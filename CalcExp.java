public class CalcExp {
	/**
	* Given x, N as args (in this order) calculates e^x
	* with both math.exp() func and MacLaurin method
	**/
	
	public static void main(String[] args) {
	
		double getX = Double.parseDouble(args[0]);			// Retrieves user choices
		int getN = Integer.parseInt(args[1]);
		
		double javaCalc = Math.exp(getX);					// Calc of Java func for e^x
			
		double macCalc = 1.0;
		double facto = 1.0;
		double incX	= 1.0;									// set starting stat for loop vars
		
		for (int i = 1; i<=getN && getX>0; i++) {
			incX = incX * getX;								// Calc of MacLaurin: 1+x^1/1! + .. + x^N/N!
			facto = facto * i;								// For x=0, loop overruled. macCalc==1.0
			macCalc = macCalc + (incX / facto);
			
		}

		
		System.out.println("e raised to the power of " + getX + " according to Java: " + javaCalc);																		  
		System.out.println("Same, using MacLaurin approximation with " + getN + " steps: " + macCalc); 
															// outputs final conclusions 
	}
}