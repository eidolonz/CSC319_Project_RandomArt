import java.util.Stack;

public class Expression{
  private int levelDeep;
  private int currentLV;
  public String currentExp = "";
  private double x, y;
  private int pointerX, pointerY;
  
  public Expression(int lvDeep){
    this.levelDeep = lvDeep;
    this.currentLV = 0;
  }
  public double computeExpression(double x, double y){
     pointerX = 0; pointerY = 1;
     this.x = x; this.y = y;
    return getResult();
      }
    
  public double getResult(){
    double val = 0;
    boolean check = false;
    while( pointerY < currentExp.length() && pointerX >= 0){
        char c = currentExp.charAt(pointerY);
       if(!(c == 'y' || c == 'x')){
          this.pointerX++;
          this.pointerY++;
          //System.out.println("x" + this.pointerX);
          //System.out.println("y" + this.pointerY);
       }else if(!check){
            switch (currentExp.charAt(this.pointerX)){
                case 'M': val = mul(checkChar(currentExp.charAt(this.pointerY)), checkChar(currentExp.charAt(this.pointerY+1))); 
                          pointerX--; pointerY ++; check = true; break;
                case 'A': val = avg(checkChar(currentExp.charAt(this.pointerY)), checkChar(currentExp.charAt(this.pointerY+1))); 
                          pointerX--; pointerY ++; check = true; break;
                case 'S': val = sin(checkChar(currentExp.charAt(this.pointerY))); 
                          pointerX--; check = true; break;
                case 'C': val = cos(checkChar(currentExp.charAt(this.pointerY))); 
                          pointerX--; check = true; break;
                default: System.exit(0);
            }
            //System.out.println(val + "A");
       }else{
            while(pointerY < currentExp.length() && pointerX >= 0){
                switch (currentExp.charAt(pointerX)){
                case 'M': val = mul(val, checkChar(currentExp.charAt(pointerY+1))); pointerX--; pointerY ++; break;
                case 'A': val = avg(val, checkChar(currentExp.charAt(pointerY+1))); pointerX--; pointerY ++; break;
                case 'S': val = sin(val); pointerX--; break;
                case 'C': val = cos(val); pointerX--; break;
                default: System.exit(0);
              }
              //System.out.println(val + "B");
          }
        
       }
    }
    //System.out.println(val + "c");
        return val;
  
}

  public void createExpression(){
    //System.out.println(currentExp);
   if(currentLV < levelDeep){
      randomOperation();
    }else{
      randomOperand();
    }
  }
  
  //random operator
  private void randomOperand(){
    int max = (int)(Math.random()*2);
    switch (max){
      case 0: this.currentExp += "x"; break;
      default: this.currentExp += "y";
    }
  }
  
  public double getValExp(double x, double y){
    return Math.sin(Math.PI * x * Math.sin(Math.PI * y * Math.sin(Math.PI * y * (Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * Math.sin(Math.PI * Math.cos(Math.PI * y))))) * Math.cos(Math.PI * Math.sin(Math.PI * Math.cos(Math.PI * avg(Math.sin(Math.PI * y), (x * x)))))))));
  }
  
  //random operation
  private void randomOperation(){
    int max;
    if(this.currentLV < this.levelDeep){
        this.currentLV++;
      max = (int)(Math.random()*4);
    }else{
      max = -1;
    }
    
    switch (max){
      case 0: this.currentExp += "A"; randomOperation(); randomOperation(); break; //'A' 
      case 1: this.currentExp += "M"; randomOperation(); randomOperation(); break;//'M'
      case 2: this.currentExp += "S"; randomOperation(); break;//'S'
      case 3: this.currentExp += "C"; randomOperation(); break;//'C'
      default: randomOperand();
    }
  }
  
  private double sin(double x){
    return Math.sin(Math.PI * x);
  }
  private double cos(double x){
    return Math.cos(Math.PI * x);
  }
  
  private double mul(double x, double y){
    return x*y;
  }
  
  private double avg(double x, double y){
    return (x*y)/2;
  }
  
  private double checkChar(char c){
      if(c == 'x'){
          return this.x;
      }else{
          return this.y;
      }
  }
  
  public double getRed(){
    return 0;
  }
  public double getGreen(){
    return 0;
  }
  public double getBlue(){
    return 0;
  }
}