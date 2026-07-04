class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] ch1 = s1.toCharArray();

        Arrays.sort(ch1);
        String sorted_string = new String(ch1);

        System.out.println("Original String" + sorted_string);

        int i = 0;
        int j = ch1.length;

        while (j <= s2.length()) {
            String temp = s2.substring(i, j);
            char[] temp_str = temp.toCharArray();
            Arrays.sort(temp_str);
            String sorted_temp_str = new String(temp_str);

            System.out.println("temp Str " + sorted_temp_str + " for i and j " + i +" "+j);

            if (sorted_string.equals(sorted_temp_str))
                return true;
            i++;
            j++;
        }

        return false;
    }
}
