package util;

public class Stack<T> {
	// if no storage specified
	
	private static final int STACK_MAX=256;
	
	// storage
	private int min, size;
	private T[] data;
	
	// head and tail of stack
	private int head;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		data = (T[])new Object[STACK_MAX];
		min=0;
		size=STACK_MAX;
		head=-1;
	}
	
	public Stack(T[] data, int min, int size) {
		this.data = data;
		this.min=min;
		this.size=size;
		head= min-1;
	}
	
	public T peek() {
		if(head < min) return null;
		
		return data[head];
	}
	
	public void push(T t) {
		// check for overflow
		if(head+1 >= min + size) {
			throw new StackOverflowError("Stack exceeded maximum size " + Integer.toString(size));
		}
		
		// advance head
		
		head++;
		
		// place item
		data[head] = t;
	}
	
	public T pop() {
		T ret=null;
		
		// check for item
		if(head >= min) {

			// return item
			ret = data[head];
			// decrement (will set to min-1 if empty)
			head--;
		}
		return ret;
	}
}
