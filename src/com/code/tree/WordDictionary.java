package com.code.tree;

public class WordDictionary {

    private Tier tier;

    public WordDictionary() {
        tier = new Tier();

    }

    public void addWord(String word) {
        tier.insert(word);

    }

    public boolean search(String word) {
        return tier.dfs(0, word, this.tier);
    }


    public static class Tier {
        private Tier[] children;
        private boolean isEnd;

        public Tier() {
            children = new Tier[26];
            isEnd = false;
        }


        public void insert(String word) {
            Tier node = this;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new Tier();
                }
                node = node.children[index];
            }

            node.isEnd = true;
        }

        public boolean dfs(int i, String word, Tier node) {
            if (i >= word.length()) {
                return node.isEnd;
            }
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                int index =  ch - 'a';
                if (node.children[index] != null && dfs(++i, word, node.children[index])) {  //matched
                    return true;
                } else {
                    return false;
                }
            } else {
                //is '.'
                Tier temp;
                for (int j = 0; j < 26; ++j) {
                    temp = node.children[j];
                    if (temp != null && dfs(++i, word, temp)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");



        wordDictionary.search("pad");
        wordDictionary.search("bad");
        wordDictionary.search(".ad");
        wordDictionary.search("b..");



    }
}


