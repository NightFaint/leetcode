import java.util.Stack;

public class IsSymmetrical_28 {

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
	 * 树为空时也对称
	 * 比较左右子树，根节点不相等->返回false
	 * 根节点相等，递归比较左子树的左子树和右子树的右子树、左子树的右子树和右子树的左子树，均返回true时对称
	 */
	public boolean isSymmetrical(TreeNode node) {
		return node==null || isSubSymmetrical(node.left, node.right);
	}
	
	private boolean isSubSymmetrical(TreeNode node1,TreeNode node2) {
		if (node1==null && node2==null) {
			return true;
		}
		
		if (node1 == null || node2==null) {
			return false;
		}
		
		if (node1.val != node2.val) {
			return false;
		}
		
		return isSubSymmetrical(node1.left, node2.right) && isSubSymmetrical(node1.right, node2.left);
	}
	
	/*
	 * 非递归版本
	 * 用一个堆来存储左右子树，每次弹出两个元素
	 */
	public boolean isSymmetrical2(TreeNode node) {
		if (node==null) {
			return true;
		}
		
		
		TreeNode left=node.left;
		TreeNode right=node.right;
		
		Stack<TreeNode> stack=new Stack<>();
		stack.push(left);
		stack.push(right);
		while(!stack.isEmpty())
		{
			right=stack.pop();
			left=stack.pop();
			if (right==null && left==null) {
				continue;
			}
			if (right==null || left == null) {
				return false;
			}
			
			if (left.val!=right.val) {
				return false;
			}
			
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;
		
		
	}
	

}
