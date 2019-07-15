public class L1123_Lowest_Common_Ancestor_of_Deepest_Leaves {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) {
            return root;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(left > right) {
            return lcaDeepestLeaves(root.left);
        }
        else if(right > left) {
            return lcaDeepestLeaves(root.right);
        } else {
            return root;
        }
    }

    private int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return left > right ? left + 1 : right + 1;
    }
}
