

public class VerifySequenceOfBST_33 {

	
	public boolean verifySequenceOfBST(int[] nums,int length) {
		if (nums==null || length<=0) {
			return false;
		}
		
		return isBST(nums, 0, length-1);
		
	}
	
	public boolean isBST(int[] nums,int begin,int end) {
		 // begin比end大说明上层结点没有左子树或者右子树，begin == end说明该本层结点没有子树，无需比较了
        // 这两种情况都应该返回true
		if (begin>=end) {
			return true;
		}
		
		//后序遍历，根节点最后遍历到
		int root=nums[end];
		int i=begin;
		
		//BST中，左子树中节点的值均小于根节点，且在后序遍历中，左子树的节点在最前，后面是右子树，再是根节点
		for(;i<end;i++)
		{
			if (nums[i]>root) {
				break;
			}
		}
		
		//右子树中，不应该有小于根节点的值
		for(int j=i;j<=end-1;j++)
		{
			if (nums[j]<root) {
				return false;
			}
		}
		
		return isBST(nums, begin, i-1) && isBST(nums, i, end-1);
	}
}
