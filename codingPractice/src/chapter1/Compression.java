package chapter1;

public class Compression {
	public static String compress(String s) {
		if(s == null || s.length() == 0) return s;
		int count = 1;
		StringBuilder sb = new StringBuilder();
		char c = s.charAt(0);
		for(int i = 1; i < s.length(); i++) {
			if(c == s.charAt(i)) {
				count++;
			} else {
				sb.append(c);
				sb.append(count);
				count = 1;
				c = s.charAt(i);
			}
		}
		sb.append(c);
		sb.append(count);
		//return sb.toString();
		return sb.length() <= s.length() ? sb.toString() : s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aabcccccccaaadd"));
	}

}
