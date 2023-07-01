class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        if (rowIndex == 0) {
            return prevRow;
        }
        prevRow.add(1);
        if (rowIndex == 1) {
            return prevRow;
        }
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            currRow.add(1);

            for (int j = 1; j < prevRow.size(); j++) {
                currRow.add(currRow.size() - 1, prevRow.get(j - 1) + prevRow.get(j));
            }

            prevRow = currRow;
        }
        return prevRow;
    }
}