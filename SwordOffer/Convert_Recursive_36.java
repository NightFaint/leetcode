

public class Convert_Recursive_36 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	TreeNode head=null;
	TreeNode pre=null;
	/*
	 * 递归版本
	 */
	public TreeNode convert(TreeNode pRootOfTree) {
		convertSub(pRootOfTree);
		return head;
	}
	
	public void convertSub(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return;
		}
		
		convertSub(pRootOfTree.left);
		//head=null,即此时pRootOfTree是最左的叶节点
		if (head == null) {
			head=pRootOfTree;
			pre=pRootOfTree;
		}
		
		//head！=null,需要连接pre和pRootOfTree
		else {
			pre.right=pRootOfTree;
			pRootOfTree.left=pre;
			pre=pRootOfTree;//连接好后，pre变为pRootOfNode,即下一次遍历的前节点
		}
		convertSub(pRootOfTree.right);
	}
}
