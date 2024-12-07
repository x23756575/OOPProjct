package MainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel {
    private InfoContent infoContent;

    public InfoPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        infoContent = new InfoContent();
        add(infoContent, BorderLayout.CENTER);

        // Panel for Bottom buttons: Home, Back
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());  // Align buttons horizontally
        JButton homeBtn = new JButton("Home");
        JButton backBtn = new JButton("Back");

        // Set button sizes
        homeBtn.setPreferredSize(new Dimension(150, 40));
        backBtn.setPreferredSize(new Dimension(150, 40));

        // ActionListeners for buttons
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Navigating to MainApp (Home)..."); 
                showHomePage();
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going back to Information Home...");
                showInformationHomePage();
            }
        });

        // Add buttons to the panel
        bottomPanel.add(homeBtn);
        bottomPanel.add(backBtn);

        // Add the panel at the bottom of the frame
        add(bottomPanel, BorderLayout.SOUTH);

        // Adding buttons for topics dynamically
        JPanel topicPanel = new JPanel();
        topicPanel.setLayout(new GridLayout(3, 2)); // Adjust the layout depending on the number of topics

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
        // Code to show home page
    }

    private void showInformationHomePage() {
        System.out.println("Displaying Information Home...");
        // Reset content and show home page of the information
        infoContent.getDisplayText().setText("Select a topic to learn more.");
        infoContent.getImageLabel().setIcon(null);
    }
}
