package edu.ustb.sei.mde.graph.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.graph.Derived;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.IGraph;
import edu.ustb.sei.mde.graph.INode;

public class TypeGraph implements IGraph {
	
	public TypeGraph() {
		nodes = new ArrayList<>();
		edges = new ArrayList<>();
	}
	
	private ArrayList<INode> nodes;
	private ArrayList<IEdge> edges;
	
	@Derived private List<TypeNode> typeNodes = null;
	@Derived 
	public List<TypeNode> getAllTypeNodes() {
		if(typeNodes==null) {
			typeNodes = new ArrayList<TypeNode>();
			nodes.forEach((n)->{if(n instanceof TypeNode) typeNodes.add((TypeNode)n);});
		}
		return typeNodes;
	}
	
	@Derived List<DataTypeNode> dataTypeNodes = null;
	@Derived 
	public List<DataTypeNode> getAllDataTypeNodes() {
		if(dataTypeNodes==null) {
			dataTypeNodes = new ArrayList<DataTypeNode>();
			nodes.forEach((n)->{if(n instanceof DataTypeNode) dataTypeNodes.add((DataTypeNode)n);});
		}
		return dataTypeNodes;
	}
	
	@Derived List<TypeEdge> typeEdges = null;
	@Derived 
	public List<TypeEdge> getAllTypeEdges() {
		if(typeEdges==null) {
			typeEdges = new ArrayList<TypeEdge>();
			edges.forEach((n)->{if(n instanceof TypeEdge) typeEdges.add((TypeEdge)n);});			
		}
		return typeEdges;
	}
	

	@Derived List<GeneralizationEdge> generalizationEdges = null;
	@Derived
	public List<GeneralizationEdge> getAllGeneralizationEdges() {
		if(generalizationEdges==null) {
			generalizationEdges = new ArrayList<GeneralizationEdge>();
			edges.forEach((n)->{if(n instanceof GeneralizationEdge) generalizationEdges.add((GeneralizationEdge)n);});
		}
		return generalizationEdges;
	}
	
	@Derived List<PropertyEdge> propertyEdges = null;
	@Derived
	public List<PropertyEdge> getAllPropertyEdges() {
		if(propertyEdges==null) {
			propertyEdges = new ArrayList<PropertyEdge>();
			edges.forEach((n)->{if(n instanceof PropertyEdge) propertyEdges.add((PropertyEdge)n);});
		}
		return propertyEdges;
	}

	@Override
	public List<INode> getNodes() {
		return nodes;
	}

	@Override
	public List<IEdge> getEdges() {
		return edges;
	}
	
	@Derived HashMap<TypeNode,List<TypeNode>> superTypeMap = new HashMap<TypeNode,List<TypeNode>>();
	@Derived
	public List<TypeNode> getAllSuperTypes(TypeNode n) {
		List<TypeNode> st = superTypeMap.get(n);
		if(st==null) {
			st = new ArrayList<TypeNode>();
			superTypeMap.put(n, st);
			List<GeneralizationEdge> elist = this.getAllGeneralizationEdges();
			for(GeneralizationEdge g : elist) {
				if(g.getSource()==n) {
					st.add(g.getTarget());
					XmuCoreUtils.addAllUnique(st, this.getAllSuperTypes(g.getTarget()));
				}
			}
		}
		
		return st;
	}
	
	public boolean isSuperTypeOf(ITypeNode child, ITypeNode parent)  {
		if(parent==TypeNode.ANY_TYPE 
				|| child==DataTypeNode.NULL_TYPE // NULL value
				|| child==TypeNode.NULL_TYPE) // NULL value 
			return true;
		else if(child==parent) 
			return true;
		else if(child instanceof TypeNode)
			return this.getAllSuperTypes((TypeNode)child).contains(parent);
		else return false;
	}
	
