class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int newLeft = left;
        right = nums.length - 1;

        while (newLeft <= right) {
            int mid = (newLeft + right) / 2;

            if (nums[mid] < target) {
                newLeft = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                result = mid;
                break;
            }
        }

        right = left;
        newLeft = 0;
        while (newLeft <= right) {
            int mid = (newLeft + right) / 2;

            if (nums[mid] < target) {
                newLeft = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                result = mid;
                break;
            }
        }
        
        return result;
    }
}
