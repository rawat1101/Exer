package org.example.leetcode;

public class JumpGame {
    public static void main(String[] args) {

    }

    public static boolean canJumpL1(int[] nums) {

        int des = nums.length - 1;
        for (int i = des - 1; i >= 0; i--) {
            if (nums[i] + i >= des)
                des = i;
        }
        return des == 0;
    }

    public int jumpL2(int[] nums) {
        int jump = 0;
        int pos = 0;
        int dis = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            dis = Math.max(dis, i + nums[i]);
            if (i == pos) {
                jump++;
                pos = dis;
            }
        }
        return jump;
    }
}
