package MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InfoContent extends JPanel {
    private JTextArea displayText;
    private JLabel imageLabel;
    private JTextArea introText;
    private Map<String, String> topics;

    public InfoContent() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 700));

        // Title label
        JLabel title = new JLabel("Life Below Water: The Oceans and Their Challenges", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        // Small introduction text
        introText = new JTextArea();
        introText.setText("This page explores various challenges facing the oceans, including ocean warming, overfishing, pollution, and more.");
        introText.setEditable(false);
        introText.setLineWrap(true);
        introText.setWrapStyleWord(true);
        introText.setBackground(getBackground());
        introText.setFont(new Font("Arial", Font.BOLD, 14));
        JScrollPane introScroll = new JScrollPane(introText);
        introScroll.setPreferredSize(new Dimension(450, 80));
        add(introScroll, BorderLayout.CENTER);

        // Information text area 
        displayText = new JTextArea();
        displayText.setEditable(false);
        displayText.setLineWrap(true);
        displayText.setWrapStyleWord(true);
        JScrollPane displayScroll = new JScrollPane(displayText);
        displayScroll.setPreferredSize(new Dimension(450, 150));
        add(displayScroll, BorderLayout.EAST);

        // Image Label 
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.WEST);

        // Initialize the topics with some example data
        topics = new HashMap<>();
        topics.put("Ocean Warming", "/images/ocean_warming.jpg");
        topics.put("Overfishing", "/images/overfishing.jpg");
        topics.put("Pollution", "/images/pollution.jpg");
    }

    // Method to update the display with the chosen information
    public void displayInfo(String infoText, String imagePath) {
        displayText.setText(infoText);
        try {
            // Update this to your full path
            String fullImagePath = "D:\\NCI\\Year 2\\Semester 1\\Obj Oriented Prog\\MainApp\\src\\MainApp\\images\\" + imagePath;
            ImageIcon icon = new ImageIcon(fullImagePath);
            Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imageLabel.setText("Error loading image.");
        }
    }

    // Getters for the components to be used in InfoApp
    public JTextArea getDisplayText() {
        return displayText;
    }

    public JTextArea getIntroText() {
        return introText;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    // Get the topics (for dynamically creating buttons)
    public Map<String, String> getTopics() {
        return topics;
    }
}
