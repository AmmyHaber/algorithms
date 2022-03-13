package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode139 {

    public static void main(String[] args) {
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak("catsandog", wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] b = new boolean[s.length() + 1];
        b[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!b[i]) {
                continue;
            }
            for (String word : wordDict) {
                if ((i + word.length()) < b.length && s.startsWith(word, i)) {
                    b[i + word.length()] = true;
                }
            }
        }
        return b[s.length()];
   }

}
