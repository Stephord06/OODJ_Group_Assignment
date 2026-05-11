
package counterstaff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import GeneralTools.User;


public class AddCustomer extends JFrame {
    
    private User currentUser;
    
    public AddCustomer(User user) {
        this.currentUser = user;
        
        setTitle("APU - Automotive Service Centre | Add Customer");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Panels
            // Root Panel (holds every panels)
            JPanel rootPanel = new JPanel();
            rootPanel.setLayout(new BorderLayout());
            rootPanel.setBackground(Color.WHITE);
            rootPanel.setBorder(BorderFactory.createEmptyBorder(40, 140, 40, 140));
            add(rootPanel);
            
            // Header Panel (holds title and back button)
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new BorderLayout());
            headerPanel.setBackground(Color.WHITE);
            rootPanel.add(headerPanel, BorderLayout.NORTH);            
                // Left Panel 
                JPanel headerLeftPanel = new JPanel();
                headerLeftPanel.setLayout(new BoxLayout(headerLeftPanel, BoxLayout.Y_AXIS));
                headerLeftPanel.setBackground(Color.WHITE);
                headerPanel.add(headerLeftPanel, BorderLayout.WEST);
                
                 //Label
                JLabel titleLabel = new JLabel("Add Customer");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
                titleLabel.setForeground(new Color(218, 87, 0));
                headerLeftPanel.add(titleLabel);
                
                JLabel  subLabel = new JLabel("APU Automotive Service Centre");
                subLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                subLabel.setForeground(new Color(69, 69, 69));
                headerLeftPanel.add(subLabel);
                
                //Button
                JButton backButton = new JButton("← Back");
                backButton.setBackground(Color.BLACK);
                backButton.setForeground(Color.WHITE);
                backButton.setFont(new Font("Arial", Font.BOLD, 14));
                backButton.setFocusPainted(false);
                headerPanel.add(backButton, BorderLayout.EAST);
                
            // Body Panel (holds form fields)
            JPanel bodyPanel = new JPanel();
            bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
            bodyPanel.setBackground(Color.WHITE);
            bodyPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
            rootPanel.add(bodyPanel, BorderLayout.CENTER);
               
                // Customer ID - auto generated, non-editable
                // Customer ID row
                JLabel idLabel = new JLabel("Customer ID  (auto-generated)");
                idLabel.setFont(new Font("Arial", Font.BOLD, 15));
                idLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(idLabel);
                bodyPanel.add(Box.createVerticalStrut(6));

