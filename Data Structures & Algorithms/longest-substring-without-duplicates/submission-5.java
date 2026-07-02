class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        HashMap<Character, Integer> mp = new HashMap<>();
        char[] charArray = s.toCharArray();
        
        int i = 0;
        int maxLen = 0;
        
        for (int j = 0; j < charArray.length; j++) {
            if (mp.containsKey(charArray[j])) {
                int previousIndex = mp.get(charArray[j]);
                i = Math.max(previousIndex + 1, i);
            }
            
            mp.put(charArray[j], j);
            
            maxLen = Math.max(maxLen, j - i + 1);
        }
        
        return maxLen;
    }
}
