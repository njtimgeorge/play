package util;

import java.util.ArrayList;
import java.util.HashSet;

// singly linked list for Cracking the Coding Interview exercises

public class LinkedList<T extends Comparable<T>> {

	private Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public Node getHead() {
		return head;
	}

	public class Node {
		private T element;
		public T getElement() {
			return element;
		}

		private Node next;
		
		public Node getNext() {
			return next;
		}

		protected Node(T element, Node next) {
			this.element = element;
			this.next=next;
		}
		
		@Override
		public int hashCode() {
			return element.hashCode();
		}
	}
	
	public void insert(T element) {
		if(head == null) {
			head = new Node(element, head);
		} else {
			Node p = null;
			for(Node n=head;n!=null;n=n.getNext()) p=n;
			
			p.next = new Node(element,null);
		}
	}
	
	// assumptions:
	// equality is .equals
	
	// options:
	// 1) nested for loops: O(n**2)
	// 2) sort then remove duplicates max(O(n), O(sort))
	// 3) HashSet for existing ones o(n)
	
	public void removeDuplicates() {
		if(head == null) {
			return;
		}
		
		HashSet<T> els = new HashSet<T>();
		
		Node prev = head;
		els.add(head.element);
		
		for(Node n=head.next;n!=null;n=n.next) {
			if(els.contains(n.element)) {
				// duplicate. Preserve previous, while removing n from list
				prev.next = n.next;
			} else {
				els.add(n.element);
				prev = n;
			}
		}
		
		System.gc(); // if this is periodic maintenance of potentially large lists
	}
	
	public void removeDuplicatesNoBuffer() {
		if(head == null) {
			return;
		}
						
		for(Node n=head.next;n!=null;n=n.next) {
			Node prev = n;
			for(Node f=n.next;f!=null;f=f.getNext()) {
				if(n.getElement().equals(f.getElement())) {
					prev.next = f.next;
				} else {
					prev=f;
				}
			}
		}		
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) return false;
		
		if(!(obj instanceof LinkedList<?>)) return false;
		
		LinkedList<?> other = (LinkedList<?>) obj;
		
		if(head == null && other.head == null) return true;
		
		if(head == null || other.head == null) return false;
		
		if(head.element.getClass() != other.head.element.getClass()) return false;

		Node listNode = head;
		Node otherListNode = (Node) other.head;
		
		while(listNode != null && otherListNode != null) {
			if(listNode.element.equals(otherListNode.element)) {
				listNode = listNode.next;
				otherListNode = otherListNode.next;
			} else {
				return false;
			}
		}
		
		if(listNode == null && otherListNode == null) return true;
				
		return false;
		
	}
	
	public void insertArray(T[] array) {
		for(int i=0; i<array.length;i++) {
			this.insert(array[i]);
		}
	}
	
	public T findKthElement(int k) {
		Node cur=head;
		Node kth=head;
		
		for(int i=0;i<k &&cur!=null;i++) {cur=cur.next;}
		
		if(cur==null) 
			return null;
		
		for(cur=cur.next;cur!=null;cur=cur.next) kth=kth.next;
		
		return kth.getElement();
		
	}
	
	public void delete(Node nodeToDelete) {
		// assumption: delete by equality of node, not element value
		
		if(head == null) {return;}
		if(head == nodeToDelete) {
			head = head.next;
		} else {
			Node prev = head;
			
			for(Node n=head.next;n!=null;n=n.next) {
				if(n==nodeToDelete) {
					prev.next=n.next;
					break;
				} else {
					prev=n;
				}
			}
		}
	}
	
	// arrange list such that:
	// Nodes less than x occur before x
	// Nodes equal to x are in the middle
	// Nodes greater than x are at the end
	// preserve order of lt/gt nodes relative to their group
	
	public void partition(T x) {
		if(head == null ||  x == null) {
			return;
		}
		
		Node lt_head = null;
		Node lt_tail = null;
		Node eq_head = null;
		Node eq_tail = null;
		Node gt_head = null;
		Node gt_tail = null;
		
		for(Node n=head;n!=null;n=n.getNext()) {
			int i = n.getElement().compareTo(x);
			
			if(i<0) {
				if(lt_head == null) {
					lt_head = lt_tail = n;
				} else {
					lt_tail.next = n;
					lt_tail = n;
				}
			} else if (i> 0) {
				if(gt_head == null) {
					gt_head = gt_tail = n;
				} else {
					gt_tail.next = n;
					gt_tail = n;
				}				
			} else {
				if(eq_head == null) {
					eq_head = eq_tail = n;
				} else {
					eq_tail.next = n;
					eq_tail = n;
				}				
			}
		}
		
		if(gt_tail != null) {gt_tail.next = null;}
		if(eq_tail != null) {eq_tail.next = null;}
		if(lt_tail != null) {lt_tail.next = null;}
			
		//System.out.println(dumpNode(lt_head, "Less than:    "));
		//System.out.println(dumpNode(eq_head, "Equal:        "));
		//System.out.println(dumpNode(gt_head, "Greater than: "));
		
		
		if(lt_head != null) {
			head = lt_head;
			
			if(eq_head != null) {
				lt_tail.next = eq_head;
				eq_tail.next = gt_head;
			} else {
				lt_tail.next = gt_head;
			}
		} else if(eq_head != null) {
			head=eq_head;
			eq_tail.next = gt_head;
		} else {
			head = gt_head;
		}
	}
	
	public boolean isPalindrome() {
		
		ArrayList<T> arry = new ArrayList<T>();
		
		for(Node n=head;n!=null;n=n.next) {
			arry.add(n.getElement());
		}
		
		int i=0;
		int j=arry.size()-1;
		
		while(i<j) {
			if(arry.get(i) != arry.get(j)) return false;
			i++;
			j--;
		}
		
		return true;
	}

	public void corrupt(Node p, Node q) {
		q.next = p;
	}
	
	public Node detectCycle() {
		Node ret=null;
		HashSet<Node> nodes = new HashSet<Node>();
		
		for(Node n = head;n != null; n=n.getNext()) {
			if(nodes.contains(n)) {
				ret = n;
				break;
			} else {
				nodes.add(n);
			}
		}
		
		return ret;
	}
	
	private String dumpNode(Node n, String desc) {
		StringBuilder sb = new StringBuilder();
		sb.append(desc);
		int i = 0;
		for(; n!=null; n=n.getNext()) {
			sb.append(n.getElement().toString());
			sb.append(",");
			
			i++;
			
			if(i>100) {break;}
		}
		
		return sb.toString();		
	}
	
	@Override 
	public String toString() {
		return dumpNode(head, "");
	}
}
