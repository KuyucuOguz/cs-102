public class Square extends Shape2D{
    //properties
    protected double sideLength;
    //constructors
    /**Creates square 
     * @param sideLength is sidelength of a square
     * @param x is x coordinate of center of a square
     * @param y is y coordinate of center of square
     */
    public Square(int x, int y, double sideLength){
        this.x = x;
        this.y = y;
        this. sideLength = sideLength;
    
    }
    public Square(){
        
    }
    //methods
    /**Calculates perimeter of square
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        return sideLength * 4;
    }
    /**Calculates area of square
     * @return area
     */
    @Override
    public double calculateArea() {
        return Math.pow(sideLength, 2);
    }
    @Override
    /**Represent square as a string
     * @return string representation of circle
     */
    public String toString(){
        if(sideLength <= 0)
            return null;
        return "[class square] " + super.toString() + " and side " + sideLength; 
    }
    
    @Override
    /**Controls if two square are equal or not
     * @param o is second shape
     * @return true if squares are equal, otherwise false
     */
    public boolean equals(Object o){
        Square square;
        if( o instanceof Square){
            square =(Square) o;
            if(sideLength == square.sideLength)
                return super.equals(o);
        }
        return false;
    }
}