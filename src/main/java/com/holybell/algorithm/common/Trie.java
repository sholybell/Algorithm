package com.holybell.algorithm.common;

public class Trie {

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

