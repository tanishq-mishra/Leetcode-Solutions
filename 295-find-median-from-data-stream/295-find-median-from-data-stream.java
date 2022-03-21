class MedianFinder {
    double median;
    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;
    public MedianFinder() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if(leftHalf.size() > 0 && num > leftHalf.peek()) {
            rightHalf.add(num);
        } else {
            leftHalf.add(num);
        }
        
        int sizeCompare = leftHalf.size() - rightHalf.size();
        
        if(sizeCompare == 0) {
            median = ((double)leftHalf.peek() + (double)rightHalf.peek())/2.0d;
        } else if(sizeCompare == -1) {
            median = rightHalf.peek();
        } else if(sizeCompare == 1) {
            median = leftHalf.peek();
        } else if( sizeCompare < -1) {
            int extraElement = rightHalf.poll();
            leftHalf.add(extraElement);
            median = ((double)leftHalf.peek() + (double)rightHalf.peek())/2.0d;
        } else {
            int extraElement = leftHalf.poll();
            rightHalf.add(extraElement);
            median = ((double)leftHalf.peek() + (double)rightHalf.peek())/2.0d;
        }
        
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */