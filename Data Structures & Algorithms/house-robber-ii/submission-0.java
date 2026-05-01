class Solution {
    public int rob(int[] nums) {
                int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] firstHouse = new int[n];
        for (int i = 0; i < n - 1; i++) firstHouse[i] = nums[i];


        int[] secondHouse = new int[n];
        for (int i = 1; i < n; i++) secondHouse[i] = nums[i];


        System.out.println(Arrays.toString(firstHouse));
        System.out.println(Arrays.toString(secondHouse));

        int firstHousePrev1 = 0;
        int firstHousePrev2 = 0;

        int secondHousePrev1 = 0;
        int secondHousePrev2 = 0;

        for (int i = 0; i < n; i++) {
            int firstHouseCurrentMax = Math.max(firstHouse[i] + firstHousePrev2, firstHousePrev1);
            firstHousePrev2 = firstHousePrev1;
            firstHousePrev1 = firstHouseCurrentMax;

            int secondHouseCurrentMax = Math.max(secondHouse[i] + secondHousePrev2, secondHousePrev1);
            secondHousePrev2 = secondHousePrev1;
            secondHousePrev1 = secondHouseCurrentMax;
        }
        
        return Math.max(firstHousePrev1, secondHousePrev1);
    }
}
