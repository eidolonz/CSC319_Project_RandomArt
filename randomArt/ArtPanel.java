
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

public class ArtPanel extends JPanel{
  
  private Expression randExp = new Expression(8); 
  
<<<<<<< HEAD
  public ArtPanel(int width, int height){
    setPreferredSize(new Dimension(width, height));
    randExp.createExpression();
    //System.out.println(randExp.currentExp);
}
=======
  public ArtPanel(int widht, int height){
    setPreferredSize(new Dimension());
  }
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
  public ArtPanel(){
    this(320, 320);
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    int c = 0;
    
<<<<<<< HEAD
    
=======
    randExp.createExpression(5, 5);
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
    
    for(int i = 0; i < getWidth(); i++){
      for(int j = 0; j < getHeight(); j++){
        
<<<<<<< HEAD
        double R = randExp.computeExpression(i, j);
        double G = randExp.computeExpression(i, j);
        double B = randExp.computeExpression(i, j);
=======
        double R = randExp.computeExpression();
        double G = randExp.computeExpression();
        double B = randExp.computeExpression();
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
        
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