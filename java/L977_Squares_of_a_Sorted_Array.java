import org.junit.Test;

import java.util.ArrayList;

public class L977_Squares_of_a_Sorted_Array {
    /**
     * 思路类似于insertionSort
     * 复杂度O(n^2)
     * 没有利用到原数组是有序数组的特性
     */
    public int[] sortedSquares(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : A) {
            insert(list, ele * ele);
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    private void insert(ArrayList<Integer> list, int value) {
        if(list.size() == 0) {
            list.add(value);
        }
        else {
            int index = list.size() - 1;
            while(index > 0 && list.get(index) > value) {
                index--;
            }
            list.add(index, value);
        }
    }

    /**
     * 思路：原数组是有序数组，分为两个数组：大于0和小于0的
     * 两个数组的元素分别平方后仍有序
     * 利用mergeSort中merge的思想，再把两个有序数组组合成一个有序的数组
     */
    public int[] sortedSquares2(int[] A) {
        int bound = 0;
        // 找出第一个大于0的元素的索引
        for(int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                bound = i;
                break;
            }
        }
        int[] neg = new int[bound];
        int[] pos = new int[A.length - bound];
        // 为两个数组赋值，都是从小到大的有序数组
        for (int i = 0; i < A.length; i++) {
            if (i < bound) {
                neg[bound - 1 - i] =A[i] * A[i];
            }
            else {
                pos[i - bound] = A[i] * A[i];
            }
        }
        // 返回的数组
        int[] res = new int[A.length];
        // i,j分别指示两个数组的索引位置
        int i = 0;
        int j = 0;
        for (int k = 0; k < res.length; k++){
            if (i < bound && j < res.length - bound) {
                if (neg[i] < pos[j]){
                    res[k] = neg[i];
                    i++;
                }
                else {
                    res[k] = pos[j];
                    j++;
                }
            }
            else if (i >= bound) {
                System.arraycopy(pos, j, res, k, res.length - bound - j);
                break;
            }
            else {
                System.arraycopy(neg, i, res, k, bound - i);
                break;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] a = {-4,-1,0,3,10};
        int[] squares2 = sortedSquares2(a);
    }
}
