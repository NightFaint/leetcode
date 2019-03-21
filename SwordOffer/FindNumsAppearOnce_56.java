
public class FindNumsAppearOnce_56 {

	//num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[])
    {
    	if (array==null || array.length<2) {
			return;
		}
    	
    	int res=0;
    	//得到两个出现一次的数的异或
    	for(int i=0;i<array.length;i++)
    	{
    		res^=array[i];
    	}
    	
    	int index=findFirstBitIs1(res);
    	// 以第n位是不是1为标准，将数组拆分成两个
        // 相同数字一定会被分到同一个子数组，
    	//因为相同的数字第n位也是相同的；
    	//只出现一次的那两个数字肯定不会分到一个数组中
    	//因为他们的第n位异或值为1，说明他们第n位不相同
    	for(int i=0;i<array.length;i++)
    	{
    		if (isBit1(array[i], index)) {
				num1[0]^=array[i];
			}
    		else {
				num2[0]^=array[i];
			}
    	}
    }
	
    //找出从右往左数第一个为1的索引
	private int findFirstBitIs1(int num) {
		int indexBit=0;
		while(num!=0)
		{
			if ((num&1)==1) {
				return indexBit;
			}
			num=num>>1;
			indexBit++;
		}
		return -1;
	}
	
	//判断num第indexbit位是不是1
	private boolean isBit1(int num,int indexBit) {
		num=num>>indexBit;
		return (num&1) == 1;
	}
}
