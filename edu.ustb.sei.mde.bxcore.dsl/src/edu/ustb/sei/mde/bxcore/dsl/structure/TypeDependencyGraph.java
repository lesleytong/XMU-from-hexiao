package edu.ustb.sei.mde.bxcore.dsl.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandSource;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreFork;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreForkBranch;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreGraphReplace;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreMatchSource;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreMatchView;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreParallelComposition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitch;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitchBranch;
import edu.ustb.sei.mde.bxcore.dsl.structure.TypeDependency.DependencySort;
import edu.ustb.sei.mde.structure.Tuple2;

public class TypeDependencyGraph {

	public TypeDependencyGraph() {
		types = new ArrayList<>();
	}
	
	List<Type> types;

	public Type addType(Object ref) {
		Type t = new Type();
		t.referredObject = ref;
		types.add(t);
		return t;
	}
	
	public Type getType(Object ref) {
		for(Type t : types) {
			if(t.referredObject==ref) return t;
		}
		return null;
	}
	
	public Type getOrAddType(Object ref) {
		Type t  = getType(ref);
		if(t==null) {
			t = addType(ref);
		}
		return t;
	}
	
	public void addEqualDependency(Object from, Object to) {
		Type f = getOrAddType(from);
		Type t = getOrAddType(to);
		
		TypeDependency d = new TypeDependency();
		d.from = f;
		d.to = t;
		d.dependencySort = DependencySort.equal;
		
		f.outgoings.add(d);
		t.incomings.add(d);
	}
	
	public void addSubtypeDependency(Object from, Object to) {
		Type f = getOrAddType(from);
		Type t = getOrAddType(to);
		
		TypeDependency d = new TypeDependency();
		d.from = f;
		d.to = t;
		d.dependencySort = DependencySort.subtype;
		
		f.outgoings.add(d);
		t.incomings.add(d);
	}
	
	public void addMappingDependency(Object from, Object to, List<VarMapping> mappings) {
		Type f = getOrAddType(from);
		Type t = getOrAddType(to);
		
		TypeDependency d = new TypeDependency();
		d.from = f;
		d.to = t;
		d.dependencySort = DependencySort.fullMapping;
		d.mappings = mappings;
		
		f.outgoings.add(d);
		t.incomings.add(d);
	}
	
	
	class TypeInformation {
		Map<Type, Set<Type>> equalTypes = new HashMap<>(); 
		Map<Type,Set<Type>> superTypes = new HashMap<>();
		Map<Type,Set<Type>> subTypes = new HashMap<>();
		Map<Type, Set<Tuple2<Type, TypeDependency>>> mappingTypes = new HashMap<>();
		
		Set<Type> definedTypes = new HashSet<>();
		Set<Set<Type>> undefinedTypes = new HashSet<>();
		
		
		void makeEqual(Type a, Type b) {
			Set<Type> ea = equalTypes.get(a);
			Set<Type> eb = equalTypes.get(b);
			eb.forEach(e->equalTypes.put(e, ea));
			ea.addAll(eb);
		}
	}
	
	public TypeInformation collectTypeInformation() {
		TypeInformation info = new TypeInformation();
		
		this.types.forEach(t->{
			Set<Type> s = new HashSet<>();
			s.add(t);
			info.equalTypes.put(t, s);
			
			info.superTypes.put(t, new HashSet<>());
			info.subTypes.put(t, new HashSet<>());
			info.mappingTypes.put(t, new HashSet<>());
		});
		
		for(int i=0;i<this.types.size();i++) {
			Type ti = this.types.get(i);
			Set<Type> si = info.equalTypes.get(ti);
			for(int j=i+1;j<this.types.size();j++) {
				Type tj = this.types.get(j);
				Set<Type> sj = info.equalTypes.get(tj);
				
				if(si==sj) continue;
				else {
					if(ti.isExplicitEqualTo(tj)) {
						sj.forEach(ej->{
							info.equalTypes.put(ej, si);
							si.add(ej);
						});
					}
				}
			}
		}
		
		for(int i=0;i<this.types.size();i++) {
			Type ti = this.types.get(i);
			Set<Type> si = info.subTypes.get(ti);
			Set<Tuple2<Type, TypeDependency>> mi = info.mappingTypes.get(ti);
			for(int j=0;j<this.types.size();j++) {
				if(i==j) continue;
				Type tj = this.types.get(j);
				Set<Type> sj = info.superTypes.get(tj);
				Set<Tuple2<Type, TypeDependency>> mj = info.mappingTypes.get(tj);
				
				if(ti.isExplicitSuperTypeOf(tj)) {
					si.add(tj);
					sj.add(ti);
				} else  {
					TypeDependency d=ti.getMappingTo(tj);
					if(d!=null) {
						mi.add(Tuple2.make(tj, d));
						mj.add(Tuple2.make(ti, d));
					}
				}
			}
		}
		
		info.equalTypes.values().forEach(es->{
			if(es.stream().anyMatch(t->t.isExplicit())) {
				info.definedTypes.addAll(es);
			} else {
				info.undefinedTypes.add(es);
			}
		});
		
		return info;
	}
	
