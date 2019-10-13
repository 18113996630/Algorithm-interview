package com.hrong.type.tree;

import java.util.Arrays;

/**
 * @Author hrong
 * @Description
 **/
public class TreeGenerator {

	public static TreeNode generateTree(){
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		return reConstructBinaryTree(pre, in);
	}
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
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
