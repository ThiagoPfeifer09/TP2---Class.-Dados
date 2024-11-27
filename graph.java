package grafo;

import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;


enum Color {
  WHITE, GRAY, BLACK
}

class VertexAttributes {
  Color color;
  int pred;
  int d;
  int f;
}

class In {
  Scanner in;

  In(File in) {
    try {
      this.in = new Scanner(in);
    } catch (FileNotFoundException e) {

    }
  }

  int readInt() {
    // System.out.println(in.next());
    return in.nextInt();
  }
}

public class Graph {
  static final Integer INF = 1000000000;
  static final Integer NIL = -1;
  private final int V; // number of vertices
  private int E; // number of edges
  private Vector<Vector<Integer>> adj; // adjacency lists
  private Vector<VertexAttributes> atribs;

  public Graph(int V) {
    this.V = V;
    this.E = 0;
    adj = new Vector<Vector<Integer>>(V); // Create array of lists.
    for (int v = 0; v < V; v++)
      adj.add(new Vector<Integer>()); // Initialize all lists to empty.
    atribs = new Vector<VertexAttributes>(V);
    for (int v = 0; v < V; v++)
      atribs.add(new VertexAttributes());
  }

  public Graph(In in) {
    this(in.readInt()); // Read V and construct this graph.
    int E = in.readInt(); // Read E.
    for (int i = 0; i < E; i++) { // Add an edge.
      int v = in.readInt(); // Read a vertex,
      int w = in.readInt(); // read another vertex,
      addEdge(v, w); // and add edge connecting them.
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(int v, int w) {
    adj.get(v).add(w); // Add w to v’s list.
    adj.get(w).add(v); // Add v to w’s list.
    E++;
  }

  public Iterable<Integer> adj(int v) {
    return adj.get(v);
  }

  public String toString() {
    String s = V + " vertices, " + E + " edges\n";
    for (int v = 0; v < V; v++) {
      s += v + ": ";
      for (int w : this.adj(v))
        s += w + " ";
      s += "\n";
    }
    return s;
  }

  public String StatusAtribs() {
    String s = "Vertex Attributes Status (color, pred, d, f) \n";
    int i = 0;
    for (VertexAttributes a : atribs) {
      s += (i) + ": " + a.color + ", " + a.pred + ", " + a.d + ", " + a.f;
      s += "\n";
      i++;
    }
    return s;
  }

  public void BFS(int s) {
    Queue<Integer> Q;
    for (VertexAttributes a : atribs) {
      a.color = Color.WHITE;
      a.d = INF;
      a.pred = NIL;
    }
    atribs.get(s).color = Color.GRAY;
    atribs.get(s).d = 0;
    atribs.get(s).pred = NIL;
    Q = new LinkedList<Integer>();
    Q.add(s);
    while (Q.peek() != null) { // if Q is empty, peek() returns null
      int u = Q.poll();
      for (Integer v : adj(u)) {
        if (atribs.get(v).color == Color.WHITE) {
          atribs.get(v).color = Color.GRAY;
          atribs.get(v).d = atribs.get(u).d + 1;
          atribs.get(v).pred = u;
          Q.add(v);
        }
      }
      atribs.get(u).color = Color.BLACK;
    }
  }

  public void DFS() {
    Stack<Integer> S; // Pilha para a busca em profundidade
    // Inicializa os atributos dos vértices
    for (VertexAttributes a : atribs) {
      a.color = Color.WHITE; // Branco significa não visitado
      a.d = INF; // Distância inicial como infinito
      a.pred = NIL; // Sem predecessores
    }

    // Vamos agora iterar sobre todos os vértices
    // e chamar DFSVisit para os que ainda não foram visitados
    for (int i = 0; i < atribs.size(); i++) {
      if (atribs.get(i).color == Color.WHITE) {
        DFSVisit(i); // Realiza a DFS a partir do vértice i
      }
    }
  }

  private void DFSVisit(int s) {
    Stack<Integer> S = new Stack<>(); // Usando uma pilha para a DFS
    atribs.get(s).color = Color.GRAY; // Marca o vértice como em processo
    atribs.get(s).d = 0; // A distância para o vértice inicial é 0
    atribs.get(s).pred = NIL; // Sem predecessor
    S.push(s); // Coloca o vértice inicial na pilha

    while (!S.isEmpty()) { // Enquanto houver vértices na pilha
      int u = S.pop(); // Retira o topo da pilha

      // Explora os vizinhos do vértice u
      for (Integer v : adj(u)) {
        // Se o vizinho ainda não foi visitado
        if (atribs.get(v).color == Color.WHITE) {
          atribs.get(v).color = Color.GRAY; // Marca o vizinho como em processo
          atribs.get(v).d = atribs.get(u).d + 1; // Atualiza a distância
          atribs.get(v).pred = u; // Define o predecessor
          S.push(v); // Coloca o vizinho na pilha para exploração futura
        }
      }

      // Marca o vértice u como completamente explorado
      atribs.get(u).color = Color.BLACK;
    }
    
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Graph g = null;

    // Menu inicial para ler grafo
    System.out.println("Escolha como deseja criar o grafo:");
    System.out.println("1 - Ler grafo de um arquivo");
    System.out.println("2 - Criar grafo manualmente (exemplo pré-definido)");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha restante

    if (choice == 1) {
      System.out.print("Digite o nome do arquivo: ");
      String fileName = scanner.nextLine();
      try {
        g = new Graph(new In(new File(fileName)));
      } catch (Exception e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        return;
      }
    } else if (choice == 2) {
      // Exemplo de grafo pré-definido
      g = new Graph(6);
      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 3);
      g.addEdge(2, 4);
      g.addEdge(2, 5);
    } else {
      System.out.println("Opção inválida!");
      return;
    }

    // Menu para escolha do método de ordenação
    System.out.println("Escolha o método de busca:");
    System.out.println("1 - BFS (Busca em Largura)");
    System.out.println("2 - DFS (Busca em Profundidade)");
    int method = scanner.nextInt();

    if (method == 1) {
      System.out.print("Digite o vértice de início para BFS: ");
      int startVertex = scanner.nextInt();
      g.BFS(startVertex);
      System.out.println("Resultado da BFS:");
      System.out.println(g.StatusAtribs());
    } else if (method == 2) {
      g.DFS();
      System.out.println("Resultado da DFS:");
      System.out.println(g.StatusAtribs());
    } else {
      System.out.println("Método inválido!");
    }

    scanner.close();
  }
}
