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

    }

}
