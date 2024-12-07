package MainApp;
/**
 *
 * @author Blesson/Saboteur
 */

// importing all the necessary files
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InfoApp extends JPanel {
    private MainGUI mp;
    private InfoContent infoContent;

    public InfoApp(MainGUI mp) {
        this.mp = mp; // connecting MainGUI
        setLayout(new BorderLayout());
        infoContent = new InfoContent();
        add(infoContent, BorderLayout.CENTER);

        // Creating the bottom panel for buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // center the buttons
        JButton homeBtn = new JButton("Home");
        JButton creditsBtn = new JButton("Credits");
        homeBtn.setPreferredSize(new Dimension(150, 40));
        creditsBtn.setPreferredSize(new Dimension(150, 40));
        // referred to this website: https://stackoverflow.com/questions/53423090/trying-to-put-buttons-on-the-bottom-of-the-screen
        
        // ActionListeners for both buttons
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Going to Home... Restarting app...");          
                    //Restarting the main app, issue with back button so the workaround
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(homeBtn);
                    frame.dispose();
                    MainGUI.main(null);  
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        creditsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Loading credits...");

                // Load the contents of the credits.txt file and display it
                String creditsText = loadCredits();
                infoContent.displayInfo(creditsText, null); // Passing null for image as it's not required here
            }
        });

        //Positioning all Buttons
        bottomPanel.add(homeBtn);
        bottomPanel.add(creditsBtn);
        add(bottomPanel, BorderLayout.SOUTH);
        JPanel topicPanel = new JPanel();
        topicPanel.setLayout(new GridLayout(3, 2));

        
        for (String topic : infoContent.getTopics().keySet()) {
            JButton topicButton = new JButton(topic);
            topicButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Displaying information about " + topic);
                    displayTopicInfo(topic);
                }
            });
            topicPanel.add(topicButton);
        }

        add(topicPanel, BorderLayout.NORTH);
    }

    private void displayTopicInfo(String topic) {
        // Dispaly info regartding the topics
        String infoText = getTopicInfo(topic); // Fetch content
        String imagePath = infoContent.getTopics().get(topic); 
        infoContent.displayInfo(infoText, imagePath);
    }

    private String getTopicInfo(String topic) {
        switch (topic) {
            case "Ocean Pollution":
                return InfoContent.getOceanPollutionInfo();

            case "Ocean Warming":
                return InfoContent.getOceanWarmingInfo();

            default:
                return "Information not available.";
        }
    }
    
    // Displaying info from credits file
    private String loadCredits() {
        StringBuilder creditsText = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/MainApp/credits.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                creditsText.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading credits.";
        }

        return creditsText.toString();
    }


    private void showHomePage() {
        System.out.println("Displaying Home Page...");

        
        mp.showHomePage();
    }
}
//END OF CODE