import java.util.Random;

public class MySort {

//	 冒泡排序：最优为O(n),最坏为O(n^2),平均O(n^2）
	public void bubbleSort(int[] nums) {
		boolean doSwap=false;
		for(int i=0;i<nums.length-1;i++)
		{
			for(int j=0;j<nums.length-1-i;j++)
			{
				if (nums[j]>nums[j+1]) {
					swap(nums, j, j+1);
					doSwap=true;
				}
			}
			if (!doSwap) {
				return;
			}
		}
	}
	
//	选择排序：O(n^2)
	public void selectSort(int[] nums) {
		for(int i=0;i<nums.length-1;i++)
		{
			int k=i;
			for(int j=i+1;j<nums.length;j++)
			{
				if (nums[j]<nums[k]) {
					k=j;
				}
			}
			if (k!=i) {
				swap(nums, i, k);
			}
		}
		
	}
	
	//复杂度：O(n^2)，best case:O(n)
	public void insertionSort(int[] nums) {
		for(int i=1;i<nums.length;i++)
		{
			int k=nums[i];
			int j=i-1;
			if (nums[j]>nums[i]) {
				for(j=i-1;j>=0&&nums[j]>k;j--)
				{
					nums[j+1]=nums[j];
				}
				nums[j+1]=k;
			}
		}
	}
	
	//复杂度O(nlgn)
	public void quickSort(int[] nums) {
		int low=0;
		int high=nums.length-1;
		quickSort_help(nums, low, high);
	}
	
	private void quickSort_help(int[] nums,int low,int high) {
		if (low<high) {
			int k=randomize_partition(nums, low, high);
			quickSort_help(nums, low, k-1);
			quickSort_help(nums, k+1, high);
		}
	}
	
	private int partition(int[] nums,int low,int high) {
		int pivot=nums[high];
		int i=low-1;
		
		for(int j=low;j<high;j++)
		{
			if (nums[j]<pivot) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i+1, high);
		return i+1;
	}
	
	private int randomize_partition(int[] nums,int low,int high) {
		Random random=new Random();
		int i=random.nextInt(high-low+1)+low;
		swap(nums, i, high);
		return partition(nums, low, high);
	}
	
	
	public void mergeSort(int[] nums) {
		int l=0;
		int h=nums.length-1;
		mergeSort_help(nums, l, h);
		
	}
	
	private void mergeSort_help(int [] nums,int l,int h) {
		if(l<h)
		{
			int m=(l+h)/2;
			mergeSort_help(nums, l,m);
			mergeSort_help(nums, m+1, h);
			merge(nums, l, m, h);
		}
	}
	
	private void merge(int[] nums,int l,int m,int h) {
		int n1=m-l+1;
		int n2=h-m;
		
		int[] array1=new int[n1];
		int[] array2=new int[n2];
		
		for(int i=0;i<n1;i++)
		{
			array1[i]=nums[l+i];
		}
		
		for(int i=0;i<n2;i++)
		{
			array2[i]=nums[m+1+i];
		}
		int k=l;
		
		int i=0;
		int j=0;
		while(i<n1 && j<n2)
		{
			if (array1[i]<array2[j]) {
				nums[k]=array1[i];
				i++;
			}
			else {
				nums[k]=array2[j];
				j++;
			}
			k++;
		}
		while (i<n1) {
			nums[k]=array1[i];
			i++;
			k++;
		}
		while (j<n2) {
			nums[k]=array2[j];
			j++;
			k++;
		}
	}
	
	private void swap(int[] nums,int i,int j)
	{
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
