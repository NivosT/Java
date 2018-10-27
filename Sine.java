public class Sine {
	/**
	* Performs & outputs specific sine calculations
	**/
	
	public static void main(String[] args) {
		
		System.out.println("sin(0)       = " + Math.sin(0));				// Each line performs specific sin calc
		System.out.println("sin(1/4 PI)  = " + Math.sin(0.25*Math.PI));		// & prints the given angle + result
		System.out.println("sin(2/4 PI)  = " + Math.sin(0.5*Math.PI));
		System.out.println("sin(3/4 PI)  = " + Math.sin(0.75*Math.PI));
		System.out.println("sin(4/4 PI)  = " + Math.sin(Math.PI));
		System.out.println("sin(5/4 PI)  = " + Math.sin(1.25*Math.PI));
		System.out.println("sin(6/4 PI)  = " + Math.sin(1.5*Math.PI));
		System.out.println("sin(7/4 PI)  = " + Math.sin(1.75*Math.PI));
		System.out.println("sin(8/4 PI)  = " + Math.sin(2*Math.PI));
	}
}