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
    private JLabel[][] keyboardLabels; // store keyboard keys as image labels

    // constructor
    public TypingApp(MainGUI mp) {
        this.mp = mp;
        TypingLogic tl = new TypingLogic(mp); 
        
        // 2d array for keyboard images
        String[][] keyboardLayout = {
            {"lowercase_q.png", "lowercase_w.png", "lowercase_e.png", "lowercase_r.png", "lowercase_t.png", "lowercase_y.png", "lowercase_u.png", "lowercase_i.png", "lowercase_o.png", "lowercase_p.png"},
            {"lowercase_a.png", "lowercase_s.png", "lowercase_d.png", "lowercase_f.png", "lowercase_g.png", "lowercase_h.png", "lowercase_i.png", "lowercase_j.png", "lowercase_k.png"},
            {"lowercase_z.png", "lowercase_x.png", "lowercase_c.png", "lowercase_v.png", "lowercase_b.png", "lowercase_n.png", "lowercase_m.png"}
        };

        keyboardLabels = new JLabel[keyboardLayout.length][]; // make keyboard label array

        // loop to create labels for each key
        for (int row = 0; row < keyboardLayout.length; row++) {
            keyboardLabels[row] = new JLabel[keyboardLayout[row].length];
            for (int col = 0; col < keyboardLayout[row].length; col++) {
                String fileName = keyboardLayout[row][col]; // get image name
                keyboardLabels[row][col] = createLabel(fileName); // create label for the key
            }
        }

        JPanel gameJPanel = mp.getGameJPanel();
        
        JLabel randomSentenceLabel = tl.typingText();
        randomSentenceLabel.setFont(new Font("arial", Font.BOLD, 20)); // set font for the random sentence
        randomSentenceLabel.setBounds(270, 100, 900, 50); // position the random sentence label
        
        gameJPanel.add(randomSentenceLabel); // add random sentence label
        
        keyboardLayout(); // create keyboard layout
    }

    // method to create label for a key
    private JLabel createLabel(String fileName) {
        String path = "C:\\Users\\samor\\OneDrive\\Documents\\NetBeansProjects\\MainApp\\MainApp\\src\\MainApp\\Images\\" + fileName; // path for images
        File file = new File(path);

        ImageIcon icon;
        if (file.exists()) { // check if file exists
            icon = new ImageIcon(path);
            int width = 50; // set image width
            int height = 50; // set image height
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // resize the image
            icon = new ImageIcon(scaledImg); // create icon with resized image
        } else {
            System.out.println("Image not found: " + path); // print error if file not found
            icon = null;
        }

        JLabel label = new JLabel(icon); // create label with the icon
        label.setPreferredSize(new Dimension(50, 50)); // set label size
        return label;
    }

    // method to set up the keyboard layout
    //write plan for this before code
    private void keyboardLayout() {
        
        


        JPanel gameJPanel = mp.getGameJPanel();

        gameJPanel.setLayout(null); // set layout to null for custom positioning
        

        
        int baseX = 150; // starting x position
        int baseY = 400; // starting y position
        int keySize = 50; // key width and height
        int spacingX = 60; //spacing between the elements
        int spacingY = 60; 
        int[] rowShifts = {0, 40, 90}; //this positions each row directly below eachother because 2nd and row are smaller so they need to be pushed more to the right

        for (int row = 0; row < keyboardLabels. length; row++) {
            int yPos = baseY + (row * spacingY); // y position for the row
            int xStart = baseX + rowShifts[row]; // positionn1 of the each row from the left side across usijng rowshift values

            for (int col = 0; col < keyboardLabels[row].length; col++) {
                JLabel keyLabel = keyboardLabels[row][col];
                int xPos = xStart + (col * spacingX); // the row starts at xStart and moves across each image in the row adding spacingX to change the x positon

                keyLabel.setBounds(xPos, yPos, keySize, keySize); // set key position and size
                gameJPanel.add(keyLabel);
                
            }
        }



        gameJPanel.revalidate(); // refresh the panel
        gameJPanel.repaint(); // repaint the panel
        // Create the background label
JLabel background = new JLabel(new ImageIcon("C:\\Users\\samor\\OneDrive\\Documents\\NetBeansProjects\\MainApp\\MainApp\\src\\MainApp\\Images\\bggg.png"));
background.setBounds(100,350,700,250); // Full panel size

// Add the background first
gameJPanel.add(background);
    }
}
