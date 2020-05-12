package edu.ustb.sei.mde.graph.typedGraph;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.Derived;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.IGraph;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.ConcurrentTypeGraph;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.PairMap;
import edu.ustb.sei.mde.structure.Tuple3;

@SuppressWarnings("unused")
public class ConcurrentTypedGraph extends IndexSystem implements IGraph {

	OrderInformation order;
	GraphConstraint constraint;
	List<TypedNode> allTypedNodes;
	List<ValueNode> allValueNodes;
	List<TypedEdge> allTypedEdges;
	List<ValueEdge> allValueEdges;

	@Derived
	private ConcurrentHashMap<TypedNode, List<TypedEdge>> outgoingEdgeMap;
	@Derived
	private ConcurrentHashMap<TypedNode, List<TypedEdge>> incomingEdgeMap;
	@Derived
	private ConcurrentHashMap<TypedNode, List<ValueEdge>> valueEdgeMap;
	@Derived
	private ConcurrentHashMap<ValueNode, List<ValueEdge>> valueReferenceMap;

	// lyt
	private ConcurrentTypeGraph concurrentTypeGraph;

	/** TypedGraph���췽���е���init() */
	public void init() {
		allTypedNodes = new CopyOnWriteArrayList<TypedNode>();
		allValueNodes = new CopyOnWriteArrayList<ValueNode>();
		allTypedEdges = new CopyOnWriteArrayList<TypedEdge>();
		allValueEdges = new CopyOnWriteArrayList<ValueEdge>();
		valueEdgeMap = new ConcurrentHashMap<TypedNode, List<ValueEdge>>();
		valueReferenceMap = new ConcurrentHashMap<>();
		incomingEdgeMap = new ConcurrentHashMap<TypedNode, List<TypedEdge>>();
		outgoingEdgeMap = new ConcurrentHashMap<TypedNode, List<TypedEdge>>();

		order = new OrderInformation();

		constraint = GraphConstraint.TRUE;
	}

	public List<TypedNode> getAllTypedNodes() {
		return allTypedNodes;
	}

	public List<ValueNode> getAllValueNodes() {
		return allValueNodes;
	}

	public List<TypedEdge> getAllTypedEdges() {
		return allTypedEdges;
	}

	public List<ValueEdge> getAllValueEdges() {
		return allValueEdges;
	}

	public OrderInformation getOrder() {
		return order;
	}

	// lyt
	public ConcurrentTypeGraph getConcurrentTypeGraph() {
		return this.concurrentTypeGraph;
	}

	@Override
	@Derived
	public List<INode> getNodes() {
		List<INode> nodes = new CopyOnWriteArrayList<>();
		nodes.addAll(allTypedNodes);
		nodes.addAll(allValueNodes);
		return nodes;
	}

	@Override
	public List<IEdge> getEdges() {
		List<IEdge> edges = new CopyOnWriteArrayList<>();
		edges.addAll(allTypedEdges);
		edges.addAll(allValueEdges);
		return edges;
	}

	public void addTypedNode(TypedNode n) {
		allTypedNodes.add(n);

		indexing(n); // ��������������������ͼ��indexToObjectMap
	}

	public void addValueNode(ValueNode n) {
		if (allValueNodes.contains(n) == false)
			allValueNodes.add(n);

		indexing(n);
	}

	public void moveTypedEdgeTo(int n, int i) {
		moveEdgeTo(allTypedEdges, n, i);
	}

	public void moveValueEdgeTo(int n, int i) {
		moveEdgeTo(allValueEdges, n, i);
	}

	public <T> void moveEdgeTo(List<T> edges, int cur, int i) {
		T n = edges.get(cur);

		if (cur == i || cur == -1)
			return;
		else {
			if (cur < i) {
				for (int j = cur; j < i; j++) {
					edges.set(j, edges.get(j + 1));
				}
			} else {
				for (int j = cur; j > i; j--) {
					edges.set(j, edges.get(j - 1));
				}
			}
			edges.set(i, n);
		}
	}

	public int indexOf(List<? extends Object> list, Object o) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == o)
				return i;
		}
		return -1;
	}

	/** ���ͷ�����Ϊ�������������������ڲ��������Ͷ����ӳ���ϵ��ӵ�ͼ��indexToObject�� */
	private <T extends IndexableElement> void indexing(T n) {
		if (n.isIndexable() == false)
			return;

		try {
			// �������û������
			if (n.getIndex().isEmpty()) {
				// ����ȫ��Ψһ������������ӵ�����n���ڲ���������
				n.appendIndexValue(IndexSystem.generateUUID());
				// lyt-Ϊ�˿�����̨�������ʱע��
//				XmuCoreUtils.warning("An object without index was found");
			}
		} catch (Exception e) {
			XmuCoreUtils.failure("Unknown error", e);
			return;
		}

//		n.foreach(i -> {
//			try {
//				// ���ڲ��������Ͷ����ӳ���ϵע�ᵽͼ��indexToObjectMap��
//				this.registerIndex(i, n);
//			} catch (NothingReturnedException e) {
//				java.util.logging.Logger.getLogger(XmuCoreUtils.COMPONENT_NAME).log(Level.SEVERE,
//						"Two objects are mapped onto the same index", e);
//			}
//		});
		n.getIndex().getInternalIndices().parallelStream().forEach(i -> {
			try {
				// ���ڲ��������Ͷ����ӳ���ϵע�ᵽͼ��indexToObjectMap��
				this.registerIndex(i, n);
			} catch (NothingReturnedException e) {
				java.util.logging.Logger.getLogger(XmuCoreUtils.COMPONENT_NAME).log(Level.SEVERE,
						"Two objects are mapped onto the same index", e);
			}
		});

	}

	/** ����ͼ��indexToObjectMap�����޸���private */
