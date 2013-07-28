/*Stable_Marriage_Problem
geeksforgeeks

SMP: http://en.wikipedia.org/wiki/Stable_marriage_problem
*/

import java.util.*;


public class Stable_Marriage_Problem {

	/*
	 * Given N men and N women, where each person has ranked all members of the
	 * opposite sex in order of preference, marry the men and women together
	 * such that there are no two people of opposite sex who would both rather
	 * have each other than their current partners. If there are no such people,
	 * all the marriages are “stable”
	 */

	static final int UNASSIGNED = -1;
	
	/* 
	 * Input definition: prefer[][] with 2 * N women and men.
	 * prefer[0:N - 1] is men's preference list and prefer[N:2 * N - 1] is women's.
	 * for a specific man/woman prefer[i] is a int array with length N and elements are
	 * indexes for preferred women/men in order.
	 */
	
	public static void main(String[] args) {
		int[][] prefer;
		// test case 1
		prefer = new int[][] { { 7, 5, 6, 4 }, { 5, 4, 6, 7 }, { 4, 5, 6, 7 },
				{ 4, 5, 6, 7 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 },
				{ 0, 1, 2, 3 }, };
		SMP(prefer);
		// test case 2
		prefer = new int[][] {{2, 3}, {2, 3}, {0, 1}, {0, 1},};
		SMP(prefer);
	}

	public static void SMP(int[][] prefer) {
		int N = prefer[0].length;
		// Sanity check.
		if (prefer.length != 2 * N) {
			System.out.println("Invalid prefer matrix");
			return;
		}
		// Initialize state vars.
		int[] wPartner = new int[N]; // Women's list
		boolean[] mFree = new boolean[N]; // Availability of men.
		Arrays.fill(wPartner, UNASSIGNED);
		int freeCount = N, m, i, w, m1;

		// For all available free men.
		while (freeCount > 0) {
			// Find the free man.
			for (m = 0; m < N; ++m) {
				if (!mFree[m]) {
					break;
				}
			}
			// Iterate through free man's preference list.
			for (i = 0; i < N && !mFree[m]; ++i) {
				w = prefer[m][i];
				m1 = wPartner[w - N]; //
				//:param w - n: index transform from prefer to wPartner.
				if (m1 == UNASSIGNED) {
					wPartner[w - N] = m;
					mFree[m] = true;
					--freeCount;
				// If w prefers m over her current engagement m1,
	            // then break the engagement between w and m1 and
	            // engage m with w.
				} else if (!wPreferesM1OverM(prefer[w], m, m1)) {
						wPartner[w - N] = m;
						mFree[m] = true;
						mFree[m1] = false;
				} // else continue.
			}
		}
		// STDOUT
		System.out.println("Woman\tMan");
		for (i = 0; i < N; ++i) {
			System.out.println((i + N) + "\t" + wPartner[i]);
		}
	}

	// Given women's preference list, return if m1 is preferred over m.
	public static boolean wPreferesM1OverM(int[] wPrefer, int m, int m1) {
		int N = wPrefer.length, i;
		for (i = 0; i < N; ++i) {
			if (wPrefer[i] == m1 || wPrefer[i] == m) {
				return wPrefer[i] == m1;
			}
		}
		return false;
	}
}
