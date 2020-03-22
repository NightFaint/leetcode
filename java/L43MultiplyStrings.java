import org.junit.Test;

public class L43MultiplyStrings {

    /**  index     0  1  2
     *             1  2  3
     * *           4  5  6
     *-------------------
     *                1  8
     *             1  2
     *          0  6
     *    ...
     * ------------------
     *    0  1  2  3  4  5          index
     * num[i] * num[j]相乘的结果位于index=i+j和i+j+1的位置
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        // 因为有进位，应该从m-1，n-1开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int cur = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 加上进位,res[i+j+1]最大为9，cur最大为81，所以相加最大不超过99
                cur += res[i + j + 1];
                // 每进行一次相乘，对应的res[i+j+1],res[i+j]都会更新
                res[i + j + 1] = cur % 10;
                res[i + j] += cur / 10; //注意这里是+=
            }
        }
        // res数组前面几位可能为零
        StringBuilder sb = new StringBuilder();
        for (int ele : res) {
            if (!(sb.length() == 0 && ele == 0)) {
                sb.append(ele);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test() {
        System.out.println(multiply("123", "456"));
    }
}
