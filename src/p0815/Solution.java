package p0815;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> siteBusMap = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> busList = siteBusMap.getOrDefault(routes[i][j], new ArrayList<Integer>());
                busList.add(i);
                siteBusMap.put(routes[i][j], busList);
            }
        }

        int[][] grid = new int[routes.length][routes.length];
        for (int i = 0; i < routes.length; i++) {
            Arrays.fill(grid[i], -1);
        }
        Map<Integer, Set<Integer>> busMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> busSet = busMap.getOrDefault(i, new HashSet<Integer>());
            for (int j = 0; j < routes[i].length; j++) {
                for (int bus : siteBusMap.getOrDefault(routes[i][j], new ArrayList<Integer>())) {
                    busSet.add(bus);
                }
            }
            busMap.put(i, busSet);
        }

        List<Integer> sourceBus = siteBusMap.getOrDefault(source, new ArrayList<Integer>());
        for (int bus : sourceBus) {
            calcMinBus(grid, bus, busMap);
        }

        int ans = -1;
        for (int s : siteBusMap.getOrDefault(source, new ArrayList<Integer>())) {
            for (int t : siteBusMap.getOrDefault(target, new ArrayList<Integer>())) {
                if (grid[s][t] != -1) {
                    if (ans == -1 || ans > grid[s][t]) {
                        ans = grid[s][t];
                    }
                }
            }
        }

        return ans == -1 ? -1 : ans + 1;
    }

    private void calcMinBus(int[][] grid, int bus, Map<Integer, Set<Integer>> busMap) {
        boolean[] color = new boolean[grid.length];

        List<Integer> targets = new ArrayList<>();
        targets.add(bus);
        grid[bus][bus] = 0;
        color[bus] = true;
        for (int i = 0; i < targets.size(); i++) {
            Set<Integer> nexts = busMap.get(targets.get(i));
            for (int next : nexts) {
                if (!color[next]) {
                    grid[bus][next] = grid[bus][targets.get(i)] + 1;
                    targets.add(next);
                    color[next] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] routes = { {7,12},{4,5,15},{6},{15,19},{9,12,13} };
        int res = s.numBusesToDestination(routes, 15, 12);
        System.out.println(res);
    }
}
