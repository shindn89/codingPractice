package isAnagram;

import java.util.HashMap;
import java.util.Map;

public class isAnagram {
	public boolean isAnagram(String s, String t) {
        if(s==null && t==null) return true;
        else if (s==null || t== null) return false;
        else if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c,0) +1);
        for(char c : t.toCharArray()){
            if(!map.containsKey(c))
                return false;
            else{
                if(map.get(c)-1 < 0) return false;
                map.put(c, map.get(c)-1);
            }
        }
        return true;
    }
}
