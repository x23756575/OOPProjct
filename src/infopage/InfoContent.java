package infopage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Saboteur
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoContent extends JPanel {
    private JTextArea displayText;
    private JLabel imageLabel;
    private JTextArea introText;  

    public InfoContent() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 900)); 

        // Title label
        JLabel title = new JLabel("Life Below Water: The Oceans and Their Challenges", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        // Small introduction text
        introText = new JTextArea();
        introText.setText("This page explores various challenges facing the oceans, including ocean warming, overfishing, pollution, and more. "
                + "Click on the buttons below to learn more about each topic and their impact on marine life and ecosystems.");
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

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 5, 5));
        buttonPanel.setPreferredSize(new Dimension(900, 200));  
        
        JButton oceanLifeBtn = createButton("Ocean Life");
        JButton oceanTechBtn = createButton("Ocean Tech");
        JButton sustainableOceanBtn = createButton("Sustainable Ocean");
        JButton oceanPollutionBtn = createButton("Ocean Pollution");
        JButton overFishingBtn = createButton("Over Fishing");
        JButton oceanWarmingBtn = createButton("Ocean Warming");

        oceanLifeBtn.addActionListener(createButtonListener("Ocean Life", 
                "The ocean is home to a vast array of species, from microscopic plankton to the largest mammals, such as whales. "
                + "Marine ecosystems, like coral reefs and deep-sea habitats, are vital for ocean health.", 
                "/infopage/images/ocean_life.jpg"));

        oceanTechBtn.addActionListener(createButtonListener("Ocean Technology", 
                "Ocean technology includes innovations like underwater drones and ocean sensors that help scientists explore and protect the ocean.", 
                "/infopage/images/ocean_tech.jpg"));

        sustainableOceanBtn.addActionListener(createButtonListener("Sustainable Ocean", 
                "Sustainability in the ocean involves responsible resource use like sustainable fishing and marine protected areas.", 
                "/infopage/images/sustainable_ocean.jpg"));

        oceanPollutionBtn.addActionListener(createButtonListener("Ocean Pollution", 
                "Ocean pollution, including plastics and oil spills, is a major threat to marine life and ecosystems.", 
                "/infopage/images/ocean_pollution.jpg"));

        overFishingBtn.addActionListener(createButtonListener("Over Fishing", 
                "Overfishing depletes fish populations, disrupting food chains and harming marine biodiversity.", 
                "/infopage/images/over_fishing.jpg"));

        oceanWarmingBtn.addActionListener(createButtonListener("Ocean Warming", 
                "Ocean warming due to climate change is altering marine ecosystems, causing coral bleaching and species migrations.", 
                "/infopage/images/ocean_warming.jpg"));

        buttonPanel.add(oceanLifeBtn);
        buttonPanel.add(oceanTechBtn);
        buttonPanel.add(sustainableOceanBtn);
        buttonPanel.add(oceanPollutionBtn);
        buttonPanel.add(overFishingBtn);
        buttonPanel.add(oceanWarmingBtn);

        add(buttonPanel, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }

    // Helper method to create buttons
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 40));  
        return button;
    }

    // ActionListener generator for each button
    private ActionListener createButtonListener(final String title, final String infoText, final String imagePath) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInfo(title, infoText, imagePath);
            }
        };
    }

    // Method to update the display with the chosen information
    private void displayInfo(String title, String infoText, String imagePath) {
        displayText.setText(infoText); 
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imageLabel.setText("Error loading image.");
        }
    }
}
