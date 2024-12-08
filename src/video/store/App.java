package video.store;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePage frm = new HomePage();
            frm.requestFocus();
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setSize(450, 330);
            frm.setResizable(false);
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);

            new Thread(new BackgroundTask(frm)).start();
        });
    }
}

class BackgroundTask implements Runnable {

    private final HomePage frame;

    public BackgroundTask(HomePage frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        try {
            
            Thread.sleep(3000);
            SwingUtilities.invokeLater(() -> {
                
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(frame, "Task was interrupted.", "Error", JOptionPane.ERROR_MESSAGE);
            });
        }
    }
}

