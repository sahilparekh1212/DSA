class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<Integer>();
    }

    public void push(int x) {
        // x is last in queue
        q.add(x);
        // everyone except x will get popped as range is from 1
        for (int i = 1; i < q.size(); i++) {
            // q.remove first item in queue
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}