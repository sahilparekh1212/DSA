class Solution {
    // https://leetcode.com/problems/daily-temperatures/solutions/109862/o-n-java-stack/
    // https://leetcode.com/problems/daily-temperatures/solutions/1574775/a-classic-stack-problem-detailed-explanation-picture-c-java-python-novemberchallenge/
    //
    public int[] dailyTemperatures(int[] tArr) {
        int[] ans = new int[tArr.length];
        if (tArr.length == 1) {
            return ans;
        }
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        st.push(new Pair(tArr[0], 0));
        int i = 1;
        while (i < tArr.length) {
            if (tArr[i] > st.peek().getKey()) {
                while (!st.isEmpty() && st.peek().getKey() < tArr[i]) {
                    int j = st.pop().getValue();
                    ans[j] = i - j;
                }
            }
            st.push(new Pair(tArr[i], i));
            i++;
        }
        return ans;
    }
}