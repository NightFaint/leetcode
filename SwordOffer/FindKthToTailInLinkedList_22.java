
/*
 * 设置两个指针a、b，若当a指针到链表末尾时，
 * b指针正好指向倒数第k个结点，此时返回指针b处的结点即可，
 * 这时a指针的位置减去b指针的位置等于k-1，如果将两个指针同步地倒退到链表头结点处，
 * b指针会位于位置0处的头结点，而a指针位于位置k-1处的结点。所以如果我们反过来思考：
 * 一开始先让a指针走k-1步，b不动，之后两个指针同时移动，直到a到了链表末尾，
 * 此时返回b指针处的结点就是倒数第k个结点。**这种方法只需遍历一次链表。**时间复杂度为O(n)。
 */
public class FindKthToTailInLinkedList_22 {

	private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
	
	public ListNode findKthToTail(ListNode pHead,int k) {
		if (pHead == null || k==0) {
			return null;
		}
		
		ListNode p1 = pHead;
		ListNode p2 =pHead;
		while(k>1)
		{
			if (p2.next!=null) {
				p2=p2.next;
			}
			else {
				return null;
			}
			k--;
		}
		while(p2.next != null)
		{
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
		
	}
}
