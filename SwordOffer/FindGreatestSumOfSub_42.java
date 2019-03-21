import java.util.HashMap;

public class FindGreatestSumOfSub_42 {

	//���������Ƿ�����Ч��������������ֵΪ0
	boolean isInvalid;
	/*
	 * �ۼӷ�
	 * �����ǰ�ۼӺ��Ǹ�����
	 * ��ô�����ϵ�ǰԪ�ؽ�ʹ���µ��ۼӺͱȵ�ǰԪ�ػ�ҪС��
	 * ��ʱӦ�ý�֮ǰ���ۼӺͶ������ӵ�ǰԪ�ؿ�ʼ�ۼӡ�
	 * ���Ӷ�O(n)
	 */
	public int findGreatestSumOfSub(int[] nums) {
		if (nums==null || nums.length==0) {
			isInvalid=true;
			return 0;
		}
		
		int cumulative=0;
		int greatestSum=0;
		for(int i=0;i<nums.length;i++)
		{
			if (cumulative<=0) {
				cumulative=nums[i];
			}
			else {
				cumulative+=nums[i];
			}
			if (cumulative>greatestSum) {
				greatestSum=cumulative;
			}
		}
		return greatestSum;
	}
	
	/*��̬�滮
	 * ������dp[j]����j��β������������ֵ
	 * ���������:dp[j]=max{dp[j-1]+nums[j],nums[j]}
	 * Ȼ���ҳ����ֵ
	 * ����cur������dp[j]�� maxSum���������ֵ
	 * �Խ�ʡ�ռ�
	 * ʱ�临�Ӷ�O(n)
	 */
	
	public int findGreatestSumOfSub_dp(int[] nums) {
		if (nums==null || nums.length==0) {
			isInvalid=true;
			return 0;
		}
		
		int cur=0;
		int maxSum=0;
		for(int i=0;i<nums.length;i++)
		{
			cur=Math.max(cur+nums[i], nums[i]);
			if (cur>maxSum) {
				maxSum=cur;
			}
		}
		return maxSum;

		
	}
}
