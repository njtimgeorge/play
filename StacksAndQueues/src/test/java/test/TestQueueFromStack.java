package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.QueueFromStacks;

public class TestQueueFromStack {

	// empty
	// enqueue/dequeue
	// enqueue sequence/dequeue
	
	// intermingled enqueue/dequeue
	
	@Test
	public void testEmptyDeq() {
		QueueFromStacks<Integer> q = new QueueFromStacks<Integer>();
		
		assertNull(q.dequeue());
	}

	@Test
	public void testEnqDeq() {
		QueueFromStacks<Integer> q = new QueueFromStacks<Integer>();
		
		q.enqueue(1);
		
		assertEquals(1,q.dequeue().intValue());
	}

	@Test
	public void testEnqDeq256() {
		QueueFromStacks<Integer> q = new QueueFromStacks<Integer>();
		
		for(int i=0; i<256;i++)
			q.enqueue(i);

		for(int i=0; i<256;i++)
			assertEquals(i,q.dequeue().intValue());

	}

	@Test
	public void testEnqDeqMingle() {
		QueueFromStacks<Integer> q = new QueueFromStacks<Integer>();
		
		int j=0;
		
		for(int i=0; i<256;i++) {
			if(i > 0 && i%3 == 0) {
				assertEquals(j++,q.dequeue().intValue());				
			}
			q.enqueue(i);
		}

		for(int i=j; i<256;i++)
			assertEquals(i,q.dequeue().intValue());

		assertEquals(null,q.dequeue());
	}

}
