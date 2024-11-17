public class Propriedade {
    private int valorVenda;
    private int valorAluguel;
    private Jogador dono;

    public Propriedade(int valorVenda, int valorAluguel) {
        this.valorVenda = valorVenda;
        this.valorAluguel = valorAluguel;
        this.dono = null; //------------------------------------------------------ Não há dono inicialmente no JOGO
    }

    public int getValorVenda() {
        return valorVenda;
    }

    public int getValorAluguel() {
        return valorAluguel;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    public boolean temDono() {
        return dono != null;
    }

    public void cobrarAluguel(Jogador jogador) {
        if (temDono() && jogador != dono) {
            jogador.perderDinheiro(valorAluguel);
            dono.receberDinheiro(valorAluguel);
        }
    }
}
