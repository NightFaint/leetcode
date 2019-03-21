package leetcode;

public class Transpose_Matrix_867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] transpose(int[][] A) {
        if (A==null ||A.length==0) {
			return A;
		}
		int row=A.length;
        int column=A[0].length;
        
        int[][] newA=new int[column][row];
        
        for(int i=0;i<row;i++)
        	for(int j=0;j<column;j++)
        	{
        		newA[j][i]=A[i][j];
        	}
        return newA;
    }

}
