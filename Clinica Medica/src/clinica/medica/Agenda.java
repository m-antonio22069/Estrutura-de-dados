/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.medica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 * @param <T>
 */
public class Agenda<T> extends Paciente {
    private T[] elementos, listaNome, listaCPF, listaIdade;
    int tamanho;
    
    public Agenda(int capacidade){
        this.elementos=(T[]) new Object[capacidade];
        this.listaNome=(T[]) new Object[capacidade];
        this.listaCPF=(T[]) new Object[capacidade];
        this.listaIdade=(T[]) new Object[capacidade];
        this.tamanho=0;
    }
    
    public Agenda(int capacidade, Class<T> tipoClasse){
        this.elementos=(T[]) Array.newInstance(tipoClasse, tamanho);
        this.listaNome=(T[]) Array.newInstance(tipoClasse, tamanho);
        this.listaCPF=(T[]) Array.newInstance(tipoClasse, tamanho);
        this.listaIdade=(T[]) Array.newInstance(tipoClasse, tamanho);
        this.tamanho=0;
    }
    
    
    public List<String> cadastro() throws IOException{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList auxiliarEndereco = new ArrayList();
        ArrayList auxiliarData = new ArrayList();
        ArrayList lista = new ArrayList();
        
        
        System.out.println("Nome completo:");
        String nome = in.readLine();
        lista.add(nome);
        this.setNome(nome);
        this.listaNome(nome);
        
        System.out.println("CPF:");
        String cpf = in.readLine();
        lista.add(cpf);
        this.setCPF(cpf);
        this.listaCPF(cpf);
                
        System.out.println("Idade:");
        String idade = in.readLine();
        lista.add(idade);
        this.setIdade(idade);
        this.listaIdade(idade);
        
        System.out.println("Endereço:");
        String endereco = in.readLine();
        auxiliarEndereco.add(endereco);
        
        System.out.println("Numero:");
        String numero = in.readLine();
        auxiliarEndereco.add(numero);
        
        System.out.println("Complemento:");
        String complemento = in.readLine();
        auxiliarEndereco.add(complemento);
        
        System.out.println("Bairro:");
        String bairro = in.readLine();
        auxiliarEndereco.add(bairro);
        
        System.out.println("CEP:");
        String cep = in.readLine();
        auxiliarEndereco.add(cep);
        
        System.out.println("Cidade:");
        String cidade = in.readLine();
        auxiliarEndereco.add(cidade);
        
        System.out.println("Estado:");
        String estado = in.readLine();
        auxiliarEndereco.add(estado);
        
        String enderecoCompleto = "";
        
        for(int i=0;i<auxiliarEndereco.size();i++){
            enderecoCompleto = enderecoCompleto + auxiliarEndereco.get(i) + " ";
        }
        lista.add(enderecoCompleto);
        this.setEndereço(enderecoCompleto);
        
        
        System.out.println("Data de Nascimento:");
        System.out.print("Dia:");
        String dia = in.readLine();
        auxiliarData.add(dia);
        System.out.print("Mes:");
        String mes = in.readLine();
        auxiliarData.add(mes);
        System.out.print("Ano:");
        String ano = in.readLine();
        auxiliarData.add(ano);
        
        String dataNascimento = "";
        
        for(int i=0; i<auxiliarData.size();i++){
            dataNascimento =dataNascimento + auxiliarData.get(i) + ".";
        }
        lista.add(dataNascimento);
        this.setAniversario(dataNascimento);
        
        System.out.print("Telefone:");
        String telefone = in.readLine();
        lista.add(telefone);
        this.setTelefone(telefone);
        
        System.out.print("Celular:");
        String celular = in.readLine();
        lista.add(celular);
        this.setCelular(celular);
        
        System.out.print("E-mail:");
        String email = in.readLine();
        lista.add(email);
        this.setEmail(email);
             
        return lista;              
    }
    
