import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class L46_Permutations {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 深度优先
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        help(0, nums, new ArrayList<>());
        return res;
    }

    private void help(int index, int[] nums, List<Integer> list) {
        if (index == nums.length - 1) {
            list.add(nums[index]);
            res.add(new ArrayList<>(list));
            list.remove(index);
            return;
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(index, i, nums);
                list.add(nums[index]);
                help(index + 1, nums, list);
                list.remove(index);
                swap(index, i, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}
