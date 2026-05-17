/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/**
 *
 * @author User
 */
public class ViewHistory {
    
    private Customer Customer;
    private String id;
    private String name;
    private String password;
    
    private JFrame Frame;
    
    private List<String[]> appointmentsData = new ArrayList<>();
    private List<String[]> receiptsData = new ArrayList<>();
    
    public ViewHistory(Customer customer){
        
        this.Customer = customer;
        this.id = customer.getID() ;
        this.name = customer.getName();
        this.password = customer.getPassword();
        readAppointmentsData("appointments.txt");
        readReceiptsData("receipts.txt");
        
    }
    
    public void UI(){
        Frame = new JFrame();
        Frame.setTitle("View Service History and Payment History");
        Frame.setSize(1100, 700);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);
        
        Frame.add(mainPanel());
        
        Frame.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "Load Successfully");
    }
    
    
    private JPanel mainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        //top bar panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(60, 52, 137));
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true), BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        
        //top bar left side
        JLabel topLabel = new JLabel("View Service and Payment History ");
        topLabel.setForeground(Color.WHITE);
        topLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        
        
        //top bar right side
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10,0));
        backPanel.setBackground(new Color(60, 52, 137));
        
        JLabel customerName = new JLabel(this.name);
        customerName.setForeground(Color.WHITE);
        customerName.setFont(new Font("SansSerif", Font.BOLD, 25));
        
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 25));
        
        backPanel.add(customerName);
        backPanel.add(backBtn);
        
        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(backPanel, BorderLayout.EAST);
        
        //card layout for service and price history
        CardLayout cl = new CardLayout();
        JPanel deck = new JPanel(cl);
        
        //Tab switcher bar
        JPanel tabBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        tabBar.setBackground(new Color(45, 38, 110));  // slightly darker than header
        
        JButton serviceBtn = new JButton("Service History");
        JButton paymentBtn = new JButton("Payment History");
        
        tabBar.add(serviceBtn);
        tabBar.add(paymentBtn);
        
         // Add cards to the deck with unique names
        deck.add(serviceHistoryPanel(),"Service History");
        deck.add(priceHistoryPanel(),"Payment History");
        
        
         //Event Handling
        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Frame.dispose();
                CustomerDashBoard back = new CustomerDashBoard(Customer);
                back.UI();
            }
        });
        
        serviceBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cl.show(deck, "Service History");
            }
        });
        
        paymentBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                 cl.show(deck, "Payment History");
            }
        });
         
        // Assemble
        
        JPanel northStack = new JPanel(new BorderLayout());
        northStack.add(topPanel, BorderLayout.NORTH);
        northStack.add(tabBar,   BorderLayout.SOUTH);
        
        mainPanel.add(northStack, BorderLayout.NORTH);
        mainPanel.add(deck, BorderLayout.CENTER);
        
        return mainPanel;
        
        
    }
    
    private JScrollPane priceHistoryPanel(){
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));
        
        if(receiptsData.isEmpty()){
            JLabel noData = new JLabel("No payment history found.");
            noData.setFont(new Font("SansSerif", Font.BOLD, 18));
            noData.setForeground(Color.WHITE);
            noData.setAlignmentX(Component.CENTER_ALIGNMENT);  // center the label
            panel.add(Box.createVerticalGlue());   // push to center vertically
            panel.add(noData);
            panel.add(Box.createVerticalGlue());   // push to center vertically
            
        } 
        else{
            for(String[] receipt : receiptsData){
                panel.add(priceHistoryCard(receipt[0],receipt[1],receipt[2],receipt[3],receipt[4],receipt[5]
                        ,receipt[6],receipt[7],receipt[8]));
                panel.add(Box.createVerticalStrut(10));
           }
        }
        
        JScrollPane sp = new JScrollPane(panel);
        
        return sp;
        
        
    }
    
    private JScrollPane serviceHistoryPanel(){
            
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));
        
        if(appointmentsData.isEmpty()){
            JLabel noData = new JLabel("No appointment history found.");
            noData.setFont(new Font("SansSerif", Font.BOLD, 18));
            noData.setForeground(Color.WHITE);
            noData.setAlignmentX(Component.CENTER_ALIGNMENT);  // center the label
            panel.add(Box.createVerticalGlue());   // push to center vertically
            panel.add(noData);
            panel.add(Box.createVerticalGlue());   // push to center vertically
        } 
        else{
            for(String[] appointment : appointmentsData){
                String amount = "-";                // haven't pay no amount "-"
                for(String[] receipt : receiptsData){
                    if(appointment[0].equals(receipt[1])){
                        amount = receipt[8];        //paid got amount
                        break;
                    }
                }
                panel.add(serviceHistoryCard(appointment[0],appointment[2],appointment[3],appointment[4]
                        ,amount,appointment[5],appointment[6],appointment[7],appointment[10]));
                
                panel.add(Box.createVerticalStrut(10));
           }
        }
        
        JScrollPane sp = new JScrollPane(panel);
        
        return sp;
        
    }
    
    private JPanel priceHistoryCard(String receiptId, String appointmentId, String name, String service
            , String technicianId, String date, String time, String payment, String amount){
        
        JPanel panel = new JPanel(new BorderLayout(0,20));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),   // create border for the center panel;
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));
        
         // Header row
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        header.setBackground(Color.WHITE);
        
        JLabel idLabel = new JLabel(receiptId);             //appointment id
        idLabel.setFont(new Font("SansSerif", Font.BOLD, 18));   
        
        header.add(idLabel);
        
        // receipts detail
        JPanel fields = new JPanel(new GridLayout(4,2));
        
        fields.setBackground(Color.WHITE);
        
        
        fields.add(makeField("Payment ID", receiptId));
        fields.add(makeField("Appointment ID", appointmentId));
        fields.add(makeField("Customer Name", name));
        fields.add(makeField("Service Type", service));
        fields.add(makeField("Technician Id/Name", technicianId));
        fields.add(makeField("Payment Date", date));
        fields.add(makeField("Payment Method", payment));
        fields.add(makeField("Payment Amount", amount));
        
        panel.add(header, BorderLayout.NORTH);
        panel.add(fields, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel serviceHistoryCard(String appointmentId , String technicianId
            , String counterId, String service, String amount, String date, String startTime, String endTime, String status){
        
        JPanel panel = new JPanel(new BorderLayout(0, 20));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),   // create border for the center panel;
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));

        
         // Header row
        JPanel header = new JPanel(new BorderLayout(0,5));
        header.setBackground(Color.WHITE);
        
        //title panel for header row left side
        
        JPanel titleLeftPanel = new JPanel(new GridLayout(2,1));
        titleLeftPanel.setBackground(Color.WHITE);
        
        JLabel idLabel = new JLabel(appointmentId);             //appointment id
        idLabel.setFont(new Font("SansSerif", Font.BOLD, 18));   
        
        
        JLabel dateLabel = new JLabel(date + "  |  " + startTime + " - " + endTime);  // fixed spacing
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        dateLabel.setForeground(new Color(100, 100, 100));
        
        titleLeftPanel.add(idLabel);
        titleLeftPanel.add(dateLabel);
        
        
        // result label for header row right side
        JLabel badge  = new JLabel(status);  //result, etc pending,complete
        badge.setFont(new Font("Arial", Font.BOLD, 11));
        badge.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
        badge.setOpaque(true);                  //paint its background color , turn color instead of transparent
        
        if (status.equals("Completed")) {
            badge.setBackground(Color.GREEN);
            badge.setForeground(Color.WHITE);
        } 
        else if(status.equals("Paid")) 
        {
            badge.setBackground(new Color(88, 28, 135));
            badge.setForeground(new Color(243, 232, 255));
        }
        else{
            badge.setBackground(new Color(146, 64, 14));
            badge.setForeground(new Color(254, 243, 199));
        }
        //add to header
        header.add(titleLeftPanel, BorderLayout.WEST);
        header.add(badge , BorderLayout.EAST);
        
        
        // appointment detail
        JPanel fields = new JPanel(new GridLayout(3,2));
        
        fields.setBackground(Color.WHITE);
        
        
        fields.add(makeField("Counter staff", counterId));
        fields.add(makeField("Technician", technicianId));
        fields.add(makeField("Duration", duration(service)));
        fields.add(makeField("Service type", service));
        fields.add(makeField("Amount paid", amount));
        fields.add(makeField("Status",status));
        

        
        panel.add(header, BorderLayout.NORTH);
        panel.add(fields, BorderLayout.CENTER);
        
        return panel;
        
    }
    
    
    private JPanel makeField(String label, String value) {
        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(210, 210, 210), 1),
        BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        panel.setPreferredSize(new Dimension(200, 70));  // fixed card size
        
        
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Arial", Font.PLAIN, 13));
        lbl.setForeground(Color.GRAY);
        JLabel val = new JLabel(value);
        val.setFont(new Font("Arial", Font.BOLD, 16));
        
        panel.add(lbl);
        panel.add(val);
        return panel;
    
    }
    
    private String duration(String service){
        if(service.equals("Normal Service")){
            return "1 Hour";
        }
        else{
            return "3 Hour";
        }
    }
   
    private void readAppointmentsData(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            
            while((line = br.readLine()) != null){
                String[] body = line.split("\\|");
                if(body[1].equals(this.id)){
                    appointmentsData.add(body);
                }
            } 
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void readReceiptsData(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            
            while((line = br.readLine()) != null){
                String[] body = line.split("\\|");
                for(int i = 0 ; i < appointmentsData.size() ; i++ ){           //iteration loop for row
                   if(body[1].equals(appointmentsData.get(i)[0])){             // looping each row for finding column[0] equal data
                    receiptsData.add(body);
                    } 
                }

            } 
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
