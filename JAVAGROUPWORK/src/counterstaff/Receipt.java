
package counterstaff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Receipt extends JFrame{
    
    public Receipt(String receiptId, String appointmentId, String customerName,
            String serviceType, String techName, String date,
            String timeSlot, String paymentMethod, String totalPaid) {
        setTitle("APU - Automotive Service Centre | Receipt");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Panels
            // Root Panel (holds every panels)
            JPanel rootPanel = new JPanel();
            rootPanel.setLayout(new BorderLayout());
            rootPanel.setBackground(Color.WHITE);
            rootPanel.setBorder(BorderFactory.createEmptyBorder(40, 200, 40, 200));
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
                JLabel titleLabel = new JLabel("Receipt");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
                titleLabel.setForeground(new Color(218, 87, 0));
                headerLeftPanel.add(titleLabel);
                
                JLabel  subLabel = new JLabel("APU Automotive Service Centre");
                subLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                subLabel.setForeground(new Color(69, 69, 69));
                headerLeftPanel.add(subLabel);
                
            // Body Panel (holds 2 columns)
            JPanel bodyPanel = new JPanel();
            bodyPanel.setLayout(new BorderLayout());
            bodyPanel.setBackground(Color.WHITE);
            bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
            rootPanel.add(bodyPanel, BorderLayout.CENTER);     
            
                // Receipt Card
                JPanel receiptCard = new JPanel();
                receiptCard.setLayout(new BorderLayout());
                receiptCard.setBackground(new Color(58, 58, 58));
                receiptCard.setBorder(BorderFactory.createEmptyBorder(24, 30, 24, 30));
                bodyPanel.add(receiptCard, BorderLayout.CENTER);  
                
                    // Top Section (title + subtitle)
                    JPanel topSection = new JPanel();
                    topSection.setLayout(new BoxLayout(topSection, BoxLayout.Y_AXIS));
                    topSection.setBackground(new Color(58, 58, 58));
                    receiptCard.add(topSection, BorderLayout.NORTH);
                    
                        // Title
                        JLabel recTitle = new JLabel("APU - ASC");
                        recTitle.setFont(new Font("Arial", Font.BOLD, 22));
                        recTitle.setForeground(Color.WHITE);
                        recTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
                        recTitle.setHorizontalAlignment(SwingConstants.CENTER);
                        recTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                        topSection.add(recTitle);
                        topSection.add(Box.createVerticalStrut(4));

                        JLabel recSubTitle = new JLabel("APU Automotive Service Centre");
                        recSubTitle.setFont(new Font("Arial", Font.PLAIN, 13));
                        recSubTitle.setForeground(new Color(180, 180, 180));
                        recSubTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
                        recSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
                        recSubTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
                        topSection.add(recSubTitle);
                        topSection.add(Box.createVerticalStrut(16));

                        // Top Divider
                        JSeparator topDivider = new JSeparator();
                        topDivider.setForeground(new Color(100, 100, 100));
                        topSection.add(topDivider);
                        
                    // Middle Section (rows)
                    JPanel middleSection = new JPanel(new BorderLayout());
                    middleSection.setBackground(new Color(58, 58, 58));
                    middleSection.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
                    receiptCard.add(middleSection, BorderLayout.CENTER);
                    
                        // Receipt rows
                        JPanel rowsPanel = new JPanel();
                        rowsPanel.setLayout(new GridLayout(8, 2, 0, 13));
                        rowsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
                        rowsPanel.setBackground(new Color(58, 58, 58));
                        middleSection.add(rowsPanel, BorderLayout.NORTH);

                            // Receipt ID
                            JLabel recIdLabel = new JLabel("Receipt ID");
                            recIdLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            recIdLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(recIdLabel);

                            JLabel recIdValue = new JLabel(receiptId); // auto generated later
                            recIdValue.setFont(new Font("Arial", Font.BOLD, 13));
                            recIdValue.setForeground(Color.WHITE);
                            recIdValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(recIdValue);

                            // Appointment ID
                            JLabel appIdLabel = new JLabel("Appointment ID");
                            appIdLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            appIdLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(appIdLabel);

                            JLabel appIdValue = new JLabel(appointmentId); // load from txt later
                            appIdValue.setFont(new Font("Arial", Font.BOLD, 13));
                            appIdValue.setForeground(Color.WHITE);
                            appIdValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(appIdValue);

                            // Customer
                            JLabel recCusLabel = new JLabel("Customer");
                            recCusLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            recCusLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(recCusLabel);

                            JLabel recCusValue = new JLabel(customerName); // load from txt later
                            recCusValue.setFont(new Font("Arial", Font.BOLD, 13));
                            recCusValue.setForeground(Color.WHITE);
                            recCusValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(recCusValue);

                            // Service
                            JLabel recServiceLabel = new JLabel("Service");
                            recServiceLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            recServiceLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(recServiceLabel);

                            JLabel recServiceValue = new JLabel(serviceType); // load from txt later
                            recServiceValue.setFont(new Font("Arial", Font.BOLD, 13));
                            recServiceValue.setForeground(Color.WHITE);
                            recServiceValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(recServiceValue);

                            // Technician
                            JLabel recTechLabel = new JLabel("Technician");
                            recTechLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            recTechLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(recTechLabel);

                            JLabel recTechValue = new JLabel(techName); // load from txt later
                            recTechValue.setFont(new Font("Arial", Font.BOLD, 13));
                            recTechValue.setForeground(Color.WHITE);
                            recTechValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(recTechValue);

                            // Date
                            JLabel recDateLabel = new JLabel("Date");
                            recDateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            recDateLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(recDateLabel);

                            JLabel recDateValue = new JLabel(date); // load from txt later
                            recDateValue.setFont(new Font("Arial", Font.BOLD, 13));
                            recDateValue.setForeground(Color.WHITE);
                            recDateValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(recDateValue);

                            // Time Slot
                            JLabel recTimeLabel = new JLabel("Time Slot");
                            recTimeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            recTimeLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(recTimeLabel);

                            JLabel recTimeValue = new JLabel(timeSlot); // load from txt later
                            recTimeValue.setFont(new Font("Arial", Font.BOLD, 13));
                            recTimeValue.setForeground(Color.WHITE);
                            recTimeValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(recTimeValue);

                            // Payment Method
                            JLabel recPayLabel = new JLabel("Payment Method");
                            recPayLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                            recPayLabel.setForeground(new Color(180, 180, 180));
                            rowsPanel.add(recPayLabel);

                            JLabel recPayValue = new JLabel(paymentMethod);
                            recPayValue.setFont(new Font("Arial", Font.BOLD, 13));
                            recPayValue.setForeground(Color.WHITE);
                            recPayValue.setHorizontalAlignment(SwingConstants.RIGHT);
                            rowsPanel.add(recPayValue);
                    
                    // Bottom Section (divider + total + status)
                    JPanel bottomSection = new JPanel();
                    bottomSection.setLayout(new BoxLayout(bottomSection, BoxLayout.Y_AXIS));
                    bottomSection.setBackground(new Color(58, 58, 58));
                    receiptCard.add(bottomSection, BorderLayout.SOUTH);
                    
                    bottomSection.add(Box.createVerticalStrut(6));
          
                        // Bottom Divider
                        JSeparator botDivider = new JSeparator();
                        botDivider.setForeground(new Color(100, 100, 100));
                        botDivider.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
                        bottomSection.add(botDivider);
                        bottomSection.add(Box.createVerticalStrut(14));

                        // Total Paid
                        JPanel totalRow = new JPanel();
                        totalRow.setLayout(new BorderLayout());
                        totalRow.setBackground(new Color(58, 58, 58));
                        totalRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

                        JLabel totalPaidLabel = new JLabel("Total Paid");
                        totalPaidLabel.setFont(new Font("Arial", Font.BOLD, 16));
                        totalPaidLabel.setForeground(new Color(218, 87, 0));

                        JLabel totalPaidValue = new JLabel("RM " + totalPaid); // load from txt later
                        totalPaidValue.setFont(new Font("Arial", Font.BOLD, 16));
                        totalPaidValue.setForeground(new Color(218, 87, 0));
                        totalPaidValue.setHorizontalAlignment(SwingConstants.RIGHT);

                        totalRow.add(totalPaidLabel, BorderLayout.WEST);
                        totalRow.add(totalPaidValue, BorderLayout.EAST);
                        bottomSection.add(totalRow);
                        bottomSection.add(Box.createVerticalStrut(14));

                        // Payment Successful Status
                        JLabel statusLabel = new JLabel("PAYMENT SUCCESSFUL");
                        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        statusLabel.setForeground(new Color(153, 255, 109));
                        statusLabel.setBackground(new Color(26, 26, 26));
                        statusLabel.setOpaque(true);
                        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        statusLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                        statusLabel.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
                        bottomSection.add(statusLabel);
                    
                // Buttons Panel
                JPanel btnPanel = new JPanel();
                btnPanel.setLayout(new GridLayout(1, 2, 12, 0));
                btnPanel.setBackground(Color.WHITE);
                btnPanel.setBorder(BorderFactory.createEmptyBorder(16, 0, 0, 0));
                bodyPanel.add(btnPanel, BorderLayout.SOUTH);
                
                    // Buttons
                    JButton dashBtn = new JButton("BACK TO DASHBOARD");
                    dashBtn.setBackground(new Color(218, 87, 0));
                    dashBtn.setForeground(Color.WHITE);
                    dashBtn.setFont(new Font("Arial", Font.BOLD, 14));
                    dashBtn.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
                    dashBtn.setFocusPainted(false);
                    dashBtn.setBorderPainted(false);
                    btnPanel.add(dashBtn);
                    
                    JButton newAppBtn = new JButton("CREATE NEW APPOINTMENT");
                    newAppBtn.setBackground(Color.WHITE);
                    newAppBtn.setForeground(Color.BLACK);
                    newAppBtn.setFont(new Font("Arial", Font.BOLD, 14));
                    newAppBtn.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
                    newAppBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK , 2));
                    newAppBtn.setFocusPainted(false);
                    btnPanel.add(newAppBtn);
                    
        // Action Listeners      
        dashBtn.addActionListener(e -> {
            dispose();
            new StaffDashboard();
        });
        
        newAppBtn.addActionListener(e -> {
            dispose();
            new CreateAppointment();
        });
                
                    
        setVisible(true);
        
 
    }
    
    
    public static void main(String[] args) {
        // dummy data for testing
        new Receipt("R001", "A001", "Ahmad Razif", "Normal Service",
                "T001 - Ali Hassan", "16-05-2026", "09:00 AM", "Cash", "200.00");
    }
}
