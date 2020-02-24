package com.hrong.code.stack;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hrong
 **/
public class MyQueue {
	private Stack<Integer> data;
	private Stack<Integer> help;
	/** Initialize your data structure here. */
	public MyQueue() {
		data = new Stack<>();
		help = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!data.isEmpty()){
			help.push(data.pop());
		}
		help.add(x);
		while (!help.isEmpty()) {
			data.push(help.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (data.isEmpty()) {
			throw new RuntimeException("illegal");
		}
		return data.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (data.isEmpty()) {
			throw new RuntimeException("illegal");
		}
		return data.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return data.size() == 0;
	}
}
