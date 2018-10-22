package edu.ustb.sei.mde.bxcore.dsl.jvmmodel;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.infer.TypeInferenceException;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.structure.Tuple2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@SuppressWarnings("all")
public class ModelInferrerUtils {
  public static HashMap<TypeLiteral, Tuple2<TupleType, Integer>> groupTypeLiterals(final BXProgram program) {
    final ArrayList<Pair<TypeLiteral, TupleType>> literals = new ArrayList<Pair<TypeLiteral, TupleType>>();
    final TreeIterator<EObject> itr = program.eAllContents();
    while (itr.hasNext()) {
      {
        final EObject e = itr.next();
        boolean _eIsProxy = e.eIsProxy();
        if (_eIsProxy) {
          throw new TypeInferenceException(e, null);
        } else {
          if ((e instanceof TypeLiteral)) {
            TupleType _make = TupleType.make(((TypeLiteral) e));
            Pair<TypeLiteral, TupleType> _mappedTo = Pair.<TypeLiteral, TupleType>of(((TypeLiteral) e), _make);
            literals.add(_mappedTo);
          }
        }
      }
    }
    final Function1<Pair<TypeLiteral, TupleType>, TupleType> _function = (Pair<TypeLiteral, TupleType> it) -> {
      return it.getValue();
    };
    final Map<TupleType, List<Pair<TypeLiteral, TupleType>>> groups = IterableExtensions.<TupleType, Pair<TypeLiteral, TupleType>>groupBy(literals, _function);
    final HashMap<TypeLiteral, Tuple2<TupleType, Integer>> result = new HashMap<TypeLiteral, Tuple2<TupleType, Integer>>();
    final Procedure3<TupleType, List<Pair<TypeLiteral, TupleType>>, Integer> _function_1 = (TupleType k, List<Pair<TypeLiteral, TupleType>> v, Integer id) -> {
      final Tuple2<TupleType, Integer> pair = Tuple2.<TupleType, Integer>make(k, id);
      final Consumer<Pair<TypeLiteral, TupleType>> _function_2 = (Pair<TypeLiteral, TupleType> p) -> {
        result.put(p.getKey(), pair);
      };
      v.forEach(_function_2);
    };
    MapExtensions.<TupleType, List<Pair<TypeLiteral, TupleType>>>forEach(groups, _function_1);
    return result;
  }
}
