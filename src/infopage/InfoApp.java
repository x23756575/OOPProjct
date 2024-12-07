package MainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InfoApp extends JPanel {
    private MainGUI mp;
    private InfoContent infoContent;

    // Constructor accepting MainGUI object
    public InfoApp(MainGUI mp) {
        this.mp = mp;
        setLayout(new BorderLayout());

        // Initialize InfoContent
        infoContent = new InfoContent();
        add(infoContent, BorderLayout.CENTER);

        // Bottom Panel for buttons: Home and Back
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout()); // Align buttons horizontally
        JButton homeBtn = new JButton("Home");
        JButton backBtn = new JButton("Back");

        // Set button sizes
        homeBtn.setPreferredSize(new Dimension(150, 40));
        backBtn.setPreferredSize(new Dimension(150, 40));

        // ActionListeners for buttons
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going to Home..."); 
                showHomePage();
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going back...");
                // Use the MainGUI's showHomePage() method to navigate back
                mp.showHomePage();  // This will call the method in MainGUI to switch to the home page
            }
        });

        // Add buttons to the panel
        bottomPanel.add(homeBtn);
        bottomPanel.add(backBtn);

        // Add the panel at the bottom of the frame
        add(bottomPanel, BorderLayout.SOUTH);

        // Dynamically add topic buttons to the panel
        JPanel topicPanel = new JPanel();
        topicPanel.setLayout(new GridLayout(3, 2)); // Adjust layout depending on the number of topics

        // Example topics and their image paths
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
        String infoText = "Detailed information about " + topic; // Replace with actual content
        String imagePath = infoContent.getTopics().get(topic);
        infoContent.displayInfo(infoText, imagePath);
    }

    private void showHomePage() {
        System.out.println("Displaying Home Page...");

        // Use the existing showHomePage() method from MainGUI
        mp.showHomePage();
    }
}

