/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
*/
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        // length of array
        int len = nums.length;
        // rotated array
        int[] rotate = new int[len];
        for (int i = 0; i < len; i++)
            rotate[i] = nums[i];
        // for each item
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % len] = rotate[i];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        // int[] nums = {-1,-100,3,99};
        // int k = 2;
        rotate(nums, k);
        for (int item : nums)
            System.out.print(item + ", ");
        System.out.println();
    }
}