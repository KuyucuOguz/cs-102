import java.io.File;
import java.sql.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class History{
    String name;
    public History(String userName){
        try{
            name = textReader();
        }
        catch(FileNotFoundException e){
            System.out.println("1");
        }
        name = userName;
    }
    public String getActivity(String date, String user) {
        try{
            String s;
            s = "";
            Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connect=DriverManager.getConnection(  
            "jdbc:mysql://34.69.74.87:3306/" + user ,"root","20210406cp");  
            //here sonoo is database name, root is username and password  
            Statement statement=connect.createStatement();  
            ResultSet resultset=statement.executeQuery("select * from activity where date = " + "'" + date + "'") ;
            while(resultset.next()){
                s = s  +  resultset.getString("time") + "    " + resultset.getString("activityName") + "          " + 
                resultset.getString("duration") + "minute          -" + resultset.getString("calorie") + "kcal       \n";
            }
            connect.close();
            return s;
        } 
        catch(Exception e){ 
            System.out.println(e);
            return null;
        } 
    }
    public String getWater(String date, String user) {
        try{
            String s;
            s = "";
            Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connect=DriverManager.getConnection(  
            "jdbc:mysql://34.69.74.87:3306/" + user ,"root","20210406cp");  
            //here sonoo is database name, root is username and password  
            Statement statement=connect.createStatement();  
            ResultSet resultset=statement.executeQuery("select * from water where date = " + "'" + date + "'") ;
            while(resultset.next()){
                s = s + resultset.getString("time") + "  Water"  + "           " + 
                resultset.getString("amount") + "ml            0" + "\n";
            }
            connect.close();
            return s;
        } 
        catch(Exception e){ 
            System.out.println(e);
            return null;
        }
    }
    public String getFoods(String date, String user) {
        try{
            String s;
            s = "";
            Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connect=DriverManager.getConnection(  
            "jdbc:mysql://34.69.74.87:3306/" + user ,"root","20210406cp");  
            //here sonoo is database name, root is username and password  
            Statement statement=connect.createStatement();  
            ResultSet resultset=statement.executeQuery("select * from food where date = " + "'" + date + "'") ;
            while(resultset.next()){
                s = s + resultset.getString("time") + "  " + resultset.getString("foodname") + "              " + 
                resultset.getString("grams") + "gr               " + resultset.getString("calorie") + "kcal \n";
            }
            connect.close();
            return s;
        } 
        catch(Exception e){ 
            System.out.println(e);
            return null;
        } 
    }
    public static String textReader() throws FileNotFoundException
    {
        File file = new File( "filename.txt" );
        Scanner scan = new Scanner( file );
        String name = scan.next();
        //String userPassword = scan.next();
        scan.close();
        return name;
    } 
    public static void main(String[] args){
        History history = new History("asim123");
        System.out.println(history.getActivity("02/05/2021", "asim123"));
        System.out.println(history.getWater(EnergyTracker.todayString, "asim123"));
        System.out.println(history.getFoods(EnergyTracker.todayString, "asim123"));
    }
}