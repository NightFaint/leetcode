import java.util.ArrayList;
import java.util.List;

public class L118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) {
            return res;
        }
        // 第一行为[1]
        res.add(new ArrayList<>());
        res.get(0).add(1);

        for(int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            // 第一列为1
            cur.add(1);
            // 前一行数据
            List<Integer> pre = res.get(i - 1);
            // 除了第一列和最后一列，其他列都有上一行两列得出
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            // 最后一列为1
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
