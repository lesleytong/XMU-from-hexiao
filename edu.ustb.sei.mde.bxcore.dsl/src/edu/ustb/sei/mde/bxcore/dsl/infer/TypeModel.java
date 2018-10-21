package edu.ustb.sei.mde.bxcore.dsl.infer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.SetVar;
import org.chocosolver.util.objects.setDataStructures.ISetIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DefinedContextTypeRef;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinitionReference;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.structure.Tuple2;

public abstract class TypeModel {
	protected Set<TupleType> types;
	protected List<TypeConstraint> constraints;
	
	private List<String> nameList;
	private Map<TupleType, SetVar> typeVarMap;
	
	// could be shared
	private BXProgram program;
	protected List<Object> typeList;
	protected boolean[][] superTypeTable;
	
	
	// derived from input
	public Map<XmuCoreStatement, TupleType> unsolvedTupleTypeMap;
	
	// input
	public Map<TypeLiteral, Tuple2<TupleType, Integer>> literalMap;
	
	
	public TypeModel(BXProgram program, Map<TypeLiteral, Tuple2<TupleType, Integer>> literalMap) {
		this.program = program;
		this.literalMap = literalMap;
		this.types = new HashSet<>();
		this.constraints = new ArrayList<>();
		this.unsolvedTupleTypeMap = new HashMap<>();

		extractConstraint(program);
	}
	
	protected void extractConstraint(BXProgram program) {
		program.eAllContents().forEachRemaining(e->{
			if(e instanceof XmuCoreStatement) {
				UnsolvedTupleType st = new UnsolvedTupleType();
				unsolvedTupleTypeMap.put((XmuCoreStatement)e, st);
			}
		});
		
		literalMap.values().forEach(v->types.add(v.first));
		unsolvedTupleTypeMap.values().forEach(v->types.add(v));
		
		program.eAllContents().forEachRemaining(e->{
			if(e instanceof XmuCoreStatement) {
				extractConstraint((XmuCoreStatement)e);
			}
		});
	}

	protected abstract void extractConstraint(XmuCoreStatement e);

	public TupleType getType(EObject o) {
		if(o instanceof XmuCoreStatement) return unsolvedTupleTypeMap.get(o);
		else if(o instanceof BXFunctionDefinition) return unsolvedTupleTypeMap.get(((BXFunctionDefinition) o).getStatement());
		else if(o instanceof TypeLiteral) return literalMap.get(o).first;
		else if(o instanceof DefinedContextTypeRef) return literalMap.get(((DefinedContextTypeRef) o).getType().getLiteral()).first;
		else if(o instanceof TypeDefinition) return literalMap.get(((TypeDefinition) o).getLiteral()).first;
		else if(o instanceof PatternDefinitionReference) return literalMap.get(((PatternDefinitionReference) o).getPattern().getLiteral()).first;
		else return null;
	}
	
	public void solveNames() {
		Model model = new Model("name infer");
		Set<String> names = new HashSet<>();
		types.forEach(t->{t.tuples.stream().map(k->k.first).forEach(n->names.add(n));});
		nameList = new ArrayList<>(names);
		
		int[] min = new int[0];
		int[] max = new int[nameList.size()];
		for(int i=0;i<max.length;i++) max[i] = i;
		
		
		typeVarMap = new HashMap<>();
		types.forEach(t->{
			if(t instanceof UnsolvedTupleType) {
				SetVar var = model.setVar(min, max);
				typeVarMap.put(t, var);
			} else {
				int[] vals = new int[t.tuples.size()];
				for(int i=0;i<vals.length;i++) vals[i] = nameList.indexOf(t.tuples.get(i).first);
				SetVar var = model.setVar(vals);
				typeVarMap.put(t, var);
			}
		});
		
		constraints.forEach(c->{
			if(c instanceof TypeEqual) {
				SetVar left = typeVarMap.get(((TypeEqual) c).left);
				SetVar right = typeVarMap.get(((TypeEqual) c).right);
				
				if(left==null || right==null) throw new RuntimeException();
				
				if(((TypeEqual) c).mappings!=null) {
					List<Tuple2<Integer,Integer>> idMaps = ((TypeEqual) c).mappings.stream().map(m->{
						return Tuple2.make(nameList.indexOf(m.getFrom()), nameList.indexOf(m.getTo()));
					}).collect(Collectors.toList());
					Constraint cons = new Constraint(model.generateName(), new PropSetMapping(left, right, idMaps));
					model.post(cons);
				} else model.allEqual(left,right).post();
			} else if(c instanceof TypeUnion) {
				SetVar union = typeVarMap.get(((TypeUnion)c).unionType);
				SetVar[] elements = ((TypeUnion) c).types.stream().map(t->typeVarMap.get(t)).toArray(i->new SetVar[i]);
				if(union==null) throw new RuntimeException();
				for(int i=0;i<elements.length;i++) {
					if(elements[i]==null)
						throw new RuntimeException();
				}
				model.union(elements, union).post();
			}
		});
		
		if(model.getSolver().solve()) {
			types.forEach(t->{
				if(t instanceof UnsolvedTupleType) {
					SetVar s = typeVarMap.get(t);
					ISetIterator iter = s.getValue().iterator();
					while(iter.hasNext()) {
						int v = iter.nextInt();
						String key = nameList.get(v);
						((UnsolvedTupleType) t).candidates.add(Tuple2.make(key, null));
					}
				}
			});
		} else 
			throw new RuntimeException();
	}
	
