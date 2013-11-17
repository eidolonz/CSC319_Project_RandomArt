
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

public class ArtPanel extends JPanel{
  
  private Expression randExp = new Expression(8); 
  
  public ArtPanel(int widht, int height){
    setPreferredSize(new Dimension());
  }
  public ArtPanel(){
    this(320, 320);
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    int c = 0;
    
    randExp.createExpression(5, 5);
    
    for(int i = 0; i < getWidth(); i++){
      for(int j = 0; j < getHeight(); j++){
        
        double R = randExp.computeExpression();
        double G = randExp.computeExpression();
        double B = randExp.computeExpression();
        
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