package edu.ustb.sei.mde.morel.resource.morel.analysis;

public class StringUtil {
	static public boolean fuzzyCompare(String base, String pattern) {
		String[] subPatterns = pattern.split("\\*");
		boolean head = true;
		int start = 0;
		for(String sp : subPatterns) {
			int first = 0;
			if(head==false) 
				containsFrom(base,sp,start);
			else {
				first = startFrom(base,sp,start);
				head = false;
			}
			if(first==-1) return false;
			start = start + first + sp.length();
		}
		return true;
	}
	
	
	static private int startFrom(String base, String literal, int start) {
		if(base.length()==0) return 0;
		if(base.startsWith(literal)) return 0;
		return -1;
	}
	static private int containsFrom(String base, String literal, int start) {
		if(base.length()==0) return 0;
		int i = base.indexOf(literal, start);
		return i;
	}

}
