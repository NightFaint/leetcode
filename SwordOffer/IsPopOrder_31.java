import java.util.Stack;

public class IsPopOrder_31 {

	/*
	 * 剑指offer上解法
	 */
	public boolean isPopOrder(int[] pushA,int[] popA,int length) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
            return false;
        }
		boolean possible=false;
		int p1=0;
		int p2=0;
		Stack<Integer> stack=new Stack<>();
		while (p2<length) {
			while(stack.isEmpty() || stack.peek() != popA[p2])
			{
				if (p1==length-1) {
					break;
				}
				stack.push(pushA[p1]);
				p1++;
			}
			if (stack.peek() != popA[p2]) {
				break;
			}
			
			stack.pop();
			p2++;
			
			if (p2==length-1 && stack.isEmpty()) {
				possible=true;
			}
		}
		return possible;
		
	}
	
	/*
	 * 思路一样，更易理解
	 */
	
	public boolean isPopOrder2(int[] pushA,int[] popA,int length) {
		
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
            return false;
        }
        
        int popIndex=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<pushA.length;i++)
        {
        	stack.push(pushA[i]);
        	
        	// 每入栈一次和出栈序列比较，如果栈顶和当前出栈元素相同，则弹出同时当前弹出元素指针前移；
            // 如果下一个栈顶元素还和当前弹出元素相同，继续弹出
        	while(!stack.isEmpty() && stack.peek() == popA[popIndex])
        	{
        		stack.pop();
        		popIndex++;
        	}
        }
     // 如果出栈顺序正确，模拟一次进出栈后，辅助栈应该为空。不为空说明序列不正确
        return stack.isEmpty();
	}
}
