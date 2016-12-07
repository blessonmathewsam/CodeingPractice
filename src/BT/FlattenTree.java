/**
 * 
 */
package BT;

/**
 * @author blessonm
 *
 */
public class FlattenTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlattenTree f = new FlattenTree();
		TreeNode node1 = f.new TreeNode(1);
		TreeNode node2 = f.new TreeNode(2);
		TreeNode node3 = f.new TreeNode(3);
		TreeNode node4 = f.new TreeNode(4);
		TreeNode node5 = f.new TreeNode(5);
		TreeNode node6 = f.new TreeNode(6);
		TreeNode node7 = f.new TreeNode(7);
		TreeNode node8 = f.new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		f.flatten(node1);
		TreeNode node = node1;
		while(node != null){
			System.out.println(node.val);
			node = node.right;
		}
	}
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}	
		
    public TreeNode flatten(TreeNode node) {
    	if(node.left == null)
    		return node;
		if(node.right == null){
			node.right = node.left;
			return node.left;
		}
		TreeNode right = node.right;
		node.right = node.left;
		TreeNode lastL = flatten(node.left);
		TreeNode lastR = flatten(right);
		lastL.right = right;
		return lastR;
    }    
}
