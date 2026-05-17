
package customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProvideComment extends JFrame {
    
    private Customer Customer;
    private String id;
    private String name;
    private String password;
    
    private List<String[]> appointmentsData = new ArrayList<>();
    
    public ProvideComment(Customer customer) {
        
        this.Customer = customer;
        this.id = customer.getID();
        this.name = customer.getName();
        this.password = customer.getPassword();
        readAppointmentsData("appointments.txt");
        
        
        }
    

    
    public void UI() {
        setTitle("Comments for Counter Staff and Technician");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Value set here to bring it up to UI
        JLabel valAppId = new JLabel("-");
        JLabel valService = new JLabel("-");
        JLabel valDate = new JLabel("-");        
        JTextArea commentArea = new JTextArea(6, 20);
        List<JPanel> cardList = new ArrayList<>();
        int[] selectedIndex = {-1};
        
        // Panels
            // Root panel (holds every panels)
            JPanel rootPanel = new JPanel();
            rootPanel.setBackground(Color.LIGHT_GRAY);
            rootPanel.setLayout(new BorderLayout());
            rootPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            add(rootPanel);

            // Top Panel (holds title and back button)
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());
            topPanel.setBackground(new Color(60, 52, 137));
            topPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 3, true),
                    BorderFactory.createEmptyBorder(15, 20, 15, 20)
            ));
            
            rootPanel.add(topPanel, BorderLayout.NORTH);
            
                // Title Label
                JLabel topLabel = new JLabel("Comments for Counter Staff and Technician");
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
                    
            // Body Panel (holds left and right columns)
            JPanel bodyPanel = new JPanel();
            bodyPanel.setLayout(new GridLayout(1, 2, 10, 0));
            bodyPanel.setBackground(Color.LIGHT_GRAY);
            bodyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            rootPanel.add(bodyPanel, BorderLayout.CENTER);
                
                // Left Panel (holds appointment list)
                JPanel leftPanel = new JPanel();
                leftPanel.setLayout(new BorderLayout(0, 8));
                leftPanel.setBackground(Color.LIGHT_GRAY);
                bodyPanel.add(leftPanel);
                
                    // Left title
                    JLabel leftTitle = new JLabel("Select An Appointment");
                    leftTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
                    leftTitle.setForeground(new Color(60, 52, 137));
                    leftPanel.add(leftTitle, BorderLayout.NORTH);
                    
                    // Appointment card list panel
                    JPanel appointmentListPanel = new JPanel();
                    appointmentListPanel.setLayout(new BoxLayout(appointmentListPanel, BoxLayout.Y_AXIS));
                    appointmentListPanel.setBackground(Color.LIGHT_GRAY);
                    
                    // Wrapper and scroll pane
                    JPanel listWrapper = new JPanel();
                    listWrapper.setLayout(new BorderLayout());
                    listWrapper.setBackground(Color.LIGHT_GRAY);
                    listWrapper.add(appointmentListPanel, BorderLayout.NORTH);
                    
                    JScrollPane listScroll = new JScrollPane(listWrapper);
                    listScroll.setBorder(BorderFactory.createEmptyBorder());
                    listScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    leftPanel.add(listScroll, BorderLayout.CENTER);
                    
                        // Populate the appointment cards
                        if (appointmentsData.isEmpty()) {
                            JLabel noData = new JLabel("No appointments found.");
                            noData.setFont(new Font("SansSerif", Font.BOLD, 16));
                            noData.setAlignmentX(Component.CENTER_ALIGNMENT);
                            appointmentListPanel.add(Box.createVerticalGlue());
                            appointmentListPanel.add(noData);
                            appointmentListPanel.add(Box.createVerticalGlue());
                        }
                        else {
                            for (String[] appt : appointmentsData) {
                                JPanel card = new JPanel();
                                card.setLayout(new GridLayout(3, 1));
                                card.setBackground(Color.WHITE);
                                card.setBorder(BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
                                        BorderFactory.createEmptyBorder(10, 12, 10, 12)
                                ));
                                card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
                                card.setAlignmentX(Component.LEFT_ALIGNMENT);
                                card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                
                                // Appointment Id Label
                                JLabel cardId = new JLabel(appt[0]);
                                cardId.setFont(new Font("SansSerif", Font.BOLD, 16));
                                cardId.setForeground(new Color(60, 52, 137));
                                
                                // Service type + Date Label
                                JLabel cardService = new JLabel(appt[4] + " | " + appt[5]);
                                cardService.setFont(new Font("Arial", Font.PLAIN, 13));
                                cardService.setForeground(Color.DARK_GRAY);
                                
                                // Existing Comment
                                String existingComment;
                                if (appt[9].equals("-")) {
                                    existingComment = "No comment yet";
                                }
                                else {
                                    existingComment = appt[9];
                                }
                                JLabel cardComment = new JLabel("<html><i>" + existingComment + "</i></html>");
                                cardComment.setFont(new Font("Arial", Font.PLAIN, 12));
                                cardComment.setForeground(Color.GRAY);
                                
                                card.add(cardId);
                                card.add(cardService);
                                card.add(cardComment);
                                
                                final int idx = appointmentsData.indexOf(appt);
                                cardList.add(card);
                                
                                card.addMouseListener(new MouseAdapter(){
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        // Deselect all cards
                                        for (JPanel c : cardList) {
                                            c.setBackground(Color.WHITE);
                                            c.setBorder(BorderFactory.createCompoundBorder(
                                                    BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
                                                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
                                            ));
                                        }
                                        
                                        // Highlight selected card
                                        card.setBackground(new Color(235, 232, 255));
                                        card.setBorder(BorderFactory.createCompoundBorder(
                                                BorderFactory.createLineBorder(new Color(60, 52, 137), 2, true),
                                                BorderFactory.createEmptyBorder(10, 12, 10, 12)
                                        ));
                                        
                                        // Update selected index
                                        selectedIndex[0] = idx;
                                        
                                        // Populate right panel info box
                                        valAppId.setText(appt[0]);
                                        valService.setText(appt[4]);
                                        valDate.setText(appt[5]);
                                        
                                        // Load the existing comment into the text area
                                        if (appt[9].equals("-")) {
                                            commentArea.setText("");
                                        }
                                        else {
                                            commentArea.setText(appt[9]);
                                        }
                                    }
                                });
                                
                                appointmentListPanel.add(card);
                                appointmentListPanel.add(Box.createVerticalStrut(8));
                            }
                        }
                    
                // Right Panel (holds comments form)
                JPanel rightPanel = new JPanel();
                rightPanel.setLayout(new BorderLayout(0, 8));
                rightPanel.setBackground(Color.LIGHT_GRAY);
                bodyPanel.add(rightPanel);
                
                    // Right title
                    JLabel rightTitle = new JLabel("Write Your Comment");
                    rightTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
                    rightTitle.setForeground(new Color(60, 52, 137));
                    rightPanel.add(rightTitle, BorderLayout.NORTH);
                    
                    // Form center panel (holds info box and comment area)
                    JPanel formPanel = new JPanel();
                    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
                    formPanel.setBackground(Color.LIGHT_GRAY);
                    rightPanel.add(formPanel, BorderLayout.CENTER);
                    
                        // Info box (shows selected appointment details)
                        JPanel infoBox = new JPanel();
                        infoBox.setLayout(new GridLayout(3, 2, 0, 8));
                        infoBox.setBackground(new Color(245, 245, 245));
                        infoBox.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(210, 210, 210), 1),
                                BorderFactory.createEmptyBorder(10, 14, 10, 14)
                        ));
                        infoBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
                        infoBox.setAlignmentX(Component.LEFT_ALIGNMENT);
                        formPanel.add(infoBox);
                        formPanel.add(Box.createVerticalStrut(12));
                        
                            // Detail Labels
                            JLabel lblAppId = new JLabel("Appointment ID");
                            lblAppId.setFont(new Font("Arial", Font.PLAIN, 13));
                            lblAppId.setForeground(Color.GRAY);
                            
                            JLabel lblService = new JLabel("Service Type");
                            lblService.setFont(new Font("Arial", Font.PLAIN, 13));
                            lblService.setForeground(Color.GRAY);
                            
                            JLabel lblDate = new JLabel("Date");
                            lblDate.setFont(new Font("Arial", Font.PLAIN, 13));
                            lblDate.setForeground(Color.GRAY);
                            
                            // Value Labels
                            valAppId.setFont(new Font("Arial", Font.BOLD, 15));
                            
                            valService.setFont(new Font("Arial", Font.BOLD, 15));
                            
                            valDate.setFont(new Font("Arial", Font.BOLD, 15));
                            
                            infoBox.add(lblAppId);
                            infoBox.add(valAppId);
                            
                            infoBox.add(lblService);
                            infoBox.add(valService);
                            
                            infoBox.add(lblDate);
                            infoBox.add(valDate);
                            
                        // Comment Label
                        JLabel commentLabel = new JLabel("Comment");
                        commentLabel.setFont(new Font("Arial", Font.BOLD, 15));
                        commentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        formPanel.add(commentLabel);
                        formPanel.add(Box.createVerticalStrut(6));
                        
                        // Comment text area
                        commentArea.setFont(new Font("Arial", Font.PLAIN, 15));
                        commentArea.setLineWrap(true);
                        commentArea.setWrapStyleWord(true);
                        commentArea.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                                BorderFactory.createEmptyBorder(8, 10, 8, 10)
                        ));
                        JScrollPane commentScroll = new JScrollPane(commentArea);
                        commentScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
                        formPanel.add(commentScroll);
                        formPanel.add(Box.createVerticalStrut(12));
                        
                    // Button Panel (holds save and clear buttons)
                    JPanel btnPanel = new JPanel();
                    btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
                    btnPanel.setBackground(Color.LIGHT_GRAY);
                    rightPanel.add(btnPanel, BorderLayout.SOUTH);
                    
                        // Save button
                        JButton saveBtn = new JButton("Save Comment");
                        saveBtn.setFont(new Font("Arial", Font.BOLD, 20));
                        saveBtn.setPreferredSize(new Dimension(200, 50));
                        saveBtn.setBackground(new Color(60, 52, 137));
                        saveBtn.setForeground(Color.WHITE);
                        btnPanel.add(saveBtn);
                        
                        // Clear button
                        JButton clearBtn = new JButton("Clear");
                        clearBtn.setFont(new Font("Arial", Font.BOLD, 20));
                        clearBtn.setPreferredSize(new Dimension(150, 50));
                        clearBtn.setBackground(new Color(200, 50, 50));
                        clearBtn.setForeground(Color.WHITE);
                        btnPanel.add(clearBtn);
        
        // Action Listeners
          // Back button event
          backBtn.addActionListener(e -> {
              dispose();
              new CustomerDashBoard(Customer).UI();
          });
          
          // Clear Button event
          clearBtn.addActionListener(e -> {
              commentArea.setText("");
          });
          
          // Save Button event
          saveBtn.addActionListener(e -> {
              // validate appointment selected
              if (selectedIndex[0] == -1) {
                  JOptionPane.showMessageDialog(this, 
                          "Please select an appointment first!",
                          "No Appointment Selected",
                          JOptionPane.WARNING_MESSAGE);
                  return;
              }
              
              // Validate comment not empty
              String commentText = commentArea.getText().trim();
              if(commentText.isEmpty()) {
                  JOptionPane.showMessageDialog(this, 
                          "Please write a comment before saving!",
                          "Empty Comment",
                          JOptionPane.WARNING_MESSAGE);
                  return;
              }
              
              // Confirmation for save
              int confirm = JOptionPane.showConfirmDialog(this, 
                      "Are you sure you want to save this comment?",
                      "Save Confirmation",
                      JOptionPane.YES_NO_OPTION);
              
              if (confirm == JOptionPane.YES_OPTION) {
                  // Update data
                  appointmentsData.get(selectedIndex[0])[9] = commentText;
                  // Write into the file
                  JOptionPane.showMessageDialog(this, writeFile("appointments.txt"));
                  // Refresh card comment label
                  JPanel selectedCard = cardList.get(selectedIndex[0]);
                  JLabel lastLabel = (JLabel) selectedCard.getComponent(2);
                  lastLabel.setText("<html><i>" + commentText + "</i></html>");
                  selectedCard.revalidate();
                  selectedCard.repaint();
              }
          });
            

        setVisible(true);
            
        JOptionPane.showMessageDialog(null, "Load successfully!");
    }
    
    private String writeFile(String file) {
        List<String[]> allLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                allLines.add(line.split("\\|"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return "Save Unsuccessful";
        }
        
        // Update only this customer's rows
        for (String[] myAppt : appointmentsData) {
            for (String[] row : allLines) {
                if (row[0].equals(myAppt[0])) {
                    row[9] = myAppt[9];
                    break;
                }
            }
        }
        
        // Write everything into file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String[] row : allLines) {
                bw.write(String.join("|", row));
                bw.newLine();
            }
            return "Saved Successfully!";
        }
        catch (IOException e) {
            e.printStackTrace();
            return "Save Unsuccessful";
        }
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
    
    

    
}
    
