package leetcode;

import java.util.ArrayList;


/*最笨的方法便是把每棵树的叶节点都找出来，分别存放在一个列表里；然后再对这两个列表进行比较
 * 复杂度O(m+n)
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


