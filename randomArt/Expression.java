import java.util.Stack;

public class Expression{
  private int levelDeep;
  private int currentLV;
<<<<<<< HEAD
  public String currentExp = "";
=======
  private String currentExp;
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
  private double x, y;
  
  public Expression(int lvDeep){
    this.levelDeep = lvDeep;
    this.currentLV = 0;
  }
<<<<<<< HEAD
  public double computeExpression(double x, double y){
      this.x = x; this.y = y;
=======
  public double computeExpression(){
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
    Stack<Double> operands = new Stack<Double>();
    for(int i = 0; i < currentExp.length(); i++){
      char ch = currentExp.charAt(i);
      if(ch == 'x')
        operands.push(x);
      else if(ch == 'y')
        operands.push(y);
      else{
        // operator
        double op1 = operands.pop();
        if(ch == 'S')
<<<<<<< HEAD
          operands.push(sin(op1));
        else if(ch == 'C')
          operands.push(cos(op1));
=======
          operands.push(Math.sin(Math.PI * op1));
        else if(ch == 'C')
          operands.push(Math.cos(Math.PI * op1));
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
        else if(ch == 'M')
          operands.push(op1 * operands.pop());
        else if (ch == 'A')
          operands.push(avg(op1, operands.pop()));
        // CS324E students
        // add else if branch for new operator(s) here
      }
    }
<<<<<<< HEAD
    //double result = operands.pop();
    double result = Math.random();
    result = (result < -1.0) ? -1.0 : (result > 1.0) ? 1.0 : result;
    
=======
    double result = operands.pop();
    result = (result < -1.0) ? -1.0 : (result > 1.0) ? 1.0 : result;
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
    return result;
      }
    
  
  
<<<<<<< HEAD
  public void createExpression(){
    //System.out.println(currentExp);
   if(currentLV < levelDeep){
      randomOperation();
    }else{
      randomOperand();
=======
  public void createExpression(double x, double y){
    this.x = x;
    this.y = y;
    //System.out.println(currentExp);
    makeExpression(x,y);
  }
  private double makeExpression(double x, double y){
    if(currentLV < levelDeep){
      currentLV++;
      return makeExpression(randomOperation(), randomOperation());
    }else{
      return randomOperator();
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
    }
  }
  
  //random operator
<<<<<<< HEAD
  private void randomOperand(){
    int max = (int)(Math.random()*2);
    switch (max){
      case 0: this.currentExp = "x" + currentExp; break;
      default: this.currentExp = "y" + currentExp;
=======
  private double randomOperator(){
    int max = (int)(Math.random()*2);
    switch (max){
      case 0: this.currentExp += "x"; return this.x;
      default: this.currentExp += "y"; return this.y;
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
    }
  }
  
  //random operation
<<<<<<< HEAD
  private void randomOperation(){
    int max;
    if(this.currentLV < this.levelDeep){
        this.currentLV++;
      max = (int)(Math.random()*4);
    }else{
      max = -1;
    }
    
    switch (max){
      case 0: this.currentExp = "A" + currentExp; randomOperation(); randomOperation(); break; //'A' 
      case 1: this.currentExp += "M" + currentExp; randomOperation(); randomOperation(); break;//'M'
      case 2: this.currentExp += "S" + currentExp; randomOperation(); break;//'S'
      case 3: this.currentExp += "C" + currentExp; randomOperation(); break;//'C'
      default: randomOperand();
=======
  private double randomOperation(){
    int max;
    if(this.currentLV < this.levelDeep){
      max = (int)(Math.random()*4);
    }else{
      max = 4;
    }
    
    switch (max){
      case 0: this.currentExp += "A"; return avg(x, y); //'A'
      case 1: this.currentExp += "M"; return mul(x, y); //'M'
      case 2: this.currentExp += "S"; return sin(x); //'S'
      default: this.currentExp += "C"; return cos(x); //'C'
      //default: return randomOperator();
>>>>>>> b2a39564c59569be467985510cfdae59021bd1f8
    }
  }
  
  public int getResult(){
    return 0;
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