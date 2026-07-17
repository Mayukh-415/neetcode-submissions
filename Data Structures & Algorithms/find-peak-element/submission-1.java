class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        if (n == 1) return 0;

        while(left <= right) {
            int mid = left + (right -left) / 2;
            if(mid > 0 && mid < n - 1) {
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
                else if (nums[mid + 1] > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            else if (mid == 0) {
                if(nums[mid] > nums[mid+1]) return mid;
                else return mid + 1;
            }
            else if(mid == n-1) {
                if(nums[mid] > nums[mid - 1]) return mid;
                else return mid - 1;
            }
        }

        return 0;
    }
}