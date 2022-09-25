/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author WINDOWS 10
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginBtn;

    @FXML
    private Button close;
    
//    DATABASE TOOls
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
//    NOW LETS CREATE OUR DATABASE : ) 
    
    private double x= 0 ;
    private double y= 0;
    
    public void loginAdmin(){
        
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        
        connect = database.connectDb();
        
        try{ // IT WORKS GOOD : ) NOW LETS DESIGN THE DASHBOARD FORM : ) 
            Alert alert;
            
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();
//            CHECK IF FIELDS ARE EMPTTY
            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next()){
//                    THEN PROCEED TO DASHBOARD FORM

                    getData.username = username.getText();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();
                    
//                    TO HIDE THE LOGIN FORM
                    loginBtn.getScene().getWindow().hide();
                    //LINK YOUR DASHBOARD 
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
                    
                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    // THEN ERROR MESSAGE WILL APPEAR
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void close(){
        System.exit(0);
    }
    
    //LETS NAME THE COMPONENTS ON LOGIN FORM : )
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
