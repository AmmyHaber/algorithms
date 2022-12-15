package com.ammyhaber.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode820 {

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(minimumLengthEncoding(new String[]{"t"}));
        System.out.println(minimumLengthEncoding(new String[]{"time","atime","btime"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Trie.TrieNode root = trie.root;
        if (root.sonMap == null) {
            return 0;
        }
        return count(root, 0);
    }

    private static int count(Trie.TrieNode trie, int count) {
        count++;
        Map<Character, Trie.TrieNode> sonMap = trie.sonMap;
        if (sonMap == null) {
            return count;
        }
        int v = 0;
        for (Trie.TrieNode trieNode : sonMap.values()) {
            v += count(trieNode, count);
        }
        return v;
    }

    static class Trie {

        TrieNode root = new TrieNode(' ');

        public Trie() {
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode curr = root;

            char ch;
            for (int i = chars.length - 1; i >= 0; i--) {
                ch = chars[i];
                TrieNode son = curr.getSon(ch);
                if (son != null) {
                    curr = son;
                } else {
                    TrieNode newSon = new TrieNode(ch);
                    curr.putSon(newSon);
                    curr = newSon;
                }
            }
        }

        class TrieNode {
            char c;
            Map<Character, TrieNode> sonMap;

            TrieNode(char c) {
                this.c = c;
            }

            void putSon(TrieNode son) {
                if (son == null || son == root) {
                    return;
                }
                if (sonMap == null) {
                    sonMap = new HashMap<>(4);
                }
                sonMap.put(son.c, son);
            }

            TrieNode getSon(Character c) {
                if (sonMap == null || c == null) {
                    return null;
                }
                return sonMap.get(c);
            }
        }
    }
}
