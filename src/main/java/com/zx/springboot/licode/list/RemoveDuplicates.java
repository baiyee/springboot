package com.zx.springboot.licode.list;

import org.apache.poi.hssf.record.DVALRecord;

import java.util.Arrays;

/**
 * @author zhangxuan
 * @description: 删除排序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @date 2021/7/14
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.removeDuplicates(new int[]{1, 1, 2});
        System.out.println(i);
        int i1 = s.removeDuplicates1(new int[]{1, 1, 2, 2, 2});
        System.out.println(i1);
    }

    static class Solution {
        //双指针解决
        int removeDuplicates(int[] A) {
            //边界条件判断
            if (A == null || A.length == 0) {
                return 0;
            }
            int left = 0;
            for (int right = 1; right < A.length; right++) {
                //如果左指针和右指针指向的值一样，说明有重复的，
                //这个时候，左指针不动，右指针继续往右移。如果他俩
                //指向的值不一样就把右指针指向的值往前挪
                if (A[left] != A[right]) {
                    A[++left] = A[right];
                }
            }
            System.out.println(Arrays.toString(A));
            return ++left;
        }
        //双指针，数组长度减去重复数字个数解决
        int removeDuplicates1(int[] A) {
            int count = 0;// 重复的数字个数
            for (int right = 1; right < A.length; right ++) {
                if (A[right] == A[right - 1]) {
                    //如果有重复，count 值加1
                    count ++;
                } else {
                    //如果没有重复，后面的就往前挪
                    A[right - count] = A[right];
                }
            }
            //数组长度减去重复的个数
            return A.length - count ;
        }

        int removeDuplicates2(int[] nums, int numsSize) {
            int j = numsSize;
            if (j > 1) {
                j = 1;
                for (int i = 1; i < numsSize; i++) {
                    if (nums[i] == nums[i - 1]) {
                        continue;
                    } else {
                        nums[j] = nums[i];
                        j++;
                    }
                }
            }
            return j;
        }
    }


}
