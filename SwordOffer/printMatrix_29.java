import java.util.ArrayList;

public class printMatrix_29 {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix==null || matrix.length==0) {
			return null;
		}
		ArrayList<Integer> list=new ArrayList<>();
		int rows=matrix.length;
		int cols=matrix[0].length;
		
		int left=0;
		int right=cols-1;
		
		int top=0;
		int bottom=rows-1;
		
		while(left<=right && top<=bottom)
		{
			//�ϣ���������
			for(int i=left;i<=right;i++)
			{
				list.add(matrix[top][i]);
			}
			//�ң���������
			for(int i=top+1;i<=bottom;i++)
			{
				list.add(matrix[i][right]);
			}
			
			//�£���������
			for(int i=right-1;i>=left;i--)
			{
				list.add(matrix[bottom][i]);
			}
			
			//�ϣ���������
			for(int i=bottom-1;i>top;i--)
			{
				list.add(matrix[i][left]);
			}
			left++;
			right--;
			top++;
			bottom--;
			
		}
		return list;
	}
}
