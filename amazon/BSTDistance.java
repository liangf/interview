public class BSTDistance {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public TreeNode constructBST(int[] nums) {
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.val) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public int getDistanceFrom(TreeNode root, int key) {
        int d = 0;
        while (root != null) {
            if (key < root.val) {
                root = root.left;
            } else if (key > root.val) {
                root = root.right;
            } else {
                return d;
            }
            d++;
        }
        return -1;
    }

    public TreeNode BST_LCA(TreeNode root, int a, int b) {
        if (root == null) return null;

        if (Math.max(a, b) < root.val) // a.val < root.val && b.val < root.val, on the left subtree
            return BST_LCA(root.left, a, b);
        else if (Math.min(a, b) > root.val) // a.val > root.val && b.val > root.val, on the right subtree
            return BST_LCA(root.right, a, b);
        else
            return root;
    }

    public int getDistance(int[] nums, int n1, int n2) {
        TreeNode root = constructBST(nums);
        TreeNode lca = BST_LCA(root, n1, n2);

        int d1 = getDistanceFrom(lca, n1);
        int d2 = getDistanceFrom(lca, n2);
        System.out.println("d1:" + d1);
        System.out.println("d2:" + d2);
        if(d1 >= 0 && d2 >= 0) {
            return  d1 + d2;
        }
        return -1;
    }

    public static void main(String[] args) {
        BSTDistance bstDistance = new BSTDistance();


        // int[] values = new int[] {1};
        // System.out.println(bstDistance.getDistance(values, 1, 1));


        int[] values = new int[] {5, 6, 3, 1, 2, 4};
        // System.out.println(bstDistance.getDistance(values, 2, 6));
        System.out.println(bstDistance.getDistance(values, 1, 4));

    }
}