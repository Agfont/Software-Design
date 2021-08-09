/*

Autors:
* Juan Cano Pradas
* Nil Ballus Riu
* David Rial Fígols

 */

package ub.edu.view;

import ub.edu.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Formulari de registre d'un usuari a la APP, es demana el nom i cognoms, el DNI, l'adreça, l'usuari i la contrassenya.
 * Aquesta classe hereta de JDialog
 */
class FrmRegistre extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel labelNomReal;
    private JLabel labelAdreca;
    private JLabel labelDNI;
    private JLabel labelUsername;
    private JLabel labelPassword1;
    private JLabel labelPassword2;
    private JTextField textNomReal;
    private JTextField textDNI;
    private JTextField textAdreca;
    private JTextField textUsername;
    private JPasswordField textPassword1;
    private JPasswordField textPassword2;
    private Controller controler;

    /**
     * Constructor de la finestra del Registre on es fixa l'aspecte d'aquesta i s'inicialitzen els components
     * @param controler
     */
    protected FrmRegistre(Controller controler) {
        this.controler = controler;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setResizable(false);
        setTitle("REGISTRE D'UN NOU USUARI");
        initComponents();
    }

    /**
     * Mètode que inicialitza tots els components de la GUI del Registre d'usuaris i s'afegeixen els listeners dels events per quan es fa la acció sobre els components.
     */
    private void initComponents() {
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    /**
     * Acció que es realitza quan es prem sobre el botó 'Registrar' per enregistrar un nou usuari si tots els camps són correctes.
     * En cas que salti una excepció es mostra per pantalla el missatge d'error corresponent.
     */
    private void onOK() {
        // add your code here
        try {
            String contrassenya1 = new String(textPassword1.getPassword());
            if (!contrassenya1.equals(new String(textPassword2.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Les contrassenyes no coincideixen!\nTorna a introduir les contrassenyes.", "ERROR AL REGISTRAR", JOptionPane.ERROR_MESSAGE);
                textPassword1.setText("");
                textPassword2.setText("");
            }
            else{
                //TODO -- Registrar Usuari
                controler.createClient(textUsername.getText(), textPassword1.getText());
                String info = "Usuari afegit correctament";
                JOptionPane.showMessageDialog(this, info, "INFORMACIÓ REGISTRE", JOptionPane.INFORMATION_MESSAGE);
                if (info.equals("Usuari afegit correctament"))
                    this.dispose();
                else {
                    textUsername.setText("");
                    textPassword1.setText("");
                    textPassword2.setText("");
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR AL REGISTRAR", JOptionPane.YES_NO_OPTION);
        }
    }

    /**
     * Acció que es realitza quan es prem sobre el botó 'Cancel' per tancar la finestra i tornar al formulari de LogIn, mostra un missatge de confirmació.
     */
    private void onCancel() {
        // add your code here if necessary
        if (JOptionPane.showConfirmDialog(this, "VOLS CANCELAR EL REGISTRE? ", "SORTIR REGISTRE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0)
            this.dispose();
    }
}
