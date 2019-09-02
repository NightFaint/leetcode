import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0){
            return res;
        }
        // 用数组记录每个字母的起始位置和结束位置，这样每个字母都有一个区间
        // 区间重叠的应该归为一组，跟56题有点类似
        int[][] indexes = new int[26][2];
        for (int i = 0; i < S.length(); i++) {
            //为了区分不存在的字母索引为0，索引位置+1
            int[] arr = indexes[S.charAt(i) - 'a'];
            if (arr[0] == 0) {
                arr[0] = i+1;
            }
            arr[1] = i + 1;
        }
        Arrays.sort(indexes, (a, b) -> a[0] - b[0]);
        // 找到index[i][0]=1，之前的字母都不存在S中
        int cur = 0;
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i][0] == 1) {
                cur = i;
                break;
            }
        }
        while (cur < indexes.length) {
            int left = indexes[cur][0];
            int right = indexes[cur][1];
            while (cur < indexes.length - 1 && right > indexes[cur+1][0]) {
                cur++;
                right = Math.max(right, indexes[cur][1]);
            }
            res.add(right - left + 1);
            cur++;
        }
        return res;
    }

}
