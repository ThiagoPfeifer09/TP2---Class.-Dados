package grafo;
import tools.In;
import java.util.*;
import java.io.*;

// Enumerador para cores de vértices
enum Color {
    WHITE, GRAY, BLACK
}
// Classe para armazenar atributos de vértices
class VertexAttributes {
    Color color;
    int pred;
    int d; // Tempo de descoberta
    int f; // Tempo de finalização
}

// Classe principal do grafo
public class Graph {
    static final Integer INF = Integer.MAX_VALUE;
    static final Integer NIL = -1;
    private int V; // número de vértices
    private int E; // número de arestas
    private Vector<Vector<Integer>> adj; // lista de adjacência
    private int[][] adjMatrix; // matriz de adjacência
    private Vector<VertexAttributes> atribs; // atributos dos vértices
    private boolean useMatrix; // flag para usar matriz
    private int time; // contador de tempo para DFS

    // Construtor para criar grafo vazio
    public Graph(int V, boolean useMatrix) {
        this.V = V;
        this.E = 0;
        this.useMatrix = useMatrix;
        if (useMatrix) {
            initializeGraphM();
        } else {
            initializeGraph();
        }
    }

    // Construtor para criar grafo a partir de arquivo
    public Graph(In in, boolean useMatrix) {
        this.useMatrix = useMatrix;
        if (useMatrix) {
            while (in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (line.startsWith("c")) continue;
                else if (line.startsWith("p")) {
                    String[] parts = line.split(" ");
                    this.V = Integer.parseInt(parts[2]);
                    this.E = 0;
                    initializeGraphM();
                } else if (line.startsWith("a")) {
                    String[] parts = line.split(" ");
                    int u = Integer.parseInt(parts[1]) - 1;
                    int v = Integer.parseInt(parts[2]) - 1;
                    addEdgeM(u, v);
                }
            }
        } else {
            while (in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (line.startsWith("c")) continue;
                else if (line.startsWith("p")) {
                    String[] parts = line.split(" ");
                    this.V = Integer.parseInt(parts[2]);
                    this.E = 0;
                    initializeGraph();
                } else if (line.startsWith("a")) {
                    String[] parts = line.split(" ");
                    int u = Integer.parseInt(parts[1]) - 1;
                    int v = Integer.parseInt(parts[2]) - 1;
                    addEdge(u, v);
                }
            }
        }
    }

