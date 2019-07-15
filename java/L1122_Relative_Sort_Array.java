import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1122_Relative_Sort_Array {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        byte[] is_containeed = new byte[arr1.length];
        List<Integer> res = new ArrayList<>();
        for (int e2 : arr2) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == e2) {
                    res.add(arr1[i]);
                    is_containeed[i] = 1;
                }
            }
        }
        List<Integer> remains = new ArrayList<>();
        for (int i = 0; i < is_containeed.length; i++) {
            if (is_containeed[i] == 0) {
                remains.add(arr1[i]);
            }
        }
        Collections.sort(remains);
        res.addAll(remains);
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = res.get(i);
        }
        return arr1;
    }

    /**
     * counting sort
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int n : arr1) {
            count[n]++;
        }
        int i = 0;
        for (int n : arr2) {
            while (count[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < count.length; n++) {
            while (count[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

}
