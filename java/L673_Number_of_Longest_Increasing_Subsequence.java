public class L673_Number_of_Longest_Increasing_Subsequence {
    /**
     * 动态规划
     * len[i]记录以i为结尾的子数组的最长子序列的长度
     * count[i]记录以i为结尾的子数组的拥有最长子序列的个数
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int max_len = 0;
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            len[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                // len[i] len[j];count[i]、count[j]子问题关联
                if (nums[i] > nums[j]) {
                    // len[i] == len[j] + 1说明以i为结尾的子数组之前就有一个长度为len[j]+1的最长子序列
                    if (len[i] == len[j] + 1) {
                        count[i] += count[j];
                    }
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (max_len == len[i]) {
                res += count[i];
            }
            if (max_len < len[i]) {
                max_len = len[i];
                res = count[i];
            }
        }
        return res;
    }
}
