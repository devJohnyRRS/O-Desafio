import java.util.List;

public class Tabuleiro {
    private List<Propriedade> propriedades;
    
    public Tabuleiro(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    public Propriedade getPropriedade(int posicao) {
        return propriedades.get(posicao % 20); //----------------------------------- O tabuleiro é cíclico
    }
}