//	void reindexing(IndexableElement n) {
//		// ����foreach�Ĳ����Ǹ�lambda���ʽ
//		n.foreach(i -> {
//			this.indexToObjectMap.put(i, n);
//		});
//	}
	void reindexing(IndexableElement n) {
		n.getIndex().getInternalIndices().parallelStream().forEach(i -> {
			this.indexToObjectMap.put(i, n);
		});
	}

	/** ��ͼ�����TypedEdge���͵ı߶��� */
	public void addTypedEdge(TypedEdge e) {
		if (e.getType().isMany()) { // ���e��TypeEdge��isMany
			if (e.getType().isUnique()) { // �����isMany��������isUnique
				TypedEdge err = null;
				try {
					err = allTypedEdges.stream().filter(er -> {
						return er.getType() == e.getType() && er.getSource().getIndex().equals(e.getSource().getIndex())
								&& er.getTarget().getIndex().equals(e.getTarget().getIndex());
					}).findAny().get();
				} catch (Exception ex2) { // ���û�ҵ�����allTypedEdges�����e
					allTypedEdges.add(e);
					indexing(e);
				}
				if (err != null) // ����ҵ��ˣ���err�滻Ϊe
					replaceWith(err, e);
			} else { // �����isMany��������isUnique��ֱ�����e
				allTypedEdges.add(e);
				indexing(e);
			}
		} else { // �������isMany

			boolean replaced = false;

			for (int i = 0; i < allTypedEdges.size(); i++) {
				TypedEdge tmp = allTypedEdges.get(i);
				if (tmp.getSource() == e.getSource() // below I did use replaceWith, so I use == rather than
														// Index.equals
						&& tmp.getType() == e.getType()) {

					e.mergeIndex(tmp);
					reindexing(e);

					if (replaced) { // reduce redundant
						allTypedEdges.remove(i);
						i--;
						XmuCoreUtils.failure("Redundant edges " + tmp);
					} else {
						allTypedEdges.set(i, e);
						replaced = true;
					}
				}
			}
			if (!replaced) { // ���replaced����false�����e
				allTypedEdges.add(e);
				indexing(e);
			}
		}

		this.outgoingEdgeMap.remove(e.getSource());
		this.incomingEdgeMap.remove(e.getTarget());
	}

	/** ��ͼ�����ValueEdge���͵ı߶��� */
	public void addValueEdge(ValueEdge e) {
		if (e.getType().isMany()) { // ���e��PropertyEdge��isMany
			if (e.getType().isUnique()) { // �����isMany�����һ���isUnique
				ValueEdge err = null;
				try {
					err = allValueEdges.stream().filter(er -> {
						return er.getType() == e.getType() && er.getSource().getIndex().equals(e.getSource().getIndex())
								&& er.getTarget().equals(e.getTarget());
					}).findAny().get();
				} catch (Exception ex2) {
					allValueEdges.add(e);
					indexing(e);
				}
				if (err != null)
					replaceWith(err, e);
			} else { // �����isMany��������isUnique
				allValueEdges.add(e);
				indexing(e);
			}
		} else { // �������isMany
			boolean replaced = false;

			for (int i = 0; i < allValueEdges.size(); i++) {
				ValueEdge tmp = allValueEdges.get(i);
				if (tmp.getSource() == e.getSource() && tmp.getType() == e.getType()) {

					e.mergeIndex(tmp);
					reindexing(e);

					if (replaced) { // reduce redundant
						allValueEdges.remove(i);
						i--;
						XmuCoreUtils.failure("Redundant edges " + tmp);
					} else {
						allValueEdges.set(i, e);
						replaced = true;
					}
				}
			}
			if (!replaced) { // ���replace����false
				allValueEdges.add(e);
				indexing(e);
			}
		}

		this.valueEdgeMap.remove(e.getSource());
		this.valueReferenceMap.remove(e.getTarget());
	}

	// lyt
	public ConcurrentTypedGraph(ConcurrentTypeGraph concurrentTypeGraph) {
		super();
		this.concurrentTypeGraph = concurrentTypeGraph;
		init();
	}

	public TypedNode[] getTypedNodesOf(TypeNode type) {
		ConcurrentTypeGraph concurrentTypeGraph = this.getConcurrentTypeGraph();

		return allTypedNodes.stream().filter(n -> {
			return concurrentTypeGraph.isSuperTypeOf(n.getType(), type);
		}).toArray(i -> new TypedNode[i]);
	}

	public ValueNode[] getValueNodesOf(DataTypeNode type) {
		ConcurrentTypeGraph concurrentTypeGraph = this.getConcurrentTypeGraph();

		return allValueNodes.stream().filter(n -> {
			return concurrentTypeGraph.isSuperTypeOf(n.getType(), type);
		}).toArray(i -> new ValueNode[i]);
	}

	public TypedEdge[] getTypedEdgesOf(TypeEdge type) {
		return allTypedEdges.stream().filter(n -> {
			return n.getType() == type;
		}).toArray(i -> new TypedEdge[i]);
	}

	public ValueEdge[] getValueEdgesOf(PropertyEdge type) {
		return allValueEdges.stream().filter(n -> {
			return n.getType() == type;
		}).toArray(i -> new ValueEdge[i]);
	}

	@Derived
	public List<TypedEdge> getOutgoingEdges(TypedNode source) {
		List<TypedEdge> result = this.outgoingEdgeMap.get(source);
		if (result == null) {
			result = new CopyOnWriteArrayList<TypedEdge>();
			this.outgoingEdgeMap.put(source, result);

			for (TypedEdge e : this.getAllTypedEdges()) {
				if (e.getSource() == source) {
					result.add(e);
				}
			}

		}

		return result;
	}

	@Derived
	public List<TypedEdge> getOutgoingEdges(TypedNode source, TypeEdge feature) {
		List<TypedEdge> result = new CopyOnWriteArrayList<TypedEdge>();

		for (TypedEdge e : this.getOutgoingEdges(source)) {
			if (e.getType() == feature) {
				result.add(e);
			}
		}
		return result;
	}

	@Derived
	public List<TypedEdge> getOutgoingEdges(TypedNode source, TypeEdge feature, TypeNode targetType) {
		List<TypedEdge> result = new CopyOnWriteArrayList<TypedEdge>();

		for (TypedEdge e : this.getOutgoingEdges(source)) {
			if (e.getType() == feature && (targetType == null || targetType.isSuperTypeOf(e.getTarget().getType()))) {
				result.add(e);
			}
		}
		return result;
	}

	@Derived
	public List<TypedEdge> getIncomingEdges(TypedNode target) {
		List<TypedEdge> result = this.incomingEdgeMap.get(target);
		if (result == null) {
			result = new CopyOnWriteArrayList<TypedEdge>();
			this.incomingEdgeMap.put(target, result);

			for (TypedEdge e : this.getAllTypedEdges()) {
				if (e.getTarget() == target) {
					result.add(e);
				}
			}
		}
		return result;
	}

	@Derived
	public List<TypedEdge> getIncomingEdges(TypedNode target, TypeEdge feature) {
		List<TypedEdge> result = new CopyOnWriteArrayList<TypedEdge>();

		for (TypedEdge e : this.getIncomingEdges(target)) {
			if (e.getType() == feature) {
				result.add(e);
			}
		}
		return result;
	}

	@Derived
	public List<TypedEdge> getIncomingEdges(TypedNode target, TypeEdge feature, TypeNode sourceType) {
		List<TypedEdge> result = new CopyOnWriteArrayList<TypedEdge>();

		for (TypedEdge e : this.getIncomingEdges(target)) {
			if (e.getType() == feature && (sourceType == null || sourceType.isSuperTypeOf(e.getSource().getType()))) {
				result.add(e);
			}
		}
		return result;
	}

	@Derived
	public List<ValueEdge> getValueEdges(TypedNode source) {
		List<ValueEdge> result = this.valueEdgeMap.get(source); // ����key(TypedNode)�ҵ�value(List<ValueEdge>)

		if (result == null) {
			result = new CopyOnWriteArrayList<ValueEdge>();
			this.valueEdgeMap.put(source, result); // ���û���ҵ�����(source, result)��ӵ�valueEdgeMap��

			for (ValueEdge e : this.getAllValueEdges()) {
				if (e.getSource() == source) {
					result.add(e);
				}
			}
		}
		return result;
	}

	public List<ValueEdge> getValueReferences(ValueNode target) {
		List<ValueEdge> result = this.valueReferenceMap.get(target);
		if (result == null) {
			result = new CopyOnWriteArrayList<ValueEdge>();
			this.valueReferenceMap.put(target, result);

			for (ValueEdge e : this.getAllValueEdges()) {
				if (e.getTarget() == target) {
					result.add(e);
				}
			}
		}

		return result;
	}

	@Derived
	public List<ValueEdge> getValueEdges(TypedNode source, PropertyEdge feature) {
		List<ValueEdge> result = new CopyOnWriteArrayList<ValueEdge>();

		for (ValueEdge e : this.getValueEdges(source)) { // ����key(TypedNode)��ȡvalue(List<ValueEdge>)
			if (e.getType() == feature) {
				result.add(e); // �ٽ�feature�������ӵ�result��
			}
		}
		return result;
	}

	public List<ValueEdge> getValueEdgesTo(ValueNode target, PropertyEdge type, TypeNode sourceType) {
		List<ValueEdge> result = new CopyOnWriteArrayList<ValueEdge>();
		for (ValueEdge e : this.getValueReferences(target)) {
			if (e.getType() == type && (sourceType == null || sourceType.isSuperTypeOf(e.getSource().getType()))) {
				result.add(e);
			}
		}
		return result;
	}

	@Derived
	List<? extends ITypedEdge> getFeature(TypedNode source, IStructuralFeatureEdge type) {
		if (type instanceof TypeEdge) {
			return this.getOutgoingEdges(source, (TypeEdge) type);
		} else if (type instanceof PropertyEdge) {
			return this.getValueEdges(source, (PropertyEdge) type);
		} else {
			return Collections.emptyList();
		}
	}

	public String printGraph() {
		StringBuilder builder = new StringBuilder();

		List<TypedNode> allTypedNodes = this.getAllTypedNodes();
		allTypedNodes.forEach(n -> {
			builder.append(n.toString());
			builder.append("{");
			this.getValueEdges(n).forEach(v -> {
				builder.append(v.toString());
				builder.append(",");
			});
			builder.append("}");
			builder.append("\n");
		});

		this.getAllTypedEdges().forEach(e -> {
			builder.append(e.toString());
			builder.append("\n");
		});

		return builder.toString();
	}

	public boolean conformanceCheck() {
		PairMap<ITypedNode, IStructuralFeatureEdge, Integer> counts = new PairMap<>();

		for (TypedNode n : this.getAllTypedNodes()) {
			if (n.getType().isAbstract())
				return false;
			if (!this.getConcurrentTypeGraph().getAllTypeNodes().contains(n.getType()))
				return false;
		}

		for (ValueNode n : this.getAllValueNodes()) {
			if (!this.getConcurrentTypeGraph().getAllDataTypeNodes().contains(n.getType()))
				return false;
		}

		for (TypedEdge e : this.getAllTypedEdges()) {
			TypeEdge type = e.getType();
			if (!this.getConcurrentTypeGraph().getAllTypeEdges().contains(type))
				return false;
			if (!this.getConcurrentTypeGraph().isSuperTypeOf(e.getSource().getType(), type.getSource()))
				return false;
			if (!this.getConcurrentTypeGraph().isSuperTypeOf(e.getTarget().getType(), type.getTarget()))
				return false;

			Integer i = counts.get(e.getSource(), type);
			if (i == null)
				i = 0;
			counts.put(e.getSource(), type, i++);
			if (i > 1 && !type.isMany())
				return false;
		}

		for (ValueEdge e : this.getAllValueEdges()) {
			PropertyEdge type = e.getType();
			if (!this.getConcurrentTypeGraph().getAllPropertyEdges().contains(type))
				return false;
			if (!this.getConcurrentTypeGraph().isSuperTypeOf(e.getSource().getType(), type.getSource()))
				return false;
			if (!this.getConcurrentTypeGraph().isSuperTypeOf(e.getTarget().getType(), type.getTarget()))
				return false;

			Integer i = counts.get(e.getSource(), type);
			if (i == null)
				i = 0;
			counts.put(e.getSource(), type, i++);
			if (i > 1 && !type.isMany())
				return false;
		}

		return true;
	}

	/** TypedGraph���͵�ͼ�ĸ��� */
	public ConcurrentTypedGraph getCopy() {

		ConcurrentTypedGraph copy = new ConcurrentTypedGraph(this.concurrentTypeGraph);
		// addAll(c: Collection<? extends E>): boolean ������c�е�����Ԫ����ӵ��ü����С��������;͸��ƶ��������
		copy.getAllTypedNodes().addAll(this.getAllTypedNodes());
		copy.getAllValueNodes().addAll(this.getAllValueNodes());
		copy.getAllTypedEdges().addAll(this.getAllTypedEdges());
		copy.getAllValueEdges().addAll(this.getAllValueEdges());

		copy.indexToObjectMap.putAll(this.indexToObjectMap);

		copy.order = this.order.getCopy();

		copy.constraint = this.constraint;

		return copy;
	}

	public ConcurrentTypedGraph additiveMerge(ConcurrentTypedGraph graph) {

//		return BXMerge.additiveMerge(this, graph);

		ConcurrentTypedGraph result = this.getCopy();

		graph.getAllTypedNodes().forEach(n -> {
			try {
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				if (nr != n) {
					// �����������ĵ�ַ��ͬ����nr�滻Ϊn
					result.replaceWith(nr, n);
				}
			} catch (NothingReturnedException e) { // �������������resultͼ�в����ҵ���˵����graphͼ������ӵĽڵ�
				result.addTypedNode(n);
			}
		});

		graph.getAllValueNodes().forEach(n -> {
			result.addValueNode(n);
		});

		graph.getAllTypedEdges().forEach(e -> {
			try {
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				result.addTypedEdge(e);
			}
		});

		graph.getAllValueEdges().forEach(e -> {
			try {
				ValueEdge er = result.getElementByIndexObject(e.getIndex());
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				result.addValueEdge(e);
			}
		});

		result.order.merge(graph.order);

		result.constraint = GraphConstraint.and(this.constraint, graph.constraint);
		// check

		return result;
	}

	// static public boolean isIdentifical(TypedGraph left, TypedGraph right) {
	// return false;
	// }

	public ConcurrentTypedGraph merge(ConcurrentTypedGraph... interSources) throws NothingReturnedException {

		// return BXMerge.merge(this, interSources);

		ConcurrentTypedGraph result = this.getCopy();

		// each typed node n in result, collect images in interSources (null means
		// deleted, Any means default, T means required to be changed to T type)
		// if all the images of n are compatible, (1) delete or (2) change to the common
		// sub-type

		TypeNode[] nodeImages = new TypeNode[interSources.length];
		for (TypedNode baseNode : this.getAllTypedNodes()) {
			for (int i = 0; i < interSources.length; i++) {
				nodeImages[i] = computeImage(baseNode, this, interSources[i]);
			}

			try {
				TypeNode finalType = computeType(nodeImages, this.getConcurrentTypeGraph());

				if (finalType == TypeNode.NULL_TYPE) {
					result.remove(baseNode);
				} else {
					if (finalType == TypeNode.ANY_TYPE)
						finalType = baseNode.getType();

					TypedNode n = new TypedNode();
					n.setType(finalType);

					for (ConcurrentTypedGraph image : interSources) {
						n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
					}

					result.replaceWith(baseNode, n); // �ο�BXMerge
				}

			} catch (NothingReturnedException e) {
				throw e;
			}
		}

		for (ConcurrentTypedGraph image : interSources) {
			image.getAllValueNodes().forEach(v -> {
				result.addValueNode(v);
			});
		}

		// each typed edge e in the result, collect images in interSources (null means
		// deleted, Any means default, <s,t>:T means required)
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for (TypedEdge baseEdge : this.getAllTypedEdges()) {
			for (int i = 0; i < interSources.length; i++) {
				typedEdgeImages[i] = computeImage(baseEdge, this, interSources[i]);
			}
			try {
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = computeEdge(baseEdge, typedEdgeImages);
				if (finalEdgeInfo == null) {
					result.remove(baseEdge);
				} else {
					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = result.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge();
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);

					for (ConcurrentTypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e;
			}
		}

		// each typed edge e in the result, collect images in interSources (null means
		// deleted, Any means default, <s,t>:T means required)
		ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
		for (ValueEdge baseEdge : this.getAllValueEdges()) {
			for (int i = 0; i < interSources.length; i++) {
				valueEdgeImages[i] = computeImage(baseEdge, this, interSources[i]);
			}
			try {
				Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = computeEdge(baseEdge, valueEdgeImages);
				if (finalEdgeInfo == null) {
					result.remove(baseEdge);
				} else {
					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					ValueNode target = finalEdgeInfo.second;
					ValueEdge edge = new ValueEdge();
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);

					for (ConcurrentTypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e;
			}
		}

		// add extra nodes and edges

		for (ConcurrentTypedGraph image : interSources) {
			for (TypedNode n : image.allTypedNodes) {
				try {
					this.getElementByIndexObject(n.getIndex());
				} catch (NothingReturnedException e) {
					TypedNode rn = null;
					try {
						rn = result.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e1) {
						result.addTypedNode(n);
						rn = null;
					} finally {
						if (rn != null) {
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = this.getConcurrentTypeGraph().computeSubtype(lt, rt);
							if (ct == TypeNode.NULL_TYPE) {
								// incompatible
								throw new NothingReturnedException();
							} else {
								// TypedNode res = new TypedNode();
								// res.setType(ct);;
								// res.mergeIndices(rn);
								// res.mergeIndices(n);
								// result.replaceWith(rn, res);
								rn.mergeIndex(n);
								rn.setType(ct);
								reindexing(rn); // lyt-����
							}
						}
					}
				}
			}

			for (TypedEdge e : image.allTypedEdges) {
				try {
					this.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) {
					TypedEdge re = null;
					try {
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) {
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
						TypedNode target = result.getElementByIndexObject(e.getTarget().getIndex());
						if (e.getSource() != source || e.getTarget() != target) {
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addTypedEdge(ne);
						} else
							result.addTypedEdge(e);
						re = null;
					} finally {
						if (re != null) {
							if (re.getType() != e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								reindexing(re); // lyt
							}
						}
					}
				}
			}

			for (ValueEdge e : image.allValueEdges) {
				try {
					this.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) {
					ValueEdge re = null;
					try {
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) {
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
						// ValueNode target = e.getTarget();
						if (e.getSource() != source) {
							ValueEdge ne = new ValueEdge();
							ne.setSource(source);
							ne.setTarget(e.getTarget());
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addValueEdge(ne);
						} else
							result.addValueEdge(e);
						// result.addValueEdge(e);
						re = null;
					} finally {
						if (re != null) {
							if (re.getType() != e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| re.getTarget().equals(e.getTarget()) == false) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								reindexing(re); // lyt
							}
						}
					}
				}
			}
		}

		OrderInformation[] orders = new OrderInformation[interSources.length];
		for (int i = 0; i < interSources.length; i++)
			orders[i] = interSources[i].order;
		result.order.merge(orders);

		List<GraphConstraint> cons = new CopyOnWriteArrayList<>();
		cons.add(this.getConstraint());
		for (ConcurrentTypedGraph g : interSources) {
			cons.add(g.constraint);
		}
		result.constraint = GraphConstraint.and(cons);
		// check

		return result;
	}

	// �ж�����Ԫ���Ƿ����
	static boolean isEqual(IndexableElement l, IndexableElement r) {
		return l == r || (l != null && l.isIndexable() && r.isIndexable() && l.getIndex().equals(r.getIndex()));
	}

	/** ��ͼ��ɾ��TypedNode���͵Ľڵ� */
	public void remove(TypedNode n) {
		// �ҵ�List<TypedNodes>����n��ȵĵ㣬ɾ��
		this.allTypedNodes.removeIf(x -> isEqual(x, n));
		this.clearIndex(n);

		// ����˽ڵ㻹��ĳ��TypedEdge���ͱ�e��source��target�˵㣬��ɾ��������e
//		for (int i = this.allTypedEdges.size() - 1; i >= 0; i--) {
//			TypedEdge e = this.allTypedEdges.get(i);
//			if (isEqual(e.getSource(), n) || isEqual(e.getTarget(), n)) {
//				this.allTypedEdges.remove(i);
//				this.clearIndex(e);
//			}
//		}
		this.allTypedEdges.parallelStream().filter(e -> isEqual(e.getSource(), n) || isEqual(e.getTarget(), n))
				.forEach(e -> {
					this.allTypedEdges.remove(e);
					this.clearIndex(e);
				});

		// ����˽ڵ㻹��ĳ��ValueEdge���ͱ�e��source�˵㣬��ɾ��������e
//		for (int i = this.allValueEdges.size() - 1; i >= 0; i--) {
//			ValueEdge e = this.allValueEdges.get(i);
//			if (isEqual(e.getSource(), n)) {
//				this.allValueEdges.remove(i);
//				this.clearIndex(e);
//			}
//		}
		this.allValueEdges.parallelStream().filter(e -> isEqual(e.getSource(), n)).forEach(e -> {
			this.allValueEdges.remove(e);
			this.clearIndex(e);
		});

	}

	/** ��ͼ�е�TypedEdge��er�滻Ϊe */
	// lyt - �޸�Ϊ��public��Ϊ����TestThreeOrder����ʹ��
	public void replaceWith(TypedEdge er, TypedEdge e) {
		// ���ҵ�allTypedEdges�е�er�����滻Ϊe����
		this.allTypedEdges.replaceAll(x -> isEqual(x, er) ? e : x);
		e.mergeIndex(er);
		reindexing(e);

	}

	/** ��ͼ�е�ValueEdge��er�滻Ϊe */
	void replaceWith(ValueEdge er, ValueEdge e) {
		this.allValueEdges.replaceAll(x -> isEqual(x, er) ? e : x);
		e.mergeIndex(er);
		reindexing(e);
	}

	/** ��ͼ�е�TypedNode�ڵ�nr�滻Ϊn��ע�⻹Ҫ�������ڵ�TypedEdge�ߺ�ValueEdge�� */
	// Ϊ�˲��ԣ�default�ĳ���public
	public void replaceWith(TypedNode nr, TypedNode n) {

		List<TypedNode> allTypedNodes = this.allTypedNodes;
		List<TypedEdge> allTypedEdges = this.allTypedEdges;
		List<ValueEdge> allValueEdges = this.allValueEdges;
		ConcurrentTypeGraph concurrentTypeGraph = this.concurrentTypeGraph;

		// �ҵ�ͼ��List<TypedNode>�е�nr�����滻Ϊn����
		allTypedNodes.replaceAll(e -> isEqual(e, nr) ? n : e);
		// �ϲ�������
		n.mergeIndex(nr);
		// ����ͼ��indexToObjectMap
		reindexing(n);

		// TypedNode�ڵ��滻�󣬻�Ҫ�������ڵı�
		if (nr != n) {

			TypeNode nodeType = n.getType();

			// �������ڵ�TypedEdge���͵ı�
			List<TypedEdge> removedTypedEdges = new CopyOnWriteArrayList<TypedEdge>();
			allTypedEdges.replaceAll(e -> { // ����resultͼ��List<TypedEdge>��ÿ��Ԫ��e
				TypeEdge edgeType = e.getType(); // �Ȼ�ȡe��type
				// �ٸ���edgeType���Ի��sourceType��targetType
				TypeNode sourceType = edgeType.getSource();
				TypeNode targetType = edgeType.getTarget();

				if (e.getSource() == nr && e.getTarget() == nr) { // 1.���e��source��target����nr�ڵ�
					// ����n��type(nodeType)��e��sourceType��targetType��������
					if (concurrentTypeGraph.isSuperTypeOf(nodeType, sourceType)
							&& concurrentTypeGraph.isSuperTypeOf(nodeType, targetType)) {
						TypedEdge res = new TypedEdge();
						res.setSource(n);
						res.setTarget(n);
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res; // ��e�滻Ϊres
					} else { // ����n��type����e��sourceType |(&) targetType��������
						removedTypedEdges.add(e); // ��e��ӵ�removedTypedEdges������
						clearIndex(e); // ��Ԫ��e����������e��ӳ���ϵ����indexToObjectMap�����
						return e; // ��������ʱe->e���Ѿ���ӵ�ɾ��������
					}
				} else if (e.getSource() == nr) { // 2. ��e��source��nr��e��target����nr
					// ����n��type(nodeType)��e��sourceType��������
					if (concurrentTypeGraph.isSuperTypeOf(nodeType, sourceType)) {
						TypedEdge res = new TypedEdge();
						res.setSource(n);
						res.setTarget(e.getTarget());
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res;
					} else { // ����n��type����e��sourceType��������
						removedTypedEdges.add(e);
						clearIndex(e);
						return e;
					}
				} else if (e.getTarget() == nr) { // 3. ��e��target��nr��e��source����nr
					// ����n��type(nodeType)��e��targetType��������
					if (concurrentTypeGraph.isSuperTypeOf(nodeType, targetType)) {
						TypedEdge res = new TypedEdge();
						res.setSource(e.getSource());
						res.setTarget(n);
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res;
					} else { // ����n��type(nodeType)����e��targetType��������
						removedTypedEdges.add(e);
						clearIndex(e);
						return e;
					}
				} else // 4. e��source����nr��targetҲ����nr
					return e;
			});
			allTypedEdges.removeAll(removedTypedEdges); // ���ϲ���removeAll()��A <- A-B������A������ɾ��B����

			// �������ڵ�ValueEdge���͵ı�
			List<ValueEdge> removedValueEdges = new CopyOnWriteArrayList<ValueEdge>();
			allValueEdges.replaceAll(e -> { // ����resultͼ��List<ValueEdge>��ÿһ����e
				PropertyEdge edgeType = e.getType();
				TypeNode sourceType = edgeType.getSource();

				if (e.getSource() == nr) { // ���e��source��nr
					// ����n��type��e��sourceType�������ͣ���e�滻Ϊres
					if (concurrentTypeGraph.isSuperTypeOf(nodeType, sourceType)) {
						ValueEdge res = new ValueEdge();
						res.setSource(n);
						res.setTarget(e.getTarget());
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res;
					} else {
						// ����n��type��nr��type�����ݣ���ɾ��e
						removedValueEdges.add(e);
						clearIndex(e);
						return e;
					}
				} else
					return e; // ���e��source����nr������
			});
			allValueEdges.removeAll(removedValueEdges);

		}

	}

//	static public boolean isIdentifical(TypedGraph left, TypedGraph right) {
//		return false;
//	}

	/**
	 * �ٸ���valueEdgeImages[]�е������ȷ��finalEdgeInfo��Ԫ�� 1)
	 * ����baseEdge��Ԫ����Ϣ��a==baseEdge����b==baseEdge 2) ����null��a==baseEdge����b==null |
	 * a==null����b==baseEdge | a==null����b==null 3) �׳��쳣��a==null����b==imageEdge |
	 * a==imageEdge����b==null | a==imageEdge����b==imageEdge�������� 4)
	 * ����imageEdge��Ԫ����Ϣ��a==baseEdge����b==imageEdge | a==imageEdge����b==baseEdge |
	 * a==imageEdge����b==imageEdge���Ҽ���
	 */
	static Tuple3<TypedNode, ValueNode, PropertyEdge> computeEdge(ValueEdge baseEdge, ValueEdge[] valueEdgeImages)
			throws NothingReturnedException {
		Tuple3<TypedNode, ValueNode, PropertyEdge> any = new Tuple3<TypedNode, ValueNode, PropertyEdge>(
				baseEdge.getSource(), baseEdge.getTarget(), baseEdge.getType());
		Tuple3<TypedNode, ValueNode, PropertyEdge> tuple = any; // ��ʼ��ΪbaseEdge����Ϣ

		for (ValueEdge e : valueEdgeImages) {
			if (e == baseEdge)
				continue;
			else if (e == null) {
				if (tuple == null || isImage(tuple, baseEdge))
					tuple = null;
				else
					throw new NothingReturnedException(); // incompatible: a==imageEdge����b==null
			} else {
				if (tuple == null)
					throw new NothingReturnedException(); // incompatible: a==null����b==imageEdge
				else if (isImage(tuple, baseEdge))
					tuple = new Tuple3<TypedNode, ValueNode, PropertyEdge>(e.getSource(), e.getTarget(), e.getType());
				else {
					if (isImage(tuple, e)) // a==imageEdge����b==imageEdgeʱ���ж��Ƿ����
						continue;
					else
						throw new NothingReturnedException(); // incompatible: a==imageEdge����b==imageEdge���Ҳ�����
				}
			}
		}

		return tuple;
	}

	/** �ж�����ValueEdge�Ƿ���ݣ���Ԫ��tuple�ǵ�һ��ValueEdge����Ϣ */
	static private boolean isImage(Tuple3<TypedNode, ValueNode, PropertyEdge> tuple, ValueEdge e) {
		return tuple.third == e.getType() && tuple.first.getIndex().equals(e.getSource().getIndex()) // ��TypedNode���Ͷ����index�Ƿ��н���
				&& tuple.second.equals(e.getTarget()); // ��ValueNode���Ͷ����Ƿ�Ϊͬһ����
	}

	/** ������֧ͼ�Ⱥͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��imageGraph[]�У�������null��baseEdge��imageEdge */
	static ValueEdge computeImage(ValueEdge baseEdge, ConcurrentTypedGraph baseGraph, ConcurrentTypedGraph imageGraph) {
		try {
			// �ҵ���
			ValueEdge imageEdge = imageGraph.getElementByIndexObject(baseEdge.getIndex());
			if (imageEdge.getType() == baseEdge.getType()
					&& imageEdge.getSource().getIndex().equals(baseEdge.getSource().getIndex())
					&& imageEdge.getTarget().equals(baseEdge.getTarget()))
				return baseEdge;
			else
				return imageEdge;

		} catch (Exception e) { // û�ҵ���˵���ڷ�֧ͼ�б�ɾ��
			return null;
		}
	}

	/** ɾ��resultͼ�е�TypedEdge���ͱ�baseEdge */
	public void remove(TypedEdge baseEdge) {
		this.allTypedEdges.removeIf(x -> isEqual(x, baseEdge));
		this.clearIndex(baseEdge);
		// compute pre-deleted elements when baseEdge is containment, or not?
	}

	/** ɾ��resultͼ�е�ValueEdge���ͱ�baseEdge */
	public void remove(ValueEdge baseEdge) {
		this.allValueEdges.removeIf(x -> isEqual(x, baseEdge));
		this.clearIndex(baseEdge);
	}

	/**
	 * �ٸ���typedEdgeImages�е������ȷ��finalEdgeInfo��Ԫ����Ϣ
	 * 1)����baseEdge��Ԫ����Ϣ��a==baseEdge����b==baseEdge 2) ����null��a==baseEdge����b==null
	 * |a==null����b==baseEdge | a==null����b==null 3) �׳��쳣��a==null����b==imageEdge |
	 * a==imageEdge����b==null | a==imageEdge����b==imageEdge�������� 4)
	 * ����imageEdge��Ԫ����Ϣ��a==baseEdge����b==imageEdge | a==imageEdge����b==baseEdge
	 * |a==imageEdge����b==imageEdge���Ҽ���
	 */
	static Tuple3<TypedNode, TypedNode, TypeEdge> computeEdge(TypedEdge baseEdge, TypedEdge[] typedEdgeImages)
			throws NothingReturnedException {

		Tuple3<TypedNode, TypedNode, TypeEdge> any = new Tuple3<TypedNode, TypedNode, TypeEdge>(baseEdge.getSource(),
				baseEdge.getTarget(), baseEdge.getType());
		Tuple3<TypedNode, TypedNode, TypeEdge> tuple = any; // �����ʼ��ΪbaseEdge����Ϣ

		for (TypedEdge e : typedEdgeImages) {
			if (e == baseEdge)
				continue;
			else if (e == null) {
				if (tuple == null || isImage(tuple, baseEdge))
					tuple = null;
				else
					throw new NothingReturnedException(); // incompatible: a==imageEdge����b==null
			} else {
				if (tuple == null)
					throw new NothingReturnedException(); // incompatible: a==null����b==imageEdge
				else if (isImage(tuple, baseEdge))
					tuple = new Tuple3<TypedNode, TypedNode, TypeEdge>(e.getSource(), e.getTarget(), e.getType());
				else {
					if (isImage(tuple, e)) // a==imageEdge����b==imageEdgeʱ���������������
						continue;
					else
						throw new NothingReturnedException(); // incompatible: a==imageEdge����b==imageEdge����������
				}
			}
		}

		return tuple;
	}

	/** �Ƚ�����TypedEdge�Ƿ���ݣ�tuple�ǵ�һ���ߵ���Ԫ����Ϣ */
	static private boolean isImage(Tuple3<TypedNode, TypedNode, TypeEdge> tuple, TypedEdge e) {
		return tuple.third == e.getType() && tuple.first.getIndex().equals(e.getSource().getIndex())
				&& tuple.second.getIndex().equals(e.getTarget().getIndex());
	}

	/**
	 * ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��typedEdgeImages[i]�У�������baseEdge��imageEdge��null
	 */
	static TypedEdge computeImage(TypedEdge baseEdge, ConcurrentTypedGraph baseGraph, ConcurrentTypedGraph imageGraph) {
		try {
			// ����baseEdge���������ڷ�֧ͼ���ҵ���
			TypedEdge imageEdge = imageGraph.getElementByIndexObject(baseEdge.getIndex());
			// ���baseEdge�ڷ�֧ͼ�ͻ���ͼ��һ��(type & source & target)���򷵻�baseEdge
			if (imageEdge.getType() == baseEdge.getType()
					&& imageEdge.getSource().getIndex().equals(baseEdge.getSource().getIndex())
					&& imageEdge.getTarget().getIndex().equals(baseEdge.getTarget().getIndex()))
				return baseEdge;
			else
				return imageEdge; // �����һ�£��򷵻��޸ĺ��imageEdge

		} catch (Exception e) { // ����baseEdge�������ڷ�֧ͼ��û���ҵ���˵����ɾ�ˣ�����null
			return null;
		}
	}

	/** lyt-�޸�computeImage */
	static TypedEdge computeImage(TypedEdge baseEdge, Map<Index, TypedEdge> imageMap) {

		TypedEdge imageEdge = imageMap.get(baseEdge.getIndex());
		if(imageEdge != null) {
			// ���baseEdge�ڷ�֧ͼ�ͻ���ͼ��һ��(type & source & target)���򷵻�baseEdge
			if (imageEdge.getType() == baseEdge.getType()
					&& imageEdge.getSource().getIndex().equals(baseEdge.getSource().getIndex())
					&& imageEdge.getTarget().getIndex().equals(baseEdge.getTarget().getIndex()))
				return baseEdge;
			else
				return imageEdge; // �����һ�£��򷵻��޸ĺ��imageEdge
		}
		// ����baseEdge�������ڷ�֧ͼ��û���ҵ���˵����ɾ�ˣ�����null
		return null;
	}

	/**
	 * 
	 * ������ã�TypeNode finalType = TypedGraph.computeType(nodeImages,
	 * first.getTypeGraph())
	 * ��������֧��base�Ƚ�����ٸ�������֧baseNode�������NULL��ANY���޸ĺ�����ͣ�ȷ��finalType; 1)����ANY��a��b��ANY
	 * 2)����NULL��a��ANY��b��NULL | a��NULL��b��ANY | a��NULL��b��NULL 3)�׳��쳣��a��NULL��b���� |
	 * a���ˡ�b��NULL | a����bҲ���ˣ��������� 4)�����޸ĺ�����ͣ�a��ANY��b���� | a���ˡ�b��ANY | a����bҲ���ˣ�������
	 */
	static TypeNode computeType(TypeNode[] images, ConcurrentTypeGraph concurrentTypeGraph)
			throws NothingReturnedException {
		TypeNode finalType = TypeNode.ANY_TYPE;

		for (TypeNode n : images) {
			if (n == TypeNode.ANY_TYPE)
				continue;
			else if (n == TypeNode.NULL_TYPE) {
				if (finalType == TypeNode.ANY_TYPE || finalType == TypeNode.NULL_TYPE)
					finalType = TypeNode.NULL_TYPE;
				else
					throw new NothingReturnedException(); // incompatibe��a���ˡ�b��NULL
			} else {
				if (finalType == TypeNode.NULL_TYPE)
					throw new NothingReturnedException(); // incompatible��a��NULL��b����
				else if (finalType == TypeNode.ANY_TYPE)
					finalType = n;
				else {
					// a�����base���ˣ�b�����baseҲ���ˡ���һ��finalType��a�е����ͣ��ڶ��λ�����else���飬ȷ��finalType���յ����͡�
					finalType = concurrentTypeGraph.computeSubtype(finalType, n);
					if (finalType == TypeNode.NULL_TYPE)
						throw new NothingReturnedException();
				}

			}
		}
		return finalType;
	}

	/** �ڵ��ڷ�֧ͼ�ͻ���ͼ�еıȽϣ����ܷ���imageNode��type��ANY��NULL */
	static TypeNode computeImage(TypedNode baseNode, ConcurrentTypedGraph baseGraph, ConcurrentTypedGraph imageGraph) {
		try {
			// �ڷ�֧ͼ�и����������Ҷ�Ӧ��baseNode������ҵ���ֵ��imageNode
			TypedNode imageNode = imageGraph.getElementByIndexObject(baseNode.getIndex());
			// ����˽ڵ���baseGraph��imageGraph�е����Ͳ�һ�£��򷵻�imageNode
			if (imageNode.getType() != baseNode.getType())
				return imageNode.getType();
			else { // ����˽ڵ���baseGraph��imageGraph�е�����һ�£��򷵻�ANY
//				if (isTouched(imageNode, imageGraph, baseNode, baseGraph)) { // ����ʡ�ԣ�
//					return imageNode.getType();
//				} else
//					return TypeNode.ANY_TYPE;

				return TypeNode.ANY_TYPE;
			}

		} catch (NothingReturnedException e) {
			return TypeNode.NULL_TYPE; // imageGraph��û���ҵ���Ӧ��baseNode���򷵻�NULL_TYPE��nodeImage[0]
		}
	}

	/** ����ʡ�ԣ��� */
	private static boolean isTouched(TypedNode imageNode, ConcurrentTypedGraph imageGraph, TypedNode baseNode,
			ConcurrentTypedGraph baseGraph) {
		// may be omitted

		try {
			List<TypedEdge> imageEdges = imageGraph.getOutgoingEdges(imageNode);
			List<TypedEdge> baseEdges = baseGraph.getOutgoingEdges(baseNode);

			if (imageEdges.size() > baseEdges.size())
				return true;
			for (TypedEdge imageEdge : imageEdges) {
				if (baseEdges.stream().noneMatch(baseEdge -> {
					TypedNode imageTarget = imageEdge.getTarget();
					TypedNode baseTarget = baseEdge.getTarget();

					if (imageEdge.getType() == baseEdge.getType()) {
						if (!baseTarget.getIndex().equals(imageTarget.getIndex()))
							return false; // target inconsistent
						if (imageEdge.getType().isUnique()) {
							return baseEdge.getIndex().equals(imageEdge.getIndex()); // for a non-unique reference, the
																						// edge index determines the
																						// result
						} else
							return true; // for a unique reference, the edge index is determined by the source and
											// target indices
					} else {
						return false; // type inconsistent
					}
				}))
					return true; // we found that imageEdge is a new edge
			} // end for
		} catch (Exception e) {
			return true;
		}

		try {
			List<ValueEdge> imageEdges = imageGraph.getValueEdges(imageNode);
			List<ValueEdge> baseEdges = baseGraph.getValueEdges(baseNode);

			if (imageEdges.size() > baseEdges.size())
				return true;

			for (ValueEdge imageEdge : imageEdges) {
				if (baseEdges.stream().noneMatch(baseEdge -> {
					ValueNode imageTarget = imageEdge.getTarget();
					ValueNode baseTarget = baseEdge.getTarget();

					if (imageEdge.getType() == baseEdge.getType()) {
						if (baseTarget != imageTarget)
							return false; // target inconsistent
						if (imageEdge.getType().isUnique()) {
							return baseEdge.getIndex().equals(imageEdge.getIndex()); // for a non-unique reference, the
																						// edge index determines the
																						// result
						} else
							return true; // for a unique reference, the edge index is determined by the source and
											// target indices
					} else {
						return false; // type inconsistent
					}
				}))
					return true; // we found that imageEdge is a new edge
			} // end for
		} catch (Exception e) {
			return true;
		}

		return false;
	}

	public void setConstraint(GraphConstraint c) {
		this.constraint = c;
	}

	public GraphConstraint getConstraint() {
		return this.constraint;
	}

	/** ����buildTypedGraph */
	public void declare(String graphString) {
		// 1. split by ';'
		// 2. match by node/edge formats

		Map<String, TypedNode> map = new ConcurrentHashMap<>();

		String[] statements = graphString.split(";");
		String nodeDeclPattern = "\\s*(\\w+)\\s*:\\s*(\\w+)\\s*";
		String propDeclPattern = "\\s*(\\w+)\\s*\\.\\s*(\\w+)\\s*=\\s*(\\d+|true|false|\".*\")\\s*";
		String edgeDeclPattern = "\\s*(\\w+)\\s*\\-\\s*(\\w+)\\s*->\\s*(\\w+)\\s*";

		Pattern ndp = Pattern.compile(nodeDeclPattern);
		Pattern pdp = Pattern.compile(propDeclPattern);
		Pattern edp = Pattern.compile(edgeDeclPattern);

		Matcher matcher = null;

		for (String stat : statements) {
			if ((matcher = ndp.matcher(stat)).matches()) {
				String nodeName = matcher.group(1);
				String typeName = matcher.group(2);

				TypeNode type = this.concurrentTypeGraph.getTypeNode(typeName);

				TypedNode n = new TypedNode();
				n.setType(type);
				this.addTypedNode(n);
				map.put(nodeName, n);
			} else if ((matcher = pdp.matcher(stat)).matches()) {
				String sourceName = matcher.group(1);
				String featureName = matcher.group(2);
				String targetValue = matcher.group(3);

				TypedNode sn = (TypedNode) map.get(sourceName);
				PropertyEdge feature = this.concurrentTypeGraph.getPropertyEdge(sn.getType(), featureName);
				Object value = null;

				if (targetValue.equals("true") || targetValue.equals("false")) {
					value = Boolean.parseBoolean(targetValue);
				} else if (targetValue.startsWith("\"")) {
					value = targetValue.substring(1, targetValue.length() - 1);
				} else
					value = Integer.parseInt(targetValue);

				ValueNode n = ValueNode.createConstantNode(value, feature.getTarget());
				this.addValueNode(n);

				ValueEdge e = new ValueEdge();
				e.setSource(sn);
				e.setTarget(n);
				e.setType(feature);
				this.addValueEdge(e);
			} else if ((matcher = edp.matcher(stat)).matches()) {
				String sourceName = matcher.group(1);
				String featureName = matcher.group(2);
				String targetName = matcher.group(3);

				TypedNode sn = (TypedNode) map.get(sourceName);
				TypedNode tn = (TypedNode) map.get(targetName);
				TypeEdge feature = this.concurrentTypeGraph.getTypeEdge(sn.getType(), featureName);

				TypedEdge e = new TypedEdge();
				e.setSource(sn);
				e.setTarget(tn);
				e.setType(feature);

				this.addTypedEdge(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void enforceOrder() throws NothingReturnedException {
		List<? extends ITypedEdge> results = null;

		results = reorderEdges(this.allTypedEdges);
		this.allTypedEdges = (List<TypedEdge>) results;

		results = reorderEdges(this.allValueEdges);
		this.allValueEdges = (List<ValueEdge>) results;
	}

	private List<? extends ITypedEdge> reorderEdges(List<? extends ITypedEdge> edges) throws NothingReturnedException {
		List<Index> indices = edges.stream().map(e -> ((IndexableElement) e).getIndex()).collect(Collectors.toList());

		Index[] orderedIndices = this.order.planOrder(indices);

		List<? extends ITypedEdge> results = new CopyOnWriteArrayList<>();

		for (Index i : orderedIndices) {
			results.add(this.getElementByIndexObject(i));
		}
		return results;
	}

}
