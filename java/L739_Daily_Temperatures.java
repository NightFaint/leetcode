import java.util.Stack;

public class L739_Daily_Temperatures {
    /**
     * 思路1：暴力法，针对每个元素，遍历数组，复杂度O(n^2)
     * 思路2：观察数组特点，未遇到更高的温度的数组是一个递减的数组，
     *  可用一个栈来存储，栈顶存储最小的元素的索引，遇到比栈顶高的温度，栈poll直到栈顶大于当前温度
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < T.length; i++) {
            while((!stack.isEmpty()) && (T[stack.peek()] < T[i])) {
                Integer top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        return res;
    }


    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
