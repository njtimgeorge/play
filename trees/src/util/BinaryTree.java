package util;

import java.util.HashSet;
import java.util.Iterator;

public class BinaryTree<T> {
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private BinaryTree<T> parent;

	public T getData() {
		return data;
	}

	public BinaryTree<T> getParent() {
		return parent;
	}

	private T data;
	
	public BinaryTree(T data) {
		this(null, data);
	}
	
	private BinaryTree(BinaryTree<T> parent, T data) {
		this.right = null;
		this.left = null;
		this.parent = parent;
		this.data = data;
	}
	
	public BinaryTree<T> addLeft(T t) {
		left = new BinaryTree<T>(this, t);
		return left;
	}

	public BinaryTree<T> addRight(T t) {
		right = new BinaryTree<T>(this, t);
		return right;
	}

	public void deleteLeft() {
		left = null;
	}
	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void deleteRight() {
		right = null;
	}
	
	public boolean isBalanced() {
		HashSet<Integer> depths = new HashSet<Integer>();
		return isBalanced(depths,0);
	}
	
	private boolean isBalanced(HashSet<Integer> depths, int depth) {
		
		// leaf node: save depth
		if(right == null && left == null) {
			Iterator<Integer> i = depths.iterator();
			
			while(i.hasNext()) {
				if(Math.abs(i.next()-depth) >1) {return false;} 
			}

			depths.add(depth);
		}
		
		if(right != null) {
			if(!right.isBalanced(depths, depth+1)) {
				return false;
			}
		}
		
		if(left != null) {
			if(!left.isBalanced(depths, depth+1)) {
				return false;
			}
		}
		
		return true;
	}
}
