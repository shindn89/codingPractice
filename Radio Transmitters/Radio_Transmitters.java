import java.util.Arrays;
import java.util.Scanner;

public class Radio_Transmitters {

    public static void main(String[] args) {

        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        
        Arrays.sort(x);
        int numOfTransmitters = 0;
        int i = 0;
        
        /* Key is to use greedy algorithm to always place the transmitter at the house furthest to the right possible 
	    * to cover the range.
        */
        while (i < n) {
            numOfTransmitters++;
            int loc = x[i] + k;
            
            //go to right as far as we cover i_orig as well.
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k; // this is where we place the transmitter
            //now go to the right of x[i] by k because transmitter at x[i] covers houses to its right as well. 
            while (i < n && x[i] <= loc) i++;
        }
        System.out.println(numOfTransmitters);
        
        
        
    }
}