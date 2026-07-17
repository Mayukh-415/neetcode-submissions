class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        if (nums[left] < nums[right])
            return nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(nums[mid]);
            if (nums[mid] <= nums[(mid + n - 1) % n] && nums[mid] <= nums[(mid + 1) % n]) {
                return nums[mid];
            } else if (nums[mid] > nums[right]) {
                left = mid + 1; // Minimum must be in the right un-sorted half
            } else {
                right = mid - 1; // Minimum must be in the left half
            }
        }

        return ans;
    }
}
