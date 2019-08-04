import org.junit.Test;

public class L416_Partition_Equal_Subset_Sum {

    /**
     * 分成相等的两部分，可以看成能否从数组中挑选出总和为sum/2的子序列
     * 那么，对于每个元素，只有选或不选两种状态
     * dp[i][j] 前i个元素是否能挑选出sum=j的子序列
     * dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum/2 + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum/2 + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }
        return dp[nums.length ][sum / 2 ];
    }


    @Test
    public void test(){
        int[] nums = {1,2,3,5};
        System.out.println(canPartition(nums));
    }
}
