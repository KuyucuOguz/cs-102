import java.util.Arrays;
/**This class represent a polynomial
 *@version 06.02.2021
 *@author Oguz_Kuyucu
 *
 */ 
public class Polynomial{
    //properties
    private double[] coefficients;

    //constructors
    
    /**Creates zero polynomial
     * 
     */
    public Polynomial() {
        coefficients = new double[0];
    }

    /**Creates polynomial with one term
     *@param power is power of the term
     *@param coefficient is coefficient of the term
     */
    public Polynomial(int power, double coefficient) {
        coefficients = new double[power + 1];
        coefficients[power] = coefficient;
    } 
    /**Creates polynomial with more than one term
     *@param coefficients are coefficients of terms with sequence  
     */
    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    //methods

    /** Gets the coefficient of the term with the degree in polynomial
     * @param power is the power whose coefficient will be looked for
     * @return coefficient of spesific term
     */
    public double getCoefficient(int power){
        if(coefficients.length > power)
        {
            return coefficients[power];
        }
        else
            return 0;
        
    }

    /**Gets the degree of polynomial
     * @return degree of polynomial
     */ 
    public int getDegree(){
        if(coefficients.length != 0)
            return coefficients.length - 1;
        else
            return 0;
    }

    /**Converts polynomial to String
     *@return String representation of polynomial
     */
    public String toString(){
        String polynomial;
        int termSoFar;
        int termNumber;
        termNumber = 0;
        polynomial = "";
        for(termSoFar = 0; termSoFar < coefficients.length; termSoFar++){
            if(coefficients[termSoFar] != 0){
                if(termSoFar == 0)
                    polynomial = polynomial + coefficients[termSoFar];
                else if(termNumber == 0)
                    polynomial = polynomial + coefficients[termSoFar] + "x^" + termSoFar;
                else if(coefficients[termSoFar] > 0)
                    polynomial = polynomial + " + " + coefficients[termSoFar] + "x^" + termSoFar; 
                else
                    polynomial = polynomial + " - " + Math.abs(coefficients[termSoFar]) + "x^" + termSoFar; 
                termNumber = termNumber + 1;
            }
        }
        if(polynomial.equals(""))
            polynomial = "0";
        return polynomial;
    }

    /**Evaluates polynomial for given value
     * @param value will be evaluated for polynomial
     * @return evaluated value
     */
    public double eval(double value){
        double result;
        result = 0;
        int termSoFar;
        for(termSoFar = 0; termSoFar < coefficients.length; termSoFar++){
            result = result + coefficients[termSoFar] * Math.pow(value, termSoFar);
        }
        return result;
    }

    /**
     * Evaluates polynomial for given value by Horner's method
     * @param value will be evaluated for polynomial
     * @return evaluated value
     */
    public double eval2(double value){
        double result;
        int TermSoFar;
        result = 0;
        if(coefficients.length == 0)
            return result;
        else if(coefficients.length > 1)
        {
            result = coefficients[coefficients.length - 1] * value;
            for(TermSoFar = coefficients.length - 1; TermSoFar >= 2; TermSoFar--){
                result =(result + coefficients[TermSoFar - 1]) * value;
            }
            return result + coefficients[0];
        }
        return result + coefficients[0];
    }
}