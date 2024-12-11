import java.util.Arrays;

public class simplifiedlsr {
    static int INF = 9999;

    public static void dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && graph[u][v] != INF
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Router " + src + " shortest paths: " + Arrays.toString(dist));
    }

    public static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 3, 5},
            {4, 0, 5, 1},
            {3, 5, 0, 6},
            {5, 1, 6, 0}
        };

        for (int i = 0; i < graph.length; i++) {
            dijkstra(graph, i);
        }
    }
}