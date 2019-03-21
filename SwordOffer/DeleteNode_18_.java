
public class DeleteNode_18_ {

	private class Node {
        int val;
        Node next;
    }
	
	/**
	* ��toBeDel����һ�����j��ֵ���Ƹ�toBeDel��Ȼ��toBeDelָ��j����һ�����
	* O(1)
	*/
	public void deleteNode(Node first, Node toBeDel)
	{
		if (first==null || toBeDel==null) {
			return;
		}
		Node nextNode = toBeDel.next;
		if (nextNode != null) {
			toBeDel.val=nextNode.val;
			toBeDel.next=nextNode.next;
		}
		else {
			if (first == toBeDel) {
				first=first.next;
			}
			else {
				Node cur=first;
				while(cur.next != toBeDel)
					cur=cur.next;
				cur.next=null;
			}
		}
	}
}
