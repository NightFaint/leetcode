import java.util.HashMap;

public class FindGreatestSumOfSub_42 {

	//用来区分是否是无效输入和最大子数组值为0
	boolean isInvalid;
	/*
	 * 累加法
	 * 如果当前累加和是负数，
	 * 那么它加上当前元素将使得新的累加和比当前元素还要小，
	 * 此时应该将之前的累加和丢弃，从当前元素开始累加。
	 * 复杂度O(n)
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
	
	/*动态规划
	 * 子问题dp[j]：以j结尾的子数组的最大值
	 * 子问题关联:dp[j]=max{dp[j-1]+nums[j],nums[j]}
	 * 然后找出最大值
	 * 采用cur来保存dp[j]， maxSum来保存最大值
	 * 以节省空间
	 * 时间复杂度O(n)
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
