public class FVCalc {
	/**
	* Given $ sum, annual rate, years amount as args (in this order)
	* Outputs the future value according to the formula:
	* $ X (1 + rate)^years
	**/
	
	public static void main(String[] args) {
	
		int getSum = Integer.parseInt(args[0]); 	       						   // Retrieves user choices
		double getRate = Double.parseDouble(args[1]);
		int getYears = Integer.parseInt(args[2]);
		
		double numericalRate = getRate /100;				                       // Sets given rate as numerical
		
		double futureValue = getSum * Math.pow((1 + numericalRate), getYears);     // Computes the FV
												      
		
		System.out.println("After " + getYears + " years, $" +  getSum + " saved at " + getRate + "% will yield $" + futureValue);																		  
																				   // outputs final conclusion 
	}
}