package MainApp;

/**
 * Quiz Class to encapsulate quiz data and logic.
 */
public class Quiz {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public Quiz(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}