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
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNodeRef;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternValueCondition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PredefinedTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeRef;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.UnorderedTupleTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.infer.UnsolvedTupleType;
import edu.ustb.sei.mde.structure.Tuple3;

public class TupleType {
	public boolean ordered=false;
	public List<Tuple3<String,Object, Boolean>> tuples = new ArrayList<Tuple3<String,Object,Boolean>>();
	public ImportSection importSection = null;
	public String info;
	
	public boolean equals(Object o) {
		if(o instanceof TupleType && !(o instanceof UnsolvedTupleType)) return compare((TupleType)o);
		return false;
	}

	public boolean compare(TupleType o) {
		TupleType right = o;
		if ((this.tuples.isEmpty() || this.ordered == right.ordered) && this.tuples.size() == right.tuples.size()) {
			return this.tuples.stream().allMatch(t -> {
				return right.tuples.contains(t);
			});
		} else return false;
	}
	
	static final public TupleType empty = new TupleType();
	
	static public TupleType make(TypeLiteral literal) {
		if(literal instanceof PredefinedTypeLiteral) {
			// to support other types
			return empty;
		} else if(literal instanceof OrderedTupleTypeLiteral) {
			TupleType t = new TupleType();
			t.ordered = true;
			((OrderedTupleTypeLiteral) literal).getElements().forEach(e->t.tuples.add(Tuple3.make(e.getName(), getType(e.getType()), e.isMany())));
			t.importSection  = ((OrderedTupleTypeLiteral) literal).getSource();
			return t;
		}  else if(literal instanceof UnorderedTupleTypeLiteral) {
			TupleType t = new TupleType();
			t.ordered = false;
			((UnorderedTupleTypeLiteral) literal).getElements().forEach(e->t.tuples.add(Tuple3.make(e.getName(), getType(e.getType()), e.isMany())));
			t.tuples.sort((l,r)->l.first.compareTo(r.first));
			t.importSection  = ((UnorderedTupleTypeLiteral) literal).getSource();
			return t;
		} else if(literal instanceof PatternTypeLiteral) {
			TupleType t = new TupleType();
			t.ordered = false;
			literal.eAllContents().forEachRemaining(e->{
				if(e instanceof PatternNode) {
					t.tuples.add(Tuple3.make(((PatternNode)e).getName(), ((PatternNode)e).getType(), ((PatternNode)e).isMany()));
				} else if(e instanceof PatternEdge) {
					t.tuples.add(Tuple3.make(((PatternEdge)e).getName(), ((PatternEdge)e).getFeature(), isMany((PatternEdge)e)));
				}
				
			});
			t.importSection  = ((PatternTypeLiteral) literal).getSource();
			t.tuples.sort((l,r)->l.first.compareTo(r.first));
			return t;
		} else return empty;
	}

	protected static boolean isMany(PatternEdge e) {
		PatternNode con = (PatternNode) e.eContainer();
		if(con.isMany()) return true;
		PatternValueCondition target = e.getValue();
		if(target instanceof PatternNode) {
			return ((PatternNode) target).isMany();
		} else if(target instanceof PatternNodeRef) {
			return ((PatternNodeRef) target).getNode().isMany();
		}
		return ((PatternEdge)e).isMany();
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
