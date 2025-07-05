package dailyLeetcodeProblems;

public class container_with_most_water_11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0, left = 0 , right = length-1;
        while(left < right){
            int currentArea = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(maxArea,currentArea);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
