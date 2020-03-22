import org.junit.Test;

public class L67AddBinary {

    /**
     * 同一个位上a[i]和b[j]相加,再加上进位得到结果sum
     * sum & 1 则得到该位的结果
     * sum >> 1 得到进位
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            int add = carry;
            if (i >= 0 ){
                add += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                add += b.charAt(j--) - '0';
            }
            // 为了不让stringbuilder每次从index=0添加元素的时候需要移动整个对象的元素
            // 每次都直接添加到末尾
            // 最后的时候再进行reverse操作
            sb.append(add & 1);
            carry = add >> 1;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();

    }



    @Test
    public void test(){
        System.out.println(addBinary("100", "110010"));
    }
}