    // Inicializa as estruturas internas (matriz de adjacência)
    private void initializeGraphM() {
        adjMatrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = 0; // 0 indica ausência de aresta
            }
        }
        atribs = new Vector<>(V);
        for (int i = 0; i < V; i++) {
            atribs.add(new VertexAttributes());
        }
    }

    // Adiciona uma aresta (matriz de adjacência)
    public void addEdgeM(int u, int v) {
        adjMatrix[u][v] = 1; // Altere o peso, se necessário
        E++;
    }


    // Retorna os vizinhos de um vértice (matriz)
    public List<Integer> adjM(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i] != 0) { // Considera arestas com peso não nulo
                neighbors.add(i);
            }
        }
        return neighbors;
    }

  

    // Inicializa as estruturas internas do grafo
    private void initializeGraph() {
        adj = new Vector<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new Vector<>());
        }
        atribs = new Vector<>(V);
        for (int i = 0; i < V; i++) {
            atribs.add(new VertexAttributes());
        }
    }

    // Adiciona uma aresta dirigida de v para w
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        E++;
    }

    // Retorna os vértices adjacentes de um vértice
    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    
    // Realiza uma busca em largura (BFS) a partir de um vértice
    public void BFS(int s) {
        // Inicializa os atributos dos vértices
        for (VertexAttributes attr : atribs) {
            attr.color = Color.WHITE;
            attr.d = INF;
            attr.pred = NIL;
        }

        // Marca o vértice de origem
        atribs.get(s).color = Color.GRAY;
        atribs.get(s).d = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        System.out.println("Iniciando BFS a partir do vértice " + s);

        // Executa a BFS
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println("Visitando vértice " + u);  // Print para ver qual vértice está sendo visitado
            for (int v : adj(u)) {  // Supondo que adj(u) retorna os vizinhos de u
                if (atribs.get(v).color == Color.WHITE) {
                    atribs.get(v).color = Color.GRAY;
                    atribs.get(v).d = atribs.get(u).d + 1;
                    atribs.get(v).pred = u;
                    queue.add(v);
                }
            }
            atribs.get(u).color = Color.BLACK;
        }
    }

    // Realiza uma busca em profundidade (DFS)
    public void DFS() {
        time = 0;
        // Inicializa os atributos dos vértices
        for (VertexAttributes attr : atribs) {
            attr.color = Color.WHITE;
            attr.pred = NIL;
        }

        System.out.println("Iniciando DFS");

        // Executa a DFS para cada vértice não visitado
        for (int i = 0; i < V; i++) {
            if (atribs.get(i).color == Color.WHITE) {
                DFSVisit(i);
            }
        }
    }

    // Visita um vértice na DFS
    private void DFSVisit(int u) {
        time++;
        atribs.get(u).d = time;
        atribs.get(u).color = Color.GRAY;

        System.out.println("Visitando vértice " + u + " (DFS)");  // Print para ver qual vértice está sendo visitado na DFS
        System.out.println("Tempo de descoberta do vértice " + u + ": " + atribs.get(u).d);  // Print do tempo de descoberta

        // Visita os vizinhos do vértice u
        for (int v : adj(u)) {
            if (atribs.get(v).color == Color.WHITE) {
                atribs.get(v).pred = u;
                DFSVisit(v);
            }
        }

        // Finaliza a visita ao vértice u
        atribs.get(u).color = Color.BLACK;
        time++;
        atribs.get(u).f = time;

        System.out.println("Finalizando vértice " + u + " (DFS)");  // Print quando finalizar o vértice na DFS
        System.out.println("Tempo de finalização do vértice " + u + ": " + atribs.get(u).f);  // Print do tempo de finalização
    }
    
    
    // Retorna o status dos atributos dos vértices
    public String StatusAtribs() {
        StringBuilder sb = new StringBuilder("Vertex Attributes (color, pred, d, f):\n");
        for (int i = 0; i < atribs.size(); i++) {
            VertexAttributes a = atribs.get(i);
            sb.append(i).append(": ")
                    .append(a.color).append(", ")
                    .append(a.pred).append(", ")
                    .append(a.d).append(", ")
                    .append(a.f).append("\n");
        }
        return sb.toString();
    }

    // Exibe o grafo em formato de string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges\n");
        for (int i = 0; i < V; i++) {
            sb.append(i).append(": ").append(adj.get(i)).append("\n");
        }
        return sb.toString();
    }

    public List<int[]> getEdgeList() {
    List<int[]> edges = new ArrayList<>();
    for (int u = 0; u < this.adj.size(); u++) {
        for (int v = 0; v < this.adj.get(u).size(); v++) {
            int weight = this.adj.get(u).get(v);
            if (weight != 0) {
                edges.add(new int[]{u, v, weight});
            }
        }
    }
    return edges;
}

public int[] Bellman_Ford_Lista(int src, List<int[]> edges) {
    // Determinar o maior índice de vértice
    int maxIndex = 0;
    for (int[] edge : edges) {
        maxIndex = Math.max(maxIndex, Math.max(edge[0], edge[1]));
    }
    if (maxIndex >= V) {
        System.err.println("Vértices fora do intervalo definido! Ajustando...");
        V = maxIndex + 1; // Ajustar V
    }

    // Inicializar distâncias
    int[] dist = new int[V];
    Arrays.fill(dist, INF);
    dist[src] = 0;

    // Relaxar arestas
    for (int i = 0; i < V - 1; i++) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if (u < 0 || u >= V || v < 0 || v >= V) {
                System.err.println("Aresta inválida: (" + u + ", " + v + ")");
                continue;
            }
            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
            }
        }
    }

    // Verificar ciclos negativos
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], weight = edge[2];
        if (dist[u] != INF && dist[u] + weight < dist[v]) {
            System.err.println("Ciclo de peso negativo detectado");
            return null;
        }
    }

    return dist;
}


