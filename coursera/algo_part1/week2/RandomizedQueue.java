import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int capacity;
	private int size;
	private Item[] queue;

	/**
	 * construct an empty randomized queue
	 */
	public RandomizedQueue() {
		this.capacity = 8;
		this.size = 0;
		this.queue = (Item[]) new Object[this.capacity];
	}

	/**
	 * is the queue empty?
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 *
	 * return the number of items on the queue
	 */
	public int size() {
		return this.size;
	}

	/**
	 * add the item
	 */
	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException("Can not enqueue null");
		}
		this.queue[size()] = item;
		++this.size;

		if (size() == this.capacity) {
			resize(2 * this.capacity);
		}
	}

	/**
	 * delete and return a random item
	 */
	public Item dequeue() {
		if (size() == 0) {
			throw new NoSuchElementException("Can not dequeue an empty queue");
		}
		int index = StdRandom.uniform(size());

		Item res = this.queue[index];
		this.queue[index] = this.queue[size() - 1];
		this.queue[size() - 1] = null;
		--this.size;

		if (this.capacity > 8 && this.size * 4 <= this.capacity) {
			resize(this.capacity / 2);
		}

		return res;
	}

	private void resize(int newSize) {
		Item[] newQueue = (Item[]) new Object[newSize];
		for (int i = 0; i < Math.min(newSize, size()); ++i) {
			newQueue[i] = this.queue[i];
		}

		this.capacity = newSize;
		this.queue = newQueue;
		// System.out.println("resizing to " + this.capacity + " size " +
		// this.size);
	}

	/**
	 *
	 * return (but do not delete) a random item
	 */
	public Item sample() {
		if (size() == 0) {
			throw new NoSuchElementException("Can not sample an empty queue");
		}
		return this.queue[StdRandom.uniform(size())];
	}

	@Override
	public Iterator<Item> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Item> {
		private int i = 0;
		private final Item[] copy = initCopy();

		private Item[] initCopy() {
			Item[] copy = Arrays.copyOf(queue, size());
			StdRandom.shuffle(copy);
			return copy;
		}

		@Override
		public boolean hasNext() {
			return i < size();
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("Can not call next(). Next is null");
			}
			Item item = copy[i];
			++i;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove method not supported");
		}

	}

	/**
	 * unit testing
	 */
	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		for (int i = 0; i < 256; ++i) {
			rq.enqueue(Character.toString((char) i));
		}
	}
}
