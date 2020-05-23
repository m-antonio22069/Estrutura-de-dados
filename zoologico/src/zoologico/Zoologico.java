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
public class Zoologico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cavalo cavalo = new Cavalo();
        cavalo.setNome("Zeus");
        cavalo.setIdade((byte)2);
        System.out.println(cavalo.toString());
        cavalo.som();
        cavalo.acao();
        
        Cachorro cachorro=new Cachorro();
        cachorro.setNome("Pegasus");
        cachorro.setIdade((byte)1);
        System.out.println(cachorro.toString());
        cachorro.som();
        cachorro.acao();
        
        Preguiça preguiça = new Preguiça();
        preguiça.setNome("jubileu");
        preguiça.setIdade((byte)4);
        preguiça.som();
        preguiça.acao();
        
        Animal pets[] = new Animal[3];
    
        pets[0]=cachorro;
        pets[1]=cavalo;
        pets[2]=preguiça;
        
        for(int i=0;i<3;i++){
            pets[i].som();
            pets[i].acao();
    }
    }
    
}
