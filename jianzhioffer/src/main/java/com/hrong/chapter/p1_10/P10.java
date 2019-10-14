package com.hrong.chapter.p1_10;

/**
 * @Author hrong
 * @Description 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 **/
public class P10 {
	/**
	 * 基本思路：
	 * n取值		方法种数
	 * 1		1
	 * 2		2(横纵两个方向)
	 * ...		...
	 * n		可以横置或者纵置，如果横置的话，则第一个方块下面的位置就固定了，所以是target-2
	 */
	private int RectCover(int target) {
		if (target <= 2) {
			return target;
		}
		return RectCover(target - 1) + RectCover(target - 2);
	}
}
