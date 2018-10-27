public class LinearEq {
	/**
	* given a, b, c values as args (in this order):
	* outputs X value as formed in: a*x + b = c
	* Assumed: x != 0, args are valid no.
	**/
	
	public static void main(String[] args) {
	
		double getA = Double.parseDouble(args[0]);			// Retrieves user choices		
		double getB = Double.parseDouble(args[1]);
		double getC = Double.parseDouble(args[2]);
		
		double xResult = (getC - getB) /getA;				// Solves for X
		
		
		System.out.println(getA + " * x + " + getB + " = " + getC);
		System.out.println("x = " + xResult);				// outputs equation & final result
			
	}
}