package util;
import java.util.Stack;

public class StackSorter<T extends Comparable<T>> {
	public void sort(Stack<T> s) {
		Stack<T> tmp = new Stack<T>();
		
		if(s.isEmpty()) return;
		
		boolean firstTime = true;
		int depth = 0;

		T least, cur;

		while(firstTime || depth > 0) {
			int i=0;
			least = s.peek();
			
			while(!s.isEmpty()) {
				cur = s.pop();
				
				if(cur.compareTo(least) < 0) least = cur;
				
				tmp.push(cur);

				if(firstTime) {
					depth++;
				} else {
					if(++i > depth) break;
				}
			}
			
			s.push(least);

			//System.out.println("least = " + least.toString());
			
			while(!tmp.isEmpty()) {
				cur = tmp.pop();
				
				if(cur != least) // note: object comparison, not .equals
					s.push(cur);
			}
			
			if(firstTime) {
				firstTime=false;
				depth--;
			}
			
			depth--;
			
			//System.out.println("depth = " + Integer.toString(depth));

		}
	}	
}
