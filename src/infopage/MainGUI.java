package MainApp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.PopupMenu;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author temuulen
 */

public class MainGUI extends javax.swing.JFrame {

    String fileName;
    private JLabel header = new JLabel("Life Below Water");
    private JLabel infoSentence = new JLabel("<html>This is an information page talking about ocean warming, ocean pollution and overfishing and more.<br> Click on the icon to learn more about these important topics in further detail<html> ");
    private JLabel quizSentence = new JLabel("<html>This quiz is designed to explore the topic of overwarming. Challenge yourself <br>to test your understanding on over warming, and give an insight to this ongoing issue.<html>");
    private JLabel gameSentence = new JLabel("<html>Take this typing test to test your typing skills while learning about water pollution<html>");

    private JLabel infoHeader = new JLabel("Information Page");
    private JLabel quizHeader = new JLabel("Quiz Page");
    private JLabel gameHeader = new JLabel("Game Page");
  
    public MainGUI() {
        initComponents();
        
        header.setBounds(300,20,400,70);

        infoSentence.setBounds(300, 150,800,150);
        quizSentence.setBounds(110,120,500,500);
        gameSentence.setBounds(310,250,500,500);

        infoHeader.setBounds(450,100,800,150);
        quizHeader.setBounds(310,60,500,500);
        gameHeader.setBounds(470,200,500,500);

        infoHeader.setFont(new Font("arial", Font.BOLD, 25));
        quizHeader.setFont(new Font("arial", Font.BOLD, 25));
        gameHeader.setFont(new Font("arial", Font.BOLD, 25));

        header.setFont(new Font("arial", Font.BOLD, 40));

        mainJPanel.add(infoHeader);
        mainJPanel.add(quizHeader);
        mainJPanel.add(gameHeader);

        mainJPanel.add(header);

        mainJPanel.add(infoSentence);
        mainJPanel.add(quizSentence);
        mainJPanel.add(gameSentence);

        // Set the layout to null for manual positioning
        mainJPanel.setLayout(null);

        // Set the size and position of the button
         // x, y, width, height

        infoBTN.setBounds(140,100, 150, 150);
        quizBTN.setBounds(600,245, 150, 150);
        gameBTN.setBounds(140,390, 150, 150);

        // Load the image
        String filePathOne = "C:\\Users\\samor\\OneDrive\\Documents\\NetBeansProjects\\MainApp\\MainApp\\src\\MainApp\\Images\\Ocean pollution icon.png";
        String filePathTwo = "C:\\Users\\samor\\OneDrive\\Documents\\NetBeansProjects\\MainApp\\MainApp\\src\\MainApp\\Images\\Ocean warming icon.png";
        String filePathThree = "C:\\Users\\samor\\OneDrive\\Documents\\NetBeansProjects\\MainApp\\MainApp\\src\\MainApp\\Images\\informationpage icon.png";
        File fileOne = new File(filePathOne);
        File fileTwo = new File(filePathTwo);
        File fileThree = new File(filePathThree);

        if (fileOne.exists()) {
            // Scale the image to match the button size (200x100)
            ImageIcon iconOne = new ImageIcon(filePathOne);
            Image scaledImage = iconOne.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            gameBTN.setIcon(scaledIcon); // Set the scaled image as the button's icon
            gameBTN.setText(""); // Remove text
            gameBTN.setContentAreaFilled(false); // Make the button background transparent
            gameBTN.setBorderPainted(false); // Remove the border
            gameBTN.setFocusPainted(false); // Remove focus painting
        } else {
            System.out.println("Image not found: " + filePathOne);
        }
        if (fileTwo.exists()) {
            // Scale the image to match the button size (200x100)
            ImageIcon iconTwo = new ImageIcon(filePathTwo);
            Image scaledImage = iconTwo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            quizBTN.setIcon(scaledIcon); // Set the scaled image as the button's icon
            quizBTN.setText(""); // Remove text
            quizBTN.setContentAreaFilled(false); // Make the button background transparent
            quizBTN.setBorderPainted(false); // Remove the border
            quizBTN.setFocusPainted(false); // Remove focus painting

        } else {
            System.out.println("Image not found: " + filePathTwo);
        }
        if (fileThree.exists()) {
            // Scale the image to match the button size (200x100)
            ImageIcon iconThree = new ImageIcon(filePathThree);
            Image scaledImage = iconThree.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            infoBTN.setIcon(scaledIcon); // Set the scaled image as the button's icon
            infoBTN.setText(""); // Remove text
            infoBTN.setContentAreaFilled(false); // Make the button background transparent
            infoBTN.setBorderPainted(false); // Remove the border
            infoBTN.setFocusPainted(false); // Remove focus painting
        } else {
            System.out.println("Image not found: " + filePathThree);
        }

        // Add the button to the panel
        mainJPanel.add(gameBTN);
        mainJPanel.add(quizBTN);
        mainJPanel.add(infoBTN);

            mainJPanel.setBackground(new java.awt.Color(255, 255, 255));
            gameJPanel.setBackground(new java.awt.Color(51, 204, 255));
    }
    public JPanel getGameJPanel() {
        return gameJPanel;
    }
    public JPanel getQuizJPanel(){
        return quizJPanel;
    }
    public JPanel getInfoJPanel(){
        return infoJPanel;
    }
    public JPanel getMainPanel() {
        return mainJPanel;
    }
    // Public method to show the home page
    public void showHomePage() {
        System.out.println("Switching to Home Page...");
        // Switch to main/home panel
        this.getContentPane().removeAll();
        this.add(mainJPanel);  // Add the main panel back
        this.revalidate();     // Revalidate the content
        this.repaint();        // Repaint the UI to reflect the changes
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // method to create label for a key
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundJPanel = new javax.swing.JPanel();
        mainJPanel = new javax.swing.JPanel();
        infoBTN = new javax.swing.JButton();
        quizBTN = new javax.swing.JButton();
        gameBTN = new javax.swing.JButton();
        infoJPanel = new javax.swing.JPanel();
        infobackBTN = new javax.swing.JButton();
        quizJPanel = new javax.swing.JPanel();
        quizbackBTN = new javax.swing.JButton();
        gameJPanel = new javax.swing.JPanel();
        gamebackBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 700));

        backgroundJPanel.setLayout(new java.awt.CardLayout());

        mainJPanel.setBackground(new java.awt.Color(204, 255, 255));

        infoBTN.setText("INFO");
        infoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBTNActionPerformed(evt);
            }
        });

        quizBTN.setText("QUIZ");
        quizBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizBTNActionPerformed(evt);
            }
        });

        gameBTN.setText("GAME");
        gameBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(quizBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gameBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(infoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quizBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(gameBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        backgroundJPanel.add(mainJPanel, "card2");

        infoJPanel.setBackground(new java.awt.Color(255, 204, 204));

        infobackBTN.setText("back");
        infobackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infobackBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoJPanelLayout = new javax.swing.GroupLayout(infoJPanel);
        infoJPanel.setLayout(infoJPanelLayout);
        infoJPanelLayout.setHorizontalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infobackBTN)
                .addContainerGap(810, Short.MAX_VALUE))
        );
        infoJPanelLayout.setVerticalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infobackBTN)
                .addContainerGap(659, Short.MAX_VALUE))
        );

        backgroundJPanel.add(infoJPanel, "card3");

        quizJPanel.setBackground(new java.awt.Color(204, 255, 204));

        quizbackBTN.setText("back");
        quizbackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizbackBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout quizJPanelLayout = new javax.swing.GroupLayout(quizJPanel);
        quizJPanel.setLayout(quizJPanelLayout);
        quizJPanelLayout.setHorizontalGroup(
            quizJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quizbackBTN)
                .addContainerGap(810, Short.MAX_VALUE))
        );
        quizJPanelLayout.setVerticalGroup(
            quizJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quizbackBTN)
                .addContainerGap(659, Short.MAX_VALUE))
        );

        backgroundJPanel.add(quizJPanel, "card4");

        gameJPanel.setBackground(new java.awt.Color(102, 102, 255));

        gamebackBTN.setText("back");
        gamebackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamebackBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameJPanelLayout = new javax.swing.GroupLayout(gameJPanel);
        gameJPanel.setLayout(gameJPanelLayout);
        gameJPanelLayout.setHorizontalGroup(
            gameJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamebackBTN)
                .addContainerGap(810, Short.MAX_VALUE))
        );
        gameJPanelLayout.setVerticalGroup(
            gameJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamebackBTN)
                .addContainerGap(659, Short.MAX_VALUE))
        );

        backgroundJPanel.add(gameJPanel, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backgroundJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backgroundJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBTNActionPerformed
        // TODO add your handling code here:
       // mainJPanel.setVisible(false);
        //infoJPanel.setVisible(true);
        InfoApp infoApp = new InfoApp(this);
        infoJPanel.setLayout(new BorderLayout());

        // Clear old content
        infoJPanel.removeAll();

        // Add the new InfoApp to the panel
        infoJPanel.add(infoApp, BorderLayout.CENTER);

        // Revalidate and repaint
        infoJPanel.revalidate();
        infoJPanel.repaint();

        // Show the info panel
        ((CardLayout) backgroundJPanel.getLayout()).show(backgroundJPanel, "card3");
        backgroundJPanel.revalidate();
        backgroundJPanel.repaint(); 
    }//GEN-LAST:event_infoBTNActionPerformed

    private void infobackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infobackBTNActionPerformed
        // TODO add your handling code here:
        ((CardLayout) backgroundJPanel.getLayout()).show(backgroundJPanel, "card2");

        //mainJPanel.setVisible(true);
        //infoJPanel.setVisible(false);
        
    }//GEN-LAST:event_infobackBTNActionPerformed

    private void quizbackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizbackBTNActionPerformed
        // TODO add your handling code here:
        mainJPanel.setVisible(true);
        quizJPanel.setVisible(false);
    }//GEN-LAST:event_quizbackBTNActionPerformed

    private void quizBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizBTNActionPerformed
        // TODO add your handling code here:
        mainJPanel.setVisible(false);
        quizJPanel.setVisible(true);
    }//GEN-LAST:event_quizBTNActionPerformed

    private void gamebackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamebackBTNActionPerformed
        // TODO add your handling code here:
        mainJPanel.setVisible(true);
        gameJPanel.setVisible(false);
    }//GEN-LAST:event_gamebackBTNActionPerformed

    private void gameBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameBTNActionPerformed
        // TODO add your handling code here:
        mainJPanel.setVisible(false);
        gameJPanel.setVisible(true);
    }//GEN-LAST:event_gameBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundJPanel;
    private javax.swing.JButton gameBTN;
    private javax.swing.JPanel gameJPanel;
    private javax.swing.JButton gamebackBTN;
    private javax.swing.JButton infoBTN;
    private javax.swing.JPanel infoJPanel;
    private javax.swing.JButton infobackBTN;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JButton quizBTN;
    private javax.swing.JPanel quizJPanel;
    private javax.swing.JButton quizbackBTN;
    // End of variables declaration//GEN-END:variables

    

}