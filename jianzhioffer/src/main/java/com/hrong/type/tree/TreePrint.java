package com.hrong.type.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author hrong
 * @Description 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 **/
public class TreePrint {

	public static void main(String[] args) {
		TreePrint obj = new TreePrint();
		//正确打印结果：12347568
		TreeNode tree = TreeGenerator.generateTree();
		ArrayList<Integer> printData = obj.printFromTopToBottom(tree);
		System.out.println(printData);
	}

	/**
	 * 解题思路：
	 * 最开始想要用递归来完成，但是后续发现使用递归的话【同层节点从左至右打印】功能无法完成，
	 * 会出现先输出左边的节点，再输出右边节点的情况
	 * <p>
	 * 循环肯定是要的，同层节点要从左到右输出，
	 * 所以可以想到根据【当前节点(在循环过程中不断改变)】获取左节点右节点，然后依次输出左节点和右节点
	 * 但是【当前节点】只有一个，怎么动态赋值呢，这时候可以考虑引入一个有序的list，遍历左节点右节点的时候
	 * 将节点按顺序加入list，再将list的第一个元素赋值给【当前节点】
	 */
	private ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		ArrayList<Integer> printData = new ArrayList<>();
		LinkedList<TreeNode> data = new LinkedList<>();
		data.add(root);
		TreeNode cur;
		while (!data.isEmpty()) {
			cur = data.removeFirst();
			printData.add(cur.val);
			//同层节点从左至右打印
			if (cur.left != null) {
				data.add(cur.left);
			}
			if (cur.right != null) {
				data.add(cur.right);
			}
		}
		return printData;
	}
}
