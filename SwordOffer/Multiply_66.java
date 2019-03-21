
public class Multiply_66 {

	public int[] multiply(int[] A) {
		if (A==null || A.length<2) {
			return null;
		}
		
		int[] B=new int[A.length];
		B[0]=1;
		for(int i=1;i<A.length;i++)
		{
			B[i]=B[i-1]*A[i-1];
		}
		
		int d=1;
		for(int i=A.length-2;i>=0;i--)
		{
			d*=A[i+1];//¼ÆËãD[i]
			
			B[i]=B[i]*d;
		}
		
		return B;
	}
}
