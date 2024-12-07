/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainApp;

/**
 *
 * @author temuulen
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainGUI gui = new MainGUI();
        TypingApp typingApp = new TypingApp(gui);
        QuizApp quizApp = new QuizApp(gui);
        InfoApp infoApp = new InfoApp(gui);
        gui.setVisible(true);
    }
     
}