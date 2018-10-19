package edu.ustb.sei.mde.bxcore.dsl.structure;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.EcoreTypeRef;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.FeatureTypeRef;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.OrderedTupleTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternEdge;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PredefinedTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeRef;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.UnorderedTupleTypeLiteral;
import edu.ustb.sei.mde.structure.Tuple2;

public class TupleType {
	public boolean ordered=false;
	public List<Tuple2<String,Object>> tuples = new ArrayList<Tuple2<String,Object>>();
	public ImportSection importSection = null;
	
	public boolean equals(Object o) {
		if(o instanceof TupleType) {
			TupleType right = (TupleType) o;
			if((this.tuples.isEmpty() || this.ordered == right.ordered) && this.tuples.size()==right.tuples.size()) {
				return this.tuples.stream().allMatch(t->{
					return right.tuples.contains(t);
				});
			} else return false;
		} else
			return false;
	}
	
	static final public TupleType empty = new TupleType();
	
	static public TupleType make(TypeLiteral literal) {
		if(literal instanceof PredefinedTypeLiteral) {
			// to support other types
			return empty;
		} else if(literal instanceof OrderedTupleTypeLiteral) {
			TupleType t = new TupleType();
			t.ordered = true;
			((OrderedTupleTypeLiteral) literal).getElements().forEach(e->t.tuples.add(Tuple2.make(e.getName(), getType(e.getType()))));
			t.importSection  = ((OrderedTupleTypeLiteral) literal).getSource();
			return t;
		}  else if(literal instanceof UnorderedTupleTypeLiteral) {
			TupleType t = new TupleType();
			t.ordered = true;
			((UnorderedTupleTypeLiteral) literal).getElements().forEach(e->t.tuples.add(Tuple2.make(e.getName(), getType(e.getType()))));
			t.tuples.sort((l,r)->l.first.compareTo(r.first));
			t.importSection  = ((UnorderedTupleTypeLiteral) literal).getSource();
			return t;
		} else if(literal instanceof PatternTypeLiteral) {
			TupleType t = new TupleType();
			literal.eAllContents().forEachRemaining(e->{
				if(e instanceof PatternNode) {
					t.tuples.add(Tuple2.make(((PatternNode)e).getName(), ((PatternNode)e).getType()));
				} else if(e instanceof PatternEdge) {
					t.tuples.add(Tuple2.make(((PatternEdge)e).getName(), ((PatternEdge)e).getFeature()));
				}
				
			});
			t.importSection  = ((PatternTypeLiteral) literal).getSource();
			t.tuples.sort((l,r)->l.first.compareTo(r.first));
			return t;
		} else return empty;
	}
	
	static public Object getType(TypeRef ref) {
		if(ref instanceof EcoreTypeRef) return ((EcoreTypeRef) ref).getType();
		else if(ref instanceof FeatureTypeRef) return ((FeatureTypeRef) ref).getFeature();
		return null;
	}
	
	static public EPackage getPackage(TypeRef ref) {
		if(ref instanceof EcoreTypeRef) return ((EcoreTypeRef) ref).getType().getEPackage();
		else if(ref instanceof FeatureTypeRef) return ((FeatureTypeRef) ref).getFeature().getEContainingClass().getEPackage();
		return null;
	}
	
	int hash = 0;
	@Override
	public int hashCode() {
		if(hash==0) 
			hash = tuples.stream().map(t->t.hashCode()).reduce(0, (a,b)->a+b);
		return hash;
	}
}
