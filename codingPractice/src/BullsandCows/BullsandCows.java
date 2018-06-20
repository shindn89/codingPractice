package BullsandCows;

import java.util.HashMap;
import java.util.Map;

public class BullsandCows {
	
	/*
	 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

		Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 
		
		Please note that both secret number and friend's guess may contain duplicate digits.
		
		Example 1:
		
		Input: secret = "1807", guess = "7810"
		
		Output: "1A3B"
		
		Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
		Example 2:
		
		Input: secret = "1123", guess = "0111"
		
		Output: "1A1B"
		
		Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
		Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
	 */
	/*
	 * Runtime: 3 ms
	 */
	public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] check = new int[10];
        char[] se = secret.toCharArray();
        char[] gu = guess.toCharArray();
        for (int i = 0; i < secret.length(); i++) {
            int s = se[i]-'0';
            int g = gu[i]-'0';
            if(s==g) {
                bull++;
            } else {
                if (check[s]++<0) 
                    cow++;
                if (check[g]-->0) 
                    cow++;
            }
        }
        String res =  bull+"A"+cow+"B";
        return res;
    }
	
	
	
	/*
	 * Runtime: 15 ms
	 */
	public String getHint2(String secret, String guess) {
	    if(secret == null || guess==null || secret.length() == 0 || guess.length() == 0) return "";
	    int bull = 0;
	    Map<Character, Integer> map = new HashMap<>();
	    for(int i = 0; i < secret.length(); i++){
	        if(secret.charAt(i) == guess.charAt(i)) bull++;
	        else {
	            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i),0)+1);
	        }
	    }
	    int cow = 0;
	    for(int i = 0; i < guess.length(); i++){
	        if(map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0 && secret.charAt(i) != guess.charAt(i)){
	            cow++;
	            map.put(guess.charAt(i), map.get(guess.charAt(i))-1);
	        }
	    }
	    String res = bull+"A"+cow+"B";
	    return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
