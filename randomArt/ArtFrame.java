
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.*;

//import java.awt.border.*;
import java.awt.event.*;//.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.util.List;
import java.util.ArrayList;
//import java.io.File;

public class ArtFrame extends JFrame{
  //field
  private static JFileChooser fileChoose = new JFileChooser(System.getProperty("user.dir")); 
  
  private JFrame frame;
  private JButton button;
  private JLabel label;
  private JTextField widthText;
  private JTextField heightText;
  private JPanel preferencePanel;
  private JPanel thePanel;
  private ArtPanel artPanel;
    
  private int width, height;
  private boolean color = true;
      
  
  //Constructor
  public ArtFrame(){
    newArt();
  }
  
  public void makePanel(int width, int height){
    frame = new JFrame();
    frame.setTitle("RandomArt");
    
    makeMenuBar(frame);
    
    thePanel = new ArtPanel(320, 320, color);   
    artPanel = (ArtPanel)thePanel;
    frame.add(thePanel);
    
    frame.pack();
    frame.setVisible(true);
  }
    
  private void generate(int width, int height){
    setVisible(false);
    makePanel(width, height);
    remove(frame);
  }
  private void generate(){
    generate(this.width, this.height);
    }
  private void cancle(){
    //remove(preferencePanel);
    setVisible(false);
  }
  
  private void newArt(){
    makePreferencePanel();
  }
  
  private void saveAs(){}
  
  private void quit(){
    //JOptionPane.showConfirmDialog(frame, "Are you sure?", "Quit RandomArt?",JOptionPane.INFORMATION_MESSAGE);
    int selection = JOptionPane.showConfirmDialog(frame, "Are you sure?", "Quit RandomArt?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
     
    if (selection == JOptionPane.OK_OPTION){
      System.exit(0);
    }
  }
  
  private void about(){
    JOptionPane.showMessageDialog(frame, "RandomArt\nBeta Version 2.2.27", "AboutRandomArt", JOptionPane.INFORMATION_MESSAGE);
  }
  
  private void printFunction(){
    JOptionPane.showMessageDialog(frame, artPanel.getExp(),"RandomArt-Functions", JOptionPane.INFORMATION_MESSAGE);
  }
  
  private boolean getColor(){
      return this.color;
  }
  
  private void setTextFieldEnabled(boolean status){
    widthText.setEnabled(status);
    heightText.setEnabled(status);
  }
  
  private void makePreferencePanel(){
    preferencePanel = new JPanel();
    //sizeBox
      JRadioButton colorRGB = new JRadioButton("RGB-Color");
      colorRGB.setActionCommand("RGB-Color");
      colorRGB.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){color = true;}});
      colorRGB.setSelected(true);
      JRadioButton grayScale = new JRadioButton("Grayscale");
      grayScale.setActionCommand("Grayscale");
      grayScale.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){color = false;}});  
  
    Box colorBox = Box.createVerticalBox();
    ButtonGroup colorGroup = new ButtonGroup();
    colorGroup.add(colorRGB);
    colorGroup.add(grayScale);
    colorBox.add(colorRGB);
    colorBox.add(grayScale);
    colorBox.setBorder(BorderFactory. createTitledBorder("Color Option"));
    addItem(preferencePanel, colorBox, 0, 3, 1, 1, GridBagConstraints.SOUTH);
    
     JTextField widthText = new JTextField("320", 5), heightText = new JTextField("320", 5);
     this.width = Integer.parseInt(widthText.getText()); 
     this.height = Integer.parseInt(heightText.getText());
      
    Box sizeBox = Box.createHorizontalBox();
    label = new JLabel("Width: ");
    sizeBox.add(label);
    sizeBox.add(widthText);
    label = new JLabel("  Height: ");
    sizeBox.add(label);
    sizeBox.add(heightText);
    widthText.setEnabled(true);
    sizeBox.setBorder(BorderFactory.createTitledBorder("Size"));
    addItem(preferencePanel, sizeBox, 1, 3, 1, 1, GridBagConstraints.NORTH); 
    
    Box buttonBox = Box.createVerticalBox();
    button = new JButton("Generate");
    buttonBox.add(button);
    button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){generate(width, height);}});
    buttonBox.add(Box.createVerticalStrut(0));
    buttonBox.add(button);
    buttonBox.add(Box.createVerticalStrut(0));
    button = new JButton("Cancle");
    button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){cancle();}});
    buttonBox.add(button);
    addItem(preferencePanel, buttonBox, 2, 3, 1, 1, GridBagConstraints.CENTER);
    
    this.add(preferencePanel);
    this.pack();
    this.setVisible(true);
  }
  
  private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
    GridBagConstraints gc = new GridBagConstraints();
    gc.gridx = x;
    gc.gridy = y;
    gc.gridwidth = width;
    gc.gridheight = height;
    gc.weightx = 100.0;
    gc.weighty = 100.0;
    gc.insets = new Insets(5, 5, 5, 5);
    gc.anchor = align;
    gc.fill = GridBagConstraints.NONE;
    p.add(c, gc);
    
  }
  
  private void makeMenuBar(JFrame frame){
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    
    JMenu menu;
    JMenuItem item;
    
    //create File
    menu = new JMenu("File");
    menuBar.add(menu);
    
    item = new JMenuItem("New");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){newArt();}});
    menu.add(item);
    
    item = new JMenuItem("Save as");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){saveAs();}});
    menu.add(item);
    
    item = new JMenuItem("Quit");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){quit();}});
    menu.add(item);
    menu = new JMenu("Tools");
    menuBar.add(menu);
    
    /*
    item = new JMenuItem("Preferences");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){randomPreference();}});
    menu.add(item);
    */
    item = new JMenuItem("Functions");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){printFunction();}});
    menu.add(item);
    
    menu = new JMenu("Help");
    menuBar.add(menu);
    
    item = new JMenuItem("About RandomArt");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){about();}});
    menu.add(item);
  }
}