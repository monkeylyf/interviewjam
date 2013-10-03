/*Gas_Station
leetcode

There are N gas stations along a circular route, where the amount of gas at
station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
from station i to its next station (i+1). You begin the journey with an empty
tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit
once, otherwise return -1.
*/


public class leetcode_Gas_Station {

	/*
	 * Key notes:
	 * 1. 'Travel around the circuit once' I think it means visit each node once.
	 * 2. No-brainer solution is try every node as a start point. O(n^2)
	 * 3. I think you can only go clockwise though the question deosn't mention.
	 * 4. We can do O(n).
	 * 
	 */
	
	public static void main(String[] args) {
		
	}

	/*
	1. If you travel from a0 to a1...an and find you run out of gas before reaching an,
	   then you can start your journey neither from a1, nor from a2..an-1. Why?
	2. If sum(cost) + sum(gas) >= 0, then there must be at least one gas station you can
	   start from. Vice versa, if sum(cost) + sum(gas) < 0 then there will be no solution
	   at all. Why?
	*/
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int localSum = 0, total = 0, valley = -1, i;
		for (i = 0; i < gas.length; ++i){
			localSum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (localSum < 0) {
				valley = i; // Reset starting point.
				localSum = 0; // Reset local sum.
			}
		}
		return (total >= 0) ? j + 1 : -1;
	}
}
