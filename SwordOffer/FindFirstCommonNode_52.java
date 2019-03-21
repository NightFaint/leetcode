import java.util.Stack;

public class FindFirstCommonNode_52 {

	private class ListNode{
		int val;
		ListNode next;
		
	}
	
	//利用栈:O(m+n),空间复杂度O(m+n)
	//先将两个链表分别入栈
	//然后一个一个出栈，若出栈的节点不同
	//则上一个节点是第一个公共子节点
	public ListNode findFirstCommonNode(ListNode node1,ListNode node2) {
		Stack<ListNode> stack1=new Stack<>();
		Stack<ListNode> stack2=new Stack<>();
		while(node1!=null)
		{
			stack1.push(node1);
			node1=node1.next;
		}
		while(node2!=null)
		{
			stack2.push(node2);
			node2=node2.next;
		}
		ListNode result=null;
		while(!stack1.isEmpty() && !stack2.isEmpty())
		{
			if (stack1.peek()==stack2.pop()) {
				result=stack1.pop();
			}
			else
			{
				return result;
			}
		}
		return result;
	}
	
	/*O(m+n)，不需要额外空间
	 * 先遍历链表，记录每个链表长度
	 *再一次遍历链表 
	 * 比较长(假设长m个节点)的链表先走m步
	 * 然后两个链表同时移动
	 * 第一个相同的节点便是第一个公共子节点
	 */
	
	public ListNode findFirstCommonNode2(ListNode node1,ListNode node2) {
		int len1=0;
		int len2=0;
		ListNode cur=node1;
		while(cur!=null)
		{
			len1++;
			cur=cur.next;
		}
		cur=node2;
		while(cur!=null)
		{
			len2++;
			cur=cur.next;
		}
		if (len1>len2) {
			for(int i=0;i<len1-len2;i++)
			{
				node1=node1.next;
			}
		}
		if (len2>len1) {
			for(int i=0;i<len2-len1;i++)
			{
				node2=node2.next;
			}
		}
		
		while(node1!=null && node2!=null)
		{
			if (node1==node2) {
				return node1;
			}
			else {
				node1=node1.next;
				node2=node2.next;
			}
		}
		return null;
	}
	
	//还有：利用集合不能添加重复元素的特性
//	所谓公共结点其实就是完全一样的元素，而Set不能存入相同元素，当第一次添加元素失败时，该结点就是第一个公共结点了
}
