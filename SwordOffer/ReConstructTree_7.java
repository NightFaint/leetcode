
public class ReConstructTree_7 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) 
    {
    	TreeNode root=reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    	return root;
    	
    }
    
    private TreeNode reConstructBinaryTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd) {
		if (preStart>preEnd || inStart>inEnd) {
			return null;
		}
		
		int rootVal=pre[preStart];
		TreeNode root=new TreeNode(rootVal);
		
		for(int i=inStart;i<=inEnd;i++)
		{
			if (in[i]==rootVal) {
				root.left=reConstructBinaryTree(pre, preStart+1,preStart+i-inStart,in,inStart,i-1);
				root.right=reConstructBinaryTree(pre, preStart+i-inStart+1, preEnd, in, i+1, inEnd);
			}
		}
		return root;
	}
}
