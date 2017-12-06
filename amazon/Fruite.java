
import java.util.*;

public class Fruite {

	public static boolean match(List<List<String>> fruiteList, List<String> shoppingList) {
		int i = 0;
		int k = 0;

		while (i < fruiteList.size() && k < shoppingList.size()) {
			int j = 0;
			while (j < fruiteList.get(i).size()) {
				String s = fruiteList.get(i).get(j);
				if (s.equals("anything") || shoppingList.get(k).equals(s)) {
					k++;
					j++;
				} else {
					if (j == 0) k++;
					break;
				}
			}
			if (j == fruiteList.get(i).size()) {
				i++;
			} 
		}

		return i == fruiteList.size();
	}

	public static void main(String[] args) {
		List<List<String>> fruiteList = new ArrayList<List<String>>();
		List<String> l1 = new ArrayList<String>();
		l1.add("apple");
		l1.add("apple");
		List<String> l2 = new ArrayList<String>();
		l2.add("banana");
		l2.add("anything");
		l2.add("banana");
		fruiteList.add(l1);
		fruiteList.add(l2);

		List<String> shoppingList = new ArrayList<String>();
		// shoppingList.add("orange");
		// shoppingList.add("apple");
		// shoppingList.add("apple");
		// shoppingList.add("banana");
		// shoppingList.add("orange");
		// shoppingList.add("banana1");

		shoppingList.add("apple");
		shoppingList.add("apple");
		shoppingList.add("orange");
		shoppingList.add("orange");
		shoppingList.add("banana");
		shoppingList.add("apple");
		shoppingList.add("banana");
		shoppingList.add("banana");

		System.out.println(match(fruiteList, shoppingList));
	}

}
