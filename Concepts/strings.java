import java.util.*;

public class strings {

    public static boolean anagrams(String s, String t) {

        int n = s.length();
        int m = t.length();

        if (m != n)
            return false;

        int arr[] = new int[26];

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            arr[t.charAt(i) - 'a']--;
        }

        for (int num : arr) {
            if (num != 0)
                return false;
        }
        return true;
    }

    public static String Reverse(String str) {

        StringBuilder revesrsed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            revesrsed.append(str.charAt(i));
        }
        return revesrsed.toString();

    }

    public static boolean IsValidPalindrome(String str) {

        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }

        }
        return true;

    }

    public static void Duplicates(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + "=>" + entry.getValue() + " ");
            }

        }

    }

    public static void CountCharacters(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " => " + entry.getValue() + " | ");
        }
    }

    public static List<List<String>> GroupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();

            Arrays.sort(chars);

            String sorted = new String(chars);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(word);

        }

        return new ArrayList<>(map.values());

    }

    public static String LongestCommanPrefix(String[] strs) {

        for (int i = 0; i < strs[0].length(); i++) {

            char curr = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != curr) {
                    return strs[0].substring(0, i);
                }

            }

        }
        return strs[0];
    }

    public static int LongestLengthofSubstringWithoutRepeatingCharecters(String str) {

        int max = 0;
        int start = 0;

        HashSet<Character> map = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            while (map.contains(curr)) {
                map.remove(str.charAt(start));
                start++;

            }

            map.add(curr);

            max = Math.max(max, i - start + 1);

        }
        return max;

    }

    public static String SortWords(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            int count = map.get(c);

            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static String RemovesameConsecutiveChars(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (!stack.isEmpty() && curr == stack.peek()) {
                stack.pop();
            }
            stack.push(curr);
        }
        StringBuilder sb = new StringBuilder();

        for (char letter : stack) {
            sb.append(letter);
        }
        return sb.toString();

    }

    public static boolean WordBreak(String s, List<String> dictionary) {

        Set<String> dict = new HashSet<>(dictionary);

        boolean dp[] = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;

                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return dp[s.length()];
    }

    public static String LongestPolindromicSubstring(String str) {

        // ExpandAroundCornersMethod;

        if (str == null || str.length() < 1) {
            return " ";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {

            int len1 = ExpandAroundcenter(str, i, i);
            int len2 = ExpandAroundcenter(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);

    }

    // Helper--Longest polindrome ss
    public static int ExpandAroundcenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;

    }

    public static List<String> PartitionStrings(String str) {

        HashSet<String> set = new HashSet<>();
        List<String> segments = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            StringBuilder sb = new StringBuilder();

            int j = i;

            while (j < str.length()) {
                sb.append(str.charAt(j));
                String curr = sb.toString();

                if (!set.contains(curr)) {
                    set.add(curr);
                    segments.add(curr);

                    break;
                }

                j++;
            }
            i = j + 1;

        }
        return segments;

    }

    public static String MinimumWindowSubString(String s, String t) {

        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int start = 0;
        int right = 0;
        int minval = Integer.MAX_VALUE;
        int formed = 0;
        int required = tmap.size();

        while (right < s.length()) {

            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (tmap.containsKey(ch) && tmap.get(ch).intValue() == window.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minval) {
                    minval = right - left + 1;
                    start = left;
                }

                char c = s.charAt(left);
                window.put(c, window.getOrDefault(c, 0) - 1);
                if (tmap.containsKey(c) && window.get(c).intValue() < tmap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minval == Integer.MAX_VALUE ? "" : s.substring(start, start + minval);
    }

    public static void main(String[] args) {

        // String s = "education";
        // String t = "aeioudtnc";
        // System.out.println(anagrams(s, t));

        // String str = "HelloWorld";
        // System.out.println(Reverse(str));

        // String str = "racrcr";
        // System.out.println(IsValidPalindrome(str));

        // String str = "programming";
        // Duplicates(str);

        // String str = "qwertyyuiop";
        // CountCharacters(str);

        // String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // List<List<String>> ans = GroupAnagrams(strs);
        // System.out.println(ans);

        // String[] strs = { "flower", "flow", "floicker" };
        // System.out.println(LongestCommanPrefix(strs));

        // String str = "abcdefbbcd";
        // int length = LongestLengthofSubstringWithoutRepeatingCharecters(str);
        // System.out.println(length);

        // String str = "rrwiAAAn";
        // System.out.println(SortWords(str));

        // String str = "aabccdeeffd";
        // System.out.println(RemovesameConsecutiveChars(str));

        // List<String> dictionary = Arrays.asList("leet", "code", "hopp ");
        // String s = "leetcode";
        // System.out.println("Word Exists : " + WordBreak(s, dictionary));

        // String str = "geksskeeg";
        // System.out.println(LongestPolindromicSubstring(str));

        // String str = "abbccccd";
        // System.out.println(PartitionStrings(str));

        // String s = "ADOBECODEBANC";
        // String t = "ABC";
        // System.out.println(MinimumWindowSubString(s, t));

    }

}
