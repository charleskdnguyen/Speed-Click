/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qc.bdeb.TP1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * La classe jeuPanel contient les boutons du jeu et l'algorithme qui va activer
 * chaques boutons aléatoirement.
 * @author charles
 */
public class jeuPanel extends JPanel {

    protected JButton[][] tabButton; //déclaration du tableau matrice de boutons
    protected int horizontale; //valeur X généré aléatoirement
    protected int verticale; //valeur Y généré aléatoirement
    Icon image = new ImageIcon("tp1.png"); //déclaration de l'image des boutons
    protected Random rand; //la valeur aléatoire qui sera généré

    /**
     * L'affichage des boutons dans le panel
     */
    public jeuPanel() {
        rand = new Random();

        tabButton = new JButton[5][5];

        for (int i = 0; i < tabButton.length; i++) {
            for (int j = 0; j < tabButton[i].length; j++) {
                tabButton[i][j] = new JButton(image);
                add(tabButton[i][j]);
                tabButton[i][j].setEnabled(false);
                tabButton[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Score.pointage++;
                        JButton btn = (JButton) e.getSource();
                        btn.setEnabled(false);
                    }
                });
            }
        }
    }

    /**
     * Algorithme qui va générer et activer les boutons aléatoirement
     */
    public void enableBoutonAleatoire() {
        int originalH = horizontale;
        int originalV = verticale;

        do {
            horizontale = rand.nextInt(4);
        } while (horizontale == originalH);

        do {
            verticale = rand.nextInt(4);
        } while (originalV == verticale);

        tabButton[horizontale][verticale].setEnabled(true);
    }

    /**
     * L'algorithme qui va désactiver le bouton après qu'on le clique
     */
    public void disableCurrentBouton() {
        tabButton[horizontale][verticale].setEnabled(false);
    }
}
