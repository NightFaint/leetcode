import java.util.LinkedList;
import java.util.Queue;

public class L104_MaximumDepth_of_Binary_Tree {
    /**
     * 层序遍历
     * O(n)
     */
    public int maxDepth(TreeNode root) {
        if(root == null ) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while(size > 0) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null ){
                    queue.offer(cur.right);
                }
                size--;
            }
        }
        return depth;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归 更快
     */
    public int maxDepth2(TreeNode root) {
        if(root == null ) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
    }
}
