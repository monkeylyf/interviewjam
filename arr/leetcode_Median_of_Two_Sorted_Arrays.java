/*Median_of_Two_Sorted_Arrays

There are two sorted arrays A and B of size m and n respectively. Find the
median of the two sorted arrays. The overall run time complexity should be
O(log (m+n)).
*/

class leetcode_Median_of_Two_Sorted_Arrays {

  public static void main(String[] args) {
	System.out.println(findMedianSortedArrays(new int[] {4}, new int[] {1,2,3}));
	//System.out.println(findMedianSortedArrays(new int[] {1}, new int[] {1}));
	//System.out.println(get(new int[] {1, 2, 3}, 0, 0, 1));
	//System.out.println(get(new int[] {2, 3}, 0, 0, 1));
	//System.out.println(get(new int[] {1}, 0, 0, 1));
	//System.out.println(get(new int[] {}, 0, 0, 1));
  }

  /** The idea is find the kth largest element in A and B.
   *  
   *  The cool thing about the solution below is getting rid of the median
   *  concept since median brings even/odd length problem.
   *  Simply finding the kth largest element will help write clean code.
   *
   */
  public double findMedianSortedArrays(int A[], int B[]) {
	int n = A.length;
	int m = B.length;
	int mid = (n + m) / 2;
	if ((n + m) % 2 == 0) {
      // Length sum is even, find two elements.
	  return (find(A, n, B, m, mid - 1) + find(A, n, B, m, mid)) / 2.0;
	} else {
	  return find(A, n, B, m, mid);
	}
  }

  public double find(int[] A, int n, int[] B, int m, int th) {
	if (n == 0) { return B[th]; }
	if (m == 0) { return A[th]; }

	int midA = (n - 1) / 2;
	int midB = (m - 1) / 2;

	// Assuming A[midA] < B[midB] so keep code clean.
	if (A[midA] < B[midB]) { return find(B, m, A, n, th); }
	
	// Example:
	// A:      a0, a1, a2, a3, a4
	// B:  b0, b1, b2, b3, b4, b5, b6
	// midA = 2 and midB = 3 and A[2] >= A[3]
	if (midA + 1 + midB + 1 <= th + 1) {
	  // th >= 6. What are those elements that th will never ever be in?
	  // (b0..b3) <= (a2) <= (a3 a4) is know. Where (b4b5b6) can be? Can be anywhere between(b3, a2..a4) 
	  // Can not dump any a because when b4b5b6 are between b3 and a2 when kth will be in a2-a4
	  // Conclusion: It's only safe to dump b0b1b2b3.
	  return find(A, n, Arrays.copyOfRange(B, midB + 1, m), m - (midB + 1), th + 1 - (midB + 1) - 1);
	} else {
	  // Same idea. It's only safe to dump a3, a4
	  return find(A, midA, B, m, th);
	}
  }

  /* The solution below is obsolete.*/
  public static double MedianOfFour(int a, int b, int c, int d) {
	int min = Math.min(d, Math.min(c, Math.min(b, a)));
	int max = Math.max(d, Math.max(c, Math.max(b, a)));
	return (a + b + c + d - min - max) / 2.0;
  }

  public static double MedianOfThree(int a, int b, int c) {
	int min = Math.min(c, Math.min(b, a));
	int max = Math.max(c, Math.max(b, a));
	return (a + b + c - min - max);
  }

  public static double findMedianSortedArrays(int[] A, int[] B) {
	if (B.length >= A.length) {
	  return medianSortedArrays(A, B);
	} else {
	  return medianSortedArrays(B, A);
	}
  }

  public static double medianSortedArrays1(int[] A, int[] B) {
	int n = A.length;
	int m = B.length;
	if (n == 0) {
	  if (m % 2 == 1) {
		return B[m / 2];
	  } else {
		return (B[m / 2 - 1] + B[m / 2]) / 2.0;
	  }
	} else if (n == 1) {
	  if (m == 1) {
		return (A[0] + B[0]) / 2.0;
	  } else if (m % 2 == 1) { // m is odd.
		return (B[m / 2] + MedianOfThree(A[0], B[m / 2 - 1], B[m / 2 + 1])) / 2.0;
	  } else { // m is even.
		return MedianOfThree(A[0], B[m / 2 - 1], B[m / 2]);
	  }
	} else if (n == 2) {
	  if (m == 2) {
		return MedianOfFour(A[0], A[1], B[0], B[1]);
	  }
	  if (m % 2 == 1) { // m is odd.
		return MedianOfThree(B[m / 2], Math.min(A[0], B[m / 2 + 1]), Math.max(A[1], B[m / 2 - 1]));
	  } else { // m is even.
		return MedianOfFour(B[m / 2 - 1], B[m / 2], Math.min(A[0], B[m / 2 + 1]), Math.max(A[1], B[m / 2 - 2]));
	  }
	}
	int minRemoved = 0, idxA = n / 2, idxB = m / 2;
	if (A[idxA] < B[idxB]) {
	  if (n % 2 == 0) {
		--idxA;
	  }
	  minRemoved = Math.min(idxA, m - idxB - 1);
	  return medianSortedArrays(Arrays.copyOfRange(A, minRemoved, A.length), Arrays.copyOfRange(B, 0, B.length - minRemoved));
	} else {
	  if (m % 2 == 0) {
		--idxB;
	  }
	  minRemoved = Math.min(n - idxA - 1, idxB);
	  return medianSortedArrays(Arrays.copyOfRange(A, 0, A.length - minRemoved), Arrays.copyOfRange(B, minRemoved, B.length));
	}
  }
}



/* Python version 
http://blog.csdn.net/sigh1988/article/details/12192299
Time complexity O(lgm + lgn)

def findMedianSortedArrays(self, A, B):
    m = len(A)
    n = len(B)
    mid = (m + n) / 2
    if (m + n) % 2  == 1:
        return self.find(A, m, B, n, mid)
    else:
        left = right - 1
        return (self.find(A, m, B, n, mid - 1) + self.find(A, m, B, n, mid)) / 2.0
        
def find(self, A, m, B, n, th):
    if m == 0:
        return B[th]
    if n == 0:
        return A[th]
    
    mida = (m - 1) / 2
    midb = (n - 1) / 2
    if A[mida] < B[midb]:
        return self.find(B, n, A, m, th)
    # else A[mida] >= B[mida]
    if mida + 1 + midb + 1 <= th + 1:
        return self.find(A, m, B[midb + 1:], n - (midb + 1), (th + 1) - (midb + 1) - 1)
    else:
        return self.find(A, mida, B, n, th)
*/
