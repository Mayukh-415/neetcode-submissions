class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        char[] charArray = s.toCharArray();
        int j = 1;
        int i = 0;
        int length = 1;
        int maxLen = 1;
        mp.put(charArray[0], 0);

        while(j<charArray.length) {

            // if(charArray[i] == charArray[j]) {
            if(mp.containsKey(charArray[j])) {
               maxLen = Math.max(maxLen, length);
               
               int newIdx = mp.get(charArray[j]);
               i = Math.max(newIdx + 1, i);

               length = j - i + 1;
               mp.put(charArray[j], j);
               j++;
            } else{
                mp.put(charArray[j], j);
                j++;
                length++;
                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}