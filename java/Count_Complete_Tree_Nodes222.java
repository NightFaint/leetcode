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
每棵完全二叉树的高度可通过一直向左得到，只有一个节点的树高为0，如果树为空，设树高为-1，拥有0个节点

检查右子树的树高是否为整棵树的高度减一，如果是，意味着左子树和右子树一样高。最后一层不充满的情况只可能在右子树中，左子树最后一层都是充满的。
则此时整棵树拥有的节点数为：1+左子树的节点数+右子树节点数=1+(1+2+3+..+2^(h-1))+右子树节点数=2^h+countNodes(root.right)。

如果右子树高度不是整棵树的高度减一，那么最后一层不充满的情况从左子树就开始的，意味着右子树在整棵树的最后一层为空，相当于少了一层，其余层是充满的。
那么此时整棵树拥有的节点数为：1+左子树的节点数+右子树节点数=1+左子树的节点数+(1+2+3+..+2^(h-2))=countNodes(root.left)+2^(h-1)。

由于要递归每一层，总共递归了O(lg(n))层。同时，求得树的高度需要O(lgn)。所以总的复杂度为O(log(n)^2)
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
