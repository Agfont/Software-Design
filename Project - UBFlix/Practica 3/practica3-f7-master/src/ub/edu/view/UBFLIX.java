package ub.edu.view;

/* Interfície Gràfica desenvolupada per: Nils Ballús, Joan Cano, David Rial i Miquel Guiot */

import ub.edu.controller.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/*
 * GUI bàsica de l'app UBFLIX on es mostraran les diferents llistes corresponent a cada client que hagi realitzat el Log In.
 * Aquesta classe hereta de JFrame i és la vista principal de l'aplicació.
 */
public class UBFLIX extends JFrame{

    private JPanel jPanel;
    private JTabbedPane llistes;
    private JPanel fieldAll;
    private JPanel fieldWatchNext;
    private JPanel fieldWatched;
    private JPanel fieldNotStarted;
    private JList listAll;
    private JList listMyList;
    private JList listWatched;
    private JList listContinueWatching;
    private JTable tableTopVisualitzacions;
    private JTable tableTopValoracions;
    private JLabel labelTopVisualitzacions;
    private JLabel labelTopValoracions;
    private JButton btnTancarSessio;
    private JButton btnCrearUsuari;
    private JButton btnAfegirMyList;
    private JComboBox comboBoxValorar;
    //Afegits manualment
    private HashMap<String, JPopupMenu> popupMenuTemporades;
    private DefaultTableModel tableModelVis;
    private DefaultTableModel tableModelVal;
    private Controller controler;


    /**
     * Constructor de la classe UBFLIX que crida initComponents()
     * @param controler
     */
    public UBFLIX(Controller controler){
        super("UBFLIX");
        this.controler = controler;
        initComponents();
        this.setVisible(true);
    }

