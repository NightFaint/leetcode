import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeEveryLayer_32 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	public List<List<Integer>> printTreeEveryLayer(TreeNode root) {
		List<List<Integer>> list=new ArrayList<>();
		if (root==null) {
			return list;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		
		
		while(!queue.isEmpty())
		{
			List<Integer> layer=new ArrayList<>();
			int l=queue.size();
			for(int i=0;i<l;i++)
			{
				TreeNode node=queue.poll();
				layer.add(node.val);
				if (node.left!=null) {
					queue.offer(node.left);
				}
				if (node.right!=null) {
					queue.offer(node.right);
				}
			}
			list.add(layer);
			
		}
		return list;
	}
	
}
