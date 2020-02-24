package com.hrong.code.stack;

import java.util.Stack;

/**
 * @author hrong
 **/
public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.add(x);
		if (!minStack.isEmpty()) {
			Integer minElement = minStack.peek();
			if (minElement >= x) {
				minStack.pop();
				minStack.add(x);
			}
		} else {
			minStack.add(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()){
			Integer removeValue = stack.pop();
			if (removeValue.equals(minStack.peek())) {
				minStack.pop();
			}
		}
	}

	public int top() {
		if (stack.isEmpty()) {
			throw new RuntimeException("非法");
		}
		return stack.peek();
	}

	public int getMin() {
		if (minStack.isEmpty()) {
			throw new RuntimeException("非法");
		}
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		System.out.println(stack.top());

	}
}
