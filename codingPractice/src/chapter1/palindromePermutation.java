package chapter1;

import java.util.HashMap;
import java.util.Map;

public class palindromePermutation {
	public static boolean palindromePermutation(String s) {
		int[] char_set = new int[128];
		for(char c : s.toCharArray()) {
			char_set[c]++;
		}
		boolean odd = false;
		for(int i = 0; i < char_set.length; i++) {
			if(char_set[i] % 2 != 0 && odd)
				return false;
			else if (char_set[i] % 2 != 0 && !odd)
				odd=true;
		}
		return true;
	}
	public static int rand (int l, int h) {
		return l+(int)(Math.random() *(h-l)+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palindromePermutation("Tact Coa"));
		Map<Character,Integer> map = new HashMap<>();
		for(int i = 0; i < 52; i++) {
			int k = rand(0,i);
			System.out.println(k);
		}
	}

}
