import java.util.ArrayList;
import java.util.List;

public class Combination_38_2 {

	public List<String> combination(String str) {
		List<String> list=new ArrayList<>();
		
		if (str==null || str.length()==0) {
			return list;
		}
		
		StringBuilder sb=new StringBuilder();
		//搜集长的为i的组合
		for(int i=1;i<str.length();i++)
		{
			collect(str, sb, i, list);
		}
		return list;
		
	}
	
	private void collect(String str,StringBuilder sb,int num,List<String> list) {
		// 两个if顺序不可交换，否则C(n, n)不会存入到list中：即collect("", sb, 0)时，要先判断num==0存入后，再判断str.length ==0决定不再递归
		if (num==0) {
			if (!list.contains(sb.toString())) {
				list.add(sb.toString());
			}
		}
		 // 当str为""时候直接返回，不然下一句charAt(0)就会越界
		if (str.length()==0) {
			return;
		}
		// 公式C(n, m) = C(n-1, m-1)+ C(n-1, m)
        // 第一个字符是组合中的第一个字符，在剩下的n-1个字符中选m-1个字符
		sb.append(str.charAt(0));
		collect(str.substring(1), sb, num-1, list);
		// 第一个字符不是组合中的第一个字符，在剩下的n-1个字符中选m个字符
		sb.deleteCharAt(sb.length()-1);
		collect(str.substring(1), sb, num, list);
		
	}
}
