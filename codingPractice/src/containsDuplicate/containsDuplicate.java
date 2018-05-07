package containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
	//Time complexity = O(N) space complexity = O(N)
	public boolean containsDuplicate(int[] nums) {
        if(nums == null) return false;
        Set<Integer> set = new HashSet<>();
        
        for(int num: nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
	
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1])
				return true;
		}
		return false;
	}
}
