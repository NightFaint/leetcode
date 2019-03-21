
public class PathIn2DArray_12 {
public boolean hasPath(char[] matrix,int rows,int cols,char[] str) {
	if (matrix==null || rows<=0 ||cols<=0 ||str==null) {
		return false;
	}
	
	boolean[] marked=new boolean[matrix.length];
	for(int row=0;row<rows;row++)
	{
		for(int col=0;col<cols;col++)
		{
			if (hasPathTo(matrix, rows, cols, row, cols, str, 0, marked)) {
				return true;
			}
		}
	}
	return false;
}
	
	
	private boolean hasPathTo(char[] matrix, int rows, int cols, int row, int col, char[] str, int len, boolean[] marked)
	{
		int index=row*cols+col;
		if (row < 0 || row > rows || col < 0 || col > cols || matrix[index] != str[len] || marked[index] ) {
			return false;
		}
		
		if (len == str.length-1) {
			return true;
		}
		
		marked[index]=true;
		
		if (hasPathTo(matrix, rows, cols, row, col-1, str, len+1, marked)
				||hasPathTo(matrix, rows, cols, row-1, col, str, len+1, marked)
				||hasPathTo(matrix, rows, cols, row, col+1, str, len+1, marked)
				||hasPathTo(matrix, rows, cols, row+1, col, str, len+1, marked)) {
			return true;
		}
		
		marked[index] =false;
		return false;
	}
}
