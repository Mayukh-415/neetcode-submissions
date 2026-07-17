class Solution {
    Boolean canEatAllBananas(int[] piles, int speed, int h) {
        int hoursTaken = 0;
        for(int elem : piles) {
            hoursTaken += Math.ceil((double)elem/speed);
        }

        return hoursTaken <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int elem : piles) {
            right = Math.max(right, elem);
        }

        while(left < right) {
            int mid = left + (right - left)/2;

            if(canEatAllBananas(piles, mid, h)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
