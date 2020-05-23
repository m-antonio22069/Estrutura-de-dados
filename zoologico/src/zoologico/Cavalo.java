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
public class Cavalo extends Animal implements Quadrupede {
    private String som;
    private String acao;
    int npatas=4;

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    @Override
    public void som() {
        System.out.println("Cavalo relixando");
    }

    @Override
    public void acao() {
        System.out.println("Cavalo correndo");
    }
    
    @Override 
    public boolean isQuadrupede(){
        if (this.npatas == 4){
            return true;
        } else {
            return false;
        }
    }
}
