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
        setSize(900, 700);  // Fixed size for the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        InfoContent contentPanel = new InfoContent();
        add(contentPanel, BorderLayout.CENTER);

        // Panel for Bottom buttons: Home, Info Home, Suggest an Edit
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());  // Align buttons horizontally
        JButton homeBtn = new JButton("Home");
        JButton infoHomeBtn = new JButton("Information Home");
        JButton changeBtn = new JButton("Suggest an Edit");

        // Set button sizes
        homeBtn.setPreferredSize(new Dimension(150, 40));
        infoHomeBtn.setPreferredSize(new Dimension(150, 40));
        changeBtn.setPreferredSize(new Dimension(150, 40));

        // ActionListeners for buttons
        homeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Navigating to MainApp (Home)..."); 
                showHomePage();
            }
        });

        infoHomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Navigating to Information Home...");
                showInformationHomePage();
            }
        });

        changeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Suggesting a change..."); 
            }
        });

        // Add buttons to the panel
        bottomPanel.add(homeBtn);
        bottomPanel.add(infoHomeBtn);
        bottomPanel.add(changeBtn);

        // Add the panel at the bottom of the frame
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new InfoForm();  
    }

    // Methods to handle button actions
    private void showHomePage() {
        System.out.println("Displaying Home Page...");
    }

    private void showInformationHomePage() {
        System.out.println("Displaying Information Home...");
    }
}

