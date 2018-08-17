package top.ruandb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author rdb
 *
 */
public class LeetCode3 {
	/**
	 * 暴力解法，循环遍历字符串的所有子串，找到最大的
	 * 这种方法在leetcode上是不通过的，超时
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s){
		int wl = s.length();
		//循环改变滑动窗口的长度
		while(wl > 0){
			//滑动固定长度的窗口
			for(int i=0;i<s.length()-wl+1;i++){
				Map<Character,Integer> map = new HashMap<>();
				boolean isMax = true ;
				
				//判断固定窗口中是否有重复字符,利用哈希表
				for(int j=i;j<i+wl;j++){
					//有重复值
					if(map.containsKey(s.charAt(j))){
						isMax = false ;
						break;
					}
					map.put(s.charAt(j), j);
				}
				
				//找到最大长度
				if(isMax){
					return wl ;
				}
			}
			wl--;
		}
		return wl;
	}
	
	/**
	 * 动态改变滑动窗口长度
	 * 将字符保存hashmap中
	 * 如果不重复，end++,并将字符保存到hashmap中
	 * 如果重复，start++并将字符移除hashmap中
	 * （始终保存end++时窗口中的串是不重复的）
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unused")
	public int lengthOfLongestSubstring2(String s){
		//保存最长不重复子串
		int maxLength = 0;
		//保存滑动窗口两端的所有
		int start = 0,end = 0 ;
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		while( end != s.length() ){

			if(map.containsKey(s.charAt(end))){
				map.remove(s.charAt(start));
				start++;
				maxLength = maxLength>(end - start + 1)?maxLength:(end - start + 1); 	
			}else{
				map.put(s.charAt(end),end);
				maxLength = maxLength>(end - start + 1)?maxLength:(end - start + 1); 
				end++ ;
			}	
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		LeetCode3 lc = new LeetCode3();
		System.out.println(lc.lengthOfLongestSubstring2(s));
	}
}
