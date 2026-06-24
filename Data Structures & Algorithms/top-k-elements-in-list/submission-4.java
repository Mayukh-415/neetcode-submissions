class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];

        HashMap<Integer, Integer>freqCounter = new HashMap<>();

        for (int elem : nums) {
            freqCounter.put(elem, freqCounter.getOrDefault(elem, 0)+1);
        }

        // List<Integer> topElements = freqCounter.entrySet().stream()
        //         .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()) // Sort by value, descending
        //         .limit(k)                                                        // Take the top k
        //         .map(Map.Entry::getKey)                                          // Extract the key
        //         .collect(Collectors.toList());
        // int j = 0;
        // for(int elem : topElements) {
        //     ans[j++] = elem;
        // }
// ---------- Min Heap----------------------------------------
        // PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());

        // for(Map.Entry<Integer, Integer> entry : freqCounter.entrySet()) {
        //     minHeap.add(entry);
        //     if(minHeap.size() > k) {
        //         minHeap.poll();
        //     }
        // }

        // while(!minHeap.isEmpty()) {
        //     ans[j++] = minHeap.poll().getKey();
        // }
//----------- Bucket Sort--------------------------------------
        List<Integer>[] bucketSort = new List[nums.length + 1];
        int index = 0;
        for(Integer num: freqCounter.keySet()) {
            int freq = freqCounter.get(num);

            if(bucketSort[freq] == null ){
                bucketSort[freq] = new ArrayList<>();
            }
            bucketSort[freq].add(num);
        }

        for(int i = bucketSort.length-1; i>=0 && index < k; i--) {
            if(bucketSort[i] != null) {
                for(Integer value : bucketSort[i]) {
                    ans[index]= value;
                    index++;
                    if(index==k) break;
                }
            }
        }

        return ans;

        
    }
}
