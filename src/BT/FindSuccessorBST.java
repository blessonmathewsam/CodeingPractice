/**
 * 
 */
package BT;

import BT.FlattenTree.TreeNode;

/**
 * @author blessonm
 *
 */
public class FindSuccessorBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindSuccessorBST f = new FindSuccessorBST();
		TreeNode node1 = f.new TreeNode(1);
		TreeNode node2 = f.new TreeNode(2);
		TreeNode node3 = f.new TreeNode(3);
		TreeNode node4 = f.new TreeNode(4);
		TreeNode node5 = f.new TreeNode(5);
		TreeNode node6 = f.new TreeNode(6);
		TreeNode node7 = f.new TreeNode(7);
		TreeNode node8 = f.new TreeNode(8);
		node1.left = node2;
		node2.parent = node1;
		node1.right = node3;
		node3.parent = node1;
		node2.left = node4;
		node4.parent = node2;
		node2.right = node5;
		node5.parent = node2;
		node3.left = node6;
		node6.parent = node3;
		node3.right = node7;
		node7.parent = node3;
		node4.left = node8;
		node8.parent = node4;
		System.out.println(findInOrderAncestor(node2).val);
	}
	
	/**
	 * @param node
	 */
	private static TreeNode findInOrderAncestor(TreeNode node){
		if(node.right != null)
			return findMinimumKey(node.right);
		
		TreeNode ancestor = node.parent;
		TreeNode child = node;
		while(ancestor != null && child == ancestor.right){
			child = ancestor;
			ancestor = child.parent;
		}
		return ancestor;
	}

	/**
	 * @param node
	 * @return
	 */
	private static TreeNode findMinimumKey(TreeNode node) {
		while(node.left != null)
			node = node.left;
		return node;
	}

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode parent;
	    TreeNode(int x) { val = x; }
	}

}