    public List<String> cadastroQualquerPosicao(int posicao) throws IOException{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList auxiliarEndereco = new ArrayList();
        ArrayList auxiliarData = new ArrayList();
        ArrayList lista = new ArrayList();
        
        
        System.out.println("Nome completo:");
        String nome = in.readLine();
        lista.add(nome);
        this.setNome(nome);
        this.listaNomeQualquerPosicao(nome, posicao);
        
        System.out.println("CPF:");
        String cpf = in.readLine();
        lista.add(cpf);
        this.setCPF(cpf);
        this.listaCPFQualquerPosicao(cpf, posicao);
                
        System.out.println("Idade:");
        String idade = in.readLine();
        lista.add(idade);
        this.setIdade(idade);
        this.listaIdadeQualquerPosicao(idade, posicao);
        
        System.out.println("Endereço:");
        String endereco = in.readLine();
        auxiliarEndereco.add(endereco);
        
        System.out.println("Numero:");
        String numero = in.readLine();
        auxiliarEndereco.add(numero);
        
        System.out.println("Complemento:");
        String complemento = in.readLine();
        auxiliarEndereco.add(complemento);
        
        System.out.println("Bairro:");
        String bairro = in.readLine();
        auxiliarEndereco.add(bairro);
        
        System.out.println("CEP:");
        String cep = in.readLine();
        auxiliarEndereco.add(cep);
        
        System.out.println("Cidade:");
        String cidade = in.readLine();
        auxiliarEndereco.add(cidade);
        
        System.out.println("Estado:");
        String estado = in.readLine();
        auxiliarEndereco.add(estado);
        
        String enderecoCompleto = "";
        
        for(int i=0;i<auxiliarEndereco.size();i++){
            enderecoCompleto = enderecoCompleto + auxiliarEndereco.get(i) + " ";
        }
        lista.add(enderecoCompleto);
        this.setEndereço(enderecoCompleto);
        
        
        System.out.println("Data de Nascimento:");
        System.out.print("Dia:");
        String dia = in.readLine();
        auxiliarData.add(dia);
        System.out.print("Mes:");
        String mes = in.readLine();
        auxiliarData.add(mes);
        System.out.print("Ano:");
        String ano = in.readLine();
        auxiliarData.add(ano);
        
        String dataNascimento = "";
        
        for(int i=0; i<auxiliarData.size();i++){
            dataNascimento =dataNascimento + auxiliarData.get(i) + ".";
        }
        lista.add(dataNascimento);
        this.setAniversario(dataNascimento);
        
        System.out.print("Telefone:");
        String telefone = in.readLine();
        lista.add(telefone);
        this.setTelefone(telefone);
        
        System.out.print("Celular:");
        String celular = in.readLine();
        lista.add(celular);
        this.setCelular(celular);
        
        System.out.print("E-mail:");
        String email = in.readLine();
        lista.add(email);
        this.setEmail(email);
             
        return lista;              
    }
    
    public void listarPacientes(){
        for (int i = 0; i<this.tamanho;i++){
            System.out.print(this.elementos[i]+"\n");
        }
    }
 
    public void adiciona(T elemento){
        this.aumentaCapacidade();
        if(this.tamanho<this.elementos.length){
            this.elementos[this.tamanho]=(T) elemento;
            this.tamanho++;
        }
    }
    
    public void adicionaQualquerPosicao(T elemento, int posicao){
        
        this.aumentaCapacidade();
        
        this.Busca(posicao);
        
        for(int i=this.tamanho-1;i>=posicao;i--){
            this.elementos[i+1]=this.elementos[i];
        }
        this.elementos[posicao]=elemento;
        this.tamanho++;
        
    }
    
    protected void aumentaCapacidade(){
        if(this.tamanho==this.elementos.length){
            Object[] novoVetor = new Object[this.elementos.length *2];
            System.arraycopy(this.elementos, 0, novoVetor, 0, this.elementos.length);
            this.elementos=(T[]) novoVetor;
        }
    }
    
    public void remover(T elemento){
        this.Busca(elemento);
        
        for(int i=0;i<=this.tamanho-1;i++){
            this.elementos[i]=this.elementos[i+1];
        }
        this.elementos[this.tamanho-1]=null;
        this.tamanho--;
    }
    
