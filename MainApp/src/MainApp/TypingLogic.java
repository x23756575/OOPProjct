package MainApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
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
    private String currentText; 
    private JLabel label;
    private String counterWords;
    private int counter;
    private int numberOfWords;
    private int correctMatches;
    
    StringBuilder userInput = new StringBuilder();
    StringBuilder newText = new StringBuilder("<html>");
    
    public TypingLogic(MainGUI mp) {
        this.mp = mp;


        JPanel gameJPanel = mp.getGameJPanel();
        mp.setFocusable(true);
        mp.requestFocusInWindow(); //I added this as a test because keylistener was having problems.
        //I was able to figure setFocusable(true) was necessary as the gameJPanel needed focus form keybaord inputs
        mp.addKeyListener(this);
        mp.setFocusTraversalKeysEnabled(false);

        
        JLabel time = new JLabel(String.valueOf(count));
        time.setBounds(50, 50, 100, 30);
        gameJPanel.add(time);
        System.out.println("Panel is focusable: " + gameJPanel.isFocusable());
        JLabel typingLabel = typingText(); // Get the JLabel with random text
        currentText = typingLabel.getText();

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                time.setText(String.valueOf(count));
                if (count <= 0) {
            ((Timer) e.getSource()).stop();

String cleanedUserInput = stripHtml(userInput.toString()).toLowerCase(); 
String cleanedDisplayedText = stripHtml(label.getText()).toLowerCase(); // i needed to strip html to clear the html tags in stringbuilder 
                                                                        //because it was interfering with my logic when matching random sentence and user entered sentences

// Split cleaned text into words
String[] correctWords = cleanedUserInput.split("\\s+");
String[] labelWords = cleanedDisplayedText.split("\\s+"); // splits words by spaces used to match word to word



correctMatches = 0;
int mistakes = 0;

for (int i = 0; i < labelWords.length; i++) {
    if (i < correctWords.length) {
        if (labelWords[i].equals(correctWords[i])) {
            correctMatches++;
            System.out.println("Match found at index " + i + ": " + correctWords[i]);
        } else {
            mistakes++;
            System.out.println("Mistake at index " + i + ": " + correctWords[i] + " != " + labelWords[i]);
        }
    } else {
        mistakes++;
        System.out.println("Missing word at index " + i + ": " + labelWords[i]);
    }
}

// Count extra words in user input
if (correctWords.length > labelWords.length) {
    for (int i = labelWords.length; i < correctWords.length; i++) {
        mistakes++;
        System.out.println("Extra word at index " + i + ": " + correctWords[i]);
    }
}
//WPM

    numberOfWords = correctMatches * 6;
    System.out.println("WPM "+ numberOfWords);



// Print results
System.out.println("Correct Matches: " + correctMatches);
System.out.println("Mistakes: " + mistakes); //i used this to check if the matching was correct

            label.setText(""); //clears the labels text when the test is done
            
            loopTest();
                }
            }
        });



        gameJPanel.revalidate();
        gameJPanel.repaint();
    }
public static String stripHtml(String html) {
    if (html == null) {
        return "";
    }
    // Regex to remove all html tags
    return html.replaceAll("<[^>]*>", "").trim();
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
        int index = random.nextInt(sentences.length); // this picks a random sentence from the array
        label = new JLabel(sentences[index]); 
        label.setForeground(Color.black);// this is the default color of the text that i will display from the above array

        return label;

    }
    
    
public void loopTest() {
    timer.stop(); // Stop the timer
    count = 10;   // Reset the countdown
    
    currentText = typingText().getText(); // Get a new random sentence
    userInput.setLength(0); // Clear the user input

    // clear for next sentence
    newText.setLength(0);
    newText.append("<html>");
    for (int i = 0; i < currentText.length(); i++) {
        newText.append("<span style='color:black;'>")
               .append(currentText.charAt(i))
               .append("</span>");
    }
    newText.append("</html>");

    label.setText(newText.toString()); // Update the label text
    mp.getGameJPanel().add(label);
    pressed = false; // Reset the pressed flag
    label.setFont(new Font("arial", Font.BOLD, 20));
    label.setBounds(270, 100, 900, 50); // Adjust as necessary
    mp.getGameJPanel().add(label);



}
    
    
    
    
    
    
    
    
    
    
@Override

public void keyTyped(KeyEvent e) {
    char key = e.getKeyChar();

    if (userInput.length() < currentText.length()) {
        userInput.append(key);
    }

    // Clear the newText stringbuilder
    newText.setLength(0);
    newText.append("<html>");

    for (int i = 0; i < currentText.length(); i++) {
        if (i < userInput.length()) {
            // Correctly typed character
            if (currentText.charAt(i) == userInput.charAt(i)) {
                newText.append("<span style='color:green;'>")
                       .append(currentText.charAt(i))
                       .append("</span>");
            } else {
                newText.append("<span style='color:red;'>")
                       .append(currentText.charAt(i))
                       .append("</span>");
            }
        } else {
            newText.append("<span style='color:black;'>")
                   .append(currentText.charAt(i))
                   .append("</span>");
        }
    }
    newText.append("</html>");

    // Update the label with the new colored HTML text
    label.setText(newText.toString());
    timer.start();

}

        @Override
        public void keyReleased(KeyEvent e) {
        }
@Override
public void keyPressed(KeyEvent e) {
    System.out.println("Key pressed: " + e.getKeyCode());
    if (userInput.length() == currentText.length() && e.getKeyCode() == KeyEvent.VK_TAB) {
        System.out.println("Tab key pressed. Triggering result processing.");

        // Debug the cleaned strings
        String cleanedUserInput = stripHtml(userInput.toString().trim().toLowerCase());
        String cleanedDisplayedText = stripHtml(currentText.trim().toLowerCase());
        System.out.println("Cleaned User Input: " + cleanedUserInput);
        System.out.println("Cleaned Displayed Text: " + cleanedDisplayedText);

        String[] correctWords = cleanedUserInput.split("\\s+");
        String[] labelWords = cleanedDisplayedText.split("\\s+");

        correctMatches = 0;
        int mistakes = 0;

        for (int i = 0; i < labelWords.length; i++) {
            if (i < correctWords.length) {
                if (labelWords[i].equals(correctWords[i])) {
                    correctMatches++;
                    System.out.println("Match found at index " + i + ": " + correctWords[i]);
                } else {
                    mistakes++;
                    System.out.println("Mistake at index " + i + ": " + correctWords[i] + " != " + labelWords[i]);
                }
            } else {
                mistakes++;
                System.out.println("Missing word at index " + i + ": " + labelWords[i]);
            }
        }

        // Count extra words
        if (correctWords.length > labelWords.length) {
            for (int i = labelWords.length; i < correctWords.length; i++) {
                mistakes++;
                System.out.println("Extra word at index " + i + ": " + correctWords[i]);
            }
        }

        // Calculate WPM
        if (correctMatches > 0) {
            numberOfWords = correctMatches * 6;
        } else {
            numberOfWords = 0;
        }
        System.out.println("Final WPM: " + numberOfWords);
            label.setText("");
        loopTest();
    }
}

}


