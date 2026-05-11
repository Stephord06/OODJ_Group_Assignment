/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class AnalyzedReport {
    

    private JFrame Frame;
    private List<String[]> DataList = new ArrayList<>();
    
    private JComboBox<String> monthBox;
    private JComboBox<String> serviceBox;
    
    public void AnalyzedReportUI(){
        Frame = new JFrame("AnalyzedReport");
        Frame.setSize(800,500);
        Frame.setLayout(new BorderLayout());
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        
        Frame.add(AnalyzedReportPanel());       
    }
    
    public JPanel  AnalyzedReportPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0,20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        mainPanel.setBackground(Color.GRAY);

        //top bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.GRAY);

        JLabel title = new JLabel("Analyzed Reports - Overview");
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel filters = new JPanel(new FlowLayout(FlowLayout.RIGHT, 18, 0));
        filters.setBackground(Color.GRAY);

        String[] months = {"January","February","March","April","May","June","July","August"
                ,"September","Octorber","November","December"};

        String[] services = {"All","Normal","Major"};
        monthBox = new JComboBox<>(months);
        serviceBox = new JComboBox<>(services);

        monthBox.setFont(new Font("Arial", Font.PLAIN, 13));
        serviceBox.setFont(new Font("Arial", Font.PLAIN, 13));
        monthBox.setPreferredSize(new Dimension(120, 30));
        serviceBox.setPreferredSize(new Dimension(100, 30));

        filters.add(monthBox);
        filters.add(serviceBox);

        topBar.add(title,BorderLayout.WEST);
        topBar.add(filters, BorderLayout.EAST);


        //Center component

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.GRAY);

        JPanel indicator = new JPanel();
        indicator.setLayout(new GridLayout(1, 4, 12, 0));
        indicator.setBackground(Color.GRAY);

        //add component insdie the indicator

        indicator.add(makeCard("Total Revenue", "RM 0"));
        indicator.add(makeCard("Totap Appointments", "0"));
        indicator.add(makeCard("Total Paid Appointments", "0"));
        indicator.add(makeCard("Total Customer Comments", "0 / 5"));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets  = new Insets(40, 60, 40, 60);

        centerPanel.add(indicator, gbc);



        // button and panel
        JPanel panelbtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelbtn.setBackground(Color.GRAY);

        JButton checkbtn = new JButton("Check");
        panelbtn.add(checkbtn);

        JButton backbtn = new JButton("Back");
        panelbtn.add(backbtn);

        //event handler

        checkbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                indicator.removeAll();

                // Add updated cards
                indicator.add(makeCard("Total Revenue", "RM " + TotalRevenue()));
                indicator.add(makeCard("Totap Appointments", TotalAppointments()));
                indicator.add(makeCard("Total Paid Appointments", TotalPaidAppointments()));
                indicator.add(makeCard("Total Customer Comments", TotalCustomerComments()));

                // Refresh the panel
                indicator.revalidate();
            }
        });

        backbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Frame.dispose();
                ManagerDashBoard md = new ManagerDashBoard();
                md.DashBoardUI();
            }
        });

        // add to the mainpanel
        mainPanel.add(topBar,BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(panelbtn, BorderLayout.SOUTH);

        return mainPanel;

    }
    
    public JPanel makeCard(String label, String value){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
       
        JLabel labelText = new JLabel(label);
        labelText.setFont(new Font("Arial", Font.PLAIN, 13));
        labelText.setForeground(Color.DARK_GRAY);
        
        JLabel valueText = new JLabel(value);
        valueText.setFont(new Font("Arial", Font.BOLD, 20));
        valueText.setForeground(Color.DARK_GRAY);
        
        panel.add(labelText);
        panel.add(Box.createVerticalStrut(10));
        panel.add(valueText);
        
        return panel ;
    }
    
    private String TotalRevenue() {
        List<Double> lines = readfile(8, 3, serviceBox.getSelectedItem().toString(), "receipts.txt");
        double total = 0;
        for (double value : lines) {
            total += value;
        }
        return String.format("%.2f", total);
    }
    
    private String TotalAppointments() {
        return String.valueOf(countRows(4, 4, serviceBox.getSelectedItem().toString(), "appointments.txt"));
    }
    
    private String TotalPaidAppointments() {
        return String.valueOf(countRows(3, 3, serviceBox.getSelectedItem().toString(), "receipts.txt"));
    }
    
    private String TotalCustomerComments() {
        return String.valueOf(countRows(9,4, serviceBox.getSelectedItem().toString(), "appointments.txt"));
    }
    
    public List<Double> readfile(int column, int serviceColumn, String service, String file) {
    List<Double> results = new ArrayList<>();
    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (column < parts.length && !(parts[column].equals("-"))) 
            {
                boolean serviceMatch = service.equals("All") || parts[serviceColumn].equals(service);
                if (serviceMatch) {
                    results.add(Double.parseDouble(parts[column]));
                }
            }
        }
        br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
    
    public int countRows(int column,int serviceColumn, String service, String file) {
    int count = 0;
    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (serviceColumn < parts.length  && !(parts[column].equals("-")))
            {
                boolean serviceMatch = service.equals("All") || parts[serviceColumn].equals(service);
                if (serviceMatch ) { 
                    count++;
                }
            }
        }
        br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    
    
}
