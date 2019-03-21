
public class CloneLinkedList_35 {

    private class ListNode {
        int val;
        ListNode next = null;
        ListNode sibling = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    /*
     * 插入、连接、拆分三步法
     */
    public ListNode clone(ListNode head) {
		if (head == null) {
			return null;
		}
		clone(head);
		setCloneSiblings(head);
		return splitList(head);
	}
    
    //插入：在原始链表的每个结点后插入一个值和它一样的新结点；则有oriNode.next == cloneNode这样的关系；
    private void cloneNode(ListNode head) {
		ListNode cur=head;
		while(cur!=null)
		{
			ListNode cloneNode=new ListNode(cur.val);
			cloneNode.next=cur.next;
//			copy.sibling=null;
			cur.next=cloneNode;
			
			cur=cloneNode.next;
		}
	}
    
    //连接：遍历插入新结点后的链表，在访问原始链表中的那些结点时，判断其是否有sibling结点，如果有，则其复制节点的sibling在其sibling的下一个节点上
    //cloneNode=cur.next;cloneNode.sibling=cur.sibling.next;
    private void setCloneSiblings(ListNode head) {
		ListNode cur=head;
		while(cur!=null)
		{
			if (cur.sibling != null) {
				cur.next.sibling=cur.sibling.next;
			}
			cur=cur.next.next;
		}
	}
    
    //拆分：把新新插入的节点从链表中分离开来
    private ListNode splitList(ListNode head) {
    	ListNode cur=head;
		ListNode cloneHead=head.next;
		
		while(cur != null)
		{
			ListNode cloneNode=cur.next;
			cur.next=cloneNode.next;
			if (cloneNode.next !=null) {
				cloneNode.next=cloneNode.next.next;
			}
			cur=cur.next;
		}
		return cloneHead;
		
	}
}
