class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length  == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        // Set<Integer> set = new HashSet<>();
        // {0, 1, 1, 2, 3, 4, 5, 6}
       
        for(int i=1;i<nums.length; i++) {
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1]+1) {
                count++;
            }else {
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
        }

        return maxCount = Math.max(count, maxCount);
    }
}
