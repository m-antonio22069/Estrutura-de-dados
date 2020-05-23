package contabancaria;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class Conta {
    
    String titular = "";
    private int numero;
    private int agencia;
    private double saldo;
    Date dataCriacao;
    
    // construtores da classe
    Conta(String titularConta){
        this.titular = titularConta;
        dataCriacao = new Date();  
    }
    Conta(){
        dataCriacao = new Date();
    }

    //getters e setters
    public String getTitular (){
        return this.titular;
    }
    public void setTitular (String titularConta){
        this.titular = titularConta;
    }
   
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // metodo para sacar um valor da conta
    public void sacar (double valor){
        this.saldo -= valor;
    }
    
    // metodo para depositar um valor da conta
    public void depositar (double valor){
        this.saldo += valor;
    }
    
    //metodo para calcular rendimento
    private double calcularRendimento (){
        double rendimento = this.saldo*0.1;
        return rendimento;
    }
    
    // imprimir os dados da conta
    public void recuperarDadosImpressao(){
        JOptionPane.showMessageDialog(null, "Nome do titular da conta: "+getTitular()+"\n Numero da conta: "+ getNumero()
                +"\n Agencia:"+getAgencia()+"\n Saldo atual: "+getSaldo()+"\n Rendimento da conta a.m: "+calcularRendimento()
                +"\n Data da criação da conta: "+this.dataCriacao);
    }
    
}
