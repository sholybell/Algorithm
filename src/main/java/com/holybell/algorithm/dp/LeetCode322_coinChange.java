package com.holybell.algorithm.dp;

import java.util.Arrays;

/**
 * 难度:中等
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * Related Topics 动态规划
 **/
public class LeetCode322_coinChange {

    private static int myCoinChange(int[] coins, int amount) {
        return -1;
    }

    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------

    /**
     * 给定一个硬币集合，求各种硬币组合达到amount的最少硬币数
     * <p>
     * 本题DP解法，与 爬楼梯{@link LeetCode70_climbStairs} 以及 斐波那契数列{@link LeetCode509_fib} 一致，
     * 都可以看成 F(n) = F(n-2) + F(n-1) 这种类型的表达式构成
     * 本题的难点在于数组coins里面元素未知，但是可以转而这么思考 第一层循环 0 - amount 每个数组看看coins数组里的硬币是否可以一个硬币到达
     * 后面大额的Amount看看是否有 amount-coin 之前的金额已经有最小硬币数量，从所有amount-coin有解答的最小值+1即为当前amount的最小硬币数量
     *
     * @param coins  硬币面值集合
     * @param amount 给定数量
     */
    private static int coinChangeV1(int[] coins, int amount) {
        // 使用一个数组来保存达到当前下标的amount至少需要多少硬币
        int[] dp = new int[amount + 1];
        // 将数组的元素全部初始化为amount+1,因为硬币最小为1，那么达到amount最大硬币数量就是amount，amount+1是一个不可能值（注意题目的给定的数值范围）
        Arrays.fill(dp, amount + 1);
        // amount=0时，很明显，只需要0个硬币
        dp[0] = 0;
        // 开始计算每个amount需要的最少硬币数量
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 当前amount采用这枚币值的硬币之后会超过amount本身，不采用
                if (i - coin < 0) {
                    continue;
                }
                // 每一个amount的最少硬币数都可以考虑成这种情况，（当前amount-各种硬币的币值）这个比较小的amount+当前币值1个，得到一个当前amount可能的最少硬币数量
                // dp[i]会再循环中不断地被覆盖，因此每次都需要再拿出来和dp[i-coin]比较
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * 若dp数组使用-1作为初始值的解法
     */
    public int coinChangeV22(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        // 金额为下标时最小需要的硬币数量，dp[i]表示着此时硬币总额为i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                // 由于i表示当前硬币要凑的金额，如果一枚金币究竟超过了，那么dp[i]肯定保存初始值-1就好了
                if (i - coins[j] < 0) {
                    continue;
                }

                // 如果i刚好和硬币等值，那么dp[i]=1，仅需要一枚硬币
                if (i - coins[j] == 0) {
                    dp[i] = 1;
                } else {
                    // 如果扣掉当前硬币面值的金额没有答案，那么当前这枚硬币自然不能使用
                    if (dp[i - coins[j]] == -1) {
                        continue;
                    } else {
                        // 如果当前的金额i还是初始值dp[i]=-1，那么表示找到第一个解答
                        if (dp[i] == -1) {
                            dp[i] = dp[i - coins[j]] + 1;
                        } else {
                            // 当dp[i]!=-1表示已经使用过其他硬币，此时还有dp[i-coins[j]]+1的解法，那么取二者较小值
                            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        }
                    }
                }
            }
        }
        return dp[amount];
    }

    // --------------------------------------------------------------------

    private static int min = -1;

    /**
     * 本解答在LeetCode中将会超时
     */
    private static int coinChangeV2(int[] coins, int amount) {

        // 重置初始值
        min = -1;

        // 总额0不需要硬币
        if (amount == 0) {
            return 0;
        }

        // 硬币数组和总额为负数无解
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        // 使用所有面值的硬币作为第一枚硬币尝试穷举所有答案
        for (int i = 0; i < coins.length; i++) {
            helperV1(coins, amount, 1, 0, coins[i]);
        }

        return min;
    }

    private static void helperV1(int[] coins, long amount, int coinNum, long preAmount, int coin) {

        // 选择coin面值的硬币本轮累计的总金额
        long _amount = preAmount + coin;

        // 总金额为目标金额，有解答
        if (_amount == amount) {
            // min若为初始值直接赋值，如果已经有其他解答，相比取较小解答
            if (min == -1) {
                min = coinNum;
            } else {
                min = Math.min(min, coinNum);
            }
            return;
        }

        // 本轮金额已经超过目标金额，无解，不再往下递归
        if (_amount > amount) {
            return;
        }

        // 从本轮的总额_amount开始，继尝试所有所有面值的硬币往下递归
        for (int j = 0; j < coins.length; j++) {
            helperV1(coins, amount, coinNum + 1, _amount, coins[j]);
        }
    }

    // --------------------------------------------------------------------

    /**
     * 递归+记忆化
     */
    private static int coinChangeV3(int[] coins, int amount) {

        // 无解
        if (amount < 0) {
            return -1;
        }

        int limit = amount + 1;
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, limit);

        return helperV2(coins, amount, cache, limit);
    }

    /**
     * @param amount 每次递归要计算的最小硬币数量金额、
     * @param limit  建议数组的初始化值，为原amount+1
     */
    private static int helperV2(int[] coins, int amount, int[] cache, int limit) {

        // amount小于0 无解
        if (amount < 0) {
            return -1;
        }

        // amount=0，只需要0个硬币，配合下面的条件判断if (res != -1 && res < min),为一次有效解答的终结
        if (amount == 0) {
            return 0;
        }

        // TODO cache数组初始值都为limit，由于硬币最小为1元，不可能达到可以理解为cache[amount]==limit时还没有解答
        if (cache[amount] != limit) {
            return cache[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 选取一枚硬币面值，减去该面值进入下一次递归
            int res = helperV2(coins, amount - coin, cache, limit);
            if (res != -1 && res < min) {
                min = res + 1;      // TODO 不要忘记+1操作，每次递归本身就代表一枚硬币的选取，res表示剩余额度需要的最少硬币数量
            }
        }

        // 记录每一个面额的操作，配合上面进行递归减枝
        cache[amount] = (min != Integer.MAX_VALUE ? min : -1);

        // 整个方法完结，amount需要最少硬币数就在cache[amount]
        return cache[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println("你的答案:");
        System.out.println("数组 : " + Arrays.toString(coins) + " 凑成11最少需要几个硬币 : " + myCoinChange(coins, 11));
        System.out.println("---------------------------->");
        System.out.println("正确答案:");
        System.out.println("数组 : " + Arrays.toString(coins) + " 凑成11最少需要几个硬币 : " + coinChangeV1(coins, 11));
        System.out.println("数组 : " + Arrays.toString(coins) + " 凑成11最少需要几个硬币 : " + coinChangeV2(coins, 11));
        System.out.println("数组 : " + Arrays.toString(coins) + " 凑成11最少需要几个硬币 : " + coinChangeV3(coins, 11));
    }
}
