package lengthOfLongestSubstringTwoDistinct;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringTwoDistinct {
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s== null || s.length() == 0) return 0;
        if(s.length() <=2) return s.length();
        int max= 0;
        int count =0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0,j=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c) && count == 2){
                char curPoint = s.charAt(j);
                int runner = j;
                j = Math.max(j, map.get(curPoint)+1);
                
                /*
                 * so for a b a a f f z z e e e
                 *        0 1 2 3 4 5 6 7 8 9 10
                 *        a b b a f f z z e e e 
                 *        c a c b c a a c c b c  c  a  c  c  c  c  c  c  b  c  a  b  a 
                 *        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
                  */
                if(i == j ) j--;
                if(curPoint != s.charAt(j)) map.remove(curPoint);
                else {
	                while(runner < j) {
	                	if(curPoint != s.charAt(runner)&&map.containsKey(s.charAt(runner))) {   
	                		j = map.get(s.charAt(runner))+1;
	                		map.remove(s.charAt(runner));
	                		
	                		break;
	                    }
	                	runner++;
	                }
                }
            }
            else if(!map.containsKey(c)) count++;
            map.put(c, i);
            System.out.println(i+" "+j);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstringTwoDistinct("ababffzzeee"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("aecebb"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("ababffbzzeee"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("cacbcaaccbccaccccccbcaba"));
		String s = "alksdjfl";
		char[]k = s.toCharArray();
		String zz = new String(k,0,4);
	}

}
