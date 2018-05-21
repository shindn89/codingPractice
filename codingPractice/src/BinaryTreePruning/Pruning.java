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
import java.util.Stack;

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
		StringBuilder sb = new StringBuilder();
		String s = "himm my name is dn";
		StringBuilder out = new StringBuilder();
		for(String str: s.split(" ")) {
			String revstr = new StringBuilder(str).reverse().toString();
			revstr = Character.toUpperCase(revstr.charAt(0))+revstr.substring(1, revstr.length()-1)
			+ Character.toUpperCase(revstr.charAt(revstr.length()-1));
			out.append(revstr).append(" ");
		}
		System.out.println(out.toString().trim());
		final int three =3;
		final int five =5;
		String k = "abab";
		int half = k.length()/2;
		String left = k.substring(0, half);
		String right  =k.substring(half, k.length());
		StringBuilder sbb = new StringBuilder();
		sbb.append(left);
		//sbb.append(right);
		System.out.println(sbb.toString());
		System.out.println(left == right);
		System.out.println(left.equals(right) );
		/*String[] test = new String[2];
		Stack<Integer> stack = new Stack<>();
		String kk = "kkkaz";
		 int va =kk.indexOf("kk");
		 System.out.println(va);*/
	}

}
