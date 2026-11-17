package com.rv.agoda;

import java.util.*;

public class TopKFrequentElement {

//    Top K Frequent Elements
//    Return the k most frequently occurring elements.
    public List<Integer> solve(int []nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));

        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
            pq.add(Arrays.asList(e.getKey(), e.getValue()));
            if(pq.size() > k) {
                pq.remove();
            }
        }
        for (List<Integer> list: pq) {
            ans.add(list.get(0));
        }
        return ans;
    }

}
