public class Gen3 {
	/**
	* Given a range [a,b) as args (in this order)
	* outputs three pseudo random values in that range
	* and states the minimal generated value
	**/
	
	public static void main(String[] args) {
	
		int getMin = Integer.parseInt(args[0]);									    // Retrieves chosen range		
		int getMax = Integer.parseInt(args[1]);
		
		int firstRandom = getMin + (int)(Math.random()*(getMax - getMin));	        // Generates 3 randoms between [getMin, getMax)
		int secondRandom = getMin + (int)(Math.random()*(getMax - getMin));
		int thirdRandom = getMin + (int)(Math.random()*(getMax - getMin));
		
		int minRandom = Math.min(firstRandom, Math.min(secondRandom, thirdRandom));	// Finds minimal value
		
		
		System.out.println(firstRandom + "\n" + secondRandom + "\n" + thirdRandom); // outputs final conclusions
		System.out.println("The minimal generated number was " + minRandom);		
		
	}
}