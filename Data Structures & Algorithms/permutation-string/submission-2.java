class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq_s1 = new int[26];
        int[] freq_s2 = new int[26];

        for(int ch : s1.toCharArray()) {
            freq_s1[ch - 'a']++;
        }

        int i = 0, j = 0;
        while(j<s2.length()) {
            char[] temp_arr = s2.toCharArray();

            if(j-i+1 > s1.length()) {
                freq_s2[temp_arr[i] - 'a']--;
                i++;
            } else {
                System.out.println(" i and j " + i+" "+j);
                freq_s2[temp_arr[j] - 'a']++;
                System.out.println();
                if(Arrays.equals(freq_s1, freq_s2)) return true;
                j++;
            }

        }
        return false;
    }
}
