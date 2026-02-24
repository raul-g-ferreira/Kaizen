package CeV.UltraEmojiCombat;

import java.util.Random;

public class Luta {
    private Lutador desafiante;
    private Lutador desafiado;
    private int rounds;
    private boolean aprovada;

    public void marcarLuta(Lutador l1, Lutador l2) {
        if (l1.getCategoria().equals(l2.getCategoria()) && l1 != l2){
            aprovada = true;
            desafiado = l1;
            desafiante = l2;
        }else {
            aprovada = false;
            desafiado = null;
            desafiante = null;
        }
    }

    public void lutar() {
        if (this.aprovada) {
            desafiado.apresentar();
            desafiante.apresentar();

            Random random = new Random();
            int vencedor = random.nextInt(0,3);
            System.out.println("-------------------------------------------");
            switch (vencedor) {
                case 0:
                    System.out.println("EMPATE!");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                    break;
                case 1:
                    System.out.println("Vitória do " + desafiado.getNome());
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
                    break;
                case 2:
                    System.out.println("Vitória do " + desafiante.getNome());
                    desafiado.perderLuta();
                    desafiante.ganharLuta();
                    break;
            }
        } else {
            System.out.println("ESSA LUTA NÃO PODE ACONTECER");
        }
    }
}
