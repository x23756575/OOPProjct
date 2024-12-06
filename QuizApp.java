package MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;

public class QuizApp {
    private MainGUI mainGui;
    private JPanel quizJPanel;
    private java.util.List<QuizTopic> quizTopics;
    private java.util.List<Quiz> quizList;
    private int currentQuestionIndex = 0;
    private int points = 10; // Starting points

    private JLabel questionLabel;
    private JButton[] optionButtons;
    private JLabel feedbackLabel;
    private JLabel pointsLabel;
    private JSlider progressSlider;
    private JComboBox<String> topicSelector;
    private String currentTopic = "Ocean Warming";

    public QuizApp(MainGUI mainGui) {
        this.mainGui = mainGui;
        this.quizJPanel = mainGui.getQuizJPanel();
        quizTopics = new ArrayList<>();
        quizList = new ArrayList<>();

        initQuizTopics();
        setupQuizUI();
        setTopic("Ocean Warming"); // default topic
    }

    // Initialize topics
    private void initQuizTopics() {
        quizTopics.add(new QuizTopic("Ocean Warming", Arrays.asList(
                new Quiz("What is the primary cause of ocean warming?", new String[]{"Natural solar activity", "Greenhouse gas emissions", "Volcanic eruptions"}, 1),
                new Quiz("How does ocean warming impact marine life?", new String[]{"Increases biodiversity", "Causes coral bleaching", "Promotes faster fish growth"}, 1),
                new Quiz("What role does the ocean play in regulating Earth’s climate?", new String[]{"Absorbs heat and carbon dioxide", "Reflects sunlight", "Generates oxygen"}, 0),
                new Quiz("What happens to coral as sea temperatures rise?", new String[]{"Coral bleaching", "Coral fertilization", "Coral intensification"}, 0),
                new Quiz("Which ocean is warming the fastest?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean"}, 2),
                new Quiz("How does ocean warming affect hurricanes?", new String[]{"Increases intensity", "Decreases frequency", "No effect"}, 0),
                new Quiz("What is the consequence of melting ice caps?", new String[]{"Lower sea levels", "More freshwater in oceans", "Higher sea levels"}, 2),
                new Quiz("What stops cold water from rising?", new String[]{"Upwelling", "Algal bloom", "Ocean stratification"}, 2),
                new Quiz("What is the effect of warmer water on fish migration?", new String[]{"Shifts migration patterns", "Increases growth rate", "Decreases biodiversity"}, 0),
                new Quiz("What percentage of human-made heat is absorbed by oceans?", new String[]{"50%", "70%", "90%"}, 2),
                new Quiz("How does ocean warming impact polar bears?", new String[]{"Shrinks habitat", "Increases prey availability", "Creates new habitats"}, 0),
                new Quiz("What is the connection between ocean warming and ocean acidification?", new String[]{"Both caused by CO2", "No connection", "One reduces the other"}, 0),
                new Quiz("Which marine ecosystem is most vulnerable to warming?", new String[]{"Coral reefs", "Kelp forests", "Deep-sea habitats"}, 0),
                new Quiz("What happens to dissolved oxygen levels as water warms?", new String[]{"Increases", "Decreases", "Remains constant"}, 1),
                new Quiz("What is one major effect of ocean warming on sea level?", new String[]{"Sea level rise", "Sea level drop", "No effect"}, 0),
                new Quiz("How does ocean warming affect the food chain?", new String[]{"Disrupts it", "Stabilizes it", "Improves it"}, 0),
                new Quiz("What is the primary driver of ocean warming?", new String[]{"CO2 emissions", "Overfishing", "Tectonic activity"}, 0),
                new Quiz("What is the effect of warmer waters on marine diseases?", new String[]{"Increases diseases", "Decreases diseases", "No effect"}, 0),
                new Quiz("What is the main reason for ocean heat absorption?", new String[]{"Dark water absorbs heat", "Salt content", "Marine vegetation"}, 0),
                new Quiz("How does ocean warming impact Arctic wildlife?", new String[]{"Reduces sea ice", "Increases biodiversity", "No impact"}, 0)
        )));
     

