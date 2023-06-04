class KVPair {
    Integer key;
    Integer val;

    KVPair(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }

    public Integer getKey() {
        return this.key;
    }

    public Integer getValue() {
        return this.val;
    }
}

class StockSpanner {
    Stack<KVPair> st;

    public StockSpanner() {
        st = new Stack();
    }

    public int next(int price) {
        if (st.isEmpty()) {
            st.push(new KVPair(price, 1));
            return 1;
        } else {
            int tempCount = 0;
            if (st.peek().getKey() <= price) {
                while (!st.isEmpty() && st.peek().getKey() <= price) {
                    tempCount += st.peek().getValue();
                    st.pop();
                }
            }
            st.push(new KVPair(price, 1 + tempCount));
            return st.peek().getValue();
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */