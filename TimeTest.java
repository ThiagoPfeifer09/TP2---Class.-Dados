package test;
import grafo.*;
import java.util.*;
import java.io.*;

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

public class TimeTest {
    public static void main(String[] args) {
        //args[0] grafo para teste
       //args[1] quantidade de testes


        List<Long> Bellman_Ford_Lista = new ArrayList<>();
        List<Long> Bellman_Ford_Matriz = new ArrayList<>();
        List<Long> Dijkstral_Lista = new ArrayList<>();
        List<Long> Dijkstral_Matriz = new ArrayList<>();

      Graph graph;

      switch(Integer.parseInt(args[0])){

        case 1:
            graph = new Graph(new In(new File("sample100-1980.gr")));;
        break;
        case 2:
            graph = new Graph(new In(new File("sample100-3960.gr")));
        break;
        case 3:
            graph = new Graph(new In(new File("sample100-5940.gr")));
        break;
        case 4:
            graph = new Graph(new In(new File("sample100-7920.gr")));
        break;
        case 5:
            graph = new Graph(new In(new File("sample100-9900.gr")));
        break;
        case 6:
            graph = new Graph(new In(new File("sample200-7960.gr")));
        break;
        case 7:
            graph = new Graph(new In(new File("sample200-15920.gr")));
        break;
        case 8:
            graph = new Graph(new In(new File("sample200-23880.gr")));
        break;
        case 9:
            graph = new Graph(new In(new File("sample200-31840.gr")));
        break;
        case 10:
            graph = new Graph(new In(new File("sample200-39800.gr")));
        break;
        case 11:
            graph = new Graph(new In(new File("sample500-49900.gr")));
        break;
        case 12:
            graph = new Graph(new In(new File("sample500-99800.gr")));
        break;
        case 13:
            graph = new Graph(new In(new File("sample500-149700.gr")));
        break;
        case 14:
            graph = new Graph(new In(new File("sample500-199600.gr")));
        break;
        case 15:
            graph = new Graph(new In(new File("sample500-249500.gr")));
        break;

	}

	int k = 0;

	while(k<Integer.parseInt(args[1])){

	   long t_ini, t_fim;

            // Bellman-Ford_Lista
            t_ini = System.nanoTime();
            graph.Bellman_Ford_Lista();
            t_fim = System.nanoTime();
            Bellman_Ford_Lista.add(t_fim - t_ini);
            


            // Bellman-Ford_Matriz
            t_ini = System.nanoTime();
            graph.Bellman_Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman_Ford_Matriz.add(t_fim - t_ini);
            


            // Dijkstral_Lista
            t_ini = System.nanoTime();
            graph.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            
            
            // Dijkstral_Matriz
            t_ini = System.nanoTime();
            graph.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);


        k++;

    }

        String nomeArquivoCSV = "TemposExecucao" + args[0] + "testes" + "grafo" + args[1] + ".csv";

        
        try (PrintWriter writer = new PrintWriter(new File(nomeArquivoCSV))) {
          
            writer.print("Algoritmo utilzado");
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                writer.print(",Teste " + (i + 1));
            }
            writer.println();

            
            writer.print("Bellman-Ford Lista");
            for (Long tempo : Bellman_Ford_Lista) writer.print("," + tempo);
            writer.println();

            writer.print("Bellman-Ford Matriz");
            for (Long tempo : Bellman_Ford_Matriz) writer.print("," + tempo);
            writer.println();

            writer.print("Dijkstral Lista");
            for (Long tempo : Dijkstral_Lista) writer.print("," + tempo);
            writer.println();

            writer.print("Dijkstral_Matriz");
            for (Long tempo : Dijkstral_Matriz) writer.print("," + tempo);
            writer.println();

            
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
