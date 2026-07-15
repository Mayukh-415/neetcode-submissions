class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();

        int[] nge = new int[nums1.length];
        HashMap<Integer, Integer> mp = new HashMap<>();

        int idx = 0;

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                mp.put(nums2[i], -1);
            } else {
                mp.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        for(int elem : nums1) {
            nge[idx++] = mp.get(elem);
        }

        return nge;
    }

}
