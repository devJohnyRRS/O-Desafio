// -------------------------------------------------------------------------------Classe base abstrata Jogador
public abstract class Jogador {
    private String nome;
    private int coins;
    private int posicao;

    // ---------------------------------------------------------------------------define o nome e as moedas iniciais
    public Jogador(String nome) {
        this.nome = nome;
        this.coins = 300; // -----------------------------------------------------Todos começam com 300 moedas
        this.posicao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getCoins() {
        return coins;
    }

    public void perderDinheiro(int valor) {
        this.coins -= valor;
    }
    public void receberDinheiro(int valor) {
        this.coins += valor;
    }
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    // -------------------------------------------------------------------------------jogadores devem implementar para decidir se compram a propriedade
    public abstract boolean deveComprar(Propriedade propriedade);

    // -------------------------------------------------------------------------------retorna o comportamento do jogador
    public abstract String getComportamento();
}

// -----------------------------------------------------------------------------------Jogador Impulsivo: Compra qualquer propriedade sem questionar
class JogadorImpulsivo extends Jogador {
    public JogadorImpulsivo(String nome) {
        super(nome);
    }

    // ------------------------------------------------------------------------------Compra qualquer propriedade que não tenha dono
    @Override
    public boolean deveComprar(Propriedade propriedade) {
        return !propriedade.temDono(); // -------------------------------------------Compra qualquer propriedade
    }

    @Override
    public String getComportamento() {
        return "Impulsivo";
    }
}

// -----------------------------------------------------------------------------------Jogador Exigente: Compra propriedades com aluguel maior que 50
class JogadorExigente extends Jogador {
    public JogadorExigente(String nome) {
        super(nome);
    }

    // ---------------------------------------------------------------------------------Compra se o aluguel for maior que 50
    @Override
    public boolean deveComprar(Propriedade propriedade) {
        return !propriedade.temDono() && propriedade.getValorAluguel() > 50;
    }

    @Override
    public String getComportamento() {
        return "Exigente";
    }
}

// --------------------------------------------------------------------------------------Jogador Cauteloso: Compra se sobrar 80 moedas após a compra
class JogadorCauteloso extends Jogador {
    public JogadorCauteloso(String nome) {
        super(nome);
    }

    // Compra se sobrar pelo menos 80 moedas após a compra
    @Override
    public boolean deveComprar(Propriedade propriedade) {
        return !propriedade.temDono() && getCoins() - propriedade.getValorVenda() >= 80;
    }

    @Override
    public String getComportamento() {
        return "Cauteloso";
    }
}

// --------------------------------------------------------------------------------------------Jogador Aleatório: Compra com 50% de chance
class JogadorAleatorio extends Jogador {
    private static final double PROBABILIDADE_COMPRA = 0.5; // --------------------------------Probabilidade de 50%

    public JogadorAleatorio(String nome) {
        super(nome);
    }

    // ------------------------------------------------------------------------------------------Compra com uma probabilidade de 50%
    @Override
    public boolean deveComprar(Propriedade propriedade) {
        return !propriedade.temDono() && Math.random() < PROBABILIDADE_COMPRA;
    }

    @Override
    public String getComportamento() {
        return "Aleatório";
    }
}
