public class L75SortColors {

    // 基于三路快排,
    // 只要递归一次就行，因为只有三个元素
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int lt = 0;
        int gt = nums.length-1;
        int i = 0;
        while (i <= gt) {
            // [start+1, lt]都是0
            // (lt,i)都是等于1的
            // [gt,end]都是2
            if (nums[i] == 0) {
                swap(nums, i++, lt++);
            } else if (nums[i] == 2) {
                swap(nums, i, gt--);
                // 注意，这里的i不能变，还需要继续判断num[--gt]的大小
            } else {
                i++;
            }
        }


    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
