package com.hrong.code.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hrong
 **/
public class ArrayUtils {
	private static final int MAX = 20;

	/**
	 * 随机生成长度为l的int数组
	 * @param l 指定长度
	 * @return arr
	 */
	private static int[] gen(int l) {
		int[] arr = new int[l];
		Random random = new Random();
		for (int i = 0; i < l; i++) {
			arr[i] = random.nextInt(MAX) + 1;
		}
		System.out.println("随机生成的数组为：" + Arrays.toString(arr));
		return arr;
	}
}
