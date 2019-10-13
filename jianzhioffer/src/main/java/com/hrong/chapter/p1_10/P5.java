package com.hrong.chapter.p1_10;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author hrong
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 栈：先进后出
 * 队列：先进先出
 * 通过两个栈实现元素先进先出的效果
 **/
public class P5 {
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	/**
	 * 大致思路：
	 * 存元素时将元素存入stack1，
	 * 取元素时因为栈是先进后出，所以单个栈无法实现先进先出
	 * 借助第二个栈，可以将第一个栈中的元素依次弹出并存入第二个栈
	 * 所以原本在第一个栈中是先进后出的顺序，经过处理变成了先进先出的顺序
	 */
	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.size() == 0) {
			while (stack1.size() != 0) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		P5 p5 = new P5();
		p5.push(1);
		p5.push(2);
		p5.push(34);
		p5.push(5);
		System.out.println(p5.pop());
	}
}
