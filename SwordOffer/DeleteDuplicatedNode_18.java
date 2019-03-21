
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
		
		ListNode pre=null;// ��ǰ����ǰһ�����
		ListNode cur=pHead;
		
		while(cur != null && cur.next !=null)
		{
			if (cur.val == cur.next.val) {
				int val=cur.val;
				// �������к�cur��ͬ��ֵ
				while (cur != null && cur.val ==val) {
					cur=cur.next;
				}
				// ����ѭ���õ����ǵ�һ����cur.val��ͬ�Ľ��
                // preΪ��˵��ͷ�������ظ���㣬�����Ҫ��������ͷ���
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
