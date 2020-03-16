class MaxQueue {
    int[] q;
    int front = 0, rear = 0;
    int max = 0;
    public MaxQueue() {
        q = new int[10001];
    }
    
    public int max_value() {
        if(front == rear){
            return -1;
        }
        return max;
    }
    
    public void push_back(int value) {
        q[rear++] = value;
        max = max >= value ? max : value;
    }
    
    public int pop_front() {
        if(front == rear){
            return -1;
        }
        if(q[front] == max){
            max = 0;
            for(int i = front + 1;i<rear;i++){
                 max = max >= q[i] ? max : q[i];
            }
        }
        return q[front++];
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */