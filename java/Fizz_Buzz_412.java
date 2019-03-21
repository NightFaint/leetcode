package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz_412 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<String> strings=fizzBuzz(15);
		System.out.println(strings);

	}
	
    public static List<String> fizzBuzz(int n) 
    {
        List<String> ss=new ArrayList<>();
        String s="";
        for(int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0)
                s="FizzBuzz";
            else if(i%3==0)
                s="Fizz";
            else if(i%5==0)
                s="Buzz";
            else
                s=Integer.toString(i);
            ss.add(s);
        }
        return ss;
        
    }

}
