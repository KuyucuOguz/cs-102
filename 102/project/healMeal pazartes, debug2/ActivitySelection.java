import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
public class ActivitySelection{
    //properties
    //ArrayList<Activity> mostPopular;
    ArrayList<Activity> indoors;
    ArrayList<Activity> outdoors;
    //ArrayList<Activity> outdoors;
    //ArrayList<Activity> house;
    ArrayList<Activity> sport;
    //ArrayList<Activity> others;
    Activity ActivitySelected;
    //constructors
    public ActivitySelection(){
        indoors = getActivityFromSQL("indoor");
        outdoors = getActivityFromSQL("outdoor");
       //sport = getActivityFromSQL("sports");
        ActivitySelected = null;
    }

    //methods

    public Activity selectActivity(ArrayList<Activity> list, int index){
        return list.get(index);
    }       
    public void logActivity(String user,String date,String name, double minutes, String type, String time ){//String will be changed to user (maybe)
        try{
            double totalCalorie = 0;
            java.sql.Connection connect2=DriverManager.getConnection(  
            "jdbc:mysql://34.69.74.87:3306/activity", "root", "20210406cp");
            if(type.equals("cardio")){
                Statement statement3=((java.sql.Connection) connect2).createStatement();  
                ResultSet resultset=statement3.executeQuery("select calorie from indoor where indoorName = '" + name + "'");
                while(resultset.next()){
                    totalCalorie = totalCalorie + resultset.getDouble(1);
                }  
            }
            else if(type.equals("sports")){
                Statement statement4=((java.sql.Connection) connect2).createStatement();  
                ResultSet resultset=statement4.executeQuery("select calorie from outdoor where outdoorName = '" + name + "'");
                while(resultset.next()){
                    totalCalorie = totalCalorie + resultset.getDouble(1);
                }
            }
            //Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connect=DriverManager.getConnection(  
            "jdbc:mysql://34.69.74.87:3306/"+ user, "root", "20210406cp");
            PreparedStatement statement = connect.prepareStatement("insert into activity values (?, ?, ?, ?, ?)");
            statement.setString(1, date);
            statement.setString(2,time);
            statement.setDouble(3, minutes);
            statement.setString(4, name);
            statement.setDouble(5, totalCalorie * minutes / 10);
            statement.executeUpdate();
            
            PreparedStatement statement2 = connect.prepareStatement("insert into energytracker values (?, ?, ?, ?)");
            statement2.setString(1, date);
            statement2.setString(2, time);
            statement2.setDouble(3, 0.0);
            statement2.setDouble(4, totalCalorie * minutes / 10);
            statement2.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }  
    }
    public ArrayList<Activity> getActivityFromSQL(String name){
        try{

            Activity act; 
            ArrayList<Activity> list = new ArrayList<Activity>();
            //Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connect=DriverManager.getConnection(  
            "jdbc:mysql://34.69.74.87:3306/activity", "root", "20210406cp");  
            //here sonoo is database name, root is username and password  
            Statement statement=((java.sql.Connection) connect).createStatement();  
            ResultSet resultset=statement.executeQuery("select * from " + name);  
            while(resultset.next()){
                act = new Activity(resultset.getString(1), resultset.getDouble(2));
                list.add(act);
            }
            connect.close(); 
            return list; 
        }catch(Exception e){ 
            System.out.println(e);
            return null;
        }
          
    }
    public String[] getCardio(){
        int size = indoors.size();
        String names[] = new String[size + 1];
        names[0] = "indoors";
        for(int elementSoFar = 1; elementSoFar <= size; elementSoFar++){
            names[elementSoFar] = indoors.get(elementSoFar - 1).getName(); 
        }
        return names;
    }
    public String[] getSports(){
        int size = outdoors.size();
        String names[] = new String[size + 1];
        names[0] = "outdoors";
        for(int elementSoFar = 1; elementSoFar <= size; elementSoFar++){
            names[elementSoFar] = outdoors.get(elementSoFar - 1).getName(); 
        }
        return names;
    }
    public static void main(String[] args) {
        ActivitySelection act = new ActivitySelection();
        System.out.println(act.getActivityFromSQL("sports"));
        System.out.println(act.getActivityFromSQL("cardio"));
        System.out.println(act.getActivityFromSQL("machines"));
        //act.logActivity("user"," 01.01.2021", "Basketball", 60);
        //act.logActivity("user","01/05/2021" , "f", 40, "sports");
        
    }   
}
//  Connection connect = DriverManager.getConnection("jdbc:mysql://34.69.74.87:3306/test", "root", "20210406cp");