    public void removerNome(String nome){
        int posicao = this.BuscaNome(nome);
        
        for(int i=posicao;i<=this.tamanho-1;i++){
            this.listaNome[i]=this.listaNome[i+1];
            this.listaCPF[i]=this.listaCPF[i+1];
            this.listaIdade[i]=this.listaIdade[i+1];
            this.elementos[i]=this.elementos[i+1];
        }
        this.listaNome[this.tamanho-1]=null;
        this.tamanho--;
    }
    
    public void removerCPF(String CPF){
        int posicao = this.BuscaCPF(CPF);
        
        for(int i=posicao;i<=this.tamanho-1;i++){
            this.listaNome[i]=this.listaNome[i+1];
            this.listaCPF[i]=this.listaCPF[i+1];
            this.listaIdade[i]=this.listaIdade[i+1];
            this.elementos[i]=this.elementos[i+1];
        }
        this.listaNome[this.tamanho-1]=null;
        this.listaCPF[this.tamanho-1]=null;
        this.listaIdade[this.tamanho-1]=null;
        this.elementos[this.tamanho-1]=null;
        
        this.tamanho--;
    }
    
    public int tamanho(){
        return this.tamanho;
    }
    
    public int Busca(Object nome){
        for(int i=0;i<this.tamanho;i++){
            if(this.listaNome[i].equals(nome)){
                return i;
            }
        }
        return -1;
    }
    
    public int BuscaNome(String nome){
        for(int i=0;i<this.tamanho;i++){
            if(this.listaNome[i].equals(nome)){
                System.out.println("Posicao:"+i);
                return i;
            }
        }
        return -1;
    }
    
    public int BuscaCPF(String cpf){
        for(int i=0;i<this.tamanho;i++){
            if(this.listaCPF[i].equals(cpf)){
                System.out.println("Posicao:"+i);
                return i;
            }
        }
        return -1;
    }
    
    public T BuscaIdade(String idade){
        for(int i=0;i<this.tamanho;i++){
            if(this.listaIdade[i].equals(idade)){
                System.out.println("Posicao:"+i);
                return this.listaIdade[i];
            }
        }
        return null;
    }
      
    public int ultimoIndice(T elemento){
        int ultimoIndice=-1;
        for (int i=this.tamanho-1;i>=0;i--){
            if(this.elementos[i].equals(elemento)){
                ultimoIndice=i;
            }
        }
        return ultimoIndice;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        
        for(int i=0;i<this.tamanho-1;i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if(this.tamanho>0){
            s.append(this.elementos[this.tamanho-1]);
        }
        s.append("]");
        
        return s.toString();
    }

    public void listaNome(String nome) {
        this.aumentaCapacidade();
        
        if(this.tamanho<this.listaNome.length){
            this.listaNome[this.tamanho]=(T) nome;
        }
    }
    
    public void listaNomeQualquerPosicao(String nome, int posicao){
        
        this.aumentaCapacidade();
        
        this.Busca(posicao);
        
        for(int i=this.tamanho-1;i>=posicao;i--){
            this.listaNome[i+1]=this.listaNome[i];
        }
        this.listaNome[posicao]=(T) nome;
    }

    public void listaCPF(String cpf) {
        this.aumentaCapacidade();
        if(this.tamanho<this.listaCPF.length){
            this.listaCPF[this.tamanho]=(T) cpf; 
        }
    }
    
    public void listaCPFQualquerPosicao(String cpf, int posicao){
        
        this.aumentaCapacidade();
        
        this.Busca(posicao);
        
        for(int i=this.tamanho-1;i>=posicao;i--){
            this.listaCPF[i+1]=this.listaCPF[i];
        }
        this.listaCPF[posicao]=(T) cpf;
    }

    public void listaIdade(String idade) {
        this.aumentaCapacidade();
        if(this.tamanho<this.listaIdade.length){
            this.listaIdade[this.tamanho]=(T) idade; 
        }
    }

    private void listaIdadeQualquerPosicao(String idade, int posicao) {
        this.aumentaCapacidade();
        
        this.Busca(posicao);
        
        for(int i=this.tamanho-1;i>=posicao;i--){
            this.listaCPF[i+1]=this.listaCPF[i];
        }
        this.listaCPF[posicao]=(T) idade;
    }

}
