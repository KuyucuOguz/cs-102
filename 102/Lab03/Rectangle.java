public class Rectangle extends Shape2D{
    //properties
    protected double height;
    protected double width;
    //constructors
    /**Creates a rectangle
     * @param x is x coordinate of center of rectangle
     * @param y is y coordinate of center of rectangle
     * @param height is height of rectangle
     * @param width is width of rectangle
     */
    public Rectangle(int x, int y, double height, double width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public Rectangle(){
        
    }
    //methods
    @Override
    /**Calculates perimeter of rectangle
     * @return perimeter
     */
    public double calculatePerimeter() {
        double perimeter;
        perimeter = 2 * (height + width);
        return perimeter;
    }
    /**Calculates area of rectangle
     * @return area
     */
    @Override
    public double calculateArea() {
        double area;
        area = height * width;
        return area;
    }
    @Override
    /**Represent rectangle as a string
     * @return string representation of circle
     */
    public String toString(){
        if( height <= 0 && width <= 0)
            return null;
        return "[class rectangle] " + super.toString() + " height " + height + " and width " + width; 
    }
    @Override
    /**Controls if two rectangles are equal or not
     * @param o is second shape
     * @return true if rectangles are equal, otherwise false
     */
    public boolean equals(Object o){
        Rectangle rectangle;
        if( o instanceof Rectangle){
            rectangle = (Rectangle) o;
            if(height == rectangle.height && width == rectangle.width)
                return super.equals(o);
        }
        return false;
    }
}