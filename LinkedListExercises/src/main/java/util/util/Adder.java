package util;

public class Adder {
	private static int getDigits(LinkedList<Integer> l) throws IllegalStateException {
		int res = 0;
		int power=1;
		int cur;
		
		for(LinkedList<Integer>.Node n=l.getHead(); n != null; n=n.getNext()) {
			cur = n.getElement().intValue();
			
			if(cur > 9 || cur < 0) 
				throw new IllegalStateException("only 0-9 allowed for addition");
			
			if(power > 100000000) 
				throw new IllegalStateException("Overflow: integer too big");
			
			res += cur * power;
			// TODO: check for overflow
			power *= 10;
		}
		
		return res;
	}

	private static int getDigitsReverse(LinkedList<Integer> l) throws IllegalStateException {
		int res = 0;
		int power=1;
		int cur;

		for(LinkedList<Integer>.Node n=l.getHead(); n != null; n=n.getNext()) {

			if(power > 100000000) 
				throw new IllegalStateException("Overflow: integer too big");

			power *= 10;
		}
		
		for(LinkedList<Integer>.Node n=l.getHead(); n != null; n=n.getNext()) {
			cur = n.getElement().intValue();
			
			if(cur > 9 || cur < 0) 
				throw new IllegalStateException("only 0-9 allowed for addition");
			
			
			res += cur * power;
			// TODO: check for overflow
			power /= 10;
		}
		
		return res;
	}

	public static LinkedList<Integer> add(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		int a1=0, // number from list l1
			a2=0, // number from list l2
			sum=0; // sum to process
	
		a1 = getDigits(l1);
		a2 = getDigits(l2);
		
		sum = a1 + a2;
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int digit;
		
		while(sum > 0) {
			digit = sum%10;
			sum /= 10;
			result.insert(digit);
		}
		
		return result;
	}

	public static LinkedList<Integer> addReverse(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		int a1=0, // number from list l1
			a2=0, // number from list l2
			sum=0; // sum to process
	
		a1 = getDigitsReverse(l1);
		a2 = getDigitsReverse(l2);
		
		sum = a1 + a2;

		int digits=0;
		
		while(sum > 0) {
			digits++;
			sum /= 10;
		}
	
		int[] d = new int[digits];
		
		sum=a1+a2;
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int digit;
		int i=0;
		
		while(sum > 0) {
			digit = sum%10;
			sum /= 10;
			d[i++] = digit;
		}
		
		for(i=d.length-1;i>=0;i--) {
			result.insert(d[i]);
		}
		
		return result;
	}
}
