package list;

public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaByDoublePoint(height));
    }

    /**
     * 自己解法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1 ; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmp = (j - i) * Math.min(height[i] , height[j]);
                max = Math.max(tmp, max);
            }
        }
        return max;
    }

    /**
     * 双指针解法
     * @param height
     * @return
     */
    public static int maxAreaByDoublePoint(int[] height) {
        int max = 0, i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

}
