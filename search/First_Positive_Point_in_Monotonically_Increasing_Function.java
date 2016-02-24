/*First_Positive_Point_in_Monotonically_Increasing_Function
geeksforgeeks

Given a function ‘int f(unsigned int x)’ which takes a non-negative
integer ‘x’ as input and returns an integer as output. The function is
monotonically increasing with respect to value of x, i.e., the value of
f(x+1) is greater than f(x) for every input x. Find the value ‘n’ where
f() becomes positive for the first time. Since f() is monotonically
increasing, values of f(n+1), f(n+2),… must be positive and values of
f(n-2), f(n-3), .. must be negative. Find n in O(logn) time, you may
assume that f(x) can be evaluated in O(1) time for any input x.
*/


import java.lang.reflect.*;


public class First_Positive_Point_in_Monotonically_Increasing_Function {

	/**
	 */
	public static void main(String[] args) throws Exception{
		// This part is kinda irrelavent. java reflection example.
        Class[] parameterTypes = new Class[1];
        parameterTypes[0] = String.class;
        Method method1 = First_Positive_Point_in_Monotonically_Increasing_Function.class.getMethod("method1", parameterTypes);

        First_Positive_Point_in_Monotonically_Increasing_Function demo = new First_Positive_Point_in_Monotonically_Increasing_Function();
        demo.method2(demo, method1, "Hello World");

		// test. Shoudl print 5.
		demo.solve();
    }

    public void method1(String message) {
        System.out.println(message);
    }

    public void method2(Object object, Method method, String message) throws Exception {
        Object[] parameters = new Object[1];
        parameters[0] = message;
        method.invoke(object, parameters);
    }
    
    public int f(int x) {
    	return 2 * x - 9;
    }
    
    public void solve() {
    	if (f(0) > 0) {
    		System.out.println(0);
    	} else {
    		int x = 1;
    		while (f(x) <= 0) {
    			x = 2 * x;
    		}
    		System.out.println(binarySearch(x / 2, x));
    	}
    }
    
    public int binarySearch(int head, int tail) {
    	if (head > tail) {
    		return -1;
    	} else {
    		int mid = (tail - head) / 2 + head;
    		if (f(mid) > 0 && (f(mid - 1) <= 0 || mid == head)) {
    			return mid;
    		} else if (f(mid) <= 0) {
    			return binarySearch(mid + 1, tail);
    		} else {
    			return binarySearch(head, mid - 1);
    		}
    	}
    }
}
