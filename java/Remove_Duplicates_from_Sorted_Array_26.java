package leetcode;

public class Remove_Duplicates_from_Sorted_Array_26 {
	//10ms£¬»÷°Ü52%
    public int removeDuplicates(int[] nums) {
        int end=1;
        int start=1;
        while(end<nums.length)
        {
        	while(nums[end]==nums[end-1])
        	{
                if(end+1<nums.length)
        		    end++;
                else
                {
                    return start;
                }
        	}
        	nums[start]=nums[end];
        	start++;
        	end++;
        }
        return start;
    }
}
