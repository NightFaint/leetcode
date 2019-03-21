import java.util.ArrayList;
import java.util.Stack;

public class KthNode_54 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	/*
	 * �Ƚϼ�
	 * ���ö���������������ص�
	 * �������һ�ηŽ�������
	 * Ȼ�������е�k��Ԫ�ؼ�Ϊ��k�����
	 */
	
	public TreeNode kThNode(TreeNode root ,int k) {
		if (root==null || k<=0) {
			return null;
		}
		
		ArrayList<TreeNode> list=new ArrayList<>();
		putInArray(root, list);
		return list.get(k-1);
	}
	
	private void putInArray(TreeNode node,ArrayList<TreeNode> list)
	{
		if (node==null) {
			return;
		}
		putInArray(node.left, list);
		list.add(node);
		putInArray(node.right, list);
	}
	
	/*
	 * ��һ�ֽⷨ������Ҫ�����꣬�ϸ�Ч��������O(n)
	 */
	public TreeNode kThNode_2(TreeNode root,int k) {
		if (root==null || k<=0) {
			return null;
		}
		
		Stack<TreeNode> stack=new Stack<>();
		int count=0;
		while(root!= null || !stack.isEmpty())
		{
			while(root!=null)
			{
				stack.push(root);
				root=root.left;
			}
			
			if (!stack.isEmpty()) {
				root=stack.pop();
				if (++count==k) {
					return root;
				}
				root=root.right;
			}
		}
		return null;
	}
}
