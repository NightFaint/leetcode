
public class InOrderNextNode_8 {

	private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        // nextָ�򸸽��
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
	
	public TreeLinkNode GetNext(TreeLinkNode pNode)
	{
		// �����ǰ������������գ���ô������һ��������������������ӽ�㣨����еĻ��������������û�����ӽ��ͷ��������������
		if (pNode.right!=null) {
			pNode=pNode.right;
			while(pNode.left!=null)
			{
				pNode=pNode.left;
			}
			return pNode;
		}
		
		// �����ǰ�ӽ��pNode������Ϊ��
        // �����ϲ�ĸ���㣬������������ӽ����ǵ�ǰ��㣬�������ص��ϲ�ĸ����...ֱ�����������ӽ����ڵ�ǰ���
		while(pNode.parent != null && pNode.parent.right == pNode)
		{
			pNode=pNode.parent;
		}
		
		// ������������ӽ����ڵ�ǰ��㣬˵����һ��Ҫ�����Ľ����Ǹ�����ˣ����߸����Ϊ�գ�˵����ǰ�����root�������Ƿ��ظ���㣨null��
        // pNode.next == null ���� pNode.next.left == pNode
		return pNode.parent;
	}
}