	@Derived HashMap<TypeNode,List<PropertyEdge>> propertyEdgeMap = new HashMap<TypeNode,List<PropertyEdge>>();
	@Derived
	public List<PropertyEdge> getAllPropertyEdges(TypeNode n) {
		List<PropertyEdge> result = propertyEdgeMap.get(n);
		if(result==null) {
			result = new ArrayList<PropertyEdge>();
			propertyEdgeMap.put(n, result);
			List<TypeNode> superTypesOfN = this.getAllSuperTypes(n);
			
			for(TypeNode s : superTypesOfN) {
				List<PropertyEdge> tt = this.getAllPropertyEdges(s);
				XmuCoreUtils.addAllUnique(result, tt);
			}
			
			List<PropertyEdge> allProperties = this.getAllPropertyEdges();
			
			for(PropertyEdge g : allProperties) {
				if(g.getSource()==n) {
					XmuCoreUtils.addUnique(result, g);
				}
			}
		}
		
		return result;
	}
	
	
	@Derived HashMap<TypeNode,List<TypeEdge>> outgoingTypeEdgeMap = new HashMap<TypeNode,List<TypeEdge>>();
	@Derived
	public List<TypeEdge> getAllOutgoingTypeEdges(TypeNode n) {
		List<TypeEdge> result = outgoingTypeEdgeMap.get(n);
		if(result==null) {
			result = new ArrayList<TypeEdge>();
			outgoingTypeEdgeMap.put(n, result);
			List<TypeNode> superTypesOfN = this.getAllSuperTypes(n);
			
			for(TypeNode s : superTypesOfN) {
				List<TypeEdge> tt = this.getAllOutgoingTypeEdges(s);
				XmuCoreUtils.addAllUnique(result, tt);
			}
			
			List<TypeEdge> allEdges = this.getAllTypeEdges();
			
			for(TypeEdge g : allEdges) {
				if(g.getSource()==n) {
					XmuCoreUtils.addUnique(result, g);
				}
			}
			
		}
		return result;
	}
	
	@Derived HashMap<TypeNode,List<TypeEdge>> incomingTypeEdgeMap = new HashMap<TypeNode,List<TypeEdge>>();
	@Derived
	public List<TypeEdge> getAllIncomingTypeEdges(TypeNode n) {
		List<TypeEdge> result = incomingTypeEdgeMap.get(n);
		if(result==null) {
			result = new ArrayList<TypeEdge>();
			incomingTypeEdgeMap.put(n, result);
			List<TypeNode> superTypesOfN = this.getAllSuperTypes(n);
			
			for(TypeNode s : superTypesOfN) {
				List<TypeEdge> tt = this.getAllIncomingTypeEdges(s);
				XmuCoreUtils.addAllUnique(result, tt);
			}
			
			List<TypeEdge> allEdges = this.getAllTypeEdges();
			
			for(TypeEdge g : allEdges) {
				if(g.getTarget()==n) {
					XmuCoreUtils.addUnique(result, g);
				}
			}
			
		}
		return result;
	}
	
	public void addNode(INode n) {
		this.nodes.add(n);
		if(n instanceof TypeNode) this.typeNodes=null;
		else this.dataTypeNodes=null;
	}
	public void addEdge(IEdge e) {
		this.edges.add(e);
		if(e instanceof TypeEdge) this.typeEdges = null;
		else if(e instanceof GeneralizationEdge) this.generalizationEdges = null;
		else this.propertyEdges = null;
	}
	
	protected void initDataTypeNodes() {
		DataTypeNode n = null;
		
		n = new DataTypeNode();
		n.setDataType("Integer", int.class);
		this.addNode(n);
		
		n = new DataTypeNode();
		n.setDataType("Boolean", boolean.class);
		this.addNode(n);
		
		n = new DataTypeNode();
		n.setDataType("String", String.class);
		this.addNode(n);
		
		n = new DataTypeNode();
		n.setDataType("Char", char.class);
		this.addNode(n);
	}
	
//	public DataTypeNode getDataType(String name) {
//		return this.getAllDataTypeNodes().stream().filter(d->d.getName().equals(name)).findAny().get();
//	}
	
	
	static public TypeNode createTypeNode(String name, boolean abs) {
		TypeNode n = new TypeNode();
		n.setName(name);
		n.setAbstract(abs);
		return n;
	}
	
	static public GeneralizationEdge createGeneralizationEdge(TypeNode parent, TypeNode child) {
		GeneralizationEdge e = new GeneralizationEdge();
		e.setSource(child);
		e.setTarget(parent);
		return e;
	}
	
	static public IStructuralFeatureEdge createFeatureEdge(String name, TypeNode source, INode target, boolean many) {
		IStructuralFeatureEdge res = null;
		
		if(target instanceof TypeNode) {
			TypeEdge e = new TypeEdge();
			e.setName(name);
			e.setSource(source);
			e.setTarget((TypeNode)target);
			e.setMany(many);
			res = e;
		}
		else {
			PropertyEdge e = new PropertyEdge();
			e.setName(name);
			e.setSource(source);
			e.setTarget((DataTypeNode)target);
			e.setMany(many);
		}
		
		return res;
	}
	
	static public DataTypeNode createDataTypeNode(String name, Class<?> javaType) {
		DataTypeNode n = new DataTypeNode();
		n.setDataType(name, javaType);
		return n;
	}

