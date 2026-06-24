class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // int []arr = new int[10];

        // for(int i=0; i<= nums.size(); i++) {
        //     int elem = nums[i];
        //     arr[i] += 1;
        // }

        int[] ans = new int[k];

        HashMap<Integer, Integer>freqCounter = new HashMap<>();

        for (int elem : nums) {
            freqCounter.put(elem, freqCounter.getOrDefault(elem, 0)+1);
        }

        List<Integer> topElements = freqCounter.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()) // Sort by value, descending
                .limit(k)                                                        // Take the top k
                .map(Map.Entry::getKey)                                          // Extract the key
                .collect(Collectors.toList());
        int j = 0;
        for(int elem : topElements) {
            ans[j++] = elem;
        }

        return ans;

        
    }
}
