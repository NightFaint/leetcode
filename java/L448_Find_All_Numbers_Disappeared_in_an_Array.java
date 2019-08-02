import java.util.ArrayList;
import java.util.List;

public class L448_Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 把数组元素数值对应的索引（数组元素-1）全部变为负值，则数组中没有变负值的索引即是没有出现过的元素
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
