
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
  private JPanel panel;
  private JPanel thePanel;
    
  String[] size = new String[6];
      
  
  //Constructor
  public ArtFrame(){
    randomPreference();
    //thePanel = new ArtPanel();
  }
  
  public void makePanel(int width, int height){
    frame = new JFrame();
    frame.setTitle("RandomArt");
    frame.setSize(width, height);
    
    makeMenuBar(frame);
    
    thePanel = new ArtPanel();
    frame.add(thePanel);
    
    //frame.pack();
    frame.setVisible(true);
  }
    
  private void generate(){
    setVisible(false);
    makePanel(getWidth(), getHeight());
    remove(frame);
  }
  
  private void setDefault(){}
  
  private void cancle(){}
  
  private void newRandomArt(){}
  
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
  
  private void randomPreference(){
    makePreferencePanel();
  }
  
  private void setTextFieldEnabled(boolean status){
    widthText.setEnabled(status);
    heightText.setEnabled(status);
  }
  
  private ArrayList<String> createSizeList(){
    ArrayList<String> sizeList = new ArrayList<String>();
    sizeList.add("Default: 200 x 200");
    sizeList.add("320, 320");
    sizeList.add("480, 480");
    sizeList.add("800, 600");
    sizeList.add("1280, 720");
    sizeList.add("Add specific size");
    
    return sizeList;
  }
  
  private void makePreferencePanel(){
    panel = new JPanel();
    //sizeBox
    
      
      size[0] = "Defualt: 200 x 200"; size[1] = "320 x 320"; size[2] = "480 x 480"; size[3] = "800 x 600"; size[4] = "1280 x 720";size[5] = "Add specific size";
      JTextField widthText = new JTextField(5), heightText = new JTextField(5);
      JComboBox combo = new JComboBox(size);
      JRadioButton colorRGB = new JRadioButton("RGB-Color");
      JRadioButton grayScale = new JRadioButton("Grayscale");
  
    Box colorBox = Box.createVerticalBox();
    ButtonGroup colorGroup = new ButtonGroup();
    colorGroup.add(colorRGB);
    colorGroup.add(grayScale);
    colorBox.add(colorRGB);
    colorBox.add(grayScale);
    colorBox.setBorder(BorderFactory. createTitledBorder("Color Option"));
    addItem(panel, colorBox, 0, 3, 1, 1, GridBagConstraints.SOUTH);
    
    Box sizeBox = Box.createHorizontalBox();
    label = new JLabel("Width: ");
    sizeBox.add(label);
    sizeBox.add(widthText);
    label = new JLabel("  Height: ");
    sizeBox.add(label);
    sizeBox.add(heightText);
    sizeBox.add(combo);
    widthText.setEnabled(true);
    sizeBox.setBorder(BorderFactory.createTitledBorder("Size"));
    addItem(panel, sizeBox, 1, 3, 1, 1, GridBagConstraints.NORTH); 
    
    Box buttonBox = Box.createVerticalBox();
    button = new JButton("Generate");
    buttonBox.add(button);
    button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){generate();}});
    buttonBox.add(Box.createVerticalStrut(0));
    button = new JButton("Default");
    buttonBox.add(button);
    buttonBox.add(Box.createVerticalStrut(0));
    button = new JButton("Cancle");
    buttonBox.add(button);
    addItem(panel, buttonBox, 2, 3, 1, 1, GridBagConstraints.CENTER);
    
    this.add(panel);
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
    
    item = new JMenuItem("Save as");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){saveAs();}});
    menu.add(item);
    
    item = new JMenuItem("Quit");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){quit();}});
    menu.add(item);
    
    menu = new JMenu("Tools");
    menuBar.add(menu);
    item = new JMenuItem("Preferences");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){randomPreference();}});
    menu.add(item);
    
    menu = new JMenu("Help");
    menuBar.add(menu);
    
    item = new JMenuItem("About RandomArt");
    item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){about();}});
    menu.add(item);
  }
}