/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainApp;

import javax.swing.JPanel;

/**
 *
 * @author temuulen
 */
public class InfoApp {
    
    private MainGUI mp;
    
    public InfoApp(MainGUI mp){
        this.mp = mp;
    
    JPanel infoJPanel = mp.getInfoJPanel();
     
    infoJPanel.revalidate();
    infoJPanel.repaint();
    }
    
}
