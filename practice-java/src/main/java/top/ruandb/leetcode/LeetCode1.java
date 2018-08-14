package top.ruandb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 *Example:
 *	Given nums = [2, 7, 11, 15], target = 9,
 *	Because nums[0] + nums[1] = 2 + 7 = 9,
 *	return [0, 1].
 * @author rdb
 *
 */
public class LeetCode1 {

    //传统暴力做法，时间复杂度O(n^2)
    public int[] twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j]) == target){
                    return new int[]{i,j} ;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //利用哈希表快速查找
    public int[] twoSum1(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int temp = target - nums[i] ;
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);//放在判断后面，避免某个元素的两倍正好是target
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        LeetCode1 le = new LeetCode1();
        int[] result = le.twoSum1(nums, 9);
        Arrays.stream(result).forEach(e -> System.out.print(e+" "));
    }
}