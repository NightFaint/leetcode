

public class MergeList_25 {
	private class ListNode{
		int val;
		ListNode next=null;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val=val;
		}
	}
	
	/*
	 * 基本按照mergesort的思想把两个链表合并
	 */
	public ListNode  merge(ListNode p1,ListNode p2) {
		if (p1==null || p2 == null) {
			return p1==null?p2:p1;
		}
		ListNode pre=new ListNode(0);
		ListNode cur=pre;
		while(p1!=null && p2 != null)
		{
			if (p1.val < p2.val) {
				cur.next=p1;
				cur=cur.next;
			}
			else {
				cur.next=p2;
				cur=cur.next;
			}
		}
		if (p1 != null) {
			cur.next=p1;
		}
		if (p2 != null) {
			cur.next=p2;
		}
		return pre.next;
		
	}
}