	public void infer(TypeInformation info) {
		Set<Set<Type>> removed = new HashSet<>();
		
		int undefined = 0;
		
		do {
			undefined = info.undefinedTypes.size();
			// 1. use mapping information
			do {
				info.undefinedTypes.removeAll(removed);
				removed.forEach(es -> info.definedTypes.addAll(es));
				removed.clear();
				for (Set<Type> es : info.undefinedTypes) {
					if (es.stream().anyMatch(t -> {
						return info.mappingTypes.get(t).stream().filter(tuple -> tuple.second.from == t)
								.allMatch(s -> info.definedTypes.contains(s.first));
					})) {
						removed.add(es);
					}
				}
			} while (!removed.isEmpty());

			// 2. use subtype/supertype
			do {
				info.undefinedTypes.removeAll(removed);
				removed.forEach(es -> info.definedTypes.addAll(es));
				removed.clear();
				for (Set<Type> es : info.undefinedTypes) {
					for (Type t : es) {
						Set<Type> sups = info.superTypes.get(t);
						Set<Type> subs = info.subTypes.get(t);
						for (Type sp : sups) {
							Set<Type> esp = info.equalTypes.get(sp);
							for (Type sb : subs) {
								Set<Type> esb = info.equalTypes.get(sb);
								if (esp == esb) { // sp = sb => sp=sb=t
									info.makeEqual(sp, t);
									removed.add(es);
								}
							}
						}
					}
				}
			} while (!removed.isEmpty());

			// 3. align with super
			do {
				info.undefinedTypes.removeAll(removed);
				removed.forEach(es -> info.definedTypes.addAll(es));
				removed.clear();
				for (Set<Type> es : info.undefinedTypes) {
					Outer: for (Type t : es) {
						Set<Type> sups = info.superTypes.get(t);
						for (Type sp : sups) {
							if (info.definedTypes.contains(sp)) {
								info.makeEqual(sp, t);
								removed.add(es);
								break Outer;
							}
						}
					}
				}
			} while (!removed.isEmpty());

			// 3. align with sub
			do {
				info.undefinedTypes.removeAll(removed);
				removed.forEach(es -> info.definedTypes.addAll(es));
				removed.clear();
				for (Set<Type> es : info.undefinedTypes) {
					Outer: for (Type t : es) {
						Set<Type> subs = info.subTypes.get(t);
						for (Type sb : subs) {
							if (info.definedTypes.contains(sb)) {
								info.makeEqual(sb, t);
								removed.add(es);
								break Outer;
							}
						}
					}
				}
			} while (!removed.isEmpty());
		} while (undefined != info.undefinedTypes.size());
		
		
	}
	
	
	
	
	static public TypeDependencyGraph constructSource(BXFunctionDefinition element) {
		TypeDependencyGraph graph = new TypeDependencyGraph();
		Type bx = graph.getOrAddType(element);
		Type st = graph.getOrAddType(element.getStatement());
		graph.addEqualDependency(bx, st);
		constructSource(element.getStatement(), graph);
		return graph;
	}
	
	static public TypeDependencyGraph constructView(BXFunctionDefinition element) {
		TypeDependencyGraph graph = new TypeDependencyGraph();
		Type bx = graph.getOrAddType(element);
		Type st = graph.getOrAddType(element.getStatement());
		graph.addEqualDependency(bx, st);
		constructView(element.getStatement(), graph);
		return graph;
	}
	
