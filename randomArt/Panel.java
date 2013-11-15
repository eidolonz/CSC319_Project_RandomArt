
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

public class Panel extends JPanel{
  
  public Panel(int widht, int height){
    setPreferredSize(new Dimension());
  }
  public Panel(){
    this(320, 320);
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    int c = 0;
    
    for(int i = 0; i < getWidth(); i+=getWidth()/2 , c++){
      for(int j = 0; j < getHeight(); j+=getHeight()/2, c++){
        if(c % 2 == 0){
          g2.setColor(Color.BLACK);
        }else{
          g2.setColor(Color.RED);
        }
        g2.fillRect(i,j,getWidth()/2, getHeight()/2);
      }
    }
  }
}