class Solution {
    public int subarraySum(int[] nums, int k) {
        // for every x, check subarray starting with x
        // O(n^2)
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = nums[i];
            if (sum == k) count++;
            
            int j  = i + 1;
            while (j < nums.length) {
                sum += nums[j];
                if (sum == k) count ++;
            }
        }
        return count;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        //Sliding window -- NO, contains negative number
        // hashmap + preSum  
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.  
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
        int result = 0;
        int sum = 0; // current sum
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) { // means exist sum[i, j]
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return result;
    }
}


