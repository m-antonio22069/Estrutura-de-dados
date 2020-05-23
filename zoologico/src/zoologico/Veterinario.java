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
public class Veterinario {
    
    public void examinar(Animal animal){
         if (animal instanceof Cachorro){
            animal.som();
        } else if (animal instanceof Cavalo){
            animal.som();
        } else if (animal instanceof Preguiça){
            animal.som();
        }
    }
}
