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
	 * ����ѭ�������ⷨ���Ƚ�low����Ҳͨ���ˡ�
	 *@param s
	 *@return
	 */
	public String longestPalindrome(String s) {
		if(s == null || s.equals("")){
			return "";
		}
		//�洢�����Ĵ�����
		int maxLen = 0 ;
		//�洢ÿ�������Ӵ�
		Map<Integer,String> map = new HashMap<>();
		//�����Ӵ��������ʼ������
		for(int i=s.length()-1;i>=0;i--){
			for(int j=0;j<s.length();j++){
				//ֻ�������ַ���ͬ�����п����ǻ��Ĵ�����ȥ���ж�
				if(s.charAt(i) == s.charAt(j)){
					//��������жϵ��ַ�������С�������Ĵ��ĳ��ȣ�����
					if(maxLen>j-i+1){
						continue;
					}
					//��ʾ�ַ������˵�����
					int left = i,right = j ;
					//�ж��ַ����ǻ��Ĵ���Ҫѭ���Ĵ���
					int cpt = (right-left+1)/2;
					//�Ƿ��ǻ��Ĵ���ʶ
					boolean isPalindromic = true ;
					//ѭ���ж��Ƿ��ǻ��Ĵ�
					while(cpt-- > 0){
						if(s.charAt(left) == s.charAt(right)){
							right-- ;
							left++;
						}else{
							isPalindromic = false ;
							break;
						}
					}
					//�ǻ��Ĵ��������Ĵ������ϣ������󷵻أ������������Ĵ�����
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
	 * ���ĵ㷨
	 * ����ķ���ʱͨ�����Ĵ����ߵ��ַ���ʼ�ж�����Ҫ����ѭ��.
	 * ���Ĵ������ҶԳƵģ����Ƕ��и����ĵ㣨ż�����м���������������Ҳ����ͨ���ұ������ĵ�,�ҵ������ĵ����Ļ��Ĵ�������ֻ�����һ��
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
			str = extendPalindrome(s,i,i);//�������Ĵ����
			if(maxLen < str.length()){
				maxLen = str.length();
				map.put(maxLen, str);
			}		
			str = extendPalindrome(s,i,i+1);//ż�����Ĵ����
			if(maxLen < str.length()){
				maxLen = str.length();
				map.put(maxLen, str);
			}
			
		}
		return map.get(maxLen);
	}
	//�ҵ������ĵ����ַ��������Ļ��Ĵ�������
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
