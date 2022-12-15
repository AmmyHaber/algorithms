package com.ammyhaber.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True);
    }

    static class Trie {

        TrieNode root = new TrieNode(' ');

        public Trie() {
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode curr = root;
            for (char ch : chars) {
                TrieNode son = curr.getSon(ch);
                if (son != null) {
                    curr = son;
                } else {
                    TrieNode newSon = new TrieNode(ch);
                    curr.putSon(newSon);
                    curr = newSon;
                }
            }
            curr.end = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                TrieNode son = curr.getSon(ch);
                if (son == null) {
                    return false;
                }
                curr = son;
            }
            return curr.end;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                TrieNode son = curr.getSon(ch);
                if (son == null) {
                    return false;
                }
                curr = son;
            }
            return true;
        }

        class TrieNode{
            char c;
            boolean end = false;
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
