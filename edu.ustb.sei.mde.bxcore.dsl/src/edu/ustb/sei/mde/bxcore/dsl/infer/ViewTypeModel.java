package edu.ustb.sei.mde.bxcore.dsl.infer;

import java.util.Map;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.structure.Tuple2;

public class ViewTypeModel extends TypeModel {

	public ViewTypeModel(BXProgram program, Map<TypeLiteral, Tuple2<TupleType, Integer>> literalMap) {
		super(program, literalMap);
	}

	@Override
	protected void extractConstraint(XmuCoreStatement e) {
		// TODO Auto-generated method stub
		
	}

}
