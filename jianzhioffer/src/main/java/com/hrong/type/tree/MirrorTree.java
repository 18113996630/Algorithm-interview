package com.hrong.type.tree;

import com.hrong.chapter.p1_10.P4;

/**
 * @Author hrong
 * @Description
 * 二叉树的镜像定义：源二叉树
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 **/
public class MirrorTree {
	public static void main(String[] args) {
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode treeNode = TreeGenerator.reConstructBinaryTree(pre, in);
		System.out.println(treeNode);
		mirror(treeNode);
		System.out.println(treeNode);
	}

	/**
	 * 思路：
	 * 将树的左右节点进行交换
	 * 递归终止条件：左节点和右节点都为空
	 */
	private static void mirror(TreeNode root) {
		if (root != null && (root.left != null || root.right != null)) {
			TreeNode left = root.left;
			root.left = root.right;
			root.right =left;
			mirror(root.left);
			mirror(root.right);
		}
	}
}

