

package counterstaff;

import java.awt.*;
import javax.swing.*;


public class StaffDashboard {
    
    public static void main(String[] args){
        
        //panel
        JPanel mainPanel = new JPanel(); //border layout
        JPanel sidebarPanel = new JPanel(); //menu & nav buttons
        JPanel topPanel = new JPanel(); //welcome + date
        JPanel centerPanel = new JPanel(); //grid layout 1x2
        JPanel appointmentsPanel = new JPanel(); // appointment list
        JPanel technicianPanel = new JPanel(); //technician list
        JPanel metricsPanel = new JPanel(); //grid layout 1x4
            
            //color variants
            Color bgDark     = new Color(15, 17, 26);      //black 
            Color bgPanel    = new Color(22, 27, 42);      //dark navy
            Color bgCard     = new Color(30, 36, 54);      //light navy
            Color accentCyan = new Color(0, 212, 255);     //neon cyan
            Color accentBlue = new Color(63, 140, 255);    //electric blue
            Color textPri    = new Color(220, 230, 255);   //soft white
            Color textSec    = new Color(120, 140, 180);   //muted blue-grey
            
            //set colour of sidebar/panel
            sidebarPanel.setBackground(bgDark);
            mainPanel.setBackground(bgDark);
            topPanel.setBackground(bgPanel);
            centerPanel.setBackground(bgDark);
            appointmentsPanel.setBackground(bgPanel);
            technicianPanel.setBackground(bgPanel);
            metricsPanel.setBackground(bgDark);
            
            //customize sidebar
            sidebarPanel.setPreferredSize(new Dimension(200, 0));
        
            //set layout
            mainPanel.setLayout(new BorderLayout());
            centerPanel.setLayout(new GridLayout(1, 2, 10, 0));
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
            metricsPanel.setLayout(new GridLayout(3, 4, 10, 5));
            sidebarPanel.setLayout(new GridLayout(5, 1, 0, 10));
            sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
            
            //set border
            topPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
            metricsPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
            appointmentsPanel.setBorder(BorderFactory.createTitledBorder
        (BorderFactory.createLineBorder(accentCyan, 1), "ALL APPOINTMENTS", 0, 0, (new Font("Segoe UI", Font.BOLD, 24)), accentCyan));
            technicianPanel.setBorder(BorderFactory.createTitledBorder
        (BorderFactory.createLineBorder(accentCyan, 1), "TECHNICIAN STATUS", 0, 0, (new Font("Segoe UI", Font.BOLD, 24)), accentCyan));
           
        
        //frame
        JFrame dashframe = new JFrame("Staff Dashboard");
        dashframe.setSize(1100, 700);
        dashframe.setLocationRelativeTo(null);
        dashframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashframe.setLayout(new BorderLayout());
        dashframe.getContentPane().setBackground(new Color(15, 17, 26));
        
        
        // add panel
        dashframe.add(sidebarPanel, BorderLayout.WEST);
        dashframe.add(mainPanel, BorderLayout.CENTER);
        
        
        mainPanel.add(topPanel, BorderLayout.NORTH);        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(metricsPanel, BorderLayout.SOUTH);
                
        centerPanel.add(appointmentsPanel);
        centerPanel.add(technicianPanel);
        
        
        
                
        //label
            //topPanel
            JLabel lbl1 = new JLabel("Welcome, name");
            lbl1.setForeground(accentCyan);
            lbl1.setFont(new Font("Segoe UI", Font.BOLD, 20));
            
            JLabel lbl2 = new JLabel("day, DD-MM-YY —— APU Automotive Service Centre");
            lbl2.setForeground(textSec);
            lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                
                //add into topPanel
                topPanel.add(lbl1);
                topPanel.add(lbl2);
                
            //mainPanel
                //metricsPanel
                JLabel lbl3 = new JLabel("Total appointments");
                lbl3.setForeground(textSec);
                lbl3.setFont(new Font("Segoe UI", Font.BOLD, 16));
                
                JLabel lbl4 = new JLabel("Pending Payment");
                lbl4.setForeground(textSec);
                lbl4.setFont(new Font("Segoe UI", Font.BOLD, 16));
                
                JLabel lbl5 = new JLabel("Total Revenue");
                lbl5.setForeground(textSec);
                lbl5.setFont(new Font("Segoe UI", Font.BOLD, 16));
                
                JLabel lbl6 = new JLabel("Available technicians");
                lbl6.setForeground(textSec);
                lbl6.setFont(new Font("Segoe UI", Font.BOLD, 16));
                
                JLabel lbl7 = new JLabel("app-0");
                lbl7.setForeground(accentCyan);
                lbl7.setFont(new Font("Segoe UI", Font.BOLD, 22));
                
                JLabel lbl8 = new JLabel("pay-0");
                lbl8.setForeground(accentCyan);
                lbl8.setFont(new Font("Segoe UI", Font.BOLD, 22));
                
                JLabel lbl9 = new JLabel("RM 0");
                lbl9.setForeground(accentCyan);
                lbl9.setFont(new Font("Segoe UI", Font.BOLD, 22));
                
                JLabel lbl10 = new JLabel("0/0");
                lbl10.setForeground(accentCyan);
                lbl10.setFont(new Font("Segoe UI", Font.BOLD, 22));
                
                JLabel lbl11 = new JLabel("+0 from last login");
                lbl11.setForeground(textSec);
                lbl11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                
                JLabel lbl12 = new JLabel("awaiting collection");
                lbl12.setForeground(textSec);
                lbl12.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                
                JLabel lbl13 = new JLabel("0 receipts issued");
                lbl13.setForeground(textSec);
                lbl13.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                
                JLabel lbl14 = new JLabel("0 currently assigned");
                lbl14.setForeground(textSec);
                lbl14.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                
                    //add into metricsPanel
                    metricsPanel.add(lbl3);
                    metricsPanel.add(lbl4);
                    metricsPanel.add(lbl5);
                    metricsPanel.add(lbl6);
                    metricsPanel.add(lbl7);
                    metricsPanel.add(lbl8);
                    metricsPanel.add(lbl9);
                    metricsPanel.add(lbl10);
                    metricsPanel.add(lbl11);
                    metricsPanel.add(lbl12);
                    metricsPanel.add(lbl13);
                    metricsPanel.add(lbl14);
                    
                //appointmentsPanel
                
                    
                    //add into appointmentsPanel
                    
                
                //technicianPanel
                
                
                    //add into technicianPanel
                    
                    
        //button
            //sidebarPanel
            
            JButton btnApp = new JButton("Appointments");
            btnApp.setMaximumSize(new Dimension(200, 50));
            
            JButton btnCus = new JButton("Customers");
            btnCus.setMaximumSize(new Dimension(200, 50));
            
            JButton btnPay = new JButton("Payment");
            btnPay.setMaximumSize(new Dimension(200, 50));
            
            JButton btnPro = new JButton("My Profile");
            btnPro.setMaximumSize(new Dimension(200, 50));
            
            JButton btnLog = new JButton("Logout");
            btnLog.setMaximumSize(new Dimension(200, 50));
            
                //add into sidebarPanel
                sidebarPanel.add(Box.createVerticalStrut(10));
                
                sidebarPanel.add(btnApp);
                sidebarPanel.add(Box.createVerticalStrut(8));
                
                sidebarPanel.add(btnCus);
                sidebarPanel.add(Box.createVerticalStrut(8));
                
                sidebarPanel.add(btnPay);
                sidebarPanel.add(Box.createVerticalStrut(8));
                
                sidebarPanel.add(btnPro);
                sidebarPanel.add(Box.createVerticalStrut(8));
                
                sidebarPanel.add(btnLog);
                sidebarPanel.add(Box.createVerticalStrut(8));
        
        
        
        
        dashframe.setVisible(true);
    }
}
