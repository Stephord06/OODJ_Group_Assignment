
package counterstaff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import GeneralTools.User;

public class CollectPayment extends JFrame{
    
    private User currentUser;
    
    public CollectPayment(User user) {
        this.currentUser = user;
        
        setTitle("APU - Automotive Service Centre | Collect Payment");
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
                JLabel titleLabel = new JLabel("Collect Payment");
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
                    
                    JLabel payDetailsLabel = new JLabel("Payment Details  —  select an appointment"); 
                    JLabel cusValue = new JLabel("-");
                    JLabel serviceValue = new JLabel("-");
                    JLabel techValue = new JLabel("-");
                    JLabel dateValue = new JLabel("-");
                    JLabel timeValue = new JLabel("-");
                    JLabel totalValue = new JLabel("-");
                    
                    // Track selected appointment
                    String[] selectedApp = new String[6]; // Stores the currently clicked appointment
                    
                    cusValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    serviceValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    techValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    dateValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    timeValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    totalValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    wrapperPanel.add(Box.createHorizontalStrut(20));
                    
                        // Completed Appointment list
                        JLabel comAppLabel = new JLabel("Completed Appointments");
                        comAppLabel.setFont(new Font("Arial", Font.BOLD, 16));
                        comAppLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        leftCol.add(comAppLabel);
                        leftCol.add(Box.createVerticalStrut(10));
                        
                            // Appointment List - using JPanel inside JScrollPane
                            JPanel appListPanel = new JPanel();
                            appListPanel.setLayout(new BoxLayout(appListPanel, BoxLayout.Y_AXIS));
                            appListPanel.setBackground(Color.WHITE);
                            
                            JScrollPane appScroll = new JScrollPane(appListPanel);
                            appScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
                            appScroll.setBorder(BorderFactory.createEmptyBorder());
                            appScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            appScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                            leftCol.add(appScroll);
                            
                            // Load completed appointments from appointment.txt
                            java.util.List<String> appointmentLines = FileManager.readFile("appointments.txt");
                            
                            for (String line : appointmentLines) {
                                String[] parts = line.split("\\|");
                                
                                // Only show completed appointments
                                if (!parts[10].equals("Completed")) {
                                    continue;
                                }
                                
                                String appId = parts[0];
                                String customerId = parts[1];
                                String techId = parts[2];
                                String service = parts[4];
                                String date = parts[5];
                                String timeStart = parts[6];
                                
                                // Look for names using id
                                String customerName = FileManager.getNameFromFile("customers.txt", customerId);
                                String techName = FileManager.getNameFromFile("technicians.txt", techId);
                                
                                String[] app = {
                                    appId,
                                    customerName,
                                    date,
                                    timeStart,
                                    service,
                                    techId + " - " + techName
                                };
                                
                                // Card
                                JPanel card = new JPanel();
                                card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
                                card.setBackground(Color.WHITE);
                                card.setBorder(BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                                        BorderFactory.createEmptyBorder(10, 12, 10, 12)
                                ));
                                card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
                                card.setAlignmentX(Component.LEFT_ALIGNMENT);
                                card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                
                                JLabel idLabel = new JLabel(app[0]);
                                idLabel.setFont(new Font("Arial", Font.BOLD, 13));
                                idLabel.setForeground(new Color(218, 87, 0));
                                
                                JLabel infoLabel = new JLabel(app[1] + " | " + app[2]);
                                infoLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                                infoLabel.setForeground(Color.BLACK);
                                
                                JLabel serviceInfoLabel = new JLabel(app[4] + " · " + app[5]);
                                serviceInfoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                                serviceInfoLabel.setForeground(Color.GRAY);
                                
                                card.add(idLabel);
                                card.add(Box.createVerticalStrut(3));
                                card.add(infoLabel);
                                card.add(Box.createVerticalStrut(3));
                                card.add(serviceInfoLabel);
                                
                                // Hover effect
                                card.addMouseListener(new MouseAdapter(){
                                   public void mouseEntered(MouseEvent e) {
                                       card.setBackground(new Color(255, 248, 245));
                                       card.setBorder(BorderFactory.createCompoundBorder(
                                               BorderFactory.createLineBorder(new Color(218, 87, 0)),
                                               BorderFactory.createEmptyBorder(10, 12, 10, 12)
                                       ));
                                   } 
                                   
                                   public void mouseExited(MouseEvent e) {
                                       card.setBackground(Color.WHITE);
                                       card.setBorder(BorderFactory.createCompoundBorder(
                                               BorderFactory.createLineBorder(new Color(220, 220, 220)),
                                               BorderFactory.createEmptyBorder(10, 12, 10, 12)
                                       ));
                                   }
                                   
                                   // Click to load appointment details in the box details
                                   public void mouseClicked(MouseEvent e) {
                                       // Update payment details box
                                       payDetailsLabel.setText("Payment Details — " + app[0]);
                                       cusValue.setText(app[1]);
                                       dateValue.setText(app[2]);
                                       timeValue.setText(app[3]);
                                       serviceValue.setText(app[4]);
                                       techValue.setText(app[5]);
                                       
                                       // Load price from prices.txt
                                       String price = FileManager.getPriceFromFile(app[4]);
                                       totalValue.setText("RM " + price);
                                       
                                       // Store selected appointment
                                       selectedApp[0] = app[0]; // Appointment ID
                                       selectedApp[1] = app[1]; // Customer Name
                                       selectedApp[2] = app[2]; // Date
                                       selectedApp[3] = app[3]; // Time
                                       selectedApp[4] = app[4]; // Service
                                       selectedApp[5] = app[5]; // Technician
                                   }
                                });
                                
                                appListPanel.add(card);
                                appListPanel.add(Box.createVerticalStrut(8));
                            }

                                
                        
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
                    rightCol.setPreferredSize(new Dimension(400, 0));
                    rightCol.setMaximumSize(new Dimension(400, Integer.MAX_VALUE));
                    wrapperPanel.add(rightCol);
                    
