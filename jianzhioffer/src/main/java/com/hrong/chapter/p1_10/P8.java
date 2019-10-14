package com.hrong.chapter.p1_10;

/**
 * @Author hrong
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 **/
public class P8 {
	/**
	 * 每次只能跳一级或者两级，所以可以从终点往前推
	 * 终点只能由n-1或者n-2跳上去，一直可以推到n<=3
	 * n=3时有三种跳法，n=2时有两种跳法，n=1时有一种跳法
	 */
	private int JumpFloor(int target) {
		if (target <= 3) {
			return target;
		}
		return JumpFloor(target - 1) + JumpFloor(target - 2);
	}
}
