package tim.util;

public class BasicHashTable {
	private static final int CHashTableSize = 127;
	
	private class Node {
		public String key;
		public Object val;
		public Node next;
		
		public Node(String k,Object v) {
			key=k;
			val=v;
		}
		
		public Node(String k,Object v, Node n) {
			this(k, v);
			next = n;
		}
	}
	
	private Node[] m_hashTable;
	
	public BasicHashTable() {
		m_hashTable = new Node[CHashTableSize];
	}
	
	private int hash(String s) {
		int sum = 0;
		
		for(int i=0; i<s.length();i++) {
			sum+=s.charAt(i);
			if(i%10 == 0) {
				break;
			}
		}
		
		return Math.abs(sum);
	}

	public Object get(String k) {
		int slot = hash(k) % CHashTableSize;
		
		Object ret=null;
		
		for(Node n=m_hashTable[slot];n!=null;n=n.next) {
			if(n.key.equals(k)) {
				ret=n.val;
				break;
			}
		}
		
		return ret;
	}

	public void put(String k, Object v) {
		int slot = hash(k) % CHashTableSize;
		boolean found = false;
		
		for(Node n=m_hashTable[slot];n!=null;n=n.next) {
			if(n.key.equals(k)) {
				found = true;
				n.val = v;
			}
		}
		
		if(!found) {
			Node n=new Node(k,v,m_hashTable[slot]);
			m_hashTable[slot] = n;
		}
	}
}
