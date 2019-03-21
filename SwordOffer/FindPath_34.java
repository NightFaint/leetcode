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
	
	//�����������
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root , int target) {
		if (root==null) {
			return res;
		}
		
		path.add(root.val);
		target-=root.val;
		
		//��Ŀ��ֵ��Ϊ0�ҽڵ�ΪҶ�ڵ�ʱ��pathΪ����������·��֮һ
		if (target == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<>(path));
		}
		
		else {
			findPath(root.left, target);
			findPath(root.right, target);
		}
		//������ĳһ·���󣬻ص���һ���ڵ㣬��targetҪ�ӻ���root.val��pathҪ����root.val
		target+=root.val;
		path.remove(path.size()-1);
		return res;
	}
}
