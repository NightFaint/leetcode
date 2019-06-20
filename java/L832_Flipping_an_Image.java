
public class L832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0){
            return A;
        }
        int cols = A[0].length;
        int rows = A.length;
        for(int i = 0; i < rows; i++) {
            reverse(A[i]);
            invert(A[i]);
        }
        return A;
    }

    /**
     * 将一个数组反转
     * @param a
     */
    private void reverse(int[] a){
        if(a == null || a.length <= 1){
            return;
        }
        int low = 0;
        int high = a.length - 1;
        while(low < high) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
    }

    /**
     * 数组1->0,0->1
     * @param a
     */
    private void invert(int[] a){
        if(a == null || a.length == 0){
            return;
        }
        for(int i=0; i < a.length; i++){
            a[i] = (a[i] ^ 1);
        }
    }
}
