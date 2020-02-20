package com.hrong.code.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hrong
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class 有效的括号 {
	private static Map<Character, Character> mapping = new HashMap<>(3);
	static {
		mapping.put(')', '(');
		mapping.put('}', '{');
		mapping.put(']', '[');
	}
	public boolean isValid(String s) {
		if (s == null || "".equals(s)) {
			return true;
		}
		int length = s.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < length; i++) {
			char singleChar = s.charAt(i);
			// 如果是属于前括号，那么直接加入栈顶
			if (mapping.containsValue(singleChar)) {
				stack.push(singleChar);
			} else {
				// 如果第一个元素就是后括号，直接返回false
				if (stack.size() == 0) {
					return false;
				}
				// 判断前括号与后括号的类型是否匹配
				Character rightCharacter = mapping.get(singleChar);
				if (!rightCharacter.equals(stack.lastElement())) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		// 如果栈内还有元素，则说明还有未消除掉的元素
		return stack.size() == 0;
	}

	public static void main(String[] args) {
		String s = "]";
		System.out.println(new 有效的括号().isValid(s));
	}
}
