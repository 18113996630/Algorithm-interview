package com.hrong.code.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hrong
 **/
public class ListStack {
	private List<Integer> list;

	/**
	 * Initialize your data structure here.
	 */
	public ListStack() {
		list = new ArrayList<>();
	}

	/**
	 * Push element x onto stack.
	 */
	public void push(int x) {
		list.add(x);
	}

	/**
	 * Removes the element on top of the stack and returns that element.
	 */
	public int pop() {
		return list.remove(list.size() - 1);
	}

	/**
	 * Get the top element.
	 */
	public int top() {
		return list.get(list.size() - 1);
	}

	/**
	 * Returns whether the stack is empty.
	 */
	public boolean empty() {
		return list.size() == 0;
	}

	public static void main(String[] args) {
		ListStack stack = new ListStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.empty());
	}
}
