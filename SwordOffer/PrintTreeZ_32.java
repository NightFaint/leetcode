import java.util.Stack;

public class PrintTreeZ_32 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	/*
	 * 剑指offer上解法
	 * 用两个栈来存储奇数层和偶数层节点
	 */
	public void print(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stackOdd=new Stack<>();
		Stack<TreeNode> stackEven=new Stack<>();
		
		stackOdd.push(root);
		
		while(!stackOdd.isEmpty() || !stackEven.isEmpty())
		{
			if (!stackOdd.isEmpty()) {
				while(!stackOdd.isEmpty())
				{
					TreeNode node=stackOdd.pop();
					System.out.print(node.val+" ");
					if (node.left != null) {
						stackEven.push(node.left);
					}
					if (node.right != null) {
						stackEven.push(node.right);
					}
				}
			}
			else {
				while(!stackEven.isEmpty())
				{
					TreeNode node=stackEven.pop();
					System.out.print(node.val+" ");
					if (node.right!=null) {
						stackOdd.push(node.right);
					}
					if (node.left != null) {
						stackEven.push(node.left);
					}
				}
			}
			System.out.println();
		}
	}
}