        quizTopics.add(new QuizTopic("Overfishing", Arrays.asList(
                new Quiz("What is a significant cause of overfishing?", new String[]{"Recreational fishing", "Unsustainable commercial practices", "Marine conservation efforts"}, 1),
                new Quiz("Which marine species is most impacted by overfishing?", new String[]{"Dolphins", "Tuna", "Coral reefs"}, 1),
                new Quiz("What is bycatch?", new String[]{"Target species caught", "Unintended species caught", "Discarded fishing gear"}, 1),
                new Quiz("How does overfishing affect biodiversity?", new String[]{"Increases it", "Decreases it", "No impact"}, 1),
                new Quiz("What is one economic effect of overfishing?", new String[]{"Increased fish prices", "Stable fishing jobs", "Long-term profit"}, 0),
                new Quiz("Which fishing method is most destructive?", new String[]{"Pole fishing", "Trawling", "Net fishing"}, 1),
                new Quiz("What is a marine protected area?", new String[]{"An area where fishing is restricted", "A place for recreational fishing", "A region for deep-sea mining"}, 0),
                new Quiz("What is a consequence of overfishing on coral reefs?", new String[]{"Reef growth", "Reef degradation", "No impact"}, 1),
                new Quiz("How does overfishing affect the food chain?", new String[]{"Disrupts it", "Improves it", "Stabilizes it"}, 0),
                new Quiz("What is one way to combat overfishing?", new String[]{"Fishing subsidies", "Sustainable fishing practices", "Increase fishing quotas"}, 1),
                new Quiz("Which region is most affected by overfishing?", new String[]{"Polar regions", "Coastal areas", "Deserts"}, 1),
                new Quiz("What does illegal fishing lead to?", new String[]{"Sustainable stocks", "Decline in fish population", "Improved economy"}, 1),
                new Quiz("How does overfishing impact food security?", new String[]{"Improves it", "Threatens it", "No effect"}, 1),
                new Quiz("What is an overfished stock?", new String[]{"Fish population below sustainable levels", "Fish population in surplus", "Protected fish species"}, 0),
                new Quiz("Which species is endangered due to overfishing?", new String[]{"Bluefin tuna", "Sardines", "Sea cucumbers"}, 0),
                new Quiz("What is the role of quotas in fishing?", new String[]{"Increase fishing effort", "Limit fish catch", "Eliminate fishing"}, 1),
                new Quiz("How does overfishing impact marine ecosystems?", new String[]{"Balances ecosystems", "Causes imbalance", "No effect"}, 1),
                new Quiz("What is one consequence of overfishing on sharks?", new String[]{"Population increase", "Population decline", "No effect"}, 1),
                new Quiz("What is the aim of sustainable fishing?", new String[]{"Profit maximization", "Conservation of fish stocks", "Reduction of regulations"}, 1),
                new Quiz("What is one solution to reduce overfishing?", new String[]{"Marine protected areas", "Increase fishing quotas", "Use larger nets"}, 0)

        )));

