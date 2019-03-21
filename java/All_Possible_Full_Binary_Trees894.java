package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class All_Possible_Full_Binary_Trees894 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	public List<TreeNode> allPossibleFBT(int N) 
    {
		Map<Integer, List<TreeNode>> memo=new HashMap<>();
        TreeNode node=new TreeNode(0);
        List<TreeNode> list=new ArrayList<>();
        if(N%2==0)
            return list;
        list.add(node);
        memo.put(1,list);
        if(N==1)
            return memo.get(1);
        for(int i=3;i<N+1;i+=2)
        {
        	List<TreeNode> iList=new ArrayList<>();
        	memo.put(i, iList);
        	for(int j=1;j<i;j+=2)
        	{
        		List<TreeNode> left=memo.get(j);
        		List<TreeNode> right=memo.get(i-j-1);
        		for(TreeNode x:left)
        			for(TreeNode y:right)
        			{
        				TreeNode newnode=new TreeNode(0);
        				newnode.left=x;
        				newnode.right=y;
        				iList.add(newnode);
        			}
        	}
        }
        return memo.get(N);
        
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
