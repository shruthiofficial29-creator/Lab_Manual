public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] coordinates1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        boolean result1 = solution.checkStraightLine(coordinates1);
        System.out.println("Test Case 1 Output: " + result1);
       
    }
}
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
