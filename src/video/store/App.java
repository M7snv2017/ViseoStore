package video.store;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePage frm = new HomePage();
            frm.requestFocus();
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setSize(450,330);
            frm.setResizable(false);
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        });	
    }
}
