package edu.ustb.sei.mde.bxcore.dsl.jvmmodel

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral
import java.util.HashMap
import edu.ustb.sei.mde.structure.Tuple2
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType
import java.util.ArrayList
import edu.ustb.sei.mde.bxcore.dsl.infer.TypeInferenceException

class ModelInferrerUtils {
	static def groupTypeLiterals(BXProgram program) {
		val literals = new ArrayList;
		val itr = program.eAllContents;
		while(itr.hasNext()) {
			val e = itr.next;
			if(e.eIsProxy) {
				throw new TypeInferenceException(e,null);
			} else {
				if(e instanceof TypeLiteral) {
					literals.add((e as TypeLiteral)->TupleType.make(e as TypeLiteral));
				}
			}
		}
		
		val groups = literals.groupBy[it.value];
		val result = new HashMap;
		
		groups.forEach[k,v,id|
			val pair = Tuple2.make(k,id);
			v.forEach[p|result.put(p.key, pair);];
		];
		
		return result;
	}
}