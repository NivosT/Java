public class Birthday {
	/**
	* Calculates the smallest amount of people (N) that will:
	* yield 0.5 probability for "the birthday problem"
	**/
	
	public static void main(String[] args) {
	
		
		int n = 2;
		boolean zeroFive = false;				// Initiating values	
														
			
			
		while (!zeroFive) {							
			
			zeroFive = (probSomeBirthday(n) > 0.5);		// Runs probability func for n values starting from n=2									
									// Loop will exit when prob is greater than
			n++;
			
			}
									// Fixes n value for actual vinal result - for the output
		n--;											
		
		
		System.out.println("\nAccording to our calculations:\nThe smallest amount of people with the probability of at least 0.5 for 2+ people with the same birthday will occur for:\n" + n + " people.");
		
		}
		
						
	
	
	
	/**
	* returns the probability for at least 2 of N to have the same birthday
	* @param n - amount of people in the room
	* @return - prob of 2+ of n ppl to have a birthday
	**/
	public static double probSomeBirthday(int n) {
		
		double pN = 1;							// sets base vars for calc
		double base = 1.0/365.0;
														
		for (int i = 1; i<=(n-1); i++) {				// Runs the calc for no birthday withn N people
										// According to the birthday probability - until N-1		
														
			pN *= (1-(base*i));						
			
			
			}
		
		double twoMin = 1 - pN;						//calculates final value of min 2+ ppl with same birthday
		
		return twoMin;
		
		}
	

		
															
}
