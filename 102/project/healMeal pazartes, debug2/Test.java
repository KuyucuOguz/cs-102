
import java.sql.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Test {
    static String name = "asim";
    static String userPassword = "154";
    public static String getHeight()
    {
    String height ="";    
    try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://34.69.74.87:3306/userdemo";
            String username = "root";
            String password = "20210406cp";
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection( url, username, password );
            Statement statement = conn.createStatement();
            String sql = "SELECT height FROM user WHERE username = '" + name + "'  and password = '" + userPassword + "'";
            ResultSet r = statement.executeQuery(sql);
            
            while( r.next() )
            {
                height = r.getString( "height" );
            }
        } catch( Exception e ) { e.printStackTrace(); }
        
        return height;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println(getHeight());
        File file = new File( "filename.txt" );
        Scanner scan = new Scanner( file );
        String name = scan.next();
        String userPassword = scan.next();
        System.out.println( name + userPassword);
        scan.close();
    }
    
    
}
