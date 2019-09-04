/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qc.bdeb.TP1;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.*;

/**
 * La classe qui va afficher la barre de menu dans le haut de la page qui
 * contiendra l'option de démarrer ou de quitter.
 * @author charles
 */
public class Toolbar extends JMenuBar {

    private JMenu menuOption; //L'option "Menu"
    private JMenuItem itemDemarrer; //L'option de démarrer le jeu
    private JMenuItem itemQuitter; //L'option de quitter le jeu
    Score score; //le pointage du jeu
    jeuPanel panel; //le panel qui contient les boutons
    jeuThread jeuThread; //l'algorithme pour activer chaques boutons

    /**
     * Constructeur de la barre de menu
     * @param panel le panel qui contient les boutons du jeu
     * @param score le pointage du jeu
     */
    public Toolbar(jeuPanel panel, Score score) {
        menuOption = new JMenu("Menu");
        this.itemDemarrer = new JMenuItem("Démarrer");
        this.itemQuitter = new JMenuItem("Quitter");
        this.panel = panel;
        this.score = score;

        /**
         * Si on clique sur "cliquer"
         */
        itemQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });

        /**
         * Si on clique sur "démarrer"
         */
        itemDemarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String reponse = JOptionPane.showInputDialog
                ("Combien de chances voulez-vous avoir?", 5);
                
                /**
                 * Si démarre le jeu, on va activer l'algorithme dans la classe 
                 * jeuThread
                 */
                try {
                    Score.tourTotal = Integer.parseInt(reponse);
                    Score.pointage = 0;
                    jeuThread = new jeuThread(Score.tourTotal, panel, score);
                    jeuThread.start();
                } catch (NumberFormatException erreur) {
                    System.out.println("Mauvaise reponse");
                }
            }
        });

        //on ajoute les menus dans la barre de menu pour les afficher
        add(menuOption);
        menuOption.add(itemDemarrer);
        menuOption.addSeparator();
        menuOption.add(itemQuitter);
    }
}
