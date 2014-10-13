import solver.Solver;
import solver.constraints.ICF;
import solver.constraints.LCF;
import solver.variables.IntVar;
import solver.variables.VF;


public class TestChoco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solver solver = new Solver();
		IntVar v1 = VF.enumerated("v1", 0, 1, solver);
		IntVar v2 = VF.enumerated("v2", -15, 15, solver);
		IntVar v3 = VF.enumerated("v3", -15, 15, solver);
		
		solver.post(LCF.ifThen(ICF.arithm(v1, "=", 0), ICF.arithm(v2, "<", v3)));
		solver.post(LCF.ifThen(ICF.arithm(v1, "=", 0), ICF.arithm(v2, "<", 0)));
		solver.post(LCF.ifThen(ICF.arithm(v1, "=", 1), ICF.arithm(v3, "<", v2)));
		solver.post(LCF.ifThen(ICF.arithm(v1, "=", 1), ICF.arithm(v3, "<", 0)));
		
		boolean flag = solver.findSolution();
		
		while(flag) {
			System.out.println(solver);
			flag = solver.nextSolution();
		}
	}

}
