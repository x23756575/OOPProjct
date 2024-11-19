package MainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TypingLogic implements KeyListener{

    private MainGUI mp;
    boolean pressed;
    private int count = 10; 
    private Timer timer;
    
    public TypingLogic(MainGUI mp) {
        this.mp = mp;


        JPanel gameJPanel = mp.getGameJPanel();
        mp.setFocusable(true);
        mp.requestFocusInWindow(); //I added this as a test because keylistener was having problems.
        //I was able to figure setFocusable(true) was necessary as the gameJPanel needed focus form keybaord inputs
        mp.addKeyListener(this);
        
        JLabel time = new JLabel(String.valueOf(count));
        time.setBounds(50, 50, 100, 30);
        gameJPanel.add(time);
        System.out.println("Panel is focusable: " + gameJPanel.isFocusable());

        timer = new Timer(1000,e -> {
          count--;
          
          time.setText(String.valueOf(count));//this will update the label every 1000 ms
           if(count <= 0){//ends loop if less than or equal to 0
           ((Timer) e.getSource()).stop(); // Stop the timer when it reaches 0
           }
        });

        gameJPanel.revalidate();
        gameJPanel.repaint();
    }

    // Method to get a random sentence as JLabel
    public JLabel typingText(){
        String[] sentences = {
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
        int index = random.nextInt(sentences.length); // Picks a random sentence from the array
        JLabel label = new JLabel(sentences[index]);  // Create JLabel with the random sentence

        return label; // Returns the label
        


    }
            @Override
        public void keyTyped(KeyEvent e) {
          
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Key pressed: " + e.getKeyChar());

           pressed = true;
            timer.start();
            System.out.println("Timer started!");
         
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
}


