package com.hrong.chapter.p1_10;

/**
 * @Author hrong
 * @Description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 **/
public class P7 {
	/**
	 * 基本思路：
	 * 0 1 1 2 3 5 8 13
	 * 规律是：第n项=（第n-1项） + （第n-2项）
	 * 所以自然联想到使用递归来进行求解
	 * 递归的终点是当n等于0或者1
	 */
	public int Fibonacci(int n) {
		//递归终点
		if (n == 0 || n == 1) {
			return n;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
