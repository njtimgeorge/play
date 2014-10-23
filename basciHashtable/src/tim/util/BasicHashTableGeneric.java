package tim.util;

public class BasicHashTableGeneric<KeyType,ValueType> {
	private static final int CHashTableSize = 127;
		
	private HashTableNode[] m_hashTable;
	
	public BasicHashTableGeneric() {
		m_hashTable = new HashTableNode[CHashTableSize];
	}
	
	@SuppressWarnings("unchecked")
	public ValueType get(KeyType k) {
		int slot = k.hashCode() % CHashTableSize;		
		ValueType ret=null;
		
		for(HashTableNode n=m_hashTable[slot];n!=null;n=n.next) {
			if(n.key.equals(k)) {
				ret=(ValueType)n.val;
				break;
			}
		}
		
		return ret;
	}

	public void put(String k, Object v) {
		int slot = k.hashCode() % CHashTableSize;		
		boolean found = false;
		
		for(HashTableNode n=m_hashTable[slot];n!=null;n=n.next) {
			if(n.key.equals(k)) {
				found = true;
				n.val = v;
			}
		}
		
		if(!found) {
			HashTableNode n=new HashTableNode(k,v,m_hashTable[slot]);
			m_hashTable[slot] = n;
		}
	}
}
