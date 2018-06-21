package generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
	/*
	 * 22. Generate Parentheses
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

		For example, given n = 3, a solution set is:
		
		[
		  "((()))",
		  "(()())",
		  "(())()",
		  "()(())",
		  "()()()"
		]

	 */
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        String tmp = "";
        helper(res, tmp, n, 0, 0);
        return res;
    }
    private void helper(List<String> res, String tmp, int n, int curOpen, int curClose){
        if(tmp.length() == n*2){
            res.add(tmp);
            return;
        }
        if(n > curOpen){
            //tmp +="(";
            helper(res, tmp+"(", n, curOpen+1, curClose);
        }
        if(curOpen > curClose){
            //tmp += ")";
            helper(res, tmp+")", n, curOpen, curClose+1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
