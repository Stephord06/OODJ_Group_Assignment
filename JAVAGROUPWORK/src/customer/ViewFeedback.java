
package customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ViewFeedback extends JFrame implements CustomerStandard_Method{
    
    private String id;
    private String name;
    private String password;
    
    private List<String[]> appointmentsData = new ArrayList<>();
    
    public ViewFeedback(String id, String name, String password) {
        
        this.id = id;
        this.name = name;
        this.password = password;
        readAppointmentsData("appointments.txt");
        
    }
    

    @Override
    public void UI() {
        setTitle("Feedbacks of Individual Appointment");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Panels
            // Root panel (holds every panels)
            JPanel rootPanel = new JPanel();
            rootPanel.setBackground(Color.LIGHT_GRAY);
            rootPanel.setLayout(new BorderLayout());
            rootPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            add(rootPanel);

            // Top Panel (holds title and back panel)
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());
            topPanel.setBackground(new Color(60, 52, 137));
            topPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 3, true),
                    BorderFactory.createEmptyBorder(15, 20, 15, 20)
            ));
            
            rootPanel.add(topPanel, BorderLayout.NORTH);
            
                // Title Label
                JLabel topLabel = new JLabel("Feedbacks of Invidual Appointment");
                topLabel.setForeground(Color.WHITE);
                topLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
                topPanel.add(topLabel, BorderLayout.WEST);
                
                // Back Panel
                JPanel backPanel = new JPanel();
                backPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
                backPanel.setBackground(new Color(60, 52, 137));
                topPanel.add(backPanel, BorderLayout.EAST);
                    // Customer name Label
                    JLabel cusNameLabel = new JLabel(this.name);
                    cusNameLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
                    cusNameLabel.setForeground(Color.WHITE);
                    backPanel.add(cusNameLabel);
                    
                    // Back button
                    JButton backBtn = new JButton("Back");
                    backBtn.setFont(new Font("SansSerif", Font.BOLD, 25));
                    backPanel.add(backBtn);
                    
            // Card panel (holds all appointments card)
            JPanel cardPanel = new JPanel();
            cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
            cardPanel.setBackground(Color.LIGHT_GRAY);
            
            // Wrapper
            JPanel wrapper = new JPanel();
            wrapper.setLayout(new BorderLayout());
            wrapper.setBackground(Color.LIGHT_GRAY);
            wrapper.add(cardPanel, BorderLayout.NORTH);
            
            JScrollPane scrollPane = new JScrollPane(wrapper);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            rootPanel.add(scrollPane, BorderLayout.CENTER);
            
                // populate the cards
                if (appointmentsData.isEmpty()) {
                    JLabel noData = new JLabel("No appointments found.");
                    noData.setFont(new Font("SansSerif", Font.BOLD, 16));
                    noData.setAlignmentX(Component.CENTER_ALIGNMENT);
                    cardPanel.add(Box.createVerticalGlue());
                    cardPanel.add(noData);
                    cardPanel.add(Box.createVerticalGlue());
                }
                else {
                    for (String[] appt : appointmentsData) {
                        cardPanel.add(Box.createVerticalStrut(8));
                        cardPanel.add(feedbackCard(appt));
                    }
                }
            
        
        // Action Listeners
          // Back button event
          backBtn.addActionListener(e -> {
              dispose();
              new CustomerDashBoard(id, name, password).UI();
          });
                    
            
        setVisible(true);
            
        JOptionPane.showMessageDialog(null, "Load successfully!");
    }
    
    private void readAppointmentsData(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] body = line.split("\\|");
                if (body[1].equals(this.id)) {
                    appointmentsData.add(body);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private JPanel feedbackCard(String[] appt) {
        // Outer card
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout(0, 8));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Header row (display Id + date on the left, badge on the right)
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(Color.WHITE);
        
            // Left header (display Id + date)
            JPanel headerLeft = new JPanel();
            headerLeft.setLayout(new GridLayout(2, 1));
            headerLeft.setBackground(Color.WHITE);
                // Labels
                    // Id label
                    JLabel idLabel = new JLabel(appt[0]);
                    idLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

                    // Date Label
                    JLabel dateLabel = new JLabel(appt[5] + " | " + appt[6] + " – " + appt[7]);
                    dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
                    dateLabel.setForeground(new Color(100, 100, 100));
                    
                    headerLeft.add(idLabel);
                    headerLeft.add(dateLabel);
                    
                    // Status Label
                    JLabel statusLabel = new JLabel(appt[10]);
                    statusLabel.setFont(new Font("Arial", Font.BOLD, 11));
                    statusLabel.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
                    statusLabel.setOpaque(true);
                    
                    if (appt[10].equals("Completed")) {
                        statusLabel.setBackground(Color.GREEN);
                        statusLabel.setForeground(Color.WHITE);
                    }
                    else if (appt[10].equals("Paid")) {
                        statusLabel.setBackground(new Color(88, 28, 135));
                        statusLabel.setForeground(new Color(243, 232, 255));
                    }
                    else {
                        statusLabel.setBackground(new Color(146, 64, 14));
                        statusLabel.setForeground(new Color(254, 243, 199));
                    }
                    
            header.add(headerLeft, BorderLayout.WEST);
            header.add(statusLabel, BorderLayout.EAST);
                
            // Fields rows (3 info boxes)
            JPanel fields = new JPanel();
            fields.setLayout(new GridLayout(1, 3, 8, 0));
            fields.setBackground(Color.WHITE);
            fields.add(makeField("Technician ID", appt[2]));
            fields.add(makeField("Service Type", appt[4]));
            fields.add(makeField("Status",   appt[10]));
            
            // Bottom row (feedback and comment)
            JPanel bottomRow = new JPanel();
            bottomRow.setLayout(new GridLayout(1, 2, 8, 0));
            bottomRow.setBackground(Color.WHITE);
            bottomRow.add(makeCommentBox("Technician Feedback", appt[8]));
            bottomRow.add(makeCommentBox("Your Comment", appt[9]));
                
        card.add(header, BorderLayout.NORTH);
        card.add(fields, BorderLayout.CENTER);
        card.add(bottomRow, BorderLayout.SOUTH);
        
        
        return card;
    }
    
    private JPanel makeField(String label, String value) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 210), 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Arial", Font.PLAIN, 13));
        lbl.setForeground(Color.GRAY);
        
        String text;
        if (value.equals("-")) {
            text = "None"; 
        }
        else {
            text = value;
        }
        JLabel val = new JLabel("<html><body style = 'width: 150px'>" + text + "</body></html>");
        val.setFont(new Font("Arial", Font.BOLD, 14));
        
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(val, BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel makeCommentBox(String label, String value) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 4));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 210), 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Arial", Font.PLAIN, 13));
        lbl.setForeground(Color.GRAY);
        
        String text;
        if (value.equals("-")){
            text = "None";
        }
        else {
            text = value;
        }
        
        JLabel val = new JLabel("<html><body style = 'width: 350px'>" + text + "</body></html>");
        val.setFont(new Font("Arial", Font.BOLD, 14));
        
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(val, BorderLayout.CENTER);
        return panel;
    }
    
    
    public static void main(String[] args) {
        new ViewFeedback("C000", "Test", "1111").UI();
    }
    
}
