package q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

import q22.Tries;

public class q3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
	    TreeMap<String, Integer> dateToQuantity = new TreeMap<>();
	    HashMap<String, HashSet<String>> dateToId = new HashMap<>();
	    
	    while ( (line = in.readLine()) != null) {
	    	if(line.isEmpty()) {
	    		//loop over
	    		Iterator<String> itr = dateToQuantity.keySet().iterator();
	    		while(itr.hasNext()) {
	    			String date = itr.next();
	    			int quantity = dateToQuantity.get(date);
	    			int productIdsize = dateToId.get(date).size();
	    			System.out.printf("%s,%d,%.2f,%d\n", date, quantity, quantity/(double)productIdsize, productIdsize);
	    		}
	    	}
	    	else {
	    		//need to work here
	    		// Just in case product Id contains a comma, use substring instead of split
	            // Assume yyyy-mm-dd,quantity,productId
	    		int firstComma = line.indexOf(",");
	    		int secondComma = line.indexOf(",", firstComma+1);
	    		
	    		String date = line.substring(0, firstComma);
	    		int quantity = Integer.parseInt(line.substring(firstComma+1, secondComma));
	    		String productId = line.substring(secondComma+1, line.length());
	    		
	    		dateToQuantity.put(date, dateToQuantity.getOrDefault(date, 0) + quantity);
	    		
	    		if(!dateToId.containsKey(date)) {
	    			dateToId.put(date, new HashSet<String>());
	    		}
	    		dateToId.get(date).add(productId);
	    	}
	    }
	}

}
