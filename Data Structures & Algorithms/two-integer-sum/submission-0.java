class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> occurenceCounter = new HashMap<>();
        int[] answer = new int[2];
        int index = 0;

        for(int elem : nums) {
            int remValue = target - elem;
            if(occurenceCounter.containsKey(remValue)) {
                answer[0] = occurenceCounter.get(remValue);
                answer[1] = index;
                // return [index, occurenceCounter.get(remValue)];
            }
            occurenceCounter.put(elem, index);
            index++;
        }

        return answer;
    }
}
