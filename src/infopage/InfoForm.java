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

public class InfoForm extends JFrame {
    public InfoForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("InfoApp");
        setSize(900, 900);  // Fixed size for the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        InfoContent infoContentPanel = new InfoContent();
        add(infoContentPanel, BorderLayout.CENTER);

        // Panel for Bottom buttons: Home, Info Home, Suggest an Edit
        JPanel bottomButtonPanel = new JPanel();
        bottomButtonPanel.setLayout(new FlowLayout());  // Align buttons horizontally
        JButton homeButton = new JButton("Home");
        JButton infoHomeButton = new JButton("Information Home");
        JButton changeButton = new JButton("Suggest an Edit");

        // Set button sizes
        homeButton.setPreferredSize(new Dimension(150, 40));
        infoHomeButton.setPreferredSize(new Dimension(150, 40));
        changeButton.setPreferredSize(new Dimension(150, 40));

        // ActionListeners for buttons
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Navigating to MainApp (Home)...");
                showHomePage();
            }
        });

        infoHomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Navigating to Information Home...");
                showInformationHomePage();
            }
        });

        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Suggesting a change..."); // Still under development, testing
            }
        });

        // Add buttons to the panel
        bottomButtonPanel.add(homeButton);
        bottomButtonPanel.add(infoHomeButton);
        bottomButtonPanel.add(changeButton);

        // Add the panel at the bottom of the frame
        add(bottomButtonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new InfoForm();  
    }

    // Method to handle button actions
    private void showHomePage() {
        System.out.println("Displaying Home Page...");
    }

    private void showInformationHomePage() {
        System.out.println("Displaying Information Home...");
    }
}
