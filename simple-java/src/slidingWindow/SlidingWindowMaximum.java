package slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] numbers, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int n = numbers.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            while (!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                result[index++] = numbers[deque.peek()];
            }
        }

        return result;

    }
}
