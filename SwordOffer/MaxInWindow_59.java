import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


public class MaxInWindow_59 {

	/*
	 * ʹ��˫�˶���
	 * ֻ���п��ܳ�Ϊ���������е����ֵ��Ԫ�����С�
	 * ����Ҫ���еĵ�Ԫ�رȶ�������ЩԪ�ش������ȣ��ͽ���ЩԪ���ȴӶ�����ɾ����Ȼ����������Ԫ�أ�
	 *����ͷ�����ֵ���λ�ڻ�������֮�⣬����Ҫ������ͷ�����ֵ�Ӷ�����ɾ����
	 *��ǰ�±����1����Ϊ�±��0��ʼ�ƣ����ڴ��ڿ�ȵ�ʱ��Ϳ��Կ�ʼͳ�ƻ������ڵ����ֵ��
	 */
	public ArrayList<Integer> maxInWindow(int[] array,int size) {

		ArrayList<Integer> list=new ArrayList<>();
		if (array==null || array.length<size || size<=0) {
			return list;
		}
		
		Deque<Integer> qDeque=new LinkedList<>();
		for(int i=0;i<array.length;i++)
		{
			while(!qDeque.isEmpty() && array[i] > array[qDeque.peekLast()])
				qDeque.pollLast();
			
			if (!qDeque.isEmpty() && i-qDeque.peekFirst()>=size) {
				qDeque.pollFirst();
			}
			
			qDeque.offerLast(i);
			
			if (i+1>=size) {
				list.add(array[qDeque.peekFirst()]);
			}
		}
		return list;
	}
}
