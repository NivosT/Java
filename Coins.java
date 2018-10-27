public class Coins {
	/**
	* Receives quantity of cents from args[0]
	* outputs the amount in quarters (worth 25 cents)
	* and the remainder as cents
	**/
	
	public static void main(String[] args) {
	
		int getQuantity = Integer.parseInt(args[0]); 		 // Retrieves given cents amount
		
		int quarters = getQuantity /25;				 // Calculates no. of quarters & cents
		int cents = getQuantity %25;				
		
		System.out.println("Use " + quarters + " quarters and " + cents + " cents");											 
									 // outputs final conclusion
		
	}
}
