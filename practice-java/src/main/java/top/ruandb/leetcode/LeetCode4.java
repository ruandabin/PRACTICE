package top.ruandb.leetcode;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * 	nums1 = [1, 3]
 * 	nums2 = [2]
 *  The median is 2.0
 * Example 2:
 * 	nums1 = [1, 2]
 * 	nums2 = [3, 4]
 *  The median is (2 + 3)/2 = 2.5
 * @author rdb
 *
 */
public class LeetCode4 {

	/**
	 * �����������У����뵽�˹鲢�������ù鲢˼�룬���������ݹ鲢��һ���µ������У��Ӷ��ҳ��м�ֵ
	 *@param nums1
	 *@param nums2
	 *@return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//���ؽ��
		double target = 0;
		//�������������
		int i = 0, j = 0;
		// �����м�����
		int targetIndex = (nums1.length + nums2.length) / 2;
		//�鲢��ŵ�������
		int[] temp = new int[targetIndex + 1];
		//temp��������
		int mind = 0;
		// nums1����Ϊ�յ����
		if (nums1.length == 0) {
			//����ż�����
			if((nums1.length + nums2.length) % 2 == 1){
				return nums2[targetIndex];
			}else{
				return (nums2[targetIndex - 1] + nums2[targetIndex]) * 1.0 / 2;
			}
		}
		// nums2����Ϊ�յ����
		if (nums2.length == 0) {
			if((nums1.length + nums2.length) % 2 == 1){
				return nums1[targetIndex];
			}else{
				return (nums1[targetIndex - 1] + nums1[targetIndex]) * 1.0 / 2;
			}
		}
		//�鲢���������
		while (i < nums1.length || j < nums2.length) {
			if (i < nums1.length && j < nums2.length && nums1[i] <= nums2[j]) {
				temp[mind++] = nums1[i++];
			} else if (i < nums1.length && j < nums2.length
					&& nums1[i] > nums2[j]) {
				temp[mind++] = nums2[j++];
			} else if (i == nums1.length && j < nums2.length) {
				temp[mind++] = nums2[j++];
			} else if (i < nums1.length && j == nums2.length) {
				temp[mind++] = nums1[i++];
			}
			//�ж��Ƿ񵽴��м�������
			if (mind == targetIndex + 1) {
				if((nums1.length + nums2.length) % 2 == 1){
					target = temp[targetIndex];
				}else{
					target = (temp[targetIndex] + temp[targetIndex - 1]) * 1.0 / 2;
				}
				break;
			}

		}
		return target;
	}
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 3 };
		int[] nums2 = new int[] { 2 ,4};
		LeetCode4 lc = new LeetCode4();
		System.out.println(lc.findMedianSortedArrays(nums1, nums2));

	}
}
