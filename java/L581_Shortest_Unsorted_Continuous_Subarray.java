import org.junit.Test;

import java.util.Arrays;

public class L581_Shortest_Unsorted_Continuous_Subarray {
    /**
     * 从左：整个数组最小的顺应该顺序排放，找出第一个不满足这个规则的数，即右边有比这个数还小的数
     * 从右：整个数组最大的数应该顺序排列，找出第一个不满足这个规则的数，即左边有比这个数还大的数
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int min_index = i + min_index(Arrays.copyOfRange(nums, i, nums.length));
            if (left == min_index) {
                left ++;
            } else {
                break;
            }
        }
        if (left == nums.length) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int max_index = max_index(Arrays.copyOfRange(nums, 0, nums.length - i));
            if (right == max_index) {
                right--;
            } else {
                break;
            }
        }
        return right - left + 1;

    }

    private int min_index(int[] nums) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                index = i;
            }
        }
        return index;
    }

    private int max_index(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4};
        int i = findUnsortedSubarray(nums);
        System.out.println(i);
    }
}