	static public void constructSource(XmuCoreStatement element, TypeDependencyGraph graph) {
		if(element instanceof XmuCoreMatchSource) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreMatchSource) element).getPattern());
			Type bt = graph.getOrAddType(((XmuCoreMatchSource) element).getBody());
			graph.addSubtypeDependency(st, pt);
			graph.addEqualDependency(pt, bt);

			constructSource(((XmuCoreMatchView) element).getBody(), graph);
		} else if(element instanceof XmuCoreMatchView) {
			Type st = graph.getOrAddType(element);
			Type bt = graph.getOrAddType(((XmuCoreMatchView) element).getBody());
			graph.addEqualDependency(st, bt);
			
			constructSource(((XmuCoreMatchView) element).getBody(), graph);
		} else if(element instanceof XmuCoreExpandSource) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreExpandSource) element).getPattern());
			Type bt = graph.getOrAddType(((XmuCoreExpandSource) element).getBody());
			graph.addEqualDependency(st, pt);
			
			// pt is subtype of vt and vt fullMapping bt
			graph.addMappingDependency(pt, bt, ((XmuCoreExpandSource) element).getMappings());
			
			constructSource(((XmuCoreExpandSource) element).getBody(), graph);
		} else if(element instanceof XmuCoreExpandView) {
			Type st = graph.getOrAddType(element);
			Type bt = graph.getOrAddType(((XmuCoreExpandView) element).getBody());
			graph.addEqualDependency(st, bt);
			
			constructSource(((XmuCoreExpandView) element).getBody(), graph);
		} else if(element instanceof XmuCoreGraphReplace) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreGraphReplace) element).getSource());
			graph.addEqualDependency(st, pt);
		} else if(element instanceof XmuCoreParallelComposition) {
			Type st = graph.getOrAddType(element);
			for(XmuCoreStatement f : ((XmuCoreParallelComposition) element).getBodies()) {
				Type ft = graph.getOrAddType(f);
				
				// st fullMapping to all ft
				graph.addSubtypeDependency(st, ft);

				constructSource(f, graph);
			}
		} else if(element instanceof XmuCoreFork) {
			Type st = graph.getOrAddType(element);
			for(XmuCoreForkBranch f : ((XmuCoreFork) element).getForks()) {
				Type ft = graph.getOrAddType(f.getBody());
				
				// st is subtype of vt and vt fullMapping to ft
				graph.addMappingDependency(st, ft, f.getSourceMappings());
				
				constructSource(f.getBody(), graph);
			}
		} else if(element instanceof XmuCoreSwitch) {
			Type st = graph.getOrAddType(element);
			for(XmuCoreSwitchBranch f : ((XmuCoreSwitch) element).getBranches()) {
				Type ft = graph.getOrAddType(f.getAction());
				graph.addEqualDependency(st, ft);
				
				constructSource(f.getAction(), graph);
			}
		} else if(element instanceof XmuCoreAlign) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreAlign) element).getSourcePattern());
			Type bt = graph.getOrAddType(((XmuCoreAlign) element).getMatch());
			graph.addSubtypeDependency(st, pt);
			graph.addEqualDependency(pt, bt);
			
			constructSource(((XmuCoreAlign) element).getMatch(), graph);
		} else 
			throw new RuntimeException("unknown type "+element.eClass());
	}
	
	static public void constructView(XmuCoreStatement element, TypeDependencyGraph graph) {
		if(element instanceof XmuCoreMatchView) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreMatchView) element).getPattern());
			Type bt = graph.getOrAddType(((XmuCoreMatchView) element).getBody());
			graph.addSubtypeDependency(st, pt);
			graph.addEqualDependency(pt, bt);

			constructView(((XmuCoreMatchView) element).getBody(), graph);
		} else if(element instanceof XmuCoreMatchSource) {
			Type st = graph.getOrAddType(element);
			Type bt = graph.getOrAddType(((XmuCoreMatchSource) element).getBody());
			graph.addEqualDependency(st, bt);
			
			constructView(((XmuCoreMatchSource) element).getBody(), graph);
		} else if(element instanceof XmuCoreExpandView) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreExpandView) element).getPattern());
			Type bt = graph.getOrAddType(((XmuCoreExpandView) element).getBody());
			graph.addEqualDependency(st, pt);
			graph.addMappingDependency(pt, bt, ((XmuCoreExpandView) element).getMappings());
			
			constructView(((XmuCoreExpandView) element).getBody(), graph);
		} else if(element instanceof XmuCoreExpandSource) {
			Type st = graph.getOrAddType(element);
			Type bt = graph.getOrAddType(((XmuCoreExpandSource) element).getBody());
			graph.addEqualDependency(st, bt);
			
			constructView(((XmuCoreExpandSource) element).getBody(), graph);
		} else if(element instanceof XmuCoreGraphReplace) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreGraphReplace) element).getView());
			graph.addEqualDependency(st, pt);
		} else if(element instanceof XmuCoreParallelComposition) {
			Type st = graph.getOrAddType(element);
			for(XmuCoreStatement f : ((XmuCoreParallelComposition) element).getBodies()) {
				Type ft = graph.getOrAddType(f);
				graph.addSubtypeDependency(st, ft);

				constructView(f, graph);
			}
		} else if(element instanceof XmuCoreFork) {
			Type st = graph.getOrAddType(element);
			for(XmuCoreForkBranch f : ((XmuCoreFork) element).getForks()) {
				Type ft = graph.getOrAddType(f.getBody());
				graph.addMappingDependency(st, ft, f.getViewMappings());
				
				constructView(f.getBody(), graph);
			}
		} else if(element instanceof XmuCoreSwitch) {
			Type st = graph.getOrAddType(element);
			for(XmuCoreSwitchBranch f : ((XmuCoreSwitch) element).getBranches()) {
				Type ft = graph.getOrAddType(f.getAction());
				graph.addEqualDependency(st, ft);
				
				constructView(f.getAction(), graph);
			}
		} else if(element instanceof XmuCoreAlign) {
			Type st = graph.getOrAddType(element);
			Type pt = graph.getOrAddType(((XmuCoreAlign) element).getViewPattern());
			Type bt = graph.getOrAddType(((XmuCoreAlign) element).getMatch());
			graph.addSubtypeDependency(st, pt);
			graph.addEqualDependency(pt, bt);
			
			constructView(((XmuCoreAlign) element).getMatch(), graph);
		} else 
			throw new RuntimeException("unknown type "+element.eClass());
	}
}
