package doublepointer;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author zerods
 * @version 1.0 2020/4/18
 */
public class Q11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxArea = 0;
        while (l < r) {
            int curArea = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, curArea);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
