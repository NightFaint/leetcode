package leetcode;

/*
 * 复杂度O(n)
 * 击败99.84%
 * 刚开始思路是遍历数组，遇到目标值则把数组向左移动一位，再向末尾添加目标值，显然复杂度达到O(n**2)。
 * 后来想到可以在数组末尾添加一个指针，该指针右边全是目标值，即不列入计数的，同样从左向右遍历数组，
 * 当遇到目标值时，判断当前right是否是目标值，若是，则right减1(注意此时要判断i是否大于right，若是，可以直接停止遍历得到结果)，
 * 直到找到一个非目标值为止，然后将nums[i]和nums[right]互换位置，再将right减1.
 * 显然，当遍历到的i比right大时，可停止遍历，此时有i+1项可计数值(索引从0开始)。
 */

public class Remove_Element_27 {
	
    public static int removeElement(int[] nums, int val) {
    	int count=0;
    	int right=nums.length-1;
    	tag:
    	for(int i=0;i<nums.length;i++)
    	{
    		if (i>right) {
				break;
			}
    		if (nums[i]==val) {
				while(nums[right]==val )
				{
					right--;
                    if(i>right)
                        break tag;
					
				}
				nums[i]=nums[right];
				nums[right]=val;
				right--;
			}
    		count++;
    	}
        return count;
    }

    public static void main(String[] args) {
		int i=removeElement(new int[] {1}, 1);
		System.out.println(i);
	}

}
