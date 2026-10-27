import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame {

    private JRadioButton birdBtn, catBtn, dogBtn, rabbitBtn, pigBtn;
    private ButtonGroup group;
    private JLabel imageLabel;

    public RadioButtonDemo() {
        // Set up the frame
        setTitle("RadioButtonDemo");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- Left Panel: Radio Buttons ---
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        birdBtn   = new JRadioButton("Bird");
        catBtn    = new JRadioButton("Cat");
        dogBtn    = new JRadioButton("Dog");
        rabbitBtn = new JRadioButton("Rabbit");
        pigBtn    = new JRadioButton("Pig");

        group = new ButtonGroup();
        group.add(birdBtn);
        group.add(catBtn);
        group.add(dogBtn);
        group.add(rabbitBtn);
        group.add(pigBtn);

        radioPanel.add(birdBtn);
        radioPanel.add(catBtn);
        radioPanel.add(dogBtn);
        radioPanel.add(rabbitBtn);
        radioPanel.add(pigBtn);

        // --- Right Panel: Image Display ---
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        // Add panels to frame
        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        // --- Add Action Listeners ---
        birdBtn.addActionListener(e -> selectPet("Bird", "images/bird.jpeg"));
        catBtn.addActionListener(e -> selectPet("Cat", "images/cat.jpeg"));
        dogBtn.addActionListener(e -> selectPet("Dog", "images/dog.jpeg"));
        rabbitBtn.addActionListener(e -> selectPet("Rabbit", "images/rabbit.jpeg"));
        pigBtn.addActionListener(e -> selectPet("Pig", "images/pig.jpeg"));

        setVisible(true);
    }

    private void selectPet(String petName, String imagePath) {
        // Display the image
        ImageIcon icon = new ImageIcon(getClass().getResource("/" + imagePath));

        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE || icon.getIconWidth() > 0) {
            // Scale image to fit
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } else {
            imageLabel.setText("Image not found:\n" + imagePath);
        }

        // Show message box with selection
        JOptionPane.showMessageDialog(this,
                "You selected: " + petName,
                "Pet Selection",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // --- Main Method ---
    public static void main(String[] args) {
        // Run on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new RadioButtonDemo();
        });
    }
}