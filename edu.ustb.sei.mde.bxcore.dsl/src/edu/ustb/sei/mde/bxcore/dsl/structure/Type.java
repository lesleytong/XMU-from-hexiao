package edu.ustb.sei.mde.bxcore.dsl.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping;
import edu.ustb.sei.mde.bxcore.dsl.structure.TypeDependency.DependencySort;
import edu.ustb.sei.mde.structure.Tuple2;

public class Type {

	public Type() {
		this.outgoings = new ArrayList<>();
		this.incomings = new ArrayList<>();
	}
	
	List<TypeDependency> outgoings;
	List<TypeDependency> incomings;
	
	Object referredObject;
	
	public boolean isExplicit() {
		return referredObject instanceof Pattern || referredObject instanceof TypeDefinition;
	}
	
	public void inferType() {
		if(isExplicit()) return;
		else {
			
		}
	}
	
	public boolean isExplicitEqualTo(Type t) {
		for(TypeDependency d : this.outgoings) {
			if(d.dependencySort==DependencySort.equal && d.to==t) return true;
		}
		for(TypeDependency d : this.incomings) {
			if(d.dependencySort==DependencySort.equal && d.from==t) return true;
		}
		return false;
	}
	
	public boolean isExplicitSuperTypeOf(Type t) {
		for(TypeDependency d : this.outgoings) {
			if(d.dependencySort==DependencySort.subtype && d.to==t) return true;
		}
		return false;
	}

	public TypeDependency getMappingTo(Type t) {
		for(TypeDependency d : this.outgoings) {
			if(d.dependencySort==DependencySort.fullMapping && d.to==t) return d;
		}
		return null;
	}
	
	
}
