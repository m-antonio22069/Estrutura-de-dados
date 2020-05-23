
package clinica.medica;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * O projeto consiste em construir um pequeno sistema na qual seja possivel
 * alimentar o mesmo com informações de contatos de pacientes de uma clinica
 * 
 * @author Marcos
 */
public class ClinicaMedica {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int retornarMenu=1;
        
        Agenda agenda = new Agenda(10);//Instanciando uma agenda
        
        do{
            menu(); //Abrir menu
            Scanner entrada = new Scanner(System.in); //Instanciando nova entrada
        
            int menu = entrada.nextInt();//Escolhendo menu
            clean();
        
            OUTER:
            switch (menu) {
                case 1:
                //Adicionar contato
                    System.out.println("Deseja inserir contato ao final da lista?\n1-Sim  2-Não  3-Voltar ao menu");
                    int adiciona = entrada.nextInt();
                    clean();
                    //Modo de Adição
                    switch (adiciona) {
                        case 1:
                            List<String> lista1 = agenda.cadastro();
                            agenda.adiciona(lista1);
                            break;
                        case 2:
                            System.out.println("Digita a posicao que deseja adicionar o contato:");
                            int posicao = entrada.nextInt();
                            List<String> lista2 = agenda.cadastroQualquerPosicao(posicao);
                            
                            agenda.adicionaQualquerPosicao(lista2, posicao);
                            clean();
                            break;
                        default:
                            break OUTER;
                    }
                    clean();
                    System.out.println("Deseja voltar ao menu inicial?\n1-Sim  2-Não");
                    int voltarMenu1 = entrada.nextInt();
                    
                    if(voltarMenu1==2){
                        System.exit(0);
                    }
                    break;
                //Buscar um contato
                case 2:
                    System.out.println("Como deseja realizar a busca?\n1-Nome 2-CPF 3-Idade 4-Sair");
                    int modoBusca = entrada.nextInt();
                    clean();
                    //Modo de busca
                    switch(modoBusca){
                        case 1:
                            System.out.println("Digite o nome:");
                            String nome = entrada.next();
                            System.out.println(agenda.BuscaNome(nome));
                            break;
                        case 2:
                            System.out.println("Digite o CPF:");
                            String cpf = entrada.next();
                            System.out.println(agenda.BuscaCPF(cpf));
                            break;
                        case 3:
                            System.out.println("Digite o Idade:");
                            String idade = entrada.next();
                            System.out.println(agenda.BuscaIdade(idade));
                            break;
                        default:
                            break OUTER;
                    }
                    System.out.println("Deseja voltar ao menu inicial?\n1-Sim  2-Não");
                    int voltarMenu2 = entrada.nextInt();
                    
                    if(voltarMenu2==2){
                        System.exit(0);
                    }
                    break;
                //Listar contatos
                case 3:
                    agenda.listarPacientes();
                    System.out.println("\nDeseja voltar ao menu inicial?\n1-Sim  2-Não");
                    int voltarMenu3 = entrada.nextInt();
                    
                    if(voltarMenu3==2){
                        System.exit(0);
                    }
                    break;
                case 4:
                //Remover contato
                    System.out.println("Como deseja apagar um contato?\n1-Nome 2-CPF 3-Voltar ao menu");
                    int metodoRemover = entrada.nextInt();
                    
                    switch(metodoRemover){
                        case 1:
                            System.out.println("Digite o nome a ser removido");
                            String nomeRemover = entrada.next();
                            clean();
                            System.out.println("Tem certeza que deseja remover "+nomeRemover+"?\n1-Sim  2-Não");
                            int certezaRemover = entrada.nextInt();
                            
                            if(certezaRemover ==1){
                                agenda.removerNome(nomeRemover);
                            }else{
                                break;
                            }
                        break;
                        
                        case 2:
                            System.out.println("Digite o nome a ser removido");
                            String nomeRemover1 = entrada.next();
                            clean();
                            System.out.println("Tem certeza que deseja remover "+nomeRemover1+"?\n1-Sim  2-Não");
                            int certezaRemover1 = entrada.nextInt();
                            
                            if(certezaRemover1 ==1){
                                agenda.removerCPF(nomeRemover1);
                            }else{
                                break;
                            }
                        break;
                        
                        case 3:
                            break;
                    }
                    System.out.println("Deseja voltar ao menu inicial?\n1-Sim  2-Não");
                    int voltarMenu4 = entrada.nextInt();
                    
                    if(voltarMenu4==2){
                        System.exit(0);
                    }
                    break;
                default:
                    System.exit(0);
            }
            clean();
        }while(retornarMenu==1); 
    }
    
    private static void menu(){
        
        System.out.println("--------------BEM VINDO--------------\n");
        System.out.println("# Selecione uma opção no menu abaixo #\n");
        System.out.println("1-Inserir novo contato na Agenda");
        System.out.println("2-Buscar paciente");
        System.out.println("3-Listar todos os pacientes");
        System.out.println("4-Deletar contato de um paciente");
        System.out.println("5-Sair\n");
        System.out.println("------------------*------------------");
    }
    
    private static void clean() {
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
    
}
