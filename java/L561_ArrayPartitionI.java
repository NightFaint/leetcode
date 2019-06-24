import java.util.Arrays;

public class L561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        // 数组排序后相邻元素两两组合，复杂度O(nlgn)
        Arrays.sort(nums);//O(nlgn)
        int sum = 0;
        for(int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
