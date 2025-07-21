import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.List;

public class graphs {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 6));
        graph[0].add(new Edge(0, 2, 10));
        graph[0].add(new Edge(0, 9, 10));
        graph[1].add(new Edge(1, 0, 6));
        graph[1].add(new Edge(1, 3, 9));
        graph[2].add(new Edge(2, 0, 10));
        graph[2].add(new Edge(2, 3, 7));
        graph[2].add(new Edge(2, 4, 8));
        graph[3].add(new Edge(3, 1, 9));
        graph[3].add(new Edge(3, 2, 7));
        graph[3].add(new Edge(3, 5, 13));
        graph[4].add(new Edge(4, 2, 8));
        graph[4].add(new Edge(4, 3, 12));
        graph[5].add(new Edge(5, 3, 13));
        graph[5].add(new Edge(5, 4, 15));
        graph[5].add(new Edge(5, 0, 15));
        graph[5].add(new Edge(5, 6, 5));
        graph[6].add(new Edge(6, 5, 5));
        graph[6].add(new Edge(6, 8, 5));
        graph[6].add(new Edge(6, 1, 5));
        graph[6].add(new Edge(6, 7, 4));
        graph[6].add(new Edge(6, 0, 5));
        graph[6].add(new Edge(6, 9, 5));
        graph[7].add(new Edge(7, 8, 6));
        graph[7].add(new Edge(7, 6, 6));
        graph[7].add(new Edge(7, 3, 9));
        graph[8].add(new Edge(8, 4, 7));
        graph[8].add(new Edge(8, 6, 5));
        graph[8].add(new Edge(8, 9, 3));
        graph[9].add(new Edge(9, 5, 10));
        graph[9].add(new Edge(9, 0, 11));
        graph[9].add(new Edge(9, 6, 5));

        // KosaRaju Example and Bridge Detection and AP
        // graph[0].add(new Edge(0, 1, 0));
        // graph[1].add(new Edge(1, 2, 0));
        // graph[2].add(new Edge(2, 0, 0));
        // graph[1].add(new Edge(1, 3, 0));
        // graph[3].add(new Edge(3, 4, 0));
        // graph[4].add(new Edge(4, 5, 0));
        // graph[5].add(new Edge(5, 3, 0));
        // graph[6].add(new Edge(6, 7, 0));
        // graph[7].add(new Edge(7, 6, 0));
        // graph[7].add(new Edge(7, 8, 0));
        // graph[8].add(new Edge(8, 9, 0));

    }

    public static void BFS(ArrayList<Edge> graph[], int V, boolean visited[], int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            if (visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {

                    Edge e = graph[curr].get(i);

                    queue.add(e.dest);

                }

            }

        }
        System.out.println();

    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean[] visiteddfs) {
        System.out.print(curr + " ");
        visiteddfs[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visiteddfs[e.dest]) {
                DFS(graph, e.dest, visiteddfs);

            }
        }

    }

    public static void FindAllPathsI(ArrayList<Edge> graph[], int src, int dest, ArrayList<Integer> list) {
        list.add(src);

        if (src == dest) {
            System.out.println(list);
        } else {
            for (Edge e : graph[src]) {
                if (!list.contains(e.dest)) {
                    FindAllPathsI(graph, e.dest, dest, list);
                }

            }

        }

        list.remove(list.size() - 1);

    }

    public static void FindAllPathsII(ArrayList<Edge> graph[], int curr, int dest, ArrayList<Integer> path,
            boolean visitedfap[]) {
        if (curr == dest) {
            path.add(curr);
            System.out.println(path);
            path.remove(path.size() - 1);
            return;
        }
        visitedfap[curr] = true;
        path.add(curr);

        for (Edge e : graph[curr]) {
            if (!visitedfap[e.dest]) {
                FindAllPathsII(graph, e.dest, dest, path, visitedfap);
            }
        }
        visitedfap[curr] = false;
        path.remove(path.size() - 1);

    }

    public static boolean HasCycle(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]) {

        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (rec[e.dest]) {
                return true;
            }

            else if (!vis[e.dest]) {
                if (HasCycle(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    // Helper -- TopSort
    public static void TopSortutil(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> stack) {

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                TopSortutil(graph, vis, e.dest, stack);
            }
        }

        stack.push(curr);

    }

    public static void TopSort(ArrayList<Edge> graph[], int V) {

        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                TopSortutil(graph, vis, i, stack);
            }

        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean HasCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (vis[curr] == true && e.dest != par) {
                return true;
            }

            else if (!vis[e.dest]) {
                if (HasCycleUndirected(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void DijkstraAlgorithm(ArrayList<Edge> graph[], int src, int V) {

        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean vis[] = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (vis[curr.node]) {
                continue;
            }
            vis[curr.node] = true;

            for (Edge e : graph[curr.node]) {

                int u = e.src;
                int v = e.dest;
                int w = e.wt;

                if (dist[u] + w < dist[v]) {// Relaxation
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));

                }

            }

        }

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void BellmanFord(ArrayList<Edge> graph[], int src, int V) {

        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int k = 0; k < V - 1; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {

                    Edge e = graph[i].get(j);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for (int num : dist) {
            System.out.print(num + " ");

        }

    }

    public static void PrimsAlgo(ArrayList<Edge> graph[], int V) {

        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        pq.add(new Pair(0, 0));
        int value = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (vis[curr.node])
                continue;

            vis[curr.node] = true;
            value += curr.weight;

            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);

                if (!vis[e.dest]) {
                    pq.add(new Pair(e.dest, e.wt));
                }

            }

        }
        System.out.println("the minimum cost to span the tree : " + value);

    }

    // Helper--KosaRaju
    public static void TopologicalSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                TopologicalSort(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);

    }

    public static void DFSHelp(ArrayList<Edge> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);

            }

        }

    }

    public static void KosaRajuAlgo(ArrayList<Edge> graph[], int V) {

        // Step 1 : Topological Sort
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                TopologicalSort(graph, i, vis, stack);
            }

        }

        // Step 2 : transpose The Graph

        @SuppressWarnings("unchecked")

        ArrayList<Edge> transpose[] = new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src, 0));
            }
        }

        // Step-3 : DFS
        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!vis[curr]) {
                DFSHelp(transpose, vis, curr);
                System.out.println();
            }

        }

    }

    static int time = 1;

    public static void BridgeDetection(ArrayList<Edge> graph[], int curr, int parent, int[] dt, int[] low,
            boolean vis[]) {

        vis[curr] = true;
        dt[curr] = low[curr] = time++;

        for (Edge e : graph[curr]) {

            int neigh = e.dest;

            if (neigh == parent)
                continue;

            if (!vis[neigh]) {
                BridgeDetection(graph, e.dest, curr, dt, low, vis);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (low[neigh] > dt[curr]) {
                    System.out.println("Bridge detected : " + curr + "--" + e.dest);
                } else {
                    System.out.println("No Bridges Detected.");
                }
            }

            else {
                low[curr] = Math.min(low[curr], dt[neigh]);

            }

        }
        // System.out.println(Arrays.toString(dt));
        // System.out.println(Arrays.toString(low));

    }

    // Helper Function
    public static void APdfs(ArrayList<Edge> graph[], int curr, int parent, int[] dt, int[] low, int time,
            boolean vis[], boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (Edge e : graph[curr]) {
            int neigh = e.dest;

            if (neigh == parent) {
                continue;
            }

            if (!vis[neigh]) {
                children++;
                APdfs(graph, e.dest, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (low[neigh] >= dt[curr] && parent != -1) {
                    ap[curr] = true;

                }

            }

            else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }

        if (parent == -1 && children > 1) {
            ap[curr] = true;
        }

    }

    // Tarjan Algorithm
    public static void ArticulationPoinit(ArrayList<Edge> graph[], int V) {

        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                APdfs(graph, i, -1, dt, low, time, vis, ap);
            }
        }
        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
                System.out.println("AP : " + i);
            }
        }

    }

    public static int CheapestFlight(ArrayList<Edge> graph[], int V, int src, int dest, int K) {

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(dis, V);

            for (int j = 0; j < V; j++) {
                for (Edge e : graph[j]) {
                    if (dis[e.src] != Integer.MAX_VALUE && dis[e.src] + e.wt < temp[e.dest]) {
                        temp[e.dest] = dis[e.src] + e.wt;
                    }

                }

            }
            dis = temp;

        }
        for (int num : dis) {
            System.out.print(num + " ");
        }
        return dis[dest] == Integer.MAX_VALUE ? -1 : dis[dest];

    }

    // Prims == ConnectCitiesWithMinimumCost
    public static int ConnectCitiesWithMinimumCost(ArrayList<Edge> graph[], int V) {
        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (vis[curr.node]) {
                continue;
            }
            vis[curr.node] = true;
            finalCost += curr.weight;

            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);

                if (!vis[e.dest]) {
                    pq.add(new Pair(e.dest, e.wt));
                }

            }

        }
        System.out.print("The total cost to connect the cities : ");
        return finalCost;

    }

    public static boolean CourseSchedule(int num, int[][] prerequsites) {

        int[] indegree = new int[num];
        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            map.add(new ArrayList<>());
        }

        for (int pre[] : prerequsites) {
            int course = pre[0];
            int prereq = pre[1];
            map.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) {
                queue.add(i);

            }

        }

        // int completed = 0;
        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            idx++;

            for (int neighbour : map.get(curr)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return (idx == num);

    }

    public static int[] CourseScheduleII(int num, int[][] prerequsites) {

        int[] indegree = new int[num];
        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            map.add(new ArrayList<>());
        }

        for (int pre[] : prerequsites) {
            int course = pre[0];
            int prereq = pre[1];
            map.get(prereq).add(course);
            indegree[course]++;
        }
        int flow[] = new int[num];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) {
                queue.add(i);

            }

        }

        // int completed = 0;
        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            flow[idx++] = curr;

            for (int neighbour : map.get(curr)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return (idx == num) ? flow : new int[] { 0 };

    }

    public static class OPair {
        int col;
        int row;

        OPair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public static int RottenOranges(int[][] grid) {

        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<OPair> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new OPair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;
        int mins = ROBacktrack(grid, queue, cols, rows, 0);

        for (int row[] : grid) {
            for (int cells : row) {
                if (cells == 1) {
                    return -1;
                }
            }
        }

        return mins;

    }

    public static int ROBacktrack(int[][] grid, Queue<OPair> queue, int cols, int rows, int time) {

        int size = queue.size();

        if (size == 0)
            return time - 1;

        while (size-- > 0) {

            OPair curr = queue.poll();
            int r = curr.row;
            int c = curr.col;

            if (r > 0 && grid[r - 1][c] == 1) {
                grid[r - 1][c] = 2;
                queue.add(new OPair(r - 1, c));
            }

            if (r < rows - 1 && grid[r + 1][c] == 1) {
                grid[r + 1][c] = 2;
                queue.add(new OPair(r + 1, c));
            }

            if (c > 0 && grid[r][c - 1] == 1) {
                grid[r][c - 1] = 2;
                queue.add(new OPair(r, c - 1));
            }

            if (c < cols - 1 && grid[r][c + 1] == 1) {
                grid[r][c + 1] = 2;
                queue.add(new OPair(r, c + 1));
            }

        }
        return ROBacktrack(grid, queue, cols, rows, time + 1);

    }

    // Travelling Sales Man
    // Floyd Warshell Algo..

    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 10;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);

        // for (int i = 0; i < V; i++) {
        // System.out.print("vertex " + i + " : ");
        // for (int j = 0; j < graph[i].size(); j++) {
        // Edge e = graph[i].get(j);
        // System.out.print(e.dest + " => " + e.wt + " | ");
        // }
        // System.out.println();
        // }

        // boolean visited[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        // if (visited[i] == false) {
        // BFS(graph, V, visited, i);
        // }
        // }

        // boolean visiteddfs[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        // if (visiteddfs[i] == false) {
        // DFS(graph, 0, visiteddfs);
        // }
        // }

        // int src = 0;
        // int dest = 5;
        // ArrayList<Integer> list = new ArrayList<>();
        // FindAllPathsI(graph, src, dest, list);

        // int src1 = 0;
        // int dest1 = 3;
        // boolean visitedfap[] = new boolean[V];
        // FindAllPathsII(graph, src1, dest1, list, visitedfap);

        // boolean vis[] = new boolean[V];
        // boolean rec[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        // if (!vis[i]) {
        // boolean cycle = HasCycle(graph, vis, 0, rec);
        // if (cycle) {
        // System.out.println(cycle);
        // break;
        // }
        // }
        // }

        // TopSort(graph, V);

        // boolean vis[] = new boolean[V];
        // boolean cycle = HasCycleUndirected(graph, vis, 0, -1);
        // System.out.println(cycle);

        // DijkstraAlgorithm(graph, 6, V);
        // System.out.println();

        // BellmanFord(graph, 0, V);
        // System.out.println();

        // PrimsAlgo(graph, V);

        // KosaRajuAlgo(graph, V);

        // boolean vis[] = new boolean[V];
        // int[] dt = new int[V];
        // int[] low = new int[V];
        // for (int i = 0; i < V; i++) {
        // if (!vis[i]) {
        // BridgeDetection(graph, i, -1, dt, low, vis);
        // }
        // }

        // ArticulationPoinit(graph, V);

        // int src = 3;
        // int dest = 9;
        // int K = 2;
        // int cost = CheapestFlight(graph, V, src, dest, K);
        // System.out.println("Cost : " + cost);

        // System.out.println(ConnectCitiesWithMinimumCost(graph, V));

        // int num = 4;
        // int[][] prerequsites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        // boolean ans = CourseSchedule(num, prerequsites);
        // System.out.println(ans);

        // int num1 = 4;
        // int[][] prerequsites1 = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        // int[] ans1 = CourseScheduleII(num1, prerequsites1);
        // System.out.println(Arrays.toString(ans1));

        int[][] grid = {
                { 1, 1, 1 },
                { 1, 2, 0 },
                { 0, 1, 1 }
        };
        System.out.println(RottenOranges(grid));

    }

}
