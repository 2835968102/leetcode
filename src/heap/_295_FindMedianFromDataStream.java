package heap;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * https://leetcode.cn/problems/find-median-from-data-stream/
 *
 * 1) maxHeap 保存较小的一半（大顶堆）
 * 2) minHeap 保存较大的一半（小顶堆）
 * 3) 插入后平衡两个堆的数量差 <= 1
 */
public class _295_FindMedianFromDataStream {

    private PriorityQueue<Integer> maxHeap; // 大顶堆
    private PriorityQueue<Integer> minHeap; // 小顶堆

    public _295_FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // 大顶堆
        minHeap = new PriorityQueue<>(); // 小顶堆
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // 平衡两个堆
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
