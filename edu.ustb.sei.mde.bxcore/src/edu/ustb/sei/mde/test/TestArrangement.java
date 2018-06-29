package edu.ustb.sei.mde.test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class TestArrangement {

	public static void main(String...strings) {
		List<ClassInfo> allClasses = new ArrayList<>();
		Model model = new Model("class arrangement");
		
		allClasses.add(new ClassInfo("C++", new int[] {2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0}, model));
		allClasses.add(new ClassInfo("Java", new int[] {2,4,2,4,1,1,1,1,0,0,0,0,0,0,0,0}, model));
		
		ClassInfo c3 = new ClassInfo("C#", new int[] {0,0,0,0,2,2,2,2,2,2,2,2,0,0,0,0}, model);
		allClasses.add(c3);
		
		c3.forbidDay(1, model);
		c3.forbidDay(3, model);
		c3.forbidDay(4, model);
		c3.forbidTimeSlot(0, model);
		c3.forbidTimeSlot(5, model);
		
		ClassInfo.noConflicts(allClasses, model);
		
		Solver s = model.getSolver();
		
		if(s.solve()) {
			allClasses.forEach(c->{c.print();});
		}
	}

}

class ClassInfo {
	final static String[] dayLabels = new String[] {"星期一","星期二","星期三","星期四","星期五"};
	final static String[] timeLabels = new String[] {"8:00-9:35","9:55-11:30","13:30-15:05","15:20-16:55","17:10-18:45","19:30-21:05"};
	final static int[] weekLabels = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	
	public static void noConflicts(List<ClassInfo> infos, Model m) {
		for(int w = 0; w<numberOfWeeksPerTerm; w++) {
			final int ww = w;
			infos.forEach(i1->{
				infos.forEach(i2->{
					if(i1==i2) return;
					
					for(ClassSchedule cs1 : i1.schedules[ww]) {
						for(ClassSchedule cs2 : i2.schedules[ww]) {
							m.or(m.arithm(cs1.dayOfWeek, "!=", cs2.dayOfWeek),m.arithm(cs1.timeSoltOfDay, "!=", cs2.timeSoltOfDay)).post();
						}
					}
					
				});
			});
		}
	}
	
	public void print() {
		System.out.println(name);
		
		Set<ClassSchedule> printed = new HashSet<>();
		
		for(int w=0;w<numberOfWeeksPerTerm;w++) {
			if(!(w<schedules.length)) continue;
			for(int d=0;d<numberOfDaysPerWeek;d++) {
				 if(!(d<schedules[w].length)) break;
				
				ClassSchedule cs = schedules[w][d];
				if(printed.contains(cs)) continue;
				printed.add(cs);
				
				int day = cs.dayOfWeek.getValue();
				int time = cs.timeSoltOfDay.getValue();
				
				System.out.print(dayLabels[day-1]+", "+timeLabels[time-1]+" ("+weekLabels[w]);
				filter(printed,w,day,time,System.out);
				System.out.println(")");
				
			}
		}
		
		System.out.println();
		
	}
	
	private void filter(Set<ClassSchedule> printed, int week, int day, int time, PrintStream out) {
		for(int w=week+1;w<numberOfWeeksPerTerm;w++) {
			if(!(w<schedules.length)) continue;
			for(int d=0;d<numberOfDaysPerWeek;d++) {
				if(!(d<schedules[w].length)) break;
				
				ClassSchedule cs = schedules[w][d];
				if(printed.contains(cs)) continue;
				
				int tday = cs.dayOfWeek.getValue();
				int ttime = cs.timeSoltOfDay.getValue();
				
				if(day==tday && time==ttime) {
					printed.add(cs);					
					out.print(", "+weekLabels[w]);
				}
			}
		}
	}




	public String name;
	public ClassSchedule[][] schedules;
	
	static final int numberOfDaysPerWeek = 5;
	static final int numberOfWeeksPerTerm = 16;

	public ClassInfo(String name, int[] classesOfEachWeek, Model m) {
		this.name = name;
		schedules = new ClassSchedule[classesOfEachWeek.length][];
		
		for(int w = 0; w<numberOfWeeksPerTerm; w++) {
			schedules[w] = new ClassSchedule[classesOfEachWeek[w]];
			for(int s=0;s<classesOfEachWeek[w];s++) {
				ClassSchedule ss = new ClassSchedule();
				ss.dayOfWeek = m.intVar(name+"_day_"+"["+w+","+s+"]", 1, 5);
				ss.timeSoltOfDay = m.intVar(name+"_time_"+"["+w+","+s+"]", 1, 6);
				schedules[w][s] = ss;
			}
		}
		
		// 1. for every week w, all different schedules[w][0], schedules[w][1], ...
		for(int w = 0; w<numberOfWeeksPerTerm; w++) {
			IntVar[] days = new IntVar[schedules[w].length];
			
			for(int s=0;s<schedules[w].length;s++) {
				days[s] = schedules[w][s].dayOfWeek;
			}
			
			m.allDifferent(days).post();
		}
		
		// 2. for schedules, they must be aligned
		for(int s=0;s<numberOfDaysPerWeek;s++) {
			List<ClassSchedule> allDays = collectSchedules(s);
			if(allDays.size()>1) {
				m.allEqual(allDays.stream().map(d->{return d.dayOfWeek;}).toArray((size)->{return new IntVar[size];})).post();;
				m.allEqual(allDays.stream().map(d->{return d.timeSoltOfDay;}).toArray((size)->{return new IntVar[size];})).post();
			}
		}
		
	}
	
	public void forbidDay(int day, Model m) {
		for(int w = 0; w<schedules.length; w++) {
			for(int s=0;s<schedules[w].length;s++) {
				ClassSchedule s0 = schedules[w][s];
				m.arithm(s0.dayOfWeek, "!=", day).post();;
			}
		}
	}
	
	public void forbidTimeSlot(int timeSlot, Model m) {
		for(int w = 0; w<schedules.length; w++) {
			for(int s=0;s<schedules[w].length;s++) {
				ClassSchedule s0 = schedules[w][s];
				m.arithm(s0.timeSoltOfDay, "!=", timeSlot).post();;
			}
		}
	}

	private List<ClassSchedule> collectSchedules(int s) {
		List<ClassSchedule> results = new ArrayList<>();
		
		for(int w=0;w<this.schedules.length;w++) {
			ClassSchedule[] ws = schedules[w];
			if(ws.length>s)
				results.add(ws[s]);
		}
		
		return results;
	}
	
}

class ClassSchedule {
	public IntVar dayOfWeek;
	public IntVar timeSoltOfDay;
}