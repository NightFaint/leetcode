

public class SerializeBT_37 {

	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
	
	public String serialize(TreeNode root) {
		if (root==null) {
			return null;
		}
		
		StringBuilder sb=new StringBuilder();
		preOrder(root, sb);
		return sb.toString();
	}
	
	private void preOrder(TreeNode node,StringBuilder sb) {
		if (node == null) {
			sb.append("$ ");
			return;
		}
		
		sb.append(node.val).append(" ");
		preOrder(node.left, sb);
		preOrder(node.right, sb);
	}
	
	int index=-1;
	public TreeNode deSerialize(String str) {
		if (str==null) {
			return null;
		}
		
		String[] seq=str.split("\\s");
		TreeNode root=reConstruct(seq);
		return root;
	}
	
	private TreeNode reConstruct(String[] seq) {
		++index;
		if (seq[index] == "$") {
			return null;
		}
		
		TreeNode node= new TreeNode(Integer.parseInt(seq[index]));
		node.left=reConstruct(seq);
		node.right=reConstruct(seq);
		return node;
	}
}
