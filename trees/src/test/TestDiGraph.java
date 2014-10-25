package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.DiGraphNode;

public class TestDiGraph {

	// graph with cycle, no connection
	// graph with cycle and connection
	
	// 1 node
	@Test
	public void testSmallGraph() {
		DiGraphNode<Integer> x = new DiGraphNode<Integer>(1); 
		DiGraphNode<Integer> y = new DiGraphNode<Integer>(2);
		
		assertFalse(x.pathTo(y));
	}

	// no connection
	@Test
	public void testNoConnections() {
		DiGraphNode<Integer> x = new DiGraphNode<Integer>(1); 
		DiGraphNode<Integer> y = new DiGraphNode<Integer>(2);

		int i=10;
		x.addChild(new DiGraphNode<Integer>(i++)).
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)); 
		
		assertFalse(x.pathTo(y));
	}

	// x->y
	@Test
	public void testXToY() {
		DiGraphNode<Integer> x = new DiGraphNode<Integer>(1); 
		DiGraphNode<Integer> y = new DiGraphNode<Integer>(2);

		int i=10;
		x.addChild(new DiGraphNode<Integer>(i++)).
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(y); 
		
		assertTrue(x.pathTo(y));
	}
	
	// y->x
	@Test
	public void testYToX() {
		DiGraphNode<Integer> x = new DiGraphNode<Integer>(1); 
		DiGraphNode<Integer> y = new DiGraphNode<Integer>(2);

		int i=10;
		x.addChild(new DiGraphNode<Integer>(i++)).
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(y); 
		
		assertTrue(y.pathTo(x));
	}

	// graph with cycle, no connection
	@Test
	public void graphWithCycleNoConnection() {
		DiGraphNode<Integer> x = new DiGraphNode<Integer>(1); 
		DiGraphNode<Integer> y = new DiGraphNode<Integer>(2);

		int i=10;
		x.addChild(new DiGraphNode<Integer>(i++)).
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(x). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)); 
		
		assertFalse(x.pathTo(y));
	}

	// graph with cycle, connection
	@Test
	public void graphWithCycleConnection() {
		DiGraphNode<Integer> x = new DiGraphNode<Integer>(1); 
		DiGraphNode<Integer> y = new DiGraphNode<Integer>(2);

		int i=10;
		x.addChild(new DiGraphNode<Integer>(i++)).
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(x). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(new DiGraphNode<Integer>(i++)). 
		addChild(y). 
		addChild(new DiGraphNode<Integer>(i++)); 
		
		assertTrue(x.pathTo(y));
	}

}
