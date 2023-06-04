/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

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

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */