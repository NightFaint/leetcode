

public class VerifySequenceOfBST_33 {

	
	public boolean verifySequenceOfBST(int[] nums,int length) {
		if (nums==null || length<=0) {
			return false;
		}
		
		return isBST(nums, 0, length-1);
		
	}
	
	public boolean isBST(int[] nums,int begin,int end) {
		 // begin��end��˵���ϲ���û��������������������begin == end˵���ñ�����û������������Ƚ���
        // �����������Ӧ�÷���true
		if (begin>=end) {
			return true;
		}
		
		//������������ڵ���������
		int root=nums[end];
		int i=begin;
		
		//BST�У��������нڵ��ֵ��С�ڸ��ڵ㣬���ں�������У��������Ľڵ�����ǰ�������������������Ǹ��ڵ�
		for(;i<end;i++)
		{
			if (nums[i]>root) {
				break;
			}
		}
		
		//�������У���Ӧ����С�ڸ��ڵ��ֵ
		for(int j=i;j<=end-1;j++)
		{
			if (nums[j]<root) {
				return false;
			}
		}
		
		return isBST(nums, begin, i-1) && isBST(nums, i, end-1);
	}
}
