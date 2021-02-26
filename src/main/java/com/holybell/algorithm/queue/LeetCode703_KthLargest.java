package com.holybell.algorithm.queue;

import java.util.PriorityQueue;

/**
 * 难度：简单
 * <p>
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * <p>
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * <p>
 * <p>
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * <p>
 * Related Topics 堆 设计
 * <p>
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
public class LeetCode703_KthLargest {

    static class MyKthLargest {


        public MyKthLargest(int k, int[] nums) {

        }

        public int add(int val) {
            return -1;
        }
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
     * 使用优先队列并使用K大值控制优先队列长度
     * 如果队列不满足K个元素，直接入队列，如果队列满足K个元素，要入队的时候，额外判断堆顶元素小于要入队的元素，
     * 这样就能保证堆内元素一直是目前遍历过的整数流中的前K个大数字
     */
    static class KthLargestV1 {

        private int k;
        // 优先队列默认小顶堆！！！
        private PriorityQueue<Integer> priorityQueue;

        public KthLargestV1(int k, int[] nums) {
            this.k = k;
            this.priorityQueue = new PriorityQueue<>();
            for (int num : nums) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(num);
                } else {
                    //  超过指定个数，弹出优先队列头部元素，再入队列
                    // 还需要额外判断堆顶元素是否小于要插入的元素，如果小于，在插入，否则以[4,5,8,2]，k=3为例，插入2时会把堆顶的4顶出去
                    if (priorityQueue.peek() < num) {
                        priorityQueue.poll();
                        priorityQueue.add(num);
                    }
                }
            }
        }

        public int add(int val) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(val);
                // 题目保证add的时候堆内一定会有三个元素，有可能本来就2个元素，加入一个刚好3个，此时直接返回堆顶元素
                return priorityQueue.peek();
            } else {
                // 只有当堆顶元素小于要插入的的元素再进行插入
                if (priorityQueue.peek() < val) {
                    priorityQueue.add(val);
                    priorityQueue.poll();
                }
                return priorityQueue.peek();
            }
        }
    }

    /**
     * 上一种解法过于冗余，简化为这种，复用add方法，每次插入的时候如果当前队列个数大于K，那么弹出堆顶元素，返回剩下的堆顶元素即可
     */
    static class KthLargestV2 {

        private int k;
        private PriorityQueue<Integer> priorityQueue;

        public KthLargestV2(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            priorityQueue.add(val);
            // 如果长度大于K个，那么只能是K+1个，丢掉堆顶元素，剩下K个
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }

    // --------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        System.out.println("你的答案:");
        MyKthLargest myKthLargest = new MyKthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("插入3后第3大的元素:" + myKthLargest.add(3));
        System.out.println("插入5后第3大的元素:" + myKthLargest.add(5));
        System.out.println("插入10后第3大的元素:" + myKthLargest.add(10));
        System.out.println("插入9后第3大的元素:" + myKthLargest.add(9));
        System.out.println("插入4后第3大的元素:" + myKthLargest.add(4));
        System.out.println("----------------");
        myKthLargest = new MyKthLargest(3, new int[]{5, -1});
        System.out.println("插入2后第3大的元素:" + myKthLargest.add(2));
        System.out.println("插入1后第3大的元素:" + myKthLargest.add(1));
        System.out.println("插入-1后第3大的元素:" + myKthLargest.add(-1));
        System.out.println("插入3后第3大的元素:" + myKthLargest.add(3));
        System.out.println("插入4后第3大的元素:" + myKthLargest.add(4));

        System.out.println("正确答案:");
        KthLargestV1 kthLargest = new KthLargestV1(3, new int[]{4, 5, 8, 2});
        System.out.println("插入3后第3大的元素:" + kthLargest.add(3));
        System.out.println("插入5后第3大的元素:" + kthLargest.add(5));
        System.out.println("插入10后第3大的元素:" + kthLargest.add(10));
        System.out.println("插入9后第3大的元素:" + kthLargest.add(9));
        System.out.println("插入4后第3大的元素:" + kthLargest.add(4));
        System.out.println("----------------");
        kthLargest = new KthLargestV1(3, new int[]{5, -1});
        System.out.println("插入2后第3大的元素:" + kthLargest.add(2));
        System.out.println("插入1后第3大的元素:" + kthLargest.add(1));
        System.out.println("插入-1后第3大的元素:" + kthLargest.add(-1));
        System.out.println("插入3后第3大的元素:" + kthLargest.add(3));
        System.out.println("插入4后第3大的元素:" + kthLargest.add(4));
    }
}
