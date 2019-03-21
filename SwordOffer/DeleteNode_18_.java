
public class DeleteNode_18_ {

	private class Node {
        int val;
        Node next;
    }
	
	/**
	* 将toBeDel的下一个结点j的值复制给toBeDel。然后将toBeDel指向j的下一个结点
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
