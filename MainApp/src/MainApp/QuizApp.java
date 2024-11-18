package MainApp;

import javax.swing.JPanel;

/**
 *
 * @author temuulen
 */
public class QuizApp{
    
    private MainGUI mp;
    
    public QuizApp(MainGUI mp){
        this.mp = mp;
    
    JPanel quizJPanel = mp.getQuizJPanel();
     
    quizJPanel.revalidate();
    quizJPanel.repaint();
    }
    
}
    
    
