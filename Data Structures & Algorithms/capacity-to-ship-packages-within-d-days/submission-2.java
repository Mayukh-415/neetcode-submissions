class Solution {
    Boolean canShipAllWeight(int[] nums, int cap, int days) {
        int sum = 0;
        int dayTaken = 1;
        for(int num : nums) {
            if (num > cap) return false;
            if (sum + num > cap) {
                dayTaken++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return dayTaken <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            // System.out.println("Mid is: "+ mid);
            if (canShipAllWeight(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}