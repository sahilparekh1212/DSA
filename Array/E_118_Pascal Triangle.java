class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0;
        while (i < numRows) {
            ans.add(new ArrayList<>(
                    (ans.size() == 0) ? getPascalRow(new ArrayList<>()) : getPascalRow(ans.get(i - 1))));
            i++;
        }
        return ans;
    }

    private List<Integer> getPascalRow(List<Integer> input) {
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        if (input.size() == 0) {
            return newRow;
        }
        if (input.size() > 1) {
            for (int i = 1; i < input.size(); i++) {
                newRow.add(input.get(i) + input.get(i - 1));
            }
        }
        newRow.add(1);
        return newRow;
    }
}