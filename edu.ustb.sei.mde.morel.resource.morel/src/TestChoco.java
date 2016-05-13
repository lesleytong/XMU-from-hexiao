import edu.ustb.sei.commonutil.util.PairHashSet;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.PropTableConstraint;
import solver.Solver;
import solver.constraints.Constraint;
import solver.constraints.ICF;
import solver.constraints.LCF;
import solver.constraints.extension.Tuples;
import solver.variables.IntVar;
import solver.variables.VF;


public class TestChoco {

	public static void main(String[] args) {
		
		Solver solver = new Solver();
		IntVar v1 = VF.enumerated("v1", new int[]{2}, solver);
		IntVar v2 = VF.enumerated("v2", new int[]{2,3,5,7}, solver);
		PairHashSet<Integer,Integer> tables = new PairHashSet<Integer,Integer>();
		tables.add(3,2);
		tables.add(5,3);
		tables.add(7,2);
		
		//solver.post(new Constraint("",new PropTableConstraint(v1,v2,tables)));
		Tuples tuples = new Tuples(true);
		tuples.add(3,2);
		tuples.add(5,3);
		tuples.add(7,2);
		solver.post(ICF.table(v1, v2, tuples, "AC3"));
		
		boolean flag = solver.findSolution();
		if(flag==false) System.out.println("no solution");
		while(flag) {
			System.out.println(solver);
			flag = solver.nextSolution();
		}
	}

}
