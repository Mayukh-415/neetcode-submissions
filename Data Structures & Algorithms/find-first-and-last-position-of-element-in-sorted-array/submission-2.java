class Solution {
    int findFirstOccurence(int[] nums, int target) {
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left<=right) {
            int mid = left + (right - left)/2;

            if(target == nums[mid]) {
                ans = mid;
                right = mid - 1;
            }

            else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    int findLastOccurence(int[] nums, int target) {
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left<=right) {
            int mid = left + (right - left)/2;

            if(target == nums[mid]) {
                ans = mid;
                left = mid + 1;
            }

            else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        
        Boolean flag = false;
        int left = 0;
        int right = nums.length - 1;
        // int[] ans =  new int[2];

        if(nums.length == 0) return new int[]{-1, -1};

        while (left<=right) {
            int mid = left + (right - left)/2;

            if(target == nums[mid]) {
                flag = true;
                break;
            }

            if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(!flag) return new int[]{-1, -1};

        int i =   findFirstOccurence(nums, target);

        int j = findLastOccurence(nums, target);
        
        return new int[]{i, j};

    }
}