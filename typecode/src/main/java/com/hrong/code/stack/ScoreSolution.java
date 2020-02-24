package com.hrong.code.stack;

import java.util.Stack;

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hrong
 **/
public class ScoreSolution {
	private Stack<Integer> score = new Stack<>();

	/**
	 * 将传入的参数进行拆分，根据不同的情况进行处理
	 * 当为D时：栈顶元素*2
	 * 当为+时，获取两次栈顶元素，并进行相加
	 * 当为C时，将上次分数无效，即移除栈顶元素
	 * 当为数字时，压栈
	 *
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 */
	public int calPoints(String[] ops) {
		if (ops.length == 0) {
			return 0;
		}
		for (String op : ops) {
			int currentScore;
			if ("D".equals(op)) {
				// 前一轮有效回合
				score.push(score.peek() * 2);
			} else if ("+".equals(op)) {
				Integer lastScore = score.pop();
				Integer secondLastScore = score.peek();
				currentScore = lastScore + secondLastScore;
				score.push(lastScore);
				score.push(currentScore);
			} else if ("C".equals(op)) {
				score.pop();
			}else {
				score.push(Integer.valueOf(op));
			}
		}
		int totalScore = 0;
		while (!score.isEmpty()) {
			totalScore += score.pop();
		}
		return totalScore;
	}

	public static void main(String[] args) {
		String[] data = new String[]{"5","-2","4","C","D","9","+","+"};
		System.out.println(new ScoreSolution().calPoints(data));
	}
}
