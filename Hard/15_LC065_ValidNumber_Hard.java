class Solution {
    public boolean isNumber(String s) {

        s = s.trim();

        if (s.length() == 0) {
            return false;
        }

        boolean digit = false;
        boolean dot = false;
        boolean exp = false;
        boolean digitAfterE = true;

        int i = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);

            // Check digit
            if (Character.isDigit(ch)) {
                digit = true;

                if (exp) {
                    digitAfterE = true;
                }
            }

            // Check decimal point
            else if (ch == '.') {

                if (dot || exp) {
                    return false;
                }

                dot = true;
            }

            // Check exponent
            else if (ch == 'e' || ch == 'E') {

                if (exp || !digit) {
                    return false;
                }

                exp = true;
                digitAfterE = false;
            }

            // Check positive or negative sign
            else if (ch == '+' || ch == '-') {

                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {

                    return false;
                }
            }

            // Invalid character
            else {
                return false;
            }

            i++;
        }

        return digit && digitAfterE;
    }
}
