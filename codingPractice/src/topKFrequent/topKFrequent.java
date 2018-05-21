package topKFrequent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //loop through keep adding value to the map
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        //need work for sort by map's value
        //Priority Queue is the best?
        //need to define comparator
        PriorityQueue<Map.Entry<Integer,Integer>> output = 
            new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        
        output.addAll(map.entrySet());
        
        List<Integer> out = new ArrayList<>();
        for(int i =0; i < k; i++){
            out.add(output.poll().getKey());
        }
        
        return out;
        
        
    }
	public int lengthOfLIS(int[] nums) {
        int[][] output = new int[nums.length][nums.length];
        Arrays.fill(output,0);
        
        for(int i = nums.length -1 ; i >=0; i--){
            for(int j = i; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    output[i][j] = 1;
                }
                else if(nums[i] > nums[j] && output[i+1][j] == output[i][j-1]){
                    output[i][j] = output[i+1][j] +1;
                }
                else{
                    output[i][j] = Integer.max(output[i+1][j], output[i][j-1]);
                }
            }
        }
        return output[0][nums.length-1];

}}
