/*Circur_Tower
careercup

A circus is designing a tower routine consisting of people standing atop one
another’s shoulders. For practical and aesthetic reasons, each person must be
both shorter and lighter than the person below him or her. Given the heights
and weights of each person in the circus, write a method to compute the
largest possible number of people in such a tower.
EXAMPLE:
input (ht,wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
output: The longest tower is length 6 and includes from top to bottom:
(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
*/

import java.util.Arrays;


public class cap_Circur_Tower {

	public static void main(String[] args) {
		// Test case
		int[] height = new int[] {65, 70, 56, 75, 60, 68};
		int[] weight = new int[] {100, 150, 90, 190, 95, 110};
		People[] tower = new People[height.length];
		for (int i = 0; i < height.length; ++i) {
			tower[i] = new People(height[i], weight[i]);	
		}
		Arrays.sort(tower);
		for (People p : tower) {
			System.out.print(p + " ");	
		}
		System.out.println();
	}

	static class People implements Comparable<People>{
		int h;
		int w;

		People(int h, int w) { // Constructor.
			this.h = h;
			this.w = w;
		}

		// Implement two sorting keys.
		public int compareTo(People other) {
			if ((this.h > other.h) && (this.w > other.w)) {
				return 1;	
			} else if ((this.h == other.h) && (this.w == other.w)) {
				return 0;	
			} else {
				return -1;	
			}
		}

		public String toString() {
			return String.format("<%d,%d>", this.h, this.w);
		}
	}
}
