public class L189RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        // O(1)�ⷨ
        // ˼·���ӵ�һ����ʼ�ƶ���nums[0]�Ƶ�index_2 = (0+k)%nums.length ��λ�ã������ƶ�index_2ԭ�е�
        // Ԫ�ص�index_3=(index_2 + k) % nums.length
        // �Դ����ƣ�ֱ��index�ֻص����ʼ��λ�ã���ʱ���ƶ����ƶ��Ѿ��ƶ��������ݣ�����ѭ������ʱ���ƶ���n/k�Σ�
        // �轫index=index+1,�ƶ���һ�����Դ˷�����ֱ���ܹ��ƶ���nums.length��

        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            int current = start;
            // �洢��һ��λ�õ�ֵ
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                // �洢ԭ������
                int temp = nums[next];
                // ��preλ�õ�Ԫ���Ƶ�nextλ��
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
     * �Ƚ��������鷴ת���ٽ�ǰk��Ԫ�ط�ת������ٽ���nums.length - k��Ԫ�ط�ת
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
