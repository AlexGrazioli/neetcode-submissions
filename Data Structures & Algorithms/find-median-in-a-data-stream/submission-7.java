class MedianFinder {
    PriorityQueue<Integer> upper;
    PriorityQueue<Integer> lower;

    public MedianFinder() {
        this.upper = new PriorityQueue<>();
        this.lower = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        lower.offer(num);                    // always add to lower first
        upper.offer(lower.poll());           // move lower's max to upper (enforce ordering)
    
        if (upper.size() > lower.size() + 1) {
            lower.offer(upper.poll());       // rebalance if upper gets too big
        }
    }   

    public double findMedian() {
        if ((lower.size() + upper.size()) % 2 == 0) {
            return (double) (lower.peek() + upper.peek()) / 2;
        }
        return Objects.requireNonNull(upper.peek());
    }
}
