/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sylvain
 * Exemple de classe principale utilisant à la fois Singleton et Strategy
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Grille singleton = Grille.INSTANCE;
        singleton.init();
        Tuile2048 t = new Tuile2048(singleton, 2, 3);
        t.deplacer(Direction.GAUCHE);
        
        DeplacementContext context; 

        
        context = new DeplacementContext(new RandomDeplacement()); 
        Direction d = context.executeStrategy(); 
        
        //context.setStrategy(new IADeplacement(singleton));
        //d = context.executeStrategy();
        
        
    }
}
