import java.util.Stack;

public class IsPopOrder_31 {

	/*
	 * ��ָoffer�Ͻⷨ
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
	 * ˼·һ�����������
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
        	
        	// ÿ��ջһ�κͳ�ջ���бȽϣ����ջ���͵�ǰ��ջԪ����ͬ���򵯳�ͬʱ��ǰ����Ԫ��ָ��ǰ�ƣ�
            // �����һ��ջ��Ԫ�ػ��͵�ǰ����Ԫ����ͬ����������
        	while(!stack.isEmpty() && stack.peek() == popA[popIndex])
        	{
        		stack.pop();
        		popIndex++;
        	}
        }
     // �����ջ˳����ȷ��ģ��һ�ν���ջ�󣬸���ջӦ��Ϊ�ա���Ϊ��˵�����в���ȷ
        return stack.isEmpty();
	}
}
