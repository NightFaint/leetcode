import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56MergeIntervals {
    /**
     * 先按首位置进行排序;
     *
     * 接下来,如何判断两个区间是否重叠呢?比如 a = [1,4],b = [2,3]
     *
     * 当 a[1] >= b[0] 说明两个区间有重叠.
     *
     * 但是如何把这个区间找出来呢?
     *
     * 左边位置一定是确定，就是 a[0]，而右边位置是 max(a[1], b[1])
     *
     * 所以,我们就能找出整个区间为:[1,4]
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 数组在java中也是一个类，由jvm自动生成
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            // 排序过了，left肯定比interval[j][0]小，j=i+1,i+2,...
            int left = intervals[i][0];
            // right可能大于intervaal[j][1],j=i+1,i+2,...此时需要合并区间
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        // new int[0][]防止空异常
        // 同时，list.toArray(T[] arr)在arr大小不够的时候会新建一个足够大的数组
        return res.toArray(new int[0][]);
    }
}
