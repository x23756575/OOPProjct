package MainApp;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class TypingApp {
    
    private MainGUI mp;
    private String label;
    private ArrayList<JButton> listButtons;
    private int width, height;

    // Constructor
    public TypingApp(MainGUI mp){
        this.mp = mp;
        listButtons = new ArrayList<>(); 
        
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

    private void createButtons(String label){
        this.label = label;
        
        // Create a new button and set its text
        JButton button = new JButton(label);
        
        // Add the button to the list
        listButtons.add(button);
    }

    // Method to lay out the buttons on the panel
    public void keyboardLayout(){
        JPanel gameJPanel = mp.getGameJPanel();
        
        // Set a layout manager for the panel
        gameJPanel.setLayout(new FlowLayout());
        
        // Add each button from the list to the panel
        for(JButton button : listButtons){
            gameJPanel.add(button);
        }
        
        gameJPanel.revalidate();
        gameJPanel.repaint();
    }

    public String getLabel(){
        return label;
    }
}
