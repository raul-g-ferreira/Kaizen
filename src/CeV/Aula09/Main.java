package CeV.Aula09;

public class Main {
    public static void main(String[] args) {
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];

        p[0] = new Pessoa("Pedro", 22, Sexo.MASCULINO);
        p[1] = new Pessoa("Maria", 25, Sexo.FEMININO);

        l[0] = new Livro("Aprendendo Java", "José da silva", 300, p[0]);
        l[1] = new Livro("POO para iniciantes", "Pedro Paulo", 500, p[1]);
        l[2] = new Livro("Java Avancado", "Maria Candida", 800, p[0]);

        System.out.println(l[0].detalhes());
        System.out.println(l[1].detalhes());
        System.out.println(l[2].detalhes());
    }
}
