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
                j++;//��A[i+1]��β�ĵȲ����е�����������������ϣ��������A[i]��β�ĵȲ���������+1
                dp=dp+j;//����A[��:i+2]�ĵȲ����е�����
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
