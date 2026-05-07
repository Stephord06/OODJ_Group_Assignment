
package counterstaff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EditProfile extends JFrame {
    
    public EditProfile() {
        setTitle("APU - Automotive Service Centre | Edit Profile");
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
                JLabel titleLabel = new JLabel("Edit Profile");
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
               
                // CounterStaff ID - auto generated, non-editable
                // Staff ID row
                JLabel idLabel = new JLabel("Staff ID  (non-editable)");
                idLabel.setFont(new Font("Arial", Font.BOLD, 15));
                idLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(idLabel);
                bodyPanel.add(Box.createVerticalStrut(6));

                JTextField idField = new JTextField("S001"); //load from login later
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
                bodyPanel.add(Box.createVerticalStrut(18));

                    // Load email and contact from counterStaffs.txt
                    java.util.List<String> staffLines = FileManager.readFile("counterStaffs.txt");
                    String currentEmail = "";
                    String currentPhone = "";
                    for (String line : staffLines) {
                        String[] parts = line.split("\\|");
                        if (parts[0].equals("S001")) { // load from loginpage later
                            currentEmail = parts[3];
                            currentPhone = parts[2];
                            break;
                        }
                    }
                        
                // Email
                JLabel emailLabel = new JLabel("Email");
                emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
                emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(emailLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JTextField emailField = new JTextField(currentEmail); 
                emailField.setFont(new Font("Arial", Font.PLAIN, 15));
                emailField.setForeground(Color.BLACK);
                emailField.setMaximumSize(new Dimension(550, 35));
                emailField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                emailField.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(emailField);
                bodyPanel.add(Box.createVerticalStrut(18));
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
                
                // Phone Number
                JLabel phoneLabel = new JLabel("Phone Number");
                phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
                phoneLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(phoneLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JTextField phoneField = new JTextField(currentPhone); 
                phoneField.setFont(new Font("Arial", Font.PLAIN, 15));
                phoneField.setForeground(Color.BLACK);
                phoneField.setMaximumSize(new Dimension(550, 35));
                phoneField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                phoneField.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(phoneField);
                bodyPanel.add(Box.createVerticalStrut(18));
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
                
                // Old Password
                JLabel oldPassLabel = new JLabel("Old Password");
                oldPassLabel.setFont(new Font("Arial", Font.BOLD, 15));
                oldPassLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(oldPassLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JPasswordField oldPassField = new JPasswordField("Enter old password");
                oldPassField.setFont(new Font("Arial", Font.PLAIN, 15));
                oldPassField.setAlignmentX(Component.LEFT_ALIGNMENT);
                oldPassField.setForeground(Color.GRAY);
                oldPassField.setEchoChar((char) 0);
                oldPassField.setMaximumSize(new Dimension(550, 35));
                oldPassField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                bodyPanel.add(oldPassField);
                bodyPanel.add(Box.createVerticalStrut(18));
                    // Focus Listener
                    oldPassField.addFocusListener(new FocusAdapter(){
                        public void focusGained(FocusEvent e) {
                            String text = new String(oldPassField.getPassword());
                            if(text.equals("Enter old password")) {
                                oldPassField.setText("");
                                oldPassField.setForeground(Color.BLACK);
                                oldPassField.setEchoChar('•');
                            }
                        }
                        
                        public void focusLost(FocusEvent e) {
                            String text = new String(oldPassField.getPassword());
                            if(text.isEmpty()) {
                                oldPassField.setText("Enter old password");
                                oldPassField.setForeground(Color.GRAY);
                                oldPassField.setEchoChar((char) 0);
                            }
                        }
                    });
                    
                // New Password
                JLabel newPassLabel = new JLabel("New Password");
                newPassLabel.setFont(new Font("Arial", Font.BOLD, 15));
                newPassLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(newPassLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JPasswordField newPassField = new JPasswordField("Enter new password");
                newPassField.setFont(new Font("Arial", Font.PLAIN, 15));
                newPassField.setAlignmentX(Component.LEFT_ALIGNMENT);
                newPassField.setForeground(Color.GRAY);
                newPassField.setEchoChar((char) 0);
                newPassField.setMaximumSize(new Dimension(550, 35));
                newPassField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                bodyPanel.add(newPassField);
                bodyPanel.add(Box.createVerticalStrut(18));
                    // Focus Listener
                    newPassField.addFocusListener(new FocusAdapter(){
                        public void focusGained(FocusEvent e) {
                            String text = new String(newPassField.getPassword());
                            if(text.equals("Enter new password")) {
                                newPassField.setText("");
                                newPassField.setForeground(Color.BLACK);
                                newPassField.setEchoChar('•');
                            }
                        }
                        
                        public void focusLost(FocusEvent e) {
                            String text = new String(newPassField.getPassword());
                            if(text.isEmpty()) {
                                newPassField.setText("Enter new password");
                                newPassField.setForeground(Color.GRAY);
                                newPassField.setEchoChar((char) 0);
                                
                            }
                        }
                    });
                    
                // Confirm Password
                JLabel conPassLabel = new JLabel("Confirm New Password");
                conPassLabel.setFont(new Font("Arial", Font.BOLD, 15));
                conPassLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(conPassLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JPasswordField conPassField = new JPasswordField("Enter new password");
                conPassField.setFont(new Font("Arial", Font.PLAIN, 15));
                conPassField.setAlignmentX(Component.LEFT_ALIGNMENT);
                conPassField.setForeground(Color.GRAY);
                conPassField.setEchoChar((char) 0);
                conPassField.setMaximumSize(new Dimension(550, 35));
                conPassField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 204)),
                        BorderFactory.createEmptyBorder(6, 10, 6, 10)
                ));
                bodyPanel.add(conPassField);
                bodyPanel.add(Box.createVerticalStrut(25));
                    // Focus Listener
                    conPassField.addFocusListener(new FocusAdapter(){
                        public void focusGained(FocusEvent e) {
                            String text = new String(conPassField.getPassword());
                            if(text.equals("Enter new password")) {
                                conPassField.setText("");
                                conPassField.setForeground(Color.BLACK);
                                conPassField.setEchoChar('•');
                            }
                        }
                        
                        public void focusLost(FocusEvent e) {
                            String text = new String(conPassField.getPassword());
                            if(text.isEmpty()) {
                                conPassField.setText("Enter new password");
                                conPassField.setForeground(Color.GRAY);
                                conPassField.setEchoChar((char) 0);
                                
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
        
        saveButton.addActionListener(e -> {
            // Get all values
            String staffId = "S001"; // Will be brought in from Login.java
            String newEmail = emailField.getText().trim();
            String newPhone = phoneField.getText().trim();
            String oldPass = new String(oldPassField.getPassword()).trim();
            String newPass = new String(newPassField.getPassword()).trim();
            String conPass = new String(conPassField.getPassword()).trim();
            
            // Validation
                // Check empty fields
                if ((newEmail.isEmpty() || newEmail.equals("Enter email address")) ||
                    (newPhone.isEmpty() || newPhone.equals("Enter phone number"))) {
                    JOptionPane.showMessageDialog(this,
                            "Please fill in all fields!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Check if old password is correct
                java.util.List<String> lines = FileManager.readFile("counterStaffs.txt");
                String currentPassword = "";
                for (String line : lines) {
                    String[] parts = line.split("\\|");
                    if (parts[0].equals(staffId)) {
                        currentPassword = parts[4];
                        break;
                    }
                }
                
                if (!oldPass.equals(currentPassword)) {
                    JOptionPane.showMessageDialog(this, 
                            "Old password is incorrect!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Check if new password and confirm new password matches, and are not equal "Enter new password"
                if (!newPass.equals(conPass)) {
                    JOptionPane.showMessageDialog(this, 
                            "New password and confirm password do not match!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (newPass.equals("Enter new password" )||
                        conPass.equals("Enter new password")) {
                    JOptionPane.showMessageDialog(this, 
                            "please enter new password!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Update file counterStaffs.txt
                for (int i = 0; i < lines.size(); i++) {
                    String[] parts = lines.get(i).split("\\|");
                    if (parts[0].equals(staffId)) {
                        // Keep id and name, update email, contact and password
                        lines.set(i, staffId + "|" + parts[1] + "|" + newPhone +
                                "|" + newEmail + "|" + newPass);
                        break;
                    }
                }
                
                FileManager.writeFile("counterStaffs.txt", lines);
                
                JOptionPane.showMessageDialog(this, 
                        "Profile updated successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                
                dispose();
                new StaffDashboard();
        });
        
        backButton.addActionListener(e -> {
            dispose();
            new StaffDashboard();
        });
        
        cancelButton.addActionListener(e -> {
            dispose();
            new StaffDashboard();
        });
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new EditProfile();
    }
}
