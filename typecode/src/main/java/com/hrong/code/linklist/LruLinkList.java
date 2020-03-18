package com.hrong.code.linklist;


import java.util.Scanner;

/**
 * Lru算法-最近最少使用策略-单链表实现方式
 * 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 	如果此时缓存未满，则将此结点直接插入到链表的头部；
 * 	如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部
 * @author hrong
 **/
public class LruLinkList<T> {
	private final static Integer DEFAULT_CAPACITY = 10;
	/**
	 * 头节点
	 */
	private Node<T> head;
	/**
	 * 链表长度
	 */
	private int length;
	/**
	 * 链表容量
	 */
	private Integer capacity;

	public LruLinkList(Integer capacity) {
		this.capacity = capacity;
		this.length = 0;
		this.head = new Node<>();
	}

	public LruLinkList() {
		this(0);
	}

	public void add(T element) {
		// 先判断是否存在，获取前驱元素
		Node<T> pre = findPre(element);
		if (pre == null) {
			// 在链表尾部添加元素，当length==capacity时先删除尾部元素
			if (length == capacity) {
				deleteLastNode();
			}
			// 将元素添加到头部
			insertAtHead(element);
		} else {
			// 将元素换到链表头部
			Node<T> tmp = pre.getNext();
			pre.setNext(tmp.getNext());
			tmp.setNext(null);
			insertAtHead(element);
		}
	}

	public void print() {
		Node<T> current = head.getNext();
		while (current.getNext() != null) {
			System.out.print(current.getElement()+" -> ");
			current = current.getNext();
		}
		System.out.println(current.getElement());
	}

	/**
	 * 保持头部元素的值始终为空，这样处理所有节点的逻辑都是一样的了
	 * 值为空 -> 1 -> 2 -> null
	 */
	public void insertAtHead(T element) {
		head.setNext(new Node<>(element, head.getNext()));
		length++;
	}

	/**
	 * 删除尾节点
	 */
	public void deleteLastNode() {
		Node<T> current = head;
		if (current.getNext() == null) {
			return;
		}
		while (current.getNext().getNext() != null) {
			current = current.getNext();
		}
		current.setNext(null);
		length--;
	}

	/**
	 * 查询前一个节点,判断条件应该是当前节点的next节点是否为空
	 */
	public Node<T> findPre(T element) {
		Node<T> current = head;
		while (current.getNext() != null) {
			if (element.equals(current.getNext().getElement())) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LruLinkList<Integer> objectLru = new LruLinkList<>();
		while (true) {
			int value = scanner.nextInt();
			System.out.println("输入值：" + value);
			objectLru.add(value);
			objectLru.print();
		}
	}
}
