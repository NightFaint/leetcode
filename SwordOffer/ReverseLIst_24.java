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
	 * 第一反应：用栈
	 * 空间复杂度O(n),时间复杂度O(n)(遍历两遍）
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
	 * 三指针
	 * 可以设置三个指针，分别指向前一结点、当前结点、后一结点。
	 * 当前结点的next本来是指向它的后一结点的，
	 * 现在让其指向它的前一个结点，就实现了链表的反转。
	 * 但是当前结点与它后一个结点链接断开了，
	 * 因此在反转链表之前需要保存当前结点的下一个结点的指针。
	 * 以便链表反转的过程向前推进（当前指针和前一指针前移）。
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
