package com.syou.leetcode.leetcode30;

import java.util.*;

public class Solution {
    Set<String> set = new HashSet<>();
    public List<Integer> findSubstring(String s, String[] words) {
        // 从字符串开始不断去掉一个字符，拿到每个子串然后进行判断
        // 但是这样做有个问题，那就是如果words的重复内容非常多的话，就会影响执行效率导致超时
        // 可以考虑优化一下，由于words中所有到长度都相等
        // 那么我们可以找到words中字符组成等总长度为 wordLen * words.length
        // 就是说我们遍历字符串拿子串，只要遍历到s.length() - wordLen * words.length即可
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        String source = s;
        for (int i = 0; i < s.length() - wordLen * words.length + 1; i++) {
            List<String> wordList = new ArrayList<>(Arrays.asList(words));
            if (isStartWith(source, wordList)) {
                result.add(i);
            }
            source = source.substring(1);
        }
        return result;
    }

    private boolean isStartWith(String s, List<String> wordList) {
        if (wordList.isEmpty()) {
            return true;
        }
        System.out.println(s);
        System.out.println(wordList);
        for (String word : wordList) {
            if (s.startsWith(word)) {
                wordList.remove(word);
                return isStartWith(s.substring(word.length()), wordList);
            }
        }
        return false;
    }
}
