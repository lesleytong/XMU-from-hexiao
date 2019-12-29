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
	 * 判断两个index是否相等：任一有空集抛出异常、有交集则返回true、没有交集则false
	 * 比如调用l.getIndex().equals(r.getIndex())
	 */
	public boolean equals(Object index) {
		if (index instanceof Index) {
			if (this.internalIndices.isEmpty() || ((Index) index).internalIndices.isEmpty()) {
				XmuCoreUtils.warning("Cannot decide wether two Indexs that have empty internal index sets are equal");
			}
			// disjoint(c1: Collection, c1: Collection): boolean，如果c1和c2没有共同元素，则返回为真
			// 如果c1和c2有共同的元素，disjoint返回为假，!disjoint返回为真
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

	// 比如调用index.merge(e.getIndex())
	public void merge(Index index) {
		if (this == index)
			return; // 如果是同一个index对象直接返回

		if (this.freshIndex != index.freshIndex)
			this.freshIndex = true;

		if (this.fixedIndex == null)
			this.fixedIndex = index.fixedIndex;

		internalIndices.addAll(index.internalIndices); // 将实参的内部索引集添加入调入者的内部索引集中
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

	// 克隆出与原对象一样的对象，并将这个对象的地址赋予新的引用。必须实现Cloneable接口。
	public Index clone() {
		Index copy = new Index();
		copy.internalIndices.addAll(internalIndices);
		copy.freshIndex = freshIndex;
		copy.fixedIndex = fixedIndex;
		return copy;
	}

	/** 添加进internalIndices集合 */
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
