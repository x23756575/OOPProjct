package MainApp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author temuulen
 */

public class MainApp {

    public static void main(String[] args) {
        
        MainGUI gui = new MainGUI();
        TypingApp typingApp = new TypingApp(gui);
        QuizApp quizApp = new QuizApp(gui);
        gui.setVisible(true);  
    }
}