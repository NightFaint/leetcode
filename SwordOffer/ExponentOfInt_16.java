
public class ExponentOfInt_16 {

	//设置全局变量来标识是否出错
	boolean invalidInput=false;
	
	public double power(double base,int exponent) {
		if (equal(base, 0.0) && exponent<0 )
		{
			invalidInput=true;
			return 0;
		}
		
		double result=1.0;
		int absExponent=Math.abs(exponent);
		
		result=powerWithUnsignedExponent(base, absExponent);
		
		return exponent<0?1/result:result;
	}
	
	private boolean equal(double x,double y) {
		//精度0.000001
		if (x-y>-0.000001 && x-y<0.000001) {
			return true;
		}
		return false;
	}
	
	private double powerWithUnsignedExponent(double base,int exponent) {
		double result=1.0;
		int absExponent=Math.abs(exponent);
		for(int i=0;i<absExponent;i++)
		{
			result*=base;
		}
		return result;
	}
	
	//高效解法
	private double powerWithUnsignedExponent2(double base,int exponent) {
		if (exponent==0) {
			return 1.0;
		}
		if (exponent==1) {
			return base;
		}
		
		double result=powerWithUnsignedExponent2(base, exponent>>1);
		result*=result;
		
		if ((exponent & 0x1)==1) {
			result*=base;
		}
		return result;
	}
	
}