	static protected Tuple2<List<Object>, boolean[][]> buildTypeTable(BXProgram program) {
		List<Object> typeList = new ArrayList<>();
		boolean[][] superTypeTable = null;
		
		Set<Object> typeSet = new HashSet<>();
		program.getImports().forEach(sec->{
			sec.getMetamodel().eAllContents().forEachRemaining(e->{
				if(e instanceof EClassifier) typeSet.add(e);
				else if(e instanceof EStructuralFeature) {
					typeSet.add(e);
					typeSet.add(((EStructuralFeature) e).getEType());
				}
			});
		});
		typeList.addAll(typeSet);
		superTypeTable = new boolean[typeList.size()][];
		
		for(int i=0;i<typeList.size();i++) {
			superTypeTable[i] = new boolean[typeList.size()];
			boolean[] tableForI = superTypeTable[i];
			Object typeI = typeList.get(i);
			
			if(typeI instanceof EStructuralFeature || typeI instanceof EDataType) {
				for(int j=0;j<typeList.size();j++) {
					tableForI[j] = (i==j);
				}			
			} else {
				for(int j=0;j<typeList.size();j++) {
					Object typeJ = typeList.get(j);
					if(typeI==typeJ) tableForI[j] = true;
					else if(typeJ instanceof EStructuralFeature || typeJ instanceof EDataType) tableForI[j] = false;
					else tableForI[j] = ((EClass)typeI).isSuperTypeOf((EClass)typeJ);
				}
			}
		}
		return Tuple2.make(typeList, superTypeTable);
	}
	
	public void solveTypes() {
		if(this.typeList==null || this.superTypeTable ==null) {
			Tuple2<List<Object>, boolean[][]> t2 = buildTypeTable(this.program);
			this.typeList = t2.first;
			this.superTypeTable = t2.second;
		}
		
		Map<TupleType, Map<String, IntVar>> varMap = new HashMap<>();
		
		// build intVar
		Model model = new Model("type infer");
		types.forEach(t->{
			if(t instanceof UnsolvedTupleType) {
				Map<String, IntVar> map = new HashMap<>();
				varMap.put(t, map);
				((UnsolvedTupleType) t).candidates.forEach(s->{
					map.put(s.first, model.intVar(0, this.typeList.size()-1));
				});
			} else {
				Map<String, IntVar> map = new HashMap<>();
				varMap.put(t, map);
				t.tuples.forEach(s->{
					map.put(s.first, model.intVar(this.typeList.indexOf(s.second)));
				});
			}
		});
		
		// build constraint
		constraints.forEach(cons->{
			if(cons instanceof TypeEqual) {
				TupleType left = ((TypeEqual) cons).left;
				TupleType right = ((TypeEqual) cons).right;
				Map<String,IntVar> lv = varMap.get(left);
				Map<String,IntVar> rv = varMap.get(right);
				
				Stream<String> keys;
				if(left instanceof UnsolvedTupleType) keys = ((UnsolvedTupleType) left).candidates.stream().map(s->s.first);
				else keys = left.tuples.stream().map(s->s.first);
				
				keys.forEach(sk->{
					String vk = null;
					if (((TypeEqual) cons).mappings != null) {
						vk = ((TypeEqual) cons).mappings.stream().filter(m->m.getFrom()==sk).findFirst().get().getTo();
					} else {
						vk = sk;
					}
					
					IntVar liv = lv.get(sk);
					IntVar riv = rv.get(vk);
					
					Constraint c = new Constraint(model.generateName(), new PropTypeCast(liv, riv, typeList, superTypeTable, ((TypeEqual) cons).sort));
					model.post(c);
				});
			} else if(cons instanceof TypeUnion) {
				TupleType left = ((TypeUnion) cons).unionType;
				Map<String,IntVar> lv = varMap.get(left);
				for(TupleType right : ((TypeUnion) cons).types) {
					Map<String,IntVar> rv = varMap.get(right);
					Stream<String> keys;
					if(right instanceof UnsolvedTupleType) keys = ((UnsolvedTupleType) right).candidates.stream().map(s->s.first);
					else keys = right.tuples.stream().map(s->s.first);
					
					keys.forEach(vk->{
						IntVar liv = lv.get(vk);
						IntVar riv = rv.get(vk);
						Constraint c = new Constraint(model.generateName(), new PropTypeCast(liv, riv, typeList, superTypeTable, TypeEqual.LEFT_ABSTRACT));
						model.post(c);
					});
				}
			}
		});
		
		if(model.getSolver().solve()) {
			types.forEach(t->{
				if(t instanceof UnsolvedTupleType) {
					Map<String, IntVar> map = varMap.get(t);
					((UnsolvedTupleType) t).candidates.forEach(tp->{
						IntVar var = map.get(tp.first);
						Object type = this.typeList.get(var.getValue());
						t.tuples.add(Tuple2.make(tp.first, type));
					});
				}
			});
			
		} else throw new RuntimeException();
	}
	
	static public Tuple2<SourceTypeModel, ViewTypeModel> buildTypeInfers(BXProgram program, Map<TypeLiteral, Tuple2<TupleType, Integer>> literalMap) {
		Tuple2<List<Object>, boolean[][]> t2 = buildTypeTable(program);
		
		SourceTypeModel stm = new SourceTypeModel(program, literalMap);
		stm.typeList = t2.first;
		stm.superTypeTable = t2.second;
		
		ViewTypeModel vtm = new ViewTypeModel(program, literalMap);
		vtm.typeList = t2.first;
		vtm.superTypeTable = t2.second;
		
		return Tuple2.make(stm, vtm);
	}
}
