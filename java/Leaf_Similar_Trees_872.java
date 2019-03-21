package leetcode;

import java.util.ArrayList;


/*��ķ������ǰ�ÿ������Ҷ�ڵ㶼�ҳ������ֱ�����һ���б��Ȼ���ٶ��������б���бȽ�
 * ���Ӷ�O(m+n)
 * 
 */
public class Leaf_Similar_Trees_872 {
	
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
    	ArrayList<Integer> list1=new ArrayList<>();
    	getSequence(root1, list1);
    	ArrayList<Integer> list2=new ArrayList<>();
    	getSequence(root2, list2);
    	
    	if (list1.size()!=list2.size()) {
			return false;
		}
    	else {
			for(int i=0;i<list1.size();i++)
			{
				if(!list1.get(i).equals(list2.get(i)))
						return false;
			}
			return true;
		}
    }
    
    private static void getSequence(TreeNode root,ArrayList<Integer> list)
    {
    	if (root==null) {
    		return;
		}
    	else if (root.left==null && root.right==null) {
			list.add(root.val);
		}
    	else {
			getSequence(root.left,list);
			getSequence(root.right, list);
		}
    }

}


