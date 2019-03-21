import java.util.ArrayList;
import java.util.List;

public class Combination_38_2 {

	public List<String> combination(String str) {
		List<String> list=new ArrayList<>();
		
		if (str==null || str.length()==0) {
			return list;
		}
		
		StringBuilder sb=new StringBuilder();
		//�Ѽ�����Ϊi�����
		for(int i=1;i<str.length();i++)
		{
			collect(str, sb, i, list);
		}
		return list;
		
	}
	
	private void collect(String str,StringBuilder sb,int num,List<String> list) {
		// ����if˳�򲻿ɽ���������C(n, n)������뵽list�У���collect("", sb, 0)ʱ��Ҫ���ж�num==0��������ж�str.length ==0�������ٵݹ�
		if (num==0) {
			if (!list.contains(sb.toString())) {
				list.add(sb.toString());
			}
		}
		 // ��strΪ""ʱ��ֱ�ӷ��أ���Ȼ��һ��charAt(0)�ͻ�Խ��
		if (str.length()==0) {
			return;
		}
		// ��ʽC(n, m) = C(n-1, m-1)+ C(n-1, m)
        // ��һ���ַ�������еĵ�һ���ַ�����ʣ�µ�n-1���ַ���ѡm-1���ַ�
		sb.append(str.charAt(0));
		collect(str.substring(1), sb, num-1, list);
		// ��һ���ַ���������еĵ�һ���ַ�����ʣ�µ�n-1���ַ���ѡm���ַ�
		sb.deleteCharAt(sb.length()-1);
		collect(str.substring(1), sb, num, list);
		
	}
}
