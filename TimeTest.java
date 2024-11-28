package test;

public class TimeTest {
    public static void main(String[] args) { //args[0] número do teste
       
        List<Long> Bellman-Ford_Lista = new ArrayList<>();
        List<Long> Bellman-Ford_Matriz = new ArrayList<>();
        List<Long> Dijkstral_Lista = new ArrayList<>();
        List<Long> Dijkstral_Matriz = new ArrayList<>();

      
            Graph1 = new Graph(new In(new File("sample100-1980.gr")))
            Graph2 = new Graph(new In(new File("sample100-3960.gr")))
            Graph3 = new Graph(new In(new File("sample100-5940.gr")))
            Graph4 = new Graph(new In(new File("sample100-7920.gr")))
            Graph5 = new Graph(new In(new File("sample100-9900.gr")))
            Graph6 = new Graph(new In(new File("sample200-7960.gr")))
            Graph7 = new Graph(new In(new File("sample200-15920.gr")))
            Graph8 = new Graph(new In(new File("sample200-23880.gr")))
            Graph9 = new Graph(new In(new File("sample200-31840.gr")))
            Graph10 = new Graph(new In(new File("sample200-39800.gr")))
            Graph11 = new Graph(new In(new File("sample500-49900.gr")))
            Graph12 = new Graph(new In(new File("sample500-99800.gr")))
            Graph13 = new Graph(new In(new File("sample500-149700.gr")))
            Graph14 = new Graph(new In(new File("sample500-199600.gr")))
	    Graph15 = new Graph(new In(new File("sample500-249500.gr")))
	
	    long t_ini, t_fim;

            // Bellman-Ford_Lista
            t_ini = System.nanoTime();
            Graph1.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph2.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph3.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph4.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph5.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph6.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph7.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph8.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph9.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph10.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph11.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph12.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph13.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph14.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph15.Bellman-Ford_Lista();
            t_fim = System.nanoTime();
            Bellman-Ford_Lista.add(t_fim - t_ini);
            

            // Bellman-Ford_Matriz
            t_ini = System.nanoTime();
            Graph1.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph2.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph3.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph4.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph5.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph6.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph7.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph8.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph9.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph10.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph11.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph12.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph13.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph14.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph15.Bellman-Ford_Matriz();
            t_fim = System.nanoTime();
            Bellman-Ford_Matriz.add(t_fim - t_ini);


            // Dijkstral_Lista
            t_ini = System.nanoTime();
            Graph1.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph2.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph3.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);

	    t_ini = System.nanoTime();
            Graph4.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph5.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph6.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph7.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph8.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph9.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph10.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph11.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph12.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph13.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph14.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph15.Dijkstral_Lista();
            t_fim = System.nanoTime();
            Dijkstral_Lista.add(t_fim - t_ini);
            
            
            // Dijkstral_Matriz
       
            t_ini = System.nanoTime();
            Graph1.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph2.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph3.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph4.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph5.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph6.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph7.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph8.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph9.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph10.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph11.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph12.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph13.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph14.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);
            
            t_ini = System.nanoTime();
            Graph15.Dijkstral_Matriz();
            t_fim = System.nanoTime();
            Dijkstral_Matriz.add(t_fim - t_ini);

       
        String nomeArquivoCSV = "TemposExecucao_Teste" + args[0] + ".csv";

        
        try (PrintWriter writer = new PrintWriter(new File(nomeArquivoCSV))) {
          
            writer.print("Algoritmo utilzado");
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                writer.print(",Teste " + (i + 1));
            }
            writer.println();

            
            writer.print("Bellman-Ford Lista");
            for (Long tempo : Bellman-Ford_Lista) writer.print("," + tempo);
            writer.println();

            writer.print("Bellman-Ford Matriz");
            for (Long tempo : Bellman-Ford_Matriz) writer.print("," + tempo);
            writer.println();

            writer.print("Dijkstral Lista");
            for (Long tempo : Dijkstral_Lista) writer.print("," + tempo);
            writer.println();

            writer.print("Dijkstral_Matriz");
            for (Long tempo : temposShell) writer.print("," + tempo);
            writer.println();

            
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
