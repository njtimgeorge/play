package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.BinaryTree;

public class TestIsBalanced {

	
	// 1 node
	@Test
	public void test1Node() {
		assertTrue(new BinaryTree<Integer>(1).isBalanced());
	}

	// 1 path
	@Test
	public void test1Path() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		
		bt.addLeft(2).
		addLeft(2).
		addLeft(3).
		addLeft(4).
		addLeft(5).
		addLeft(6).
		addLeft(7).
		addLeft(8);
		
		assertTrue(bt.isBalanced());
	}
	
	// unbalanced
	@Test
	public void testUnbalanced() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		
		bt.addLeft(2).
		addLeft(2).
		addLeft(3).
		addLeft(4).
		addLeft(5).
		addLeft(6).
		addLeft(7).
		addLeft(8);

		bt.addRight(1);
		
		assertFalse(bt.isBalanced());
	}
	
	// one path off by one

	@Test
	public void testOffByOne() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		
		bt.addLeft(2).
		addLeft(2).
		addLeft(3).
		addLeft(4).
		addLeft(5).
		addLeft(6).
		addLeft(7).
		addLeft(8);
		
		bt.addRight(2).
		addRight(2).
		addRight(3).
		addRight(4).
		addRight(5).
		addRight(6).
		addRight(7);

		assertTrue(bt.isBalanced());
	}
	
	// 3 equal paths
	@Test
	public void testThreeEqual() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		
		bt.addLeft(2).
		addLeft(2).
		addLeft(3).
		addLeft(4).
		addLeft(5).
		addLeft(6).
		addLeft(7).
		addLeft(8);
		
		bt.addRight(2).
		addRight(2).
		addRight(3).
		addRight(4).
		addRight(5).
		addRight(6).
		addRight(7).
		addRight(8);
		
		bt.getRight().addLeft(2).
		addLeft(3).
		addLeft(4).
		addLeft(5).
		addLeft(6).
		addLeft(7).
		addLeft(8);

		assertTrue(bt.isBalanced());
	}

	// 3 unequal paths
	@Test
	public void testThreeUnEqual() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		
		bt.addLeft(2).
		addLeft(2).
		addLeft(3).
		addLeft(4).
		addLeft(5).
		addLeft(6).
		addLeft(7).
		addLeft(8);
		
		bt.addRight(2).
		addRight(2).
		addRight(3).
		addRight(4).
		addRight(5).
		addRight(6).
		addRight(7).
		addRight(8);
		
		bt.getRight().addLeft(2).
		addLeft(3).
		addLeft(4).
		addLeft(5).
		addLeft(6).
		addLeft(7).
		addLeft(8).addLeft(9).addLeft(10);

		assertFalse(bt.isBalanced());
	}

}
