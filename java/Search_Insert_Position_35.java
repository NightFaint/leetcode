package leetcode;

public class Search_Insert_Position_35 {

    public int searchInsert(int[] nums, int target) {
        if (nums==null || nums.length==0) {
			return -1;
		}
    	int left = 0;
        int right = nums.length-1;
        while (true) {
			if (nums[left]>=target) {
				return left;
			}
			if (target>nums[right]) {
				return  right+1;
			}
			int m=(left+right)/2;
			if (nums[m]>=target) {
				right=m;
			}
			else {
				left=m+1;
			}
		}
        
    }
    
    public static void main(String[] args) {
		System.out.println(3/2);
	}
}
