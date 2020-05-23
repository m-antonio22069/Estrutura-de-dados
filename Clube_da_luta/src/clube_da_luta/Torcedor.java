
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clube_da_luta;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author manto
 */
public class Torcedor extends Pessoa {
    private Lutador preferencia;
    private float valor;
    private String numBilhete;

    /*
    Construtor de torcedor: Todo torcedo deve ter um nome
    */
    public Torcedor(String nome) {
        this.setNome(nome);
    }
          
    /*
    Gera um numero aleatorio para ser colocado no numero da aposta.
    guardando as informações num banco de dados, pode-se utilizar o metodo 
    para garantir que duas apostas não sejam iguais, ou seja, o numero gerado
    em uma aposta não podera ser igual ao numero gerado numa segunda aposta
    */
    public void apostar(){

        
        Random aleatorio = new Random();
        String numeroBilhete="";
        int cod[]=new int[6];
        
        for(int i=0;i<6;i-=-1) {
            cod[i]= aleatorio.nextInt(10);
            numeroBilhete =numeroBilhete+Integer.toString(cod[i]);
        }

        this.setNumBilhete(numeroBilhete);
        
    }
    
    /*
    Gera o recibo da aposta
    */
    public void recibo(Lutador preferencia) {
        Date dataRecibo = new Date();
        System.out.println("--------------*--------------");
        System.out.println("|    Nome do apostador:"+this.getNome());
        System.out.println("|    Aposta:"+this.getPreferencia().getNome());
        System.out.println("|    Valor da aposta:"+this.getValor());
        System.out.println("|    Numero da aposta:"+this.getNumBilhete());
        System.out.println("|    Data da aposta\n"+dataRecibo);
        System.out.println("--------------*--------------");
    }
    

    public String getNumBilhete() {
        return numBilhete;
    }

    public void setNumBilhete(String numBilhete) {
        this.numBilhete = numBilhete;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Lutador getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Lutador preferencia) {
        this.preferencia = preferencia;
    }
    
}
