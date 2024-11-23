package video.store;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            cMain frm = new cMain();
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setSize(800,500);
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        });	
    }
}
