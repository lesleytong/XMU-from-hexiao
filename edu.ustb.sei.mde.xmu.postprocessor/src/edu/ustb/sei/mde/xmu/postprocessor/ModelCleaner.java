package edu.ustb.sei.mde.xmu.postprocessor;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.xmu.resource.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;
import edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource;
import edu.ustb.sei.mde.xmu.*;

public class ModelCleaner extends AbstractXmuPostProcesser {

	@Override
	public void process(XmuResource resource) {
		
		setFlag(true);
		XMUModel model = (XMUModel)resource.getContents().get(0);
		resource.getErrors().clear();
		
		for(Rule rule : model.getRules()) {
			if(isFlag()==false) return;
			try{
				Util.cleanVariable(rule);
			} catch(Exception e) {
				
			}
		}
		
	}
	




}
