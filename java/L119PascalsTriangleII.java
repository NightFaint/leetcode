import java.util.ArrayList;
import java.util.List;

public class L119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        if(rowIndex == 0) {
            return cur;
        }
        for(int i = 1; i <= rowIndex; i++) {
            /* 在list头部添加1个元素1，则原来的list元素都向右移了一位
               如: index:    0    1    2    3    4
                   pre:      1    2    1
                   cur:      1    1    2    1
                   从list的规则知道：curList[j] = preList[j-1] + preList[j]
                   而添加首位的1后，cur[j] = pre[j-1];
                   且我们是从左往右改数据，cur[j]现在取决于cur[j]和cur[j+1]，
                   修改了cur[j]不影响cur[j+1],cur[j+1]=cur[j+1]+cur[j+2]
             */
            cur.add(0, 1);
            for(int j = 1; j < i; j++) {
                cur.set(j, cur.get(j) + cur.get(j + 1));
            }
            // 最后一位还是1，不用修改
        }
        return cur;
    }

    public static void main(String[] args) {
        L119PascalsTriangleII test = new L119PascalsTriangleII();
        System.out.println(test.getRow(3));
    }

}

