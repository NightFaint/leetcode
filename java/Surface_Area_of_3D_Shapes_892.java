package leetcode;

public class Surface_Area_of_3D_Shapes_892 {
    public int surfaceArea(int[][] grid) {
    	int total=0;
    	int change=0;
    	for(int i=0;i<grid.length;i++)
    	{
    		for(int j=0;j<grid[0].length;j++)
    		{
    			change=grid[i][j]>0?grid[i][j]*4+2:0;
    			total+=change;
    			if (j<grid[0].length-1) {
					total-=Math.min(grid[i][j], grid[i][j+1])*2;
				}
    			if (i<grid.length-1) {
					total-=Math.min(grid[i][j], grid[i+1][j])*2;
				}
    		}
    	}
    	return total;
        
    }

}
