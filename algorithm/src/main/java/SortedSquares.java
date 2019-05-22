public class SortedSquares {

    public static void main(String[] args) {
//        sortedSquares()
    }

    public static int[] sortedSquares(int[] A) {
        int[] tmp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            tmp[i] = A[i] * A[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            for (int j = i + 1; j < tmp.length; j++) {
                if (tmp[i] > tmp[j]) {
                    int t = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = t;
                }
            }
        }
        return tmp;
    }


}
