package CeV.Aula11;

public class Tecnico extends Aluno{
    private int registroProfissional;

    public void praticar() {
        System.out.println(this.nome + " está praticando!");
    }

    public int getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(int registroProfissional) {
        this.registroProfissional = registroProfissional;
    }
}
