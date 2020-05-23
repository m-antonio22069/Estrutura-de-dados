/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoologico;

/**
 *
 * @author marcos
 */
public abstract class Animal {
    private String nome;
    private byte idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Animal\n" + "nome: " + this.nome + "\nidade: " + this.idade+" Anos";
    }
    
    public abstract void som();
    
    public abstract void acao();
}
