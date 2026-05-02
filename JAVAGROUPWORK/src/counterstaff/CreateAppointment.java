
package counterstaff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class CreateAppointment extends JFrame{
    
    public CreateAppointment() {
        setTitle("APU - Automotive Service Centre | Create Appointment");
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
                JLabel titleLabel = new JLabel("Create Appointment");
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
                
            // Body Panel (holds 2 columns)
            JPanel bodyPanel = new JPanel();
            bodyPanel.setLayout(new BorderLayout());
            bodyPanel.setBackground(Color.WHITE);
            bodyPanel.setBorder(BorderFactory.createEmptyBorder(24, 0, 0, 0));
            rootPanel.add(bodyPanel, BorderLayout.CENTER);
            
                // Wrapper Panel (holds left col, divider and right col side by side)
                JPanel wrapperPanel = new JPanel();
                wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.X_AXIS));
                wrapperPanel.setBackground(Color.WHITE);
                bodyPanel.add(wrapperPanel, BorderLayout.CENTER);
                
                    // Left Column
                    JPanel leftCol = new JPanel();
                    leftCol.setLayout(new BoxLayout(leftCol, BoxLayout.Y_AXIS));
                    leftCol.setBackground(Color.WHITE);
                    leftCol.setPreferredSize(new Dimension(350, 0));
                    leftCol.setMaximumSize(new Dimension(350, Integer.MAX_VALUE));
                    wrapperPanel.add(leftCol);
                    
                    wrapperPanel.add(Box.createHorizontalStrut(20));

                        // Appointment ID
                        JLabel appIdLabel = new JLabel("Appointment ID (auto-generated)");
                        appIdLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        appIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        leftCol.add(appIdLabel);
                        leftCol.add(Box.createVerticalStrut(6));

                        JTextField appIdField = new JTextField("A001"); //auto generated later
                        appIdField.setFont(new Font("Arial", Font.PLAIN, 14));
                        appIdField.setBackground(new Color(245, 245, 245));
                        appIdField.setForeground(Color.GRAY);
                        appIdField.setEditable(false);
                        appIdField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
                        appIdField.setAlignmentX(Component.LEFT_ALIGNMENT);
                        appIdField.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(204, 204, 204)),
                                BorderFactory.createEmptyBorder(6, 10, 6, 10)
                        ));
                        leftCol.add(appIdField);
                        leftCol.add(Box.createVerticalStrut(16));

                        // Customer Search
                        JLabel customerLabel = new JLabel("Customer");
                        customerLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        customerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        leftCol.add(customerLabel);
                        leftCol.add(Box.createVerticalStrut(6));

                        JTextField customerSearchField = new JTextField("Type to search customer...");
                        customerSearchField.setFont(new Font("Arial", Font.PLAIN, 14));
                        customerSearchField.setForeground(Color.GRAY);
                        customerSearchField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
                        customerSearchField.setAlignmentX(Component.LEFT_ALIGNMENT);
                        customerSearchField.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(204, 204, 204)),
                                BorderFactory.createEmptyBorder(6, 10, 6, 10)
                        ));
                        leftCol.add(customerSearchField);
                        leftCol.add(Box.createVerticalStrut(6));

                        //Customer list
                        DefaultListModel<String> customerListModel = new DefaultListModel<>();
                        customerListModel.addElement("C001 - Ahmad Razif"); // will read from txt later
                        customerListModel.addElement("C002 - Siti Aisyah");
                        customerListModel.addElement("C003 - Raj Kumar");
                        customerListModel.addElement("C004 - Lee Han Ming");
                        customerListModel.addElement("C005 - Chow Booh Hwa");
                        customerListModel.addElement("C006 - Wong Zheng Jun");

                        JList<String> customerList = new JList<>(customerListModel);
                        customerList.setFont(new Font("Arial", Font.PLAIN, 14));
                        customerList.setSelectionBackground(new Color(218, 87, 0));
                        customerList.setSelectionForeground(Color.WHITE);
                        customerList.setFixedCellHeight(30);

                        JScrollPane customerScroll = new JScrollPane(customerList);
                        customerScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
                        customerScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
                        leftCol.add(customerScroll);
                        leftCol.add(Box.createVerticalStrut(16));

                        //Search focus listener
                        customerSearchField.addFocusListener(new FocusAdapter() {
                           public void focusGained(FocusEvent e) {
                               if(customerSearchField.getText().equals("Type to search customer...")){
                                   customerSearchField.setText("");
                                   customerSearchField.setForeground(Color.BLACK);
                               }
                           }

                           public void focusLost(FocusEvent e) {
                               if(customerSearchField.getText().isEmpty()){
                                   customerSearchField.setText("Type to search customer...");
                                   customerSearchField.setForeground(Color.GRAY);
                               }
                           }
                        });

                        // Filter list as user types
                        customerSearchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                            public void insertUpdate(javax.swing.event.DocumentEvent e) { filter(); }
                            public void removeUpdate(javax.swing.event.DocumentEvent e) { filter(); }
                            public void changedUpdate(javax.swing.event.DocumentEvent e) { filter(); }

                            void filter() {
                                String query = customerSearchField.getText();
                                // Restore full list if placeholder showing
                                if(query.equals("Type to search customer...") || query.isEmpty()){
                                    customerListModel.clear();
                                    customerListModel.addElement("C001 - Ahmad Razif");
                                    customerListModel.addElement("C002 - Siti Aisyah");
                                    customerListModel.addElement("C003 - Raj Kumar");
                                    customerListModel.addElement("C004 - Lee Han Ming");
                                    customerListModel.addElement("C005 - Chow Booh Hwa");
                                    customerListModel.addElement("C006 - Wong Zheng Jun");
                                    return;
                                }
                                customerListModel.clear();
                                String[] allCustomers = {"C001 - Ahmad Razif", "C002 - Siti Aisyah", "C003 - Raj Kumar",
                                "C004 - Lee Han Ming", "C005 - Chow Booh Hwa", "C006 - Wong Zheng Jun"}; //will read from txt later
                                for (String c : allCustomers){
                                    if(c.toLowerCase().contains(query.toLowerCase())){
                                        customerListModel.addElement(c);
                                    }
                                }
                            }

                        });

                        // Service Type
                        JLabel serviceLabel = new JLabel("Service Type");
                        serviceLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        serviceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        leftCol.add(serviceLabel);
                        leftCol.add(Box.createVerticalStrut(6));

                        String[] serviceOptions = {"Normal Service (1 hour)", "Major Service (3 hours)"};
                        JComboBox<String> serviceCombo = new JComboBox(serviceOptions);
                        serviceCombo.setFont(new Font("Arial", Font.PLAIN, 14));
                        serviceCombo.setBackground(Color.WHITE);
                        serviceCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
                        serviceCombo.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
                        serviceCombo.setAlignmentX(Component.LEFT_ALIGNMENT);
                        leftCol.add(serviceCombo);

                    // Divider
                    JSeparator divider = new JSeparator(JSeparator.VERTICAL);
                    divider.setMaximumSize(new Dimension(2, Integer.MAX_VALUE));
                    divider.setForeground(new Color(220 , 220, 220));
                    wrapperPanel.add(divider);
                    
                    wrapperPanel.add(Box.createHorizontalStrut(20));

                    // Right Column
                    JPanel rightCol = new JPanel();
                    rightCol.setLayout(new BoxLayout(rightCol, BoxLayout.Y_AXIS));
                    rightCol.setBackground(Color.WHITE);
                    rightCol.setPreferredSize(new Dimension(350, 0));
                    rightCol.setMaximumSize(new Dimension(350, Integer.MAX_VALUE));
                    wrapperPanel.add(rightCol);
                        // Date - 3 dropdowns (day, month and year)
                        JLabel dateLabel = new JLabel("Date");
                        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        rightCol.add(dateLabel);
                        rightCol.add(Box.createVerticalStrut(6));

                        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
                        datePanel.setBackground(Color.WHITE);
                        datePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        datePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

                            // Day dropdown
                            String[] days = new String[32];
                            days[0] = "-DD-";
                            for (int i = 1; i <= 31; i++) days[i] = String.format("%02d", i);
                            JComboBox<String> dayCombo = new JComboBox<>(days);
                            dayCombo.setFont(new Font("Arial", Font.PLAIN, 14));
                            dayCombo.setBackground(Color.WHITE);
                            dayCombo.setPreferredSize(new Dimension(80, 35));
                            dayCombo.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
                            datePanel.add(dayCombo);

                            // Month dropdown
                            String[] months = {"-MM-", "January", "February", "March", "April",
                                "May", "June", "July", "August", "September", "October", 
                                "November", "December"};                   
                            JComboBox<String> monthCombo = new JComboBox<>(months);
                            monthCombo.setFont(new Font("Arial", Font.PLAIN, 14));
                            monthCombo.setBackground(Color.WHITE);
                            monthCombo.setPreferredSize(new Dimension(115, 35));
                            monthCombo.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
                            datePanel.add(monthCombo);

                            // Year dropdown
                            int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                            String[] years = new String[4];
                            years[0] = "-YYYY-";
                            for(int i = 0; i < 3; i++) years[i + 1] = String.valueOf(currentYear + i);
                            JComboBox<String> yearCombo = new JComboBox<>(years);
                            yearCombo.setFont(new Font("Arial", Font.PLAIN, 14));
                            yearCombo.setBackground(Color.WHITE);
                            yearCombo.setPreferredSize(new Dimension(95, 35));
                            yearCombo.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
                            datePanel.add(yearCombo);

                            rightCol.add(datePanel);
                            rightCol.add(Box.createVerticalStrut(16));

                        // Time slot
                        JLabel timeLabel = new JLabel("Time Slot");
                        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        rightCol.add(timeLabel);
                        rightCol.add(Box.createVerticalStrut(6));                  

                        JComboBox<String> timeCombo = new JComboBox<>();
                        timeCombo.addItem("-- Select a date first --");
                        timeCombo.setFont(new Font("Arial", Font.PLAIN, 14));
                        timeCombo.setBackground(Color.WHITE);
                        timeCombo.setAlignmentX(Component.LEFT_ALIGNMENT);
                        timeCombo.setMaximumSize(new Dimension(310, 35));
                        timeCombo.setEnabled(false);
                        rightCol.add(timeCombo);
                        rightCol.add(Box.createVerticalStrut(16));

                        // Technincian
                        JLabel techLabel = new JLabel("Technician");
                        techLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        techLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        rightCol.add(techLabel);
                        rightCol.add(Box.createVerticalStrut(6));

                        JComboBox<String> techCombo = new JComboBox<>();
                        techCombo.addItem("-- Select time slot first --");
                        techCombo.setFont(new Font("Arial", Font.PLAIN, 14));
                        techCombo.setBackground(Color.WHITE);
                        techCombo.setMaximumSize(new Dimension(310, 35));
                        techCombo.setAlignmentX(Component.LEFT_ALIGNMENT);
                        techCombo.setEnabled(false);
                        rightCol.add(techCombo);
                        rightCol.add(Box.createVerticalStrut(24));

                        //Buttons
                        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                        btnPanel.setBackground(Color.WHITE);
                        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

                        JButton confirmButton = new JButton("CONFIRM");
                        confirmButton.setBackground(new Color(218, 87, 0));
                        confirmButton.setForeground(Color.WHITE);
                        confirmButton.setFont(new Font("Arial", Font.BOLD, 14));
                        confirmButton.setFocusPainted(false);
                        confirmButton.setBorderPainted(false);
                        confirmButton.setPreferredSize(new Dimension(120, 35));
                        btnPanel.add(confirmButton);

                        btnPanel.add(Box.createHorizontalStrut(12));

                        JButton cancelButton = new JButton("CANCEL");
                        cancelButton.setBackground(new Color(218, 87, 0));
                        cancelButton.setForeground(Color.WHITE);
                        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
                        cancelButton.setFocusPainted(false);
                        cancelButton.setBorderPainted(false);
                        cancelButton.setPreferredSize(new Dimension(120, 35));
                        btnPanel.add(cancelButton);

                        rightCol.add(btnPanel);
                
        // Action Listeners
        backButton.addActionListener(e -> {
            dispose();
            new StaffDashboard();
        });
        
        cancelButton.addActionListener(e -> {
            dispose();
            new StaffDashboard();
        });
        
          // Enable time slot only when all 3 dd-mm-yyyy dropdowns are selected
          ActionListener dateListener = e -> {
              String day = (String) dayCombo.getSelectedItem();
              String month = (String) monthCombo.getSelectedItem();
              String year = (String) yearCombo.getSelectedItem();
              
              if (!day.equals("-DD-") && !month.equals("-MM-") && !year.equals("-YYYY-")){
                  // Enable time slot based on service type after all 3 date is selected
                  timeCombo.setEnabled(true);
                  timeCombo.removeAllItems();
                  String service = (String) serviceCombo.getSelectedItem();
                  if(service.equals("Normal Service (1 hour)")) {
                      String[] normalSlots = {
                          "-- Select a time slot --",
                          "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                          "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM"
                      };
                      for (String slot : normalSlots) timeCombo.addItem(slot);
                  }
                  else {
                      String[] majorSlots = {
                          "-- Select a time slot --",
                          "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                          "01:00 PM", "02:00 PM"
                      };
                      for (String slot : majorSlots) timeCombo.addItem(slot);
                  }
              }
              else {
                  // Not all selected - disable time slot and technician
                  timeCombo.removeAllItems();
                  timeCombo.addItem("-- Select a date first --");
                  timeCombo.setEnabled(false);
                  techCombo.removeAllItems();
                  techCombo.addItem("-- Select time slot first --");
                  techCombo.setEnabled(false);
              }
          };
          
            //Attach the actlistener to all 3 date dropdowns
            dayCombo.addActionListener(dateListener);
            monthCombo.addActionListener(dateListener);
            yearCombo.addActionListener(dateListener);
            
          // Update the time slots when service type changes
          serviceCombo.addActionListener(e -> {
              String day = (String) dayCombo.getSelectedItem();
              String month = (String) monthCombo.getSelectedItem();
              String year = (String) yearCombo.getSelectedItem();

              // Only update if date is already fully selected
              if (!day.equals("-DD-") && !month.equals("-MM-") && !year.equals("-YYYY-")) {
                  timeCombo.setEnabled(true);
                  timeCombo.removeAllItems();
                  String service = (String) serviceCombo.getSelectedItem();
                  if (service.equals("Normal Service (1 hour)")) {
                      String[] normalSlots = {
                          "-- Select a time slot --",
                          "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                          "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM"
                      };
                      for (String slot : normalSlots) {
                          timeCombo.addItem(slot);
                      }
                  } else {
                      String[] majorSlots = {
                          "-- Select a time slot --",
                          "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                          "01:00 PM", "02:00 PM"
                      };
                      for (String slot : majorSlots) {
                          timeCombo.addItem(slot);
                      }
                  }
                  // Reset the technicians when service type changes
                  techCombo.removeAllItems();
                  techCombo.addItem("-- Select time slot first --");
                  techCombo.setEnabled(false);
              }
          });
          
          // Enable technician dropdown when time slot is selected
          timeCombo.addActionListener(e -> {
              String selected = (String) timeCombo.getSelectedItem();
              if (selected != null && !selected.equals("-- Select a time slot --")){
                  techCombo.removeAllItems();
                  techCombo.addItem("T001 - Ali Hassan"); // Will read from txt later
                  techCombo.addItem("T002 - Ravi Kumar");
                  techCombo.setEnabled(true);
              }
              else {
                  techCombo.removeAllItems();
                  techCombo.addItem("-- Select time slot first --");
                  techCombo.setEnabled(false);
              }
          });
          
                
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new CreateAppointment();
    }
}
