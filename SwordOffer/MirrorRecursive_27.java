import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MirrorRecursive_27 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	/*
	 * ˼·���ݹ�
	 * ����ÿһ���ڵ㣬������ǿսڵ㣬�������ҽڵ�
	 */
	
	public void mirrorRecursice(TreeNode node) {
		if (node==null) {
			return;
		}
		
		if (node.left==null && node.right==null) {
			return;
		}
		
		swap(node);
		
		if (node.left!=null) {
			mirrorRecursice(node.left);
		}

		if (node.right!=null) {
			mirrorRecursice(node.right);
		}

	}
	
	private void swap(TreeNode node) {
		TreeNode temp=node.left;
		node.left=node.right;
		node.right=temp;
	}
	
	/*
	 * ˼·���������
	 * ˼·ͬ���ϵ��±���ÿһ������
	 */
	
	public void mirrorRecursive2(TreeNode node) {
		if (node==null) {
			return;
		}
		
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty())
		{
			TreeNode cur=queue.poll();
			if (cur.left != null || cur.right != null) {
				swap(cur);
			}
			
			if (cur.right != null) {
				queue.offer(cur.right);
			}
			if (cur.left !=null) {
				queue.offer(cur.left);
			}
		}
	}
	
	/*
	 * ǰ�����
	 */
	public void mirrorRecursive3(TreeNode node)
	{
		if (node==null) {
			return ;
		}
		
		Stack<TreeNode> stack=new Stack<>();
		
		stack.push(node);
		while(!stack.isEmpty())
		{
			TreeNode cur=stack.pop();
			if (cur.left != null || cur.right !=null) {
				swap(cur);
			}
			
			if (cur.left !=null) {
				stack.push(cur.left);
			}
			
			if (cur.right !=null) {
				stack.push(cur.right);
			}
		}
	}
}
