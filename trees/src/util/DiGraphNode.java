package util;

import java.util.ArrayList;

public class DiGraphNode<T> {
	private ArrayList<DiGraphNode<T>> children;
	private T data;
	
	public DiGraphNode(T data)  {
		children = new ArrayList<DiGraphNode<T>>();
		this.data = data;
	}
	
	public DiGraphNode<T> addChild(DiGraphNode<T> t) {
		children.add(t);
		return t;
	}
	
	// checks for a path from either
	
	public boolean pathTo(DiGraphNode<T> t) {
		return pathTo(this, t) || t.pathTo(t, this);
	}

	private boolean pathTo(DiGraphNode<T> orig,DiGraphNode<T> t) {
		
				
		if(this == t) return true;
		
		for(DiGraphNode<T> n: children) {
			if(n != orig){ // test for cycle
				if(n.pathTo(orig, t)) return true;
			}
		}
		return false;
	}

}
