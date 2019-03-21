import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth_55 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	/*
	 * 递归版本
	 * 树的深度=左右子树较大的深度加1
	 * 
	 */
	public int treeDepth(TreeNode node) {
		if (node==null) {
			return 0;
		}
		int left=treeDepth(node.left);
		int right=treeDepth(node.right);
		
		return left>right?left+1:right+1;
	}
	
	/*
	 * 非递归版本:借助层序遍历
	 * 每到一层，depth+1
	 */
	
	public int treeDepth2(TreeNode node) {
		if (node==null) {
			return 0;
		}
		int depth=0;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty())
		{
			int len=queue.size();
			for(int i=0;i<len;i++)
			{
				TreeNode cur=queue.poll();
				if (cur.left!=null) {
					queue.offer(cur.left);
				}
				if (cur.right!=null) {
					queue.offer(cur.right);
				}
			}
			depth++;
			
		}
		return depth;
	}
}
