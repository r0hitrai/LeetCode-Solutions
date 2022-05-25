/*
Given two binary strings a and b, return their sum as a binary string.
*/
public class AddBinary {
    public static String addBinary(String a, String b) {
        // array of sum
        char[] result;
        // bit generating from adding two 1's
        char parity = '0';
        /* result length is 1 more than max
        of a and b */
        if (a.length() > b.length())
            result = new char[a.length() + 1];
        else
            result = new char[b.length() + 1];
        /* indices for a, b and result from back*/
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = result.length - 1;
        // for all item in smaller of a and b
        while (i > -1 && j > -1) {
            // if parity is 0
            if (parity == '0') {
                /* if any of a or b is 0,
                result is other item, parity is 0 */
                if (a.charAt(i) == '0')
                    result[k] = b.charAt(j);
                else if (b.charAt(j) == '0')
                    result[k] = a.charAt(i);
                    /* if both a and b are 1,
                    result is 0, parity is 1 */
                else if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                    result[k] = '0';
                    parity = '1';
                }
            } else {
                /* if both a and b are 0,
                result is 1, parity is 0 */
                if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                    result[k] = '1';
                    parity = '0';
                /* if both a and b are 1,
                result is 1, parity is 1 */
                } else if (a.charAt(i) == '1' && b.charAt(j) == '1')
                    result[k] = '1';
                /* if a and b are not same,
                result is 0, parity is 1 */
                else
                    result[k] = '0';
            }
            /* next item from back */
            i--;
            j--;
            k--;
        }
        /* for remaining items in a */
        while (i > -1) {
            /* if parity is 0, insert a in result */
            if (parity == '0')
                result[k] = a.charAt(i);
            /* if parity is 1, add a in result */
            else {
                if (a.charAt(i) == '0') {
                    result[k] = '1';
                    parity = '0';
                } else {
                    result[k] = '0';
                    parity = '1';
                }
            }
            i--;
            k--;
        }
        /* for remaining items in b */
        while (j > -1) {
            /* if parity is 0, insert b in result */
            if (parity == '0')
                result[k] = b.charAt(j);
            /* if parity is 1, add b in result */
            else {
                if (b.charAt(j) == '0') {
                    result[k] = '1';
                    parity = '0';
                } else {
                    result[k] = '0';
                    parity = '1';
                }
            }
            j--;
            k--;
        }
        // binary sum of a and b
        String sum;
        /* if parity travelles till end,
        insert 1 in front of result */
        if (parity == '1') {
            result[0] = '1';
            sum = new String(result);
        /* if no parity at the end,
        insert 0 in front of result */
        } else {
            result[0] = '0';
            // discard leading 0
            sum = new String(result, 1, result.length - 1);
        }
        return sum;
    }
    public static void main(String[] args) {
        // String a = "11", b = "1";
        // String a = "1010", b = "1011";
        // String a = "0", b = "0";
        // String a = "1", b = "0";
        String a = "1", b = "111";
        String result = addBinary(a, b);
        System.out.println(result);
    }
}