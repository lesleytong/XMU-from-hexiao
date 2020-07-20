package edu.ustb.sei.mde.query.structure;

public class Tuple2<F,S> {
	private Tuple2(F first, S second) {
		super();
		this.first = first;
		this.second = second;
	}
	public final F first;
	public final S second;
	
	
	public static <F,S> Tuple2<F,S> make(F f, S s) {
		return new Tuple2<F, S>(f, s);
	}

}
