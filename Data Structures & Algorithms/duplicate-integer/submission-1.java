class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int elem : nums) {
            if(hashSet.contains(elem)) {
                return true;
            }

            hashSet.add(elem);
        }

        return false;
    }
}