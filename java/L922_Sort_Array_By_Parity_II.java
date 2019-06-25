public class L922_Sort_Array_By_Parity_II {
    public int[] sortArrayByParityII(int[] A) {
        // 思路1，构建一个新数组，遍历原数组，将数组元素放至新数组适当的索引位置上
        int[] copy = new int[A.length];
        // 指示奇数和偶数索引的位置
        int even = 0;
        int odd = 1;
        for(int i : A){
            if((i & 1) == 0) {
                //偶数
                copy[even] = i;
                even += 2;
            }else{
                //奇数
                copy[odd] = i;
                odd += 2;
            }
        }
        return copy;
    }

    public int[] sortArrayByParityII2(int[] A) {
        // 思路2
        int odd = 1;
        int even = 0;
        while(true) {
            while((A[odd] & 1) == 1 && odd < A.length - 2){
                // 找出第一个奇数索引上不是奇数的位置或者数组最末位索引
                odd+=2;
            }
            while((A[even] & 1) == 0 && even < A.length - 2){
                // 找出第一个偶数索引上不是偶数的位置或者数组最末位索引
                even+=2;
            }
            // 由于偶数和奇数个数一样，则两个放错的数字一一对应
            if((A[odd] & 1) == 0){
                swap(A, odd, even);
            }else{
                //此时odd =  A.length - 1,到达数组末位
                return A;
            }
        }
    }

    private void swap(int[] A,int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
