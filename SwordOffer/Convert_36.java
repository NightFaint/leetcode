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
	 * �ǵݹ�汾
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
			
			//head=null,����ʱpRootOfTree�������Ҷ�ڵ�
			if (head == null) {
				head=pRootOfTree;
				pre=pRootOfTree;
			}
			
			//head��=null,��Ҫ����pre��pRootOfTree
			else {
				pre.right=pRootOfTree;
				pRootOfTree.left=pre;
				
				//���Ӻú�pre��ΪpRootOfNode,����һ�α�����ǰ�ڵ�
				pre=pRootOfTree;
			}
			pRootOfTree=pRootOfTree.right;//������ҽڵ㣬��ô��һ���ڵ����������еĽڵ�
		}
		return head;
	}
	
	
}
