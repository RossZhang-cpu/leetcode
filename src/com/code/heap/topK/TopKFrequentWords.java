package com.code.heap.topK;

import java.util.*;

public class TopKFrequentWords {



    public List<String> topKFrequent(String[] words, int k) {
        TreeSet<WordFrequent> set = new TreeSet<>(((o1, o2) -> {
            int res = o2.frequent - o1.frequent;
            return res == 0 ? o1.word.compareTo(o2.word) : res;
        }));

        Map<String, WordFrequent> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                WordFrequent wordFrequent = map.get(word);
                set.remove(wordFrequent);
                ++wordFrequent.frequent; //

                set.add(wordFrequent);

            } else {
                WordFrequent wordFrequent = new WordFrequent(word, 1);
                map.put(word,wordFrequent);
                set.add(wordFrequent);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (WordFrequent key : set) {
            if (k <= 0) break;
            res.add(key.word);
            --k;
        }

        return res;

    }

    public static class WordFrequent{
        private final String word;
        private int frequent;

        public WordFrequent(String word, int frequent) {
            this.word = word;
            this.frequent = frequent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WordFrequent that = (WordFrequent) o;
            return Objects.equals(word, that.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

    }

    public static void main(String[] args) {
        WordFrequent wordFrequent = new WordFrequent("1", 1);
        ++wordFrequent.frequent;
        System.out.println(wordFrequent.frequent);
        wordFrequent.frequent = wordFrequent.frequent + 1;
        System.out.println(wordFrequent.frequent);
    }
}
