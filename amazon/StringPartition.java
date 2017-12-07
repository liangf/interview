
import java.util.*;

public class StringPartition {
	
	public List<Integer> lengthEachScene(List<Character> inputList) {
		List<Integer> tmp = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();

		help(inputList, 0, tmp);
		int start = 0;
		for (int i = 0; i < tmp.size(); i++) {
			int end = tmp.get(i);
			res.add(end - start);
			start = end;
		}
		System.out.println(tmp);
		System.out.println(res);
		return res;
	}

	public boolean help(List<Character> inputList, int start, List<Integer> res) {
		if (start >= inputList.size()) {
			return true;
		}

		boolean have = false;
		for (int i = start; i < inputList.size(); i++) {
			if (noCommon(inputList, res, i+1)) {
				res.add(i+1);
				have = help(inputList, i+1, res);
				if (have) return true;
				res.remove(res.size() - 1);
			}
		}
		return have;
	}

	public boolean noCommon(List<Character> inputList, List<Integer> res, int end2) {
		if (res.size() == 0) return true;

		int start1 = 0;
		int start2 = res.get(res.size() - 1);
		for (int i = 0; i < res.size(); i++) {
			int end1 = res.get(i);
			if ( !check(inputList, start1, end1, start2, end2) )  return false;
			start1 = end1;
		}
		return true;
	}

	public boolean check(List<Character> inputList, int a, int b, int c, int d) {
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();

		for (int i = a; i < b; i++)
			set1.add(inputList.get(i));

		for (int i = c; i < d; i++) 
			set2.add(inputList.get(i));

		set1.retainAll(set2);
		return set1.size() == 0;
	}

	public static void main(String[] args) {
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		set1.add('a');
		set1.add('b');
		set2.add('c');
		set2.add('b');
		set1.retainAll(set2);
		System.out.println(set1);


		StringPartition sp = new StringPartition();
		// List<Character> inputList = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
		List<Character> inputList = new ArrayList<Character>(Arrays.asList('a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j'));
		sp.lengthEachScene(inputList);

	}	
}