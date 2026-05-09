package counterstaff;

import GeneralTools.User;
import GeneralTools.Login;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class StaffDashboard extends JFrame {
    
    private User currentUser;
    
    public StaffDashboard(User user) {
        this.currentUser = user;
        
        setTitle("APU - Automotive Service Centre | Counter Staff Dashboard");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Panels      
            // Root panel (holds every panels)
            JPanel rootPanel = new JPanel();
            rootPanel.setLayout(new BorderLayout());
            rootPanel.setBackground(Color.WHITE);
            rootPanel.setBorder(BorderFactory.createEmptyBorder(40, 140, 40, 140));
            add(rootPanel);
        
            // Header Panel (holds welcome text and logout button)
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new BorderLayout());
            headerPanel.setBackground(Color.WHITE);
            rootPanel.add(headerPanel, BorderLayout.NORTH);
                //Left Panel
                JPanel headerLeftPanel = new JPanel();
                headerLeftPanel.setLayout(new BoxLayout(headerLeftPanel, BoxLayout.Y_AXIS));
                headerLeftPanel.setBackground(Color.WHITE);
                headerPanel.add(headerLeftPanel, BorderLayout.WEST);
                
                //Label
                JLabel welcomeLabel = new JLabel("Welcome back, " + currentUser.getName() + "!");
                welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
                welcomeLabel.setForeground(new Color(218, 87, 0));
                headerLeftPanel.add(welcomeLabel);
                
                JLabel titleLabel = new JLabel("APU Automotive Service Centre");
                titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                titleLabel.setForeground(new Color(69, 69, 69));
                headerLeftPanel.add(titleLabel);
                
                //Button
                JButton logoutButton = new JButton("LOG OUT");
                logoutButton.setBackground(Color.BLACK);
                logoutButton.setForeground(Color.WHITE);
                logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
                logoutButton.setFocusPainted(false);
                headerPanel.add(logoutButton, BorderLayout.EAST);
                
            
            // Body Panel (holds Quick Actions and Stats)
            JPanel bodyPanel = new JPanel();
            bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
            bodyPanel.setBackground(Color.WHITE);
            rootPanel.add(bodyPanel, BorderLayout.CENTER);
                //Label
                JLabel quickActLabel = new JLabel("Quick Actions");
                quickActLabel.setFont(new Font("Arial", Font.BOLD, 25));
                quickActLabel.setForeground(Color.BLACK);
                quickActLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(Box.createVerticalStrut(20));
                bodyPanel.add(quickActLabel);
                bodyPanel.add(Box.createVerticalStrut(12));
                
                
            // Action Cards Panel (holds 4 quick action cards)
            JPanel actCardsPanel = new JPanel();
            actCardsPanel.setLayout(new GridLayout(1, 4, 14, 0));
            actCardsPanel.setBackground(Color.WHITE);
            actCardsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
            actCardsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            bodyPanel.add(actCardsPanel);
                //Button
                    // Card 1 - Manage Customers
                    JButton manageCustomersBtn = new JButton("<html>Manage<br>Customers</html>");
                    manageCustomersBtn.setBackground(new Color(218, 87, 0));
                    manageCustomersBtn.setForeground(Color.WHITE);
                    manageCustomersBtn.setFont(new Font("Arial", Font.BOLD, 22));
                    manageCustomersBtn.setFocusPainted(false);
                    manageCustomersBtn.setBorderPainted(false);
                    manageCustomersBtn.setHorizontalAlignment(SwingConstants.LEFT);
                    manageCustomersBtn.setVerticalAlignment(SwingConstants.TOP);
                    manageCustomersBtn.setMargin(new Insets(12, 12, 0, 0));
                    actCardsPanel.add(manageCustomersBtn);
                    
                    // Card 2 - Create Appointment
                    JButton createAppointmentBtn = new JButton("<html>Create<br>Appointment</html>");
                    createAppointmentBtn.setBackground(new Color(218, 87, 0));
                    createAppointmentBtn.setForeground(Color.WHITE);
                    createAppointmentBtn.setFont(new Font("Arial", Font.BOLD, 22));
                    createAppointmentBtn.setFocusPainted(false);
                    createAppointmentBtn.setBorderPainted(false);
                    createAppointmentBtn.setHorizontalAlignment(SwingConstants.LEFT);
                    createAppointmentBtn.setVerticalAlignment(SwingConstants.TOP);
                    createAppointmentBtn.setMargin(new Insets(12, 12, 0, 0));
                    actCardsPanel.add(createAppointmentBtn);
                    
                    // Card 3 - Collect Payment
                    JButton collectPaymentBtn = new JButton("<html>Collect<br>Payment</html>");
                    collectPaymentBtn.setBackground(new Color(218, 87, 0));
                    collectPaymentBtn.setForeground(Color.WHITE);
                    collectPaymentBtn.setFont(new Font("Arial", Font.BOLD, 22));
                    collectPaymentBtn.setFocusPainted(false);
                    collectPaymentBtn.setBorderPainted(false);
                    collectPaymentBtn.setHorizontalAlignment(SwingConstants.LEFT);
                    collectPaymentBtn.setVerticalAlignment(SwingConstants.TOP);
                    collectPaymentBtn.setMargin(new Insets(12, 12, 0, 0));
                    actCardsPanel.add(collectPaymentBtn);
                    
                    // Card 4 - Edit Profile
                    JButton editProfileBtn = new JButton("<html>Edit<br>Profile</html>");
                    editProfileBtn.setBackground(new Color(218, 87, 0));
                    editProfileBtn.setForeground(Color.WHITE);
                    editProfileBtn.setFont(new Font("Arial", Font.BOLD, 22));
                    editProfileBtn.setFocusPainted(false);
                    editProfileBtn.setBorderPainted(false);
                    editProfileBtn.setHorizontalAlignment(SwingConstants.LEFT);
                    editProfileBtn.setVerticalAlignment(SwingConstants.TOP);
                    editProfileBtn.setMargin(new Insets(12, 12, 0, 0));
                    actCardsPanel.add(editProfileBtn);
            
            // Load stats from files
            java.util.List<String> appLines = FileManager.readFile("appointments.txt");
            java.util.List<String> receiptLines = FileManager.readFile("receipts.txt");
            java.util.List<String> customerLines = FileManager.readFile("customers.txt");
            
            // Calculate the data for each card
            int totalAppointments = appLines.size();
            int pendingPayment = 0;
            double totalRevenue = 0;
            int totalCustomers = customerLines.size();
            
            for (String line : appLines) {
                String[] parts = line.split("\\|");
                if (parts[10].equals("Completed")) {
                    pendingPayment ++;
                }
            }
            
            for (String line : receiptLines) {
                String[] parts = line.split("\\|");
                totalRevenue += Double.parseDouble(parts[8]);
            }
            
            // Stats Panel (holds 4 stat cards)
            JPanel statsPanel = new JPanel();
            statsPanel.setLayout(new GridLayout(1, 4, 20, 0));
            statsPanel.setBackground(Color.WHITE);
            statsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 270));
            statsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            bodyPanel.add(Box.createVerticalStrut(30));
            bodyPanel.add(statsPanel);                
                // Stat Card 1 - Total Appointments
                JPanel totalAppointmentsCard = new JPanel();
                totalAppointmentsCard.setLayout(new BorderLayout());
                totalAppointmentsCard.setBackground(new Color(58, 58, 58));
                statsPanel.add(totalAppointmentsCard);
                
                // Stat Card 2 - Pending Payment
                JPanel pendingPaymentCard = new JPanel();
                pendingPaymentCard.setLayout(new BorderLayout());
                pendingPaymentCard.setBackground(new Color(58, 58, 58));
                statsPanel.add(pendingPaymentCard);
                
                // Stat Card 3 - Total Revenue
                JPanel totalRevenueCard = new JPanel();
                totalRevenueCard.setLayout(new BorderLayout());
                totalRevenueCard.setBackground(new Color(58, 58, 58));
                statsPanel.add(totalRevenueCard);
                
                // Stat Card 4 - Available Technicians
                JPanel totalCustomerCard = new JPanel();
                totalCustomerCard.setLayout(new BorderLayout());
                totalCustomerCard.setBackground(new Color(58, 58, 58));
                statsPanel.add(totalCustomerCard);
                
                //Label
                    // Stat Card 1 content - Total Appointments
                    JLabel totalAppTitle = new JLabel("<html>Total<br>Appointments</html>");
                    totalAppTitle.setFont(new Font("Arial", Font.BOLD, 16));
                    totalAppTitle.setForeground(new Color(230, 224, 224));
                    totalAppTitle.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 0));
                    totalAppointmentsCard.add(totalAppTitle, BorderLayout.NORTH);
                    
                    JLabel totalAppValue = new JLabel(String.valueOf(totalAppointments));
                    totalAppValue.setFont(new Font("Arial", Font.BOLD, 48));
                    totalAppValue.setForeground(Color.WHITE);
                    totalAppValue.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 0));
                    totalAppointmentsCard.add(totalAppValue, BorderLayout.CENTER);
                    
                    JLabel totalAppSub = new JLabel("<html>across<br>all customers</html>");
                    totalAppSub.setFont(new Font("Arial", Font.BOLD, 16));
                    totalAppSub.setForeground(new Color(172, 172, 172));
                    totalAppSub.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 0));
                    totalAppointmentsCard.add(totalAppSub, BorderLayout.SOUTH);
                    
                    // Stat Card 2 content - Pending Payment
                    JLabel pendingPayTitle = new JLabel("<html>Pending<br>Payment</html>");
                    pendingPayTitle.setFont(new Font("Arial", Font.BOLD, 16));
                    pendingPayTitle.setForeground(new Color(230, 224, 224));
                    pendingPayTitle.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 0));
                    pendingPaymentCard.add(pendingPayTitle, BorderLayout.NORTH);
                    
                    JLabel pendingPayValue = new JLabel(String.valueOf(pendingPayment));
                    pendingPayValue.setFont(new Font("Arial", Font.BOLD, 48));
                    pendingPayValue.setForeground(Color.WHITE);
                    pendingPayValue.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));
                    pendingPaymentCard.add(pendingPayValue, BorderLayout.CENTER);
                    
                    JLabel pendingPaySub = new JLabel("<html>awaiting<br>collection</html>");
                    pendingPaySub.setFont(new Font("Arial", Font.BOLD, 15));
                    pendingPaySub.setForeground(new Color(172, 172, 172));
                    pendingPaySub.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 0));
                    pendingPaymentCard.add(pendingPaySub, BorderLayout.SOUTH);
                    
                    // Stat Card 3 content - Total Revenue
                    JLabel totalRevTitle = new JLabel("<html>Total<br>Revenue</html>");
                    totalRevTitle.setFont(new Font("Arial", Font.BOLD, 16));
                    totalRevTitle.setForeground(new Color(230, 224, 224));
                    totalRevTitle.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 0));
                    totalRevenueCard.add(totalRevTitle, BorderLayout.NORTH);
                    
                    JLabel totalRevValue = new JLabel("RM " + (int)totalRevenue);
                    totalRevValue.setFont(new Font("Arial", Font.BOLD, 32));
                    totalRevValue.setForeground(Color.WHITE);
                    totalRevValue.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));
                    totalRevenueCard.add(totalRevValue, BorderLayout.CENTER);
                    
                    JLabel totalRevSub = new JLabel("<html>" + receiptLines.size() + " receipts<br>issued</html>");
                    totalRevSub.setFont(new Font("Arial", Font.BOLD, 15));
                    totalRevSub.setForeground(new Color(153, 255, 109));
                    totalRevSub.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 0));
                    totalRevenueCard.add(totalRevSub, BorderLayout.SOUTH);
                    
                    // Stat Card 4 content - Available Technicians
                    JLabel totalCusTitle = new JLabel("<html>Total<br>Customers</html>");
                    totalCusTitle.setFont(new Font("Arial", Font.BOLD, 16));
                    totalCusTitle.setForeground(new Color(230, 224, 224));
                    totalCusTitle.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 0));
                    totalCustomerCard.add(totalCusTitle, BorderLayout.NORTH);
                    
                    JLabel availTechValue = new JLabel(String.valueOf(totalCustomers));
                    availTechValue.setFont(new Font("Arial", Font.BOLD, 48));
                    availTechValue.setForeground(Color.WHITE);
                    availTechValue.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));
                    totalCustomerCard.add(availTechValue, BorderLayout.CENTER);
                    
                    JLabel totalCusSub = new JLabel("<html>registered<br>customer</html>");
                    totalCusSub.setFont(new Font("Arial", Font.BOLD, 15));
                    totalCusSub.setForeground(new Color(172, 172, 172));
                    totalCusSub.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 0));
                    totalCustomerCard.add(totalCusSub, BorderLayout.SOUTH);
            
            
            // Action Listeners for Quick Action Buttons
            manageCustomersBtn.addActionListener(e -> {
                dispose();
                new ManageCustomer(currentUser);
            });
            
            createAppointmentBtn.addActionListener(e -> {
                dispose();
                new CreateAppointment(currentUser);
            });
            
            collectPaymentBtn.addActionListener(e -> {
                dispose();
                new CollectPayment(currentUser);
            });
            
            editProfileBtn.addActionListener(e -> {
                dispose();
                new EditProfile(currentUser);
            });
            
            logoutButton.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to log out?",
                    "Log Out",
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                    new Login().LoginPage();
                }
            });
            
            
            setVisible(true);
    }
    
    public static void main(String[] args){        

    }
}
