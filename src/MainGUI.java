/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infopage;

import javax.swing.JPanel;

public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    public MainGUI() {
        initComponents();
    }
    public JPanel getGameJPanel() {
        return gameJPanel;
    }
    public JPanel getInfoJPanel(){
        return infoJPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        mainJPanel.setVisible(false);
        infoJPanel.setVisible(true);
    }//GEN-LAST:event_infoBTNActionPerformed

    private void infobackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infobackBTNActionPerformed
        // TODO add your handling code here:
        mainJPanel.setVisible(true);
        infoJPanel.setVisible(false);
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
