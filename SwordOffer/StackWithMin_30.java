import java.util.Stack;

public class StackWithMin_30 {

	/*
	 * 第一思路：设置一个全局变量min，每次push都和当前最小值比较，
	 * 如果更小就更新min，否则min不变。但是这种方法有个问题：
	 * 要是pop出栈的元素正好就是这个min呢，那新的min是多少？我们很难得知
	 * 所以另辟蹊径。考虑到要求我们用O(1)的时间复杂度。可以考虑用空间换时间，试试使用辅助空间。
	*定义一个栈stackMin，专门用于存放当前最小值。
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
