class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        System.out.println(list);
        Collections.sort(list);
    }
    
    public double findMedian() {
        if (list.size() % 2 == 0) {
            double firstMiddleNumber = list.get((list.size() / 2) - 1);
            double secondMiddleNumber = list.get((list.size() / 2));
            System.out.println(list);
            return (firstMiddleNumber + secondMiddleNumber) / 2;
        }
        System.out.println(list);
        return list.get((list.size() / 2));
    }
}
