import java.util.ArrayList;
import java.util.Collections;

public class Permutation_38 {

	public ArrayList<String> permutation(String str ) {
		
		ArrayList<String> list=new ArrayList<>();
		if (str==null || str.length() <=0) {
			return list;
		}
		
		char[] chars=str.toCharArray();
		collect(chars, 0, list);
		Collections.sort(list);
		return list;
	}
	
	private void collect(char[] chars,int begin,ArrayList<String> list) {
		if (begin==chars.length-1) {
			String s=String.valueOf(chars);
			if (!list.contains(s)) {
				list.add(s);
			}
			return;
		}
		
		for(int i=begin;i<chars.length;i++)
		{
			if (i!=begin && chars[i]==chars[begin]) {
				continue;
			}
			swap(chars, begin, i);
			collect(chars, begin+1, list);
			swap(chars, begin, i);
		}
	}
	
    private void swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }
}
