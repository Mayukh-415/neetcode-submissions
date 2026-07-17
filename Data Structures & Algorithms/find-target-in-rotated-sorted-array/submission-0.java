class Solution {

    int bnSearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left)/2;

            if(nums[mid] == target)return mid;
            else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left  = 0;
        int right = n - 1;


        while(left < right) {
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid+1;
            } else {
                right = mid;
            }
        }

        int leftHalf = bnSearch(nums, 0, right-1, target);
        int rightHalf = bnSearch(nums, right, n-1, target);

        return leftHalf > rightHalf ? leftHalf : rightHalf;
    }
}
