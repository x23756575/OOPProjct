package infopage;

import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Saboteur
 */

public class InfoApp{
    public static void main(String[] args) {
       
        InfoForm infoForm = new InfoForm();
        infoForm.setVisible(true); 
        InfoFrame infoframe = new InfoFrame();
        infoframe.setVisible(true);
        
    }
    
    private MainGUI mp;
    
    public InfoApp(MainGUI mp){
        this.mp = mp;
    
        JPanel infoJPanel = mp.getInfoJPanel();

        infoJPanel.revalidate();
        infoJPanel.repaint();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
