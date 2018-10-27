public class Collatz {
	/**
	* Given N, Mode (v || c) as args in this order
	* Runs N hailstone sequences according to the following rules:
	* Each sequence will have a "seed" initializing with 1 until N
	* even numbers: seed/2, odd: seed*3+1
	* Sequence terminates when reaches the number 1
	**/
	
	public static void main(String[] args) {
	
		int getN = Integer.parseInt(args[0]);			// Retrieves user choices
		String getMode = args[1];
		
		
		String numOutput = "";							// Declare empty var for user output
		
		
		
		for (int i = 1; i<=getN; i++) {					// Runs N hailstone sequences
			
			boolean isOne = false;						// Initializes each hailstone sequence:
														// outputs vars, sequence seed, terminate boolean
			int seed = i;
			int numCount = 1;
			numOutput = numOutput + i;
			while (!isOne) {							// Hailstone sequence according to rules
															
				if (seed %2 != 0) {
					seed = seed*3 + 1;							
				}
			
				else {
					seed = seed/2;
				}
				
				numOutput = numOutput + " " + seed;		// Builds up output string
				numCount++;
				
				if (seed == 1) {						// Terminate sequence iff seed==1, final output data
					isOne = !isOne;
					numOutput = numOutput + " (" + numCount + ")\n";
					
				}
			}
			
		}
		switch (getMode) {
			case "v":
				System.out.print(numOutput);
			case "c":
				System.out.println("The first " + getN + " hailstone sequences reached 1.");
			
		}

		
															
	}
}