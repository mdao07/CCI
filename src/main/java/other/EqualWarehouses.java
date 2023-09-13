package other;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class EqualWarehouses {

    static class EqualWarehousesCost {
        Map<Integer, Integer> leftMap, rightMap;

        EqualWarehousesCost(int [] arr1, int [] arr2) {
            leftMap = getMap(arr1);
            rightMap = getMap(arr2);
        }

        private Map<Integer, Integer> getMap(int [] arr) {
            return Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum, HashMap::new));
        }

        private boolean isEqualityPossible() {
            var allItems = new HashSet<>(leftMap.keySet());
            allItems.addAll(rightMap.keySet());

            return allItems.stream().allMatch(k -> {
               int count1 = leftMap.getOrDefault(k, 0);
               int count2 = rightMap.getOrDefault(k, 0);

               return (count1 + count2) % 2 == 0;
            });
        }

        private void processMaps() {
            var commonItems = new HashSet<>(leftMap.keySet());
            commonItems.retainAll(rightMap.keySet());

            commonItems.stream().forEach(k -> {
                int a = leftMap.remove(k);
                int b = rightMap.remove(k);

                if (a > b) {
                    leftMap.put(k, (a - b) / 2);
                } else if (a < b) {
                    rightMap.put(k, (b - a) / 2);
                }
            });

            leftMap.keySet().stream().filter(k -> !commonItems.contains(k)).forEach(k -> leftMap.put(k, leftMap.get(k) / 2));
            rightMap.keySet().stream().filter(k -> !commonItems.contains(k)).forEach(k -> rightMap.put(k, rightMap.get(k) / 2));
        }

        private int getMaxKey(Map<Integer, Integer> map) {
            return map.keySet().stream().max(Comparator.comparingInt(a -> a)).get();
        }

        private Stack<Entry<Integer, Integer>> getStack(Map<Integer, Integer> map, Comparator<Entry<Integer, Integer>> cmp) {
            return map.entrySet().stream().sorted(cmp).collect(Collectors.toCollection(Stack::new));
        }

        private Stack<Entry<Integer, Integer>>[] getStacks() {
            int leftMax = getMaxKey(leftMap);
            int rightMax = getMaxKey(rightMap);

            Comparator<Entry<Integer, Integer>> comparator = Comparator.comparingInt(e -> e.getKey());
            Stack<Entry<Integer, Integer>> st1, st2;

            if (leftMax > rightMax) {
                st1 = getStack(leftMap, comparator);
                st2 = getStack(rightMap, comparator.reversed());
            } else {
                st1 = getStack(leftMap, comparator.reversed());
                st2 = getStack(rightMap, comparator);
            }

            return (Stack<Entry<Integer, Integer>>[])new Stack[]{st1, st2};
        }

        /*
        private int processBothStacks(Stack<Entry<Integer, Integer>> st1, Stack<Entry<Integer, Integer>> st2) {

        }
        */

        private int processStack(Stack<Entry<Integer, Integer>> st) {
            return st.stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
        }

        private int calculateWithMap(Map<Integer, Integer> map) {
            return map.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
        }

        private int calculateMinCost() {
            if (leftMap.isEmpty()) {
                return rightMap.isEmpty() ? 0 : calculateWithMap(rightMap);
            } else if (rightMap.isEmpty()) {
                return calculateWithMap(leftMap);
            }

            var stacks = getStacks();
            var st1 = stacks[0];
            var st2 = stacks[1];

            //System.out.println(st1);
            //System.out.println(st2);

            int cost = 0;
            int v1, v2, min;
            Entry<Integer, Integer> e1, e2;
            e1 = st1.pop();
            e2 = st2.pop();

            while (!st1.isEmpty() && !st2.isEmpty()) {
                v1 = e1.getValue();
                v2 = e2.getValue();
                min = Math.min(e1.getKey(), e2.getKey());

                if (v1 > v2) {
                    e1.setValue(v1 - v2);
                    e2 = st2.pop();
                    v1 = v2;
                } else if (v2 > v1) {
                    e2.setValue(v2 - v1);
                    e1 = st1.pop();
                } else {
                    e1 = st1.pop();
                    e2 = st2.pop();
                }

                cost += v1 * min;
            }

            if (st1.isEmpty()) {
                st1 = st2;
            }

            v1 = e1.getValue();
            v2 = e2.getValue();

            if (v1 > v2) {
                e1.setValue(v1 - v2);
                st1.push(e1);
                v1 = v2;
            } else if (v2 > v1) {
                e2.setValue(v2 - v1);
                st1.push(e2);
            }

            cost += v1 * Math.min(e1.getKey(), e2.getKey());

            return cost + processStack(st1);
        }

        public int getMinCost() {
            if (!isEqualityPossible()) {
                return -1;
            }

            processMaps();
            return calculateMinCost();
        }
    }

    public static int minCostToEquality(int [] arr1, int [] arr2) {
        if (arr1 == null && arr2 == null) {
            return -1;
        }

        var equalityChecker = new EqualWarehousesCost(arr1, arr2);
        return equalityChecker.getMinCost();
    }

    public static void main(String[] args) {
        int [] arr1 = {1, 1, 1, 2, 3, 3};
        int [] arr2 = {1, 2, 2, 2, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7};

        int cost = minCostToEquality(arr1, arr2);

        System.out.println(cost);
    }
}
