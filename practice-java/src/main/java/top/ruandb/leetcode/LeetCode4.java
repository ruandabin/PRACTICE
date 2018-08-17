package top.ruandb.leetcode;

public class LeetCode4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double target = 0;
		int i = 0;
		int j = 0;
		// 奇数情况
		if ((nums1.length + nums2.length) % 2 == 1) {
			// 计算中间索引
			int targetIndex = (nums1.length + nums2.length) / 2;
			//数组为空的情况
			if(nums1.length == 0){
				return nums2[targetIndex] ;
			}
			if(nums2.length == 0){
				return nums1[targetIndex] ;
			}
			
			while ((i + j) - 1 < targetIndex) {
				if (nums1[i] < nums2[j]) {
					target = nums1[i];
					i++;
					if(i == nums1.length){
						if(targetIndex >= i){
							return nums2[targetIndex-i];
						}else{
							return nums1[i-targetIndex];
						}
					}
				} else{
					target = nums2[j];
					j++;
					if(j == nums2.length){
						if(targetIndex >= j){
							return nums1[targetIndex-j];
						}else{
							return nums2[j-targetIndex];
						}
					}
				}
			}
		} else {// 偶数情况
				// 计算中间索引
			int targetIndex = (nums1.length + nums2.length) / 2 ;
			//数组为空的情况
			if(nums1.length == 0){
				return (nums2[targetIndex] + nums2[targetIndex+1])* 1.0 / 2;
			}
			if(nums2.length == 0){
				return (nums1[targetIndex] + nums1[targetIndex+1])* 1.0 / 2;
			}
			while ((i + j) - 1 < targetIndex) {
				if (nums1[i] < nums2[j]) {
					target = nums1[i];
					i++;
					if(i == nums1.length){
						if(targetIndex >= i){
							if(targetIndex-i == 0){
								
							}else{
								target = (nums2[targetIndex-i] + nums2[targetIndex-i-1])* 1.0 / 2;
							}
							
							break;
						}else{
							target = nums1[i-targetIndex];
							break ;
						}
					}
				} else{
					target = nums2[j];
					j++;
					if(j == nums2.length){
						if(targetIndex >= j){
							target = nums1[targetIndex-j];
							break;
						}else{
							target = nums2[j-targetIndex];
							break;
						}
					}
				}
			}
			
			
		}
		return target;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {1};
		int[] nums2 = new int[] {1};
		LeetCode4 lc = new LeetCode4();
		System.out.println(lc.findMedianSortedArrays(nums1, nums2));

	}
}
