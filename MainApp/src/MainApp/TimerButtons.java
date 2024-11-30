/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainApp;

import javax.swing.JButton;

/**
 *
 * @author samor
 */
public class TimerButtons extends JButton {
    
    public TimerButtons(String text) {
        super(text);
    }

    public void setPositionAndSize(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }
}
