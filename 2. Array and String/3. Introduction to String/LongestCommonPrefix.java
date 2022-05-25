/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
*/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // longest common prefix
        String result = "";
        /* if only 1 string, it is the result */
        if (strs.length == 1)
            return strs[0];
        // for every character in first string
        for (int i = 0; i < strs[0].length(); i++) {
            // check if characters are equals
            boolean isEqual = false;
            /* checking equality of character in every string */
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && strs[0].charAt(i) == strs[j].charAt(i))
                    isEqual = true;
                else {
                    isEqual = false;
                    break;
                }
            }
            /* if equal in every string, insert in result */
            if (isEqual)
                result += strs[0].charAt(i);
            else
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        // String[] strs = {"flower", "flow", "flight"};
        // String[] strs = {"dog", "racecar", "car"};
        // String[] strs = {"ab", "a"};
        String[] strs = {"abab", "aba", ""};
        System.out.println(longestCommonPrefix(strs));
    }
}
