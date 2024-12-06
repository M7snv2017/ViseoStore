package video.store;

/**
 *
 * @author Mustafa
 */
import java.awt.*;
import javax.swing.*;

public class VideoInfoFrame extends JFrame {
    public VideoInfoFrame (Video video) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(330, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));   

        JLabel lbl = new JLabel("Video Details", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(lbl, BorderLayout.NORTH);

        JLabel img = new JLabel();
        try {
            ImageIcon icn = video.getImage();
            Image image = icn.getImage();
            Image newimg = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            img.setHorizontalAlignment(SwingConstants.CENTER);
            img.setVerticalAlignment(SwingConstants.CENTER);
            icn = new ImageIcon(newimg);
            img.setIcon(icn);
        } catch (Exception e) {
            img.setHorizontalAlignment(SwingConstants.CENTER);
            img.setText("Cannot display image");
        }
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(img, BorderLayout.CENTER);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout(10,10));
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(3, 2, 5, 5)); // 3 rows, 2 columns with gaps

        // Add rows of labels and placeholders
        detailsPanel.add(new JLabel("Title: "+video.getTitle()));
        detailsPanel.add(new JLabel("Director: "+video.getDirector()));
        detailsPanel.add(new JLabel("Genre: "+video.getGenre()));
        detailsPanel.add(new JLabel("Release Year: "+video.getYear()));
        detailsPanel.add(new JLabel("Age Group: "+video.getAgeGroup()));
        detailsPanel.add(new JLabel("Purchase Frequency: "+video.getPurchaseFrequency()));
        containerPanel.add(detailsPanel, BorderLayout.NORTH);

        JTextArea synopsisArea = new JTextArea(5, 20);
        synopsisArea.setLineWrap(true);
        synopsisArea.setWrapStyleWord(true);
        synopsisArea.setEditable(false);
        synopsisArea.setText("Synopsis: "+video.getSynopsis());
        JScrollPane synopsisScrollPane = new JScrollPane(synopsisArea);
        //synopsisScrollPane.setPreferredSize(new Dimension(400, 80));
        containerPanel.add(synopsisScrollPane, BorderLayout.CENTER);

        JLabel pricelbl = new JLabel("Price: $"+video.getPrice(), SwingConstants.CENTER);
        pricelbl.setFont(new Font("Arial", Font.BOLD, 16));
        containerPanel.add(pricelbl, BorderLayout.SOUTH);

        this.add(containerPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}


