package util;

import java.util.ArrayList;

public class Tree<T> {
	private ArrayList<Tree> children;
	private Tree<T> parent;
	
	public Tree() {
		this(null);
	}
	
	private Tree(Tree parent) {
		children = new ArrayList<Tree>();
		this.parent = parent;
	}
	
	public add(T t) {
		
	}

}
