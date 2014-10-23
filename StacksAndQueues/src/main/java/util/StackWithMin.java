package util;

public class StackWithMin<T extends Comparable<T>> {
	private StackNode head;
	private StackNode min;
	
	public StackWithMin() {
		head = null;
		min = null;
	}
	
	private class StackNode {
		T element;
		StackNode next;
		
		public StackNode(T element, StackNode next) {
			this.element = element;
			this.next = next;
		}
	}
	
	public T peek() {
		if(head == null) return null;
		return head.element;
	}
	
	public T pop() {
		StackNode ret = head;
		
		if(head == null) return null;
		
		if(head == min) {
			if(head.next == null) {min = null;}
			else {
				min = head.next;
				for(StackNode n=head.next.next;n!=null;n=n.next) {
					if(n.element.compareTo(min.element) < 0) {min=n;}
				}
			}
		}
		
		head=head.next;
		
		return ret.element;
	}
	
	public void push(T t) {
		head = new StackNode(t,head);
		
		if(min == null) {
			min = head;
		}else if(min.element.compareTo(head.element) > 0) {
			min = head; 
		}
	}
	
	public T min() {
		if(head == null) return null;

		return min.element;
	}
}
