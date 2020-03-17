import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class L78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        // 对于nums数组中的每一个元素，res原有的所有list都添加这个元素，
        // 组成新的list，再添加到res中，原有的list不变
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>(list));
        // 时间复杂度O(n)
        // 空间复杂度O(n)
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            int size = res.size();
            // 时间复杂度O(n)
            // 空间复杂度O(n)
            while (j < size) {
                List<Integer> newList = new ArrayList<>(res.get(j));
                newList.add(nums[i]);
                res.add(newList);
                j++;
            }
        }
        return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }


    // 也可用深度优先
    private void dfs(List<List<Integer>> res, List<Integer> tempList, int[] nums, int index) {
        res.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 6};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
