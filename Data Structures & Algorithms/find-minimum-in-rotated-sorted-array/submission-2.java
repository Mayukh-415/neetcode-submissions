class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int left = 0;
        int right = nums.length - 1;

        if(nums[left] < nums[right]) return nums[0];

        while(left < right) {
            int mid = left + (right - left)/2;
            System.out.println(nums[mid]);
            
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[right];
    }
}
