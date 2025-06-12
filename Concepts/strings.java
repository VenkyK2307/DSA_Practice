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

    // public static String MinimumWinowSubstring(String str1, String str2) {

    // }

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

        String str = "rrwiAAAn";
        System.out.println(SortWords(str));

    }

}
