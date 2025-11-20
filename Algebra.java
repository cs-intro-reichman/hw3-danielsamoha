// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int mone = 0;
		for (int i =0 ; i < x1 + x2 ; i++){
			mone++;
		}
		return mone;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int mone = 0;
		for (int i =0 ; i < x1 ; i++){
			mone++;
		}
		for (int i =0 ; i < x2 ; i++){
			mone--;
		}
		return mone;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int mone = 0;
		for (int i =0 ; i < x2 ; i++){
			for (int j =0 ; j < x1 ; j++){
			    mone++;
		    }
		}
		return mone;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int mone = x;
		for (int i =0 ; i < n - 1 ; i++){
			mone = times(mone, x);
		}
		return mone;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int mone = 0;
		int x = x1;
		while (x >= x2) {
			x = minus(x, x2);
			mone++;
		}
		return mone;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int x = x1;
		while (x >= x2) {
			x = minus(x, x2);
		}
		return x;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int last = 0;
		for (int i = 0 ; i < x ; i++){
			if (x == times(i,i)){
				return i;
			}
			if(times(i,i) > x){
				return last;
			}
			last = i;
		}
		return last;
	}	  	  
}