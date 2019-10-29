package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.xmu.CasePatternStatement;
import edu.ustb.sei.mde.xmu.CaseSubStatement;
import edu.ustb.sei.mde.xmu.ForStatement;
import edu.ustb.sei.mde.xmu.LoopPath;
import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.Pattern;
import edu.ustb.sei.mde.xmu.PatternNode;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.Statement;
import edu.ustb.sei.mde.xmu.SwitchStatement;
import edu.ustb.sei.mde.xmu.TaggedElement;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.XMUModel;
import edu.ustb.sei.mde.xmu.XmuFactory;

public class Util {
	static public final String POST_FLAG = "@post";
	static public final int POST_LENGTH = POST_FLAG.length();
	static public final String CONSOLE = "Bidirectional Model Update";
	
	static public boolean identifierMatch(String identifier, String str) {
		if(identifier.equals(str)) return true;
		if(identifier.length()==0) return false;
		if(identifier.charAt(0)=='_') {
			if(identifier.substring(1).equals(str))
				return true;
		}
		return false;
	}
	
	static public EPackage loadPackage(String uri, Resource resource) {
		try {
			ResourceSet set = resource.getResourceSet();
			
			Map<String, URI> map = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
			for(Entry<String,URI> uriEntry : map.entrySet()) {
				if(uriEntry.getKey().indexOf(uri)!=-1) {	
					if(uri.equals(uriEntry.getKey())) {
						URI u = URI.createURI(uriEntry.getKey());
						Resource res = set.getResource(u, true);
						EObject target = res.getContents().get(0);
						return (EPackage) target;
					}
				}
			}
			
			URI u = URI.createURI(uri);
			Resource res = set.getResource(u, true);
			EObject target = res.getContents().get(0);
			return (EPackage)target;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	static public LoopPath getLoopPath(EObject o) {
		while(o!=null) {
			if(o instanceof LoopPath) break;
			else o = o.eContainer();
		}
		return (LoopPath)o;
	}
	static public Rule getRule(EObject o) {
		while(o!=null) {
			if(o instanceof Rule) break;
			else o = o.eContainer();
		}
		return (Rule) o;
	}
	
	static public <T> T getParentNodeByJavaType(EObject o, Class<T> clazz) {
		while(o!=null) {
			if(o.getClass()==clazz) break;
			else o = o.eContainer();
		}
		return (T) o;
	}
	static public <T> EObject getParentNodeByEType(EObject o, Class<T> clazz) {
		while(o!=null) {
			if(o.eClass().getClass()==clazz) break;
			else o = o.eContainer();
		}
		return o;
	}
	
	static public Pattern getPattern(EObject o) {
		while(o!=null) {
			if(o instanceof Pattern) break;
			else o = o.eContainer();
		}
		return (Pattern) o;
	}
	
	static public XMUModel getXMUModel(EObject o) {
		while(o!=null) {
			if(o instanceof XMUModel) break;
			else o = o.eContainer();
		}
		return (XMUModel) o;
	}

	
	static public EClass getEClass(String identifier, EPackage pkg) {
		TreeIterator<EObject> it = pkg.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			if(o instanceof EClass) {
				if(identifierMatch(identifier, ((EClass)o).getName()))
					return (EClass) o;
			}
		}
		return null;
	}
	
	static public EStructuralFeature getFeature(String identifier, EClass cls) {
		for(EStructuralFeature f : cls.getEAllStructuralFeatures()) {
			if(identifierMatch(identifier, f.getName()))
				return f;
		}
		return null;
	}
	
	static public EDataType getPrimitiveDataType(String identifier) {
		if("String".equals(identifier))
			return EcorePackage.eINSTANCE.getEString();
		else if("Integer".equals(identifier))
			return EcorePackage.eINSTANCE.getEIntegerObject();
		else if("Boolean".equals(identifier))
			return EcorePackage.eINSTANCE.getEBooleanObject();
		else return null;
	}
	
	static public EEnum getEnum(String identifier, EList<EPackage> packages) {
		for(EPackage pkg : packages) {
			EEnum cls = getEnum(identifier, pkg);
			if(cls !=null ) return cls;
		}
		return null;
	}
	
	static public Object getEnumLiteral(String identifier, EEnum e) {
		return XmuFactory.eINSTANCE.createFromString(e, identifier);
	}
	
	static public EEnum getEnum(String identifier, EPackage pkg) {
		TreeIterator<EObject> it = pkg.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			if(o instanceof EEnum) {
				if(identifierMatch(identifier, ((EEnum)o).getName()))
					return (EEnum) o;
			}
		}
		return null;
	}

