import java.util.HashMap;
import java.util.Map;

public class L437_Path_Sum_III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * DFS 暴力
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int rootSum = count(root, sum);
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        return rootSum + left + right;
    }

    private int count(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int isMe = node.val == sum ? 1 : 0;
        int left = count(node.left, sum - node.val);
        int right = count(node.right, sum - node.val);
        return isMe + left + right;
    }

    public int pathSum2(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 ,1);
        return findPathSum(root, 0, sum, map);
    }

    private int findPathSum(TreeNode cur, int sum, int target, Map<Integer, Integer> map) {
        if (cur == null){
            return 0;
        }
        sum += cur.val;
        int pathsToCur = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int res = pathsToCur + findPathSum(cur.left, sum, target, map)
                + findPathSum(cur.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
