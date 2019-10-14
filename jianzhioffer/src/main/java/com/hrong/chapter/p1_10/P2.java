package com.hrong.chapter.p1_10;

/**
 * @Author hrong
 * @Description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 **/
public class P2 {
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello world");
		String result = new P2().replaceSpace(data);
		System.out.println(result);
	}

	private String replaceSpace(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}
}