                JTextField idField = new JTextField(FileManager.generateNextId("customers.txt", "C"));
                idField.setFont(new Font("Arial", Font.PLAIN, 15));
                idField.setBackground(new Color(245, 245, 245));
                idField.setForeground(Color.GRAY);
                idField.setEditable(false);
                idField.setMaximumSize(new Dimension(550, 35));
                idField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                idField.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(idField);
                bodyPanel.add(Box.createVerticalStrut(20));

                
                // Customer Name
                JLabel nameLabel = new JLabel("Name");
                nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
                nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(nameLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JTextField nameField = new JTextField("Enter full name");
                nameField.setFont(new Font("Arial", Font.PLAIN, 15));
                nameField.setForeground(Color.GRAY);
                nameField.setMaximumSize(new Dimension(550, 35));
                nameField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(nameField);
                bodyPanel.add(Box.createVerticalStrut(20));
                    // Focus Listener
                    nameField.addFocusListener(new FocusAdapter(){
                        public void focusGained(FocusEvent e) {
                            if(nameField.getText().equals("Enter full name")) {
                                nameField.setText("");
                                nameField.setForeground(Color.BLACK);
                            }
                        }
                        
                        public void focusLost(FocusEvent e) {
                            if(nameField.getText().isEmpty()) {
                                nameField.setText("Enter full name");
                                nameField.setForeground(Color.GRAY);
                            }
                        }
                    });
                
                // Customer Email
                JLabel emailLabel = new JLabel("Email");
                emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
                emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(emailLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JTextField emailField = new JTextField("Enter email address");
                emailField.setFont(new Font("Arial", Font.PLAIN, 15));
                emailField.setAlignmentX(Component.LEFT_ALIGNMENT);
                emailField.setForeground(Color.GRAY);
                emailField.setMaximumSize(new Dimension(550, 35));
                emailField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                bodyPanel.add(emailField);
                bodyPanel.add(Box.createVerticalStrut(20));
                    // Focus Listener
                    emailField.addFocusListener(new FocusAdapter(){
                        public void focusGained(FocusEvent e) {
                            if(emailField.getText().equals("Enter email address")) {
                                emailField.setText("");
                                emailField.setForeground(Color.BLACK);
                            }
                        }
                        
                        public void focusLost(FocusEvent e) {
                            if(emailField.getText().isEmpty()) {
                                emailField.setText("Enter email address");
                                emailField.setForeground(Color.GRAY);
                            }
                        }
                    });
                    
                // Customer Phone No
                JLabel phoneLabel = new JLabel("Phone Number");
                phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
                phoneLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(phoneLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JTextField phoneField = new JTextField("Enter phone number");
                phoneField.setFont(new Font("Arial", Font.PLAIN, 15));
                phoneField.setAlignmentX(Component.LEFT_ALIGNMENT);
                phoneField.setForeground(Color.GRAY);
                phoneField.setMaximumSize(new Dimension(550, 35));
                phoneField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                bodyPanel.add(phoneField);
                bodyPanel.add(Box.createVerticalStrut(30));
                    // Focus Listener
                    phoneField.addFocusListener(new FocusAdapter(){
                        public void focusGained(FocusEvent e) {
                            if(phoneField.getText().equals("Enter phone number")) {
                                phoneField.setText("");
                                phoneField.setForeground(Color.BLACK);
                            }
                        }
                        
                        public void focusLost(FocusEvent e) {
                            if(phoneField.getText().isEmpty()) {
                                phoneField.setText("Enter phone number");
                                phoneField.setForeground(Color.GRAY);
                            }
                        }
                    });
                    
                // Buttons Panel
                
                JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                btnPanel.setBackground(Color.WHITE);
                btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                
                JButton saveButton = new JButton("SAVE");
                saveButton.setBackground(new Color(218, 87, 0));
                saveButton.setForeground(Color.WHITE);
                saveButton.setFont(new Font("Arial", Font.BOLD, 14));
                saveButton.setFocusPainted(false);
                saveButton.setBorderPainted(false);
                saveButton.setPreferredSize(new Dimension(120, 35));
                btnPanel.add(saveButton);
                
                btnPanel.add(Box.createHorizontalStrut(12));
                
                JButton cancelButton = new JButton("CANCEL");
                cancelButton.setBackground(Color.WHITE);
                cancelButton.setForeground(Color.BLACK);
                cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
                cancelButton.setFocusPainted(false);
                cancelButton.setPreferredSize(new Dimension(120, 35));
                btnPanel.add(cancelButton);
                
                bodyPanel.add(btnPanel);
        
        // Action Listeners
        backButton.addActionListener(e -> {
            dispose();
            new ManageCustomer(currentUser);
        });
        
        cancelButton.addActionListener(e -> {
            dispose();
            new ManageCustomer(currentUser);
        });
        
        saveButton.addActionListener(e -> {
            // Get values from fields
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            
            // Input validation
            if (name.isEmpty() || name.equals("Enter full name") ||
                email.isEmpty() || email.equals("Enter email address") ||
                phone.isEmpty() || phone.equals("Enter phone number")) {
                JOptionPane.showMessageDialog(this, 
                        "Please fill in all the fields!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } 
            
            // Auto generate Customer ID
            String customerId = FileManager.generateNextId("customers.txt", "C");
            
            // Save to customers.txt
            String newLine = customerId + "|" + name + "|" + phone + "|" + email + "|apu123"; // apu123 default password
            FileManager.appendToFile("customers.txt", newLine);
            
            // Update the ID field to show generated ID
            JOptionPane.showMessageDialog(this,
                    "Customer " + customerId + " added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
            new ManageCustomer(currentUser);
            
        });
        
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
    }
}
