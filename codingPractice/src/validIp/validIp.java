package validIp;

public class validIp {
	/*
	 * Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.

	 */
	
    public static String validIPAddress(String IP) {
        String ipv4 = "IPv4";
        String ipv6 = "IPv6";
        String neither = "Neither";
        if(IP.contains(".") && validIP4(IP))
            return ipv4;
        else if (IP.contains(":") && validIP6(IP))
            return ipv6;
        else
            return neither;	

    }
	private static boolean validIP4(String IP) {
		String[] checker = IP.split("\\.",-1);
		if(checker.length != 4) return false;
		for(String s : checker) {
			if(s.length() ==0 || s.length() >3) return false;
			if(s.startsWith("0") && s.length()>1) return false;
			int val = 0;
			for(char c : s.toCharArray()) {
				if(c<'0'||c>'9') return false;
				val = val*10 + (c-'0');
				if(val>=256) return false;
			}
		}
		return true;
	}
	private static boolean validIP6(String IP) {
		String[] sa = IP.split("\\:",-1);
        if(sa.length != 8) return false;
        for(String s : sa) {
            if(s.length()==0 || s.length()>4) return false;
            for(char c :s.toCharArray()){
                if((c<'a' || c>'f') && (c<'A' || c>'F') && (c<'0' || c>'9')) return false;
            }
        }
        return true; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validIPAddress("256.256.256.256"));
		System.out.println(validIPAddress("172.16.254.1"));
		String val = "172.16.222.22";
		String[] chars = val.split("/.");
		System.out.println("?"+ chars.length);
		System.out.println(chars[0]);
		String test = "asdf asd fas dfa sdf asdf";
		String[] kk = test.split(" ");
		System.out.println(kk[2]);

	}

}
