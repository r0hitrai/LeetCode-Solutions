/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/
public class StrStr {
    public static int strStr(String haystack, String needle) {
        /* if needle is empty, index is 0 */
        if (needle == "")
            return 0;
        /* index of first occurance */
        int index = -1;
        // index for needle
        int j = 0;
        /* search first occurence in haystack */
        for (int i = 0; i < haystack.length(); i++) {
            /* check first letter of needle in haystack */
            if (haystack.charAt(i) == needle.charAt(j)) {
                index = i;
                int k = i;
                k++;
                j++;
                /* check rest of the letters of needle in haystack */
                while (j < needle.length() && k < haystack.length()) {
                    if (haystack.charAt(k) == needle.charAt(j)) {
                        k++;
                        j++;
                    }
                    /* when next letter is not matched,
                    reset the search */
                    else {
                        index = -1;
                        j = 0;
                        break;
                    }
                }
            }
            /* stop if needle is find in haystack
            at first */
            if (index != -1)
                break;
        }
        /* if needle is not fully matched,
        return -1 */
        if (j < needle.length())
            return -1;
        return index;
    }
    public static void main(String[] args) {
        // String haystack = "hello", needle = "ll";
        // String haystack = "aaaaa", needle = "bba";
        // String haystack = "aaaaa", needle = "";
        // String haystack = "aaa", needle = "aaaa";
        String haystack = "mississippi", needle = "issip";
        System.out.println(strStr(haystack, needle));
    }
}
