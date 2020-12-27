package com.holybell.algorithm.common.util;

import com.holybell.algorithm.common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class ListUtil {

    private ListUtil() {

    }


    /**
     * 构造一个链表，pos表示链表尾指针连接表的某个节点下标
     *
     * @param nums 链表成员值
     * @param pos  环的起点，-1表示没有环
     * @return 链表头节点
     */
    public static ListNode createCycleLinkedList(int[] nums, int pos) {
        // 缓存链表每个节点的位置信息
        Map<Integer, ListNode> nodeCache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nodeCache.put(i, new ListNode(nums[i]));
        }

        // 绑定除了最后一个节点的next指针关系
        for (int i = 0; i < nums.length - 1; i++) {
            nodeCache.get(i).next = nodeCache.get(i + 1);
        }

        // 还起点在链表长度内，将最后一个节点的next指针指向链表内部pos位置节点
        if (pos >= 0 && pos < nums.length) {
            nodeCache.get(nums.length - 1).next = nodeCache.get(pos);
        }

        return nodeCache.get(0);
    }
}
