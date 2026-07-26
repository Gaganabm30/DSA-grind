class Solution {

    public int minimumGroups(String[] words) {
        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                if ((i & 1) == 0) {
                    even.append(word.charAt(i));
                } else {
                    odd.append(word.charAt(i));
                }
            }

            String evenKey = getMinRotation(even.toString());
            String oddKey = getMinRotation(odd.toString());

            set.add(evenKey + "#" + oddKey);
        }

        return set.size();
    }

    private String getMinRotation(String s) {
        int n = s.length();

        if (n <= 1) {
            return s;
        }

        String t = s + s;

        int i = 0;
        int j = 1;
        int k = 0;

        while (i < n && j < n && k < n) {

            char a = t.charAt(i + k);
            char b = t.charAt(j + k);

            if (a == b) {
                k++;
                continue;
            }

            if (a > b) {
                i = i + k + 1;
            } else {
                j = j + k + 1;
            }

            if (i == j) {
                j++;
            }

            k = 0;
        }

        int start = Math.min(i, j);

        return t.substring(start, start + n);
    }
}