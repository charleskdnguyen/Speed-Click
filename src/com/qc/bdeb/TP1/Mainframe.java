/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qc.bdeb.TP1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * La classe Mainframe va contenir le cadre du jeu, la panels de boutons et la
 * barre de menu pour démarrer ou quitter le jeu
 * @author Charles
 */
public class Mainframe extends JFrame {

    private final Toolbar toolbar;
    private final jeuPanel panel;
    private final Score score;

    /**
     * Le cadre du jeu qui va contenir tout les aspects pour former le jeu
     */
    public Mainframe() {
        //Titre du cadre de jeu
        super("TP1");
        setLayout(new BorderLayout());

        //Panel ou on crée les boutons
        panel = new jeuPanel();
        add(panel, BorderLayout.CENTER);

        //Label ou on affiche le pointage du jeu
        score = new Score();
        JPanel panelPointage = new JPanel();
        panelPointage.add(score);
        add(panelPointage, BorderLayout.SOUTH);

        //Barre de menu du jeu
        toolbar = new Toolbar(panel, score);
        setJMenuBar(toolbar);

        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
