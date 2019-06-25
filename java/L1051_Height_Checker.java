import java.util.Arrays;

public class L1051_Height_Checker {
    public int heightChecker(int[] heights) {
        // 思路1，将数组排序，对比原数组看有几个元素不在正确位置
        // O(nlgn)
        int count = 0;
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);// O(nlgn)
        // O(n)
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
