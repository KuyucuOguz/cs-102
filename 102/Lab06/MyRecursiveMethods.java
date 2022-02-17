
import java.util.ArrayList;
public class MyRecursiveMethods{
    /**
     * Reverses a string
     * @param input is imput string that will be reversed
     * @return reversed string
     */
    public static String reverse(String input){
     
        if(input.length() == 0){
            return input;
        }
        else{
            return reverse(input.substring(1)) + input.charAt(0);
        }
    }
	/**
     * Removes r from an input string
     * @param input is an input whose r's will be removed
     * @return string whose r's removed
     */
    public static String removeR(String input){
        int length = input.length();
        if(length == 0){
            return input;
        }
        else{
            while(input.charAt(0) == 'r'){
                return removeR(input.substring(1));
            }
        }
        return input.charAt(0) + removeR(input.substring(1, input.length()));
    }
    /**
     * Controls if the number enumarates and even
     * @param number will be controlled
     * @return true if number enumarates and even, otherwise false
     */
    private static boolean enumataresAndEven(String number){
        if(Integer.valueOf(number) % 2 == 1){
            return false;
        }
        if(number.length() == 1){
            return true;
        }
        else if(Character.getNumericValue(number.charAt(0)) < Character.getNumericValue(number.charAt(1)) ){
            return enumataresAndEven(number.substring(1, number.length()));
        }
        else{
            return false;
        }
    }
    
   /**
    * Converts decomal number to hexadecimal number
    * @param number is decimal number which will be converted to hexadecimal number
    * @return hexadecimal number
    */
   public static String decimalToHexa(int number){
        char characters[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexa;
        hexa = "";
        int input;
        input = number;
        String result;
        if(input < 0){
            input = -1 * number;
        }
        if(input < 16){
            return hexa + Character.toString(characters[input]);
        }
        else{
            hexa = characters[input % 16] + hexa;
            input = input / 16;
            result = decimalToHexa(input) + hexa;
        }
        if(number < 0){
            return "-" + result;
        }
        return result;
    }
    /**
     * Controls if the Strings are loxicogropic
     * @param strings is arraylist that will be controlled
     * @return true if strings are loxigropic, otherwise false
     */
    public static boolean controller(ArrayList<String> strings){
        if(strings.size() == 0 || strings.size() == 1 ){
            return true;
        }
        else{
            if(strings.get(0).compareTo(strings.get(1)) > 0){
                return false;
            }
            else{
                strings.remove(0);
                return controller(strings);
            }
        }
    }
    /**
     * Prints numbers that enumarates and even 
     * @param digit is number's digit
     */
    private static void generateAndPrintDigits(int digit, int current){
        int end = (int) Math.pow(10, digit );
        if(current >= end){
            current = current + 1;
        }
        else{
            if(enumataresAndEven(String.valueOf(current))){
                    System.out.println(current);
            }
            current = current + 1;
            generateAndPrintDigits(digit, current);
        }  
    }
    public static void generateAndPrintDigits2(int digit){
        int start =(int) Math.pow(10, digit - 1);
        generateAndPrintDigits(digit, start);
    }
}   