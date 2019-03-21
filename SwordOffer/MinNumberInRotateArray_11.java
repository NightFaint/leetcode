//由于有序数组旋转后，被分成了两个有序的子数组，因此可以用二分查找，且左半数组的值全大于等于右半数组的值。
//我们要找的最小元素恰好是右半数组的第一个元素，或者说左半数组末尾后一个元素。
//
//和二分查找一样，一个指针low指向数组首元素，一个high指向尾元素。
//还有一个指针mid，这里注意：mid不是要和哪个特定的值比较来缩小范围，
//根据旋转数组的特点，我们始终将mid和high处的值比较。分三种情况
//
//array[mid] > array[high];此时mid一定还处于左半数组中，而要找的最小值在右半数组中，
//最小值肯定在mid的右边，所以可以直接将low移动到mid的下一个位置，即low = mid + 1。举个例子{3, 4, 5, 1, 2}，
//mid处的5比high处的2大，直接更新low = 3，数组被缩小到{1, 2}
//array[mid] < array[high];此时mid一定处于右半数组中，最小值可能在mid处也可能在mid的左边。
//所以high只能缩小到mid处，即high = low。举个例子{4, 5, 1, 2, 3}，mid处的1小于high处的3，只能将high移动到1处，
//数组缩小为{4, 5, 1}，如果像上面类似令high = mid - 1，最小值再这个例子中就被跳过了！
//array[mid] == array[high];此时无法分辨mid处于左半数组还是右半数组。
//比如{1, 0, 1, 1, 1}和{1, 1, 1, 0, 1}都是数组{0, 1, 1, 1, 1}的旋转数组。
//此时mid处和high处的值一样，若根据low缩小范围，对于{1, 0, 1, 1, 1}最小值将被跳过；
//如果根据high缩小范围，对于{1, 1, 1, 0, 1}最小值也会被跳过。此时的处理方法是暂时放弃二分查找，
//**既然mid处和high处值相同，那么让high--，让mid和high的前一个值继续比较。**如果mid和high处都是最小值，就算放弃了high最后还是会在mid处找到最小值。
//**只要low < high(不含等于)，就不断重复上面过程，最后将范围缩小到只有一个元素后，
//low == high跳出循环。**其实low == high时候还进入循环，也没有错，此时只会造成high--，
//而我们返回的是array[low]，值不会影响，但是何必进行这次无意义的比较呢。

public class MinNumberInRotateArray_11 {

	public int minNumberInRotateArray(int[] nums) {
		if (nums==null || nums.length==0) {
			return 0;
		}
		int left=0;
		int right=nums.length-1;

		while (left<right) {
			int mid=(left+right)/2;
			
			if (nums[mid]>nums[right]) {
				left=mid+1;
			}
			else if (nums[mid]<nums[right]) {
				right=mid;
			}
			else {
				right--;
			}
			
		}
		return nums[left];
	}
}
