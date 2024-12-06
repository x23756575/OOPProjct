package MainApp;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Quiz Application Logic and UI Manager.
 */
public class QuizApp {
    private MainGUI mainGui; // Reference to MainGUI
    private JPanel quizJPanel; // Panel for quiz-related UI
    private List<Quiz> quizList; // List of Quiz objects
    private int currentQuestionIndex = 0;
    private int points = 10; // Starting points

    private JLabel questionLabel;
    private JButton[] optionButtons;
    private JLabel feedbackLabel;
    private JLabel pointsLabel;
    

    public QuizApp(MainGUI mainGui) {
        this.mainGui = mainGui;
        this.quizJPanel = mainGui.getQuizJPanel();
        this.quizList = new ArrayList<>();

        // Initialize quiz questions here
        initQuizQuestions();

        // Randomize the question order
        Collections.shuffle(quizList);

        setupQuizUI();
        loadQuestion(currentQuestionIndex);
    }

    /**
     * Initialize quiz questions.
     */
    private void initQuizQuestions() {
        quizList.add(new Quiz("What is the primary cause of ocean warming?", new String[]{"Natural solar activity", "Greenhouse gas emissions", "Volcanic eruptions"}, 1));
        quizList.add(new Quiz("How does ocean warming impact marine life?", new String[]{"Increases biodiversity", "Causes coral bleaching", "Promotes faster fish growth"}, 1));
        quizList.add(new Quiz("What role does the ocean play in regulating Earth’s climate?", new String[]{"It absorbs heat and carbon dioxide", "It reflects sunlight into space", "It reduces atmospheric oxygen levels"}, 0));
        quizList.add(new Quiz("What stops cold water from rising?", new String[]{"Upwelling", "Algal bloom", "Ocean stratification"}, 2));
        quizList.add(new Quiz("What happens when ice caps melt?", new String[]{"Lower sea levels", "More freshwater in the ocean", "Higher sea levels"}, 2));
        quizList.add(new Quiz("Which gas is primarily responsible for ocean acidification?", new String[]{"Carbon dioxide", "Methane", "Ozone"}, 0));
        quizList.add(new Quiz("What happens to coral as sea temperatures rise?", new String[]{"Coral bleaching", "Coral fertilization", "Coral intensification"}, 0));
        quizList.add(new Quiz("How does ocean warming affect hurricanes?", new String[]{"Increases their intensity", "Decreases their frequency", "Has no effect"}, 0));
        quizList.add(new Quiz("What is one way ocean warming impacts Arctic wildlife?", new String[]{"Expands their habitat", "Reduces sea ice", "Increases fish population"}, 1));
        quizList.add(new Quiz("Which region is most impacted by rising sea levels?", new String[]{"Mountain regions", "Low-lying coastal areas", "Deserts"}, 1));
        quizList.add(new Quiz("What is a significant consequence of ocean deoxygenation?", new String[]{"Dead zones in the ocean", "Increase in fish populations", "More oxygen for marine plants"}, 0));
        quizList.add(new Quiz("What is when warm ocean water causes deep ocean water to sink?", new String[]{"Upwelling", "Thermohaline circulation", "Ocean stratification"}, 1));
        quizList.add(new Quiz("Which marine species is most threatened by ocean warming?", new String[]{"Polar bears", "Coral reefs", "Whales"}, 1));
        quizList.add(new Quiz("Which ocean is warming the fastest?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean"}, 2));
        quizList.add(new Quiz("How does ocean warming affect the carbon cycle?", new String[]{"It decreases carbon absorption", "It increases carbon absorption", "No impact on carbon absorption"}, 0));
    }

    /**
     * Set up the initial UI elements for the quiz panel.
     */
    private void setupQuizUI() {
        quizJPanel.setLayout(null); // Use absolute positioning for simplicity

        // Question Label
        questionLabel = new JLabel();
        questionLabel.setBounds(200, 100, 700, 30);
        quizJPanel.add(questionLabel);

        // Option Buttons
        optionButtons = new JButton[3];
        for (int i = 0; i < optionButtons.length; i++) {
            JButton optionButton = new JButton();
            optionButton.setBounds(250, 200 + (i * 50), 400, 40);
            final int optionIndex = i;
            optionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer(optionIndex);
                }
            });
            quizJPanel.add(optionButton);
            optionButtons[i] = optionButton;
            
        }

        // Feedback Label
        feedbackLabel = new JLabel();
        feedbackLabel.setBounds(200, 350, 400, 30);
        quizJPanel.add(feedbackLabel);

        // Points Label
        pointsLabel = new JLabel("Points: " + points);
        pointsLabel.setBounds(200, 400, 400, 30);
        quizJPanel.add(pointsLabel);
        
        pointsLabel.setFont(new Font("arial", Font.BOLD, 20));
        feedbackLabel.setFont(new Font("arial", Font.BOLD, 20));
        questionLabel.setFont(new Font("arial", Font.BOLD, 20));
    }

    /**
     * Load a question into the quiz panel.
     */
    private void loadQuestion(int questionIndex) {
        if (questionIndex >= quizList.size()) {
            questionLabel.setText("Quiz Completed!");
            for (JButton button : optionButtons) {
                button.setVisible(false);
            }
            feedbackLabel.setText("");
            checkGameStatus();
            return;
        }

        Quiz currentQuiz = quizList.get(questionIndex);
        questionLabel.setText(currentQuiz.getQuestion());
        String[] options = currentQuiz.getOptions();
        for (int i = 0; i < options.length; i++) {
            optionButtons[i].setText(options[i]);
            optionButtons[i].setVisible(true);
        }
        feedbackLabel.setText("");
    }

    /**
     * Check if the selected answer is correct.
     */
    private void checkAnswer(int selectedOption) {
        Quiz currentQuiz = quizList.get(currentQuestionIndex);
        if (selectedOption == currentQuiz.getCorrectAnswerIndex()) {
            feedbackLabel.setText("Correct!");
            points++;
        } else {
            feedbackLabel.setText("Incorrect. Try again!");
            points--;
        }

        pointsLabel.setText("Points: " + points);

        // Check for game over or winning conditions
        if (points <= 0) {
            JOptionPane.showMessageDialog(quizJPanel, "You lost all your points. Restarting the quiz!");
            resetGame();
            return;
        } else if (points >= 20) {
            JOptionPane.showMessageDialog(quizJPanel, "Congratulations! You earned 20 points and donated 10 Euros to fight ocean warming!");
            resetGame();
            return;
        }

        // Load next question after a short delay
        Timer timer = new Timer(1000, e -> {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Check the game status (win/lose conditions).
     */
    private void checkGameStatus() {
        if (points <= 0) {
            JOptionPane.showMessageDialog(quizJPanel, "You lost all your points. Restarting the quiz!");
            resetGame();
        } else if (points >= 20) {
            JOptionPane.showMessageDialog(quizJPanel, "Congratulations! You earned 20 points and donated 10 Euros to fight ocean warming!");
            resetGame();
        }
    }

    /**
     * Reset the game to its initial state.
     */
    private void resetGame() {
        points = 10;
        currentQuestionIndex = 0;
        Collections.shuffle(quizList);
        pointsLabel.setText("Points: " + points);
        loadQuestion(currentQuestionIndex);
    }
}