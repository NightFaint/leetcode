import java.util.Stack;

public class ReverseLIst_24 {
	
	private class ListNode{
		int val;
		ListNode next=null;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val=val;
		}
	}
	
	/*
	 * ��һ��Ӧ����ջ
	 * �ռ临�Ӷ�O(n),ʱ�临�Ӷ�O(n)(�������飩
	 */
	public ListNode reverseList(ListNode pHead ) {
		if (pHead==null || pHead.next==null) {
			return pHead;
		}
		
		Stack<ListNode> stack=new Stack<>();
		ListNode cur=pHead;
		while(cur!=null)
		{
			stack.push(cur);
			cur=cur.next;
		}
		
		pHead=stack.pop();
		cur=pHead;
		while(!stack.isEmpty())
		{
			cur.next=stack.pop();
			cur=cur.next;
		}
		cur.next=null;
		return pHead;
	}
	
	/*
	 * ��ָ��
	 * ������������ָ�룬�ֱ�ָ��ǰһ��㡢��ǰ��㡢��һ��㡣
	 * ��ǰ����next������ָ�����ĺ�һ���ģ�
	 * ��������ָ������ǰһ����㣬��ʵ��������ķ�ת��
	 * ���ǵ�ǰ���������һ��������ӶϿ��ˣ�
	 * ����ڷ�ת����֮ǰ��Ҫ���浱ǰ������һ������ָ�롣
	 * �Ա�����ת�Ĺ�����ǰ�ƽ�����ǰָ���ǰһָ��ǰ�ƣ���
	 */
	public ListNode reverseList2(ListNode pHead) {
		if (pHead==null || pHead.next==null) {
			return pHead;
		}
		
		ListNode pre=null;
		ListNode cur=pHead;
		ListNode next=null;
		while(cur!=null)
		{
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		return pre;
	}

}
