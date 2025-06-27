public class tries {

    static class Node {

        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {

            children = new Node[26];

            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }
        curr.eow = true;

    }

    public static boolean Search(String key) {

        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];

        }
        return curr.eow;
    }

    public static boolean startswith(String key) {

        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];

        }
        return true;

    }

    public static boolean WordBreak(String key) {

        if (key.length() == 0) {
            return false;
        }

        if (Search(key)) {
            return true;
        }

        for (int i = 1; i < key.length(); i++) {
            String PartOne = key.substring(0, i);
            String PartTwo = key.substring(i);

            if (Search(PartOne) && WordBreak(PartTwo)) {
                return true;
            }

        }
        return false;
    }

    public static int UniqueSubstrings(Node root) {

        Node curr = root;

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                count += UniqueSubstrings(curr.children[i]);
            }
        }
        return count + 1;

    }

    public static String ans = "";

    public static String LongestWorfwithAllPrefixes(Node root, StringBuilder sb) {

        if (root == null) {
            return " ";
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                sb.append((char) (i + 'a'));

                if (sb.length() > ans.length()) {
                    ans = sb.toString();
                }

                LongestWorfwithAllPrefixes(root.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);

            }

        }

        return ans;

    }

    public static void main(String[] args) {
        String words[] = { "tree", "tries", "trans", "transform", "answer" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // System.out.println(Search("tree"));
        // System.out.println(Search("trees"));

        // String key = "treetranstransform";
        // System.out.println(WordBreak(key));

        // String key = "anss";
        // System.out.println(startswith(key));

        // String str = "apple";
        // for (int i = 0; i < str.length(); i++) {
        // String suffix = str.substring(i);
        // insert(suffix);
        // }
        // System.out.println(UniqueSubstrings(root));

        // String[] words = { "a", "ap", "app", "appl", "apple", "apply", "transform" };
        // for (String word : words) {
        // insert(word);
        // }
        // System.out.println(LongestWorfwithAllPrefixes(root, new StringBuilder("")));
    }

}
