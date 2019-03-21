

public class BST_55 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	/*
	 * 后序遍历，为了传引用使用了对象数组
	 */
	public boolean isBalanced(TreeNode node) {
		return isBalanced(node, new int[1]);
	}
	
	
	private boolean isBalanced(TreeNode node,int[] depth)
	{
		if (node==null) {
			depth[0]=0;
			return true;
		}
		
		boolean left=isBalanced(node.left, depth);
		int leftDepth=depth[0];
		
		boolean right=isBalanced(node.right, depth);
		int rightDepth=depth[0];
		
		depth[0]=Math.max(leftDepth, rightDepth)+1;
		
		if (left && right && Math.abs(leftDepth-rightDepth)<=1) {
			return true;
		}
		return false;
	}
}
