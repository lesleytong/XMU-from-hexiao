package edu.ustb.sei.mde.xmu2.runtime.string;

import java.util.ArrayList;
import java.util.List;

public class StringCombination extends StringPatternElement {
	
	public StringPatternElement getLast() {
		if(tail!=null) {
			if(tail instanceof StringCombination) return ((StringCombination) tail).getLast();
			else return tail;
		} else if(separator!=null) 
			return separator;
		else if(head!=null) {
			if(head instanceof StringCombination) return ((StringCombination) head).getLast();
			else return head;
		} else return null;
	}
	
	private StringPatternElement head = null;
	
	private StringConstant separator = null;
	
	private StringPatternElement tail = null;
	
	private boolean prefix = true;

	public StringPatternElement getHead() {
		return head;
	}

	public void setHead(StringPatternElement head) {
		this.head = head;
	}

	public StringConstant getSeparator() {
		return separator;
	}

	public void setSeparator(StringConstant separator) {
		this.separator = separator;
	}

	public StringPatternElement getTail() {
		return tail;
	}

	public void setTail(StringPatternElement tail) {
		this.tail = tail;
	}

	public boolean isPrefix() {
		return prefix;
	}

	public void setPrefix(boolean prefix) {
		this.prefix = prefix;
	}
}
