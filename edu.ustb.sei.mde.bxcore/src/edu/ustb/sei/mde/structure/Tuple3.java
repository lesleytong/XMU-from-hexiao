package edu.ustb.sei.mde.structure;

public class Tuple3<F, S, T> {
	public Tuple3(F first, S second, T third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public final F first;
	public final S second;
	public final T third;

	
	static public <F,S, T> Tuple3<F,S, T> make(F f, S s, T t) {
		return new Tuple3<F, S, T>(f, s, t);
	}
	
	public Tuple3<F, S, T> replaceFirst(F f) {
		return Tuple3.make(f, second, third);
	}
	
	public Tuple3<F, S, T> replaceSecond(S s) {
		return Tuple3.make(first, s, third);
	}
	
	public Tuple3<F, S, T> replaceThird(T t) {
		return Tuple3.make(first, second, t);
	}
}
