/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infopage;
/**
 *
 * @author Saboteur
 */

public class MainApp {
    public static void main(String[] args) {
        // TODO code application logic here
        MainGUI gui = new MainGUI();
        //TypingApp typingApp = new TypingApp(gui);
        InfoApp infoapp = new InfoApp(gui);
        gui.setVisible(true);
    }
}
