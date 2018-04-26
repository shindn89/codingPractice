package constructMaximumBinaryTree;

import java.util.Stack;

import BinaryTreePruning.TreeNode;

public class constructMaximumBinaryTree {
	public static TreeNode constructMaximumBinaryTreeN(int[] nums)
	{
		if(nums.length ==0) return null;
		if(nums.length == 1) return new TreeNode(nums[0]);
		
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++)
        {
            TreeNode cur = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < cur.val)
            {
                cur.left = stack.pop();
            }
            if(!stack.isEmpty())
            {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
		
        return stack.isEmpty() ? null : stack.get(0);
	}
		
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length ==0) return null;
		if(nums.length == 1) return new TreeNode(nums[0]);
		TreeNode root = new TreeNode(nums[0]);
		for(int i = 1; i < nums.length; i++)
		{
			root = recurseHelper(root, new TreeNode(nums[i]));
		}
		
        return root;
    }
	public static TreeNode recurseHelper(TreeNode root, TreeNode addNode)
	{
		if(root == null) return null;
		if(addNode == null)
		{
			root.right = null;
			return root;
		}
		TreeNode rootValue = root;
		if(root.val > addNode.val)
		{
			if (root.right != null && root.right.val < addNode.val)
			{
				addNode.left = root.right;
				root.right = addNode;
			}
			else {
				root.right= recurseHelper(root.right, addNode);
			}
		}
		if(root.val < addNode.val) {
			rootValue = addNode;
			rootValue.left = root;
		}
		return rootValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b[] ={3,2,1,6,0,5};
		TreeNode.printTree(constructMaximumBinaryTreeN(b));
		//TreeNode k = new TreeNode(3);
		//k.right = new TreeNode(2);
		//TreeNode.printTree(k);
	}


}
