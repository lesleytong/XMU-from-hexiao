package edu.ustb.sei.mde.bxcore.dsl.infer;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferData;
import edu.ustb.sei.mde.bxcore.dsl.infer.SourceTypeModel;
import edu.ustb.sei.mde.bxcore.dsl.infer.TypeModel;
import edu.ustb.sei.mde.bxcore.dsl.infer.ViewTypeModel;
import edu.ustb.sei.mde.bxcore.dsl.jvmmodel.ModelInferrerUtils;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.structure.Tuple2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class InferManager {
  public static Map<Resource, InferData> inferredDataMap = new HashMap<Resource, InferData>();
  
  public static InferData getInferredTypeModel(final Resource resource) throws Exception {
    final InferData data = InferManager.inferredDataMap.get(resource);
    if ((data == null)) {
      return InferManager.createInfer(resource);
    } else {
      boolean _isModified = resource.isModified();
      if (_isModified) {
        resource.setModified(false);
        return InferManager.createInfer(resource);
      } else {
        return data;
      }
    }
  }
  
  public static InferData safeGetInferredTypeModel(final Resource resource) throws Exception {
    return InferManager.inferredDataMap.get(resource);
  }
  
  protected static InferData createInfer(final Resource resource) throws Exception {
    boolean _isTrackingModification = resource.isTrackingModification();
    boolean _tripleEquals = (Boolean.valueOf(_isTrackingModification) == Boolean.valueOf(false));
    if (_tripleEquals) {
      resource.setTrackingModification(true);
    }
    InferManager.inferredDataMap.remove(resource);
    EObject _get = resource.getContents().get(0);
    final BXProgram program = ((BXProgram) _get);
    final HashMap<TypeLiteral, Tuple2<TupleType, Integer>> literalMap = ModelInferrerUtils.groupTypeLiterals(program);
    final Tuple2<SourceTypeModel, ViewTypeModel> infer = TypeModel.buildTypeInfers(program, literalMap);
    infer.first.solveNames();
    infer.first.solveTypes();
    infer.second.solveNames();
    infer.second.solveTypes();
    final InferData data = new InferData();
    data.setLiteralMap(literalMap);
    data.setSourceInfer(infer.first);
    data.setViewInfer(infer.second);
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((it instanceof PatternTypeLiteral));
    };
    final Function1<EObject, PatternTypeLiteral> _function_1 = (EObject it) -> {
      return ((PatternTypeLiteral) it);
    };
    final List<Pair<Integer, PatternTypeLiteral>> patternLiterals = IteratorExtensions.<Pair<Integer, PatternTypeLiteral>>toList(IteratorExtensions.<PatternTypeLiteral>indexed(IteratorExtensions.<EObject, PatternTypeLiteral>map(IteratorExtensions.<EObject>filter(program.eAllContents(), _function), _function_1)));
    data.patternLiterals = patternLiterals;
    InferManager.inferredDataMap.put(resource, data);
    XmuCoreUtils.log(Level.INFO, "infer created", null);
    return data;
  }
}
