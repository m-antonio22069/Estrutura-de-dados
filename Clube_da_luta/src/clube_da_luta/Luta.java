
package clube_da_luta;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manto
 */
public class Luta extends Lutador {
    public Lutador desafiado;
    public Lutador desafiante;
    public Lutador vencedor;
    private int rounds, golpe, fighter, energiaDesafiado, energiaDesafiante,empate=1;
    private boolean aprovada;
    private int round;
    
    //Metodo para marcar uma luta    
    public void marcarLuta(Lutador desafiado,Lutador desafiante){
        if((desafiado.getCategoria().equals(desafiante.getCategoria()))&&(desafiante!=desafiado)){
            this.aprovada=true;            //TIREI OS SET'S
            this.desafiado=desafiado;
            this.desafiante=desafiante;
        }
        else{
            this.aprovada=false;
            this.desafiado=null;
            this.desafiante=null;
        }
    }
    
    //objeto instanciado da classe Random. ele gera um numero aleatorio
    Random n = new Random();
     
    //Metodo lutar
    //Verifica a viabilidade da luta e define seu resultado
    
    public void lutar() {
            //Verificando a viabilidade da luta
            if (this.getAprovada()) {
                /*Caso a luta seja possivel, os desafiante e o desafiado são apresentados*/
                System.out.println("          === DESAFIADO ===");
                this.getDesafiado().apresentar();
                System.out.println("          === DESAFIANTE ===");
                this.getDesafiante().apresentar();
                
                //Delay para dar a sensação de que a luta esta acontecendo ao vivo
                delay(2);
                //limpar saida
                limparsaida();
                
                //Definindo um valor de energia para cada lutador
                this.setEnergiaDesafiado(6);
                this.setEnergiaDesafiante(6);
                
                /*
                Delay para dar a sensação de que a luta esta acontecendo ao vivo
                */
                delay(2);
                
                
                //Inicio da luta
                System.out.println("-------------------------------------");
                System.out.println("        Começou a luta!!");
                System.out.println("-------------------------------------");
                
                //Delay para dar a sensação de que a luta esta acontecendo ao vivo
                delay(2);
                
                //limpar saida
                limparsaida();
                
                //Mostra na tela a energia de cada lutador no inicio da luta
                System.out.println("-----------------------------------------------");
                System.out.print("      Energia do " + this.getDesafiado().getNome()+ ": ");                
                for (int c=0; c<this.getEnergiaDesafiado(); c++) {
                    System.out.print("| ");
                }
                System.out.println("");
                System.out.print("      Energia do " + this.getDesafiante().getNome() + ": ");
                for (int c=0; c<this.getEnergiaDesafiante(); c++) {
                    System.out.print("| ");
                }
                System.out.println("");
                System.out.println("-----------------------------------------------");
                
                //Laço que ocorre durante a realização da luta
                /*É bom observar que o laço se encerra se um dos lutadores tiver com energia zero(perdeu)
                ou a luta terminou empatada.
                */
                while((this.energiaDesafiado>0)&&(this.energiaDesafiante>0)&&(empate!=0)) {
                    /*
                    Delay para dar a sensação de que a luta esta acontecendo ao vivo
                    */
                    delay(2);
                    /*
                    numero gerado aleatoriamente para definir quem vai atacar
                    pode-se observar :
                            de [0,3] o desafiante ataca;
                            de [4,7] o desafiado ataca;
                            de [8,9] a luta termina empatada;
                            o programa abre espaço para que cada numero represente um golpe ou finalização;
                            um golpe diminui a energia em (-1) e a finalização encerra a luta
                            (EnergiaFinal =0)
                    */
                    this.fighter = n.nextInt(10);
                    
                    if ((this.fighter>=0)&&(this.fighter<4)){
                            this.golpe = n.nextInt(4);
                            if ((this.golpe==0) || (this.golpe==1) || (this.golpe==2)) {
                                this.energiaDesafiante-=1;
                                System.out.println(this.desafiante.getNome() + " socou o " + this.desafiado.getNome());
                            } else {
                                this.energiaDesafiante = 0;
                                System.out.println(this.desafiante.getNome() + " FINALIZOU o " + this.desafiado.getNome());
                            }
                    }
                    else if((this.fighter>=4)&&(this.fighter<9)){
                            this.golpe = n.nextInt(4);
                            if ((this.golpe==0) || (this.golpe==1) || (this.golpe==2) ) {
                                this.energiaDesafiado-=1;
                                System.out.println(this.desafiado.getNome() + " socou o " + this.desafiante.getNome());
                            } else {
                                this.energiaDesafiado = 0;
                                System.out.println(this.desafiado.getNome() + " FINALIZOU o " + this.desafiante.getNome());                            
                            }
                    }
                    else{
                            this.empate=0;
                            System.out.println("Empate técnico !!");
                            this.desafiado.empatarLuta();
                            this.desafiante.empatarLuta();
                            break;
                            
                    }
                } 
                
                /*
                Sequencia de condicionais que definem o ganhador da luta
                pode observar que sera mostrado o nome do vencedor e sua energia;
                caso a luta tenha terminado empatada, o programa mostra apenas
                a energia final
                */
                if (this.energiaDesafiado==0) {
                    this.setVencedor(this.getDesafiante());
                    this.ganharLuta();
                    System.out.println("-----------------------------");
                    System.out.println("VENCEDOR: " + this.desafiado.getNome());
                    System.out.println("-----------------------------");
                    System.out.print("\nEnergia do " + this.desafiado.getNome() + ": ");
                    
                    for (int c=0; c<=this.energiaDesafiante; c++) {
                        System.out.print("| ");
                    }
                    System.out.println("\n");
                } else if (this.energiaDesafiante==0) {
                        this.setVencedor(this.getDesafiado());
                        this.ganharLuta();
                        System.out.println("------------------------------");
                        System.out.println("VENCEDOR: " + this.desafiante.getNome());
                        System.out.println("-----------------------------");
                        System.out.print("\nEnergia do " + this.desafiante.getNome() + ": ");
                        for (int c=0; c<this.energiaDesafiado; c++) {
                            System.out.print("| ");
                        }
                        System.out.println("\n");
                }
                else if(this.empate==0){
                    Lutador empt=null;
                    System.out.println("-----------------------------");
                    System.out.println("  A LUTA TERMINOU EMPATADA !!");
                    System.out.println("-----------------------------");
                    this.setVencedor(empt);
                    System.out.print("\nEnergia do " + this.desafiado.getNome() + ": ");
                    for (int c=0; c<=this.energiaDesafiante; c++) {
                        System.out.print("| ");
                    }
                    System.out.println("\n");
                    
                    System.out.print("\nEnergia do " + this.desafiante.getNome() + ": ");
                        for (int c=0; c<this.energiaDesafiado; c++) {
                            System.out.print("| ");
                        }
                    System.out.println("\n");
                }                                    
            } 
            /*
            Caso a luta seja inviavel, o programa printa na tela esse aviso
            */
            else {
                System.out.println("A luta não pode acontecer!!");
            }
        }
    
    //Metodos especiais get e set
    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    private int getRounds() {
        return rounds;
    }

    private void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Lutador getVencedor() {
        return this.vencedor;
    }

    public void setVencedor(Lutador vencedor) {
        this.vencedor = vencedor;
        
    }

    public int getGolpe() {
        return golpe;
    }

    public void setGolpe(int golpe) {
        this.golpe = golpe;
    }

    public int getFighter() {
        return this.fighter;
    }

    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    public int getEnergiaDesafiante() {
        return energiaDesafiante;
    }

    public void setEnergiaDesafiante(int energiaDesafiante) {
        this.energiaDesafiante = energiaDesafiante;
    }

    public int getEnergiaDesafiado() {
        return energiaDesafiado;
    }

    public void setEnergiaDesafiado(int energiaDesafiado) {
        this.energiaDesafiado = energiaDesafiado;
    }

    public int getRound() {
        return this.round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public boolean getAprovada() {
        return this.aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    private void limparsaida() {
        try {
        Robot robot = new Robot();
        robot.setAutoDelay(10);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
    } catch (AWTException ex) {
    }
}

    private void delay(int tempo) {
        try {
            Thread.sleep(tempo*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Luta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

