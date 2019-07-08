import java.util.HashMap;
import java.util.Map;

public class L454_4SumII {
    /**
     *  空間換時間
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> sums = new HashMap<>();
            for(int a : A) {
                for(int b : B) {
                    int sum = a + b;
                    sums.put(sum, sums.getOrDefault(sum, 0) + 1);
                }
            }

            int res = 0;

            for (int c : C) {
                for (int d : D) {
                    int sum = -(c + d);
                    res += sums.getOrDefault(sum, 0);
                }
            }
            return res;
        }
}