	public static EClass getEClass(
			String identifier, EList<EPackage> packages) {
		int indexOf = identifier.indexOf("!");
		if(indexOf==-1) {
			for(EPackage pkg : packages) {
				EClass cls = getEClass(identifier, pkg);
				if(cls !=null ) return cls;
			}		
		} else {
			String[] buf = identifier.split("!");
			for(EPackage pkg : packages) {
				if(pkg.getName().equals(buf[0]))
					return getEClass(buf[1],pkg);
			}
		}
		return null;
	}
	
	public static Variable getVariable(String identifier,EList<? extends Variable> vars) {
		for(Variable v : vars) {
			if(identifierMatch(identifier, v.getName())) return v;
		}
		return null;
	}
	
	public static Statement getPatternNodeStatement(PatternNode node) {
		EObject o = node;
		
		while(o!=null) {
			if(o instanceof Statement)
				return (Statement)o;
		}
		return null;
	}
	
	public static void cleanVariable(Rule rule) {
		cleanVariable(rule, rule.getSVars(),rule.getSpVars());
		cleanVariable(rule, rule.getVVars(),null);
		//cleanVariable(rule.getSpVars());
	}
	
	public static Map<EObject, Collection<Setting>> collectReferencedVariables(Rule rule) {
		Map<EObject, Collection<Setting>> map = EcoreUtil.CrossReferencer.find(Collections.singleton(rule));
		return map;
	}
	
	public static void cleanVariable(Rule rule, EList<? extends Variable> vars,EList<? extends Variable> pvars) {
		Map<EObject, Collection<Setting>> collectReferencedVariables = collectReferencedVariables(rule);
		
		
		for(int i=vars.size()-1;i>=0;i--) {
			Variable v = vars.get(i);
			Collection<Setting> collection = collectReferencedVariables.get(v);
			if(collection==null || collection.size()==0) {
				System.out.println("remove "+v.getName());
				vars.remove(i);
				if(pvars!=null) {
					Variable pv = getVariable(v.getName()+Util.POST_FLAG,pvars);
					if(pv!=null) {
						collection = collectReferencedVariables.get(pv);
						if(collection==null || collection.size()==0)
							pvars.remove(pv);
					}
				}
			}
		}
	}
	
	public static TaggedElement getTaggedElement(EObject o) {
		if(o == null) return null;
		if(o instanceof TaggedElement) return (TaggedElement) o;
		else return getTaggedElement(o.eContainer());
	}
	
	public static PatternNode getNearestPatternNode(EObject o, ObjectVariable v) {
		if(o instanceof Rule) return null;
		
		if(o instanceof Pattern) {
			PatternNode n = searchPatternNode((Pattern) o,v);
			if(n!=null) return n;
		} else if(o instanceof SwitchStatement) {
			for(CaseSubStatement c : ((SwitchStatement) o).getCases()) {
				if(c instanceof CasePatternStatement) {
					PatternNode n = searchPatternNode(((CasePatternStatement) c).getPattern(), v);
					if(n!=null) return n;
				}
			}
		} else if(o instanceof ForStatement) {
			PatternNode n = null;
			
			n = searchPatternNode(((ForStatement) o).getSPattern(), v);
			if(n!=null)
				return n;
		}
		return getNearestPatternNode(o.eContainer(), v);
	}
	
	static private PatternNode searchPatternNode(Pattern o, ObjectVariable v) {
		TreeIterator<EObject> it = o.eAllContents();
		
		while(it.hasNext()) {
			EObject c = it.next();
			if(c instanceof PatternNode) {
				if(checkSameSource((ObjectVariable) ((PatternNode) c).getVariable(),v)) 
					return (PatternNode) c;
			}
		}
		
		return null;
	}
	
	static private boolean checkSameSource(ObjectVariable s, ObjectVariable sp) {
		if(s==sp) return true;
		
		String sname = s.getName();
		String spname = sp.getName();
		if(sname.length()+5==spname.length() && spname.startsWith(sname))
			return true;
		return false;
	}

}
