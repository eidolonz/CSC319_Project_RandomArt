
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

public class ArtPanel extends JPanel{
  
  private Expression randExpR = new Expression(22); 
  private Expression randExpG = new Expression(27); 
  private Expression randExpB = new Expression(13); 
  private boolean check = false;
  
  public ArtPanel(int width, int height, boolean color){
    setPreferredSize(new Dimension(width, height));
    createExpreesion(color);
}

  public ArtPanel(){
    this(320, 320, true);
  }
  
  private void createExpreesion(boolean color){
      if(!check){
          if(color){
              randExpR.createExpression();
              randExpG.createExpression();
              randExpB.createExpression();
              //System.out.println("R: " + randExpR.currentExp);
              //System.out.println("G: " + randExpG.currentExp);
              //System.out.println("B: " + randExpB.currentExp);
              this.check = true;
          }else{
              randExpR.createExpression();
              randExpG = randExpB = randExpR;
          }
      }
    }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    int c = 0;
    
    
    
    for(int i = 0; i < getWidth(); i++){
      for(int j = 0; j < getHeight(); j++){
        
        double x = (((double) i) / getWidth() * 2.0) - 1.0;
        double y = (((double) j) / getHeight()* 2.0) - 1.0;
        double R = randExpR.computeExpression(x, y);
        
         x = (((double) i) / getWidth() * 2.0) - 1.0;
         y = (((double) j) / getHeight()* 2.0) - 1.0;
        double G = randExpG.computeExpression(x, y);
        
         x = (((double) i) / getWidth() * 2.0) - 1.0;
         y = (((double) j) / getHeight()* 2.0) - 1.0;
        double B = randExpB.computeExpression(x, y);
        
        Color C = new Color(toColor(R), toColor(G), toColor(B));
        
        g2.setColor(C);
        g2.fillRect(i,j,1, 1);
      }
    }
  }
  
  public int toColor(double val){
    val += 1.0;
    if (val < 0) {
      val *= -1;
    }
    val /= 2.0;
    int col = (int) (val * 255);
    if (col >= 255) {
      col = 255;
    }
    return col;
  }
}