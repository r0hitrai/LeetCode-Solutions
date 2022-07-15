/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

    - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
    - int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
*/
import java.util.PriorityQueue;

public class KthLargestElementInStream {
    // to store data in ascending order
    PriorityQueue<Integer> data;
    // number of lasrget num
    int k;

    /* Initializes the object with the integer k and the stream of integers nums. */
    public KthLargestElementInStream(int k, int[] nums) {
        // initialize data
        data = new PriorityQueue<>();
        // initialize k
        this.k = k;
        /* insert each item from nums in data */
        for (int item : nums)
            data.offer(item);
        }
    /* Appends the integer val to the stream and returns the element representing the kth largest element in the stream. */
    public int add(int val) {
        // insert val in data
        data.offer(val);
        /* remove items till only k items remains */
        while (data.size() != k)
          data.poll();
        // return kth largest item
        return data.peek();
    }
    
    public static void main(String[] args) {
        int k = 2;
        int[] nums = {4,5,8,2};
        KthLargestElementInStream kthLargest = new KthLargestElementInStream(k, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}