class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][m - 1])
                continue;

            for (int j = 0; j < m; j++) {
                int left = 0;
                int right = matrix[i].length - 1;
                int mid;
                while (left <= right) {
                    if (target == matrix[i][j])
                        return true;

                    mid = left + (right - left) / 2;

                    if (target < matrix[i][mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return false;
    }
}
