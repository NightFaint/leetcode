public class L905_Sort_Array_By_Parity {
    /**
     * 思想类似于快排的partition，
     * 指定偶数的起始位i = -1；
     * 从左到右遍历，遍历到j,若是偶数,i++,并swap(i,j)保证i及i左边的数都是偶数
     * 复杂度O(n)
     */
    public int[] sortArrayByParity(int[] A) {
        int i = -1;
        for(int j = 0; j < A.length; j++) {
            // 用与位运算判断是否为偶数
            if((A[j] & 1) == 0 ) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
