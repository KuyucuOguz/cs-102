public abstract class Person implements Locatable{
    //properties
    String name;
    int posX;
    int posY;
    //constructors
    
    public Person(String name, int x,int y){
        this.name = name;
        posX = x;
        posY = y;
    }
    public Person(String name){
        this.name = name;
        posX = 0;
        posY = 0;
    }
    //methods
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
    
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
    public void setPos(int x, int y){
        x = posX;
        y = posY;
    }
}
