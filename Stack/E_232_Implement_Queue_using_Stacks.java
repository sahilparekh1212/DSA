class MyQueue {

    Stack<Integer> s;
    Stack<Integer> ref;

    public MyQueue() {
        s = new Stack<Integer>();
        ref = new Stack<Integer>();
    }

    public void push(int x) {
        ref.push(x);
        for (int i = 0; i < ref.size(); i++) {
            s.push(s.pop());
        }
        s.push(x);
    }

    public int pop() {
        return s.pop();
    }

    public int peek() {
        return s.peek();
    }

    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */