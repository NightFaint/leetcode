import java.util.ArrayList;
import java.util.LinkedList;

public class FromTail2Head_6 {

	// �ڵ���Ķ���
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    /**
     * ���Ƽ�ʹ��ջ������ѹ�룬β�ڵ������ǰ����
     *
     * @param listNode �����ͷ���
     * @return ��β��ͷ���еĽ��
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }
        return new ArrayList<>(stack);
    }
    
    /*
     * �ݹ�
     */
    ArrayList<Integer> res=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode)
    {   
    	if (listNode!=null) {
        	printListFromTailToHead(listNode.next);
        	res.add(listNode.val);
		}
    	return res;
    }
}
