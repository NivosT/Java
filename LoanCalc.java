/**
* Calculates the periodical payment necessary to re-pay a given loan
*/
public class LoanCalc {
	
	static int iterationCounter;  // monitors the efficiency of the calculation
	
   	/** Gets the loan data and computes the periodical payment,
	*   using two methods: brute force search, and bisection search.  
	*/
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		
		double epsilon = 0.001;  // the computation tolerance / accuracy
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment: ");
		System.out.printf("%.2f",solveByBruteForceSearch(loan,rate,n,epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment: ");
		System.out.printf("%.2f",solveByBisectionSearch(loan,rate,n,epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a brute force search method to compute an approximation of
	* the periodical payment that will bring the ending balance of a loan to 0.
	* Given: the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
	public static double solveByBruteForceSearch(double loan, double rate, int n, double epsilon) {  
    		iterationCounter = 0; // reset static counter
    		double x = loan / n;
    	
    		while ((endBalance(loan, rate, n, x)) > 0) {
    			iterationCounter++;
    			x += epsilon;
    		}
    		return x;
   	 }
    
    /**
	* Uses a bisection search method to compute an approximation of
	* the periodical payment that will bring the ending balance of a loan to 0.
	* Given: the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
	public static double solveByBisectionSearch(double loan, double rate, int n, double epsilon) {  
    		iterationCounter = 0; // reset static counter
    		double hi = loan;
    		double lo = 0;
    		double mid = (hi + lo) / 2;
    	
    		while ((hi - lo)/2 > epsilon) {
    			iterationCounter++;
    			// sets hi && lo for the next iteration
    			if (((endBalance(loan, rate, n, lo)) * (endBalance(loan, rate, n, mid))) > 0) {
    				lo = mid;
    			}
    			else {
    				hi = mid;
    			}
    			mid = (lo + hi) / 2;
    		}
        	return lo;
	}
	
	/**
	* Computes the ending balance of a loan, given: the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
		for (;n > 0; n--) {
			loan = (loan - payment) * (rate/100 + 1);
		}
        return loan;
	}
}
