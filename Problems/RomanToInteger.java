/*
13.
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    - I can be placed before V (5) and X (10) to make 4 and 9. 
    - X can be placed before L (50) and C (100) to make 40 and 90. 
    - C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
*/
public class RomanToInteger {
    public static int romanToInt(String s) {
        // interger form of roman
        int integer = 0;
        // for each letter in s from back
        for (int i = s.length() - 1; i >= 0; i--) {
            // switch to the case matching current letter
            switch (s.charAt(i)) {
                // if current letter is I
                case 'I':
                    // letter is 1
                    integer += 1;
                    // exit switch
                    break;
                // if current letter is V
                case 'V':
                    /* next letter from back is I, then both 
                     * letter becomes 4
                     */
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        integer += 4;
                        i--;
                    /* next letter from back is not I, then
                     * letter is 5
                     */
                    } else
                        integer += 5;
                    // exit switch
                    break;
                // if current letter is X
                case 'X':
                    /* next letter from back is I, then both 
                     * letter becomes 9
                     */
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        integer += 9;
                        i--;
                    /* next letter from back is not I, then
                     * letter is 10
                     */
                    } else
                        integer += 10;
                    // exit switch
                    break;
                // if current letter is L
                case 'L':
                    /* next letter from back is X, then both 
                     * letter becomes 40
                     */
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        integer += 40;
                        i--;
                    /* next letter from back is not X, then
                     * letter is 50
                     */
                    } else
                        integer += 50;
                    // exit switch
                    break;
                // if current letter is C
                case 'C':
                    /* next letter from back is X, then both 
                     * letter becomes 90
                     */
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        integer += 90;
                        i--;
                    /* next letter from back is not X, then
                     * letter is 100
                     */
                    } else
                        integer += 100;
                    // exit switch
                    break;
                // if current letter is D
                case 'D':
                    /* next letter from back is C, then both 
                     * letter becomes 400
                     */
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        integer += 400;
                        i--;
                    /* next letter from back is not C, then
                     * letter is 500
                     */
                    } else
                        integer += 500;
                    // exit switch
                    break;
                // if current letter is M
                case 'M':
                    /* next letter from back is C, then both 
                     * letter becomes 900
                     */
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        integer += 900;
                        i--;
                    /* next letter from back is not C, then
                     * letter is 1000
                     */
                    } else
                        integer += 1000;
                    // exit switch
                    break;
            }
        }
        return integer;
    }
    public static void main(String[] args) {
        // String s = "III";
        // String s = "LVIII";
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}