import java.util.LinkedList;

public class TwoStackImpQueue_9 {

	private LinkedList<Integer> stack1=new LinkedList<>();
	private LinkedList<Integer> stack2=new LinkedList<>();
	
	public void enqueue(int i)
	{
		stack1.push(i);
	}
	
	public int dequeue(int i)
	{
		if (stack2.isEmpty() && stack1.isEmpty()) {
			throw new RuntimeException("╤сапн╙©у");
		}
		
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			
		}
		return stack2.pop();
	}
}
