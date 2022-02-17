import java.util.Arrays;
public class ShapeTest{
    public static void main(String[]args){
        //constants

        //variables
        Shape2D[] list;
        Shape2D circle;
        Circle circle2;
        Square square;
        Rectangle rectangle;
        Rectangle rectangle2;
        Square square2;
        //program code
        list = new Shape2D[3];
        circle = new Circle(5, 3, 1);
        square = new Square(1, 0, 4);
        rectangle = new Rectangle(5, 0, 8, 1);
        rectangle2 = new Rectangle(5, 0, 8, 1);
        circle2 = new Circle(5, 3, 4);
        square2 = new Square();

        list[0] = circle;
        list[1] = square;
        list[2] = rectangle;
        //1. test area and perimeter methods
        System.out.println(circle.calculateArea() + " is area of circle");
        System.out.println(circle.calculatePerimeter() + " is perimeter of circle");
        System.out.println(square.calculateArea() + " is area of square");
        System.out.println(square.calculatePerimeter() + " is perimeter of square");
        System.out.println(rectangle.calculateArea() + " is area of rectangle");
        System.out.println(rectangle.calculatePerimeter() + "is perimeter of rectangle");
        System.out.println();

        //2. find shapes that has largest area and perimeter
        System.out.println(findLargestArea(list) + " has the largest area");
        System.out.println(findLongestPerimeter(list) + " has the largest perimeter");
        System.out.println();

        //3. toString methods
        System.out.println("circle = " + circle);
        System.out.println("circle2 = " + circle2);
        System.out.println("square = " + square);
        System.out.println("rectangle1 = " + rectangle);
        System.out.println("rectangle2 = " + rectangle2);
        System.out.println("square2 = " + square2);
        System.out.println();

        System.out.println("circle1 and circle two are equals is " + circle.equals(circle2));
        System.out.println("rectangle1 and rectangle2 are equal is " + rectangle2.equals(rectangle));
        System.out.println("circle1 and rectangle1 are equal is " + circle.equals(rectangle));
        System.out.println();

        //4. distance method
        System.out.println("distance between square and circle is: " + square.calculateDistance(circle) );
        System.out.println("distance between square and rectangle is: " + square.calculateDistance(rectangle));
        System.out.print("the shape array: ");
        printArray(list);
        System.out.println();
        calculateDistance(list);
    }
    
    /**Detects shape which has largest area
     * @param list is list of shapes
     * @return shape with largest area
     */
    public static Shape2D findLargestArea(Shape2D[] list){
        Shape2D largest;
        largest = list[0];
        for(int elementSoFar = 0; elementSoFar < list.length; elementSoFar++){
            if(list[elementSoFar].calculateArea() > largest.calculateArea())
                largest = list[elementSoFar];
        }
        return largest;
    }
    
    /**Detects shape which has longest perimeter
     * @param list is list of shapes
     * @return shape with largest perimeter
     */
    public static Shape2D findLongestPerimeter(Shape2D[] list){
        Shape2D largest;
        largest = list[0];
        for(int elementSoFar = 0; elementSoFar < list.length; elementSoFar++){
            if(list[elementSoFar].calculatePerimeter() > largest.calculatePerimeter())
                largest = list[elementSoFar];
        }
        return largest;
    }
    /**
     * Prints arrays elements with sequence
     * @param list is an arraylist which will be printed
     */
    public static void printArray(Shape2D[] list){
        for(int elementSoFar = 0; elementSoFar < list.length; elementSoFar++){
            System.out.print(list[elementSoFar] + " ");
        }
    }
    /**
     * Calculates distance between centers of the shapes in the list
     * @param list is an arraylist which contains 2D shapes
     */
    public static void calculateDistance(Shape2D[] list){
        int otherObject;
        for(int objectSoFar = 0; objectSoFar < list.length; objectSoFar++){
            for(otherObject = objectSoFar; otherObject < list.length; otherObject++){
                if(otherObject != objectSoFar){
                    System.out.println("distance between shape " + objectSoFar + " and " + otherObject + 
                    " is " + list[objectSoFar].calculateDistance(list[otherObject]));
                }
            }

        }
    }
}