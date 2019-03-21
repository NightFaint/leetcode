
public class IsNumeric_20 {
	
	public boolean isNumeric2(char[] str) {
        int len = str.length;
        if (len==1) {
			if (str[0]<'0' || str[0]>'9') {
				return false;
			}
		}
        boolean sign = false, decimal = false, hasE = false;
        for(int i=0;i<len;i++)
        {
        	if (str[i] == '+' || str[i] == '-') {
				if (!sign && i>0 && str[i-1] != 'e' && str[i-1] != 'E') {
					return false;
				}
				if (sign && str[i-1] != 'e' && str[i-1] != 'E') {
					return false;
				}
				sign=true;
				
			}
        	else if (str[i] == 'e' || str[i]=='E') {
				if (i==len-1) {
					return false;
				}
				if (hasE) {
					return false;
				}
				hasE=true;
			}
        	else if (str[i] == '.') {
				if (hasE || decimal) {
					return false;
				}
				if (i>0 && (str[i-1] == '+'||str[i-1] == '-')) {
					return false;
				}
				if(i<len-1 && (str[i+1]=='e' || str[i+1]=='E'))
				{
					return false;
				}
				decimal=true;
			}
        	else if(str[i]<'0' || str[i] > '9'){
				return false;
			}
        }
        return true;
    }
	
	public static void main(String[] args) {
		char[] test={'.','2'};
		char[] test2={'+','.','2'};
		char[] test3={'+','.','2','e'};
		char[] test4={'.','e','+','4'};
		char[] test5={'1','2','3','.'};
		System.out.println(new IsNumeric_20().isNumeric2(test5));
	}
}