    /**
     * Mètode que inicialitza tots els components de la GUI de l'APP STUB i s'afegeixen els listeners dels events per quan es fa l'acció sobre els diferents components de Java.
     */
    private void initComponents(){
        add(jPanel);
        setSize(800,700);
        setMinimumSize(new Dimension(800,700));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        btnTancarSessio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ferLogIn();
            }
        });
        btnAfegirMyList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel, "Serie afegida a My List!");
            }
        });
        btnCrearUsuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mirar si el cliente ya tiene asociado 5 usuarios
                //controler.canCreateUsers(String name, String passw)
                userActionPerformed();
            }
        });
        listAll.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                mostrarPopupMenuTemporades(listAll, fieldAll);
            }
        });
        listMyList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                mostrarPopupMenuTemporades(listMyList, fieldWatchNext);
            }
        });
        listWatched.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                mostrarPopupMenuTemporades(listWatched, fieldWatched);
            }
        });
        listContinueWatching.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                mostrarPopupMenuTemporades(listContinueWatching, fieldNotStarted);
            }
        });
        popupMenuTemporades = new HashMap<>();
        inicialitzarLlistaTopVisualitzacions();
        inicialitzarLlistaTopValoracions();
    }

    /**
     * Mètode que serveix per inicialitzar el Top10 de sèries més visualitzades
     */
    private void inicialitzarLlistaTopVisualitzacions() {
        tableModelVis = new DefaultTableModel(new Object[][]{}, new Object[]{"nomSerie","visualitzacions"}){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableTopVisualitzacions.setModel(tableModelVis);
        tableTopVisualitzacions.setShowGrid(false);
        tableTopVisualitzacions.setFocusable(false);
        tableTopVisualitzacions.setRowSelectionAllowed(false);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tableTopVisualitzacions.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
    }

    private void userActionPerformed() {
        FormUser dialog = new FormUser();
        dialog.pack();
        dialog.setVisible(true);
    }

    /**
     * Mètode que serveix per inicialitzar el top10 de sèries més ben valorades
     */
    private void inicialitzarLlistaTopValoracions() {
        tableModelVal = new DefaultTableModel(new Object[][]{}, new Object[]{"nomSerie","valoracio"}){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableTopValoracions.setModel(tableModelVal);
        tableTopValoracions.setFocusable(false);
        tableTopValoracions.setRowSelectionAllowed(false);
        tableTopValoracions.setShowGrid(false);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tableTopValoracions.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
    }

    /**
     * Mètode que serveix per mostrar les temporades disponibles d'una sèrie concreta
     * @param llista llista que conté la sèrie seleccionada
     * @param panel panel de la vista que conté les llistes
     */
    private void mostrarPopupMenuTemporades(JList llista, JPanel panel) {
        int index = llista.getSelectedIndex();
        Object element = llista.getSelectedValue();
        llista.removeSelectionInterval(llista.getLastVisibleIndex()+1, llista.getLastVisibleIndex()+1);
        if (popupMenuTemporades.get(llista.getSelectedValue()) != null)
            mostrarTemporades(element, index, panel);
    }

    /**
     * Mètode que mostra les diferents temporades de cada sèrie
     * @param serie sèrie de la qual s'han de mostrar les temporades
     * @param index índex de la sèrie seleccionada
     */
    private void mostrarTemporades(Object serie, int index, JPanel panel) {
        String s = (String) serie;
        JPopupMenu pm = popupMenuTemporades.get(s);
        pm.show(panel, panel.getWidth()/2, index*18);
    }

    /**
     * Mètode que fa visible el formulari de LogIn
     */
    private void ferLogIn() {
        jPanel.setVisible(false);
        FrmLogIn dialog = new FrmLogIn(controler);
        dialog.pack();
        dialog.setVisible(true);
        jPanel.setVisible(true);
        refreshLlistes();
    }

    /**
     * Mètode que es crida quan s'obre la finestra i crida a ferLogIn()
     * @param evt event que es dóna a l'obrir l'aplicació
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        refreshListAll();
        ferLogIn();
    }

    /**
     * Mètode que es crida quan es tanca la finestra, fet click sobre la 'x' amb missatge de confirmació de sortida.
     * @param evt event que es dóna al tancar la finestra
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        if (JOptionPane.showConfirmDialog(this, "VOLS SORTIR? ", "SORTIR APP", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0)
            System.exit(0);
    }

    /**
     * Mètode que actualitza les sèries del catàleg
     */
    private void refreshListAll() {
        //TODO Cal cridar a Controller per refescar les series
        String[] series = controler.llistarCataleg().toArray(new String[0]);
        listAll.setListData(series);
        refreshTemporades(series);
    }

    /**
     * Mètode que serveix per actualitzar les temporades de les sèries passades per paràmetres
     * @param series sèries de les quals s'han d'actualitzar les temporades
     */
    private void refreshTemporades(String[] series) {
        popupMenuTemporades.clear();
        for (String serie: series) {
            JPopupMenu s = new JPopupMenu();
            //TODO Cal cridar a Controller per refescar les temporades
            String[] temporades = controler.getTemporades(serie).toArray(new String[0]);
            for (String temporada: temporades) {
                JMenu temp = new JMenu("Temporada " + temporada);
                refreshEpisodis(serie, temporada, temp);
                s.add(temp);
            }
            popupMenuTemporades.put(serie, s);
        }
    }

    /**
     * Mètode que serveix per actualitzar els episodis de la temporada de la sèrie indicats per paràmetres
     * @param serie sèrie de la qual s'ha d'actualitzar els episodis
     * @param temporada temporadad de la qual s'ha d'actualitzar els episodis
     * @param jm JMenu de l'episodi
     */
    private void refreshEpisodis(String serie, String temporada, JMenu jm) {
        //TODO Cal cridar a Controller per refescar els episodis
        String[] episodis = controler.getEpisodis(serie,temporada).toArray(new String[0]);
        for (String episodi: episodis) {
            System.out.println(episodi);
            String idSerie = "Id Serie";
            int numTemporada = Integer.parseInt(temporada);
            int duracio = 30;
            int duracioVisualitzada = 0;
            //TODO Cal cridar a Controller per obtenir les descripcions
            controler.detallsSerie(serie);
            String descripcio = "Descripcio de l'episodi";
            JMenuItem ep = new JMenuItem(episodi);
            ep.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    onEpisodi(idSerie, numTemporada, episodi, duracio, duracioVisualitzada, descripcio);
                }
            });
            jm.add(ep);
        }
    }

    /**
     * Mètode que serveix per actualitzar totes les llistes de la vista
     */
    private void refreshLlistes() {
        String clientName = controler.getCurrentClient();
        String[] usuaris = controler.getUsers(clientName).toArray(new String[0]);
        comboBoxValorar.removeAllItems();
        for (int i = 0; i < usuaris.length; i++) {
            comboBoxValorar.addItem(usuaris[i]);
        }
        int index = comboBoxValorar.getSelectedIndex();
        controler.setCurrentUser((String) comboBoxValorar.getItemAt(index));
        String userName = controler.getCurrentUser();
        refreshWatched(clientName, userName);
        refreshMyList(clientName, userName);
        refreshContinueWatching(clientName, userName);
        refreshTopValoracions(clientName, userName);
        refreshTopVisualitzacions(clientName, userName);
    }

    /**
     * Mètode que actualitza les sèries de la llista MyList
     * @param clientName
     * @param userName
     */
    private void refreshMyList(String clientName, String userName) {
        //TODO Cal cridar a Controller per refescar les series
        String[] series = controler.getMyList(clientName, userName).toArray(new String[0]);
        listMyList.setListData(series);
    }

    /**
     * Mètode que actualitza les sèries de la llista Watched
     * @param clientName
     * @param userName
     */
    private void refreshWatched(String clientName, String userName) {
        //TODO Cal cridar a Controller per refescar les series
        String[] series = controler.getWatchedList(clientName, userName).toArray(new String[0]);
        listWatched.setListData(series);
    }

    /**
     * Mètode que actualitza les sèries de la llista ContinueWatching
     * @param clientName
     * @param userName
     */
    private void refreshContinueWatching(String clientName, String userName) {
        //TODO Cal cridar a Controller per refescar les series
        String[] series = controler.getContinueWatchingList(clientName, userName).toArray(new String[0]);
        listContinueWatching.setListData(series);
    }

    /**
     * Mètode que actualitza les sèries del top10 de sèries més ben valorades
     * @param clientName
     * @param userName
     */
    private void refreshTopValoracions(String clientName, String userName) {
        //Fem el clear de la llista del top 10 de valoracions
        int numRows = tableModelVal.getRowCount();
        for (int i = numRows - 1; i >= 0; i--)
            tableModelVal.removeRow(i);
        //TODO Cal cridar a Controller per refescar les series
        String [] topTenVal = controler.getMostLikedSeries();
        for (String serie: topTenVal) {
            tableModelVal.addRow(new String[]{serie, String.format("%.2f", topTenVal)});
        }
    }

    /**
     * Mètode que actualitza les sèries del top10 de sèries més visualitzades
     * @param clientName
     * @param userName
     */
    private void refreshTopVisualitzacions(String clientName, String userName) {
        //Fem el clear de la llista del top 10 de visualitzacions
        int numRows = tableModelVis.getRowCount();
        for (int i = numRows - 1; i >= 0; i--)
            tableModelVis.removeRow(i);
        //TODO Cal cridar a Controller per refescar les series
        String [] topTenVisualitzacions = controler.getMostWatchedSeries();
        for (String serie: topTenVisualitzacions) {
            tableModelVal.addRow(new String[]{serie, String.format("%.2f", topTenVisualitzacions)});
        }
    }

    /**
     * Mètode que serveix per obrir la finestra amb tota la informació i opcions disponibles d'un episodi seleccionat
     * @param idSerie identificador de la sèrie de l'episodi
     * @param temporada número de temporada de l'episodi
     * @param episodi títol de l'episodi seleccionat
     * @param duracio duració de l'episodi seleccionat
     * @param duracioVisualitzada duració ja visualitzada pel client de l'episodi seleccionat
     * @param descripcio descripció de l'episodi seleccionat
     */
    private void onEpisodi(String idSerie, int temporada, String episodi, int duracio, int duracioVisualitzada, String descripcio) {
        FormEpisodi dialog = new FormEpisodi(controler, idSerie, temporada, episodi, duracio, descripcio);
        dialog.pack();
        dialog.setVisible(true);
    }

}
