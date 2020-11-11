package edu.ustb.sei.mde.query.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import edu.ustb.sei.mde.query.structure.Tuple2;

public class GraphPattern<CLASSIFIER,STRUCTURE> implements Pattern {
	private String name;
	
	public GraphPattern(String name) {
		this.name = name;
	}
	
	protected NodePattern<CLASSIFIER>[] nodes;
	protected Pattern[] relations;
	protected Variable[] ports;

	@Override
	public Variable[] getPorts() {
		return ports;
	}
	
	

	private Tuple2<List<Graphlet<CLASSIFIER, STRUCTURE>>,List<Pattern>> split = null;
	
	public Tuple2<List<Graphlet<CLASSIFIER, STRUCTURE>>,List<Pattern>> split() {
		if(split==null) {
			@SuppressWarnings("unchecked")
			List<EdgePattern<STRUCTURE>> edgePatterns = Arrays.stream(relations).filter(r->r instanceof EdgePattern).map(r->(EdgePattern<STRUCTURE>)r).collect(Collectors.toList());
			
			// otherRelations are relations that may not be efficiently processed
			List<Pattern> otherRelations = Arrays.stream(relations).filter(r->!(r instanceof EdgePattern)).collect(Collectors.toList());
			
			
			List<Graphlet<CLASSIFIER, STRUCTURE>> graphlets = new ArrayList<>();
			for(NodePattern<CLASSIFIER> node : nodes) {
				Graphlet<CLASSIFIER, STRUCTURE> graphlet = extractGraphLet(node,edgePatterns, otherRelations);
				graphlets.add(graphlet);
				otherRelations.removeAll(graphlet.otherRelations);
			}
			
			split = Tuple2.make(graphlets,otherRelations);
		}
		 
		return split;
	}


//	private void minimize(List<Graphlet<CLASSIFIER, STRUCTURE>> graphlets, List<EdgePattern<STRUCTURE>> edgePatterns) {
//		Model model = new Model();
//		Map<NodePattern<CLASSIFIER>, IntVar> varMap = new HashMap<>();
//		graphlets.forEach(g->{
//			varMap.put(g.mainNode, model.intVar(g.mainNode.toString(), 0, 1));
//		});
//		
//		edgePatterns.forEach(e->{
//			if(e.source==e.target) {
//				Set<IntVar> ext = new HashSet<>();
//				ext.add(varMap.get(e.source));
//				edgePatterns.forEach(ex->{
//					if(ex.source==e.source && ex.target!=e.target) {
//						ext.add(varMap.get(ex.target));
//					} else if(ex.source!=e.source && ex.target==e.target) {
//						ext.add(varMap.get(ex.source));
//					}
//				});
//				model.post(model.sum(ext.toArray(i->new IntVar[i]), ">=", 1));
//			} else {
//				Set<IntVar> ext = new HashSet<>();
//				ext.add(varMap.get(e.source));
//				ext.add(varMap.get(e.target));
//				
//				edgePatterns.forEach(ex->{
//					NodePattern<?> mid,tar;
//					if(ex.source==e.target) {
//						mid = null;
//						tar = null;
//					}
//					else if(ex.source==e.source && ex.target!=e.target) {
//						mid = ex.target;
//						tar = e.target;
//					} else if(ex.source==e.target && ex.target!=e.source) {
//						mid = ex.target;
//						tar = e.source;
//					} else if(ex.source!=e.source && ex.target==e.target) {
//						mid = ex.source;
//						tar = e.source;
//					} else if(ex.source!=e.target && ex.target==e.source) {
//						mid = ex.source;
//						tar = e.target;
//					} else {
//						mid = null;
//						tar = null;
//					}
//					if(mid!=null) {
//						edgePatterns.forEach(ey->{
//							if(ey.source==mid && ey.target==tar) {
//								ext.add(varMap.get(mid));
//							} else if(ey.target==mid && ey.source==tar) {
//								ext.add(varMap.get(mid));
//							}
//						});
//					}
//				});
//				
//				model.post(model.sum(ext.toArray(i->new IntVar[i]), ">=", 1));
//			}
//		});
//		
//		IntVar obj = model.intVar(0,varMap.size());
//		model.post(model.sum(varMap.values().toArray(i->new IntVar[i]), "=", obj));
//		Solution sol = model.getSolver().findOptimalSolution(obj, false);
//		
//		Set<NodePattern<?>> minSet = new HashSet<>();
//		for(Entry<NodePattern<CLASSIFIER>, IntVar> entry : varMap.entrySet()) {
//			if(sol.getIntVal(entry.getValue())==1) {
//				minSet.add(entry.getKey());
//			}
//		}
//		
//		for(int i=0;i<graphlets.size();) {
//			Graphlet<CLASSIFIER, STRUCTURE> g = graphlets.get(i);
//			if(!minSet.contains(g.mainNode)) {
//				int last = graphlets.size()-1;
//				if(i!=last) {
//					graphlets.set(i, graphlets.get(last));
//				}
//				graphlets.remove(last);
//			} else {
//				i++;
//			}
//		}
//	}


