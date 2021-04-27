package com.syou.leetcode.leetcode149;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Solution {
    public int maxPoints(int[][] points) {
        // 寻找最多有几个点共线
        // 数学题，两条线共线必然满足一下条件：
        // 1.斜率相同
        // 2.在y轴上的截距相同
        // 用个hashmap来记录满足以上两点构成线的数量
        int result = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<List<DD>, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                DD rate;
                DD distance;
                // 考虑垂直于x轴的线
                if (points[j][0] - points[i][0] == 0) {
                    rate = new DD(1, Integer.MAX_VALUE);
                    // x轴截距
                    distance = new DD(points[i][0], 1);
                } else {
                    // 计算斜率
                    rate = new DD(points[j][0] - points[i][0], points[j][1] - points[i][1]);
                    // 计算截距
                    distance = new DD(rate.getA(), points[j][1] * rate.getA() - points[j][0] * rate.getB());
                }
                List<DD> list = new ArrayList<>();
                list.add(rate);
                list.add(distance);
                if (map.containsKey(list)) {
                    map.put(list, map.get(list) + 1);
                    System.out.println(list + ":" + map.get(list));
                } else {
                    map.put(list, 1);
                    System.out.println(list + ":" + 1);
                }
            }
            for (Integer integer : map.values()) {
                result = Math.max(result, integer);
            }
        }
        return result + 1;
    }

    class DD {
        private int a;
        private int b;
        public DD(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DD dd = (DD) o;
            return a*dd.b == b * dd.a;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return "DD{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
