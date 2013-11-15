import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
 
public class Frame extends JFrame{
  
  private Panel panel;
  boolean check;
  
  public Frame(int width, int height){
    createWelcomePopUp();
    
    
  }
  
  public Frame(){
    this(500, 320);
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
    addButton();
  }
  
  public void addButton(){
    //create button
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(new JButton("Generate!"));
    add(buttonPanel, BorderLayout.SOUTH);
  }
  
  public void createWelcomePopUp(){
    setTitle("RandomArtProject");
    setSize(320, 50);
    Container contentPanes = new Panel();
    JLabel welcome = new JLabel("       Welcome! to Random-Art Beta v.2.2.27 ");
    add(welcome, BorderLayout.CENTER);
    setVisible(true);
    
    while(!check){
      check = timeCounter(1);
    }
    setVisible(false);
    remove(welcome);
    createFrame(320,320);
    setVisible(true);
  }
  
  public boolean timeCounter(int delay){
    delay *= 99999999;
    while(delay > -9999999){
      delay--;
    }
    return true;
  }
  
  public void run(){
    //setVisible(true);
  }
  
}