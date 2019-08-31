import org.junit.Test;

public class L300_Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] increase = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            int low = 0;
            int high = len;
            low = index(increase, low, high, x);
            increase[low] = x;
            if (low == len) {
                len++;
            }
        }
        return len;

    }

    private int index(int[] nums, int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    @Test
    public void test(){
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
