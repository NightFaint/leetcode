import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class L969_Pancake_Sorting {
    public List<Integer> pancakeSort(int[] A) {
        // 找出最大值所在的索引位置maxIndex
        // flip(A,maxIndex + 1)最大值即在A[0]的位置
        // flip(A,A.length)最大值即最A[A.length-1]位置
        // 再对A[0-A.length-2]做上述操作，如此反复
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length - 1; i++){
            int maxIndex = maxIndex(A, 0, A.length - 1 - i);
            flip(A, maxIndex + 1);
            res.add(maxIndex + 1);
            flip(A, A.length - i);
            res.add(A.length - i);
        }
        return res;
    }

    private int maxIndex(int[] A, int low, int high) {
        int max = A[low];
        int maxIndex = low;
        for(int i = low + 1; i <= high; i++){
            if (A[i] > max){
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void flip(int[] A, int k){
        int low = 0;
        int high = k - 1;
        while (low < high){
            int temp = A[low];
            A[low] = A[high];
            A[high] = temp;
            low++;
            high--;
        }
    }

    @Test
    public void test(){
        int[] A = {3,2,4,1};
        pancakeSort(A);
    }
}
