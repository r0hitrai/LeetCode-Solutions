/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/
public class ReverseWordsString3 {
    public static String reverseWords(String s) {
        // reversed characters
        String result;
        // split s based on space
        String[] words = s.split(" ");
        // for faster append
        StringBuilder temp = new StringBuilder();
        // for each word
        for (String word : words) {
            // for faster reverse
            StringBuilder item = new StringBuilder(word);
            // append reversed word and space
            temp.append(item.reverse() + " ");
        }
        // convert to string
        result = temp.toString();
        // return removing trail spaces
        return result.trim();
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        // String s = "God Ding";
        System.out.println(reverseWords(s));
    }
}
