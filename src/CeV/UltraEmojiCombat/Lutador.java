package CeV.UltraEmojiCombat;

enum Categoria{
    LEVE,
    MEDIO,
    PESADO,
    INVALIDO
        }

public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura, peso;
    private Categoria categoria;
    private int wins, defeats, draws;

    public Lutador(String nome, String nacionalidade, int idade, float altura, float peso, int wins, int defeats, int draws) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        setPeso(peso);
        this.wins = wins;
        this.defeats = defeats;
        this.draws = draws;
    }

    public void apresentar() {
        System.out.println("==========================================");
        System.out.println("CHEGOU A A HORA! Apresentamos o lutador" + this.getNome());
        System.out.println("Diretamente de " + this.getNacionalidade());
        System.out.println("Com " + this.getIdade() + " anos e " + this.getAltura() + "m");
        System.out.println("Pesando " + this.getPeso() + "kg");
        System.out.println(this.getWins() + " Vitórias");
        System.out.println(this.getDefeats() + " Derrotas");
        System.out.println(this.getDraws() + " Empates");
    }

    public void status() {
        System.out.println("------------------------------------------");
        System.out.printf("%s é um PESO-%s%n" +
                "Ganhou %d vezes%n" +
                "Perdeu %d vezes%n" +
                "Empatou %d vezes%n", this.getNome(), this.getCategoria(), this.getWins(), this.getDefeats(), this.getDraws());
    }


    public  void ganharLuta(){
        this.setWins(this.getWins() + 1);
    }

    public void perderLuta(){
        this.setDefeats(this.getDefeats() + 1);
    }

    public void empatarLuta() {
        this.setDraws(this.getDraws() + 1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        setCategoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if (getPeso() < 52.2){
            this.categoria = Categoria.INVALIDO;
        } else if (getPeso() <= 70.3) {
            this.categoria = Categoria.LEVE;
        } else if (getPeso() <= 83.9) {
            this.categoria = Categoria.MEDIO;
        } else if (getPeso() <= 120.2) {
            this.categoria = Categoria.PESADO;
        }else {
            this.categoria = Categoria.INVALIDO;
        }
    }

    public int getWins() {
        return wins;
    }

    private void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    private void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getDraws() {
        return draws;
    }

    private void setDraws(int draws) {
        this.draws = draws;
    }
}
