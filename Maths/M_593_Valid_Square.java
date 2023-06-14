class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        TreeSet<Integer> ts1 = new TreeSet<>();
        ts1.add(getDistanceSquare(p1, p2));
        ts1.add(getDistanceSquare(p1, p3));
        ts1.add(getDistanceSquare(p1, p4));
        ts1.add(getDistanceSquare(p2, p3));
        ts1.add(getDistanceSquare(p2, p4));
        ts1.add(getDistanceSquare(p3, p4));

        boolean isASquare = false;

        if (!ts1.contains(Integer.valueOf(0)) && ts1.size() == 2) {
            int i = 0;
            int diff = 0;
            // y = sqrt(2)*x
            // (y^2)=2*(x^2)
            for (int d : ts1) {
                if (i == 0) {
                    diff += 2 * d;
                } else {
                    diff -= d;
                }
                i++;
            }
            isASquare = diff == 0;
        }

        return isASquare;

    }

    public int getDistanceSquare(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return (x * x + y * y);
    }
}