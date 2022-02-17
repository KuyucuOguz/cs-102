public abstract class Shape2D{
    //properties
    protected int x;
    protected int y;
    //methods
    /**
     * Calculates perimeter of a two D shape
     */
    public abstract double calculatePerimeter();
    
    /**
     * Calculates area of a two D shape
     */
    public abstract double calculateArea();

    /**
     * Calculates distance between two shapes' centers
     * @param anyShape is other shape
     * @return distance between two shape
     */
    public double calculateDistance( Object anyShape ){
        Shape2D shape;
        if( anyShape instanceof Shape2D){
            shape =(Shape2D) anyShape;
            return Math.sqrt(Math.pow(x - shape.x, 2) +  Math.pow(y - shape.y, 2));
        }
        else{
            return -1;
        }
    }
    /**
     * Makes 2D shape a string
     * @return x and y coordinates of the center of shape
     */
    @Override
    public String toString(){
        return "" +"x = " + x + " y = " + y;
    }
    /**
     * Controls if two shape have same center
     * @return true if two shape have same center, otherwise false
     */
    @Override
    public boolean equals( Object o ){
        Shape2D shape;
        if( o instanceof Shape2D){
            shape =(Shape2D) o;
            if(x == shape.x && y == shape.y )
                return true;
        }
        return false;
    }
}