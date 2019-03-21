package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
ÿ����ȫ�������ĸ߶ȿ�ͨ��һֱ����õ���ֻ��һ���ڵ������Ϊ0�������Ϊ�գ�������Ϊ-1��ӵ��0���ڵ�

����������������Ƿ�Ϊ�������ĸ߶ȼ�һ������ǣ���ζ����������������һ���ߡ����һ�㲻���������ֻ�������������У����������һ�㶼�ǳ����ġ�
���ʱ������ӵ�еĽڵ���Ϊ��1+�������Ľڵ���+�������ڵ���=1+(1+2+3+..+2^(h-1))+�������ڵ���=2^h+countNodes(root.right)��

����������߶Ȳ����������ĸ߶ȼ�һ����ô���һ�㲻������������������Ϳ�ʼ�ģ���ζ���������������������һ��Ϊ�գ��൱������һ�㣬������ǳ����ġ�
��ô��ʱ������ӵ�еĽڵ���Ϊ��1+�������Ľڵ���+�������ڵ���=1+�������Ľڵ���+(1+2+3+..+2^(h-2))=countNodes(root.left)+2^(h-1)��

����Ҫ�ݹ�ÿһ�㣬�ܹ��ݹ���O(lg(n))�㡣ͬʱ��������ĸ߶���ҪO(lgn)�������ܵĸ��Ӷ�ΪO(log(n)^2)
*/

public class Count_Complete_Tree_Nodes222 
{
    int height(TreeNode root)
    {
        return root==null ? -1:1+height(root.left);
    }
    
    public int countNodes(TreeNode root) 
        
    {
        int h=height(root);
        if(h<0)
            return 0;
        else if(height(root.right)==h-1)
            return (1<<h)+countNodes(root.right);
        else
            return countNodes(root.left)+(1<<(h-1));
        
    }

}
