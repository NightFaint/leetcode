
/*
 * ��������ָ��a��b������aָ�뵽����ĩβʱ��
 * bָ������ָ������k����㣬��ʱ����ָ��b���Ľ�㼴�ɣ�
 * ��ʱaָ���λ�ü�ȥbָ���λ�õ���k-1�����������ָ��ͬ���ص��˵�����ͷ��㴦��
 * bָ���λ��λ��0����ͷ��㣬��aָ��λ��λ��k-1���Ľ�㡣����������Ƿ�����˼����
 * һ��ʼ����aָ����k-1����b������֮������ָ��ͬʱ�ƶ���ֱ��a��������ĩβ��
 * ��ʱ����bָ�봦�Ľ����ǵ�����k����㡣**���ַ���ֻ�����һ������**ʱ�临�Ӷ�ΪO(n)��
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
