class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>(); // Map<Sum of AB, frequency>
        for (int a : A) {
            for (int b : B) {
                int s = a + b;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        int result = 0;
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(0-c-d)) {
                    result += map.get(0-c-d);
                }
            }
        }
        return result;
    }
}