class Solution {
    public int characterReplacement(String s, int k) {
      if(s.length() == 0) return 0;

      int left=0;
      int maxFreq, maxLen = 0;
      char[] ch = s.toCharArray();
      HashMap<Character, Integer> mp = new HashMap<>();

      for(int right = 0; right<ch.length; right++) {
        mp.put(ch[right], mp.getOrDefault(ch[right], 0)+1);
        int length = right - left + 1;
        maxFreq = Collections.max(mp.values());

        if(length - maxFreq <= k) {
            maxLen = Math.max(length, maxLen);
        } else {
            mp.put(ch[left], mp.get(ch[left])-1);
            left++;
            maxFreq = Collections.max(mp.values());
        }
      }  

      return maxLen;
    }
}
