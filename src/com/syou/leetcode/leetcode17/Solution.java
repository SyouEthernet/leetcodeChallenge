package com.syou.leetcode.leetcode17;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        // 考虑使用队列解决
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        HashMap<Character, List<Character>> map = new HashMap<>();

        List<Character> list2 = new ArrayList<>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        List<Character> list3 = new ArrayList<>();
        list3.add('d');
        list3.add('e');
        list3.add('f');
        List<Character> list4 = new ArrayList<>();
        list4.add('g');
        list4.add('h');
        list4.add('i');
        List<Character> list5 = new ArrayList<>();
        list5.add('j');
        list5.add('k');
        list5.add('l');
        List<Character> list6 = new ArrayList<>();
        list6.add('m');
        list6.add('n');
        list6.add('o');
        List<Character> list7 = new ArrayList<>();
        list7.add('p');
        list7.add('q');
        list7.add('r');
        list7.add('s');
        List<Character> list8 = new ArrayList<>();
        list8.add('t');
        list8.add('u');
        list8.add('v');
        List<Character> list9 = new ArrayList<>();
        list9.add('w');
        list9.add('x');
        list9.add('y');
        list9.add('z');

        map.put('2', list2);
        map.put('3', list3);
        map.put('4', list4);
        map.put('5', list5);
        map.put('6', list6);
        map.put('7', list7);
        map.put('8', list8);
        map.put('9', list9);

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            if (queue.isEmpty()) {
                for (Character word :
                        map.get(digits.charAt(i))) {
                    queue.offer(String.valueOf(word));
                }
                continue;
            }
            do {
                String str = queue.poll();
                for (Character word :
                        map.get(digits.charAt(i))) {
                    String newString = str + word;
                    queue.offer(newString);
                }
            } while(queue.peek().length() <= i);
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}
