package test;

import java.util.LinkedList;

public class LRUTest {

	public static void main(String[] args) {

		lru(new int[] { 7, 0, 1, 2, 0, 3, 0, 4 },4);
	}

	public static void lru(int[] is,int num) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 0; i < is.length; i++) {
			if (ll.size() < num) {
				// 添加到满为止
				ll.add(is[i]);
				System.out.println(ll.toString());
			} else {
				if (ll.contains(is[i])) {
					// 新的放到最后
					int index = ll.indexOf(is[i]);
					for(int j = index+1;j<num;j++) {
						ll.set(j-1, ll.get(j));
					}
					ll.set(num-1, is[i]);
					System.out.println(ll.toString());
				} else {
					// 去掉第一个
					for (int j = 0; j < num-1; j++) {
						ll.set(j, ll.get(j + 1));
					}
					ll.set(num-1, is[i]);
					System.out.println(ll.toString());
				}
			}
		}
	}
}
