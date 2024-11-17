import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class GameConfig {
    public static List<Propriedade> carregarConfig(String arquivo) throws IOException {
        List<Propriedade> propriedades = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");
                if (partes.length == 2) {
                    int valorVenda = Integer.parseInt(partes[0]);
                    int valorAluguel = Integer.parseInt(partes[1]);
                    propriedades.add(new Propriedade(valorVenda, valorAluguel));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: O arquivo de configuração não foi encontrado.");
            throw e;
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de configuração.");
            throw e;
        }
        return propriedades;
    }
}
