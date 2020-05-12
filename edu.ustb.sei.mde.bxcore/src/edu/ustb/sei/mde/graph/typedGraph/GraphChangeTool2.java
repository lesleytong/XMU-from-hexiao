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

	/** �ı�y��TypedEdge���ͱߵ�source�����ı�quarterSize���� */
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
				// ��er�滻Ϊe
				graph.replaceWith(er, e);
			}
		}

		changeTypedEdgesFlag = (changeTypedEdgesFlag == true) ? false : true;

	}

	/** �ı�y��ValueEdge��target�����ı�quarterSize���� */
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
				// �������ValueNode
				ValueNode v0 = graph.getAllValueNodes().get(0); // û��ֱ��new ValueNode()����
				ValueNode v = v0.createConstantNode("replace_name", v0.getType());
				e.setTarget(v);
				// ��er�滻Ϊe
				graph.replaceWith(er, e);
			}
		}

		changeValueEdgesFlag = (changeValueEdgesFlag == true) ? false : true;

	}

	/** ɾ��y��TypedNodes�����ɾ��quarterSize���� */
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
			 * ��Ϊɾ��Address�Ļ���Person�Ტ�У�EMF Compare��ʶ����¼� ������ֱ��ֻɾ��Person���ͽڵ���
			 * ��Personɾ���Ļ������ӻ������µ�ValueNodeҲ��ɾ���� Ϊ�˱�֤�ϲ�ʱ����һ�£�������ҲҪɾ�����µ�ValueNode
			 * ��ͼ�ϲ��㷨ֻ���¼ӵ�ValueNode ���Կ������������ϲ����Ʋ�̫һ�� EMF Compare���ʶ���ValueNode��ɾ��
			 */
			if (nd.getType() == typePerson) {
				map.put(i, nd); // �ȱ�������
			}
		}

		for (int i = deleteStart; i <= deleteEnd; i++) {
			TypedNode nd = map.get(i);
			graph.remove(nd);
		}

		changeTypedNodesFlag = (changeTypedNodesFlag == true) ? false : true;

	}

	/** �������ⳤ�ȵ�����ַ�����ȫ��ĸ��ȫ���� */
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

	/** ���Address-Person��Person-name��Person-tel */
	public static void addNodesAndEdges(TypedGraph graph, int z) {

		List<PropertyEdge> allPropertyEdges = graph.getTypeGraph().getAllPropertyEdges();

		for (int i = 0; i < z; i++) {
			graph.declare("a:AddressBook;" + "p:Person;" + "a-persons->p;");

			TypedNode personNode = graph.getAllTypedNodes().get(graph.getAllTypedNodes().size() - 1);

			String name = getRandomString(5, true);
			String tel = getRandomString(5, false);

			// ����ValueNode
			ValueNode v0 = graph.getAllValueNodes().get(0); // û��ֱ��new ValueNode()����
			
			ValueNode valueNodeName = v0.createConstantNode(name, v0.getType());
			graph.addValueNode(valueNodeName);
			
			ValueNode valueNodeTel = v0.createConstantNode(tel, v0.getType());
			graph.addValueNode(valueNodeTel);

			System.out.println("**********" + graph.getAllValueEdges().size());
			
			// ����ValueEdge
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
