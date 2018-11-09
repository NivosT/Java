/** 
* Performs various array operations
*/
public class ArrayOps {

	public static void main(String[] args) {
		
		//test_printArr();
		test_maxArr();
	}	
	
	public static void test_printArr() {
		int[] a = {2,  1,  9,  7,  0};
		printArr(a); 
	}
	
	public static void test_maxArr() {
		int[] a = {2,  1,  9,  7,  5};
		int[] b = {3,  0,  8, 11, -1, 9 ,-2};
		int[] maxArr = maxArr(a,b);
		System.out.print("a = "); printArr(a); 
		System.out.print("b = "); printArr(b); 
		System.out.print("max = "); printArr(maxArr); 
	}	
	
	/** Returns an array whose elements are the maxima of the respective elements of the 
	 *  two given arrays. The size of the returned array is the size of the longer array.
	 *  For example, if the two given arrays are [3,4,1] and [2,6,8,5,1], returns [3,6,8,5,1]. 
	 */
	public static int[] maxArr(int[] a, int[] b) {

		int[] maxArr = new int[Math.max(a.length, b.length)];			// Define new array, num of elements as the bigger set
																			// If sets are equal, that would be the amount
		for (int i = 0; i <= (Math.min(a.length, b.length) - 1); i++) { 
			maxArr[i] = Math.max(a[i], b[i]);				// Assigns to new array a corresponding element
		}																	// the bigger one
																			// stops at last element of shorter set
		int[] bigSet = a;
		int[] smallSet = b;
		if (b.length > a.length) {
			bigSet = b;
			smallSet = a;							// Defining the bigger/smaller arrays
		}																	
																			
		for (int j = (smallSet.length); j <= (bigSet.length - 1); j++) {	// copying the rest of the big array to new array
			maxArr[j] = bigSet[j];
		}
		
	return maxArr;
	}
		
	/** Prints the given array in one line, with space separators, 
	 *  and then skips to the next line.
	 */
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
	    }
		System.out.println();
	}
}
