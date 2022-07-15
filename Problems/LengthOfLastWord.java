/*
58.
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
*/
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // end index of last word starts from back of string
        int end = s.length() - 1;
        /* skip all spaces form back */
        while (s.charAt(end) == ' ')
            end--;
        // start index of last word starts from end index
        int start = end;
        /* skip all letters from back */
        while (start >= 0 && s.charAt(start) != ' ')
            start--;
        // difference of start and end index is length
        return end - start;
    }
    public static void main(String[] args) {
        // String s = "Hello World";
        // String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
    }
}
