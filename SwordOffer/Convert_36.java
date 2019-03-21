import java.util.Stack;

public class Convert_36 {


	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	

	/*
	 * 非递归版本
	 */
	public TreeNode convert(TreeNode pRootOfTree) {
		TreeNode head=null;
		TreeNode pre=null;
		
		Stack<TreeNode> stack=new Stack<>();
		while(pRootOfTree != null || !stack.isEmpty())
		{
			while(pRootOfTree != null)
			{
				stack.push(pRootOfTree);
				pRootOfTree = pRootOfTree.left;
			}
			
			pRootOfTree=stack.pop();
			
			//head=null,即此时pRootOfTree是最左的叶节点
			if (head == null) {
				head=pRootOfTree;
				pre=pRootOfTree;
			}
			
			//head！=null,需要连接pre和pRootOfTree
			else {
				pre.right=pRootOfTree;
				pRootOfTree.left=pre;
				
				//连接好后，pre变为pRootOfNode,即下一次遍历的前节点
				pre=pRootOfTree;
			}
			pRootOfTree=pRootOfTree.right;//如果有右节点，那么下一个节点是右子树中的节点
		}
		return head;
	}
	
	
}
