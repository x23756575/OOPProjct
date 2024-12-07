
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoForm extends JPanel {
    private JLabel infoLabel;
    private JButton topicButton;

    public InfoForm() {
        setLayout(new BorderLayout());
        infoLabel = new JLabel("Select a topic to learn more.");
        add(infoLabel, BorderLayout.CENTER);

        // Add buttons dynamically
        topicButton = new JButton("Example Topic");
        topicButton.addActionListener(e -> showTopicInfo("Example Topic"));
        add(topicButton, BorderLayout.SOUTH);
    }

    private void showTopicInfo(String topic) {
        infoLabel.setText("Detailed info about: " + topic);
        // You can add logic to dynamically load info here.
    }
}
