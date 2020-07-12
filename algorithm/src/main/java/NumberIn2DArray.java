public class NumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {-5}
        };
        System.out.println(findNumberIn2DArray(matrix, -5));
    }

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int i = matrix.length - 1; i >= 0; i-- ) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > target) {
                    break;
                }
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
