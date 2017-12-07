

import java.util.*;

public class WordGame {
	

	public List<String> subStringsLessKDist(String inputString, int num) {
		List<String> res = new ArrayList<String>();

		for (int i = 0; i < inputString.length() - num; i++) {
			String s = inputString.substring(i, i+num);
			if (oneRepeat(s, num)) {
				res.add(s);
			}
		}
		return res;
	}

	private boolean oneRepeat(String s, int num) {
		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		return set.size() == num - 2;
	}


	public static void main(String[] args) {
		WordGame wg = new WordGame();


		String inputString = "abcdabcbefg";
		System.out.println(wg.subStringsLessKDist(inputString, 5));

	}
}