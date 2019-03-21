
public class DeleteDuplicatedNode_18 {

	private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
	
	public ListNode deleteDuplication(ListNode pHead)
	{
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		
		ListNode pre=null;// 当前结点的前一个结点
		ListNode cur=pHead;
		
		while(cur != null && cur.next !=null)
		{
			if (cur.val == cur.next.val) {
				int val=cur.val;
				// 跳过所有和cur相同的值
				while (cur != null && cur.val ==val) {
					cur=cur.next;
				}
				// 跳出循环得到的是第一个和cur.val不同的结点
                // pre为空说明头结点就是重复结点，因此需要重新设置头结点
				if (pre==null) {
					pre=cur;
				}
				else {
					pHead.next=cur;
				}
			}
			else {
				pre=cur;
				cur=cur.next;
			}
		}
		return pHead;
	}
	
	public static void main(String[] args) {
		DeleteDuplicatedNode_18 test=new DeleteDuplicatedNode_18();
		ListNode node1=test.new ListNode(2);
		ListNode node2=test.new ListNode(2);
		test.deleteDuplication(node1);
		
	}
}
