import java.util.ArrayList;
public class RecursionTest{
    public static void main(String[] args){
        System.out.println(MyRecursiveMethods.reverse("123457 12"));
        System.out.println();
        System.out.println(MyRecursiveMethods.removeR("rrryou arre generrrousrrr nrrrr"));
        System.out.println();

        MyRecursiveMethods.generateAndPrintDigits2(3);
        System.out.println(MyRecursiveMethods.decimalToHexa((-100)));
        
        System.out.println();
        ArrayList<String> array = new ArrayList<String>();
        array.add("Adana");
        array.add("Bursa");
        array.add("Denizli");
        array.add("Urfa");
        array.add("Urfa");
        //array.add("Bolu");
        System.out.println(MyRecursiveMethods.controller(array));
    }
}

