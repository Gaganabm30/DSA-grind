class Solution {
    public String rearrangeString(String s, char x, char y) {

        StringBuilder yPart = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder xPart = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == y) {
                yPart.append(ch);
            } else if (ch == x) {
                xPart.append(ch);
            } else {
                middle.append(ch);
            }
        }

        return yPart.toString() + middle.toString() + xPart.toString();
    }
}