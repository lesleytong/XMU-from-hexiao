package edu.ustb.sei.mde.emg.graph;

public class EIdentifiable {
	
	static public boolean isValid(int s) {
		return s>NULL_ID;
	}
	
	public EIdentifiable() {
		setID(getNextID());
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	private int id;
	
	static public final int NULL_ID = 0;
	static public final int INVALID_ID = -1;
	
	private static int nextID = 1;
	static public int getNextID() {
		return nextID++;
	}
}
