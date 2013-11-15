import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
 
public class Frame extends JFrame{
  
  private Panel panel;
  private int width;
  private int height;
  boolean check;
  
  public Frame(){
    createWelcomePopUp();
  }
    
  public void createFrame(int width, int height){
    //set title of window
    setTitle("CSC319-OOP PROJECT RANDOM ART");
    setSize(width, height); // will change to use input later
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createMenuBar();
    
    panel = new Panel();
    add(panel, BorderLayout.CENTER);
  }
  
  public void createMenuBar(){
    //createMenuBar
    JMenuBar menu = new JMenuBar();
    JMenu file = new JMenu("File");  
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    menu.add(file);
    menu.add(edit);
    menu.add(help);
    //add sub menu to file
    file.add("New");
    file.add("Save");
    file.add("Exit");
    //add sub menu to edit
    edit.add("New Color");
    edit.add("New Gray");
    edit.add("Change Size");
    edit.add("Random New");
    //add sub menu to about
    help.add("About");
    setJMenuBar(menu);
    addButton("Generate", "SOUTH");
  }
  
  public void addButton(String s, String layout){
    //create button
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(new JButton(s));
    if(layout == "SOUTH"){
      add(buttonPanel, BorderLayout.SOUTH);
    }else if(layout == "NORTH"){
      add(buttonPanel, BorderLayout.NORTH);
    }else if(layout == "EAST"){
      add(buttonPanel, BorderLayout.EAST);
    }else if(layout == "WEST"){
      add(buttonPanel, BorderLayout.WEST);
    }else{
      add(buttonPanel, BorderLayout.CENTER);
    }
  }
  
  public void addLabel(String s, String layout){
    JLabel label = new JLabel(s);
    if(layout == "NORTH"){
      add(label, BorderLayout.NORTH);
    }else if(layout == "SOUTH"){
      add(label, BorderLayout.SOUTH);
    }else if(layout == "EAST"){
      add(label, BorderLayout.EAST);
    }else if(layout == "WEST"){
      add(label, BorderLayout.WEST);
    }else{
      add(label, BorderLayout.CENTER);
    }
  }
  
  
  
  public void createWelcomePopUp(){
    setTitle("RandomArtProject");
    setSize(320, 50);
    Container contentPanes = new Panel();
    JLabel label = new JLabel("       Welcome! to Random-Art Beta v.2.2.27 ");
    add(label, BorderLayout.CENTER);
    //setBackground(Color.BLUE);
    setVisible(true);
    
    //timeCheck(50);
    setVisible(false);
    remove(label);
    //createFrame(320,320);
    //createWidthHeight();
    createColorSelection();
    setVisible(true);
  }
  
  public void timeCheck(int check){
    long time1 = System.currentTimeMillis();
    long stop = 0;
    while(stop >= check){
      stop = (System.currentTimeMillis() - time1)/1000;
    }
  }
  
 
  public void createWidthHeight(){
    setSize(250, 125);
    setLayout(new GridLayout(3,1));
    JTextField text = new JTextField(5);
    JTextField text2 = new JTextField(5);
    
    addLabel("Width: ", "WEST");
    add(text);//,BorderLayout.EAST);
    addLabel("Height: ", "WEST");
    add(text2);//,BorderLayout.EAST);
    addButton("Next","SOUTH");
  }
  
  public void createColorSelection(){
    setSize(250,125);
    setLayout(new GridLayout(2,2));
    JRadioButton color = new JRadioButton(" Random Color");
    JRadioButton gray = new JRadioButton(" Random Gray");
    add(color, BorderLayout.CENTER); 
    add(gray, BorderLayout.CENTER);
    addButton("Generate", "CENTER");
    addButton("Back", "CENTER");
  }
  
  public void run(){
    //setVisible(true);
  }
  
}