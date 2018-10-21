package edu.ustb.sei.mde.bxcore.dsl.infer;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.structure.Tuple2;

public class UnsolvedTupleType extends TupleType {
	public List<Tuple2<String,Object[]>> candidates = new ArrayList<>();
	
	@Override
	public boolean equals(Object o) {
		return this==o;
	}
}
