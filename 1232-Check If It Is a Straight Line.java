class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int dx = coordinates[1][0] - x0;
        int dy = coordinates[1][1] - y0;

        for (int i = 2; i < coordinates.length; i++) {
            if (dy * (coordinates[i][0] - x0) != dx * (coordinates[i][1] - y0)) {
                return false;
            }
        }
        return true;
    }
}
