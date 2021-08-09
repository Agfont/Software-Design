/*

Autors:
* Juan Cano Pradas
* Nil Ballus Riu
* David Rial Fígols

 */

package ub.edu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Finestra amb la barra de reproducció d'un episodi. Aquesta classe hereta de JDialog
 */
class FormReproduccio extends JDialog {
    private JPanel jPanel;
    private JProgressBar progressBar;
    private Timer timer;
    private ActionListener actionListener;
    private int duracioVisualitzacio;
    private int duracioVisualitzada;
    private String serie;
    private int numTemporada;
    private String episodi;

    /**
     * Constructor de la classe
     * @param serie identificador de la sèrie de l'episodi a reproduir
     * @param numTemporada número de temporada de l'episodi a reproduir
     * @param episodi títol de l'episodi a reproduir
     * @param duracioEpisodi duració de l'episodi a reproduir
     * @param duracioVisualitzada duració ja visualitzada anteriorment de l'episodi a reproduir
     */
    protected FormReproduccio(String serie, int numTemporada, String episodi, int duracioEpisodi, int duracioVisualitzada) {
        duracioVisualitzacio = duracioEpisodi;
        this.duracioVisualitzada = duracioVisualitzada;
        this.serie = serie;
        this.numTemporada = numTemporada;
        this.episodi = episodi;
        initComponents();
        setResizable(false);
        setTitle("Reproducció");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    /**
     * Mètode que inicialitza tots els components de la GUI de FormReproduccio i s'afegeixen els listeners dels events per quan es fa l'acció sobre els diferents components de Java.
     */
    private void initComponents() {
        add(jPanel);
        setModal(true);
        setMinimumSize(new Dimension(300,300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(WindowEvent evt) { formWindowClosing(evt, serie, numTemporada, episodi);
            }
        });
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
    }

    /**
     * Mètode que serveix per començar a reproduir l'episodi una vegada s'ha obert la finestra de reproducció
     * @param evt event que detecta quan s'obra la finestra
     */
    private void formWindowOpened(WindowEvent evt) {
        progressBar.setValue((duracioVisualitzada*100)/duracioVisualitzacio);
        int delay = (duracioVisualitzacio*1000)/100;
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progressBar.getValue() < 100)
                    progressBar.setValue(progressBar.getValue() + 1);
                else {
                    formWindowClosing(evt, serie, numTemporada, episodi);
                }
            }
        };
        this.timer = new Timer(delay, actionListener);
        timer.start();
    }

    /**
     * Mètode que es crida quan es tanca la finestra de reproducció
     * @param evt event del mètode
     * @param serie identificador de la sèrie de l'episodi a reproduir
     * @param numTemporada número de temporada de l'episodi a reproduir
     * @param episodi títol de l'episodi a reproduir
     */
    private void formWindowClosing(WindowEvent evt, String serie, int numTemporada, String episodi) {
        timer.stop();
        int tempsVisualitzacio = (progressBar.getValue()*duracioVisualitzacio)/100;
        //TODO Cal cridar a Controller per guardar l'estat de la visualització
        String estat = "Episodi visualitzat";
        JOptionPane.showMessageDialog(jPanel, estat);
        dispose();
    }


}