                        // Payment Details (display all the paid appointment info)
                        payDetailsLabel.setFont(new Font("Arial", Font.BOLD, 16));
                        payDetailsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        rightCol.add(payDetailsLabel);
                        rightCol.add(Box.createVerticalStrut(20));
                        
                        // Detail box
                        JPanel detailBox = new JPanel();
                        detailBox.setLayout(new GridLayout(6, 2, 0, 12));
                        detailBox.setBackground(new Color(245, 245, 245));
                        detailBox.setAlignmentX(Component.LEFT_ALIGNMENT);
                        detailBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 230));
                        detailBox.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
                        rightCol.add(detailBox);
                        rightCol.add(Box.createVerticalStrut(16));    
                        
                            // Customer
                            JLabel cusLabel = new JLabel("Customer");
                            cusLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            cusLabel.setForeground(Color.GRAY);
                            detailBox.add(cusLabel);         
                            
                            cusValue.setFont(new Font("Arial", Font.BOLD, 13));
                            detailBox.add(cusValue); 
                            
                            // Service
                            JLabel serviceLabel = new JLabel("Service");
                            serviceLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            serviceLabel.setForeground(Color.GRAY);
                            detailBox.add(serviceLabel);         

                            serviceValue.setFont(new Font("Arial", Font.BOLD, 13));
                            detailBox.add(serviceValue); 
                            
                            // Technician
                            JLabel techLabel = new JLabel("Technician");
                            techLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            techLabel.setForeground(Color.GRAY);
                            detailBox.add(techLabel);         

                            techValue.setFont(new Font("Arial", Font.BOLD, 13));
                            detailBox.add(techValue); 
                            
                            // Date
                            JLabel dateLabel = new JLabel("Date");
                            dateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            dateLabel.setForeground(Color.GRAY);
                            detailBox.add(dateLabel);         

                            dateValue.setFont(new Font("Arial", Font.BOLD, 13));
                            detailBox.add(dateValue); 
                            
                            // Time slot
                            JLabel timeLabel = new JLabel("Time Slot");
                            timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            timeLabel.setForeground(Color.GRAY);
                            detailBox.add(timeLabel);         

                            timeValue.setFont(new Font("Arial", Font.BOLD, 13));
                            detailBox.add(timeValue); 
                            
                            // Total Amount
                            JLabel totalLabel = new JLabel("Total Amount");
                            totalLabel.setFont(new Font("Arial", Font.BOLD, 15));
                            totalLabel.setForeground(new Color(218, 87, 0));
                            detailBox.add(totalLabel);         

                            totalValue.setFont(new Font("Arial", Font.BOLD, 15));
                            totalValue.setForeground(new Color(218, 87, 0));
                            detailBox.add(totalValue); 
                            
                            
                            
                        
                        // Payment Method Label
                        JLabel methodLabel = new JLabel("Payment Method");
                        methodLabel.setFont(new Font("Arial", Font.BOLD, 15));
                        methodLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        rightCol.add(methodLabel);
                        rightCol.add(Box.createVerticalStrut(10));
                        
                        //Pay Method Buttons
                        JPanel methodPanel = new JPanel();
                        methodPanel.setLayout(new GridLayout(1, 2, 12, 0));
                        methodPanel.setBackground(Color.WHITE);
                        methodPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        methodPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
                        rightCol.add(methodPanel);
                        rightCol.add(Box.createVerticalStrut(14));
                        
                        JButton cashBtn = new JButton("CASH");
                        cashBtn.setFont(new Font("Arial", Font.BOLD, 14));
                        cashBtn.setBackground(new Color(255, 248, 245));
                        cashBtn.setForeground(new Color(218, 87, 0));
                        cashBtn.setFocusPainted(false);
                        cashBtn.setBorder(BorderFactory.createLineBorder(new Color(218, 87, 0), 2));
                        cashBtn.setPreferredSize(new Dimension(120, 35));
                        methodPanel.add(cashBtn);
                        
                        JButton cardBtn = new JButton("CARD");
                        cardBtn.setFont(new Font("Arial", Font.BOLD, 14));
                        cardBtn.setBackground(Color.WHITE);
                        cardBtn.setForeground(Color.DARK_GRAY);
                        cardBtn.setFocusPainted(false);
                        cardBtn.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
                        cardBtn.setPreferredSize(new Dimension(120, 35));
                        methodPanel.add(cardBtn);
                        
                        // Confirm button
                        JButton confirmBtn = new JButton("CONFIRM PAYMENT");
                        confirmBtn.setFont(new Font("Arial", Font.BOLD, 14));
                        confirmBtn.setBackground(new Color(218, 87, 0));
                        confirmBtn.setForeground(Color.WHITE);
                        confirmBtn.setFocusPainted(false);
                        confirmBtn.setBorderPainted(false);
                        confirmBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
                        confirmBtn.setPreferredSize(new Dimension(120, 40));
                        confirmBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
                        rightCol.add(confirmBtn);
                        rightCol.add(Box.createVerticalGlue());
                        
                
        // Action Listeners
        backButton.addActionListener(e -> {
            dispose();
            new StaffDashboard(currentUser);
        });
        
         // Toggle between Cash and Card
         cashBtn.addActionListener(e -> {
             cashBtn.setForeground(new Color(218, 87, 0));
             cashBtn.setBackground(new Color(255, 248, 245));
             cashBtn.setBorder(BorderFactory.createLineBorder(new Color(218, 87, 0), 2));
             cardBtn.setBackground(Color.WHITE);
             cardBtn.setForeground(Color.DARK_GRAY);
             cardBtn.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
         });
         
         cardBtn.addActionListener(e ->{
             cardBtn.setForeground(new Color(218, 87, 0));
             cardBtn.setBackground(new Color(255, 248, 245));
             cardBtn.setBorder(BorderFactory.createLineBorder(new Color(218, 87, 0), 2));
             cashBtn.setBackground(Color.WHITE);
             cashBtn.setForeground(Color.DARK_GRAY);
             cashBtn.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
         });
         
         // Confirm Button
         confirmBtn.addActionListener(e -> {
            // Validate appointment is selected
            if (selectedApp[0] == null) {
                JOptionPane.showMessageDialog(this, 
                        "Please select an appointment first!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Get selected payment method
            String paymentMethod;
            if (cashBtn.getBackground().equals(new Color(255, 248, 245))) {
                paymentMethod = "Cash";
            }
            else {
                paymentMethod = "Card";
            }
            
            // Get price
            String price = FileManager.getPriceFromFile(selectedApp[4]);
            
            // Auto generate Receipt ID
            String receiptId = FileManager.generateNextId("receipts.txt", "R");
            
            // Save receipt to receipts.txt
            String receiptLine = receiptId + "|" + selectedApp[0] + "|" +
                    selectedApp[1] + "|" + selectedApp[4] + "|" + selectedApp[5]
                    + "|" + selectedApp[2] + "|" + selectedApp[3] + "|" + 
                    paymentMethod + "|" + price;
            
            FileManager.appendToFile("receipts.txt", receiptLine);
            
            // Update appointment status to Paid in appointment.txt
            java.util.List<String> appLines = FileManager.readFile("appointments.txt");
            for (int i = 0; i < appLines.size(); i++) {
                String[] parts = appLines.get(i).split("\\|");
                
                if (parts[0].equals(selectedApp[0])) {
                    parts[10] = "Paid";
                    appLines.set(i, String.join("|", parts));
                    break;
                }
            }
            FileManager.writeFile("appointments.txt", appLines);
            
            // Open Receipt Frame with data
            dispose();
            new Receipt(currentUser, receiptId, selectedApp[0], selectedApp[1], selectedApp[4],
                    selectedApp[5], selectedApp[2], selectedApp[3], paymentMethod, price);
         });
                
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
    }
}
