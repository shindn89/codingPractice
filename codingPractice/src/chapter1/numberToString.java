package chapter1;

public class numberToString {
	
	public static String numberToString(int k) {
		if(k==0) return "Zero";
		int val = k;
		int hundreds = val/100;
		int tens = k%100/10;
		int last = k%100%10;
		boolean check = false;
		String res = "";
		if(hundreds >0)
			res += helper(hundreds) + " Hundred ";
		if(tens > 0) {
			if(tens > 3 && tens != 5 && tens != 8) {
				res += helper(tens) + "ty ";
			} else {
				if(tens == 1) {
					if((last >5&&last!=8) || last ==4) {
						res += helper(last) + "teen";
					}else if (last == 1)
						res+="Eleven";
					else if(last == 2)
						res+="Twelve";
					else if (last == 3)
						res+= "Thirteen";
					else if (last == 5)
						res += "Fitheen";
					else if (last == 8)
						res += "Eighteen";
					else if (last == 0)
						res+= "Ten";
					check = true;
					
				} else if (tens == 2) {
					res += "Twenty ";
				} else if (tens == 3) {
					res += "Thirty ";
				} else if (tens == 5) {
					res += "Fithy ";
				} else if (tens == 8)
					res+="Eighty ";
			}
		}
		if(!check)
			res+=helper(last);
		return res;
		
	}
	public static String helper(int k) {
		if(k == 1) return "One";
		else if(k == 2) return "Two";
		else if(k == 3) return "Three";
		else if(k == 4) return "Four";
		else if(k == 5) return "Five";
		else if(k == 6) return "Six";
		else if(k == 7) return "Seven";
		else if(k == 8) return "Eight";
		else if(k == 9) return "Nine";
		return "";
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i= 0; i < 1000; i++) {
			System.out.println(numberToString(i));
		}
	}

}
