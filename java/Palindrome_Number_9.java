package leetcode;

public class Palindrome_Number_9 {

    public boolean isPalindrome(int x) {
     
    	char[] chars=Integer.toString(x).toCharArray();
    	int left=0;
    	int right=chars.length-1;
    	while(left<right)
    	{
    		if (chars[left]!=chars[right]) {
				return false;
			}
    		else {
				left++;
				right--;
			}
    	}
    	return true;
    }
    

}
