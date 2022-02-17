import java.util.Arrays;
/**Tests polynomial class
 *@version 06.02.2021
 *@author Oguz_Kuyucu
 *
 */ 
public class PolynomialTest {
    public static void main(String[]args){
        //constants
        final double[] COEFFICIENTS = {3,4,1,3,0,2};
        final double[] COEFFICIENTS_TWO  = {2,1};
        
        //variables
        Polynomial poly;
        Polynomial polyTwo;
        Polynomial polyThree;
        Polynomial polyFour;
        
        //program code

        poly = new Polynomial(COEFFICIENTS);
        polyTwo = new Polynomial(2, 5);
        polyThree = new Polynomial();
        polyFour = new Polynomial(COEFFICIENTS_TWO);

        //1. test toString method
        System.out.println(poly.toString());
        System.out.println();
        System.out.println(polyTwo.toString());
        System.out.println();
        System.out.println(polyThree.toString());
        System.out.println();
        
        //2. test eval methods
        System.out.println(poly.eval(2));
        System.out.println(poly.eval2(2));
        System.out.println();

        System.out.println(polyThree.eval(5));
        System.out.println(polyThree.eval2(5));
        System.out.println();
        
        System.out.println(polyTwo.eval(5));
        System.out.println(polyTwo.eval2(5));
        System.out.println();

        System.out.println(polyFour.eval(7));
        System.out.println(polyFour.eval2(7));
        System.out.println();

        //3. test getCoEfficient method
        System.out.println(poly.getCoefficient(4));
        System.out.println();

        System.out.println(polyTwo.getCoefficient(2));
        System.out.println();

        System.out.println(polyThree.getCoefficient(0));
        System.out.println();

        System.out.println(polyFour.getCoefficient(0));

        //4. test getdegree method
        System.out.println(" s");
        System.out.println(polyTwo.getDegree());
        System.out.println(polyThree.getDegree());
        System.out.println(poly.getDegree());
        System.out.println(polyFour.getDegree());
        System.out.println();

        //5. test sum method
        System.out.println(poly.add(polyFour));
        System.out.println(poly.sub(polyFour));

        //6. test mul method
        System.out.println(polyFour.mul(poly));
        System.out.println(poly.compose(polyFour)); 
        System.out.println(poly.divide4(polyFour));
    }
}
