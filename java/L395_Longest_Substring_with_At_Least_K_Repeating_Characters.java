import java.util.Arrays;

public class L395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        // 记录字符出现的频率
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a'] += 1;
        }
        // 当字符串中的字符都出现了k次及以上，则返回结果
        boolean flag = true;
        for (int i = 0; i < counts.length; i += 1) {
            if (counts[i] < k && counts[i] > 0) {
                flag = false;
            }
        }
        // return the length of string if this string is a valid string
        if (flag == true) {
            return s.length();
        }

        // 记录子字符串开始位置
        int start = 0;
        int cur = 0;
        int result = 0;
        while(cur < s.length()) {
            // 当字符出现的次数小于k，则在该字符之前可能有符合条件的子字符串
            if(counts[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start, cur), k));
        return result;
    }
}
