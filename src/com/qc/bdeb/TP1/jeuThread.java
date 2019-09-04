/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qc.bdeb.TP1;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe thread va contenir l'algorithme qui va s'exécuter quand le jeu
 * démarre. On contient aussi l'algorithme qui va activer les boutons par tour.
 *
 * @author charles
 */
public class jeuThread extends Thread {

    protected Score score;
    protected int nbTour;
    protected jeuPanel panel;
    protected int tourTotal;
    protected Random rand;

    /**
     * On déclare le constructeur pour le thread
     *
     * @param tourTotal le tour total entré par le joueur
     * @param panel le panel contient les boutons du jeu
     * @param score le pointage du jeu
     */
    public jeuThread(int tourTotal, jeuPanel panel, Score score) {
        this.tourTotal = tourTotal;
        this.panel = panel;
        this.score = score;
        this.rand = new Random();
    }

    /**
     * L'algorithme qui va être lancé pour chaque tour
     */
    @Override
    public void run() {
        for (int i = 0; i < tourTotal; i++) {
            try {
                nbTour++;
                panel.enableBoutonAleatoire();
                score.updateText(nbTour);
                sleep(rand.nextInt(750) + 850);
                panel.disableCurrentBouton();
            } catch (InterruptedException ex) {
                Logger.getLogger(jeuThread.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
        score.updateText(nbTour);

    }
}
