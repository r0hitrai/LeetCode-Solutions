/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
*/
public class DecodeString {
    public static String decodeString(String s) {
        // for fast modification of string
        StringBuilder input = new StringBuilder(s);
        // call decode with input string and starting index
        decode(input, 0);
        // return input as string
        return input.toString();
    }
    static void decode(StringBuilder input, int i) {
        // start of current coded string
        int begin = i;
        // start of number
        int start = i;
        // current decoded string
        StringBuilder result = new StringBuilder();
        /* if character is not a digit, skip all non-number characters till string ends or a digit is found */
        if (!input.substring(i, i+1).matches("[0-9]")) {
            while (i < input.length() && !input.substring(i, i+1).matches("[0-9]"))
                i++;
        // if character is a digit
        } else {
            /* index of [ */
            while (input.charAt(i) != '[')
                i++;
            // convert digits to number
            int num = Integer.parseInt(input.substring(start, i));
            // start of repeating string
            start = ++i;
            // repeating string
            StringBuilder string = new StringBuilder();
            /* index of ] */
            while (input.charAt(i) != ']') {
                /* if digit found, call decode for input and current index */
                if (input.substring(i, i+1).matches("[0-9]"))
                    decode(input, i);
                i++;
            }
            // got repeating string
            string.append(input.substring(start, i));
            /* append repeating stirng in result for number times */
            for (int j = 0; j < num; j++)
                result.append(string);
            // end of current coded string
            int end = i + 1;
            // replace current coded string in input by decoded string
            input.replace(begin, end, result.toString());
            i = begin + result.length();
        }
        /* if full code is not done, call decoded for input and current index */
        if (i < input.length())
            decode(input, i);
    }
    public static void main(String[] args) {
        // String s = "3[a]";
        // String s = "3[a]2[bc]";
        // String s = "2[abc]3[cd]ef";
        // String s = "2[abc]3[cd]ef4[bc]";
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
