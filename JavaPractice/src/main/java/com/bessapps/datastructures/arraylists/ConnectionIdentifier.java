package com.bessapps.datastructures.arraylists;

import java.util.*;

public class ConnectionIdentifier {

    public static void main(String args[]) {
        List<int[]> connections = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5});

        int x = findInfluencer(connections);
        System.out.println(x);
    }

    public static int findInfluencer(List<int[]> connections) {

        connections.forEach((x) -> {
            System.out.println(Arrays.toString(x));
        });
        
        Map<Integer, Set<Integer>> connectionMap = new HashMap<>();

        for(int[] arr : connections) {
            Set<Integer> temp1 = connectionMap.getOrDefault(arr[0], new HashSet<>());
            Set<Integer> temp2 = connectionMap.getOrDefault(arr[1], new HashSet<>());
            temp1.add(arr[1]);
            temp2.add(arr[0]);

            boolean status = connectionMap.containsKey(arr[1]);
            if(status) {
                Set<Integer> temp = connectionMap.getOrDefault(arr[1], new HashSet<>());
                if(temp.size() != 0) {
                    temp1.addAll(temp);
                }
            }
            connectionMap.put(arr[0], temp1);
            connectionMap.put(arr[1], temp2);
        }

        int leastConnector = Integer.MAX_VALUE;
        int maxSize = 0;
        for(Map.Entry<Integer, Set<Integer>> entry: connectionMap.entrySet()) {
            if(maxSize < entry.getValue().size()) {
                maxSize = entry.getValue().size();

                if(leastConnector > entry.getKey()) {
                    leastConnector = entry.getKey();
                }
            }
        }
        System.out.println(connectionMap.toString());
        //System.out.println(connectionMap.get(leastConnector).toString());
        return leastConnector;

    }

    public static int findInfluencer1(List<int[]> connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // Step 1: Build undirected graph
        for (int[] edge : connections) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        int bestNode = Integer.MAX_VALUE;
        int maxConnections = -1;

        // Step 2: For each node, use BFS up to depth 2 to collect connections
        for (int node : graph.keySet()) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> depthMap = new HashMap<>();

            queue.offer(node);
            depthMap.put(node, 0);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                int depth = depthMap.get(current);

                if (depth >= 2) continue;

                for (int neighbor : graph.getOrDefault(current, new HashSet<>())) {
                    if (!depthMap.containsKey(neighbor)) {
                        depthMap.put(neighbor, depth + 1);
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            int totalConnections = visited.size(); // exclude self

            if (totalConnections > maxConnections ||
                    (totalConnections == maxConnections && node < bestNode)) {
                maxConnections = totalConnections;
                bestNode = node;
            }
        }

        return bestNode;
    }

}
