/**
 * This class defines the main GUI window for the Fortune Teller application.
 * It extends JFrame and builds a user interface using Java Swing, including:
 * - A top panel with a title and fortune-teller image
 * - A middle scrollable text area where fortunes are displayed
 * - A bottom panel with two buttons: "Read My Fortune!" and "Quit"
 * When the user clicks "Read My Fortune!", the program randomly selects a
 * humorous fortune from a predefined list and displays it in the text area.
 * It ensures the same fortune is not repeated twice in a row.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private final ArrayList<String> fortunes;
    private final JTextArea fortuneArea;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");

        // Sets up frame dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        setLocationRelativeTo(null); // centers on screen

        setLayout(new BorderLayout());

        // Top panel - Title and image
        JLabel titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);

        // Load and resize image
        ImageIcon originalIcon = new ImageIcon("Image/zoltar.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Set resized icon to label
        titleLabel.setIcon(scaledIcon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));

        add(titleLabel, BorderLayout.NORTH);

        // Middle panel - JTextArea inside JScrollPane
        fortuneArea = new JTextArea(15, 30);
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel - Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("SansSerif", Font.PLAIN, 18));

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 18));

        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Fortunes list
        fortunes = new ArrayList<>();
        populateFortunes();

        // Lambda: Read My Fortune
        readButton.addActionListener(_ -> {
            int newIndex;
            Random rand = new Random();

            do {
                newIndex = rand.nextInt(fortunes.size());
            } while (newIndex == lastIndex);

            String fortune = fortunes.get(newIndex);
            fortuneArea.append(fortune + "\n");
            lastIndex = newIndex;
        });

        // Lambda: Quit
        quitButton.addActionListener(_ -> System.exit(0));
    }

    private void populateFortunes() {
        fortunes.add("You will find a sock you've been missing since 2017.");
        fortunes.add("Beware of Tuesdays and tofu.");
        fortunes.add("A mysterious cat will cross your path and steal your lunch.");
        fortunes.add("Your future is unclear... ask again after coffee.");
        fortunes.add("A fortune a day keeps reality away.");
        fortunes.add("You will invent a new dance move that only you understand.");
        fortunes.add("You will soon gain 5 followers. None of them human.");
        fortunes.add("A nap is in your near future. Embrace it.");
        fortunes.add("You are destined to confuse someone with your wisdom today.");
        fortunes.add("You will step on a LEGO. Beware the floor.");
        fortunes.add("Dont trusst fortunes withh typos.");
        fortunes.add("Your plants are secretly judging your watering skills.");
        fortunes.add("You will trip over nothing but look graceful doing it.");
        fortunes.add("Your next sneeze will bring good luck... or maybe just allergies.");
        fortunes.add("Your phone will survive one more drop — maybe two.");
        fortunes.add("You are not illiterate.");
        fortunes.add("The fortune you seek is in another castle.");
        fortunes.add("Your keyboard knows your secrets. Type wisely.");
        fortunes.add("Someone is thinking about you. Probably confused, but thinking.");
        fortunes.add("A mysterious itch will come and go without explanation.");
        fortunes.add("Beware of left turns and vague advice.");
        fortunes.add("ERROR 404: Fortune not found.");
        fortunes.add("You will win a fake argument in the shower later.");
        fortunes.add("Your future includes a surprising number of cheese-related events.");
        fortunes.add("An inanimate object will betray you today.");
        fortunes.add("Your destiny has been postponed. Try again tomorrow.");
        fortunes.add("It would be best to maintain a low profile for now.");
        fortunes.add("Why wait for failure? Make it happen today.");
        fortunes.add("You are pretty in the face... but it won't be enough.");
        fortunes.add("One of your friends plans to stab you in the back, or is it, plans to nab a sale item off the rack? That fortune always confuses me.");
        fortunes.add("You won't live to see your funeral.");
        fortunes.add("Your computer will self destruct in 30 seconds.");
        fortunes.add("You will marry the person of your dreams. Nightmares are also dreams.");
    }
}
