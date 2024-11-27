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

// Classe para leitura de arquivos
class In {
    Scanner in;

    In(File file) {
        try {
            this.in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        }
    }

    boolean hasNextLine() {
        return in.hasNextLine();
    }

    String nextLine() {
        return in.nextLine();
    }
}

// Classe principal do grafo
public class Graph {
    static final Integer INF = Integer.MAX_VALUE;
    static final Integer NIL = -1;
    private int V; // número de vértices
    private int E; // número de arestas
    private Vector<Vector<Integer>> adj; // listas de adjacência
    private Vector<VertexAttributes> atribs; // atributos dos vértices
    private int time; // contador de tempo para DFS

    // Construtor para criar grafo vazio
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        initializeGraph();
    }

    // Construtor para criar grafo a partir de arquivo
    public Graph(In in) {
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();

            if (line.startsWith("c")) {
                continue; // Ignorar linhas de comentário
            } else if (line.startsWith("p")) {
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
        for (VertexAttributes attr : atribs) {
            attr.color = Color.WHITE;
            attr.d = INF;
            attr.pred = NIL;
        }
        atribs.get(s).color = Color.GRAY;
        atribs.get(s).d = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj(u)) {
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
        for (VertexAttributes attr : atribs) {
            attr.color = Color.WHITE;
            attr.pred = NIL;
        }

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

        for (int v : adj(u)) {
            if (atribs.get(v).color == Color.WHITE) {
                atribs.get(v).pred = u;
                DFSVisit(v);
            }
        }

        atribs.get(u).color = Color.BLACK;
        time++;
        atribs.get(u).f = time;
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

    // Programa principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph g = null;

        System.out.println("1 - Ler grafo de arquivo");
        System.out.println("2 - Criar grafo manualmente");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Digite o nome do arquivo: ");
            String fileName = scanner.next();
            try {
                g = new Graph(new In(new File(fileName)));
            } catch (Exception e) {
                System.out.println("Erro ao ler arquivo.");
                return;
            }
        } else if (choice == 2) {
            g = new Graph(4);
            g.addEdge(0, 1);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
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
