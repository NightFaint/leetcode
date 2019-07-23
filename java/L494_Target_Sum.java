import org.junit.Test;

import java.util.Arrays;

public class L494_Target_Sum {
    int count;
    // DFS
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, 0, S);
        return count;
    }

    private void helper(int[] nums, int index, int S) {
        if(index == nums.length - 1) {
            if(S == nums[index] ) {
                count++;
            }
            if(S == -nums[index]) {
                count++;
            }
            return;
        }
        helper(nums, index + 1, S - nums[index]);
        helper(nums, index + 1, S + nums[index]);
    }

    /**
     * DP 带备忘的DP
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        // sum的范围为-1000到1000
        int[][] memos = new int[nums.length + 1][2001];
        for (int[] row : memos) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate(nums, 0, 0, S, memos);
    }

    private int calculate(int[] nums, int index, int sum, int target, int[][] memos) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memos[index][sum + 1000] != Integer.MIN_VALUE) {
                return memos[index][sum + 1000];
            } else {
                int add = calculate(nums, index + 1, sum + nums[index], target, memos);
                int subtract = calculate(nums, index + 1, sum - nums[index], target, memos);
                memos[index][sum + 1000] = add + subtract;
                return memos[index][sum + 1000];
            }
        }
    }

    public int findTargetSumWays3(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int target) {
        //dp[i][j]: the number of subsets that can sum to target j with the first i numbers
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length;  i++) {
            for (int j = 0; j <= target;  j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    @Test
    public void test(){
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays3(nums, 3));
    }
}
