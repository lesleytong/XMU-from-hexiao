import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.chocosolver.solver.*;
import org.chocosolver.solver.constraints.*;
import org.chocosolver.solver.constraints.real.Ibex;
import org.chocosolver.solver.constraints.real.RealConstraint;
import org.chocosolver.solver.variables.*;

import edu.ustb.sei.commonutil.util.Pair;

public class TestChoco {

	public static void main(String[] args) {
		Solver solver = new Solver("my first problem");
		IntVar a = VF.bounded("a", VF.MIN_INT_BOUND, VF.MAX_INT_BOUND, solver);
		IntVar na = VF.minus(a);
		
		
//		Constraint get_put  = LCF.and(LCF.not(ICF.arithm(v, "=", 5)), ICF.arithm(spp, "=", 10));;
//		solver.post(sum);
//		solver.post(cons);
		
		
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bo);
			oos.writeObject(solver);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] arr = bo.toByteArray();
		
//		try {
//			ByteArrayInputStream bi = new ByteArrayInputStream(arr);
//			ObjectInputStream ois = new ObjectInputStream(bi);
//			Solver solver2 = (Solver) ois.readObject();
//			solver2.findSolution();
//			System.out.println(solver2);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
