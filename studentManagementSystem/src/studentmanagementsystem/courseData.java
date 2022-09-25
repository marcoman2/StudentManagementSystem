/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

/**
 *
 * @author WINDOWS 10
 * SUBSCRIBE OUR YOUTUBE CHANNEL -> https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 * THANKS FOR YOUR SUPPORT : ) 
 */
public class courseData {
    
    private String course;
    private String description;
    private String degree;
    
    public courseData(String course, String description, String degree){
        this.course = course;
        this.description = description;
        this.degree = degree;
    }
    public String getCourse(){
        return course;
    }
    public String getDescription(){
        return description;
    }
    public String getDegree(){
        return degree;
    }
    
}
