package com.hrong.code.linklist;

import java.util.Scanner;

/**
 * Lru算法-最近最少使用策略-数组实现方式
 * 维护一个数组，数组中缓存最近使用的元素
 * 如果元素在数组中不存在，当数组容量==长度时，先删除末尾元素，然后再数组第一位添加元素
 * 如果已存在，则将该元素放到第一位，其他元素后移
 *
 * @author hrong
 **/
public class LruArray {
	private final static Integer DEFAULT_CAPACITY = 10;
	/**
	 * 数据容器
	 */
	private Object[] dataArray;
	private int capacity;
	private int count;

	public LruArray() {
		this(0);
	}

	public LruArray(int capacity) {
		this.capacity = capacity;
		this.dataArray = new Object[capacity];
		this.count = 0;
	}

	private void add(Object element) {
		int index = findIndex(element);
		if (index == -1) {
			// 不存在，直接在第一位进行增加
			if (count == capacity) {
				deleteLastElement();
			}
			insertIntoFirstPosition(element);
		} else {
			// 将其他元素后移,该元素放到第一位
			for (int i = index; i > 0; i--) {
				dataArray[i] = dataArray[i - 1];
			}
			dataArray[0] = element;
		}
	}

	/**
	 * 删除最后一位元素
	 */
	private void deleteLastElement() {
		dataArray[count - 1] = null;
		count--;
	}

	/**
	 * 在数组下标为0处新增一个元素
	 *
	 * @param element 待新增的元素
	 */
	private void insertIntoFirstPosition(Object element) {
		if (count == capacity) {
			throw new RuntimeException("the array is full,no free position");
		}
		// 倒序进行赋值
		for (int i = count - 1; i >= 0; i--) {
			dataArray[i + 1] = dataArray[i];
		}
		dataArray[0] = element;
		count++;
	}

	/**
	 * 根据元素查询对应下标，如果该元素不存在，则返回-1
	 *
	 * @param element 待查询的元素
	 * @return 结果下标
	 */
	private int findIndex(Object element) {
		if (count == 0) {
			return -1;
		}
		for (int i = 0; i < count; i++) {
			if (element.equals(dataArray[i])) {
				return i;
			}
		}
		return -1;
	}

	private void show() {
		for (int i = 0; i < count; i++) {
			System.out.print(dataArray[i]);
			if (i != count - 1) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LruArray array = new LruArray(3);
		System.out.println("请开始输入");
		while (true) {
			array.add(scanner.next());
			array.show();
		}
	}
}
