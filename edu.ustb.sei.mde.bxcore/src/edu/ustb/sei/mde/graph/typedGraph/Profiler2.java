package edu.ustb.sei.mde.graph.typedGraph;

import java.util.concurrent.TimeUnit;

public class Profiler2 {

	private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
																	protected Long initialValue() {
																		return System.currentTimeMillis();
																	};
																};
	
	public static final void begin() {
		TIME_THREADLOCAL.set(System.currentTimeMillis());
	}
											
	public static final long end() {
		return System.currentTimeMillis() - TIME_THREADLOCAL.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Profiler2.begin();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(Profiler2.end());
	}

}
