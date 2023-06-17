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