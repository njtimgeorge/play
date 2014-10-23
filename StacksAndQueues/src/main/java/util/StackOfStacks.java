package util;

public class StackOfStacks<T> {
	
	private static final int STACK_SIZE = 10;
	
	private class Stack {
		private Object[] stack;
		private int head;
		private int stackSize;
		
		public Stack() {
			this(STACK_SIZE);
		}
		
		public Stack(int stackSize) {
			this.stackSize = stackSize;
			stack = new Object[stackSize];
			head = -1;
		}
		
		public Object pop() {
			if(head == -1) return null;
			
			return stack[head--];
		}
		
		public void push(Object t) {
			if(isFull()) {
				throw new StackOverflowError("Exceeded max stack size of " + Integer.toString(stackSize));
			} else {
				stack[++head] = t;
			}
		}
		
		public Object peek() {
			if(head == -1) return null;
			
			return stack[head];			
		}
		
		public boolean isFull() {
			return head==stackSize - 1;
		}

		public boolean isEmptyl() {
			return head==-1;
		}
	}
	
	private Stack stacks;
	private Stack curStack;
	
	public StackOfStacks() {
		curStack = null;
		stacks = new Stack(256);
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		T ret = null;
		
		if(curStack != null) {
			ret = (T) curStack.pop();

			if(curStack.isEmptyl()) {
				curStack = (Stack) stacks.pop();
			}
		} // else: if -1, return null
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		T ret = null;
		
		if(curStack != null) {
			ret = (T) curStack.peek();			
		} // else: if -1, return null
		
		return ret;
	}
	
	public void push(T t) {
		if(curStack == null || curStack.isFull()) {
			stacks.push(curStack);
			curStack = new Stack();
		}
		
		curStack.push(t);
	}
	
	//public int getStackCount() {return curStack+1;}
}
