package tools;

import tools.In;
import grafo.Graph;
import java.util.*;
import java.io.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph g = null;

        System.out.println("Menu Principal:");
        System.out.println("1 - Ler grafo de arquivo");
        System.out.println("2 - Criar grafo manualmente");
        System.out.print("Escolha uma opção: ");
        int choice = scanner.nextInt();

        // Solicitar se deseja usar matriz ou lista
        System.out.println("Escolha a representação do grafo:");
        System.out.println("1 - Usar matriz de adjacência");
        System.out.println("2 - Usar lista de adjacência");
        System.out.print("Escolha: ");
        int useMatrixChoice = scanner.nextInt();
        boolean useMatrix = useMatrixChoice == 1;

        if (choice == 1) {
            System.out.print("Digite o nome do arquivo: ");
            String fileName = scanner.next();
            try {
                g = new Graph(new In(new File(fileName)), useMatrix);
                System.out.println("Grafo carregado com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                return;
            }
        } else if (choice == 2) {
            // Criar grafo manualmente
            System.out.print("Digite o número de vértices: ");
            int vertices = scanner.nextInt();
            g = new Graph(vertices, useMatrix);

            System.out.println("Adicionando arestas (digite -1 -1 para parar):");
            while (true) {
                System.out.print("Digite origem e destino da aresta (ex: 0 1): ");
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                if (u == -1 && v == -1) break;

                g.addEdgeM(u, v); // Adiciona a aresta
                System.out.println("Aresta adicionada!");
            }
        }

        System.out.println("\nEscolha um algoritmo:");
        System.out.println("1 - BFS (Busca em Largura)");
        System.out.println("2 - DFS (Busca em Profundidade)");
        System.out.println("3 - Bellman-Ford");
        System.out.println("4 - Dijkstra");
        System.out.println("5 - Ordenação Topológica");
        System.out.println("6 - Árvore Geradora Mínima (Prim)");
        System.out.print("Escolha: ");
        int method = scanner.nextInt();

        switch (method) {
            case 1:
                System.out.print("Vértice inicial para BFS: ");
                int startBFS = scanner.nextInt();
                g.BFS(startBFS);
                break;
            case 2:
                g.DFS();
                break;
            case 3:
                if (useMatrix) {
                    g.Bellman_Ford_Matriz(0);
                } else {
                    g.Bellman_Ford_Lista(0);
                }
                break;
            case 4:
                if (useMatrix) {
                    g.Dijkstra_Matriz(0);
                } else {
                    g.Dijkstra_Lista(0);
                }
                break;
            case 5:
                g.topologicalSort(0, g);
                break;
            case 6:
                g.primMST();
                break;
            default:
                System.out.println("Opção inválida!");
        }

        System.out.println("\nStatus do grafo:");
        System.out.println(g.StatusAtribs());
        scanner.close();
    }
}
