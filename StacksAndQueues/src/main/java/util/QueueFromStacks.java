package util;

import java.util.Stack;

public class QueueFromStacks<T> {
	private Stack<T> lifo; // stack ordered
	private Stack<T> fifo; // queue ordered
	
	public QueueFromStacks() {
		lifo = new Stack<T>();
		fifo = new Stack<T>();
	}

	public void enqueue(T t) {
		while(!fifo.isEmpty()) { 
			lifo.push(fifo.pop());
		}
		
		lifo.push(t);
	}
	
	public T dequeue() {
		if(fifo.isEmpty() && lifo.isEmpty()) return null;
		
		if(fifo.isEmpty()) {
			while(!lifo.isEmpty()) fifo.push(lifo.pop());
		}
		
		return fifo.pop();
	}
}
