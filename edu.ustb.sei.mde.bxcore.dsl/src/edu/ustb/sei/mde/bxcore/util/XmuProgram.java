package edu.ustb.sei.mde.bxcore.util;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.graph.typedGraph.GraphvizExporterForTypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;

abstract public class XmuProgram {
	private Map<String, EPackage> packageMap = new HashMap<>();
	private String dotPath = "/usr/local/bin/";
	
	public String getDotPath() {
		return dotPath;
	}

	public void setDotPath(String dotPath) {
		this.dotPath = dotPath;
	}

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
	
	public void exportTypedGraph(TypedGraph graph, String uri) {
		GraphvizExporterForTypedGraph exporter = new GraphvizExporterForTypedGraph();
		String content = exporter.export(graph, "TypedGraph");
		
		try {
			File file = new File(uri+".gv"); 
			Writer writer = new java.io.BufferedWriter(new FileWriter(file));
			writer.append(content);
			writer.close();
		} catch (Exception e) {
			XmuCoreUtils.log(Level.WARNING, "Cannot save graphviz file! The content is printed below", e);
			System.out.println(content);
		}
	}
}
