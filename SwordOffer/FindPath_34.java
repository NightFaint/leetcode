import java.util.ArrayList;

public class FindPath_34 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	ArrayList<ArrayList<Integer>> res=new ArrayList<>();
	ArrayList<Integer> path=new ArrayList<>();
	
	//深度优先搜索
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root , int target) {
		if (root==null) {
			return res;
		}
		
		path.add(root.val);
		target-=root.val;
		
		//当目标值减为0且节点为叶节点时，path为符合条件的路径之一
		if (target == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<>(path));
		}
		
		else {
			findPath(root.left, target);
			findPath(root.right, target);
		}
		//搜素完某一路径后，回到上一个节点，故target要加回来root.val，path要减掉root.val
		target+=root.val;
		path.remove(path.size()-1);
		return res;
	}
}
