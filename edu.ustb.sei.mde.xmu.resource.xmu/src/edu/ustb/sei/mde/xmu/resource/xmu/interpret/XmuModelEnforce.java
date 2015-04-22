package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu.*;

public abstract class XmuModelEnforce extends XmuModelCheck {

	@Override
	protected boolean enforceAtomicExpr(AtomicExpr invalid, XmuContext context,
			SafeType expect) {
		if(expect.isInvalid()) return false;
		
		if(invalid instanceof VariableExp) {
			VariableExp exp = (VariableExp)invalid;
			if(((VariableExp) invalid).getVar() instanceof ObjectVariable && exp.getPath()!=null && exp.getPath().size()==1) {
				SafeType hostObject = context.getSafeTypeValue(exp.getVar());
				if(hostObject.isNull() || hostObject.isInvalid() || hostObject.isUndefined()) return false;
				
				Path path = exp.getPath().get(0);
				if(path instanceof FeaturePath) {
					EStructuralFeature feature  = hostObject.getObjectValue().eClass().getEStructuralFeature(((FeaturePath) path).getFeature());
					if(feature!=null) {
						if(context.getEnvironment().setFeature(hostObject.getObjectValue(), feature, expect.getValue())==Just.TRUE) return true;
						else return false;						
					} else return false;
				} else return false;
			}
		}
		return super.enforceAtomicExpr(invalid, context, expect);
	}

	protected SafeType enforcePatternEqualExpr(PatternEqualExpr expr,
			SafeType host, XmuContext context) {
		SafeType ret = XmuModelCheck.MODEL_CHECK.interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr((PatternEqualExpr)expr, context);
		if(ret==SafeType.getUndefined()) {
			// try to enforce obj.ref
			// pos==null || pos != invalid
			AtomicExpr pos = ((PatternEqualExpr) expr).getPos();
			SafeType val = this.interprete(((PatternEqualExpr) expr).getValue(), context);
			if(pos==null) {
				if(val.isUndefined() || val.isInvalid()) {
					return SafeType.getInvalid();
				}
				if(val.isNull()) {
					// FIX ME: nil list
					return SafeType.getInvalid();
				}
				SafeType r = context.getEnvironment().setFeature(host.getObjectValue(), ((PatternEqualExpr) expr).getFeature(), val.getValue());
				if(r==Just.TRUE) return Just.TRUE;
				return SafeType.getInvalid();
			} else {
				SafeType pv = this.interprete(pos, context);
				
				if(val.isUndefined() || val.isInvalid()) {
					return SafeType.getInvalid();
				}
				if(val.isNull()) {
					// FIX ME: nil list
					return SafeType.getInvalid();
				}
				
				if(pv.isInteger()) {
					SafeType v = context.getEnvironment().setFeatureAtIndex(host.getObjectValue(),((PatternEqualExpr) expr).getFeature(),val.getValue(),pv.getIntegerValue());
					if(v!=Just.TRUE) 
						return SafeType.getInvalid();
				} else {
					return SafeType.getInvalid();
				}
			}
		}
		return Just.TRUE;
	}

//	protected SafeType enforceViewPatternEqualExpr(PatternEqualExpr expr, SafeType host,
//			XmuContext context) {
//		SafeType ret = XmuModelCheck.MODEL_CHECK.interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr((PatternEqualExpr)expr, context);
//		if(ret==SafeType.getUndefined()) {
//			// try to enforce obj.ref
//			// pos==null || pos != invalid
//			AtomicExpr pos = expr.getPos();
//			SafeType val = this.interprete(expr.getValue(), context);
//			if(pos==null) {
//				if(val.isUndefined() || val.isInvalid()) {
//					return SafeType.getInvalid();
//				}
//				if(val.isNull()) {
//					// FIX ME: nil list
//					return SafeType.getInvalid();
//				}
//				SafeType r = context.getEnvironment().setFeature(host.getObjectValue(), expr.getFeature(), val.getValue());
//				if(r==Just.TRUE) return Just.TRUE;
//				return SafeType.getInvalid();
//			} else {
//				SafeType pv = this.interprete(pos, context);
//				
//				if(val.isUndefined() || val.isInvalid()) {
//					return SafeType.getInvalid();
//				}
//				if(val.isNull()) {
//					// FIX ME: nil list
//					return SafeType.getInvalid();
//				}
//				
//				if(pv.isInteger()) {
//					SafeType v = context.getEnvironment().setFeatureAtIndex(host.getObjectValue(),expr.getFeature(),val.getValue(),pv.getIntegerValue());
//					if(v!=Just.TRUE) 
//						return SafeType.getInvalid();
//				} else {
//					return SafeType.getInvalid();
//				}
//			}
//		}
//		return Just.TRUE;
//	}

	
//	protected SafeType enforceSourcePostPatternEqualExpr(PatternEqualExpr expr,
//			SafeType host, XmuContext context) {
//				SafeType ret = XmuModelCheck.MODEL_CHECK.interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr((PatternEqualExpr)expr, context);
//				if(ret==SafeType.getUndefined()) {
//					// try to enforce obj.ref
//					// pos==null || pos != invalid
//					AtomicExpr pos = ((PatternEqualExpr) expr).getPos();
//					SafeType val = this.interprete(((PatternEqualExpr) expr).getValue(), context);
//					if(pos==null) {
//						if(val.isUndefined() || val.isInvalid()) {
//							return SafeType.getInvalid();
//						}
//						if(val.isNull()) {
//							// FIX ME: nil list
//							return SafeType.getInvalid();
//						}
//						SafeType r = context.getEnvironment().setFeature(host.getObjectValue(), ((PatternEqualExpr) expr).getFeature(), val.getValue());
//						if(r==Just.TRUE) return Just.TRUE;
//						return SafeType.getInvalid();
//					} else {
//						SafeType pv = this.interprete(pos, context);
//						
//						if(val.isUndefined() || val.isInvalid()) {
//							return SafeType.getInvalid();
//						}
//						if(val.isNull()) {
//							// FIX ME: nil list
//							return SafeType.getInvalid();
//						}
//						
//						if(pv.isInteger()) {
//							SafeType v = context.getEnvironment().setFeatureAtIndex(host.getObjectValue(),((PatternEqualExpr) expr).getFeature(),val.getValue(),pv.getIntegerValue());
//							if(v!=Just.TRUE) 
//								return SafeType.getInvalid();
//						} else {
//							return SafeType.getInvalid();
//						}
//					}
//				}
//				return Just.TRUE;
//			}
}