import java.util.*;

class sts {

    // Simple Seive
    public static ArrayList<Integer> SOE(int n) {

        boolean arr[] = new boolean[n + 1];
        Arrays.fill(arr, true);
        ArrayList<Integer> list = new ArrayList<>();

        arr[0] = false;
        arr[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    arr[j] = false;

                }
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count++;
                list.add(i);
            }

        }
        System.out.println(count);

        return list;

    }

    // Segented Seive

    public static int SegmentedSeive(int low, int high) {

        boolean arr[] = new boolean[high - low + 1];
        Arrays.fill(arr, true);

        for (int p = 2; p <= Math.sqrt(high); p++) {
            int start = Math.max(p * p, (low + p - 1) / p * p);
            for (int j = start; j <= high; j = j + p) {
                arr[j - low] = false;
            }
        }
        int count = 0;
        for (boolean ans : arr) {
            if (ans) {
                count++;
            }
        }
        return count;

    }

    // Eular Totient Function

    public static int EularTotient(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (gcd(i, n) == 1) {
                count++;

            }
        }
        return count;

    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Strobogrammatic Number

    public static boolean StroboGrammatic(int number) {

        String num = Integer.toString(number);

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {

            char l = num.charAt(left);
            char r = num.charAt(right);

            if (!((l == '0' && r == '0') ||
                    (l == '1' && r == '1') ||
                    (l == '8' && r == '8') ||
                    (l == '6' && r == '9') ||
                    (l == '9' && r == '6'))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Binary Polindrome
    public static boolean BinaryPolindrome(int number) {

        String num = Integer.toBinaryString(number);

        for (int i = 0; i < num.length(); i++) {
            char l = num.charAt(i);
            char r = num.charAt(num.length() - 1 - i);

            if (l != r) {
                return false;

            }
        }

        return true;
    }

    // Toggle Doors

    public static void ToggleDoors(int n) {

        boolean arr[] = new boolean[n + 1];
        int c = 0;
        int o = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) {
                if (arr[j]) {
                    arr[j] = false;
                } else {
                    arr[j] = true;
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i]) {
                o++;
            } else {
                c++;
            }
        }

        System.out.println(o);
        System.out.println(c);

    }

    // Chinese Remainder Therom
    public static int CRT(int[] a, int[] m) {
        int k = a.length;
        int x = 1, j;
        while (true) {
            for (j = 0; j < k; j++) {
                if (x % m[j] != a[j]) {
                    break;
                }
            }
            if (j == k) {
                return x;
            }
            x++;
        }

    }

    // Alice Apple Tree

    public static int AppleAliceTree(int apple) {
        int sum = 0, cnt = 0;
        while (sum < apple) {
            cnt++;
            sum += 12 * cnt * cnt;
        }
        return (cnt);
    }

    public static int Chinese(int a[], int m[]) {

        int x = 1;
        int i;
        int k = a.length;

        while (true) {
            for (i = 0; i < k; i++) {
                if (x % m[i] != a[i]) {
                    break;
                }
            }

            if (i == k) {
                return x;
            }
            x++;

        }

    }

    public static int AliceApple(int n) {
        int level = 0;
        int sum = 0;

        while (sum < n) {
            level++;
            sum += 12 * level * level;
        }

        return level;

    }

    public static int BiaryPolindrome(int n) {
        int max = Integer.MIN_VALUE;

        for (int i = n; i >= 0; i--) {
            String num = Integer.toBinaryString(i);

            if (IsBinaryPolindrome(num)) {
                int number = Integer.parseInt(num, 2);
                if (number > max) {
                    max = number;
                }
            }
        }
        return max;

    }

    public static boolean IsBinaryPolindrome(String num) {
        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static int NearestRoundoff(int num) {

        if (num > 10) {

            int rem = num % 10;
            num = num / 10;

            if (rem <= 5) {
                num = num * 10;
            } else {
                num = num * 10;
                num = num + 10;
            }

        }

        return num;

    }

    public static List<Integer> Leaders(int nums[]) {

        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        int lead = nums[n - 1];
        list.add(lead);
        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] > lead) {
                list.add(nums[i]);
                lead = nums[i];

            }

        }

        return list;
    }

    public static int MooresVoting(int[] nums) {
        int candidate = -1;
        int count = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;

            count = (candidate == num) ? count++ : count--;
        }

        return candidate;
    }

    public static int MAjorityElementmap(int nums[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static List<Integer> HighestHourGlass(int nums[][]) {

        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 0; j < nums[0].length - 2; j++) {
                sum = Math.max(sum, nums[i][j] + nums[i][j + 1] + nums[i][j + 2] + nums[i + 1][j + 1] + nums[i + 2][j]
                        + nums[i + 2][j + 1] + nums[i + 2][j + 2]);

                list.add(sum);

            }
        }
        return list;
    }

    public static int MaxOnes(int nums[], int k) {

        // Binary NUmber

        int max = 0;
        int nor = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                nor++;
            }

            while (nor > k) {
                if (nums[start] == 0) {
                    nor--;
                }
                start++;
            }

            max = Math.max(max, end - start + 1);

        }
        return max;
    }

    public static int[] blockSwap(int nums[], int k) {

        int n = nums.length;
        k = k % n;

        Swap(nums, 0, n - 1);
        Swap(nums, 0, k - 1);
        Swap(nums, k, n - 1);

        return nums;

    }

    public static void Swap(int nums[], int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {

        // Simple Seive
        // int n = 100;
        // System.out.println(SOE(n));

        // Segmented Seive
        // System.out.println(SegmentedSeive(10, 20));

        // Eular Totient
        // System.out.println(EularTotient(53));

        // Strobogrammatic
        // System.out.println(StroboGrammatic(96));

        // BinaryPolindrome
        // int number = 14;
        // System.out.println(BinaryPolindrome(number));

        // ToggleDoors
        // ToggleDoors(100);

        // Chinese Remainder Therom
        // int a[] = { 1, 4, 6 };
        // int m[] = { 3, 5, 7 };
        // System.out.println(CRT(a, m));

        // Alice Apple Tree
        // System.out.println(AppleAliceTree(60));

        // int a[] = { 1, 4, 6 };
        // int m[] = { 3, 5, 7 };
        // System.out.println(Chinese(a, m));

        // System.out.println(AliceApple(60));

        // Scanner in = new Scanner(System.in);

        // int n = in.nextInt();

        // boolean arr[] = new boolean[n + 1];

        // for (int i = 1; i <= n; i++) {
        // for (int j = i; j <= n; j = j + i) {
        // arr[j] = !arr[j];
        // }
        // }

        // int open = 0;
        // for (boolean ans : arr) {
        // if (ans) {
        // open++;
        // }
        // }

        // System.out.println(open);

        // int n = 175;

        // while (n >= 10) {
        // int sum = 0;
        // while (n > 0) {
        // int rem = n % 10;
        // sum = sum + rem;
        // n = n / 10;
        // }
        // n = sum;

        // }

        // String name = "Space";
        // System.out.println(name.toLowerCase());
        // System.out.println(name.toUpperCase());

        // System.out.println(BiaryPolindrome(89));

        // System.out.println(NearestRoundoff(35));

        // int nums[] = { 2, 1, 9, 8, 5, 7, 4 };
        // List<Integer> ans = Leaders(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 1, 1, 2, 1, 5, 1 };
        // int ans = MooresVoting(nums);
        // System.out.println("Winner : " + ans);

        // int nums[] = { 1, 2, 1, 1, 2, 1, 5, 1, 2, 2, 2, 2 };
        // System.out.println(nums.length);
        // int ans = MAjorityElementmap(nums);
        // System.out.println(ans);

        // int num[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };
        // List<Integer> ans = HighestHourGlass(num);
        // System.out.println(ans);

        // int nums[] = { 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1 };
        // int ans = MaxOnes(nums, 2);
        // System.out.println(ans);

        // System.out.println(1010 & 1);

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        // int k = 4;
        // int ans[] = blockSwap(nums, k);
        // System.out.println(Arrays.toString(ans));

    }

}
