import java.util.*;

public class bstDistance {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode insert(TreeNode root, int x) {
		if (root == null) {
			return new TreeNode(x);
		}
		if (x < root.val) {
			root.left = insert(root.left, x);
		} else {
			root.right = insert(root.right, x);
		}
		return root;
	}

	public static void getPath(TreeNode root, int k, List<Integer> path) {
		if (root == null) {
			return;
		}

		path.add(root.val);
		if (root.val == k) {
			return;
		} else if (k < root.val) {
			getPath(root.left, k, path);
		} else {
			getPath(root.right, k, path);
		}
	}

	public static int getDistance(TreeNode root, int n1, int n2) {
		List<Integer> path1 = new ArrayList<Integer>();
		List<Integer> path2 = new ArrayList<Integer>();

		getPath(root, n1, path1);
		getPath(root, n2, path2);	

		int i = 0;
		while (i<path1.size() && i<path2.size()) {
			if (path1.get(i) != path2.get(i)) {
				break;
			}
			++i;
		}
		// nodes not in the tree
		if (path1.size()==0 || path2.size()==0 || path1.get(path1.size()-1)!=n1 || path2.get(path2.size()-1)!=n2) {
			return -1;
		}

		// nodes in diff branch
		if (i<path1.size() && i<path2.size() && path1.get(i) != path2.get(i)) {
			return path1.size()-i + path2.size()-i;
		} 
		
		// nodes in same branch
		return Math.max(path1.size(), path2.size()) - i;
	}

	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
 		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}	

	public static void main(String[] args) {
		System.out.println("hahahha");
		int[] A = new int[] {5, 6, 3, 1, 2, 4};
		TreeNode root = null;

		for (int i=0; i<A.length; ++i) {
			root = insert(root, A[i]);
		}


		System.out.println(getDistance(root, 2, 4));
		System.out.println(getDistance(root, 2, 2));
		System.out.println(getDistance(root, 2, 7));
	}
}