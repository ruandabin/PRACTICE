package top.ruandb.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * 	Input: "babad"
 * 	Output: "bab"
 * 	Note: "aba" is also a valid answer.
 * Example 2:
 * 	Input: "cbbd"
 * 	Output: "bb"
 * @author rdb
 *
 */
public class LeetCode5 {

	/**
	 * 暴力循环遍历解法，比较low，但也通过了。
	 *@param s
	 *@return
	 */
	public String longestPalindrome(String s) {
		if(s == null || s.equals("")){
			return "";
		}
		//存储最大回文串长度
		int maxLen = 0 ;
		//存储每个回文子串
		Map<Integer,String> map = new HashMap<>();
		//遍历子串（从最大开始遍历）
		for(int i=s.length()-1;i>=0;i--){
			for(int j=0;j<s.length();j++){
				//只有两端字符相同，才有可能是回文串，才去做判断
				if(s.charAt(i) == s.charAt(j)){
					//如果现在判断的字符串长度小于最大回文串的长度，跳过
					if(maxLen>j-i+1){
						continue;
					}
					//表示字符串两端的索引
					int left = i,right = j ;
					//判断字符串是回文串需要循环的次数
					int cpt = (right-left+1)/2;
					//是否是回文串标识
					boolean isPalindromic = true ;
					//循环判断是否是回文串
					while(cpt-- > 0){
						if(s.charAt(left) == s.charAt(right)){
							right-- ;
							left++;
						}else{
							isPalindromic = false ;
							break;
						}
					}
					//是回文串，将回文串存入哈希表，待最后返回，并更新最大回文串长度
					if(isPalindromic){
						map.put(j-i+1, s.substring(i,j+1 ));
						maxLen =  j-i+1;
					}
				}
			}
		}
		return map.get(maxLen) ;
	}
	
	/**
	 * 中心点法
	 * 上面的方法时通过回文串两边的字符开始判定，需要两个循环.
	 * 回文串是左右对称的，他们都有个中心点（偶数是中间两个数）。我们也可以通过找遍历中心点,找到该中心点最大的回文串，这样只需遍历一次
	 *@param s
	 *@return
	 */
	public String longestPalindrome2(String s) {
		int len = s.length();
		if(len < 2){
			return s;
		}
		int maxLen = 0;
		String str ="";
		Map<Integer,String>  map = new HashMap<>();
		for(int i=0;i<s.length()-1;i++){
			str = extendPalindrome(s,i,i);//奇数回文串情况
			if(maxLen < str.length()){
				maxLen = str.length();
				map.put(maxLen, str);
			}		
			str = extendPalindrome(s,i,i+1);//偶数回文串情况
			if(maxLen < str.length()){
				maxLen = str.length();
				map.put(maxLen, str);
			}
			
		}
		return map.get(maxLen);
	}
	//找到改中心点在字符串中最大的回文串并返回
	private String extendPalindrome(String s,int i,int j){
		while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
			i-- ;
			j++ ;
		}
		return s.substring(i+1, j);
	}
	
	public static void main(String[] args) {
		String s = "cbbd";
		LeetCode5 lc = new LeetCode5();
		//System.out.println("ba".substring(1,2));
		System.out.println(lc.longestPalindrome2(s));
	}
}
