class binarysearch {

    public static int Binarysearch(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + (end - start)) / 2;

            if (nums[mid] == target)
                return mid;

            else if (nums[mid] > target)
                end = mid - 1;
            else {
                start = mid + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 9;
        int num = Binarysearch(nums, target);
        System.out.println(num);
    }

}
