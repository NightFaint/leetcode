public class L227_Basic_CalculatorII {
    public int calculate(String s) {
        //因为有运算优先级，必须知道前一个数字是什么
        int pre = 0;
        int res = 0;

        char sign = '+';
        s = s.trim().replace(" ", "");
        int i = 0;
        while (i < s.length()){
            int cur = 0;
            while (i < s.length() && '0' <= s.charAt(i)  && s.charAt(i)<= '9'){
                cur = cur * 10 + (s.charAt(i) - '0');
                i++;
            }
            // 这时候s.charAt(i)是运算符了,当前数字也已经有了
            // 先对上一个运算符进行计算
            switch (sign){
                // 运算符是加号，此时pre不参与后续运算，可添加到res中,pre = cur
                case '+':
                    res += pre;
                    pre = cur;
                    break;
                case '-':
                    res += pre;
                    pre = -cur;
                    break;
                    // 运算符是乘号，此时pre参与后续运算，pre = pre * cur
                case '*':
                    pre *= cur;
                    break;
                case '/':
                    pre /= cur;
                    break;
            }
            if (i < s.length()){
                sign = s.charAt(i);
                i++;
            }
        }
        res += pre;
        return res;
    }
}
