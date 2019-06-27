import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40_CombinationSumII {
    /**
     * 广度优先搜索
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(new ArrayList<>(), res, target, candidates, 0);
        return res;
    }

    private void helper(List<Integer> list, List<List<Integer>> res, int remainTarget, int[] candidates, int startIndex) {
        // remainTarget只可能>=0;不可能<0,下面的if判断若出现remain[i]>remainTarget会直接返回
        if(remainTarget == 0) {
            // 必须新建一个list对象，不然之后对list的操作会影响到已添加到res的list
            res.add(new ArrayList<>(list));
        } else {
            for(int i = startIndex; i < candidates.length; i++) {
                if (candidates[i] > remainTarget) {
                    return;
                }
                list.add(candidates[i]);
                helper(list, res, remainTarget - candidates[i], candidates, i + 1);
                // 注意释放数组元素
                list.remove(list.size() - 1 );
                while(i+1 < candidates.length && candidates[i]==candidates[i+1]) {
                    i++;
                }
            }
        }
    }

    @Test
    public void test() {
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(candidates, 8);
        System.out.println(lists);
    }
}
