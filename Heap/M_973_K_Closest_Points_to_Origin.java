class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return method2(points, k);
        // return method1(points,k);
    }

    private int[][] method1(int[][] points, int k) {
        // Note order -> a, b
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        return Arrays.copyOfRange(points, 0, k);
    }

    private int[][] method2(int[][] points, int k) {
        // Note order -> b, a
        PriorityQueue<int[]> pq = new PriorityQueue<>((b, a) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        int i = 0;
        while (i < points.length) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
            i++;
        }
        int[][] ans = new int[k][2];
        int j = 0;
        while (j < k) {
            ans[j] = pq.poll();
            j++;
        }
        return ans;
    }
}