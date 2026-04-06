/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package manager;

import javax.swing.*;
import java.awt.*;

public class ManagerDashBoard {

    private String name;
    private String password;
    

    public ManagerDashBoard(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void Icon() {
        // Frame
        JFrame frame = new JFrame("Manager Dash Board");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Outer panel with GridBagLayout to center content
        JPanel outer = new JPanel(new GridBagLayout());
        frame.add(outer);

        // Container panel to stack label and button panel vertically
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        // Greeting label
        JLabel greeting = new JLabel("Welcome to the Manager Dashboard, " + this.name);
        greeting.setFont(new Font("Arial", Font.BOLD, 18));
        greeting.setAlignmentX(Component.CENTER_ALIGNMENT); // center horizontally
        container.add(greeting);

        // Gap between label and buttons
        container.add(Box.createVerticalStrut(50));
         // 50 pixels gap

        // Button panel with GridLayout 2x2
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setPreferredSize(new Dimension(300, 150));

        // Add buttons
        buttonPanel.add(new JButton("Modify Roles"));
        buttonPanel.add(new JButton("Set Prices"));
        buttonPanel.add(new JButton("Analyzed Report"));
        buttonPanel.add(new JButton("View Comment"));

        container.add(buttonPanel);

        // GridBagConstraints to center container in outer panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        outer.add(container, c);

        // Show frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerDashBoard("Alice", "pass123").Icon();
    }
}