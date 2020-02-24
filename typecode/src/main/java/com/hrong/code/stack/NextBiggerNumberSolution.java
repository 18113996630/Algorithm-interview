package com.hrong.code.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hrong
 **/
public class NextBiggerNumberSolution {

	/**
	 *
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//最原始的方法，两层循环
		/*int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int current = nums1[i];
			result[i] = -1;
			boolean flag = false;
			for (int j = 0; j < nums2.length; j++) {
				if (!flag && nums2[j] == current) {
					flag = true;
				}
				if (flag && nums2[j] > current) {
					result[i] = nums2[j];
					break;
				}
			}
		}
		return result;*/

		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> mapping = new HashMap<>();
		for (int number : nums2) {
			if (!stack.isEmpty()) {
				// 5321   4
				while (!stack.isEmpty()) {
					if (stack.peek() < number) {
						mapping.put(stack.pop(), number);
					} else {
						stack.push(number);
						break;
					}
				}
			}
			stack.push(number);
		}
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			result[i] = mapping.get(nums1[i]) == null ? -1 : mapping.get(nums1[i]);
		}
		return result;
	}
}
