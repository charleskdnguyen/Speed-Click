/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qc.bdeb.TP1;

import javax.swing.JLabel;

/**
 * Cette classe permet d'afficher le pointage lors de l'exécution
 * @author charles
 */
public class Score extends JLabel {

    public static int tourTotal;
    public static int nbTour;
    public static int pointage;

    /**
     * affichage standard au début du jeu
     */
    public Score() {
        this.setText("Tour: " + nbTour + "/" + tourTotal 
                + ". Score actuel:" + pointage);
    }

    /**
     * Fait une mise à jour du pointage à chaque tour
     * @param nbTour le nombre de tour entré par l'utilisateur
     */
    void updateText(int nbTour) {
        this.setText("Tour: " + nbTour + "/" + tourTotal 
                + ". Score actuel:" + pointage);
    }
}
