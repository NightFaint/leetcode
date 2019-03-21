package leetcode;

import java.lang.annotation.Retention;

public class Rotate_String_796 {
	

	//4ms
	public boolean rotateString1(String A, String B) {
		if (A.length()!=B.length()) {
			return false;
		}
		
		else {
			if (A.equals(B)) {
				return true;
			}
			for(int i=0;i<A.length();i++)
			{
				String rotate=A.substring(i, A.length())+A.substring(0,i);
				if (rotate.equals(B)) {
					return true;
				}
			}
			return false;
		}
        
    }
	
	//2ms
	public boolean rotateString2(String A, String B) {
		if (A==null || B==null) {
			return false;
		}
		if (A.length()!=B.length()) {
			return false;
		}
		B+=B;
		return B.indexOf(A)>-1;
	}

}
