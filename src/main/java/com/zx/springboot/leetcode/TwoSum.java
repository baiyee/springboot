package com.zx.springboot.leetcode;

/**
 * @description: TODO 求两数之和，使用暴力双重遍历
 * @date 2021/7/14
 * @author zhangxuan
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Solution.twoSum(new int[]{3,2,4},6));
    }
   static class Solution {
        public static int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            for (int i = 0; i < nums.length; i ++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] + nums[j] != target) {
                        continue;
                    } else {
                        return new int[]{i,j};
                    }
                }
            }
            return null;
        }
    }
}
