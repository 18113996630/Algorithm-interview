package com.hrong.chapter.p1_10;

import java.util.ArrayList;

/**
 * @Author hrong
 * @Description 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 **/
public class P3 {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		ArrayList<Integer> result = new P3().printListFromTailToHead(node);
		for (Integer number : result) {
			System.out.print(number + " ");
		}
	}

	/**
	 * 常规解法：顺序遍历ListNode，将数据存入list中，再将list倒序
	 */
	private ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null) {
			return new ArrayList<>();
		}
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		ListNode iter = listNode;
		while (iter != null) {
			list.add(iter.val);
			iter = iter.next;
		}
		//反转list
		for (int i = list.size() - 1; i >= 0; i--) {
			result.add(list.get(i));
		}
		return result;
	}



	/**
	 * 第二种解法：要想直接倒序保存数据，则应该从链表最后开始保存，再循环倒序保存前面的数据
	 * 这里可以找到循环的终点：当链表不为空，则可以使用递归完成
	 */
	private ArrayList<Integer> result = new ArrayList<>();
	private ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead2(listNode.next);
			result.add(listNode.val);
		}
		return result;
	}
}
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
