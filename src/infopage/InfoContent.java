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
    private JTextArea displayArea;
    private JLabel imageLabel;
    private JTextArea introArea;  

    public InfoContent() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 900)); // Fixed size for the content panel

        // Title label
        JLabel titleLabel = new JLabel("Life Below Water: The Oceans and Their Challenges", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Small introduction text
        introArea = new JTextArea();
        introArea.setText("This page explores various challenges facing the oceans, including ocean warming, overfishing, pollution, and more. "
                + "Click on the buttons below to learn more about each topic and their impact on marine life and ecosystems.");
        introArea.setEditable(false);
        introArea.setLineWrap(true);
        introArea.setWrapStyleWord(true);
        introArea.setBackground(getBackground());
        introArea.setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane introScrollPane = new JScrollPane(introArea);
        introScrollPane.setPreferredSize(new Dimension(450, 80)); 
        add(introScrollPane, BorderLayout.CENTER);

        // Information text area 
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(450, 150)); 
        add(scrollPane, BorderLayout.EAST);  // Display information

        // Image Label 
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.WEST); 

        // Panel to hold buttons for each section (using GridLayout to organize them)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 5, 5));
        buttonPanel.setPreferredSize(new Dimension(900, 200));  
        
        JButton oceanLifeButton = createButton("Ocean Life");
        JButton oceanTechButton = createButton("Ocean Tech");
        JButton sustainableOceanButton = createButton("Sustainable Ocean");
        JButton oceanPollutionButton = createButton("Ocean Pollution");
        JButton overFishingButton = createButton("Over Fishing");
        JButton oceanWarmingButton = createButton("Ocean Warming");

       
        oceanLifeButton.addActionListener(createInfoButtonListener("Ocean Life", 
                "The ocean is home to a vast array of species, from microscopic plankton to the largest mammals, such as whales. "
                + "Marine ecosystems, like coral reefs and deep-sea habitats, are vital for ocean health, supporting biodiversity. "
                + "Each species, whether it’s a fish, mammal, or invertebrate, plays a critical role in maintaining the balance of ocean life, "
                + "helping regulate the climate, food chains, and the ocean's nutrient cycles.", 
                "/infopage/images/ocean_life.jpg"));

        oceanTechButton.addActionListener(createInfoButtonListener("Ocean Technology", 
                "Ocean technology includes cutting-edge innovations that allow scientists to explore, monitor, and protect the ocean. "
                + "Tools such as underwater drones, remotely operated vehicles (ROVs), and ocean sensors provide critical data on ocean conditions. "
                + "These technologies enhance our understanding of marine ecosystems, helping with tasks like monitoring pollution, tracking marine species, "
                + "and studying climate change impacts through ocean observation systems.", 
                "/infopage/images/ocean_tech.jpg"));

        sustainableOceanButton.addActionListener(createInfoButtonListener("Sustainable Ocean", 
                "Sustainability in the ocean refers to the responsible use of ocean resources without compromising future generations. "
                + "This includes practices like sustainable fishing, aquaculture, and conservation efforts like marine protected areas. "
                + "By prioritizing sustainability, we ensure the preservation of ocean ecosystems, while also securing vital resources such as food and renewable energy.",
                "/infopage/images/sustainable_ocean.jpg"));

        oceanPollutionButton.addActionListener(createInfoButtonListener("Ocean Pollution", 
                "Ocean pollution is a significant threat to marine ecosystems and human health. It includes pollutants like plastics, oil spills, "
                + "chemical runoff, and heavy metals that enter the ocean from industrial, agricultural, and urban sources. "
                + "These pollutants harm marine life, disrupt ecosystems, and contribute to the degradation of coastal areas, requiring urgent solutions.", 
                "/infopage/images/ocean_pollution.jpg"));

        overFishingButton.addActionListener(createInfoButtonListener("Over Fishing", 
                "Overfishing occurs when fish populations are depleted due to excessive harvesting, disrupting marine food chains. "
                + "It can lead to the collapse of fish stocks, loss of biodiversity, and economic instability for communities dependent on fishing. "
                + "Sustainable fishing practices, such as catch limits and protecting breeding areas, are essential to preserve fish populations.", 
                "/infopage/images/over_fishing.jpg"));

        oceanWarmingButton.addActionListener(createInfoButtonListener("Ocean Warming", 
                "Ocean warming refers to the rising temperatures of the ocean caused by climate change. "
                + "Warmer waters impact marine life by disrupting ecosystems, causing coral bleaching, and altering species distribution. "
                + "Rising ocean temperatures also contribute to stronger storms, rising sea levels, and threaten coastal and island communities.", 
                "/infopage/images/ocean_warming.jpg"));



        buttonPanel.add(oceanLifeButton);
        buttonPanel.add(oceanTechButton);
        buttonPanel.add(sustainableOceanButton);
        buttonPanel.add(oceanPollutionButton);
        buttonPanel.add(overFishingButton);
        buttonPanel.add(oceanWarmingButton);

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
    private ActionListener createInfoButtonListener(final String title, final String infoText, final String imagePath) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInfo(title, infoText, imagePath);
            }
        };
    }

    // Method to update the display with the chosen information
    private void displayInfo(String title, String infoText, String imagePath) {
        displayArea.setText(infoText); 
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imageLabel.setText("Error loading image.");
        }
    }

    void setInfo(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void loadInfoFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}