package MainApp;
/**
 *
 * @author Blesson/Saboteur
 */

// importing all the necessary files
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InfoContent extends JPanel {  
    // Components to display text and images
    private JTextArea displayText; 
    private JLabel imageLabel;
    private JTextArea introText;
    private Map<String, String> topics; 
    private JPanel mainPanel;
    public static String getTopicInfo(String topic) {
        return null;
    }

    public InfoContent() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 700)); 

        // Initialize the main panel 
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Title label
        JLabel title = new JLabel("Life Below Water: The Oceans and Their Challenges", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24));  // Title font style and size
        add(title, BorderLayout.NORTH);

        // Intro texxt at the topc
        introText = new JTextArea();
        introText.setText("This page will give you a detailed information regarding the topics, Ocean Warming and Ocean Pollution. \n Click the button below to find the credits/source for the information");
        introText.setEditable(false);  
        introText.setLineWrap(true);  
        introText.setWrapStyleWord(true);  
        introText.setBackground(getBackground());  
        introText.setFont(new Font("Arial", Font.BOLD, 16));
        JScrollPane introScroll = new JScrollPane(introText);  
        introScroll.setPreferredSize(new Dimension(600, 80));  
        mainPanel.add(introScroll, BorderLayout.NORTH);  // Add the scroll pane to the panel

        // Panel to display detailed information and images
        JPanel contentPanel = new JPanel(new BorderLayout());
        displayText = new JTextArea();  
        displayText.setEditable(false);  
        displayText.setLineWrap(true);  
        displayText.setWrapStyleWord(true);  
        displayText.setFont(new Font("Arial", Font.PLAIN, 18));  
        JScrollPane displayScroll = new JScrollPane(displayText);  
        contentPanel.add(displayScroll, BorderLayout.CENTER); 

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        contentPanel.add(imageLabel, BorderLayout.EAST); 

        mainPanel.add(contentPanel, BorderLayout.CENTER);  // dispaly content to main panel

        // Initialize topics, using hashmap to auto map
        topics = new HashMap<>();
        topics.put("Ocean Pollution", "images/pollution.jpg");
        topics.put("Ocean Warming", "images/ocean_warming.jpg");
        // referred https://www.w3schools.com/java/java_hashmap.asp
    }

    // Method to display information 
    public void displayInfo(String infoText, String imagePath) {
        displayText.setText(infoText);  // Set the information text

        try {
            String fullImagePath = "D:\\NCI\\Year 2\\Semester 1\\Obj Oriented Prog\\MainApp\\src\\MainApp\\images\\" + imagePath;
            ImageIcon icon = new ImageIcon(fullImagePath);  // Load image from the path
            Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);  // Scale the image
            imageLabel.setIcon(new ImageIcon(img));  // Set the image icon
        } 
        
        catch (Exception e){
        }
    }

    // Getter for topics map
    public Map<String, String> getTopics() {
        return topics;
    }

    // Detailed inforation on topics
    public static String getOceanPollutionInfo() {
        return "Ocean pollution refers to the contamination of the oceans by harmful substances, primarily from human activities. "
            + "This pollution can come from a variety of sources, including land-based runoff, shipping, fishing activities, "
            + "and industrial waste. One of the major contributors to ocean pollution is plastic waste, which accounts for more than 80% "
            + "of the total pollution in the oceans. Plastic materials, such as bottles, bags, and microplastics, not only harm marine life but also "
            + "pose serious risks to human health as they enter the food chain. The Great Pacific Garbage Patch, an enormous collection of plastic debris, "
            + "is a well-known symbol of the growing crisis of ocean pollution.\n\n"
            + "Another significant pollutant is oil, which is often discharged into the ocean from ships, drilling rigs, or during oil transportation. "
            + "Even small amounts of oil can cause extensive damage to marine ecosystems, coating the feathers of birds and the fur of mammals, "
            + "as well as harming fish and other marine species. Additionally, chemicals and heavy metals from industrial processes and agricultural runoff "
            + "also contribute to ocean contamination. These pollutants affect coral reefs, sea turtles, and various marine species by disrupting their "
            + "reproductive cycles, immune systems, and overall survival.\n\n"
            + "Addressing ocean pollution requires global cooperation to reduce plastic production, implement better waste management practices, "
            + "regulate shipping and industrial discharges, and promote clean-up initiatives. The restoration of marine ecosystems is also critical, "
            + "as healthy oceans provide essential resources such as food, oxygen, and regulate the planet's climate. In summary, ocean pollution "
            + "poses a severe threat to marine biodiversity, human health, and the environment. Efforts to prevent and reverse this crisis are urgent "
            + "and necessary for the survival of the oceans and all life on Earth.";
    }

    // Static method to get information about Ocean Warming
    public static String getOceanWarmingInfo() {
        return "Ocean warming refers to the increase in the temperature of the Earth's oceans, primarily due to human-induced climate change. "
            + "The Earth's oceans absorb a significant amount of heat from the atmosphere, and as the planet warms, so do the oceans. "
            + "This phenomenon has far-reaching impacts on marine life, weather patterns, and global ecosystems.\n\n"
            + "One of the most notable effects of ocean warming is the bleaching of coral reefs. Coral reefs are highly sensitive to changes in temperature. "
            + "When water temperatures rise, corals expel the algae that live inside their tissues, which gives them their color. Without algae, corals "
            + "lose their vibrant hues and become vulnerable to disease and death.\n\n"
            + "Additionally, warmer oceans are contributing to the melting of polar ice caps and glaciers, which leads to rising sea levels. "
            + "This can cause coastal erosion, threaten coastal communities, and result in the loss of habitat for marine species.\n\n"
            + "Ocean warming also affects fish populations, many of which are sensitive to changes in temperature. Warmer waters can alter migration patterns "
            + "and disrupt food chains, leading to a decline in fish stocks. This affects not only marine ecosystems but also human communities that rely "
            + "on fishing for their livelihoods.\n\n"
            + "The increasing frequency of extreme weather events, such as hurricanes and typhoons, is another consequence of ocean warming. "
            + "These storms gain strength from warm ocean waters and can lead to severe flooding and damage to coastal regions. Scientists are working "
            + "on strategies to mitigate ocean warming, including reducing greenhouse gas emissions and promoting sustainable marine practices.";
    }
}
