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
        wordDict.sort((w1, w2) -> w2.length() - w1.length());
        return dfs(s, wordDict, 0);
    }

    private static boolean dfs(String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            return true;
        }
        if (index > s.length()) {
            return false;
        }
        for (String word : wordDict) {
            int up = index + word.length();
            if (up > s.length()) {
                continue;
            }
            if (word.equals(s.substring(index, up))) {
                boolean b = dfs(s, wordDict, up);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }
}
