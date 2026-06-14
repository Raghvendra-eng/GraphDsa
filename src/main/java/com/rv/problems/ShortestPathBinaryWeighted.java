package com.rv.problems;

import java.util.*;

public class ShortestPathBinaryWeighted {

    public class Neighbour {
        private Integer id;
        private Integer weight;

        Neighbour(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            Neighbour n = (Neighbour) obj;
            return this.id == n.id && this.weight == n.weight;
        }
    }

    public int[] shortestPath(int source, int[][]edges) {
        Map<Integer, List<Neighbour>> graph = getGraph(edges);
        Map<Integer, Integer> ans = new HashMap<>();
        ans.put(source, 0);
        PriorityQueue<Neighbour> pq = new PriorityQueue<>((a, b) -> a.weight.compareTo(b.weight));
        pq.add(new Neighbour(source, 0));

        while(!pq.isEmpty()) {
            Neighbour curr = pq.poll();
            for (Neighbour neighbour: graph.get(curr.id)) {
                if (!ans.containsKey(neighbour.id)) {
                    pq.add(new Neighbour(neighbour.id, ans.get(curr.id) + neighbour.weight));
                    ans.put(neighbour.id, ans.get(curr.id) + neighbour.weight);
                } else {
                    int weight = ans.get(curr.id);
                    if (weight > (ans.get(curr.id) + neighbour.weight)) {
                        pq.remove(new Neighbour(neighbour.id, ans.get(curr.id) + neighbour.weight));
                        pq.add(new Neighbour(neighbour.id, ans.get(curr.id) + neighbour.weight));
                        ans.put(neighbour.id, ans.get(curr.id) + neighbour.weight);
                    }
                }
            }
        }
        int []answer = new int[ans.size()];
        for (Integer key: ans.keySet()) {
            answer[key] = ans.get(key);
        }
        return answer;
    }

    private Map<Integer, List<Neighbour>> getGraph(int[][] edges) {
        Map<Integer, List<Neighbour>> graph = new HashMap<>();

        for (int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<Neighbour>());
            graph.putIfAbsent(edge[1], new ArrayList<Neighbour>());
            graph.get(edge[0]).add(new Neighbour(edge[1], edge[2]));
            graph.get(edge[1]).add(new Neighbour(edge[0], edge[2]));
        }
        return graph;
    }

    private List<String> shortestTransformationSequence(String begin, String end, String[] wordList) {
        if (begin.length() != end.length())
            return new ArrayList<String>();

        Map<String, List<String>> graph = createGraph(wordList);

        Map<String, String> prev = new HashMap<>();

        bfs(graph, begin, end, prev);

        List<String> ans = new ArrayList<>();
        ans.add(end);
        String curr = end;
        while(curr != begin) {
            curr = prev.get(curr);
            ans.add(curr);
        }
        return ans;
    }

    private void bfs(Map<String, List<String>> graph, String begin, String end, Map<String, String> prev) {
        Set<String> visited = new HashSet<>();
        Queue<String> q= new ArrayDeque<>();
        visited.add(begin);
        q.add(begin);
        prev.put(begin, "");

        while (!q.isEmpty()) {
            String curr = q.poll();

            for (String neighbour: graph.get(curr)) {
                if (!visited.contains(neighbour)) {
                    prev.put(neighbour, curr);
                    q.add(neighbour);
                    visited.add(neighbour);
                    if (neighbour.equals(end)) {
                        return;
                    }
                }
            }
        }
    }

    private Map<String, List<String>> createGraph(String[] wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int start = 0; start < wordList.length; start++) {
            for (int curr = start + 1; curr < wordList.length; curr++) {
                if (isRelated(wordList[start], wordList[curr])) {
                    graph.putIfAbsent(wordList[start], new ArrayList<>());
                    graph.putIfAbsent(wordList[curr], new ArrayList<>());
                    graph.get(wordList[start]).add(wordList[curr]);
                    graph.get(wordList[curr]).add(wordList[start]);
                }
            }
        }
        return graph;
    }

    private boolean isRelated(String s, String s1) {
        if (s.length() != s1.length()) return false;

        int diff = 0;

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) != s1.charAt(index)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }
        return true;
    }

}