        quizTopics.add(new QuizTopic("Ocean Pollution", Arrays.asList(
                new Quiz("What is a primary source of ocean pollution?", new String[]{"Forest fires", "Plastic waste", "Underwater volcanoes"}, 1),
                new Quiz("How does pollution impact marine ecosystems?", new String[]{"Increases biodiversity", "Causes habitat destruction", "Boosts coral growth"}, 1),
                new Quiz("What is microplastic?", new String[]{"Large plastic pieces", "Tiny plastic particles", "Plastic alternatives"}, 1),
                new Quiz("What is the Great Pacific Garbage Patch?", new String[]{"A coral reef", "A floating trash island", "A fishing area"}, 1),
                new Quiz("How does plastic pollution impact turtles?", new String[]{"Provides habitat", "Causes entanglement", "No impact"}, 1),
                new Quiz("What is a dead zone?", new String[]{"Area with no oxygen", "Rich biodiversity zone", "Fishing hotspot"}, 0),
                new Quiz("What is one effect of oil spills?", new String[]{"Boosts marine life", "Harms ecosystems", "No effect"}, 1),
                new Quiz("What is eutrophication?", new String[]{"Nutrient enrichment causing algae growth", "Fish population increase", "Marine conservation method"}, 0),
                new Quiz("How does ocean pollution affect coral reefs?", new String[]{"Enhances growth", "Causes bleaching", "No impact"}, 1),
                new Quiz("What is the main source of plastic in the ocean?", new String[]{"Fishing nets", "Land-based waste", "Marine organisms"}, 1),
                new Quiz("How can ocean pollution be reduced?", new String[]{"Dump waste in deeper waters", "Reduce plastic usage", "Increase plastic production"}, 1),
                new Quiz("What is one effect of heavy metals in oceans?", new String[]{"Improves fish health", "Bioaccumulation in marine life", "No effect"}, 1),
                new Quiz("How does nutrient runoff cause pollution?", new String[]{"Increases oxygen", "Creates dead zones", "Boosts fish growth"}, 1),
                new Quiz("What is the effect of acid rain on the ocean?", new String[]{"Raises ocean pH", "Lowers ocean pH", "No effect"}, 1),
                new Quiz("What is the most harmful type of ocean pollution?", new String[]{"Oil spills", "Plastic waste", "Radioactive waste"}, 2),
                new Quiz("How can marine life be impacted by ocean noise pollution?", new String[]{"Improved communication", "Disrupted navigation", "No impact"}, 1),
                new Quiz("What is the impact of ocean pollution on human health?", new String[]{"No impact", "Can cause illness", "Improves health"}, 1),
                new Quiz("How does ocean pollution affect fish migration?", new String[]{"Disrupts migration patterns", "Has no effect", "Promotes migration"}, 0),
                new Quiz("What is one way to clean up ocean oil spills?", new String[]{"Incineration", "Using booms and skimmers", "Dumping chemicals"}, 1),
                new Quiz("What is one of the main dangers of plastic bags to marine life?", new String[]{"Provides shelter", "Entanglement and ingestion", "Promotes growth"}, 1)

        )));
    }

    private void setupQuizUI() {
        // Topic Selector
        topicSelector = new JComboBox<>(quizTopics.stream().map(QuizTopic::getTopicName).toArray(String[]::new));
        topicSelector.setBounds(350, 50, 200, 30);
        topicSelector.addActionListener(e -> setTopic((String) topicSelector.getSelectedItem()));
        quizJPanel.add(topicSelector);

        // Question Label
        questionLabel = new JLabel();
        questionLabel.setBounds(200, 100, 700, 30);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        quizJPanel.add(questionLabel);

        // Option Buttons
        optionButtons = new JButton[3];
        for (int i = 0; i < optionButtons.length; i++) {
            JButton optionButton = new JButton();
            optionButton.setBounds(250, 150 + (i * 50), 400, 40);
            final int optionIndex = i;
            optionButton.addActionListener(e -> checkAnswer(optionIndex));
            quizJPanel.add(optionButton);
            optionButtons[i] = optionButton;
        }

        // Feedback Label
        feedbackLabel = new JLabel();
        feedbackLabel.setBounds(350, 350, 400, 30);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 20));
        quizJPanel.add(feedbackLabel);
        feedbackLabel.setVisible(true);


        // Points Label
        pointsLabel = new JLabel("Points: " + points);
        pointsLabel.setBounds(200, 450, 400, 30);
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        quizJPanel.add(pointsLabel);

        // Progress Slider
        progressSlider = new JSlider(0, 20, 10); // Range from 0 to 20, starting at 10
        progressSlider.setBounds(200, 500, 500, 40);
        progressSlider.setEnabled(false); // Disable manual adjustment
        progressSlider.setMajorTickSpacing(5);
        progressSlider.setPaintTicks(true);
        progressSlider.setPaintLabels(true);
        quizJPanel.add(progressSlider);
    }

    private void setTopic(String topic) {
        for (QuizTopic quizTopic : quizTopics) {
            if (quizTopic.getTopicName().equals(topic)) {
                currentTopic = topic;
                quizList = new ArrayList<>(quizTopic.getQuizzes());
                break;
            }
        }
        currentQuestionIndex = 0;
        points = 10; // Reset points
        pointsLabel.setText("Points: " + points);
        progressSlider.setValue(points); // Set slider to 10
        Collections.shuffle(quizList);
        loadQuestion(currentQuestionIndex);
    }

    private void loadQuestion(int questionIndex) {
        if (questionIndex >= quizList.size()) {
            questionLabel.setText("OUT OF QUESTIONS!");
            for (JButton button : optionButtons) {
                button.setVisible(false);
            }
            feedbackLabel.setText("");
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

    private void checkAnswer(int selectedOption) {
        Quiz currentQuiz = quizList.get(currentQuestionIndex);
        if (selectedOption == currentQuiz.getCorrectAnswerIndex()) {
            feedbackLabel.setText("Correct!");
            points++;
        } else {
            feedbackLabel.setText("Incorrect. Try again!");
            points--;
        }

        // Update Points Label and Slider
        pointsLabel.setText("Points: " + points);
        progressSlider.setValue(points); // Update the slider to reflect the current points

        if (points <= 0) {
            JOptionPane.showMessageDialog(quizJPanel, "You lost all your points. Restarting the quiz!");
            resetGame();
        } else if (points >= 20) {
            JOptionPane.showMessageDialog(quizJPanel, "Congratulations! You earned 20 points!");
            resetGame();
        } else {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        }
    }

    private void resetGame() {
        points = 10;
        currentQuestionIndex = 0;
        progressSlider.setValue(points); // resets slider to the middle
        Collections.shuffle(quizList);
        pointsLabel.setText("Points: " + points);
        loadQuestion(currentQuestionIndex);
    }

    // Inner Class for QuizTopic
    static class QuizTopic {
        private final String topicName;
        private final java.util.List<Quiz> quizzes;

        public QuizTopic(String topicName, java.util.List<Quiz> quizzes) {
            this.topicName = topicName;
            this.quizzes = quizzes;
        }

        public String getTopicName() {
            return topicName;
        }

        public java.util.List<Quiz> getQuizzes() {
            return quizzes;
        }
    }
}
