
public class InversePairs_51 {
	
	public int inversePairs(int[] array) {
		if (array==null) {
			return 0;
		}
		
		int[] aux=new int[array.length];
		return sort(array, aux, 0, array.length-1);
	}
	
	private int sort(int[] array,int[] aux,int low,int high) {
		if (low>=high) {
			return 0;
		}
		int mid=(high+low)/2;
		int left=sort(array, aux, low,mid);
		int right=sort(array, aux, mid+1, high);
		return left+right+merge(array, aux, low, mid, high);
	}
	
	private int merge(int[] array,int[] aux,int low,int mid,int high) {
		int count=0;
		int len=(high-low)/2;
		int i=mid;
		int j=high;
		for(int k=low;k<=high;k++)
			aux[k]=array[k];
		for(int k=high;k>=low;k--)
		{
			if (i<low) {
				array[k]=aux[j--];
			}
			else if (j<mid+1) {
				array[k]=aux[i--];
			} 
			else if (aux[i]>aux[j]) {
				array[k]=aux[i--];
				count+=j-low-len;
			}
			else {
				array[k]=aux[j--];
			}
		}
		return count;
	}
}
