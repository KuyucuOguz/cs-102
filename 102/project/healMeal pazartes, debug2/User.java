

import java.sql.*;

/**
 * @author Aysema Kasap
 */

public class User {
    // properties
    public String name;
    public String userPassword;
    private String gender;
    public double height;
    private double weight;
    public String email;
    public double calorieNeed;
    private int age;
    public boolean cheatDay;
    public String goal;
    
    // constructor for login user
    public User( String n )
    {
        
        name = n;
        
        //connection constants
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://34.69.74.87:3306/userdemo";
        final String username = "root";
        final String password = "20210406cp";
        
        try
        {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection( url, username, password );
            
            Statement statement2 = ((java.sql.Connection) conn).createStatement(); 
            String sql2 = "SELECT height FROM user WHERE username = '" +  name + "'";
            ResultSet resultset1 = statement2.executeQuery(sql2);
            
            while(  resultset1.next() )
            {
                height = Double.parseDouble( resultset1.getString("height"));
            }
            
            Statement statement3 = ((java.sql.Connection) conn).createStatement(); 
            String sql3 = "SELECT weight FROM user WHERE username = '" +  name + "'";
            ResultSet resultset2 = statement3.executeQuery(sql3);
            
            while(  resultset2.next() )
            {
                weight = Double.parseDouble(resultset2.getString("weight"));
            }
            
            Statement statement4 = ((java.sql.Connection) conn).createStatement(); 
            String sql4 = "SELECT age FROM user WHERE username = '" + name + "'";
            ResultSet resultset3 = statement4.executeQuery(sql4);
            
            while( resultset3.next() )
            {
                age = Integer.parseInt(resultset3.getString("age"));
            }
            
            Statement statement5 = ((java.sql.Connection) conn).createStatement(); 
            String sql5 = "SELECT gender FROM user WHERE username = '" + name  + "'";
            ResultSet resultset4 = statement5.executeQuery(sql5);
            
            while( resultset4.next() )
            {
                gender = resultset4.getString("gender");
            }
            
            Statement statement6 = ((java.sql.Connection) conn).createStatement(); 
            String sql6 = "SELECT goal FROM user WHERE username = '" + name + "'";
            ResultSet resultset6 = statement6.executeQuery(sql6);
            
            while( resultset6.next() )
            {
                goal = resultset6.getString("goal");
            }
            
            Statement statement7 = ((java.sql.Connection) conn).createStatement(); 
            String sql7 = "SELECT password FROM user WHERE username = '" +  name + "'";
            ResultSet resultset7 = statement7.executeQuery(sql7);
            
            while(  resultset7.next() )
            {
                userPassword = resultset7.getString("password");
            }
        }
        
        catch(SQLException e ) { e.printStackTrace();} catch (ClassNotFoundException e) { e.printStackTrace(); }
    }


    public double calculateBMI() {
        return height / ( weight * weight);
    }


    public double calculateCalorieNeed() {

        if( gender.equalsIgnoreCase( "female" ) ) 
        {
            if( goal.equals("Maintain weight") )
            {
                return 387 - ( 7.31 * age ) + ( 14.2 * weight + ( 503 * ( height / 100 ) ) );
            }
            
            else if( goal.equals("Lose weight") )
            {
                return 387 - ( 7.31 * age ) + ( 14.2 * weight + ( 503 * ( height / 100 ) ) ) - 300;
            }
            else
            {
                return 387 - ( 7.31 * age ) + ( 14.2 * weight + ( 503 * ( height / 100 ) ) ) + 300;
            }
        }
        else 
        {
            if( goal.equals( "Maintain weight" ) )
            {
                return 864 - ( 9.72 * age ) + ( 14.2 * weight + ( 503 * ( height / 100 ) ) );
            }
            
            else if( goal.equals( "Lose weight" ) )
            {
                return 864 - ( 9.72 * age ) + ( 14.2 * weight + ( 503 * ( height / 100 ) ) ) - 300;
            }
            else
            {
                return 864 - ( 9.72 * age ) + ( 14.2 * weight + ( 503 * ( height / 100 ) ) ) + 300;
            }
        }
    }
    
    public String getUsername()
    {
        return this.name;
    }
    
    public String getPassword()
    {
        return this.userPassword;
    }
    
    public double getCalorieNeed()
    {
        return this.calorieNeed;
    }
    
}