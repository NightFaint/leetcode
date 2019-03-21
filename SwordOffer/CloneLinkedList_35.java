
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
     * ���롢���ӡ����������
     */
    public ListNode clone(ListNode head) {
		if (head == null) {
			return null;
		}
		clone(head);
		setCloneSiblings(head);
		return splitList(head);
	}
    
    //���룺��ԭʼ�����ÿ���������һ��ֵ����һ�����½�㣻����oriNode.next == cloneNode�����Ĺ�ϵ��
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
    
    //���ӣ����������½���������ڷ���ԭʼ�����е���Щ���ʱ���ж����Ƿ���sibling��㣬����У����临�ƽڵ��sibling����sibling����һ���ڵ���
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
    
    //��֣������²���Ľڵ�������з��뿪��
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
