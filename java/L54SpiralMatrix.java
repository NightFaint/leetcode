import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int colEnd = matrix[0].length - 1;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int rowBegin = 0;
        while (colBegin <= colEnd && rowBegin <= rowEnd) {
            // 右往左
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            // 上往下
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                // 右往左
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // 下往上
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        if(matrix == null || matrix.length == 0) return result;

        int startRow = 0, endRow = matrix.length-1;
        int startCol = 0, endCol = matrix[0].length - 1;
        int dir = 0;

        while(startRow <= endRow && startCol <= endCol) {
            switch(dir) {
                case 0: //RIGHT
                    for(int col = startCol; col <= endCol; col++)
                        result.add(matrix[startRow][col]);
                    startRow++;
                    break;
                case 1: //DOWN
                    for(int row = startRow; row <=endRow; row++)
                        result.add(matrix[row][endCol])    ;
                    endCol--;
                    break;
                case 2://LEFT
                    for(int col = endCol; col >= startCol; col --)
                        result.add(matrix[endRow][col]);
                    endRow--;
                    break;
                case 3://UP
                    for(int row = endRow; row >= startRow; row--)
                        result.add(matrix[row][startCol]);
                    startCol++;
                    break;
            }
            dir = (dir+1)%4;
        }

        return result;
    }

    @Test
    public void test() {
        int[][] matrix = {{6,9,7}};
        final List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
}
