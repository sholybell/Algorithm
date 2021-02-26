package com.holybell.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 难度：简单
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <p>
 * <p>
 * 示例：
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top();  返回 2
 * myStack.pop();  返回 2
 * myStack.empty();  返回 False
 * <p>
 * <p>
 * 提示：
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 * <p>
 * <p>
 * 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？
 * 换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的时间。你可以使用两个以上的队列。
 * <p>
 * Related Topics 栈 设计
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class LeetCode225_MockStack {

    static class MyStack {


        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {

        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return -1;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return -1;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return false;
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
     * 两个队列
     */
    static class StackV1 {

        Deque<Integer> q1;
        Deque<Integer> q2;

        /**
         * Initialize your data structure here.
         */
        public StackV1() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q1.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {

            // 将q1中的数据转移到q2中，直到最后一个再弹出
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }

            int result = q1.poll();

            // 将q2的数据转移回q1
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            return result;
        }

        /**
         * Get the top element.
         */
        public int top() {
            // 将q1中的数据转移到q2中，直到最后一个再弹出
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }

            int result = q1.poll();

            // 将q2的数据转移回q1
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            q1.offer(result);
            return result;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    /**
     * 一个队列
     */
    static class StackV2 {

        Deque<Integer> dq;

        /**
         * Initialize your data structure here.
         */
        public StackV2() {
            dq = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            // 每一次添加元素，将除了队尾的元素依次出队列，再入队列
            int n = dq.size();
            dq.offer(x);
            for (int i = 0; i < n; i++) {
                dq.offer(dq.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return dq.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return dq.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return dq.isEmpty();
        }
    }

    public static void main(String[] args) {

        System.out.println("你的答案:");
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("top查看栈顶元素:" + myStack.top());
        System.out.println("pop弹出栈顶元素:" + myStack.pop());
        System.out.println("栈是否为空:" + myStack.empty());

        System.out.println("----------------------------->");

        System.out.println("正确答案:");
        StackV1 stack = new StackV1();
        stack.push(1);
        stack.push(2);
        System.out.println("top查看栈顶元素:" + stack.top());
        System.out.println("pop弹出栈顶元素:" + stack.pop());
        System.out.println("栈是否为空:" + stack.empty());
    }
}
