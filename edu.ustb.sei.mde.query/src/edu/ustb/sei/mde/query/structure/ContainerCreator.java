package edu.ustb.sei.mde.query.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ContainerCreator {
	public static boolean isParallel = false;
	
	static public <F,S> Map<F,S> autoMap() {
		if(isParallel) return new ConcurrentHashMap<>();
		else return new HashMap<>();
	}

	public static <E>  List<E> autoList() {
		if(isParallel) return Collections.synchronizedList(new ArrayList<>());
		else return new ArrayList<>();
	}

	public static <E> Set<E> autoSet() {
		if(isParallel) return new ConcurrentSkipListSet<>();
		else return new HashSet<>();
	}

}
