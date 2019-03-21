import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LastRemaining_62 {

	/*
	 * 循环链表
	 * 时间复杂度O(m*n),空间复杂度O(m)
	 */
	public int lastRemaining(int n,int m) {
		if (n<=0 || m<=0) {
			return -1;
		}
		
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++)
			list.add(i);
		int p=0;//指示下标
		while(list.size()>1)
		{
			for(int k=1;k<m;k++)//删除第m个节点，由于p已在第一个节点，再前进m-1个节点
			{
				p++;
				
				//到达链表末尾，则回到起点
				if (p==list.size()) {
					p=0;
				}
			}
			
			list.remove(p);
			
			//如果删除的正好是最后一个节点，则回到起点
			if (p==list.size()) {
				p=0;
			}
		}
		
		return list.get(0);
	}
	
	/*
	 * 取余操作可以模拟很多循环问题
	 * 因为n % n == 0，所以取余操作自动解决了到链表尾部时需要转到下标0的问题。
	 * 所以本题只需用removeIndex = （removeIndex + (m -1)） % list.size
	 * 就能得到本次要删除的元素的下标。
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
	 * 约瑟夫环问题
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