	public TypeNode getTypeNode(String string) {
		try {
			return this.getAllTypeNodes().stream().filter(t->t.getName().equals(string)).findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}

	public DataTypeNode getDataTypeNode(String string) {
		try {
			return this.getAllDataTypeNodes().stream().filter(t->t.getName().equals(string)).findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}

	public TypeEdge getTypeEdge(TypeNode typeNode, String string) {
		try {
			return this.getAllOutgoingTypeEdges(typeNode).stream().filter(e->e.getName().equals(string)).findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public PropertyEdge getPropertyEdge(TypeNode typeNode, String string) {
		try {
			return this.getAllPropertyEdges(typeNode).stream().filter(e->e.getName().equals(string)).findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public String printGraph() {
		StringBuilder builder = new StringBuilder();
		
		int i=0;
		List<TypeNode> allTypeNodes = this.getAllTypeNodes();
		for(i=0;i<allTypeNodes.size();i++) {
			TypeNode n = allTypeNodes.get(i);
			builder.append("TypeNode.");
			builder.append(i);
			builder.append(n.toString());
			builder.append("{");
			builder.append("supers:[");
			this.getAllSuperTypes(n).forEach(s->{
				builder.append("TypeNode@"+allTypeNodes.indexOf(s));
				builder.append(",");
			});
			builder.append("],");
			builder.append("properties:[");
			this.getAllPropertyEdges(n).forEach(s->{
				builder.append(s.toString());
				builder.append(",");
			});
			builder.append("],");
			builder.append("associations:[");
			this.getAllOutgoingTypeEdges(n).forEach(s->{
				builder.append(s.toString());
				builder.append(",");
			});
			builder.append("],");
			builder.append("}");
			builder.append("\n");
		}
		
		return builder.toString();
	}

	public TypeNode computeSubtype(TypeNode left, TypeNode right) {
		if(left==right) return left;
		if(isSuperTypeOf(left, right)) 
			return left;
		if(isSuperTypeOf(right, left)) 
			return right;

		// should go on
		
		return TypeNode.NULL_TYPE;
	}
	
	
	public void declare(String statement) {
		String typeNodeFormat = "\\s*(@?)(\\w+)\\s*(,\\w+)*\\s*";
		String dataNodeFormat = "\\s*(\\w+)\\s*:\\s*([\\w\\.]+)\\s*";
		String edgeFormat = "\\s*(\\w+)\\s*:\\s*(\\w+)\\s*->\\s*(\\w+)([\\*#]?)\\s*";
		
		Pattern typeNodePat = Pattern.compile(typeNodeFormat);
		Pattern dataNodePat = Pattern.compile(dataNodeFormat);
		Pattern edgePat = Pattern.compile(edgeFormat);
		
		String[] stats = statement.split(";");
		for(String stat : stats) {
			Matcher matcher = null;
			
			if((matcher=typeNodePat.matcher(stat)).matches()) {
				String abs = matcher.group(1);
				String name = matcher.group(2);
				String ext = matcher.group(3);
				
				TypeNode tn = new TypeNode();
				tn.setAbstract(abs.isEmpty()==false);
				tn.setName(name);
				
				this.addNode(tn);
				
				if(ext!=null) {
					String[] pts = ext.split(",");
					for(String p : pts) {
						if(p.isEmpty()) continue;
						TypeNode pn = this.getTypeNode(p);
						
						GeneralizationEdge ge = new GeneralizationEdge();
						ge.setSource(tn);
						ge.setTarget(pn);
						
						this.addEdge(ge);
					}
				}
			} else if((matcher=dataNodePat.matcher(stat)).matches()) {
				String name = matcher.group(1);
				String javaName = matcher.group(2);
				
				DataTypeNode dn = new DataTypeNode();
				try {
					dn.setDataType(name, Class.forName(javaName));
					this.addNode(dn);
				} catch (ClassNotFoundException e) {
					System.out.println("error name "+javaName);
				}
			} else if((matcher=edgePat.matcher(stat)).matches()) {
				String name = matcher.group(1);
				String src = matcher.group(2);
				String tar = matcher.group(3);
				String mul = matcher.group(4);
				Boolean uni = mul==null || mul.equals("*");
				
				TypeNode sn = this.getTypeNode(src);
				if(sn==null) continue;
				INode tn = this.getTypeNode(tar);
				if(tn==null) tn = this.getDataTypeNode(tar);
				if(tn==null) continue;
				
				if(tn instanceof TypeNode) {
					TypeEdge e = new TypeEdge();
					e.setName(name);
					e.setSource(sn);
					e.setTarget((TypeNode) tn);
					e.setMany(mul.isEmpty()==false);
					e.setUnique(uni);
					this.addEdge(e);
				} else if(tn instanceof DataTypeNode) {
					PropertyEdge e = new PropertyEdge();
					e.setName(name);
					e.setSource(sn);
					e.setTarget((DataTypeNode) tn);
					e.setMany(mul.isEmpty()==false);
					e.setUnique(uni);
					this.addEdge(e);
				}
			}
		}
	}
	
	
}
