import java.util.Arrays;
/**This class represent a polynomial
 *@version 06.02.2021
 *@author Oguz_Kuyucu
 *
 */

import javax.lang.model.util.ElementScanner6; 
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
        int termOfPoly;
        if(coefficients.length != 0){
            for(termOfPoly = coefficients.length; termOfPoly > 0; termOfPoly--  ){
                if(coefficients[termOfPoly - 1] != 0)
                    return termOfPoly - 1;
            }
            //return coefficients.length - 1;
        }
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
    /**Adds two polynomial
     * @param poly2 is the polynomial which will be added to first polynomial
     * @return sum of two polynomials
     */
    public Polynomial add(Polynomial poly){
        Polynomial sum;
        int termSoFar;
        int lowDegree;
        int highDegree;
        double coefficientsOfSum[];
        lowDegree = Math.min(getDegree(), poly.getDegree());
        highDegree = Math.max(getDegree(), poly.getDegree());
        coefficientsOfSum = new double[highDegree + 1];
        for(termSoFar = 0; termSoFar <= lowDegree; termSoFar++){
            coefficientsOfSum[termSoFar] = coefficients[termSoFar] + poly.coefficients[termSoFar];
        }
        for(termSoFar = lowDegree + 1; termSoFar <= highDegree; termSoFar++){
            if(poly.getDegree() >= getDegree())
                coefficientsOfSum[termSoFar] = poly.coefficients[termSoFar];
            else
                coefficientsOfSum[termSoFar] = coefficients[termSoFar];
        }
        sum = new Polynomial(coefficientsOfSum);
        return sum;
    }
    /**Finds difference of two polynomial P(x) - Q(x)
     * @param poly is  Q(x)
     * @return difference of two polynomial
     */
    public Polynomial sub(Polynomial poly){
        Polynomial difference;
        int termSoFar;
        for(termSoFar = 0; termSoFar <= poly.getDegree(); termSoFar++){
            poly.coefficients[termSoFar] = - poly.coefficients[termSoFar];
        }
        difference = add(poly);
        for(termSoFar = 0; termSoFar <= poly.getDegree(); termSoFar++){
            poly.coefficients[termSoFar] = - poly.coefficients[termSoFar];
        }
        return difference;
    }
    /**Multiplies two polynomial P(x)Q(x)
     * @param poly is another polynomial Q(x)
     * @return multiplication of two polynomial
     */
    public Polynomial mul(Polynomial poly){
        Polynomial multiplication;
        double[] coefficientsOfMultiplication;
        int termsOfFirst;
        int termsOfSecond;
        coefficientsOfMultiplication = new double[getDegree() + poly.getDegree() + 1];
        for(termsOfFirst = 0; termsOfFirst <= getDegree(); termsOfFirst++ ){
            for(termsOfSecond = 0; termsOfSecond <= poly.getDegree(); termsOfSecond++){
                coefficientsOfMultiplication[termsOfFirst + termsOfSecond] = 
                coefficientsOfMultiplication[termsOfFirst + termsOfSecond] +
                 coefficients[termsOfFirst] * poly.coefficients[termsOfSecond];
            }
        }
        multiplication = new Polynomial(coefficientsOfMultiplication);
        return multiplication;
    }
    
    /**Composes two polynomial P(Q(x))
     * @param poly is polynomial inside which is Q(x)
     * @return composition of two polynomial
     */
    public Polynomial compose(Polynomial poly){
        //variables
        int termOfP;
        int termOfQ;
        int degreeOfTerm;
        Polynomial mono;
        Polynomial result;
        Polynomial terms;
        double[] coefficientsOfResult;
        double[] term;
        
        //method
        coefficientsOfResult = new double[getDegree() * poly.getDegree() + 1];
        term = new double[getDegree() + 1];
        coefficientsOfResult[0] = coefficients[0];
        result = new Polynomial(coefficientsOfResult);
        terms = new Polynomial(term);
        for(termOfP = 1; termOfP <= getDegree(); termOfP++){
            terms = poly;
            for(termOfQ = 2; termOfQ <= termOfP; termOfQ++ ){
                terms = poly.mul(poly);
            }
            for(degreeOfTerm = 0; degreeOfTerm <= terms.getDegree(); degreeOfTerm++){
                //terms.coefficients[degreeOfTerm] = terms.coefficients[degreeOfTerm] * getCoefficient(termOfP);
            }
            terms = terms.mul(mono = new Polynomial(0, getCoefficient(termOfP)));
            result = result.add(terms);
        }
        return result;
    }
    
    
    /**Detects largest nonzero degree term
     * @return largest degree term  
     */
    public Polynomial lead(){
        Polynomial largest;
        largest = new Polynomial(getDegree(), getCoefficient(getDegree()));
        return largest;
    }


    /**Divides two polynomial P(x)/Q(x)
     * @param poly is denominator, otherwords Q(x)
     * @return result of the division without remainder
     */
    public Polynomial divide4(Polynomial poly){
        Polynomial dividentOfleadings;
        Polynomial nominator;
        Polynomial multiplication;
        Polynomial result;
        double[] memory;
        if(getDegree() >= poly.getDegree()){
            memory = new double[getDegree() - poly.getDegree() + 1];
        }
        else{
            return null;
        }

        nominator = this;
        result = new Polynomial(memory);
        while(nominator.getDegree() >= poly.getDegree()){
            //divide two leading terms
            dividentOfleadings = new Polynomial(nominator.getDegree() - poly.getDegree(),
            nominator.getCoefficient(nominator.getDegree()) / poly.getCoefficient(poly.getDegree()));
            //multiply divident with Q(x) and subtract p(x)
            multiplication = poly.mul(dividentOfleadings);
            nominator = nominator.sub(multiplication);
            result = result.add(dividentOfleadings);
        }
        return result ;
    }
}   