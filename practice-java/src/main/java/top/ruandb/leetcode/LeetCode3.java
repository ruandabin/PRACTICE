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
	 * �����ⷨ��ѭ�������ַ����������Ӵ����ҵ�����
	 * ���ַ�����leetcode���ǲ�ͨ���ģ���ʱ
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s){
		int wl = s.length();
		//ѭ���ı们�����ڵĳ���
		while(wl > 0){
			//�����̶����ȵĴ���
			for(int i=0;i<s.length()-wl+1;i++){
				Map<Character,Integer> map = new HashMap<>();
				boolean isMax = true ;
				
				//�жϹ̶��������Ƿ����ظ��ַ�,���ù�ϣ��
				for(int j=i;j<i+wl;j++){
					//���ظ�ֵ
					if(map.containsKey(s.charAt(j))){
						isMax = false ;
						break;
					}
					map.put(s.charAt(j), j);
				}
				
				//�ҵ���󳤶�
				if(isMax){
					return wl ;
				}
			}
			wl--;
		}
		return wl;
	}
	
	/**
	 * ��̬�ı们�����ڳ���
	 * ���ַ�����hashmap��
	 * ������ظ���end++,�����ַ����浽hashmap��
	 * ����ظ���start++�����ַ��Ƴ�hashmap��
	 * ��ʼ�ձ���end++ʱ�����еĴ��ǲ��ظ��ģ�
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unused")
	public int lengthOfLongestSubstring2(String s){
		//��������ظ��Ӵ�
		int maxLength = 0;
		//���滬���������˵�����
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
