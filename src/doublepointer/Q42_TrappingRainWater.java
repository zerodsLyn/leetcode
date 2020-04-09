package doublepointer;

/**
 * @author zerods
 * @version 1.0 2020/4/4
 */
public class Q42_TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = findLeftMaxHeight(i, height);
            int rightMaxHeight = findRightMaxHeight(i, height);
            result += Math.min(leftMax, rightMaxHeight) - height[i];
        }

        return result;
    }

    private int findLeftMaxHeight(int cur, int[] height) {
        int leftMax = -1;
        for (int i = 0; i <= cur; i++) {
            leftMax = Math.max(leftMax, height[i]);
        }
        return leftMax;
    }

    private int findRightMaxHeight(int cur, int[] height) {
        int rightMax = -1;
        for (int i = cur; i < height.length; i++) {
            rightMax = Math.max(rightMax, height[i]);
        }
        return rightMax;
    }

    public static void main(String[] args) {
        System.out.println(new Q42_TrappingRainWater().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new Q42_TrappingRainWater().trap(new int[] {2,0,2}));
        System.out.println(new Q42_TrappingRainWater().trap(new int[] {5,4,1,2}));
    }
}
