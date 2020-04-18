/**
 * @author gengchao05 create on 2019/04/22
 */
public class Q11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (i > 0 && height[i] <= height[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Q11_ContainerWithMostWater().maxArea(heights));
    }
}
