import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class L560_Subarray_Sum_Equals_K {
    /**
     * 目标:找到sum[i, j]使得sum[i, j] = k;
     * 已知：sum[0, i-1] + sum[i, j] = sum[0, j]
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // 储存 Map<sum[0, i-1], frequency>
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化，当sum[0, j] = sum[i, j]相等时，即i=0,
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int cur : nums) {
            sum += cur;
            // 如果map中存在sum[0, i-1] = sum - k = sum[0, j] - sum[i, j]，则说明数组中存在有一个或多个i，使得sum[0, i-1] = sum[0, j] - sum[i, j],sum[i, j] = k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {-1,-1,1,2};
        System.out.println(subarraySum(nums, 0));
    }
}
