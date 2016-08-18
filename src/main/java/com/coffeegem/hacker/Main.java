package com.coffeegem.hacker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {5,3,5,2,3,2};
        int n = numbers.length;
        int m = 3;

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer,Integer> uniques = new HashMap<>(m);
        int max = 0;

        for (int i=0; i<n; i++) {
            int num = numbers[i];
            deque.add(num);
            int val = uniques.getOrDefault(num,0) + 1;
            uniques.put(num,val);
            if (deque.size() == m) {
                int tmp = uniques.size();
                if (tmp > max) max = tmp;
                Integer key = deque.pop();
                // decrement the val & remove if necessary
                val = uniques.get(key) - 1;
                if (val <= 0) {
                    uniques.remove(key);
                } else {
                    uniques.put(key,val);
                }
            }
        }
    }
}
