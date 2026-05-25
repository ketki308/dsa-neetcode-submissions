class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {

        small = new PriorityQueue<>((a, b) -> b - a); // max heap

        large = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        else if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}