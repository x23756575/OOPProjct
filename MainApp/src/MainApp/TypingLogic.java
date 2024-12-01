package MainApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
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
    private JLabel wpm;
    private int tempCount;
    private int calcTimeForWpm;
    private boolean textPicked = false;

    
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
        
        timerButtons();   
        JLabel time = new JLabel(String.valueOf(count));
        time.setBounds(750, 60, 100, 100);
        time.setFont(new Font("arial", Font.BOLD, 50));
        gameJPanel.add(time);
        
        label = typingText(); 
        currentText = label.getText();

        wpm = new JLabel("WPM: ");
        wpm.setFont(new Font("arial", Font.BOLD, 20));
        wpm.setBounds(40, 200, 150, 30);
        gameJPanel.add(wpm);

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

    // splits text into words
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

// count extra words in user input
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
    // regex to remove all html tags
    return html.replaceAll("<[^>]*>", "").trim();
}



    // method to get a random sentence as JLabel
    public JLabel typingText(){
        System.out.println("ssjnksj");
          if (textPicked) {
        System.out.println("typingText() prevented: Already initialized.");
        return label;
    }
 String[] sentences = {
    "water pollution harms aquatic life every day",
    "industries dump toxic waste into rivers and lakes",
    "plastic debris fills oceans causing marine deaths",
    "clean water is essential for a healthy population",
    "fertilizers create algae blooms that suffocate fish",
    "oil spills destroy ecosystems and coastal habitats",
    "chemicals in water can poison plants and animals",
    "save water by reducing pollution and waste today",
    "oceans are choking under tons of floating plastic",
    "contaminated water leads to disease and poor health",
    "industrial runoff turns rivers into toxic wastelands",
    "our actions today can save water for future generations",
    "illegal dumping in water sources worsens pollution",
    "clean rivers and lakes ensure balanced ecosystems",
    "preserve water to sustain life on earth for all species",
    "global water crisis stems from pollution and misuse",
    "agriculture runoff contaminates fresh water supplies",
    "toxic water kills ecosystems and affects livelihoods",
    "oceans absorb pollutants and suffer biodiversity loss",
    "humans need to act now to protect water resources",
    "wastewater treatment is crucial to reduce pollution",
    "climate change worsens water pollution every year",
    "education can help reduce water pollution globally",
    "our future depends on clean and healthy water systems"
};

        Random random = new Random();
        int index = random.nextInt(sentences.length); // this picks a random sentence from the array
        label = new JLabel(sentences[index]); 
        label.setFont(new Font("arial", Font.BOLD, 20));
        label.setBounds(2200, 100, 900, 50);
        label.setForeground(Color.black);// this is the default color of the text that i will display from the above array
        textPicked = true;
        System.out.println("Random sentence picked: " + sentences[index]);
        return label;

    }
    
    
public void loopTest() {
    System.out.println("loopTest method");// using this to debug a problem that causes text to change at the start
    timer.stop(); // Stop the timer
    count = 10;   // Reset the countdown
    textPicked = false;
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
    JPanel gameJPanel = mp.getGameJPanel();
    
    label.setText(newText.toString()); // sets the new label text
    label.setFont(new Font("arial", Font.BOLD, 20));
    label.setBounds(220, 100, 900, 50);
    mp.getGameJPanel().add(label);
    
    
    wpm = new JLabel("WPM: ");
    numberOfWords = correctMatches * calcTimeForWpm;// calculates WPM   
    wpm.setText("WPM: " + numberOfWords);
    mp.getGameJPanel().add(wpm);
    
    gameJPanel.revalidate();
    gameJPanel.repaint();

}
    
public void timerButtons(){
    
    TimerButtons text = new TimerButtons("Select your time below");//timer buttons positions and sizes
    
    TimerButtons ten = new TimerButtons("10");  // inherited from TimerButtons class
    TimerButtons twenty = new TimerButtons("20");
    TimerButtons thirty = new TimerButtons("30");
    
    ten.setFont(new Font("arial", Font.BOLD,10));
    twenty.setFont(new Font("arial", Font.BOLD, 10));
    thirty.setFont(new Font("arial", Font.BOLD, 10));
    
    text.setPositionAndSize(350, 5, 170, 30);
    ten.setPositionAndSize(320,50,50,50);
    twenty.setPositionAndSize(400,50,50,50);
    thirty.setPositionAndSize(480,50,50,50);
    

    
ten.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        count = 10;
        timer.stop();
        timer.start();

        mp.requestFocusInWindow();// used to get focus from keyboard on the panel
    }
});

