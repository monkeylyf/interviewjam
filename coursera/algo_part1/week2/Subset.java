public class Subset {

	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<>();

		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			rq.enqueue(s);
		}

		int k = Integer.parseInt(args[0]);
		for (int i = 0; i < k; ++i) {
			StdOut.println(rq.dequeue());
		}
	}

}
