package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1 {

	//»÷°Ü79%,O(n),6ms
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map=new HashMap<>();
    	for(int i=0;i<nums.length;i++)
    	{
    		map.put(nums[i], i);
    		
    	}
    	for(int i=0;i<nums.length;i++)
    	{
    		if (map.containsKey(target-nums[i])) {
                int res=map.get(target-nums[i]);
                //ÅÅ³ý×ÔÉí
                if(res!=i)
				    return new int[] {i,res};
			}
    	}
    	return null;
    }
    
    //»÷°Ü99%£¬O(n),3ms
    public int[] twoSum2(int[] nums, int target) {
    	Map<Integer, Integer> map=new HashMap<>();
        map.put(nums[0],0);
    	for(int i=1;i<nums.length;i++)
    	{
    		if (map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
            else
            {
                map.put(nums[i],i);
            }
    	}
    	return null;
    }
}
