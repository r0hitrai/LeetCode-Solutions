/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
*/
public class ReverseWordsString {
    public static String reverseWords(String s) {
        // reverse string
        String result = "";
        // splitting string based on space
        String[] words = s.split(" ");
        // faster to append string
        StringBuilder temp = new StringBuilder();
        // for each item in words
        for (int i = words.length - 1; i > -1; i--) {
            /* skip space */
            if (words[i] == "")
                continue;
            // add item in result
            temp.append(words[i] + " ");
        }
        // convert to string
        result = temp.toString();
        return result.trim();
    }
    public static void main(String[] args) {
        // String s = "the sky is blue";
        String s = "  hello world  ";
        // String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
