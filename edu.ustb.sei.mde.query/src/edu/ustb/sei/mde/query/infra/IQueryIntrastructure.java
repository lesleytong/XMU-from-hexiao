package edu.ustb.sei.mde.query.infra;

import java.util.Collection;
import java.util.List;

import edu.ustb.sei.mde.query.indexing.Profile;
import edu.ustb.sei.mde.query.structure.PairMap;

public interface IQueryIntrastructure<METAMODEL, MODEL, CLASSIFIER, CLASS extends CLASSIFIER, OBJECT, DATATYPE extends CLASSIFIER, SLOT, FEATURE, REFERENCE extends FEATURE, LINK, ATTRIBUTE extends FEATURE, SLOTLINK> {
	Collection<OBJECT> getAllObjectsOf(CLASS type);
	Collection<Profile<OBJECT>> getAllObjectProfilesOf(CLASS type);
	Collection<LINK> getLinksOf(REFERENCE ref);
	PairMap<OBJECT,OBJECT,Boolean> getLinksMapOf(REFERENCE ref);
	Collection<LINK> getLinksFrom(OBJECT source, REFERENCE ref);
	Collection<LINK> getLinksTo(OBJECT target, REFERENCE ref);
	Collection<SLOTLINK> getSlotLinksOf(ATTRIBUTE ref);
	Collection<SLOTLINK> getSlotLinksFrom(OBJECT source, ATTRIBUTE ref);
	
	default Collection<SLOTLINK> getSlotLinksTo(SLOT target, ATTRIBUTE ref) {
		throw new UnsupportedOperationException();
	}
		
	Collection<OBJECT> getSources(OBJECT target, REFERENCE ref);
	List<OBJECT> getSourceList(OBJECT target, REFERENCE ref);
	
	Collection<OBJECT> getTargets(OBJECT source, REFERENCE ref);
	Collection<SLOT> getSlots(OBJECT source, ATTRIBUTE ref);
	Collection<OBJECT> getSlotSources(Object slot, ATTRIBUTE ref);
	
	TypeContext<METAMODEL,CLASSIFIER,CLASS, DATATYPE,FEATURE,REFERENCE,ATTRIBUTE> getContext();
	void setContext(TypeContext<METAMODEL,CLASSIFIER,CLASS, DATATYPE,FEATURE,REFERENCE,ATTRIBUTE> context);
	
	void addModel(MODEL model);
}
