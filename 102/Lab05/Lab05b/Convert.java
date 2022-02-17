import javax.swing.JLabel;
import javax.swing.JTextField;
import java.lang.Integer;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
public class Convert extends JFrame implements ActionListener{
    public static void main(String[] args) { 
      
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Convert frame = new Convert();
                frame.setVisible(true);
            
            }
        });
    }
    //properties
    private JTextField binary;
    private JTextField decim;
    private JTextField hexadec;
    /**
     *Creates Converter
     */
    //Constructors
    public Convert(){
        setTitle( "Welcome to Number Converter");
		setBounds( 300, 250, 300, 70);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout( new GridLayout(3, 3));

		container.add( new JLabel("Decimal"));
		decim = new JTextField(10);
		decim.addActionListener(this);
		container.add(decim);

		container.add( new JLabel("Hex"));
		hexadec = new JTextField(10);
		hexadec.addActionListener(this);
        container.add(hexadec);
        
        container.add( new JLabel("Binary") );
		binary = new JTextField(10);
		binary.addActionListener(this);
		container.add(binary);

		setVisible(true);
    }
    //Methods

    //Action performed method
    public void actionPerformed(ActionEvent e){
        //if it is binary, calculate hexadecimal and decimal
        if(e.getSource() == binary){
            String binar= binary.getText();
            decim.setText(String.valueOf(binarytoDecimal(binar)));
            hexadec.setText(binaryToHex(binar));
        }
        //if the source is hexadecimal, calculate decimal and binary
        else if(e.getSource() == hexadec){
            String hexadecimal=hexadec.getText();
            String decimal = String.valueOf(hexToDecimal(hexadecimal));
            decim.setText(decimal);
            binary.setText(hexToBinary(hexadecimal));
        }
        //if the source is decimal, calculate hexadecimal and binary
        else if(e.getSource() == decim){
            int decimal = Integer.valueOf(decim.getText());
            hexadec.setText(String.valueOf(Integer.toHexString(decimal)));
            binary.setText(Integer.toBinaryString(decimal));    
        }
    }
    /**
     * Converts hexadecimal to decima
     * @param hex is hexadecimal number in  String form
     * @return decimal number in int form
     */
    private int hexToDecimal(String hex){
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int value = 0;
        for(int characterSoFar = 0; characterSoFar < hex.length(); characterSoFar++ ){
            char character = hex.charAt(characterSoFar);
            int temporary = digits.indexOf(character);
            value = 16 * value + temporary;
        }
        return value;
    }
    private String hexToBinary(String hex){
        int decimal = hexToDecimal(hex);
        String binary = toBinary(decimal);
        return binary;
    }
    /**
     *Reverses string.
     * @param input will be reversed
     * @return the result
     */
    public String reverse(String input){
        int length;
        int letterSoFar;
        char character;
        String reversed;
        reversed = "";
        length = input.length();
        
        for(letterSoFar = length - 1 ; letterSoFar >= 0 ; letterSoFar--){    
            character = input.charAt(letterSoFar);
            reversed = reversed + character;   
        }
        
        return reversed;
    }
    /**
     * Transforms base 2 numbers to base 10 numbers
     * @param base2 is number in two base
     * @return ten based result
     */
    public int binarytoDecimal( String binary ){
        int length;
        int scanningDigit;
        char numberSoFar;
        int result;
        
        length = binary.length();
        scanningDigit = 0;
        result = 0;
        binary = reverse(binary);
        while(scanningDigit <= length - 1){
            numberSoFar = binary.charAt(scanningDigit);
            
            if(numberSoFar == '1' ){
                result = result +(int) Math.pow(2,scanningDigit);
            }
            scanningDigit = scanningDigit + 1;
        }    
        
        return result;
    }
    /**
     * Converst binary to hexadecimal
     * @param binary will be converted to hexadecimal
     * @return hexadecimal value of binary 
     */
    public String binaryToHex(String binary){
        int decimal = binarytoDecimal(binary);
        String hex = Integer.toHexString(decimal);
        return hex;
    }
    /**
     * Converts decimal to binary
     * @param decimal will be converted to binary
     * @return string
     */
    public String toBinary(int decimal){
        String result;
        result ="";
        while(decimal > 1){ 
            result = result + String.valueOf(decimal % 2);
            decimal = decimal / 2;
        }
        if(decimal == 1)
            result = result + "1";
        result =reverse(result);

        return result; 
    }   
}