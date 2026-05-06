
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
                JLabel idLabel = new JLabel("Staff ID  (auto-generated)");
                idLabel.setFont(new Font("Arial", Font.BOLD, 15));
                idLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(idLabel);
                bodyPanel.add(Box.createVerticalStrut(6));

                JTextField idField = new JTextField("S001"); //auto generated later
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
                JLabel nameLabel = new JLabel("Username");
                nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
                nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(nameLabel);
                bodyPanel.add(Box.createVerticalStrut(6));
                
                JTextField nameField = new JTextField("Han Ming"); // read from txt later
                nameField.setFont(new Font("Arial", Font.PLAIN, 15));
                nameField.setForeground(Color.BLACK);
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
                            if(nameField.getText().equals("Enter a username")) {
                                nameField.setText("");
                                nameField.setForeground(Color.BLACK);
                            }
                        }
                        
                        public void focusLost(FocusEvent e) {
                            if(nameField.getText().isEmpty()) {
                                nameField.setText("Enter a username");
                                nameField.setForeground(Color.GRAY);
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
                bodyPanel.add(Box.createVerticalStrut(20));
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
                bodyPanel.add(Box.createVerticalStrut(20));
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
                bodyPanel.add(Box.createVerticalStrut(30));
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
            //TODO: validate and save to txt later
            JOptionPane.showMessageDialog(this, "Profile updated successfully!");
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
