public class SizeList{
  int width;
  int height;
  String name;
  
  public SizeList(){
    this("Default: 200 x 200");
  }
  
  public SizeList(String name){
    this.name = name;
    this.width = 200;
    this.height = 200;
  }
  
  public SizeList(int width, int height){
    this.width = width;
    this.height = height;
    this.name = width + " x " + height;
  }
}