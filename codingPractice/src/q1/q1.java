/**
 * 
 */
package q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author DN
 *
 */
public class q1 {
	public final static String THINK = "THINK";
	public final static String OUT = "OUT";
	public final static String COMMA = ",";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		    BufferedReader in = new BufferedReader(reader);
		    String line;
		    while((line = in.readLine()) != null) {
		    	String[] params = line.split(" ");
		    	int n = Integer.parseInt(params[0]);
		    	int p = Integer.parseInt(params[1]);
		    	int q = Integer.parseInt(params[2]);
		    	
		    	for(int i =1; i<=n; i++) {
		    		if(i > 1) {
		    			System.out.println(COMMA);
		    		}
		    		
		    		boolean check = true;
		    		if(i%p == 0 ||i%q == 0) {
		    			System.out.print(OUT);
		    			check = false;
		    		}
		    		String checkVal = String.valueOf(i);
		    		if(checkVal.contains(params[1]) || checkVal.contains(params[2])) {
		    			System.out.print(THINK);
		    			check = false;
		    		}
		    		
		    		if(check) {
		    			System.out.print(i);
		    		}
		    	}
		    }
	}

}
