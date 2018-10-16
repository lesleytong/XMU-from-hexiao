package edu.ustb.sei.mde.bxcore.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.graph.typedGraph.ValueNode;

public class EcoreModelUtil {

	public EcoreModelUtil() {
		
	}
	
	static public TypeGraph load(EPackage pack) {
		TypeGraph graph = new TypeGraph();
		
		Set<EClass> eclasses = new HashSet<>();
		Set<EDataType> edatatypes = new HashSet<>();
		Set<EReference> ereferences = new HashSet<>();
		Set<EAttribute> eattributes = new HashSet<>();

		pack.eAllContents().forEachRemaining(o->{
			if(o instanceof EClass) eclasses.add((EClass)o);
			else if(o instanceof EReference) {
				eclasses.add(((EReference)o).getEReferenceType());
				ereferences.add((EReference) o);
			}
			else if(o instanceof EDataType) edatatypes.add((EDataType)o);
			else if(o instanceof EAttribute) {
				edatatypes.add(((EAttribute)o).getEAttributeType());
				eattributes.add((EAttribute)o);
			}
		});
		
		List<EClass> orderedClasses = new ArrayList<>();
		eclasses.forEach(c->insertInOrder(eclasses, c, orderedClasses));
		
		orderedClasses.forEach(c->{
			String code = c.isAbstract()?"@":"";
			code = code+c.getName();
			for(EClass s : c.getESuperTypes()) {
				code += (","+s.getName());
			}
			graph.declare(code);
		});
		
		edatatypes.forEach(d->{
			String code = d.getName() + ":";
			if(d instanceof EEnum) {
				code += "java.lang.String";
			} else {
				code += d.getInstanceClass().getCanonicalName();
			}
			graph.declare(code);
		});
		
		ereferences.forEach(r->{
			String code = r.getName()+":"+((EClass)r.eContainer()).getName()+"->"+r.getEReferenceType().getName();
			if(r.isMany()) {
				if(r.isUnique()) code += "*";
				else code += "#";
			}
			graph.declare(code);
		});
		
		eattributes.forEach(a->{
			String code = a.getName()+":"+((EClass)a.eContainer()).getName()+"->"+a.getEAttributeType().getName();
			if(a.isUnique()) code += "*";
			else code += "#";
			graph.declare(code);
		});
		
		return graph;
	}
	
	static private void insertInOrder(Set<EClass> eclasses, EClass c, List<EClass> orderedClasses) {
		if(orderedClasses.contains(c)) return;
		else {
			if(!eclasses.contains(c)) {
				c.getESuperTypes().forEach(s->insertInOrder(eclasses, s, orderedClasses));
				orderedClasses.add(c);
			}
		}
	}

	static public TypedGraph load(EObject root, TypeGraph typeGraph) {
		Map<EObject, TypedNode> nodeMap = new HashMap<>();
		TypedGraph graph = new TypedGraph(typeGraph);
		addTypedNode(root, typeGraph, nodeMap, graph);
		root.eAllContents().forEachRemaining(o->addTypedNode(o, typeGraph, nodeMap, graph));
		addTypedEdges(root, typeGraph, nodeMap, graph);
		return graph;
	}
	
