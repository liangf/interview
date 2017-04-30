

import java.util.*;

public class ball {
	
	public static int getSum(String[] s) {
		int sum = 0;
		Stack<Integer> stk = new Stack<>();
		for (int i=0; i<s.length; ++i) {
			if (s[i] == "Z") {
				sum -= stk.empty() ? 0 : stk.pop();	
			} else if (s[i] == "X") {
				if (!stk.empty()) {
					stk.push(stk.peek() * 2);
				}
				sum += stk.empty() ? 0 : stk.peek();
			} else if (s[i] == "+") {
				if (stk.size() >= 2) {
					stk.push(stk.get(stk.size()-1) + stk.get(stk.size()-2));
				} else if (stk.size() >= 1) {
					stk.push(stk.get(stk.size()-1));
				} 
				sum += stk.empty() ? 0 : stk.peek();
			} else {
				stk.push( Integer.parseInt(s[i]) );
				sum += stk.empty() ? 0 : stk.peek();
			}
			System.out.println(stk);
			System.out.println(sum);			
		}
		return sum;
	}

	public static void main(String[] args) {
        String[] s = new String[] {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        System.out.println(getSum(s));
	}
}