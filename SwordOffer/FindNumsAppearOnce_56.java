
public class FindNumsAppearOnce_56 {

	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
    //��num1[0],num2[0]����Ϊ���ؽ��
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[])
    {
    	if (array==null || array.length<2) {
			return;
		}
    	
    	int res=0;
    	//�õ���������һ�ε��������
    	for(int i=0;i<array.length;i++)
    	{
    		res^=array[i];
    	}
    	
    	int index=findFirstBitIs1(res);
    	// �Ե�nλ�ǲ���1Ϊ��׼���������ֳ�����
        // ��ͬ����һ���ᱻ�ֵ�ͬһ�������飬
    	//��Ϊ��ͬ�����ֵ�nλҲ����ͬ�ģ�
    	//ֻ����һ�ε����������ֿ϶�����ֵ�һ��������
    	//��Ϊ���ǵĵ�nλ���ֵΪ1��˵�����ǵ�nλ����ͬ
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
	
    //�ҳ�������������һ��Ϊ1������
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
	
	//�ж�num��indexbitλ�ǲ���1
	private boolean isBit1(int num,int indexBit) {
		num=num>>indexBit;
		return (num&1) == 1;
	}
}
