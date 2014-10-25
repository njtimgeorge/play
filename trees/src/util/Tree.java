package util;

import java.util.ArrayList;

public class Tree<T> {
	private ArrayList<Tree<T>> children;
	private Tree<T> parent;
	public Tree<T> getParent() {
		return parent;
	}

	private T data;
	
	public Tree(T data) {
		this(null, data);
	}
	
	private Tree(Tree<T> parent, T data) {
		children = new ArrayList<Tree<T>>();
		this.parent = parent;
		this.data = data;
	}
	
	public void add(T t) {
		children.add(new Tree<T>(this, t));
	}

	public void delete(int childNdx) {
		if(children.size() > childNdx)
			children.remove(childNdx);
	}
	
	public int getChildCount() {return children.size();}
	
	public Tree<T> getChild(int childNdx){
		Tree<T> ret = null;
		
		if(children.size() > childNdx)
			ret = children.get(childNdx);
			
		return ret;
	}

	public T getChildData(int childNdx){
		T ret = null;
		
		if(children.size() > childNdx)
			ret = children.get(childNdx).data;
			
		return ret;
	}

}
