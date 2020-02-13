    /*
     *You are given an n x n 2D matrix representing an image.
     *
     *Rotate the image by 90 degrees (clockwise).
     *
     *Follow up:
     *Could you do this in-place?
     * int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
     */
package ArraysAndString;

public class RotateImage {
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        for (int start = 0; start < n / 2; start++) {
            int end = n - start - 1;
            for (int j = start; j < end; j++) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end - j + start][start];
                matrix[end - j + start][start] = matrix[end][end - j + start];
                matrix[end][end - j + start] = matrix[j][end];
                matrix[j][end] = temp;
            }
        }
    }
}

    class Solution2 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2 + n % 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int[] tmp = new int[4];
                    int row = i;
                    int col = j;
                    for (int k = 0; k < 4; k++) {
                        tmp[k] = matrix[row][col];
                        int x = row;
                        row = col;
                        col = n - 1 - x;
                    }
                    for (int k = 0; k < 4; k++) {
                        matrix[row][col] = tmp[(k + 3) % 4];
                        int x = row;
                        row = col;
                        col = n - 1 - x;
                    }
                }
            }
        }
    }

    class Solution3 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < (n + 1) / 2; i ++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                    matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                    matrix[j][n - 1 - i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }
    }