package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class login extends Application {
	static Stage stg2;
	@Override
	public void start(Stage stage2) throws Exception {
		this.stg2=stage2;
		stage2.setTitle("Login");
		HBox hroot1=new HBox(20);
		HBox hroot2=new HBox(20);
        
        Label username=new Label("Username");
        username.setFont(Font.font("Time New Roman",FontWeight.BOLD,12));
        hroot1.setMargin(username, new Insets (30, 0, 0,40));
        TextField tf = new TextField();
              tf.setPrefColumnCount(15);
              hroot1.setMargin(tf, new Insets (30, 0, 0,40));
          Label password=new Label("Password");
          password.setFont(Font.font("Time New Roman",FontWeight.BOLD,12)); 
          hroot1.setMargin(password, new Insets (40, 0, 0,40));
          PasswordField pf = new PasswordField();
          pf.setPrefColumnCount(15);
          hroot1.setMargin(pf, new Insets (40, 0, 0,40));
           Image img=new Image("application/login.jpg");
           ImageView imgv=new ImageView(img);
        Button logins=new Button("Login");
        logins.setOnAction(new EventHandler<ActionEvent>()
        		{
        	          public void handle(ActionEvent ae)
        	          { try {
        	        	  Mysqlconn c1=new Mysqlconn();
        	        	 String name= tf.getText();
        	        	 String pass=pf.getText();
        	        	 String q="Select * from login where username='"+name+"' and password='"+pass+"'";
						 ResultSet rs=c1.s.executeQuery(q);
							
						if(rs.next())
						{
							try
							{
								Stage stage3=new Stage();
								Details n2=new Details();
								n2.start(stage3);
						        login.stg2.close();
							}	
					 
					        catch (Exception e) 
							{
					        	e.printStackTrace();
					        }
		     			}
						else
						  {
							Alert errorAlert = new Alert(AlertType.ERROR);
							errorAlert.setHeaderText("Invalid Login!!");
							errorAlert.setContentText("Try again");
							errorAlert.showAndWait();
						   }
        	          }
        	          catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
        		}
        		
        		});
        Button cancel=new Button("Cancel");
        cancel.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				FrontPage.stg.show();
				login.stg2.close();
			
			}
		});
        logins.setStyle ("-fx-background-color: #000000;-fx-text-fill:#FFFFFF ");
        hroot1.getChildren().addAll(username,tf);
        cancel.setStyle ("-fx-background-color: #000000;-fx-text-fill:#FFFFFF ");
        hroot2.getChildren().addAll(password,pf);
        VBox vroot=new VBox(hroot1,hroot2);
        vroot.setSpacing(20);
        HBox hroot3=new HBox(vroot,imgv);
        vroot.setSpacing(20);
        HBox hroot4=new HBox(logins,cancel);
        hroot4.setSpacing(28);
        hroot4.setMargin(logins, new Insets (0, 0, 0,40));
        VBox vroot2=new VBox(hroot3,hroot4);
        vroot.setSpacing(18);
        
        Scene myscene=new Scene(vroot2,600,300);
        stage2.setScene(myscene);
        stage2.show();
	}
}
