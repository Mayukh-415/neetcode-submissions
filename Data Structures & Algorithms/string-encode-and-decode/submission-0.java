class Solution {

    public String encode(List<String> strs) {

         StringBuilder encodedStr = new StringBuilder();

        for (String str : strs) {
            int num = str.length();

            encodedStr.append(num);
            encodedStr.append("#");
            encodedStr.append(str);
        }

        return encodedStr.toString();
    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        int i = 0;

        while(i <str.length()) {
            int slash = str.indexOf("#", i);

            int size = Integer.valueOf(str.substring(i, slash));

            i = slash + 1;

            res.add(str.substring(i, i+size));

            i+=size;
        }

        return res;
    }
}
