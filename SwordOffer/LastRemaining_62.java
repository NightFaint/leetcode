import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LastRemaining_62 {

	/*
	 * ѭ������
	 * ʱ�临�Ӷ�O(m*n),�ռ临�Ӷ�O(m)
	 */
	public int lastRemaining(int n,int m) {
		if (n<=0 || m<=0) {
			return -1;
		}
		
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++)
			list.add(i);
		int p=0;//ָʾ�±�
		while(list.size()>1)
		{
			for(int k=1;k<m;k++)//ɾ����m���ڵ㣬����p���ڵ�һ���ڵ㣬��ǰ��m-1���ڵ�
			{
				p++;
				
				//��������ĩβ����ص����
				if (p==list.size()) {
					p=0;
				}
			}
			
			list.remove(p);
			
			//���ɾ�������������һ���ڵ㣬��ص����
			if (p==list.size()) {
				p=0;
			}
		}
		
		return list.get(0);
	}
	
	/*
	 * ȡ���������ģ��ܶ�ѭ������
	 * ��Ϊn % n == 0������ȡ������Զ�����˵�����β��ʱ��Ҫת���±�0�����⡣
	 * ���Ա���ֻ����removeIndex = ��removeIndex + (m -1)�� % list.size
	 * ���ܵõ�����Ҫɾ����Ԫ�ص��±ꡣ
	 */
	
	public int lastRemaining2(int n,int m) {
		if (n<=0 || m<=0) {
			return -1;
		}
		
		List<Integer> list=new LinkedList<>();
		for(int i=0;i<n;i++)
			list.add(i);
		int removeIndex=0;
		while(list.size()>1)
		{
			removeIndex=(removeIndex+(m-1))%list.size();
			list.remove(removeIndex);
		}
		
		return list.get(0);
	}
	
	/*
	 * Լɪ������
	 */
	
	public int lastRemaining3(int n,int m) {
		if (n<=0 || m<=0) {
			return -1;
		}
		
		int last=0;
		for(int i=2;i<=n;i++)
			last=(last+m)%i;
		return last;
	}
}
