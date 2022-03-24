package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode648 {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        System.out.println(replaceWords(dictionary, "the cattle was rattled by the battery"));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trieRoot = new TrieNode();
        TrieNode cur;
        for (String root : dictionary) {
            cur = trieRoot;
            for (char c : root.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = root;
        }

        StringBuilder sb = new StringBuilder();

        for (String word : sentence.split(" ")) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            cur = trieRoot;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[c - 'a'];
            }
            sb.append(cur.word != null ? cur.word : word);
        }

        return sb.toString();
    }

    static class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
