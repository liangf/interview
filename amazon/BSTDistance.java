public class BSTDistance {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private static TreeNode root;
    public void constructBST(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (root != null) {
                constructHelper(root, nums[i]);
            } else {
                root = new TreeNode(nums[i]);
            }
        }
    }
    public void constructHelper(TreeNode node, int item) {
        if(node.val > item) {
            // construct from left
            if(node.left == null) {
                node.left = new TreeNode(item);
            } else {
                constructHelper(node.left, item);
            }
        } else {
            //construct from right
            if(node.right == null) {
                node.right = new TreeNode(item);
            } else {
                constructHelper(node.right, item);
            }
        }
    }


    public static int getDistanceFromRoot(TreeNode node) {
        int distance = 0;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val > node.val) {
                curr = curr.left;
            } else if(curr.val < node.val) {
                curr = curr.right;
            } else {
                return distance;
            }
            distance++;
        }
        return -1;
    }

    public static TreeNode BST_LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null)
            return root;
        if (root == a || root == b)
            return root;
        if (Math.max(a.val, b.val) < root.val) // a.val < root.val && b.val < root.val, on the left subtree
            return BST_LCA(root.left, a, b);
        else if (Math.min(a.val, b.val) > root.val) // a.val > root.val && b.val > root.val, on the right subtree
            return BST_LCA(root.right, a, b);
        else
            return root;
    }

    public int getDistance(int[] nums, int n, int n1, int n2) {
        TreeNode node1 = new TreeNode(n1);
        TreeNode node2 = new TreeNode(n2);
        TreeNode lca = BST_LCA(root, node1, node2);
        int s1 = getDistanceFromRoot(node1);
        int s2 = getDistanceFromRoot(node2);
        int slca = getDistanceFromRoot(lca);
        if(s1 >= 0 && s2 >= 0) {
            return  s1 + s2 - 2 * slca;
        }
        return -1;
    }

    public static void main(String[] args) {
        BSTDistance bstDistance = new BSTDistance();
        int[] values = {1};
        bstDistance.constructBST(values);
        int res = bstDistance.getDistance(values, 1,1,1);
        System.out.println(res);
    }
}