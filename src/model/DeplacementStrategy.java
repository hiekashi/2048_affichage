/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Sylvain
 * Exemple d'implémentation du design Pattern Strategy
 */
public interface DeplacementStrategy extends Serializable {
    public Direction next(); //prochain déplacement
}
