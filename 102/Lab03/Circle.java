public class Circle extends Shape2D{
    //properties

    protected double radius;
    //constructors

    public Circle(int x, int y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
   }
   public Circle(){
       
   }
    //methods

    @Override
    /**Calculates perimeter of circle 
     * @return perimeter
    */
    public double calculatePerimeter() {
        double perimeter;
        perimeter = Math.PI * radius * 2;
        return perimeter;
    }

    @Override
    /**Calculates the area of the circle
     * @return area
     */
    public double calculateArea() {
        double area;
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }
    @Override
    /**Represent circle as a string
     * @return string representation of circle
     */
    public String toString(){
        if(radius <= 0)
            return null;
        return "[class circle] " + super.toString() +" and radius " + radius; 
    }
    @Override
    /**Controls if two circle are equal or not
     * @param o is second shape
     * @return true if circles are equal, otherwise false
     */
    public boolean equals(Object o){
        Circle circle;
        if( o instanceof Circle){
            circle =(Circle) o;
            if(radius == circle.radius)
                return super.equals(o);
        }
        return false;
    }
}