	static public Collection<EObject> save(TypedGraph graph, EPackage pack) {
		Map<TypedNode, EObject> nodeMap = new HashMap<>();
		
		Map<String, EClass> eclasses = new HashMap<>();
		Map<String, EDataType> edatatypes = new HashMap<>();

		pack.eAllContents().forEachRemaining(o->{
			if(o instanceof EClass) eclasses.put(((EClass)o).getName(), (EClass)o);
			else if(o instanceof EReference) {
				eclasses.put(((EReference)o).getEReferenceType().getName(),((EReference)o).getEReferenceType());
			}
			else if(o instanceof EDataType) edatatypes.put(((EDataType)o).getName(), (EDataType)o);
			else if(o instanceof EAttribute) {
				edatatypes.put(((EAttribute)o).getEAttributeType().getName(), ((EAttribute)o).getEAttributeType());
			}
		});
		
		graph.getAllTypedNodes().forEach(n->{
			EClass tc = eclasses.get(n.getType().getName());
			EObject obj = EcoreUtil.create(tc);
			nodeMap.put(n, obj);
			
			tc.getEAllAttributes().forEach(a->{
				PropertyEdge edge = graph.getTypeGraph().getPropertyEdge(n.getType(), a.getName());
				
				if(a.isMany()) {
					List<Object> values = new ArrayList<>();
					if(a.getEAttributeType() instanceof EEnum) {
						graph.getValueEdges(n, edge).forEach(l->{
							values.add(EcoreUtil.createFromString(a.getEAttributeType(), l.getTarget().getValue().toString()));
						});
					} else {
						graph.getValueEdges(n, edge).forEach(l->{
							values.add(l.getTarget().getValue());
						});
					}
					obj.eSet(a, values);
				} else {
					List<ValueEdge> values = graph.getValueEdges(n, edge);
					if(values.isEmpty()==false) {
						Object value = values.get(0).getTarget().getValue();
						if(a.getEAttributeType() instanceof EEnum) {
							if(value!=null) value = EcoreUtil.createFromString(a.getEAttributeType(), value.toString());
						}
						obj.eSet(a, value);
					} else
						obj.eSet(a, null);
					
				}
			});
		});
		
		graph.getAllTypedNodes().forEach(n->{
			EClass tc = eclasses.get(n.getType().getName());
			EObject src = nodeMap.get(n);
			tc.getEAllReferences().forEach(r->{
				TypeEdge edge = graph.getTypeGraph().getTypeEdge(n.getType(), r.getName());
				if(r.isMany()) {
					List<EObject> values = new ArrayList<>();
					graph.getOutgoingEdges(n, edge).forEach(l->{
						values.add(nodeMap.get(l.getTarget()));
					});
					src.eSet(r, values);
				} else {
					List<TypedEdge> values = graph.getOutgoingEdges(n, edge);
					if(values.isEmpty()==false) {
						EObject tar = nodeMap.get(values.get(0).getTarget());
						src.eSet(r, tar);
					}
				}
			});
		});
		
		return nodeMap.values().stream().filter(n->n.eContainer()==null).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	private static void addTypedEdges(EObject root, TypeGraph typeGraph, Map<EObject, TypedNode> nodeMap,
			TypedGraph graph) {
		EClass cls = root.eClass();
		TypeNode tn = typeGraph.getTypeNode(cls.getName());
		
		cls.getEAllReferences().forEach(r->{
			TypeEdge typeEdge = typeGraph.getTypeEdge(tn, r.getName());
			if(r.isMany()) {
				Collection<EObject> targets = (Collection<EObject>) root.eGet(r);
				targets.forEach(t->{
					TypedEdge edge = new TypedEdge(nodeMap.get(root), nodeMap.get(t), typeEdge);
					graph.addTypedEdge(edge);
					if(r.isContainment())
						addTypedEdges(t, typeGraph, nodeMap, graph);
				});
			} else {
				EObject t = (EObject) root.eGet(r);
				if(t!=null) {
					TypedEdge edge = new TypedEdge(nodeMap.get(root), nodeMap.get(t), typeEdge);
					graph.addTypedEdge(edge);
					if(r.isContainment())
						addTypedEdges(t, typeGraph, nodeMap, graph);					
				}
			}
		});
	}

	private static void addTypedNode(EObject node, TypeGraph typeGraph, Map<EObject, TypedNode> nodeMap,
			TypedGraph graph) {
		
		TypeNode typeNode = typeGraph.getTypeNode(node.eClass().getName());
		TypedNode rootNode = new TypedNode(typeNode);
		graph.addTypedNode(rootNode);
		nodeMap.put(node, rootNode);
		
		EClass cls = node.eClass();
		cls.getEAllAttributes().forEach(a->{
			DataTypeNode dataTypeNode = typeGraph.getDataTypeNode(a.getEAttributeType().getName());
			PropertyEdge propertyEdge = typeGraph.getPropertyEdge(typeNode, a.getName());

			if(a.isMany()) {
				@SuppressWarnings("unchecked")
				Collection<Object> values = (Collection<Object>) node.eGet(a);
				values.forEach(v->{
					if(a.getEAttributeType() instanceof EEnum) {
						if(v instanceof Enumerator) v = ((Enumerator) v).getLiteral();
						else v = v.toString();
					}
					
					ValueNode vn = ValueNode.createConstantNode(v, dataTypeNode);
					graph.addValueNode(vn);
					graph.addValueEdge(new ValueEdge(rootNode, vn, propertyEdge));
				});
			} else {
				Object v = node.eGet(a);
				if(v!=null) {
					if(a.getEAttributeType() instanceof EEnum) {
						if(v instanceof Enumerator) v = ((Enumerator) v).getLiteral();
						else v = v.toString();
					}
					ValueNode vn = ValueNode.createConstantNode(v, dataTypeNode);
					graph.addValueNode(vn);
					graph.addValueEdge(new ValueEdge(rootNode, vn, propertyEdge));
				}
				
			}
		});
	}
	
	
}
