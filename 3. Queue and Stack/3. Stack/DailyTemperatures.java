/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
*/
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        // stack for lastest ith answer
        Stack<Integer> stack = new Stack<>();
        // for each item in temperatures from back
        for (int i = temperatures.length - 1; i > -1; i--) {
            // while stack is not empty
            while (stack.empty() == false) {
                /* if next temperature is small or equal,
                add its answer in current answer */
                if (temperatures[stack.peek()] <= temperatures[i])
                    answer[i] += answer[stack.pop()];
                /* else, increase current answer by one
                and stop */
                else {
                    answer[i] += 1;
                    break;
                }
            }
            /* if stack gets empty,
            answer is 0 */
            if (stack.empty())
                answer[i] =  0;
            // insert current temperature index in stack
            stack.push(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        // int[] temperatures = {73,74,75,71,69,72,76,73};
        // int[] temperatures = {30,40,50,60};
        // int[] temperatures = {30,60,90};
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        int[] answer = dailyTemperatures(temperatures);
        for (int item : answer)
            System.out.print(item + ", ");
        System.out.println();
    }
}
