import java.util.Stack;

public class L538_Convert_BST_to_Greater_Tree {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
     * 遍历顺序：右子节点 -> 中间节点 -> 左节点
     */
    public TreeNode convertBST(TreeNode root) {
        sum(root, 0);
        return root;
    }

    private int sum(TreeNode root, int plus) {
        if(root == null) {
            return plus;
        }
        int right = sum(root.right, plus);
        root.val += right;
        int left = sum(root.left, root.val);

        return left;
    }

//    int sum = 0;
//    public TreeNode convertBST2(TreeNode root) {
//        if(root != null) {
//            convertBST2(root.right);
//            sum += root.val;
//            root.val = sum;
//            convertBST2(root.left);
//        }
//        return root;
//    }


    public TreeNode convertBST3(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }
        return root;
    }


}
