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

    public static String ExcelColumString(int num) {

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            num--;
            int rem = num % 26;
            result.append((char) ('A' + rem));
            num /= 26;
        }

        return result.reverse().toString();
    }

    public static int ExcelColumNUmber(String str) {

        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int value = c - 'A' + 1;
            result = result * 26 + value;
        }
        return result;

    }

    // Same As MaxConsecutveonesIII problam
    public static int CharacterReplacement(String str, int k) {

        int freq[] = new int[26];
        int left = 0;
        int maxcount = 0;
        int maxlength = 0;

        for (int right = 0; right < str.length(); right++) {
            freq[str.charAt(right) - 'A']++;
            maxcount = Math.max(maxcount, freq[str.charAt(right) - 'A']);

            while ((right - left + 1) - maxcount > k) {
                freq[str.charAt(left) - 'A']--;
                left++;
            }
            maxlength = Math.max(maxlength, right - left + 1);

        }
        return maxlength;

    }

    public static String[] SliceStringwithFills(String str, int k, String fill) {

        StringBuilder sb = new StringBuilder(str);

        int rem = sb.length() % k;

        if (rem != 0) {
            int fills = k - rem;
            for (int i = 0; i < fills; i++) {
                sb.append(fill);
            }

        }

        String res[] = new String[sb.length() / k];

        for (int i = 0; i < sb.length(); i = i + k) {
            res[i / k] = sb.substring(i, i + k);
        }

        return res;

    }

    public static String LargestNumber(int nums[]) {

        int n = nums.length;

        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(str[i]);
        }

        return sb.toString();

    }

    public static int reversePolishNotation(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static List<Integer> PartitionLabels(String str) {

        List<Integer> list = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < str.length(); i++) {
            last[str.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            end = Math.max(end, last[str.charAt(i) - 'a']);

            if (end == i) {
                list.add(end - start + 1);
                start = i + 1;
            }
        }
        return list;

    }

    public static int VersionNUmbers(String version1, String version2) {

        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);

        for (int i = 0; i < length; i++) {

            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 > num2)
                return 1;
            if (num1 < num2)
                return -1;
        }

        return 0;

    }

    public static int RepeatedStringMatch(String a, String b) {

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.toString().contains(b))
            return count;
        sb.append(a);
        if (sb.toString().contains(b))
            return count + 1;

        return -1;
    }

    public static boolean StringwithConditions(String word) {

        if (word.length() < 3)
            return false;

        int vow = 0;
        int con = 0;

        for (char c : word.toCharArray()) {

            if (!Character.isLetterOrDigit(c)) {
                return false;
            }

            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) != -1) {
                    vow++;
                } else {
                    con++;
                }
            }
        }
        return vow > 0 && con > 0;

    }

    public static int StringtoInteger(String str) {

        int n = str.length();
        int i = 0;
        int sign = 1;
        int result = 0;

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(str.charAt(i))) {

            int digit = str.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result;

    }

    public static boolean ransomNote(String magazine, String ransomeNote) {

        int freq[] = new int[26];

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomeNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;
            }

            freq[c - 'a']--;
        }

        return true;
    }

    public static int LongestPolindromeLength(String s) {

        int freq[] = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean isodd = false;

        for (int count : freq) {
            length = length + (count / 2) * 2;

            if (count % 2 != 0) {
                isodd = true;
            }

        }

        return isodd ? length + 1 : length;

    }

    public static List<String> RemoveSubFolders(String[] folder) {

        Arrays.sort(folder);
        List<String> list = new ArrayList<>();

        for (String path : folder) {

            if (list.isEmpty() || !path.startsWith(list.get(list.size() - 1) + "/")) {
                list.add(path);
            }
        }

        return list;

    }

    public static String DecodeString(String s) {

        Stack<String> strstack = new Stack<>();
        Stack<Integer> numstack = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                numstack.push(num);
                strstack.push(sb.toString());
                num = 0;
                sb = new StringBuilder();
            }

            else if (ch == ']') {
                int times = numstack.pop();
                StringBuilder temp = new StringBuilder(strstack.pop());
                while (times-- > 0) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static List<String> TopKFrequentWords(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqcomp = map.get(a) - map.get(b);
            if (freqcomp == 0) {
                return b.compareTo(a);
            }
            return freqcomp;
        });

        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }

        Collections.reverse(list);
        return list;
    }

    public static String MakeStringBeautiful(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int len = sb.length();

            if (len >= 2 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }

            sb.append(s.charAt(i));

        }

        return sb.toString();

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

        // int num = 245;
        // System.out.println(ExcelColumString(num));

        // String str = "IK";
        // System.out.println(ExcelColumNUmber(str));

        // String str = "AABABBA";
        // System.out.println(CharacterReplacement(str, 1));

        // String str = "jayawr";
        // int k = 3;
        // String fill = "x";
        // String ans[] = SliceStringwithFills(str, k, fill);
        // System.out.println(Arrays.toString(ans));

        // int nums[] = { 3, 30, 34, 5, 9 };
        // String number = LargestNumber(nums);
        // System.out.println(number);

        // String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17",
        // "+", "5", "+" };
        // System.out.println(reversePolishNotation(tokens));

        // String str = "ababcbacadefegdehijhklij";
        // System.out.println(PartitionLabels(str));

        // String version1 = "12.1.1.1";
        // String version2 = "12.1.1.1";
        // System.out.println(VersionNUmbers(version1, version2));

        // String a = "abcd";
        // String b = "cdabcdab";
        // System.out.println(RepeatedStringMatch(a, b));

        // String str = "Ab4$";
        // System.out.println(StringwithConditions(str));

        // String str = "42";
        // System.out.println(StringtoInteger(str));

        // String magazine = "baa";
        // String ransomeNote = "aab";
        // System.out.println(ransomNote(magazine, ransomeNote));

        // String s = "abccccdd";
        // System.out.println(LongestPolindromeLength(s));

        // String[] folder = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        // List<String> ans = RemoveSubFolders(folder);
        // System.out.println(ans);

        // String s = "3[a]2[bc]";
        // System.out.println(DecodeString(s));

        // String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        // int k = 2;
        // List<String> res = TopKFrequentWords(words, k);
        // System.out.println(res);

        // String s = "leeeteeecccooodeeee";
        // System.out.println(MakeStringBeautiful(s));

    }

}
