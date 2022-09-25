/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author WINDOWS 10
 * SUBSCRIBE OUR YOUTUBE CHANNEL -> https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 * THANKS FOR YOUR SUPPORT : ) 
 */
public class database {
    
    public static Connection connectDb(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/studentdata", "root", "");
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
}
