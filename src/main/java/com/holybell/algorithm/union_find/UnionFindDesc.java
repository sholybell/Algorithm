package com.holybell.algorithm.union_find;

/**
 * 并查集类Demo
 */
public class UnionFindDesc {

    // 保存值->父值关系映射  下标为值，数组内容为父值
    private int[] roots;

    public UnionFindDesc(int n) {
        roots = new int[n];
        // 初始构造一个并查集，将每个值的父值设置为自身
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    // 寻找一个值的最终父值
    private int findRoot(int i) {
        int root = i;
        // 不断往上追溯父值
        while (root != roots[root]) {
            root = roots[root];
        }
        // 为了减少深度，将遍历过程中遇到的每个值的父值，都指向最终的父值
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    // 若两个值最终的父值相等，认为这两个值属于同一个集合
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    // 关联两个值，任选一个作为父值
    public void union(int p, int q) {
        int qroot = findRoot(q);
        int proot = findRoot(p);
        roots[proot] = qroot;
    }
}
