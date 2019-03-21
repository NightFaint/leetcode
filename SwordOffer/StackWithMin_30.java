import java.util.Stack;

public class StackWithMin_30 {

	/*
	 * ��һ˼·������һ��ȫ�ֱ���min��ÿ��push���͵�ǰ��Сֵ�Ƚϣ�
	 * �����С�͸���min������min���䡣�������ַ����и����⣺
	 * Ҫ��pop��ջ��Ԫ�����þ������min�أ����µ�min�Ƕ��٣����Ǻ��ѵ�֪
	 * ��������辶�����ǵ�Ҫ��������O(1)��ʱ�临�Ӷȡ����Կ����ÿռ任ʱ�䣬����ʹ�ø����ռ䡣
	*����һ��ջstackMin��ר�����ڴ�ŵ�ǰ��Сֵ��
	 */
	private Stack<Integer> m_data;
	private Stack<Integer> m_min;
	
	public void push(int value) {
		m_data.push(value);
		if (m_min.isEmpty() || value < m_min.peek())
			m_min.push(value);
		else {
			m_min.push(m_min.peek());
		}
	}
	
	public void pop() {
		if (m_data.isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		}
		m_data.pop();
		m_min.pop();
	}
	
	public int min() {
		if (!m_data.isEmpty() && !m_min.isEmpty()) {
			return m_min.peek();
		}
		else {
			throw new RuntimeException("Stack is empty!");
		}
	}
}
