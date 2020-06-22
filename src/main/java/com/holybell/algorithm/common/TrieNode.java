package com.holybell.algorithm.common;

class TrieNode {

    // 每一个字典树节点都连接着26个字母节点
    private TrieNode[] links = new TrieNode[26];
    // 表示是否存在某个单词到这个位置结束，否则即使存在这个节点，也仅仅表示有个单词前缀包含到这个节点
    private boolean isEnd;

    public TrieNode() {

    }

    /**
     * 判断当前字典树节点是否包含当前字母
     *
     * @param ch 字典树字母
     */
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    /**
     * 获取当前节点的的字母节点成员
     *
     * @param ch 字母
     */
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    /**
     * 为当前字典树节点添加某个字母节点
     *
     * @param ch   字母
     * @param node 新的字典树节点
     */
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}