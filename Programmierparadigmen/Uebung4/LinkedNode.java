package Uebung4;

public class LinkedNode<E extends Comparable<E>> {
    private Node<E> _head;
    private int _length;
	
	private class Node<E extends Comparable<E>> {
		
		private E item;      // reference to the item stored at this node
		private Node<E> nextNode;    // reference to the subsequent node in the list
		
		private Node() {
			this(null, null);
		}
		
		private Node(E element, Node<E> next) {
			item = element;   // creates a node with the given item
			nextNode = next;  // and next mode.
		}
		
		public E getElement() {
			return item;
		} // Accessor methods
		
		public Node<E> getNextNode() {
			return nextNode;
		}
		
		public void setElement(E element) {
			this.item = element;
		}
		
		public void setNextNode(Node<E> Node) {
			this.nextNode = Node;
		}
	}
	
	public LinkedNode() {
		_head = null;
		_length = 0;
	}
	
	public void insert(E item) {
		if (_head == null) {
			_head = new Node<>(item, null);
			_length++;
			return;
		}
		Node<E> current = _head;
		while (item.compareTo(current.getElement()) >= 0) {
			if (current.getNextNode() == null) {
				current.setNextNode(new Node<>(item, null));
				_length++;
				return;
			}
			current = current.getNextNode();
		}
		E oldValue = current.getElement();
		current.setElement(item);
		current.setNextNode(new Node<>(oldValue, current.getNextNode()));
		_length++;
	}
	
	public boolean contains(E item) {
		if (_head == null) return false;
		Node<E> node = _head;
		while (node != null) {
			if (node.getElement().equals(item)) return true;
			node = node.getNextNode();
		}
		return false;
	}
	
	public int getLength() {
		return _length;
	}
	
	public String toString() {
		if (_head == null) return "[]";
		StringBuilder sb = new StringBuilder("[");
		Node<E> node = _head;
		while (node != null) {
			sb.append(node.getElement());
			sb.append(", ");
			node = node.getNextNode();
		}
		sb.delete(sb.lastIndexOf(","), sb.length());
		sb.append(']');
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		LinkedNode<Integer> ex1 = new LinkedNode<>();
		ex1.insert(1);
		ex1.insert(5);
		ex1.insert(3);
		ex1.insert(3);
		ex1.insert(2);
		ex1.insert(4);
		System.out.println(ex1);
	}
}