package Laicode.Class06_Heap_BFS;

import java.util.*;

/**
 * Description 
 * Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order. 
 * Assumptions 
 * A is not null 
 * K is >= 0 and smaller than or equal to size of A
 * 
 * Return 
 * an array with size K containing the K smallest numbers in ascending order
 * 
 * Examples 
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */

public class KSmallestInUnsortedArray {
    // Method1: k sized max-heap
    // Time = O(nlogk) -> O(k + (n-k)logk) when use heapify()
    // Space = O(k)
    public int[] kSmallestI(int[] array, int k) {
        // handle all possible corner cases at the very beginning
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                //offer the first k elements into max-heap.
                //NOTICE: if you want to use heapify(), the only thing you can do is to call
                //a certain constructor of PriorityQueue.
                maxHeap.offer(array[i]);
            } else if (maxHeap.peek() > array[i]) {
                //for the other elements, only offer it into the max-heap
                //if it is smaller than the max value of the max-heap
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    // Method2: k sized min-heap
    // Time = O(n + klogn)
    // Space = O(n)
    public int[] kSmallestII(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[k];
        List<Integer> list = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        //Use heapify
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(list);
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    // Method3: quick select
    // Time = O(n + n/2 + n/4 + ... + 1) = O(n), worst case = O(n + n-1 + n-2 + ... + 1) = O(n^2)
    // Space = O(logn), worst case = O(n)
    public int[] kSmallestIII(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        quickSelect(array, 0, array.length - 1, k - 1);
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    private void quickSelect(int[] array, int left, int right, int target) {
        int midIdx = partition(array, left, right);
        if (midIdx == target) {
            return;
        } else if (target < midIdx) {
            quickSelect(array, left, midIdx - 1, target);
        } else {
            quickSelect(array, midIdx + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;
        int j = right - 1;

        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else if (array[j] >= pivot) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}