/**
 * 
 */
package BinaryTreePruning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author DN
 *
 */
public class Pruning {
	public TreeNode pruneTree(TreeNode root) {
        if(root.left != null)
            root.left = pruneTree(root.left);
        if(root.right != null)
            root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null)
        {
            return null;
        }  
        
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
