
public class EntryNodeOfLoop_23 {

	private class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val=val;
		}
	}
	
	
	/*
	 * 剑指offer上解法
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode meetNode=meetingNode(pHead);
		if (meetNode == null) {
			return null;
		}
		
		int countLoop=1;
		ListNode pNode1=meetNode;
		//得到环中节点数目
		while(pNode1.next != meetNode)
		{
			pNode1=pNode1.next;
			countLoop++;
		}
	    //先移动pNode1，次数为环中节点数目	
		pNode1=pHead;
		for(int i=0;i<countLoop;i++)
		{
			pNode1=pNode1.next;
		}
		
		//再移动pNode1和pNode2
		ListNode pNode2=pHead;
		while(pNode1 != pNode2)
		{
			pNode1=pNode1.next;
			pNode2=pNode2.next;
		}
		return pNode1;
		
		
	}
	
	/*
	 * 找到相遇节点
	 */
	private ListNode meetingNode(ListNode pHead) {
		if (pHead==null) {
			return null;
		}
		
		ListNode slow=pHead.next;
		if (slow==null) {
			return null;
		}
		ListNode fast=slow.next;
		while(slow != null && fast != null)
		{
			if (slow == fast) {
				return fast;
			}
			slow=slow.next;
			fast=fast.next;
			if (fast!=null) {
				fast=fast.next;
			}
		}
		return null;
	}
	
	/*
	 * 双指针法。
	 *假设环长度为n，进入环之前结点个数为x,slow在环内走了k个结点,
	 *fast绕环走了m圈,则有2(x+k)=x+mn+k 可以得出x = mn - k。
	 *此时slow距入口结点还剩 n-k个结点,x=(m−1)n+n−k，
	 *即一个指针从链表头节点走到环入口的长度等于另一个指针从相遇的位置走 m-1圈后再走n-k的长度，
	 *也就是说两个指针相遇后，让一个指针回到头节点，
	 *另一个指针不动，然后他们同时往前每次走一步，当他们相遇时，相遇的节点即为环入口节点。

	*所以，我们设置两个指针，一个是快指针fast，一个是慢指针slow，
	*fast一次走两步，slow一次走一步，如果单链表有环那么当两个指针相遇时一定在环内。
	*此时将一个指针指到链表头部，另一个不变，
	*二者同时每次向前移一格,当两个指针再次相遇时即为环的入口节点。
	*如果fast走到null则无环。
	 */
	public ListNode EntryNodeOfLoop2(ListNode pHead) {
		ListNode pFast=pHead;
		ListNode pSlow=pHead;
		
		while(pFast != null && pFast.next != null)
		{
			pFast=pFast.next.next;
			pSlow=pSlow.next;
			
			if (pFast == pSlow) {
				pFast=pHead;
				while(pFast!=pSlow)
				{
					pFast=pFast.next;
					pSlow=pSlow.next;
				}
				return pSlow;
			}
		}
		return null;
	}
	
	/*
	 * 此外，还能利用set或者Map中元素或键的唯一性来解
	 */
}
