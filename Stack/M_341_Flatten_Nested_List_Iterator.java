public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> st;

    public NestedIterator(List<NestedInteger> input) {
        st = new Stack<>();
        helper(input);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!st.isEmpty() && !st.peek().isInteger()) {
            List<NestedInteger> list = new ArrayList<>();
            list = st.pop().getList();
            helper(list);
        }
        return !st.isEmpty();
    }

    private void helper(List<NestedInteger> input) {
        for (int i = input.size() - 1; i > -1; i--) {
            st.push(input.get(i));
        }
    }
}