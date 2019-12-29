package edu.ustb.sei.mde.bxcore.structures;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;

public class Index implements Cloneable {

	/**
	 * If freshIndex is true, it means that this index is a newly allocated index
	 * for a non-existing element
	 */
	private boolean freshIndex = false;
	private Set<Object> internalIndices = new HashSet<>();
	private Object fixedIndex = null;

	/**
	 * �ж�����index�Ƿ���ȣ���һ�пռ��׳��쳣���н����򷵻�true��û�н�����false
	 * �������l.getIndex().equals(r.getIndex())
	 */
	public boolean equals(Object index) {
		if (index instanceof Index) {
			if (this.internalIndices.isEmpty() || ((Index) index).internalIndices.isEmpty()) {
				XmuCoreUtils.warning("Cannot decide wether two Indexs that have empty internal index sets are equal");
			}
			// disjoint(c1: Collection, c1: Collection): boolean�����c1��c2û�й�ͬԪ�أ��򷵻�Ϊ��
			// ���c1��c2�й�ͬ��Ԫ�أ�disjoint����Ϊ�٣�!disjoint����Ϊ��
			return !Collections.disjoint(this.internalIndices, ((Index) index).internalIndices);
		} else
			return false;
	}

	public boolean isFreshIndex() {
		return this.freshIndex;
	}

	public Set<Object> internalIndices() {
		return internalIndices;
	}

	// �������index.merge(e.getIndex())
	public void merge(Index index) {
		if (this == index)
			return; // �����ͬһ��index����ֱ�ӷ���

		if (this.freshIndex != index.freshIndex)
			this.freshIndex = true;

		if (this.fixedIndex == null)
			this.fixedIndex = index.fixedIndex;

		internalIndices.addAll(index.internalIndices); // ��ʵ�ε��ڲ����������������ߵ��ڲ���������
	}

	private Index() {
		super();
	}

	private Index(Object internalIndex) {
		super();
		this.internalIndices.add(internalIndex);
	}

	public static Index index() {
		return new Index();
	}

	public static Index index(Object i) {
		if (i instanceof Index)
			throw new RuntimeException();

		Index idx = new Index(i);
		idx.fixedIndex = i;

		return idx;
	}

	public static Index freshIndex(Object i) {
		if (i instanceof Index)
			throw new RuntimeException();

		Index idx = new Index(i);
		idx.freshIndex = true;
		idx.fixedIndex = Index.class;

		return idx;
	}

	// ��¡����ԭ����һ���Ķ��󣬲����������ĵ�ַ�����µ����á�����ʵ��Cloneable�ӿڡ�
	public Index clone() {
		Index copy = new Index();
		copy.internalIndices.addAll(internalIndices);
		copy.freshIndex = freshIndex;
		copy.fixedIndex = fixedIndex;
		return copy;
	}

	/** ��ӽ�internalIndices���� */
	public void add(Object idx) {
		if (idx instanceof Index)
			throw new RuntimeException();
		if (this.fixedIndex == null)
			this.fixedIndex = idx;

		this.internalIndices.add(idx);
	}

	public boolean isEmpty() {
		return this.internalIndices.isEmpty();
	}

	public Object getFixedIndex() {
		return fixedIndex;
	}

	@Override
	public String toString() {
		return "@" + this.internalIndices;
	}
}
