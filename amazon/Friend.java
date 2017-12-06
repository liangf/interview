

import java.util.*;


public class Friend {

	public List<String> find(String[][] input) {	
		List<Set<String>> res = new ArrayList<Set<String>>();
		for (int i = 0; i < input.length; i++) {
			union(res, input[i][0], input[i][1]);
		}

		List<String> max = new ArrayList<String>(res.get(0));
		Collections.sort(max);
		for (int i = 1; i < res.size(); i++) {
			if (res.get(i).size() > max.size()) {
				max = new ArrayList<String>(res.get(i));
				Collections.sort(max);
			} else if (res.get(i).size() == max.size()) {
				List<String> tmp = new ArrayList<String>(res.get(i));
				Collections.sort(tmp);
				String first1 = max.get(0);
				String first2 = tmp.get(0);
				if (first1.compareTo(first2) > 0) {
					max = tmp;
				}
			}
		}
		return max;
	}

	public void union(List<Set<String>>res, String first, String second) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).contains(first) && res.get(i).contains(second)) {
				return;
			} else if (res.get(i).contains(first)) {
				set1 = res.get(i);
			} else if (res.get(i).contains(second)) {
				set2 = res.get(i);
			}
		}

		if (set1.size() > 0) {
			set1.add(second);
		} else if (set2.size() > 0) {
			set2.add(first);
		} else {
			res.add(new HashSet<String>(Arrays.asList(first, second)));
		}
	}
	
	public static void main(String[] args) {
		// String[][] input = new String[][] {
		// 	{"ab", "cd"},
		// 	{"ef", "cd"},
		// 	{"ef", "gh"},
		// 	{"jk", "lm"}
		// };

		// String[][] input = new String[][] {
		// 	{"ab", "cd"},
		// 	{"ef", "cd"},
		// 	{"jk", "lm"},
		// 	{"lm", "gh"},
		// 	{"ac", "bd"},
		// 	{"bd", "ef"}
		// };

		String[][] input = new String[][] {
			{"ab", "cd"}
		};

		Friend f = new Friend();
		System.out.println(f.find(input));
	}
}
