public class L88_Merge_Sorted_Array {
    /**
     * time:O(m+n)
     * space: O(m)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 新建一个数组array存储num1前m个元素，再用mergesort merge array和nums2到nums1
        // space O(m)
        int[] array = new int[m];
        // time O(m)
        for(int i = 0; i < m; i++) {
            array[i] = nums1[i];
        }
        // 接下来就是merge操作，复杂度O(m+n)
        int i = 0;
        int j = 0;
        int k = 0;
        for(; k < m + n; k++) {
            if(i < m && j < n) {
                if(array[i] > nums2[j]) {
                    nums1[k] = nums2[j];
                    j++;
                } else {
                    nums1[k] = array[i];
                    i++;
                }
            } else {
                break;
            }
        }
        while(i < m) {
            nums1[k] = array[i];
            i++;
            k++;
        }
        while(j < n){
            nums1[k] = nums2[j];
            j++;
            k++;
        }

    }
}
