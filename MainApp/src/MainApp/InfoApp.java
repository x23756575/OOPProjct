package MainApp;

/**
 *
 * @author Blesson/Saboteur
 */

// importing neccessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InfoApp {

    private MainGUI mainGui;
    private JPanel infoPanel;
    
    //initializing Infoapp
    public InfoApp(MainGUI mainGui) {  
        this.mainGui = mainGui;
        this.infoPanel = mainGui.getInfoJPanel();
        setupInfoPanel();
    }

    private void setupInfoPanel() {
        infoPanel.removeAll();
        infoPanel.setLayout(new BorderLayout());
 
        // Displaying the intro from InfoContent
        JLabel introLabel = new JLabel(InfoContent.getIntroText());
        introLabel.setHorizontalAlignment(SwingConstants.CENTER);
        introLabel.setFont(new Font("Arial", Font.BOLD, 20));
        infoPanel.add(introLabel, BorderLayout.NORTH);

        // Main content panel with buttons
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Three buttons
        JButton OWButton = new JButton("Learn about Ocean Warming"); 
        OWButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        OWButton.addActionListener(e -> showDetailedInfo("Ocean Warming")); 
        contentPanel.add(OWButton);
        contentPanel.add(Box.createVerticalStrut(10)); // for spacing
 
        JButton OPButton = new JButton("Learn about Ocean Pollution");
        OPButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        OPButton.addActionListener(e -> showDetailedInfo("Ocean Pollution"));
        contentPanel.add(OPButton); 
        contentPanel.add(Box.createVerticalStrut(10));

        JButton creditsButton = new JButton("Show Credits");
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.addActionListener(e -> showCredits());
        contentPanel.add(creditsButton);
        infoPanel.add(contentPanel, BorderLayout.CENTER);

        // Bottom panel with buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Back button
        JButton backToMenuButton = new JButton("Back to Main Menu");
        backToMenuButton.addActionListener(e -> mainGui.showMainMenu()); 
        bottomPanel.add(backToMenuButton); 
 
        // Suggest edit button
        JButton suggestEditButton = new JButton("Suggest an Edit");
        suggestEditButton.addActionListener(e -> {
            InfoForm infoForm = new InfoForm(); 
            infoForm.setVisible(true); // Opens the InfoForm JFrame 
        });
        bottomPanel.add(suggestEditButton);

        // Add bottom panel to the south 
        infoPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Refresh the panel, to be safe 
        infoPanel.revalidate();
        infoPanel.repaint(); 
    }
    
    // Display detailed information on topics
    private void showDetailedInfo(String topic) { 
        JTextArea infoTextArea = new JTextArea();
        infoTextArea.setEditable(false); // Avoiding edits 
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true); 

        String content = "";
        if (topic.equals("Ocean Warming")) {
            content = InfoContent.getOWContent();
        } 
        else if (topic.equals("Ocean Pollution")) {
            content = InfoContent.getOPContent();
        } 

        infoTextArea.setText(content); 

        JScrollPane scrollPane = new JScrollPane(infoTextArea); 
        scrollPane.setPreferredSize(new Dimension(350, 200));
 
        infoPanel.removeAll(); 
        infoPanel.add(scrollPane, BorderLayout.CENTER);
 
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> setupInfoPanel());
 
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton); 
        infoPanel.add(bottomPanel, BorderLayout.SOUTH);

        infoPanel.revalidate();
        infoPanel.repaint();
    } 
    
    // Displaying credits, first open the pane to display and then load data
    private void showCredits() {
        JTextArea creditsTextArea = new JTextArea();
        creditsTextArea.setEditable(false);
        creditsTextArea.setLineWrap(true);
        creditsTextArea.setWrapStyleWord(true);

        String creditsContent = loadCreditsFromFile();
        creditsTextArea.setText(creditsContent); 

        JScrollPane scrollPane = new JScrollPane(creditsTextArea); 
        scrollPane.setPreferredSize(new Dimension(350, 200));
 
        infoPanel.removeAll(); 
        infoPanel.add(scrollPane, BorderLayout.CENTER);
  
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> setupInfoPanel()); 
 
        JPanel bottomPanel = new JPanel(); 
        bottomPanel.add(backButton);
        infoPanel.add(bottomPanel, BorderLayout.SOUTH);
 
        infoPanel.revalidate();
        infoPanel.repaint(); 
    }
    
    // Load credits(data) from a text file 
    private String loadCreditsFromFile() {
        StringBuilder creditsContent = new StringBuilder();
        try { 
            Path filePath = Paths.get("src/MainApp/credits.txt");  
            if (Files.exists(filePath)) { 
                Files.readAllLines(filePath).forEach(line -> creditsContent.append(line).append("\n"));  
            } 
            else { 
                creditsContent.append("Credits file not found.");
            }  
        }  
        catch (IOException e) {
        }
        
        return creditsContent.toString(); 
    }
}

// The code was created by heavy influence from the slides on moodle, and some online sources:
// https://www.geeksforgeeks.org/
// https://www.w3schools.com/java/