twenty.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {// these are the buttons to change timer, 
        count = 20; 
        
        timer.stop(); // when a timer is clicked it resets the timer to display the new timer
        timer.start();
        mp.requestFocusInWindow();
    }
});

thirty.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        count = 30;
        timer.stop();
        timer.start();
      
        mp.requestFocusInWindow();
    }
});


    mp.getGameJPanel().add(text);
    mp.getGameJPanel().add(ten);
    mp.getGameJPanel().add(twenty);
    mp.getGameJPanel().add(thirty);
    mp.getGameJPanel().revalidate();
    mp.getGameJPanel().repaint();
   
}
    
    
    
    
    
    
    
    
    
@Override

public void keyTyped(KeyEvent e) {
    char key = e.getKeyChar();
    
    if(label == null || currentText == null) {
        return; // intilizes these variables if they werent already
    }

    if (userInput.length() < currentText.length()) {
        userInput.append(key);
    }



    newText.setLength(0);// this clear the newText stringbuilder
    newText.append("<html>");// used to interpret text as html text so i can style it

    for (int i = 0; i < currentText.length(); i++) {//for loop used to loop through userinput text and checks if its correct - changes to green vice versa
        if (i < userInput.length()) {
            // Correctly typed character
            if (currentText.charAt(i) == userInput.charAt(i)) {
                newText.append("<span style='color:green;'>")//if it is correct, it appends the text interpretted as html in green
                       .append(currentText.charAt(i))
                       .append("</span>");
            } else {
                newText.append("<span style='color:red;'>")
                       .append(currentText.charAt(i)) //if it is wrong, it appends the text interpretted as html in red
                       .append("</span>");
            }
        } else {
            newText.append("<span style='color:black;'>")
                   .append(currentText.charAt(i))
                   .append("</span>"); //and if the text hasnt been looped through yet, the text stays as black
        }
    }
    newText.append("</html>");

   label.setText(newText.toString()) ;//sets the text to a label to be displayed
    timer.start();

}

        @Override
        public void keyReleased(KeyEvent e) {//redundant but i have to have it here otherwise errors
        }
@Override
public void keyPressed(KeyEvent e) {
    System.out.println("Key pressed: " + e.getKeyCode());
    if (e.getKeyCode() == KeyEvent.VK_TAB) {
        wpm.setText("");//clears text when user skips test
        tempCount = count; // i created a simple formula to calculate wpm by setting a temp variaable to hold the timer value when tab is clicked(ends the typing test)
        calcTimeForWpm = 60/tempCount;// 60 is divided by the timer value to find the multiplier to calculate the wpm.
                                      //.. i used this method because i cant just multiply by 6 in a 10 second test 
                                                                              //if they finish the test early as results would be false. *6 would only work if they completed the full 10 seconds.

        String cleanedUserInput = stripHtml(userInput.toString().trim().toLowerCase());// i used this method to get rid of html tags when appending, i found this method online by researching and it works effectively
        String cleanedDisplayedText = stripHtml(currentText.trim().toLowerCase());


        String[] correctWords = cleanedUserInput.split("\\s+");// seperates by spaces to seperate wordds
        String[] labelWords = cleanedDisplayedText.split("\\s+");// i still have an issue to fix if they type a word where a space should be, but i will do that later on

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

        // this count extra words
        if (correctWords.length > labelWords.length) {
            for (int i = labelWords.length; i < correctWords.length; i++) {
                mistakes++;
            }
        }


            numberOfWords = correctMatches * calcTimeForWpm;// calculates WPM
        
            wpm.setText("WPM: " + numberOfWords);
            label.setText("");
            userInput.setLength(0);
            loopTest();
            
    }
}


}


