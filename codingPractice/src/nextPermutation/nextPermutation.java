package nextPermutation;

public class nextPermutation {
	
	public void nextPermutation(int[] nums) {
        /*
            easiest solution would be
            last element is greater than before last element
            
            need to consider 1 3 2 
            in my case return 3 1 2 but it should be 2 1 3 instead
            need to find number that greater than swaping number and less than swapped number
            consider this case
           	orig	1 2 5 4 3 -> 1 5 2 4 3 -> 1 3 2 4 5 
           	it seems we only need to swap to the end if last member of value is less than swapped number
           	since we all know that order is increasing in reverse manner.
            index	0 1 2 3 4    0 1 2 3 4    0 1 2 3 4 
            im thinkin about after first loop, on the second loop swap if first element is greater than last element?
            like reverse whole list
            seems better to make method for swap;
        */
        int n = nums.length-1;
        boolean checker = true;
        while(n>=1){
            if(nums[n] > nums[n-1])
            {
                // general swap happen
                int temp = nums[n];
                nums[n] = nums[n-1];
                nums[n-1] = temp;
                checker = true;
                //check swap with last element if value is less than swapped number
                if(nums[n-1] > nums[nums.length-1]) {
                	int tmp = nums[n-1];
                	nums[n-1] = nums[nums.length-1];
                	nums[nums.length-1] = tmp;
                }
                break;
            }
            else	checker = false;
            
            n--;
        }
        //int findIndex = 
        //we know if checker is false decreasing order
        //need to swap whole array
        if(!checker){
            int i = 0;
            int nn = nums.length-1;
            while(i<nn){
                int temp = nums[i];
                nums[i] = nums[nn];
                nums[nn] = temp;
                i++;
                nn--;
            }
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
