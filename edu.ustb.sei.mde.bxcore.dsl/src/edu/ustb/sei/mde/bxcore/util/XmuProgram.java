package edu.ustb.sei.mde.bxcore.util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

abstract public class XmuProgram {
	private Map<String, EPackage> packageMap = new HashMap<>();
	
	public void registerPackage(String name, URI uri) {
		EPackage pkg = EcoreModelUtil.loadPacakge(uri);
		if(pkg!=null)
			packageMap.put(name, pkg);
		else {
			java.util.logging.Logger.getLogger(XmuProgram.class.getName()).log(Level.SEVERE, "The package at "+uri+" is not found");
		}
	}
	
	public EPackage getPackage(String name) {
		return packageMap.get(name);
	}
}
