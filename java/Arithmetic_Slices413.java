package leetcode;

public class Arithmetic_Slices413 {
    public int numberOfArithmeticSlices(int[] A) 
    {
        if(A.length<3)
            return 0;
        int j=0,dp=0,sum=0;
        for(int i=1;i<A.length-1;++i)
        {
            if(A[i-1]-A[i]==A[i]-A[i+1])
            {
                j++;//以A[i+1]结尾的等差数列的数量，如果条件符合，则等于以A[i]结尾的等差数列数量+1
                dp=dp+j;//数组A[？:i+2]的等差数列的数量
            }
            else
            {
                j=0;
                sum+=dp;
                dp=0;
            }
        }
        return sum+=dp;
    }
}
