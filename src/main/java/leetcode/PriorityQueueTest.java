package leetcode;

import pojo.Customer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueTest {
    private static PriorityQueue<Integer> maxHeap, minHeap;

    public static void main(String[] args) {

        //优先队列自然排序示例
        Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(7);
        Random rand = new Random();
        for(int i=0;i<7;i++){
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Processing Integer:"+in);
        }

        //优先队列使用示例

        Comparator<Integer> revCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return right.compareTo(left);
            }
        };

// Or you can use Collections‘ reverseOrder method as follows.
// Comparator<Integer> revCmp = Collections.reverseOrder();

        maxHeap = new PriorityQueue<Integer>(20, revCmp);
        minHeap = new PriorityQueue<Integer>(20);

        addNumber(6);
        addNumber(4);
        addNumber(3);
        addNumber(10);
        addNumber(12);
        System.out.println(minHeap);
        System.out.println(maxHeap);
        System.out.println(getMedian());

        addNumber(5);
        System.out.println(minHeap);
        System.out.println(maxHeap);
        System.out.println(getMedian());

        addNumber(7);
        addNumber(8);
        System.out.println(minHeap);
        System.out.println(maxHeap);
        System.out.println(getMedian());

    }

    /*
     * Note: it maintains a condition that maxHeap.size() >= minHeap.size()
     */
    public static void addNumber(int value) {
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && value > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(value);
            } else {
                maxHeap.offer(value);
            }
        } else {
            if (value < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(value);
            } else {
                minHeap.offer(value);
            }
        }
    }

    /*
     * If maxHeap and minHeap are of different sizes,
     * then maxHeap must have one extra element.
     */
    public static double getMedian() {
        if (maxHeap.isEmpty()) {
            return -1;
        }

        if (maxHeap.size() == minHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        } else {
            return maxHeap.peek();
        }
    }


}

