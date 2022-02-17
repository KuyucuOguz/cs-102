import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;
import java.text.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
public class EnergyTracker{
    //properties
    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public final static Instant today = Instant.now();
    public final static Instant oneDayAgo = today.minus(1, ChronoUnit.DAYS);
    public final static Instant twoDayAgo = today.minus(2, ChronoUnit.DAYS);
    public final static Instant threeDayAgo = today.minus(3, ChronoUnit.DAYS);
    public final static Instant fourDayAgo = today.minus(4, ChronoUnit.DAYS);
    public final static Instant fiveDayAgo = today.minus(5, ChronoUnit.DAYS);
    public final static Instant sixDayAgo = today.minus(6, ChronoUnit.DAYS);
    public final static String todayString = dateFormat.format(Date.from(today));
    public final static String oneString = dateFormat.format(Date.from(oneDayAgo));
    public final static String twoString = dateFormat.format(Date.from(twoDayAgo));
    public final static String threeString = dateFormat.format(Date.from(threeDayAgo));
    public final static String fourString = dateFormat.format(Date.from(fourDayAgo));
    public final static String fiveString = dateFormat.format(Date.from(fiveDayAgo));
    public final static String sixString = dateFormat.format(Date.from(sixDayAgo));
    
    double consumptionToday;
    double consumption1; 
    double consumption2;
    double consumption3;
    double consumption4;
    double consumption5;
    double consumption6;
    double intakeToday;
    double intake1;
    double intake2;
    double intake3;
    double intake4;
    double intake5;
    double intake6;
    String userName2 = "1";
    

    public EnergyTracker(String user){
        try{
            userName2 = textReader();
        }
        catch(FileNotFoundException e){
            System.out.println("1");
        }
        
        consumptionToday= getConsumption(todayString, userName2 );
        consumption1 = getConsumption(oneString, userName2);
        consumption2 = getConsumption(twoString, userName2);
        consumption3 = getConsumption(threeString, userName2);
        consumption4 = getConsumption(fourString, userName2);
        consumption5 = getConsumption(fiveString, userName2);
        consumption6 = getConsumption(sixString, userName2);
        intakeToday = getIntake(todayString, userName2);
        intake1 = getIntake(oneString, userName2);
        intake2 = getIntake(twoString, userName2);
        intake3 = getIntake(threeString, userName2);
        intake4 = getIntake(fourString, userName2);
        intake5 = getIntake(fiveString, userName2);
        intake6 = getIntake(sixString, userName2);
    }
    //methods
    public double getConsumption(String date, String user) {
        try{
            double consumption;
            consumption = 0;
            //Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connect=DriverManager.getConnection(
            "jdbc:mysql://34.69.74.87:3306/"+ user, "root", "20210406cp"  );  
            //here sonoo is database name, root is username and password  
            Statement statement=connect.createStatement();  
            ResultSet resultset=statement.executeQuery("select consumption from energytracker where date = " + "'" + date + "'" ) ;
            while(resultset.next()){
                consumption = consumption + (resultset.getDouble(1));
            }
            connect.close();
            return consumption;  
        } 
        catch(Exception e){ 
            System.out.println(e);
            return 0;
        }  
    }
    public double getIntake(String date, String user) {
        try{
            double intake;
            intake = 0;
            //Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connect=DriverManager.getConnection(  
            "jdbc:mysql://34.69.74.87:3306/"+ user, "root", "20210406cp");  
            //here sonoo is database name, root is username and password  
            Statement statement=connect.createStatement();  
            ResultSet resultset=statement.executeQuery("select intake from energytracker where date = " + "'" + date + "'") ;
            while(resultset.next()){
                intake = intake + (resultset.getDouble(1));
            }
            connect.close();
            return intake;  
        } 
        catch(Exception e){ 
            System.out.println(e);
            return 0;
        }  
    }
    public double getConsumption1() {
        return consumption1 + 1370;
    }
    public double getConsumption2() {
        return consumption2 + 1370;
    }
    public double getConsumption3() {
        return consumption3 + 1370;
    }
    public double getConsumption4() {
        return consumption4 + 1370;
    }
    public double getConsumption5() {
        return consumption5 + 1370;
    }
    public double getConsumption6() {
        return consumption6 + 1370 ;
    }
    public double getConsumptionToday() {
        return consumptionToday;
    }
    public double getIntake1() {
        return intake1;
    }
    public double getIntake2() {
        return intake2;
    }
    public double getIntake3() {
        return intake3;
    }
    public double getIntake4() {
        return intake4;
    }
    public double getIntake5() {
        return intake5;
    }
    public double getIntake6() {
        return intake6;
    }
    public double getIntakeToday() {
        return intakeToday;
    }
    public static void main (String[] args){
        //EnergyTracker track = new EnergyTracker(userName2);
        //System.out.println(track.getConsumption2());
        //System.out.println(track.getIntake2());
        //EnergyTracker track2 = new EnergyTracker("user2");
        //System.out.println(track2.getIntake1());
        System.out.println(oneString);
        System.out.println(Instant.now());
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
}
