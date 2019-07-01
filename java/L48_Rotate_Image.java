import org.junit.Test;

public class L48_Rotate_Image {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 1) {
            return;
        }
        int n = matrix.length;
        int left = 0;
        int right = n - 1;
        // 从四周往中心移动元素
        while(left < right) {
            // 移动上面的一行（除最后一个元素）到右边的列
            // 右边的列到下边的行
            // 下边的行到左边的列
            // 左边的列到上边的行
            for(int i = left; i < right; i++) {
                // 移动上面的一行（除最后一个元素）到右边的列
                // 先存储要目标位置的元素
                int rightCol = matrix[i][right];
                matrix[i][right] = matrix[left][i];
                // 右边的列到下边的行
                int downRow = matrix[right][right + left - i];
                matrix[right][right +left - i] = rightCol;
                // 下边的行到左边的列
                int leftCol = matrix[right + left - i][left];
                matrix[right + left - i][left] = downRow;
                // 左边的列到上边的行
                matrix[left][i] = leftCol;
            }
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }
}
