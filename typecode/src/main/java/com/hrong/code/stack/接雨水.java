package com.hrong.code.stack;

import java.util.Stack;

/**
 * @author hrong
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 **/
public class 接雨水 {
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		// 初始化栈的值
		stack.push(0);
		int totalWater = 0;
		int tmpWater = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < height.length; i++) {
			int h = height[i];
			Integer maxHeight = stack.lastElement();
			// 当前高度如果小于历史最高，则表明当前可以进行累加(后续必须要有height大于等于当前历史最高)
			if (h < maxHeight) {
				tmpWater += (maxHeight - h);
			}
			// 如果出现高度大于栈顶的值，则将栈顶的值替换为当前的值
			if (h >= maxHeight) {
				stack.pop();
				stack.push(h);
				totalWater += tmpWater;
				tmpWater = 0;
			}
		}
		return totalWater;
	}

	public static void main(String[] args) {
		System.out.println(new 接雨水().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
	}
}
