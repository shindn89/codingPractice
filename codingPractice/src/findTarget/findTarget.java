package findTarget;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class findTarget {
	public static int[] findTarget(int[] nums,int k) {
		int[] out = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i ++) {
			int value = k-nums[i];
			if(map.containsKey(value)) {
				out[0] = map.get(value);
				out[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		
		return out;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,5,6,1,10};
		int[] out = findTarget(input, 8);
		System.out.println(out[0] +" "+ out[1]);
		
		
	}

}
