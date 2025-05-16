package Uebung4;

import java.util.Iterator;
import java.util.Stack;

class BinaryTree<T> {
	private T _value;
	private BinaryTree<T> _left;
	private BinaryTree<T> _right;
	
	public BinaryTree(T value) {
		this._value = value;
	}
	
	public BinaryTree<T> getLeft() {
		return this._left;
	}
	
	public BinaryTree<T> getRight() {
		return this._right;
	}
	
	public BinaryTree<T> setLeft(BinaryTree<T> node) {
		this._left = node;
		return node;
	}
	
	public BinaryTree<T> setRight(BinaryTree<T> node) {
		this._right = node;
		return node;
	}
	
	public T getValue() {
		return this._value;
	}
	
	public T setValue(T value) {
		this._value = value;
		return value;
	}
	
	public Iterator<T> iterate(Iterable<T> iter) {
		return iter.iterator();
	}
}

class BinTreeTraversal {
	public static void main(String[] args) {
        /*
            Following is a usage example, creating a binary tree and printing out all values in the order of the given iterator
         */
		
		BinaryTree<Integer> root = new BinaryTree<Integer>(1);
		
		root.setLeft(new BinaryTree<Integer>(2));
		root.setRight(new BinaryTree<Integer>(3));
		
		// Your implementation should be able to perform a for each with the given syntax
		for (int item : new PreorderIterable<Integer>(root)) {
			System.out.println(item);
		}
	}
}

class InorderIterable<T> implements Iterable<T> {
	BinaryTree<T> _root;
	InorderIterable(BinaryTree<T> root) {
		_root = root;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new InorderIterator<>(_root);
	}
}

class InorderIterator<T> implements Iterator<T> {
	Stack<BinaryTree<T>> _stack = new Stack<>();
	
	InorderIterator(BinaryTree<T> root) {
		if (root == null) return;
		_stack.push(root);
		goLeft();
	}
	
	private void goLeft() {
		BinaryTree<T> current = _stack.peek();
		while (current.getLeft() != null) {
			_stack.push(current.getLeft());
			current = current.getLeft();
		}
	}
	
	@Override
	public boolean hasNext() {
		return !_stack.isEmpty();
	}
	
	@Override
	public T next() {
		if (!hasNext()) return null;
		
		BinaryTree<T> current = _stack.pop();
		if (current.getRight() != null) {
			_stack.push(current.getRight());
			goLeft();
		}
		return current.getValue();
	}
}

class PreorderIterable<T> implements Iterable<T> {
	BinaryTree<T> _root;
	
	PreorderIterable(BinaryTree<T> root) {
		_root = root;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new PreorderIterator<>(_root);
	}
}

class PreorderIterator<T> implements Iterator<T> {
	Stack<BinaryTree<T>> _stack = new Stack<>();
	
	PreorderIterator(BinaryTree<T> root) {
		if (root == null) return;
		_stack.push(root);
	}
	
	@Override
	public boolean hasNext() {
		return !_stack.isEmpty();
	}
	
	@Override
	public T next() {
		if (!hasNext()) return null;
		
		BinaryTree<T> current = _stack.pop();
		if (current.getRight() != null) _stack.push(current.getRight());
		if (current.getLeft() != null) _stack.push(current.getLeft());
		return current.getValue();
	}
}