package com.hrong.chapter.p1_10;

/**
 * @Author hrong
 * @Description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class P1 {
	public static void main(String[] args) {
		int[][] array = {
				{0, 1, 3, 4, 5, 7, 8, 11, 13, 15, 18, 21, 24, 27, 30, 32, 35, 36, 39, 41, 42, 43, 46, 49, 52, 55, 58, 60, 63, 66, 67, 69, 72, 75, 78, 80, 81, 82, 85, 86},
				{1, 4, 6, 8, 11, 12, 15, 17, 18, 20, 23, 24, 27, 30, 33, 34, 38, 39, 42, 44, 47, 48, 51, 52, 55, 57, 59, 62, 64, 67, 70, 72, 75, 77, 81, 83, 84, 87, 90, 91},
				{4, 7, 8, 11, 14, 16, 18, 20, 21, 24, 27, 29, 32, 35, 36, 39, 40, 42, 44, 46, 49, 52, 54, 56, 58, 60, 61, 64, 67, 70, 73, 76, 78, 81, 84, 87, 89, 91, 93, 96},
				{5, 8, 10, 13, 15, 19, 21, 23, 24, 27, 29, 31, 34, 37, 38, 41, 43, 45, 46, 49, 52, 55, 58, 59, 61, 64, 67, 69, 71, 72, 76, 78, 79, 83, 87, 90, 91, 94, 96, 97},
				{6, 11, 14, 16, 18, 22, 24, 27, 29, 32, 33, 35, 36, 40, 42, 44, 47, 50, 51, 52, 54, 58, 60, 62, 64, 67, 70, 73, 76, 79, 82, 84, 87, 88, 91, 94, 97, 99, 101, 102},
				{9, 13, 16, 19, 21, 23, 25, 29, 31, 35, 38, 39, 42, 45, 48, 51, 54, 56, 57, 60, 63, 64, 67, 69, 72, 73, 74, 76, 79, 81, 85, 88, 90, 92, 95, 98, 100, 101, 104, 106},
				{10, 16, 19, 22, 24, 26, 29, 31, 34, 36, 40, 41, 45, 46, 50, 54, 56, 59, 60, 63, 66, 69, 70, 72, 75, 77, 79, 81, 83, 85, 88, 91, 93, 96, 98, 99, 102, 105, 107, 109},
				{12, 18, 22, 25, 26, 29, 32, 33, 37, 39, 42, 44, 47, 50, 52, 57, 59, 61, 62, 66, 68, 71, 72, 74, 76, 80, 82, 84, 87, 90, 92, 94, 95, 98, 101, 102, 105, 107, 109, 112},
				{14, 20, 25, 27, 30, 32, 35, 37, 40, 43, 44, 47, 49, 52, 54, 58, 60, 63, 65, 68, 70, 73, 75, 76, 78, 83, 84, 86, 89, 92, 93, 97, 99, 101, 103, 104, 107, 110, 113, 116},
				{17, 23, 28, 29, 32, 33, 38, 40, 42, 46, 49, 50, 52, 55, 56, 60, 63, 65, 68, 71, 74, 75, 78, 81, 84, 87, 89, 92, 95, 96, 99, 100, 102, 104, 106, 108, 110, 113, 115, 118},
				{18, 25, 30, 31, 35, 38, 41, 43, 45, 48, 52, 53, 55, 58, 60, 62, 66, 67, 70, 73, 76, 77, 79, 82, 86, 89, 92, 95, 98, 101, 102, 103, 106, 109, 111, 112, 114, 117, 119, 122},
				{21, 28, 32, 34, 38, 40, 42, 45, 47, 50, 53, 56, 59, 60, 61, 63, 69, 71, 74, 75, 78, 80, 83, 84, 87, 90, 93, 98, 100, 104, 107, 110, 111, 113, 116, 117, 118, 120, 122, 123},
				{23, 29, 34, 36, 41, 43, 46, 49, 52, 54, 55, 58, 60, 63, 65, 67, 72, 74, 75, 77, 80, 82, 85, 88, 91, 94, 97, 100, 103, 106, 110, 113, 114, 116, 119, 122, 124, 125, 126, 129}};
		int target = 22;
		System.out.println(new P1().Find(target, array));
	}

	/**
	 * 解题思路：
	 * 整个二维数组可以看做一个矩阵，可以以左下角为起点开始比较，
	 * 若目标值大于起点值，则将x值加1；否则将y减1
	 */
	public boolean Find(int target, int[][] array) {
		int x = 0;
		int y = array.length - 1;
		while (x < array[0].length && y >= 0) {
			if (array[y][x] > target) {
				y--;
			} else if (array[y][x] < target) {
				x++;
			} else {
				return true;
			}
		}
		return false;
	}
}