public class L509_Fibonacci_Number {
    /**
     * 动态规划
     * Time O(n)
     * Space O(1)
     * @param N
     * @return
     */
    public int fib(int N) {
        int a = 0;
        int b = 1;
        if(N < 2) {
            return N;
        } else {
            while(N > 1) {
                int temp = b;
                b = a + b;
                a = temp;
                N--;
            }
            return b;
        }
    }
}
