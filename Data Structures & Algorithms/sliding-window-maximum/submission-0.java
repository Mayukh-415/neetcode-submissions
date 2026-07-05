class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<Integer>();
       int[] result = new int[nums.length - k + 1];
        int ri = 0; // result index
        for(int i = 0; i< nums.length; i++) {
           
           while(!deq.isEmpty()  && deq.peekFirst() <= i-k) {
            deq.pollFirst();
           }

           while(!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]) {
            deq.pollLast();
           }

          deq.offerLast(i);

          if( i >= k - 1) {
            result[ri++] = nums[deq.peekFirst()];
          }

        }

        return result;
    }
}
