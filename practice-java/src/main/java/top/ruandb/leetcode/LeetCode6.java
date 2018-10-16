package top.ruandb.leetcode;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a 
 * given number of rows like this: (you may want to display this 
 * pattern in a fixed font for better legibility)
 * Example 1:
 * 	Input: s = "PAYPALISHIRING", numRows = 3
 * 	Output: "PAHNAPLSIIGYIR"
 *Example 2:
 *	Input: s = "PAYPALISHIRING", numRows = 4
 *	Output: "PINALSIGYAHRPI"
 * @author rdb
 *
 */
public class LeetCode6 {

	/**
	 * 先不考虑斜线上的数据，用等差数列找出各点数据，然后找斜线上的数据的规律
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		if(s == null  ){
			return "" ;
		}
		if(s.length() <= numRows || numRows==1){
			return s ;
		}
		char[] sChar = s.toCharArray();
		int location;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i <numRows;i++){
			int k = i ;
			for(int j = 0;j<(s.length()/numRows+1);j++){
				location = k ;
				sb.append(sChar[k]);
				k = k+(2*numRows)-2;
				if(k>=s.length()){
					if(k-2*i<s.length() && location != (k-2*i) ){
						//System.out.print(sChar[k-2*i]);
						sb.append(sChar[k-2*i]);
					}
					break ;
				}
				if(i>0 && i<(numRows-1)){
					//System.out.print(sChar[k-2*i]);
					sb.append(sChar[k-2*i]);
				}
			}
		}
        return sb.toString();
    }
	
	public static void main(String[] args) {
		LeetCode6 lc = new LeetCode6();
		String s="ABCDE";
		int numRows=2;
		String sb = lc.convert(s, numRows);
		System.out.println(sb);
	}
}
