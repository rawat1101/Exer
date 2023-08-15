package org.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> list =new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>(3, 1.0f);
		System.out.println(list);
		System.out.println(map);
		/*
		 * Map<Integer, Integer> map = new HashMap<>(3, 1.0f); map.put(1, 1); map.put(2,
		 * 2); map.put(3, 3); map.put(4, 4); map.put(5, 5);
		 */

		/*
		 * System.out.println("11111111111111111111111111111111".length());
		 * System.out.println(Integer.toBinaryString(1024));
		 * System.out.println(Integer.toBinaryString(-1));
		 * System.out.println(tableSizeFor(1024));
		 */

		Thread unstarted = Thread.ofVirtual().unstarted(() -> System.out.println("Virtual thread"));
		unstarted.start();
		Thread startVirtualThread = Thread.startVirtualThread(() -> System.out.println("Virtual thread 2"));
		System.out.println(unstarted.getName());
		System.out.println(startVirtualThread.getName());
		Thread.sleep(2000);

		Random random = new Random();
		System.out.println(random.nextInt(10, 100));
		System.out.println(-1.0 / 0.0);
	}

	static final int tableSizeFor(int cap) {
		int n = -1 >>> numberOfLeadingZeros(cap - 1);
		return (n < 0) ? 1 : (n >= 1000000) ? 1000000 : n + 1;
	}

	public static int numberOfLeadingZeros(int i) {
		// HD, Count leading 0's
		if (i <= 0)
			return i == 0 ? 32 : 0;
		int n = 31;// maximum number of leading zeros possible in a 32-bit integer.
		if (i >= 1 << 16) {
			n -= 16;
			i >>>= 16;
		}
		if (i >= 1 << 8) {
			n -= 8;
			i >>>= 8;
		}
		if (i >= 1 << 4) {
			n -= 4;
			i >>>= 4;
		}
		if (i >= 1 << 2) {
			n -= 2;
			i >>>= 2;
		}
		return n - (i >>> 1);
	}
}
