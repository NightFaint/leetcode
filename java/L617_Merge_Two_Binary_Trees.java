import java.util.Stack;

public class L617_Merge_Two_Binary_Trees {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 跟树有关的第一想到递归
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 如果t2为空，合并不影响t1，直接返回t1
        if (t2 == null) {
            return t1;
        }
        // 同上
        if (t1 == null) {
            return t2;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 能递归的一般也能遍历
     * 逐层遍历
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees_2(TreeNode t1, TreeNode t2) {
        // 如果t1为空，合并不影响t2，直接返回t2
        if (t1 == null) {
            return t2;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] treeNodes = stack.pop();
            // 不会出现t[0] == null, t[1] != null的情况，在添加时t[0]为null时，会执行t[0] = t[1]的操作
            if (treeNodes[0] == null || treeNodes[1] == null) {
                continue;
            }
            treeNodes[0].val += treeNodes[1].val;
            if (treeNodes[0].left == null) {
                treeNodes[0].left = treeNodes[1].left;
            } else {
                stack.push(new TreeNode[]{treeNodes[0].left, treeNodes[1].left});
            }
            if (treeNodes[0].right == null) {
                treeNodes[0].right = treeNodes[1].right;
            } else {
                stack.push(new TreeNode[]{treeNodes[0].right, treeNodes[1].right});
            }
        }
        return t1;
    }
}
