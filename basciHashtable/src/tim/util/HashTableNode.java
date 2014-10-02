package tim.util;

public class HashTableNode {
	public Object key;
	public Object val;
	public HashTableNode next;
	
	public HashTableNode(Object k,Object v) {
		key=k;
		val=v;
	}
	
	public HashTableNode(Object k,Object v, HashTableNode n) {
		this(k, v);
		next=n;
	}
}
