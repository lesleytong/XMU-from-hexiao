package edu.ustb.sei.mde.graph.typedGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;

public class GraphChangeTool2 {
	static boolean changeTypedNodesFlag = true;
	static boolean changeTypedEdgesFlag = true;
	static boolean changeValueEdgesFlag = true;
	static boolean addValueEdgesFlag = true;

	/** 改变y个TypedEdge类型边的source（最多改变quarterSize个） */
	public static void changeTypedEdges(TypedGraph graph, int y) {

		int exchangeStart = 0, exchangeEnd = 0;

		int allSize = graph.getAllTypedEdges().size();
		int quarterSize = allSize / 4;
		int halfSize = allSize / 2;
		int threeQuarterSize = quarterSize + halfSize;

		if (changeTypedEdgesFlag == true) {
			exchangeStart = 0;
			exchangeEnd = (y >= quarterSize) ? (quarterSize - 1) : (y - 1);
		} else {
			exchangeStart = halfSize;
			exchangeEnd = (y >= quarterSize) ? (threeQuarterSize - 1) : (exchangeStart + y - 1);
		}

		TypedNode typedNode = graph.getAllTypedNodes().get(graph.getAllTypedNodes().size() - 2);
		TypeNode typeAddressBook = graph.getTypeGraph().getTypeNode("AddressBook");
		if (typedNode.getType() == typeAddressBook) {
			for (int i = exchangeStart; i <= exchangeEnd; i++) {
				TypedEdge er = graph.getAllTypedEdges().get(i);
				TypedEdge e = new TypedEdge();
				e.setType(er.getType());
				e.setSource(typedNode);
				e.setTarget(er.getTarget());
				// 将er替换为e
				graph.replaceWith(er, e);
			}
		}

		changeTypedEdgesFlag = (changeTypedEdgesFlag == true) ? false : true;

	}

	/** 改变y个ValueEdge的target（最多改变quarterSize个） */
	public static void changeValueEdges(TypedGraph graph, int y) {

		int exchangeStart = 0, exchangeEnd = 0;

		int allSize = graph.getAllValueEdges().size();
		int quarterSize = allSize / 4;
		int halfSize = allSize / 2;
		int threeQuarterSize = quarterSize + halfSize;

		if (changeValueEdgesFlag == true) {
			exchangeStart = 0;
			exchangeEnd = (y >= quarterSize) ? (quarterSize - 1) : (y - 1);
		} else {
			exchangeStart = halfSize;
			exchangeEnd = (y >= quarterSize) ? (threeQuarterSize - 1) : (exchangeStart + y - 1);
		}

		List<PropertyEdge> allPropertyEdges = graph.getTypeGraph().getAllPropertyEdges();
		PropertyEdge propertyEdgeName = allPropertyEdges.get(0);

		for (int i = exchangeStart; i <= exchangeEnd; i++) {
			ValueEdge er = graph.getAllValueEdges().get(i);
			if (er.getType() == propertyEdgeName) {
				ValueEdge e = new ValueEdge();
				e.setType(er.getType());
				e.setSource(er.getSource());
				// 新申请的ValueNode
				ValueNode v0 = graph.getAllValueNodes().get(0); // 没有直接new ValueNode()方法
				ValueNode v = v0.createConstantNode("replace_name", v0.getType());
				e.setTarget(v);
				// 将er替换为e
				graph.replaceWith(er, e);
			}
		}

		changeValueEdgesFlag = (changeValueEdgesFlag == true) ? false : true;

	}

	/** 删除y个TypedNodes（最多删除quarterSize个） */
	public static void deleteTypedNodes(TypedGraph graph, int y) {

		int deleteStart = 0, deleteEnd = 0;

		int allSize = graph.getAllTypedNodes().size();
		int quarterSize = allSize / 4;
		int halfSize = allSize / 2;
		int threeQuarterSize = quarterSize + halfSize;

		if (changeTypedNodesFlag == true) {
			deleteStart = quarterSize;
			deleteEnd = (deleteStart + y) >= halfSize ? (halfSize - 1) : (deleteStart + y - 1);
		} else {
			deleteStart = threeQuarterSize;
			deleteEnd = (deleteStart + y) >= allSize ? (allSize - 1) : (deleteStart + y - 1);
		}

		TypeNode typePerson = graph.getTypeGraph().getTypeNode("Person");
		HashMap<Integer, TypedNode> map = new HashMap<>();
		for (int i = deleteStart; i <= deleteEnd; i++) {
			TypedNode nd = graph.getAllTypedNodes().get(i);
			/**
			 * 因为删除Address的话，Person会并列，EMF Compare会识别成新加 所以我直接只删除Person类型节点了
			 * 而Person删除的话，可视化下旗下的ValueNode也被删除了 为了保证合并时输入一致，这里我也要删除旗下的ValueNode
			 * 但图合并算法只管新加的ValueNode 所以可以理解成两个合并机制不太一样 EMF Compare会多识别出ValueNode被删除
			 */
			if (nd.getType() == typePerson) {
				map.put(i, nd); // 先保存下来
			}
		}

		for (int i = deleteStart; i <= deleteEnd; i++) {
			TypedNode nd = map.get(i);
			graph.remove(nd);
		}

		changeTypedNodesFlag = (changeTypedNodesFlag == true) ? false : true;

	}

	/** 生成任意长度的随机字符串，全字母或全数字 */
	public static String getRandomString(int length, boolean letter) {
		String str = null;
		int len = 0;
		if (letter) {
			str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			len = str.length();
		} else {
			str = "0123456789";
			len = str.length();
		}

		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(len);
			sb.append(str.charAt(num));
		}
		return sb.toString();
	}

	/** 添加Address-Person，Person-name，Person-tel */
	public static void addNodesAndEdges(TypedGraph graph, int z) {

		List<PropertyEdge> allPropertyEdges = graph.getTypeGraph().getAllPropertyEdges();

		for (int i = 0; i < z; i++) {
			graph.declare("a:AddressBook;" + "p:Person;" + "a-persons->p;");

			TypedNode personNode = graph.getAllTypedNodes().get(graph.getAllTypedNodes().size() - 1);

			String name = getRandomString(5, true);
			String tel = getRandomString(5, false);

			// 创建ValueNode
			ValueNode v0 = graph.getAllValueNodes().get(0); // 没有直接new ValueNode()方法
			
			ValueNode valueNodeName = v0.createConstantNode(name, v0.getType());
			graph.addValueNode(valueNodeName);
			
			ValueNode valueNodeTel = v0.createConstantNode(tel, v0.getType());
			graph.addValueNode(valueNodeTel);

			System.out.println("**********" + graph.getAllValueEdges().size());
			
			// 创建ValueEdge
			ValueEdge valueEdgeName = new ValueEdge();
			valueEdgeName.setType(allPropertyEdges.get(0));
			valueEdgeName.setSource(personNode);
			valueEdgeName.setTarget(valueNodeName);
			graph.addValueEdge(valueEdgeName);
			
			ValueEdge valueEdgeTel = new ValueEdge();
			valueEdgeTel.setType(allPropertyEdges.get(1));
			valueEdgeTel.setSource(personNode);
			valueEdgeTel.setTarget(valueNodeTel);
			graph.addValueEdge(valueEdgeTel);
		
		}
	}

}
