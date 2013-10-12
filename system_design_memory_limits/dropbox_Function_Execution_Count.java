/*Function_Execution_Count
dropbox

Design a function to return how many times hit() has been executed within the
latest five minutes.

Given:
void hit()
long getHits()
*/

public class dropbox_Function_Execution_Count {
	
	/**
	 * Circular Buffer.
	 * http://en.wikipedia.org/wiki/Circular_buffer
	 * The code is not runnable for concurrency senario.
	 */	

	public static void main(String[] args) {
	    
	}

	static class CircularBuffer {

		private int capacity; // Equal to time window in sec.
		private long[] timestamp;
		private long[] count;

		CircularBuffer(int capacity) {
			this.capacity = capacity;	
			this.timestamp = new long[capacity];
			this.count = new long[capacity];
		}

		//
		public long getCount() {
			long ret = 0;
			for (long i : count) {
				ret += i;	
			}
			return i;
		}

		//
		public void update(long ts) {
			int index = ts % this.capacity;
			if (ts - this.timestamp[index] >= this.capacity) {
				this.count[index] = 1;	
			} else {
				++this.count[index];
			}
		}
	}
}

