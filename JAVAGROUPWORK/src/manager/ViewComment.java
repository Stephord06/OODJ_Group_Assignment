/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class ViewComment {
    
    private  ArrayList<String> id = new ArrayList<>();
    private JFrame Frame;
    
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JTextField search;
    
    public void ViewCommentUI(){
        Frame = new JFrame();
        Frame.setSize(800, 500);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        
        Frame.add(ViewCommentUIPanel());
        
        
    }
    
    private JPanel ViewCommentUIPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0,20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //top bar panel
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true), BorderFactory.createEmptyBorder(10,10,10,10)));
        topBar.setBackground(Color.GRAY);

        JLabel title = new JLabel("View Feedback");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        
        JPanel filtersSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        filtersSearch.setBackground(Color.GRAY);
        
        JLabel searchLabel = new JLabel("Search appointment Id:");
        searchLabel.setBackground(Color.WHITE);
        
        search = new JTextField("Search Appointnment");
        search.setPreferredSize(new Dimension(100,25));
        search.setBackground(Color.WHITE);
        
        filtersSearch.add(searchLabel);
        filtersSearch.add(search);
        
       
        topBar.add(title, BorderLayout.WEST);
        topBar.add(filtersSearch, BorderLayout.EAST);
        
        //back button
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton backbtn = new JButton("Back");
        backPanel.add(backbtn);
        //event handler
        
        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Search Appointnment")) {
                    search.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (search.getText().isEmpty()) {
                    search.setText("Search Appointnment");
                }
            }
        });
        
        search.getDocument().addDocumentListener(new DocumentListener(){
           
            @Override
            public void insertUpdate(DocumentEvent e){ 
                refresh();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e){
               refresh();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e){
                
            }
        });
        
        backbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Frame.dispose(); 
            ManagerDashBoard back = new ManagerDashBoard();
            back.DashBoardUI();
            }
        });
        
        mainPanel.add(topBar, BorderLayout.NORTH);
        mainPanel.add(addCard("appointments.txt", ""), BorderLayout.CENTER); 
        mainPanel.add(backPanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    public JScrollPane addCard(String File, String id){
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        boolean found = false;
        
        
        try(BufferedReader br = new BufferedReader(new FileReader(File))){ 

           String line;
           while ((line = br.readLine()) != null){
               String[] parts = line.split("\\|");
               
               this.id.add(parts[0]);
               
                if (parts.length >= 10) {   
                    if(id.isEmpty()){
                        cardPanel.add(CardMake(parts));
                    }
                    else if(id.equals(parts[0]))
                    {
                        cardPanel.add(CardMake(parts));
                        break;
                        
                    }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
            


        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(cardPanel, BorderLayout.NORTH);
        
        scrollPane = new JScrollPane(wrapper);
        
        return scrollPane;
    }
    
    private JPanel CardMake(String[] line){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,0));
        panel.setBorder(BorderFactory.createCompoundBorder
        (BorderFactory.createEmptyBorder(10,10,10,10), BorderFactory.createLineBorder(Color.GRAY, 1, true)));
        
        
        JPanel card1 = new JPanel(new GridLayout(3,3,10,4));
        card1.setBackground(Color.lightGray);
        
        JPanel card2 = new JPanel();
        card2.setLayout(new BoxLayout(card2, BoxLayout.Y_AXIS));
        card2.setBackground(Color.lightGray);

            
        JLabel appointment = new JLabel("Appointment# "+line[0]);
        JLabel customer = new JLabel("CustomerID : "+ line[1]);
        JLabel service = new JLabel("Service : "+ line[4]);
        JLabel date = new JLabel("Date : " + line[5]);
        JLabel technician = new JLabel("TechnicianID : "+ line[2]);    //REMEMBER FIX THE COLUMNS
        JLabel counterStaff = new JLabel("Counter Staff ID :"+ line[3]);



        JLabel customerComment = new JLabel("Customer Comment : " + line[9]);

        JLabel technicianComment = new JLabel("Technician FeedBack :"  + line[8]);

        card1.add(appointment);
        card1.add(service);
        card1.add(date);
        card1.add(technician);
        card1.add(counterStaff);
        card1.add(customer);

        card2.add(customerComment);

        card2.add(technicianComment);

        
        panel.add(card1);
        panel.add(card2);
        
        
        
        return panel;
    }
    
    private void refresh() {

            if (scrollPane != null) {
                mainPanel.remove(scrollPane);
            }
            String query = search.getText();

            mainPanel.add(addCard("appointments.txt", query), BorderLayout.CENTER);
            mainPanel.revalidate();
            
        }
}
    