package edu.ustb.sei.mde.bxcore.dsl.structure;

import java.util.List;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping;

public class TypeDependency {

	public TypeDependency() {
	}
	
	Type from;
	Type to;
	
	DependencySort dependencySort;
	
	List<VarMapping> mappings;
	
	enum DependencySort {
		equal,
		subtype,
		fullMapping
	}

}
