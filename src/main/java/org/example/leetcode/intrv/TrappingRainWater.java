package org.example.leetcode.intrv;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] heights = { 17, 11, 17 };

		System.out.println("water trapped is: " + trap(heights));
//		System.out.println("water trapped2 is: " + trap2(heights));

	}

	public static int trap(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		int leftMax = 0, rightMax = 0, ans = 0;
		while (l < r) {
			leftMax = Math.max(leftMax, arr[l]);
			rightMax = Math.max(rightMax, arr[r]);
			if (leftMax < rightMax)
				ans = ans + leftMax - arr[l++];
			else
				ans = ans + rightMax - arr[r--];
		}
		return ans;
	}

	static int trap3(int[] arr) {
		int n = arr.length;
		int[] leftHeights = new int[n];
		int[] rightHeights = new int[n];
		leftHeights[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftHeights[i] = Math.max(leftHeights[i - 1], arr[i]);
		}
		rightHeights[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightHeights[i] = Math.max(rightHeights[i + 1], arr[i]);
		}
		int waterTrapped = 0;
		for (int i = 0; i < n; i++) {
			waterTrapped += Math.min(leftHeights[i], rightHeights[i]) - arr[i];
		}
		return waterTrapped;
	}

}
