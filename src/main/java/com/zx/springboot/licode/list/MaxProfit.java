package com.zx.springboot.licode.list;

/**
 * @author zhangxuan
 * @description: 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: prices = [7,1,5,3,6,4] = 1-7 + 5-1 + 3-5 + 6-3 + 4-6 = -6 + 4 + -2 + 3 + -2  取正数相加  4 + 3 = 7
 * 输出: 7
 * 输入: prices = [1,2,3,4,5]  2-1 + 3-2 + 4-3 + 5-4  = 1 + 1 + 1 + 1 = 4
 * 输出: 4
 * 输入: prices = [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 解题思路：
 * • 动态规划
 * • 贪心算法：
 * 思路：下标默认值为0  拿下标+1 的值减去 当前下标的值 得到 正数 则 相加， 得到负数 则不加 也可以理解为 +0
 * 那么规律：((prices[1] - prices[0])>0)? (prices[0] - prices[1]):0
 * + ((prices[2] - prices[1])>0)? (prices[2] - prices[1]):0
 * + ((prices[3] - prices[2])>0)? (prices[3] - prices[2]):0
 * + ((prices[n+1] - prices[n])>0)? (prices[n+1] - prices[n]):0
 * @date 2021/7/14
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[]{1, 2, 3, 4, 5};
        int[] prices3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(Solution.maxProfit(prices1));
        System.out.println(Solution.maxProfit(prices2));
        System.out.println(Solution.maxProfit(prices3));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(Solution.myMaxProfit(prices1));
        System.out.println(Solution.myMaxProfit(prices2));
        System.out.println(Solution.myMaxProfit(prices3));
    }

    static class Solution {
        //贪心算法求解
        public static int myMaxProfit(int[] prices) {
            //校验数组非空
            if (prices == null || prices.length == 0) {
                return 0;
            }
            //总利润
            int totalProfit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                //获取每段利润，并保持利润不亏损。
                int perSegmentProfit = (prices[i + 1] - prices[i] > 0) ? prices[i + 1] - prices[i]:0;
                //总利润 = 每段不亏损利润总和
                if (perSegmentProfit != 0) {
                    totalProfit += perSegmentProfit;
                }
            }
            return totalProfit;
        }

        //贪心算法
        public static int maxProfit(int[] prices) {
            //数组校验非空
            if (prices == null || prices.length == 0) {
                return 0;
            }
            //总利润
            int maxProfit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                maxProfit += Math.max(prices[i + 1] - prices[i], 0);
            }
            return maxProfit;
        }
    }
}