	@SuppressWarnings("unchecked")
	private Graphlet<CLASSIFIER, STRUCTURE> extractGraphLet(NodePattern<CLASSIFIER> main, List<EdgePattern<STRUCTURE>> edgePatterns, List<Pattern> otherRelations) {
		Graphlet<CLASSIFIER, STRUCTURE> graphlet = new Graphlet<>();

		graphlet.pattern = this;
		graphlet.mainNode = main;

		for(EdgePattern<STRUCTURE> ep : edgePatterns) {
			Variable[] ports = ep.getPorts();
			if(ports[0]==main && ports[1]!=main) {
				graphlet.neighborNodes.add((NodePattern<CLASSIFIER>) ports[1]);
				graphlet.neighborEdges.add(ep);
			} else if(ports[1]==main && ports[0]!=main) {
				graphlet.neighborNodes.add((NodePattern<CLASSIFIER>) ports[0]);
				graphlet.neighborEdges.add(ep);
			} else if(ports[1]==main && ports[0]==main) {
				graphlet.selfEdges.add(ep);
			}
		}
		
		for(EdgePattern<STRUCTURE> ep : edgePatterns) {
			Variable[] ports = ep.getPorts();
			if(ports[0]!=main && ports[1]!=main 
					&& graphlet.neighborNodes.contains(ports[0]) 
					&& graphlet.neighborNodes.contains(ports[1])) {
				graphlet.boundaryEdges.add(ep);
			}
		}
		
		Set<NodePattern<CLASSIFIER>> allNodes = new HashSet<>();
		allNodes.add(main);
		allNodes.addAll(graphlet.neighborNodes);
		
		for(Pattern pattern : otherRelations ) {
			Variable[] ports = pattern.getPorts();
			if(allNodes.containsAll(Arrays.asList(ports))) {
				graphlet.otherRelations.add(pattern);
			}
		}
		
		return graphlet;
	}


	public NodePattern<CLASSIFIER>[] getNodes() {
		return nodes;
	}


	public void setNodes(NodePattern<CLASSIFIER>[] nodes) {
		this.nodes = nodes;
	}


	public Pattern[] getRelations() {
		return relations;
	}


	public void setRelations(Pattern[] relations) {
		this.relations = relations;
	}


	public void setPorts(Variable[] ports) {
		this.ports = ports;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("(");
		builder.append(Arrays.stream(getPorts()).map(p->p.getName()).reduce((l,r)->l+","+r).orElse(""));
		builder.append(")\n");
		builder.append("{\n");
		builder.append("\tnodes:\n");
		Arrays.stream(nodes).forEach(n->{
			builder.append("\t\t");
			builder.append(n.toString());
			builder.append("\n");
		});
		builder.append("\trelations:\n");
		Arrays.stream(relations).forEach(n->{
			builder.append("\t\t");
			builder.append(n.toString());
			builder.append("\n");
		});
		builder.append("}");
		
		return builder.toString();
	}
}
