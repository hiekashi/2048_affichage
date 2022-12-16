/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sylvain
 * Exemple de design pattern Strategy
 */
public class IADeplacement implements DeplacementStrategy {
    private Grille grille;
    
    public IADeplacement(Grille g){
        this.grille = g;
    }
    
    @Override
    public Direction next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
