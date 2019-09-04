class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // for each element, run a bidirectional sweep of 2sum for following elements
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++; // skip duplicates when result foun
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] < sum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }
}