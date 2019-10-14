package com.hrong.chapter.p1_10;

/**
 * @Author hrong
 * @Description 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 **/
public class P9 {
	/**
	 * 基本思路：
	 * 台阶数	跳法
	 * 1		1
	 * 2		2 = f(1)+1
	 * 3		4 = f(2)+f(1)+1
	 * 4		8 = f(3)+f(2)+f(1)+1 = f(2)+f(1)+1+f(2)+f(1)+1=2*f(3)   12345 1235 125 1245 1345 135 145 15
	 * ..		..
	 * n		2*f(n-1)
	 */
	private int jumpFloorII(int target) {
		if (target <= 2) {
			return target;
		}
		return 2 * jumpFloorII(target - 1);
	}
}
