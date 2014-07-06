import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private int size;
	private Node head;
	private Node tail;

	/**
	 * construct an empty deque.
	 */
	public Deque() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * is the deque empty?
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * return the number of items on the deque.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * insert the item at the front.
	 */
	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException("Can not add null item to first");
		}

		Node node = new Node(item);
		if (isEmpty()) {
			this.tail = node;
		} else {
			link(node, this.head);
		}

		this.head = node;
		++this.size;
	}

	/**
	 * insert the item at the end.
	 */
	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException("Can not add null item to last");
		}

		Node node = new Node(item);
		if (isEmpty()) {
			this.head = node;
		} else {
			link(this.tail, node);
		}

		this.tail = node;
		++this.size;
	}

	/**
	 */
	private void link(Node a, Node b) {
		a.next = b;
		b.prev = a;
	}

	/**
	 */
	private void unlink(Node a, Node b) {
		a.next = null;
		b.prev = null;
	}

	/**
	 * delete and return the item at the front.
	 */
	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException(
					"Can not remove the first from an empty deque");
		}

		Node node = this.head;
		if (size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			unlink(node, this.head);
		}

		--this.size;

		return node.item;
	}

	/**
	 * delete and return the item at the end.
	 */
	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException(
					"Can not remove the last from an empty deque");
		}

		Node node = this.tail;
		if (size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.prev;
			unlink(this.tail, node);
		}

		--this.size;
		return node.item;
	}

	/**
	 * return an iterator over items in order from front to end.
	 */
	@Override
	public Iterator<Item> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Item> {

		private Node cursor = head;

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("Can not call next(). Next is null");
			}
			Item item = cursor.item;
			cursor = cursor.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"Does not support remove operation");
		}

	}

	private class Node {

		private Node prev;
		private Node next;
		private final Item item;

		Node(Item item) {
			this.prev = null;
			this.next = null;
			this.item = item;
		}

	}

	/**
	 * unit testing
	 */
	public static void main(String[] args) {
		Deque<String> deque = new Deque<>();
		for (int i = 33; i < 133; ++i) {
			System.out.println(i + ": " + Character.toString((char) i));
			deque.addFirst(Character.toString((char) i));
		}

		for (int i = 33; i < 133; ++i) {
			System.out.println(i + ": " + deque.removeFirst());
		}
	}
}