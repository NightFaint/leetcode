import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintFromTopToBottom_32 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	public List<Integer> printFromTopToBottom(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		if (root==null) {
			return list;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		TreeNode node=null;
		while(!queue.isEmpty())
		{
			node=queue.poll();
			list.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			
		}
		return list;
	}
	
	
}
