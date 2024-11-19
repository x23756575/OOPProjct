package MainApp;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

public class TypingApp {

    private MainGUI mp;
    
    private JLabel[][] keyboardLabels; // To store keyboard keys as image labels
    
    // Constructor
    public TypingApp(MainGUI mp) {
        this.mp = mp;
        TypingLogic tl = new TypingLogic(mp); 
        // 2D array representing the keyboard layout
        String[][] keyboardLayout = {
            {"lowercase_q.png", "lowercase_w.png", "lowercase_e.png", "lowercase_r.png", "lowercase_t.png", "lowercase_y.png", "lowercase_u.png", "lowercase_i.png", "lowercase_o.png", "lowercase_p.png"},
            {"lowercase_a.png", "lowercase_s.png", "lowercase_d.png", "lowercase_f.png", "lowercase_g.png", "lowercase_h.png", "lowercase_i.png", "lowercase_j.png", "lowercase_k.png"},
            {"lowercase_z.png", "lowercase_x.png", "lowercase_c.png", "lowercase_v.png", "lowercase_b.png", "lowercase_n.png", "lowercase_m.png"}
        };
 
        // Initialize the keyboardLabels array
        keyboardLabels = new JLabel[keyboardLayout.length][];

        // Create labels for the keyboard
        for (int row = 0; row < keyboardLayout.length; row++) {
            // Initialize the column size for each row in the 2D array
            keyboardLabels[row] = new JLabel[keyboardLayout[row].length];

            for (int col = 0; col < keyboardLayout[row].length; col++) {
                String fileName = keyboardLayout[row][col]; // Get the file name
                keyboardLabels[row][col] = createLabel(fileName); // Store label in the array
            }
        }
       // Create TypingLogic instance
 // Get the random sentence as a JLabel

       JPanel gameJPanel = mp.getGameJPanel();
       JLabel randomSentenceLabel = tl.typingText();
       randomSentenceLabel.setFont(new Font("arial", Font.BOLD, 20));
       randomSentenceLabel.setBounds(270, 100, 900, 50);
       gameJPanel.add(randomSentenceLabel);
       
       keyboardLayout();
    }


    // Method to create a JLabel with an image
    private JLabel createLabel(String fileName) {
        String path = "C:\\Users\\samor\\OneDrive\\Documents\\NetBeansProjects\\MainApp\\MainApp\\src\\MainApp\\Images\\" + fileName;
        File file = new File(path);

        ImageIcon icon;
        if (file.exists()) {
            icon = new ImageIcon(path); // Use the image file
        int width = 50; // Set the width you want
        int height = 50; // Set the height you want
        Image img = icon.getImage(); // Get the Image from ImageIcon
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        icon = new ImageIcon(scaledImg); // Create a new ImageIcon from the resized image
        } else {
            System.out.println("Image not found: " + path); // Log missing file
            icon = null; 
        }

        // Create JLabel with the icon
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(50, 50)); // Adjust size if needed

        return label;
    }

    // Method to lay out the keyboard using a grid layout
    private void keyboardLayout() {
        JPanel gameJPanel = mp.getGameJPanel();

        // Set a GridLayout for the keyboard
        gameJPanel.setLayout(new GridLayout(keyboardLabels.length, 1, 5, 5)); // 5px gap

        // Add each row of labels to the panel
        for (JLabel[] row : keyboardLabels) {
            JPanel rowPanel = new JPanel(new GridLayout(1, row.length, 5, 5)); // Sub-panel for each row
            for (JLabel label : row) {
                rowPanel.add(label);
            }
            gameJPanel.add(rowPanel); // Add the row panel to the main panel
        }
                gameJPanel.setLayout(null);

        int xOffset = 150; // X position offset for the first image
        int yOffset = 400; // Y position offset for the first row
        int keyWidth = 50; // Width of each image
        int keyHeight = 50; // Height of each image
        int xSpacing = 60; // Horizontal spacing between image
        int ySpacing = 60; // Vertical spacing between rows

        // Loop through each row and place each label at a fixed position
        for (int row = 0; row < keyboardLabels.length; row++) {
            int yPos = yOffset + (row * ySpacing); // Calculate the Y position for each row
            int rowOffset = xOffset;
            if(row == 1){
                rowOffset = rowOffset + 40;
            }else if(row == 2){
                rowOffset = rowOffset + 90;
            }
            for (int col = 0; col < keyboardLabels[row].length; col++) {
                JLabel keyLabel = keyboardLabels[row][col];
                int xPos = rowOffset + (col * xSpacing); // Calculate the X position for each key
                
                // Set the bounds (x, y, width, height) for each key
                keyLabel.setBounds(xPos, yPos, keyWidth, keyHeight);

                // Add the label to the game panel
                gameJPanel.add(keyLabel);
            }
        }
        gameJPanel.revalidate();
        gameJPanel.repaint();
    }
}