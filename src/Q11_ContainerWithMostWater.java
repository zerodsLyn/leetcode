/**
 * @author gengchao05 create on 2019/04/22
 */
public class Q11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int size = height.length;
        int maxArea = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int area = area(i, height[i], j, height[j]);
                maxArea = area > maxArea ? area : maxArea;
            }
        }

        return maxArea;
    }

    public int area(int x0, int y0, int x1, int y1) {
        int base = x0 - x1 > 0 ? x0 - x1 : x1 - x0;
        int height = y0 - y1 < 0 ? y0 : y1;
        return base * height;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Q11_ContainerWithMostWater().maxArea(heights));
    }
}
