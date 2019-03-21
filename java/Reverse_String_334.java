package leetcode;

public class Reverse_String_334 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	public String reverseString(String s) 
	{
		/*
		StringBuilder stringBuilder=new StringBuilder(s);
		return stringBuilder.reverse().toString();
		*/
		char[] arr=s.toCharArray();
		/*
		for(int i=0;i<arr.length/2;i++)
		{
			char temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=temp;
		}
		*/
		int low=0;
		int high=arr.length-1;
		while(low<high)
		{
			char temp=arr[low];
			arr[low]=arr[high];
			arr[high]=temp;
			++low;
			--high;
		}
		return new String(arr);
	}

}
