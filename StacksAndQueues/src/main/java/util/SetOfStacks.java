package util;

import java.util.ArrayList;

public class SetOfStacks<T> {
	
	private static final int STACK_SIZE = 10;
	
	private class Stack {
		private Object[] stack;
		private int head;
		
		public Stack() {
			stack = new Object[STACK_SIZE];
			head = -1;
		}
		
		@SuppressWarnings("unchecked")
		public T pop() {
			if(head == -1) return null;
			
			return (T) stack[head--];
		}
		
		public void push(T t) {
			if(isFull()) {
				throw new StackOverflowError("Exceeded max stack size of " + Integer.toString(STACK_SIZE));
			} else {
				stack[++head] = t;
			}
		}
		
		@SuppressWarnings("unchecked")
		public T peek() {
			if(head == -1) return null;
			
			return (T) stack[head];			
		}
		
		public boolean isFull() {
			return head==STACK_SIZE - 1;
		}

		public boolean isEmptyl() {
			return head==-1;
		}
	}
	
	private ArrayList<Stack> stacks;
	private int curStack;
	
	public SetOfStacks() {
		curStack = -1;
		stacks = new ArrayList<Stack>();
	}
	
	public T pop() {
		T ret = null;
		
		if(curStack != -1) {
			ret = stacks.get(curStack).pop();
			
			if(stacks.get(curStack).isEmptyl()) {
				stacks.remove(curStack--);
			}
		} // else: if -1, return null
		
		return ret;
	}
	
	public T peek() {
		T ret = null;
		
		if(curStack != -1) {
			ret = stacks.get(curStack).peek();			
		} // else: if -1, return null
		
		return ret;
	}
	
	public void push(T t) {
		if(curStack == -1 || stacks.get(curStack).isFull()) {
			stacks.add(new Stack());
			curStack++;
		}
		
		stacks.get(curStack).push(t);
	}
	
	public T popAt(int i) {
		T ret = null;
		
		if(i <= curStack) {
			ret = stacks.get(i).pop();
			
			if(stacks.get(i).isEmptyl()) {
				stacks.remove(i);
				curStack--; // we have one less stack
			}
		} // else return null
		
		return ret;
	}
	
	public int getStackCount() {return curStack+1;}
}
