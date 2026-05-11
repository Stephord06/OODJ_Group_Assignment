/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;
import java.util.Properties;
import java.io.FileNotFoundException;


public class SetPrices implements ManagerStandard_Method{
    
    private String name;
    
    
    private JPanel shortpanel;
    private JPanel longpanel;
    private JPanel headerRow1;
    private JPanel headerRow2;
    
    
    private JTextField priceField1;
    private JTextField priceField2;
    
    private final File file = new File("setPrices.txt");
    
    private String readshortprice;
    private String readlongprice;
    
    public SetPrices(String name){
        this.name = name;
    }
    
    @Override
    public void UI(){
        JFrame Frame = new JFrame("SetPrices");
        Frame.setSize(800, 500);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(new BorderLayout(30,30));
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        
        //Label title main panel
        JPanel title = new JPanel();
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        title.setLayout(new FlowLayout(FlowLayout.LEFT));
        title.setPreferredSize(new Dimension(800,50));
        Frame.add(title, BorderLayout.NORTH);
        
        //Label title
        JLabel titleLabel = new JLabel("Set appointment prices");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        title.add(titleLabel); 
        
        
        //container panel
        JPanel containerpanel = new JPanel();
        containerpanel.setLayout(new BoxLayout(containerpanel,BoxLayout.Y_AXIS));
        containerpanel.setPreferredSize(new Dimension(800, 200));
        containerpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Frame.add(containerpanel, BorderLayout.CENTER);
        
        //short session appointment panel
        shortpanel = new JPanel();
        shortpanel.setLayout(new FlowLayout(FlowLayout.LEFT,10, 10));
        shortpanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,4,true));
        shortpanel.setMaximumSize(new Dimension(380,100));
        containerpanel.add(shortpanel);
        
        //a panel to control the "1 hour appointment" and the save icon
        headerRow1 = new JPanel();
        headerRow1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        headerRow1.setPreferredSize(new Dimension(350, 30));
        shortpanel.add(headerRow1);

        
        //short session appointment label and textfield
        JLabel onehourlabel = new JLabel("1 Hour Appointment");
        onehourlabel.setPreferredSize(new Dimension(250, 30));
        onehourlabel.setFont(new Font("Arial", Font.PLAIN, 12));
        headerRow1.add(onehourlabel);
        
        
        //saved icon 

        
        //price panel 
        JPanel pricepanel1 = new JPanel();
        pricepanel1.setPreferredSize(new Dimension(350, 25));
        pricepanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        shortpanel.add(pricepanel1);
        
        //short session appointment pricelabel
        JLabel priceLabel1 = new JLabel("Base Price      (RM):");
        priceLabel1.setPreferredSize(new Dimension(150, 25)); 
        pricepanel1.add(priceLabel1);
        
        //short session appointment pricefield
        priceField1 = new JTextField();
        priceField1.setPreferredSize(new Dimension(150, 25));
        priceField1.setBorder(BorderFactory.createLineBorder(Color.cyan, 1, true));
        pricepanel1.add(priceField1);
        
        //vertical gap between shortpanel and longpanel
        containerpanel.add(Box.createVerticalStrut(30));
        
        
        //long session appointment panel
        longpanel = new JPanel();
        longpanel.setLayout(new FlowLayout(FlowLayout.LEFT,10, 10));
        longpanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,4,true));
        longpanel.setMaximumSize(new Dimension(380,100));
        containerpanel.add(longpanel);
        
        //a panel to control the "3 hour appointment" and the save icon
        headerRow2 = new JPanel();
        headerRow2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        headerRow2.setPreferredSize(new Dimension(350, 30));
        longpanel.add(headerRow2);
        

        
        //long session appointment label and textfield
        JLabel onehourlabel2 = new JLabel("3 Hour Appointment");
        onehourlabel2.setPreferredSize(new Dimension(250, 30));
        onehourlabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        headerRow2.add(onehourlabel2);
        
        
        
        //saved icon for shortpanel

        
        
        //price panel 
        JPanel pricepanel2 = new JPanel();
        pricepanel2.setPreferredSize(new Dimension(350, 25));
        pricepanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        longpanel.add(pricepanel2);
        
        //long session appointment pricelabel
        JLabel priceLabel2 = new JLabel("Base Price      (RM):");
        priceLabel2.setPreferredSize(new Dimension(150, 25)); 
        pricepanel2.add(priceLabel2);
        
        //long session appointment pricefield
        priceField2 = new JTextField();
        priceField2.setPreferredSize(new Dimension(150, 25));
        priceField2.setBorder(BorderFactory.createLineBorder(Color.cyan, 1, true));
        pricepanel2.add(priceField2);
        
        //long session and short session textfield event
        priceField1.getDocument().addDocumentListener(new DocumentListener(){
            
            @Override
            public void insertUpdate(DocumentEvent e) 
            { 
                    
                   
            }
            
            
            @Override
            public void removeUpdate(DocumentEvent e) 
            { 

                
            }
            @Override
            public void changedUpdate(DocumentEvent e) { /* Not used for plain text */ }
  
            
        });
        
        priceField2.getDocument().addDocumentListener(new DocumentListener(){
            
            @Override
            public void insertUpdate(DocumentEvent e) 
            { 

            }
            
            
            @Override
            public void removeUpdate(DocumentEvent e) 
            { 

                
            }
            @Override
            public void changedUpdate(DocumentEvent e) { /* Not used for plain text */ }
  
            
        });
        
        
        
        //gap between appointment and the back
        containerpanel.add(Box.createVerticalStrut(30));
        
        
        
        //panel for button save and back
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20,1));
        panel.setMaximumSize(new Dimension(300, 40));
        containerpanel.add(panel);
        
        
        
        //button save and back
        JButton savebtn = new JButton("Save");
        savebtn.setPreferredSize(new Dimension(100,30));
        panel.add(savebtn);
        
        JButton backbtn = new JButton("Back");
        backbtn.setPreferredSize(new Dimension(100,30));
        panel.add(backbtn);
        
        
        //load the previous price to the priceField;
        if (file.exists() && file.length() > 0){
            JOptionPane.showMessageDialog(null, filereader());
        }
        
        
        //event for button
        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, filewriter());    
            }
            
        });
        
        backbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Frame.dispose(); // close this window
            ManagerDashBoard back = new ManagerDashBoard(name);
            back.UI();
            }
        });
        
    }
    
    public String filewriter(){
        Properties props = new Properties();

        props.setProperty("1hour", priceField1.getText());
        props.setProperty("3hour", priceField2.getText());
        
        try (FileWriter fw = new FileWriter("setPrices.txt")){

                props.store(fw, "Price List");
                return "Saved!";

        }
        catch (IOException e){
            e.printStackTrace(); 
        }
        return "Saved Failed";
                
    }
    
    public String filereader(){
        Properties props = new Properties();
        try (FileReader fr = new FileReader("setPrices.txt")){
            props.load(fr); 
            readshortprice = props.getProperty("1hour"); 
            readlongprice = props.getProperty("3hour");
             
            priceField1.setText(readshortprice);
            priceField2.setText(readlongprice);
            
            return "Load Successful";
        }
        catch (IOException e){
            e.printStackTrace(); 
        }
        
        return "Load Failed";
    }
    
    
    
    
    public JPanel saved(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(34, 139, 34));
        panel.setPreferredSize(new Dimension(80, 25));
        panel.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 1, true)); 

        JLabel text = new JLabel("Saved");
        text.setFont(new Font("Arial", Font.BOLD, 11));
        text.setForeground(Color.WHITE);

        panel.add(text);

        return panel;
    }
    
    public JPanel unsaved(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(200, 50, 50)); 
        panel.setBorder(BorderFactory.createLineBorder(new Color(150, 0, 0), 1, true)); 
        JLabel text = new JLabel("Unsaved");
        text.setFont(new Font("Arial", Font.BOLD, 11));
        text.setForeground(Color.WHITE);

        
        panel.add(text);

        return panel;
    }

}