public int[] Bellman_Ford_Matriz(int src) {
    // Array para armazenar as distâncias mínimas do vértice fonte para os demais
    int[] dist = new int[V];
    Arrays.fill(dist, INF); // Inicializa todas as distâncias como infinito
    dist[src] = 0; // A distância do vértice fonte para si mesmo é 0

    // Relaxa todas as arestas (V - 1) vezes
    for (int i = 0; i < V - 1; i++) {
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (adjMatrix[u][v] != 0 && dist[u] != INF && dist[u] + adjMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjMatrix[u][v];
                }
            }
        }
    }

    // Verifica a existência de ciclos de peso negativo
    for (int u = 0; u < V; u++) {
        for (int v = 0; v < V; v++) {
            if (adjMatrix[u][v] != 0 && dist[u] != INF && dist[u] + adjMatrix[u][v] < dist[v]) {
                System.out.println("Ciclo de peso negativo detectado!");
                return null;
            }
        }
    }

    return dist;
}

public void Dijkstra_Lista(int src) {
    int[] dist = new int[V]; // Array para armazenar a distância mínima
    boolean[] visited = new boolean[V]; // Array para marcar os vértices visitados
    Arrays.fill(dist, INF); // Inicializa todas as distâncias como infinito
    dist[src] = 0; // A distância do vértice de origem para si mesmo é 0

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.add(new int[]{src, 0}); // Insere o vértice de origem na fila de prioridade

    while (!pq.isEmpty()) {
        int[] current = pq.poll();
        int u = current[0];

        if (visited[u]) continue;
        visited[u] = true;

            for (int v : adj(u)) {
                if (!visited[v]) {
                    int newDist = dist[u] + 1; // Considera peso 1 para arestas sem peso explícito
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new int[]{v, dist[v]});
                    }
                }
            }
        }
}

public void Dijkstra_Matriz(int src) {
        int[] dist = new int[V]; // Array para armazenar a distância mínima
        boolean[] visited = new boolean[V]; // Array para marcar os vértices visitados
        Arrays.fill(dist, INF); // Inicializa todas as distâncias como infinito
        dist[src] = 0; // A distância do vértice de origem para si mesmo é 0

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0}); // Insere o vértice de origem na fila de prioridade

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];

            if (visited[u]) continue;
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0) { // Verifica se há aresta entre u e v
                    int newDist = dist[u] + adjMatrix[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new int[]{v, dist[v]});
                    }
                }
            }
        }

        System.out.println("Distâncias mínimas a partir do vértice " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vértice " + i + ": " + (dist[i] == INF ? "Infinito" : dist[i]));
        }
    }

    // Programa principal
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Graph g = null;
        
            System.out.println("1 - Ler grafo de arquivo");
            System.out.println("2 - Criar grafo manualmente");
            int choice = scanner.nextInt();
        
            // Solicitar se deseja usar matriz ou lista
            System.out.println("1 - Usar matriz de adjacência\n2 - Usar lista de adjacência");
            int useMatrixChoice = scanner.nextInt();
            boolean useMatrix = useMatrixChoice == 1;
        
            if (choice == 1) {
                System.out.print("Digite o nome do arquivo: ");
                String fileName = scanner.next();
                try {
                    g = new Graph(new In(new File(fileName)), useMatrix);
                } catch (Exception e) {
                    System.out.println("Erro ao ler arquivo.");
                    return;
                }
            } else if (choice == 2) {
                g = new Graph(4, useMatrix); // Passando o parâmetro useMatrix
                g.addEdgeM(0, 1);
                g.addEdgeM(1, 2);
                g.addEdgeM(2, 3);
            }
        
            System.out.println("1 - BFS\n2 - DFS");
            int method = scanner.nextInt();
            if (method == 1) {
                System.out.print("Vértice inicial: ");
                int start = scanner.nextInt();
                g.BFS(start);
            } else {
                g.DFS();
            }
        
            System.out.println(g.StatusAtribs());
            scanner.close();
        }
    }