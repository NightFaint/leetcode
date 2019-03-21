import java.util.Stack;

public class FindFirstCommonNode_52 {

	private class ListNode{
		int val;
		ListNode next;
		
	}
	
	//����ջ:O(m+n),�ռ临�Ӷ�O(m+n)
	//�Ƚ���������ֱ���ջ
	//Ȼ��һ��һ����ջ������ջ�Ľڵ㲻ͬ
	//����һ���ڵ��ǵ�һ�������ӽڵ�
	public ListNode findFirstCommonNode(ListNode node1,ListNode node2) {
		Stack<ListNode> stack1=new Stack<>();
		Stack<ListNode> stack2=new Stack<>();
		while(node1!=null)
		{
			stack1.push(node1);
			node1=node1.next;
		}
		while(node2!=null)
		{
			stack2.push(node2);
			node2=node2.next;
		}
		ListNode result=null;
		while(!stack1.isEmpty() && !stack2.isEmpty())
		{
			if (stack1.peek()==stack2.pop()) {
				result=stack1.pop();
			}
			else
			{
				return result;
			}
		}
		return result;
	}
	
	/*O(m+n)������Ҫ����ռ�
	 * �ȱ���������¼ÿ��������
	 *��һ�α������� 
	 * �Ƚϳ�(���賤m���ڵ�)����������m��
	 * Ȼ����������ͬʱ�ƶ�
	 * ��һ����ͬ�Ľڵ���ǵ�һ�������ӽڵ�
	 */
	
	public ListNode findFirstCommonNode2(ListNode node1,ListNode node2) {
		int len1=0;
		int len2=0;
		ListNode cur=node1;
		while(cur!=null)
		{
			len1++;
			cur=cur.next;
		}
		cur=node2;
		while(cur!=null)
		{
			len2++;
			cur=cur.next;
		}
		if (len1>len2) {
			for(int i=0;i<len1-len2;i++)
			{
				node1=node1.next;
			}
		}
		if (len2>len1) {
			for(int i=0;i<len2-len1;i++)
			{
				node2=node2.next;
			}
		}
		
		while(node1!=null && node2!=null)
		{
			if (node1==node2) {
				return node1;
			}
			else {
				node1=node1.next;
				node2=node2.next;
			}
		}
		return null;
	}
	
	//���У����ü��ϲ�������ظ�Ԫ�ص�����
//	��ν���������ʵ������ȫһ����Ԫ�أ���Set���ܴ�����ͬԪ�أ�����һ�����Ԫ��ʧ��ʱ���ý����ǵ�һ�����������
}
