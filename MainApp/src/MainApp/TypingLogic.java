package MainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JLabel;

public class TypingLogic implements KeyListener {

    // Constructor (optional, no need to generate the JLabel here)
    public TypingLogic() {
        // You can leave this empty or perform setup, but the logic will be in the method
    }

    // Method to get a random sentence as JLabel
    public JLabel typingText() {String[] sentences = {
    "the quick brown fox jumped over the lazy dog",
    "the rain in spain falls mainly on the plain",
    "time flies when youre having fun",
    "to be or not to be that is the question",
    "it always seems impossible until its done",
    "dont count the days make the days count",
    "you miss 100 of the shots you dont take",
    "dreams dont work unless you do",
    "the best revenge is massive success",
    "if you can dream it you can achieve it",
    "dont wait for the opportunity create it",
    "believe you can and youre halfway there",
    "make today amazing one step at a time",
    "opportunities dont happen you create them",
    "the future depends on what you do today",
    "there is no substitute for hard work",
    "stay positive work hard make it happen",
    "every moment is a fresh beginning",
    "you dont have to be great to start",
    "happiness depends upon ourselves",
    "you are stronger than you think",
    "everything you can imagine is real",
    "dream big and dare to fail",
    "the purpose of life is not to be happy"
};


        Random random = new Random();
        int index = random.nextInt(sentences.length); // Pick a random sentence
        JLabel label = new JLabel(sentences[index]);  // Create JLabel with the random sentence
        
        return label; // Return the label to be used in your app
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
