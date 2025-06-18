import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.event.TreeExpansionEvent;

class TreeNode {
    int value;
    TreeNode right;
    TreeNode left;

    TreeNode(int value) {
        this.value = value;
    }

}

class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class trees {
    static int MaxDiameter = 0;

    public static int treeheightandDiameter(TreeNode root) {

        if (root == null)
            return 0;

        int leftheight = treeheightandDiameter(root.left);
        int rightheight = treeheightandDiameter(root.right);

        int Diameter = leftheight + rightheight;

        MaxDiameter = Math.max(MaxDiameter, Diameter);

        int height = 1 + Math.max(leftheight, rightheight);
        return height;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        int NoOfNodes = 1 + left + right;
        return NoOfNodes;
    }

    public static int SumofNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = SumofNodes(root.left);
        int right = SumofNodes(root.right);

        int sum = left + right + root.value;
        return sum;

    }

    public static boolean IsSubTree(TreeNode root, TreeNode SubRoot) {
        if (root == null)
            return false;
        if (IsIdentical(root, SubRoot))
            return true;

        return IsSubTree(root.left, SubRoot) || IsSubTree(root.right, SubRoot);
    }

    // Helper Function() //Just as like same Trees
    public static boolean IsIdentical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.value != t2.value)
            return false;

        return IsIdentical(t1.left, t2.left) && IsIdentical(t1.right, t2.right);

    }

    public static void TopView(TreeNode root) {

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.value);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        System.out.print("Top view : ");
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

    public static void BottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            map.put(hd, node.value);

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        System.out.print("Bottom View : ");
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void RightView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.print("Right view : ");

        while (!queue.isEmpty()) {

            int levelsize = queue.size();

            for (int i = 0; i < levelsize; i++) {

                TreeNode node = queue.poll();

                if (i == levelsize - 1) {
                    System.out.print(node.value + " ");
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

        }
        System.out.println();

    }

    public static void LeftView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.print("Left View: ");

        while (!queue.isEmpty()) {
            int levelsize = queue.size();

            for (int i = 0; i < levelsize; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    System.out.print(node.value + " ");
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

        }
        System.out.println();
    }

    public static void BFS(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.print("BFS : ");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);

        }
        System.out.println();

    }

    // DFS == PreOrder
    public static void DFS(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.value + " ");
        DFS(root.left);
        DFS(root.right);

    }

    public static void PreOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        PreOrder(root.left);
        PreOrder(root.right);

    }

    public static void Inorder(TreeNode root) {
        if (root == null)
            return;

        Inorder(root.left);
        System.out.print(root.value + " ");
        Inorder(root.right);
    }

    public static void PostOrder(TreeNode root) {
        if (root == null)
            return;

        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.value + " ");

    }

    public static boolean IsSameTree(TreeNode root, TreeNode SubRoot) {
        if (root == null && SubRoot == null) {
            return true;
        }

        return root.value == SubRoot.value && IsSameTree(root.left, SubRoot.left)
                && IsSameTree(root.right, SubRoot.right);

    }

    public static List<List<Integer>> RootstoLeafs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helperRTLs(root, list, result);
        return result;
    }

    // Helper(main Logic)
    public static void helperRTLs(TreeNode root, List<Integer> list, List<List<Integer>> result) {

        if (root == null)
            return;

        list.add(root.value);

        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }

        helperRTLs(root.left, list, result);
        helperRTLs(root.right, list, result);

        list.remove(list.size() - 1);

    }

    public static boolean IsSymetric(TreeNode root) {
        if (root == null)
            return false;
        return IsMirror(root.left, root.right);
    }

    // Helper And Main Problam
    public static boolean IsMirror(TreeNode root1, TreeNode SubRoot) {

        if (root1 == null && SubRoot == null)
            return true;
        if (root1 == null || SubRoot == null)
            return false;

        return (root1.value == SubRoot.value) && IsMirror(root1.left, SubRoot.right)
                && IsMirror(root1.right, SubRoot.left);

    }

    public static int TransformtoSumTree(TreeNode root) {

        if (root == null)
            return -1;

        int left = TransformtoSumTree(root.left);
        int right = TransformtoSumTree(root.right);

        int old = root.value;

        root.value = left + right;

        return old + root.value;
    }

    public static boolean hasPath(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return root.value == target;
        }

        return hasPath(root.left, target - root.value) || hasPath(root.right, target - root.value);

    }

    public static void DiagonalTraversal(TreeNode root) {

        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            while (node != null) {
                System.out.print(node.value + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }

                node = node.right;
            }
        }

    }

    public static TreeNode Invert(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);

        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        root.left.left.left.left = new TreeNode(16);

        TreeNode SubRoot = new TreeNode(4);
        SubRoot.left = new TreeNode(8);
        SubRoot.right = new TreeNode(9);
        SubRoot.left.left = new TreeNode(16);

        // System.out.println("Tree Height : " + treeheightandDiameter(root));
        // System.out.println("Diameter : " + MaxDiameter);

        // System.out.println("Total Nodes : " + countNodes(root));

        // System.out.println("Sum of Nodes : " + SumofNodes(root));

        // System.out.println("Is SubTree? ==> " + IsSubTree(root, SubRoot));

        // TopView(root);
        // BottomView(root);
        // RightView(root);
        // LeftView(root);

        // BFS(root);

        // System.out.print("DFS : ");
        // DFS(root);
        // System.out.println();

        // System.out.print("PreOrder : ");
        // PreOrder(root);
        // System.out.println();

        // System.out.print("InOrder : ");
        // Inorder(root);
        // System.out.println();

        // System.out.print("PostOrder : ");
        // PostOrder(root);
        // System.out.println();

        // System.out.println("Are Trees Same ? ==> " + IsSameTree(root, SubRoot));

        // System.out.println(RootstoLeafs(root));

        // System.out.println("Is Tree Symetric == > " + IsSymetric(SubRoot));

        // System.out.println("Are the MIrrors ? ==> " + IsMirror(root, SubRoot));

        // System.out.println(TransformtoSumTree(root));

        // System.out.println(hasPath(root, 11));

        DiagonalTraversal(root);

    }

}
