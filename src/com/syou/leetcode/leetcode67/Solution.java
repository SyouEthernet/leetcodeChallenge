package com.syou.leetcode.leetcode67;

class Solution {
    public String addBinary(String a, String b) {
        // 比较简单，解法也比较多，可以考虑把string转成int，计算以后再转回去，但是这样可能超过上限
        // 也可以考虑直接在string上进行计算
        int aLength = a.length();
        int bLength = b.length();
        int maxLength = Math.max(aLength,bLength);

        //将a,b转化为char数组
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        // 定义一个进位变量
        boolean addOne = false;

        // 定义一个用于生成结果的stringbuilder
        StringBuilder builder = new StringBuilder();

        // 模拟加法运算，从字符串尾部向前运算
        for (int i = maxLength - 1; i >= 0 ; i--) {
            // 拿到两个char
            char aBit = aChar.length - maxLength + i >= 0 ? aChar[aChar.length - maxLength + i] : '0';
            char bBit = bChar.length - maxLength + i >= 0 ? bChar[bChar.length - maxLength + i] : '0';

            // 两char运算
            char resBit = '0';
            if (aBit != bBit) {
                resBit = '1';
                // 查看是否有上个进位
                if (addOne) {
                    resBit = '0';
                    addOne = true;
                }
            } else {
                resBit = '0';
                // 查看是否有上个进位
                if (addOne) {
                    resBit = '1';
                    addOne = false;
                }

                // 本轮进位
                if (aBit == '1') {
                    addOne = true;
                }
            }

            // 放在字符串最前面
            builder.insert(0, resBit);
        }

        // 遍历完成后， 判断一下还有没有进位
        if (addOne) {
            builder.insert(0, '1');
        }
        return builder.toString();
    }
}
