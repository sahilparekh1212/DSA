class Solution {
    public int numIslands(char[][] grid) {
        int totalIslandsFound = 0;
        int gridHeight = grid.length;
        int gridWidth = grid[0].length;
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == '1') {
                    markIslandArea(grid, i, j, gridHeight, gridWidth);
                    totalIslandsFound++;
                }
            }
        }
        return totalIslandsFound;
    }

    private void markIslandArea(char[][] grid, int i, int j, int gridWidth, int gridHeight) {
        // check index in bound
        if (i < 0 || j < 0 || i >= gridWidth || j >= gridHeight) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            // right
            markIslandArea(grid, i + 1, j, gridWidth, gridHeight);
            // left
            markIslandArea(grid, i - 1, j, gridWidth, gridHeight);
            // up
            markIslandArea(grid, i, j - 1, gridWidth, gridHeight);
            // down
            markIslandArea(grid, i, j + 1, gridWidth, gridHeight);
        }
    }
}