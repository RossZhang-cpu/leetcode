package com.code.tree;

import java.util.HashMap;

class Trie {

    private Trie[] childern;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        childern = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i =0; i < word.length(); ++i){
            int num = word.charAt(i) - 'a';
            if(node.childern[num] == null){
                node.childern[num] = new Trie();
            }
            node = node.childern[num];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String prefix){
        Trie node = this;
        for(int i = 0; i < prefix.length(); ++i){
            int num = prefix.charAt(i) - 'a';
            if (node.childern[num] == null){
                return null;
            }else {
                node = node.childern[num];
            }
        }
        return node;
    }
}