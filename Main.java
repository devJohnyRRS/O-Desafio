import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        try {
            //------------------------------------------------------------------------------- Carregar as propriedades do arquivo de configuração
            List<Propriedade> propriedades = GameConfig.carregarConfig("gameConfig.txt");
            //------------------------------------------------------------------------------- Criar jogadores
            List<Jogador> jogadores = new ArrayList<>();
            jogadores.add(new JogadorImpulsivo("Jogador 1"));
            jogadores.add(new JogadorExigente("Jogador 2"));
            jogadores.add(new JogadorCauteloso("Jogador 3"));
            jogadores.add(new JogadorAleatorio("Jogador 4"));
            // ----------------------------------------------------------------------------------Iniciar o jogo
            Jogo jogo = new Jogo(jogadores, propriedades);
            jogo.iniciarJogo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
