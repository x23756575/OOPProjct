package MainApp;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class TypingApp {
    
    private MainGUI mp;  // Reference to MainGUI
    private String label;
    private ArrayList<JButton> listButtons;  // List to store buttons
    private int width, height;

    // Constructor
    public TypingApp(MainGUI mp){
        this.mp = mp;  // Use the passed MainGUI reference
        listButtons = new ArrayList<>();  // Initialize the button list
        
        // Array of button names
        String[] buttonNames = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", 
                                 "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", 
                                 "X", "C", "V", "B", "N", "M"};
        
        // Create and add buttons to the list
        for(String buttonName : buttonNames){
            createButtons(buttonName);
        }
        
        // Layout the keyboard
        keyboardLayout();
    }

    // Method to create a button and add it to the list
    private void createButtons(String label){
        this.label = label;  // Set the button label
        
        // Create a new button and set its text
        JButton button = new JButton(label);
        
        // Add the button to the list
        listButtons.add(button);
    }

    // Method to lay out the buttons on the panel
    public void keyboardLayout(){
        JPanel gameJPanel = mp.getGameJPanel();  // Get the game panel from MainGUI
        
        // Set a layout manager for the panel
        gameJPanel.setLayout(new FlowLayout());  // Use FlowLayout for a simple horizontal layout
        
        // Add each button from the list to the panel
        for(JButton button : listButtons){
            gameJPanel.add(button);
        }
        
        // Revalidate and repaint the panel to ensure it updates
        gameJPanel.revalidate();
        gameJPanel.repaint();
    }

    // Getter for the label (not used currently, but left in case it's needed)
    public String getLabel(){
        return label;
    }
}
