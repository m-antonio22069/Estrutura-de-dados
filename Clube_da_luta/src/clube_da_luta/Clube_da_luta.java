/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clube_da_luta;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import static java.time.Clock.system;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manto
 */
public class Clube_da_luta {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO code application logic here
        Lutador l1,l2;
        Scanner entrada = new Scanner(System.in);
        l1 = new Lutador();
        l2 = new Lutador();
        l1.cadastrar("1-ALPHA","Pretty boy","França",31,1.75f,68.9f,11,2,1);
        l2.cadastrar("2-OMEGA","Putscript","Brasil",29,1.68f,57.8f,14,2,3);
        
        //l1.status();
        //l2.status();
        
        Luta luta1=new Luta();
        
        luta1.marcarLuta(l1, l2);
        
        Torcedor torcedor = new Torcedor("Marcos");
        
         /*
        Menu de aposta
        */
        System.out.println("-----------------------------\n");
        System.out.println("Em qual lutador deseja apostar?\n");
        System.out.println("   1-Desafiado: " + l1.getNome());
        System.out.println("");
        System.out.println("   2-Desafiante: " + l2.getNome());
        System.out.println("\n-----------------------------");
        
        /*
        Escolha da aposta
        */
        int aposta = entrada.nextInt();
        
        //delay de 2 segundos
        delay(2);
        
        //limpar saida
        limparsaida();
        
        //Escolha o valor da aposta
        System.out.println("Quanto deseja apostar?");
        float valorAposta = entrada.nextFloat();
        torcedor.setValor(valorAposta);
        torcedor.getValor();
        
        //delay de 1 segundo
        delay(1);
        
        //Limpar Saida
        limparsaida();
        
        /*
        Switch case para definir em  quem o apostador decidiu apostar e gerar
        seu comprovante.
        */
        switch(aposta){
            case 1:
                torcedor.setPreferencia(l1);
                System.out.println("Aposta realizada com sucesso\n");
                System.out.println("Imprimindo recibo...\n");
                limparsaida();
                aguarde();
                delay(2);
                limparsaida();
                torcedor.apostar();
                torcedor.recibo(torcedor.getPreferencia());
                delay(3);
                limparsaida();
                break;        
            case 2:
               torcedor.setPreferencia(l2);
                System.out.println("\nAposta realizada com sucesso");
                System.out.println("\nImprimindo recibo...\n");
                limparsaida();
                aguarde();
                delay(2);
                torcedor.apostar();
                torcedor.recibo(torcedor.getPreferencia());
                delay(3);
                limparsaida();
                break;
            default:
                System.out.println("Aposta invalida !!");
                delay(2);
                limparsaida();
                System.exit(0);
                break;
        }
        
        /*
        Comando para dar inicio a luta
        */
        luta1.lutar();
        
        //delay de 2 segundos
        delay(2);
        
        //limpar saida
        limparsaida();
        
        /*
        Verifica se o apostador venceu a luta
        */
        if(luta1.getVencedor().equals(torcedor.getPreferencia())){
            System.out.println("        ===RESULTADO===");
            System.out.println("Parabens, voce ganhou a aposta !!");
            System.out.println("        ===============");
        }
        else if(luta1.getVencedor() == null){
            System.out.println("        ===RESULTADO===");
            System.out.println("Que pena ! Mais sorte na proxima");
            System.out.println("     ===============");
        }
        else{
            System.out.println("     ===RESULTADO===");
            System.out.println("Que pena ! Mais sorte na proxima");
            System.out.println("     ===============");
        }
        
    }

    private static void limparsaida() {
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
    
    private static void delay(float tempo){
        //Delay para dar a sensação de que a luta esta acontecendo ao vivo
        try {
            Thread.sleep((long) (tempo*1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Luta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void aguarde() {
    for(int i=0;i<3;i++){
                    System.out.print("Aguarde.");
                    delay(1);
                    limparsaida();
                    System.out.println("Aguarde..");
                    delay(1);
                    limparsaida();
                    System.out.println("Aguarde...");
                    delay(1);
                    limparsaida();
                }    
    }
}
