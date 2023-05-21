class MinStack {
    int minSoFar = Integer.MAX_VALUE;
    Stack<Integer> st;

    // note that this MinStack does not keep entries sorted. It is called MinStack
    // as it can peek min entry in O(1). So the top function returns the last entry
    // just like any regular stack.
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        // here '=' in 'if' block and st.push(minSoFar) are used to keep track of
        // duplicates
        if (val <= minSoFar) {
            st.push(minSoFar);
            minSoFar = val;
        }
        st.push(val);
    }

    public void pop() {
        if (st.pop() == minSoFar) {
            minSoFar = st.pop();
        }
        ;
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSoFar;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */