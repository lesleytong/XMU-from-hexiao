
public class Test {
	
	public static void main(String[] args) {
		
		double[] fullTime = new double[] {14,15,19,20};
		
		double accRange = 0.25;
		
		double[] highestSpeed = new double[4];
		
		double[] acc = new double[4];
		
		double L = 100.0;
		
		for(int i=0;i<fullTime.length;i++) {
			highestSpeed[i] = (L+L*accRange)/fullTime[i];
			acc[i] = highestSpeed[i]*highestSpeed[i]/2.0/L/accRange;
		}
		
		int[] ord  = null;
		
		for(int j1=0;j1<4;j1++) {
			for(int j2=0;j2<4;j2++) {
				if(j1==j2) continue;
				for(int j3=0;j3<4;j3++) {
					if(j1==j3 || j2==j3) continue;
					for(int j4=0;j4<4;j4++) {
						if(j1==j4 || j2==j4 || j4==j3) continue;
						
						ord = new int[] {j1,j2,j3,j4};
						calcTotal(ord, highestSpeed, acc, L);
					}
				}
			}
		}
	}


	private static void calcTotal(int[] ord, double[] highestSpeed, double[] acc, double L) {
		double preSpeed = 0.0;
		double totalTime = 0.0;
		
		for(int i : ord) {
			totalTime += calc(preSpeed, acc[i], highestSpeed[i], L);
			preSpeed = highestSpeed[i];
		}
		
		System.out.println((ord[0]+1)+"->"+(ord[1]+1)+"->"+(ord[2]+1)+"->"+(ord[3]+1)+"="+totalTime);
	}
	
	
	static double calc(double previousSpeed, double acc, double highestSpeed, double L) {
		double startSpeed = (previousSpeed < (highestSpeed * 0.7)) ? previousSpeed : (highestSpeed * 0.7);
		
		double accT = (highestSpeed - startSpeed)/acc;
		
		double accL = (highestSpeed + startSpeed) * accT / 2.0;
		
		double remT = (L-accL)/highestSpeed;
		
		return accT+remT;
		
	}

}
