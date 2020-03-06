import org.junit.Test;

public class L680_Valid_PalindromeII {
    public boolean validPalindrome(String s) {
        return helper(s, 0);
    }

    private boolean helper(String s, int count) {
        int right = s.length() -  1;
        int left = 0;
        while (left < right) {
            // 调试用
            char a = s.charAt(left);
            char b = s.charAt(right);
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (count == 1) {
                    return false;
                } else {
                    count++;
                    // 左边与右边不相等，可跳过左边或右边
                    return helper(s.substring(left + 1, right + 1), count) || helper(s.substring(left, right), count);
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }
}
