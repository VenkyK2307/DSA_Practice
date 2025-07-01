import java.util.ArrayList;

public class bstrees {

    public static class TreeNode {
        int data;
        TreeNode right, left;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode build(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (root.data > val) {
            root.left = build(root.left, val);

        } else {
            root.right = build(root.right, val);
        }
        return root;

    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }

    public static TreeNode delete(TreeNode root, int key) {

        if (root == null)
            return null;
        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        }

        else {
            // root.data == key

            // Case-1 no child
            if (root.right == null && root.right == null)
                return null;

            // Case 2 Only one child
            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;

            // Case 3 Two children Present

            TreeNode IS = InorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;

    }

    // Helper -- delete function
    public static TreeNode InorderSuccesor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public static void PrintRange(TreeNode root, int k1, int k2) {

        if (root == null)
            return;
        if (root.data >= k1 && root.data <= k2) {
            PrintRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            PrintRange(root.right, k1, k2);
        }

        else if (root.data <= k1) {
            PrintRange(root.left, k1, k2);
        } else {
            PrintRange(root.right, k1, k2);
        }

    }

    public static void PrintPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("null");

    }

    public static void RoottoLeafPath(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);
        if (root.right == null && root.left == null) {
            PrintPath(path);

        }
        RoottoLeafPath(root.left, path);
        RoottoLeafPath(root.right, path);
        path.remove(path.size() - 1);

    }

    public static boolean ValidBst(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null)
            return true;
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;

        }

        return ValidBst(root.left, min, root) && ValidBst(root.right, root, max);

    }

    public static TreeNode CreateMirror(TreeNode root) {
        if (root == null)
            return null;

        TreeNode RightMirror = CreateMirror(root.right);
        TreeNode LeftMirror = CreateMirror(root.left);

        root.left = RightMirror;
        root.right = LeftMirror;

        return root;

    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void LowestElementinBST(TreeNode root) {

        if (root == null)
            return;

        while (root.left != null) {
            root = root.left;
        }

        System.out.println(root.data);

    }

    public static void highestElementinBSt(TreeNode root) {
        if (root == null)
            return;

        while (root.right != null) {
            root = root.right;
        }
        System.out.println(root.data);
    }

    public static int result = 0;
    public static int count = -1;

    public static int KthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        InorderKth(root, k);
        return result;
    }

    // Helper -- KthSmallest
    public static void InorderKth(TreeNode node, int k) {
        if (node == null)
            return;

        InorderKth(node.left, k);
        count++;
        if (count == k) {
            result = node.data;
            return;
        }
        InorderKth(node.right, k);

    }

    public static void main(String[] args) {

        int value[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        // Creates a BST
        TreeNode root = null;
        for (int i = 0; i < value.length; i++) {
            root = build(root, value[i]);
        }

        // inorder(root);
        // System.out.println();

        // System.out.println(search(root, 12));

        // delete(root, 4);
        // inorder(root);

        // PrintRange(root, 4, 10);

        // ArrayList<Integer> path = new ArrayList<>();
        // RoottoLeafPath(root, path);

        // boolean ans = ValidBst(root, null, null);
        // if (ans) {
        // System.out.println("valid");
        // } else {
        // System.out.println("Invalid");
        // }

        // CreateMirror(root);

        // preorder(root);

        // LowestElementinBST(root);

        // highestElementinBSt(root);

        // for (int i = 0; i < 10; i++) {
        // System.out.println(i + "th" + "==>" + KthSmallest(root, i));
        // }

    }

}
