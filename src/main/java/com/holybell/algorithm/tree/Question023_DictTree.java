package com.holybell.algorithm.tree;

/**
 * 难度：困难
 * <p>
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple"); // 返回 true
 * trie.search("app"); // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app"); // 返回 true 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。保证所有输入均为非空字符串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class Question023_DictTree {

    static class MyTrie {

        private MyTrieNode root;

        public MyTrie() {

        }

        public void insert(String word) {

        }

        private MyTrieNode searchPrefix(String word) {
            return null;
        }

        public boolean search(String word) {
            return false;

        }

        public boolean startsWith(String prefix) {
            return false;
        }

    }

    static class MyTrieNode {

        private MyTrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public MyTrieNode() {

        }

        public boolean containsKey(char ch) {
            return false;
        }


        public MyTrieNode get(char ch) {
            return null;
        }

        public void put(char ch, MyTrieNode node) {

        }

        public void setEnd() {

        }

        public boolean isEnd() {
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


    static class Trie {
        private TrieNode root;

        /**
         * 初始化一颗字典树必然要跟着初始化一个头结点，对应可以存放26个头字母
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * 往字典树中插入单词
         *
         * @param word 单词
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                // 如果当前字典树节点不存在当前字母，填充当前字母节点
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                // 获取当前节点的下一个字母节点
                node = node.get(currentChar);
            }
            // 单词填充完毕，应该设置当前节点为某个单词的完结节点
            node.setEnd();
        }

        // search a prefix or whole key in trie and
        // returns the node where search ends
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }

    }

    static class TrieNode {

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

    public static void main(String[] args) {
        Trie trie = new Trie();

        System.out.println("字典库输入:hello world apple");
        trie.insert("apple");
        trie.insert("world");
        trie.insert("hello");
        System.out.println("字典库中是否存在apple:  " + trie.search("apple"));
        System.out.println("字典库中是否存在app:    " + trie.search("app"));
        System.out.println("字典库中是否存在hell前缀:" + trie.startsWith("hell"));

        System.out.println("------------------>");

        MyTrie myTrie = new MyTrie();
        System.out.println("字典库输入:hello world apple");
        myTrie.insert("apple");
        myTrie.insert("world");
        myTrie.insert("hello");
        System.out.println("字典库中是否存在apple:  " + myTrie.search("apple"));
        System.out.println("字典库中是否存在app:    " + myTrie.search("app"));
        System.out.println("字典库中是否存在hell前缀:" + myTrie.startsWith("hell"));
    }
}
