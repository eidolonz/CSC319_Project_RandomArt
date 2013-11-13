package randomArt;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
 
public class Frame extends JFrame{
  
  private Panel panel;
  
  public Frame(int width, int height){
    createFrame(width, height);
    
    panel = new Panel();
    add(panel, BorderLayout.CENTER);
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
  
  public void run(){
    setVisible(true);
  }
  
}