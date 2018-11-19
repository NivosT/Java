import java.util.Arrays;

/**
* Assignment number: 4.2
* File name: Primes.java
* Name: Niv Tennenbaum
* Student ID: 312458904
* Email: niv.tennenbaum@post.idc.ac.il
*
* Applies the Eratosthenes algorithm to all numbers from 2 to N (received as args[0]
* Prints all found primes up to N
*/
public class Primes {
	public static void main(String[] args) {		
		// Gets the max number and initializes array
		int getN = Integer.parseInt(args[0]);
		boolean[] isPrime = new boolean[getN + 1];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i <= Math.sqrt(getN); i++) {
			//skips prior defined non prime numbers
			if (isPrime[i] == true) {
				for (int j = i*i; j <= getN; j += i) {
					isPrime[j] = false; // Sets as false all multiplies of primes
				}
			}
		}
		// Prints results
		System.out.println("The prime numbers up to " + getN + " are:");
		for (int k = 2; k <= getN; k++) {
			if (isPrime[k] == true) {
				System.out.println(k);
			}
		}
	}
}