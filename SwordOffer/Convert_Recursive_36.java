

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
	 * �ݹ�汾
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
		//head=null,����ʱpRootOfTree�������Ҷ�ڵ�
		if (head == null) {
			head=pRootOfTree;
			pre=pRootOfTree;
		}
		
		//head��=null,��Ҫ����pre��pRootOfTree
		else {
			pre.right=pRootOfTree;
			pRootOfTree.left=pre;
			pre=pRootOfTree;//���Ӻú�pre��ΪpRootOfNode,����һ�α�����ǰ�ڵ�
		}
		convertSub(pRootOfTree.right);
	}
}
