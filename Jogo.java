import java.util.*;

public class Jogo {
    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private int rodadas;
    private final int MAX_RODADAS = 1000;
    

    public Jogo(List<Jogador> jogadores, List<Propriedade> propriedades) {
        this.jogadores = jogadores;
        this.tabuleiro = new Tabuleiro(propriedades);
        this.rodadas = 0;
    }
    public void iniciarJogo() {
        Random random = new Random();
        boolean jogoFinalizado = false;

        while (!jogoFinalizado && rodadas < MAX_RODADAS) {
            rodadas++;
            for (Jogador jogador : jogadores) {
                if (jogador.getCoins() <= 0) continue; // ------------------------------------------------------Se o jogador está quebrado, pula a vez
                int dado = random.nextInt(6) + 1; // -----------------------------------------------------------Joga o dado
                int novaPosicao = (jogador.getPosicao() + dado) % 20;
                jogador.setPosicao(novaPosicao);
                Propriedade propriedade = tabuleiro.getPropriedade(novaPosicao);
                //----------------------------------------------------------------------------------------------- Caso o jogador caia numa propriedade sem dono e queira comprar
                if (!propriedade.temDono() && jogador.deveComprar(propriedade)) {
                    if (jogador.getCoins() >= propriedade.getValorVenda()) {
                        jogador.perderDinheiro(propriedade.getValorVenda());
                        propriedade.setDono(jogador);
                        System.out.println(jogador.getNome() + " comprou a propriedade " + (novaPosicao + 1));
                    }
                } else {
                    // --------------------------------------------------------------------------------------------Caso contrário, pagar aluguel
                    propriedade.cobrarAluguel(jogador);
                }
                // -------------------------------------------------------------------------------------------------Verifica se há um vencedor
                List<Jogador> jogadoresAtivos = new ArrayList<>();
                for (Jogador j : jogadores) {
                    if (j.getCoins() > 0) jogadoresAtivos.add(j);
                }
                if (jogadoresAtivos.size() == 1) {
                    System.out.println("Vencedor: " + jogadoresAtivos.get(0).getNome());
                    jogoFinalizado = true;
                    break;
                }
            }
        }
        if (rodadas >= MAX_RODADAS) {
            System.out.println("O jogo terminou por time-out após " + rodadas + " rodadas.");
        }
    }
    public int getRodadas() {
        return rodadas;
    }
}
