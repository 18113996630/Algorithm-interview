package com.hrong.code.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 使用两个栈来实现浏览器的前进后退的功能
 * @author hrong
 **/
public class GoBackStack {
	private Stack<String> left;
	private Stack<String> right;

	public GoBackStack() {
		left = new Stack<>();
		right = new Stack<>();
	}

	public void go(String page) {
		left.push(page);
	}

	public void back() {
		String topPage = left.pop();
		right.push(topPage);
	}

	public void show() {
		System.out.println("left:" + Arrays.toString(left.toArray()));
		System.out.println("right:" + Arrays.toString(right.toArray()));
	}

	public static void main(String[] args) {
		GoBackStack stack = new GoBackStack();
		stack.go("a");
		stack.show();
		stack.go("b");
		stack.show();
		stack.go("c");
		stack.show();
		stack.back();
		stack.show();
		stack.back();
		stack.show();
	}
}
