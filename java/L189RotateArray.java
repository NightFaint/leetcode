public class L189RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        // O(1)解法
        // 思路：从第一个开始移动，nums[0]移到index_2 = (0+k)%nums.length 的位置，接着移动index_2原有的
        // 元素到index_3=(index_2 + k) % nums.length
        // 以此类推，直到index又回到最初始的位置，此时再移动会移动已经移动过的数据，出现循环，此时共移动了n/k次；
        // 需将index=index+1,移动下一个，以此反复，直到总共移动了nums.length次

        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            int current = start;
            // 存储上一个位置的值
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                // 存储原有数字
                int temp = nums[next];
                // 将pre位置的元素移到next位置
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            }while(start != current);
        }
    }

    /**
     * Time:O(n)
     * Space:O(1)
     * 先将整个数组反转，再将前k个元素反转，最后再将后nums.length - k个元素反转
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0 ,nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Time:O(n)
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        if(nums == null || nums.length <= 1 ||  k % nums.length == 0) {
            return;
        }
        int[] dup = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dup[i] = nums[i];
        }
        k = k % nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                nums[i] = dup[nums.length - k + i];
            } else {
                nums[i] = dup[i - k];
            }
        }
    }
}
