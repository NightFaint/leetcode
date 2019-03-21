
public class HasSubTree {
     private class BinaryTreeNode{
    	 double val;
    	 BinaryTreeNode left;
    	 BinaryTreeNode right;
     }
     
     public boolean hasSubTree(BinaryTreeNode pRoot1,BinaryTreeNode pRoot2) {
		boolean result=false;
		
		if (pRoot1 != null && pRoot2 != null) {
			/*
			 * ����val����Ϊdouble��������==�ж�����ֵ�Ƿ����
			 * ���Զ���equal������ȷ������Ҫ�ľ���
			 */
			if (equal(pRoot1.val,pRoot2.val)) {
				result=doesTree1hasTree2(pRoot1, pRoot2);
			}
			if (!result) {
				result=hasSubTree(pRoot1.left, pRoot2);
			}
			if (!result) {
				result=hasSubTree(pRoot1.right, pRoot2);
			}
		}
		return result;
	}
     
     private boolean doesTree1hasTree2(BinaryTreeNode pRoot1,BinaryTreeNode pRoot2) {
		if (pRoot2 == null) {
			return true;
		}
		if (pRoot1==null) {
			return false;
		}
		
		if (equal(pRoot1.val, pRoot2.val)) {
			return false;
		}
		return doesTree1hasTree2(pRoot1.left, pRoot2.left) && doesTree1hasTree2(pRoot1.right, pRoot2.right);
	}
     
     private boolean equal(double x,double y) {
		if (x-y>-0.000001 && x-y < 0.000001) {
			return true;
		}
		return false;
	}
}
