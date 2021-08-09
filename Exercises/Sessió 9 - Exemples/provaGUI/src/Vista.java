import javax.swing.*;

public class Vista extends JFrame {
    Principal p;
    public Vista() {
        this.setTitle("Prova GUI");
        p = new Principal();
        this.add(p);

    }

    public void run() {
        p.setVisible(true);
        pack();
        setVisible(true);
    }



}
