package edu.ustb.sei.mde.morel.resource.processer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.morel.AdditiveExp;
import edu.ustb.sei.mde.morel.BooleanAndExp;
import edu.ustb.sei.mde.morel.BooleanImpliesExp;
import edu.ustb.sei.mde.morel.BooleanOrExp;
import edu.ustb.sei.mde.morel.EnclosureLinkConstraint;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.MultiplicativeExp;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.PathConstraint;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
import edu.ustb.sei.mde.morel.UnaryExp;
import edu.ustb.sei.mde.morel.UnaryOperator;
import edu.ustb.sei.mde.morel.VariableExp;
import edu.ustb.sei.mde.morel.resource.morel.IMorelOptionProvider;
import edu.ustb.sei.mde.morel.resource.morel.IMorelOptions;
import edu.ustb.sei.mde.morel.resource.morel.IMorelResourcePostProcessor;
import edu.ustb.sei.mde.morel.resource.morel.IMorelResourcePostProcessorProvider;
import edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity;
import edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType;
import edu.ustb.sei.mde.morel.resource.morel.analysis.TypeResolver;
import edu.ustb.sei.mde.morel.resource.morel.mopp.MorelProblem;
import edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource;

public class MorelPostProcesser implements IMorelResourcePostProcessor,
		IMorelOptionProvider, IMorelResourcePostProcessorProvider {

	@Override
	public IMorelResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap( 
				IMorelOptions.RESOURCE_POSTPROCESSOR_PROVIDER, 
				this 
				); 
	}
	
	private boolean terminateFlag;
	
	transient private List<EReference> reachable = new ArrayList<EReference>();

	@Override
	public void process(MorelResource resource) {
		terminateFlag = false;
		List<EObject> objs = resource.getContents();
		try{
			resource.getErrors().clear();
			process(objs,resource);
		}catch(Exception e) {
			
		}
	}

	private void process(List<EObject> objs, MorelResource resource) {
		for(EObject o : objs) {
			if(terminateFlag) return;
			checkLinkConstraint(o,resource);
			EObject no = simplify(o);
			
			if(no!=o) {
				if(terminateFlag) return;
				EObject container = o.eContainer();
				EReference ref = o.eContainmentFeature();
				EcoreUtil.replace(container, ref, o, no);
			}
			if(terminateFlag) return;
			process(no.eContents(),resource);
		}
	}
	
	private void checkLinkConstraint(EObject o, MorelResource resource) {
		if(o instanceof SimpleLinkConstraint) {
			ObjectVariable source = ((LinkConstraint) o).getSource();
			ObjectVariable target = ((LinkConstraint) o).getTarget();
			
			EReference ref = ((SimpleLinkConstraint) o).getReference();
			
			if(!ref.getEContainingClass().isSuperTypeOf(source.getType())) {
				String msg = "The source type of "+ref.getName()+" is not compatible with "+source.getName();
				resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
				
			}
			if(!ref.getEReferenceType().isSuperTypeOf(target.getType())) {
				String msg = "The target type of "+ref.getName()+" is not compatible with "+target.getName();
				resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
			}
		} else if(o instanceof EnclosureLinkConstraint) {
			ObjectVariable source = ((LinkConstraint) o).getSource();
			ObjectVariable target = ((LinkConstraint) o).getTarget();
			
			List<EReference> refs = ((EnclosureLinkConstraint)o).getForward();
			List<EClass> types = ((EnclosureLinkConstraint)o).getTypes();
			
			// check reachable
			{
				boolean sourceCompatible = false;
				for(EReference r : refs){
					if(r.getEContainingClass().isSuperTypeOf(source.getType())) {
						sourceCompatible = true;
						break;
					}
					if(terminateFlag) return;
				}
				if(sourceCompatible==false) {
					String msg = "The type of "+source.getName()+" is not compatible with any references";
					resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
				}
			}
			if(terminateFlag) return;
			{
				boolean targetCompatible = false;
				for(EReference r : refs){
					if(r.getEReferenceType().isSuperTypeOf(target.getType())) {
						targetCompatible = true;
						break;
					}
					if(terminateFlag) return;
				}
				if(targetCompatible==false) {
					String msg = "The type of "+target.getName()+" is not compatible with any references";
					resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
				}
			}
			if(terminateFlag) return;
			{
				if(types.size()!=0) {
					if(types.contains(target.getType())==false) {
						String msg = "The target type "+target.getType().getName()+" must be included in the candidate type list if the list is explictly defined";
						resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
					}
					for(EClass type : types) {
						boolean typeReachable = false;
						if(terminateFlag) return;
						for(EReference r : refs) {
							if(r.getEReferenceType().isSuperTypeOf(type)) {
								typeReachable = true;
								break;
							}
							if(terminateFlag) return;
						}
						if(typeReachable==false) {
							String msg = "The type "+type.getName()+" is not reachable";
							resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
						}
					}
				}
			}
			if(terminateFlag) return;
			// check connective
			{
				int oldSize = 0;
				int curSize = 0;
				
				reachable.clear();
				for(EReference r : refs) {
					if(r.getEContainingClass().isSuperTypeOf(source.getType()))
						reachable.add(r);
				}
				if(terminateFlag) return;
				oldSize = 0;
				curSize = reachable.size();
				while(oldSize!=curSize) {
					oldSize = curSize;
					for(int i=0;i<curSize;i++) {
						EReference rs = reachable.get(i);
						for(EReference rt : refs) {
							if(terminateFlag) return;
							if(reachable.contains(rt)) continue;
							if(checkConnectiveByType(rs.getEReferenceType(),rt.getEContainingClass(),types))
								reachable.add(rt);
						}
					}
					curSize = reachable.size();
				}
				if(terminateFlag) return;
				for(EReference r : refs) {
					if(terminateFlag) return;
					if(reachable.contains(r)==false) {
						String msg = r.getName() +" is not reachable from source";
						resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
					}
				}
				
				if(terminateFlag) return;
				// target
				reachable.clear();
				for(EReference r : refs) {
					if(r.getEReferenceType().isSuperTypeOf(target.getType()))
						reachable.add(r);
				}
				if(terminateFlag) return;
				oldSize = 0;
				curSize = reachable.size();
				while(oldSize!=curSize) {
					oldSize = curSize;
					for(int i=0;i<curSize;i++) {
						EReference rt = reachable.get(i);
						for(EReference rs : refs) {
							if(terminateFlag) return;
							if(reachable.contains(rs)) continue;
							if(checkConnectiveByType(rs.getEReferenceType(),rt.getEContainingClass(),types))
								reachable.add(rs);
						}
					}
					curSize = reachable.size();
				}
				if(terminateFlag) return;
				for(EReference r : refs) {
					if(reachable.contains(r)==false) {
						String msg = r.getName() +" cannot reach target";
						resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
					}
				}
			}
		} else if(o instanceof PathConstraint) {
			ObjectVariable source = ((LinkConstraint) o).getSource();
			ObjectVariable target = ((LinkConstraint) o).getTarget();
			
			List<EReference> refs = ((PathConstraint)o).getReferences();
			List<EClass> types = ((PathConstraint)o).getTypes();
			
			// check reachable
			{
				boolean sourceCompatible = false;
				for(EReference r : refs){
					if(r.getEContainingClass().isSuperTypeOf(source.getType())) {
						sourceCompatible = true;
						break;
					}
					if(terminateFlag) return;
				}
				if(sourceCompatible==false) {
					String msg = "The type of "+source.getName()+" is not compatible with any references";
					resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
				}
			}
			if(terminateFlag) return;
			{
				boolean targetCompatible = false;
				for(EReference r : refs){
					if(r.getEReferenceType().isSuperTypeOf(target.getType())) {
						targetCompatible = true;
						break;
					}
					if(terminateFlag) return;
				}
				if(targetCompatible==false) {
					String msg = "The type of "+target.getName()+" is not compatible with any references";
					resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
				}
			}
			if(terminateFlag) return;
			{
				if(types.size()!=0) {
					if(types.contains(target.getType())==false) {
						String msg = "The target type "+target.getType().getName()+" must be included in the candidate type list if the list is explictly defined";
						resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
					}
					for(EClass type : types) {
						boolean typeReachable = false;
						if(terminateFlag) return;
						for(EReference r : refs) {
							if(r.getEReferenceType().isSuperTypeOf(type)) {
								typeReachable = true;
								break;
							}
							if(terminateFlag) return;
						}
						if(typeReachable==false) {
							String msg = "The type "+type.getName()+" is not reachable";
							resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
						}
					}
				}
			}
			if(terminateFlag) return;
			// check connective
			{
				int oldSize = 0;
				int curSize = 0;
				
				reachable.clear();
				for(EReference r : refs) {
					if(r.getEContainingClass().isSuperTypeOf(source.getType()))
						reachable.add(r);
				}
				if(terminateFlag) return;
				oldSize = 0;
				curSize = reachable.size();
				while(oldSize!=curSize) {
					oldSize = curSize;
					for(int i=0;i<curSize;i++) {
						EReference rs = reachable.get(i);
						for(EReference rt : refs) {
							if(terminateFlag) return;
							if(reachable.contains(rt)) continue;
							if(checkConnectiveByType(rs.getEReferenceType(),rt.getEContainingClass(),types))
								reachable.add(rt);
						}
					}
					curSize = reachable.size();
				}
				if(terminateFlag) return;
				for(EReference r : refs) {
					if(terminateFlag) return;
					if(reachable.contains(r)==false) {
						String msg = r.getName() +" is not reachable from source";
						resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
					}
				}
				
				if(terminateFlag) return;
				// target
				reachable.clear();
				for(EReference r : refs) {
					if(r.getEReferenceType().isSuperTypeOf(target.getType()))
						reachable.add(r);
				}
				if(terminateFlag) return;
				oldSize = 0;
				curSize = reachable.size();
				while(oldSize!=curSize) {
					oldSize = curSize;
					for(int i=0;i<curSize;i++) {
						EReference rt = reachable.get(i);
						for(EReference rs : refs) {
							if(terminateFlag) return;
							if(reachable.contains(rs)) continue;
							if(checkConnectiveByType(rs.getEReferenceType(),rt.getEContainingClass(),types))
								reachable.add(rs);
						}
					}
					curSize = reachable.size();
				}
				if(terminateFlag) return;
				for(EReference r : refs) {
					if(reachable.contains(r)==false) {
						String msg = r.getName() +" cannot reach target";
						resource.addError(msg, MorelEProblemType.ANALYSIS_PROBLEM, o);
					}
				}
			}
		}
	}

	private boolean checkConnectiveByType(EClass st,
			EClass tt, List<EClass> types) {
		// TODO Auto-generated method stub
		if(st.isSuperTypeOf(tt)) return true;
		else {
			for(EClass t : types) {
				if(st.isSuperTypeOf(t) && tt.isSuperTypeOf(t))
					return true;
			}
		}
		return false;
	}

	protected EObject simplify(EObject o) {
		if(o instanceof BooleanImpliesExp) {
			if(((BooleanImpliesExp) o).getRight()==null) {
				return simplify(((BooleanImpliesExp) o).getLeft());
			}
		} else if(o instanceof BooleanOrExp) {
			if(((BooleanOrExp) o).getChildren().size()==1) {
				return simplify(((BooleanOrExp) o).getChildren().get(0));
			}
		} else if(o instanceof BooleanAndExp) {
			if(((BooleanAndExp) o).getChildren().size()==1) {
				return simplify(((BooleanAndExp) o).getChildren().get(0));
			}
		} else if(o instanceof RelationalExp) {
			if(((RelationalExp) o).getRight()==null) {
				return simplify(((RelationalExp) o).getLeft());
			}
		} else if(o instanceof AdditiveExp) {
			if(((AdditiveExp) o).getChildren().size()==1) {
				return simplify(((AdditiveExp) o).getChildren().get(0));
			}
		} else if(o instanceof MultiplicativeExp) {
			if(((MultiplicativeExp) o).getChildren().size()==1) {
				return simplify(((MultiplicativeExp) o).getChildren().get(0));
			}
		} else if(o instanceof UnaryExp) {
			if(((UnaryExp) o).getOperator()==UnaryOperator.PLUS) {
				return simplify(((UnaryExp) o).getChild());
			}
		}
		
		return o;
	}

	@Override
	public void terminate() {
		terminateFlag = true;
	}

}
