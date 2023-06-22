
import animalplanet.Animal;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnimalPlanet {

    private JTextField searchField;
    private JButton searchButton;
    private JLabel nameLabel;
    private JLabel scientificNameLabel;
    private JLabel regionLabel;
    private JLabel imageLabel;
    private JPanel recentListPanel;
    private List<String> recentSearches;
    private List<Animal> animalData;

    public AnimalPlanet() {
        initializeAnimalData();
        recentSearches = new ArrayList<>();
    }

    private void performSearch(String searchTerm) {
        clearResult();

        for (Animal animal : animalData) {
            if (animal.getName().equalsIgnoreCase(searchTerm)) {
                nameLabel.setText("Name: " + animal.getName());
                scientificNameLabel.setText("Scientific Name: " + animal.getScientificName());
                regionLabel.setText("Region: " + animal.getRegion());
                ImageIcon imageIcon = new ImageIcon(animal.getImagePath());
                imageLabel.setIcon(imageIcon);
                recentSearches.add(animal.getName());
                updateRecentList();

                return;
            }
        }
        nameLabel.setText("Data not found");
    }

    private void clearResult() {
        nameLabel.setText("");
        scientificNameLabel.setText("");
        regionLabel.setText("");
        imageLabel.setIcon(null);
    }

    private void updateRecentList() {
        recentListPanel.removeAll();
        for (String searchTerm : recentSearches) {
            JLabel searchLabel = new JLabel(searchTerm);
            recentListPanel.add(searchLabel);
        }
        recentListPanel.revalidate();
        recentListPanel.repaint();
    }

    private void initializeAnimalData() {
        animalData = new ArrayList<>();
        animalData.add(new Animal("Lion", "Panthera leo", "Africa", "img/Lion.jpg"));
        animalData.add(new Animal("Tiger", "Panthera tigris", "Asia", "img/Tiger.jpg"));
        animalData.add(new Animal("Bear", "Ursus arctos", "North-America", "img/Bear.jpg"));
        animalData.add(new Animal("Wolf", "Canis lupus", "America,Asia,Europe", "img/Wolf.jpg"));
        animalData.add(new Animal("Elephant", "Elephas maximus", "Asia", "img/Elephant.jpg"));
        animalData.add(new Animal("Panda", "Ailuropoda melanoleuca", "China", "img/Panda.jpg"));
        animalData.add(new Animal("Horse", "Equus caballus", "Various", "img/Horse.jpg"));
    }

    public void run() {
        JFrame frame = new JFrame("Animal Diary");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 2));
        nameLabel = new JLabel();
        scientificNameLabel = new JLabel();
        regionLabel = new JLabel();
        imageLabel = new JLabel();
        resultPanel.add(nameLabel);
        resultPanel.add(scientificNameLabel);
        resultPanel.add(regionLabel);
        resultPanel.add(imageLabel);

        recentListPanel = new JPanel();
        recentListPanel.setLayout(new BoxLayout(recentListPanel, BoxLayout.Y_AXIS));

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);
        frame.add(recentListPanel, BorderLayout.WEST);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                performSearch(searchTerm);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AnimalPlanet animalPlanet = new AnimalPlanet();
        animalPlanet.run();
    }
}

