package BinaryTreePruning;

public class TreeNode {
	
	 public int val;
	 public TreeNode left;
	 public TreeNode right;
	 public TreeNode(int x) { val = x; }
	 
	 public static void printTree(TreeNode root)
	 {
		 if(root== null) return;
	     if(root.left != null)
			 printTree(root.left);
		 System.out.println(root.val);
		 if(root.right != null)
			 printTree(root.right);
		 
	 }

}
