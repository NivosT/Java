public class TestRandom {	
	/**
	* Given N as args[0]
	* Runs N pseudo random selections of an int between 0-3
	* Outputs the amount of selections of each option
	**/ 

	public static void main(String args[]) {
		
		int getN = Integer.parseInt(args[0]);		// Receiving user N choice
		
		int zero = 0;					// Initiating count values
		int one = 0;
		int two = 0;
		int three = 0;
		
		for (int i = 1; i<=getN; i++){
			int select = random4();			// Runs N amount of random selections
								// Logs separately each option
			if 		(select == 0) zero	+= 1;
			else if (select == 1) one	+= 1;
			else if (select == 2) two	+= 1;
			else if (select == 3) three	+= 1;
		}
								// outputs final conclusions
		System.out.println("We have pseudo-random selected " + getN + " times.");
		System.out.println("The results are:\n0: " + zero +"\n1: " + one + "\n2: " + two + "\n3: " + three);
	}
		
	 
	
	/**
	* Pseudo random selects an int between 0-3
	*
	* @return - int between 0-3
	**/
	private static int random4() {
													 
		int pseudoSelect = (int)(Math.random()*4);	// Using Math.random()
								// performs the desired draw
		return pseudoSelect;
	}
		
}
	

