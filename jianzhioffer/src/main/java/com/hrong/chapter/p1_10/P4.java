package com.hrong.chapter.p1_10;

import java.util.Arrays;

/**
 * @Author hrong
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * --------------A
 * ------------*----*
 * ----------B---------C
 * --------*---*--------*
 * ------D------E--------F
 * ------------*---*
 * -----------G------H
 * 前中后描述的是根节点的位置信息
 * 前序遍历：根结点 —> 左子树 —> 右子树（先遍历根节点，然后左右）ABDEGHCF
 * 中序遍历：左子树—> 根结点 —> 右子树（在中间遍历根节点）DBGEHACF
 * 后序遍历：左子树 —> 右子树 —> 根结点（最后遍历根节点）DGHEBFCA
 **/
public class P4 {
	public static void main(String[] args) {
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode result = new P4().reConstructBinaryTree(pre, in);
		System.out.println(result);
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		//递归的终点
		if (in.length == 0) {
			return null;
		}
		//当前递归过程中的根节点
		TreeNode root = new TreeNode(pre[0]);
		//在中序中找到根节点
		for (int i = 0; i < in.length; i++) {
			if (pre[0] == in[i]) {
				//找到根节点左侧下方节点的前序
				int[] innerLeftPre = Arrays.copyOfRange(pre, 1, i + 1);
				//找到根节点左侧下方节点的中序
				int[] innerLeftIn = Arrays.copyOfRange(pre, 0, i);
				root.left = reConstructBinaryTree(innerLeftPre, innerLeftIn);
				//找到根节点右侧下方节点的前序
				int[] innerRightPre = Arrays.copyOfRange(pre, i + 1, pre.length);
				//找到根节点右侧下方节点的中序
				int[] innerRightIn = Arrays.copyOfRange(in, i + 1, in.length);
				root.right = reConstructBinaryTree(innerRightPre, innerRightIn);
			}
		}
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
