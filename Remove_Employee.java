package application;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Remove_Employee extends Application {
    static Stage stg6;
    String name,mail,pno; 
   
	@Override
	public void start(Stage stage6) throws Exception {
	   	
            this.stg6= stage6;
            
            StackPane rootnode=new StackPane();
            Scene myscene4=new Scene(rootnode,500,500);
            stage6.setScene(myscene4);
            HBox hbox1=new HBox();
            HBox hbox2=new HBox();
            HBox hbox3=new HBox();
            HBox hbox4=new HBox();
            HBox hbox5=new HBox();
            HBox hbox6=new HBox();
            VBox vbox=new VBox();
            VBox vbox1=new VBox();
            VBox vbox2=new VBox();
            Image img=new Image("https://thumbs.dreamstime.com/b/template-text-virtual-screen-background-icons-business-internet-technology-networking-concept-template-text-122092964.jpg");
             BackgroundImage bimg=new BackgroundImage(img,
            		                   BackgroundRepeat.NO_REPEAT,
            		                   BackgroundRepeat.NO_REPEAT,
            		                   BackgroundPosition.DEFAULT,
            		                   BackgroundSize.DEFAULT);
                Background bg=new Background(bimg);                        
             rootnode.setBackground(bg);
             Label l1=new Label("Employee ID");
             l1.setFont(Font.font("New Roman Times",FontWeight.BOLD,20));
             hbox1.setMargin(l1,new Insets(50,0,0,50));
             TextField t1=new TextField();
             t1.setPrefColumnCount(12);
             hbox1.setMargin(t1,new Insets(50,0,0,20));
             Button b1=new Button("Search");
             hbox2.setMargin(b1,new Insets(30,0,0,200));
             b1.setOnAction(new EventHandler<ActionEvent>()
            		 {
            	        public void handle(ActionEvent ae)
            	        {
            	        	Mysqlconn con =new Mysqlconn();
            	        	String id=t1.getText();
            	        	String q="Select name,Email,Phone from employee where empid='"+id+"'";
            	        	try {
								ResultSet rs=con.s.executeQuery(q);
								if(rs.next())
								{

									
										name=rs.getString("Name");
										mail=rs.getString("Email");
										pno=rs.getString("Phone");
									
									Label l2=new Label("Name:      ");
						             l2.setFont(Font.font("New Roman Times",FontWeight.BOLD,20));
						             hbox3.setMargin(l2,new Insets(200,0,0,60));
						             Label l21=new Label(name);
						             l21.setFont(Font.font("New Roman Times",FontWeight.BOLD,20));
						             hbox3.setMargin(l21,new Insets(200,0,0,50));
						             Label l3=new Label("Email Id:  ");
						             l3.setFont(Font.font("New Roman Times",FontWeight.BOLD,20));
						               hbox4.setMargin(l3,new Insets(20,0,0,50));
						             Label l31=new Label(mail);
						             l31.setFont(Font.font("New Roman Times",FontWeight.BOLD,20));
						             hbox4.setMargin(l31,new Insets(20,0,0,60));
						             Label l4=new Label("Mobile no: ");
						             l4.setFont(Font.font("New Roman Times",FontWeight.BOLD,20));
						             hbox5.setMargin(l4,new Insets(20,0,0,50));
						             Label l41=new Label(pno);
						             l41.setFont(Font.font("New Roman Times",FontWeight.BOLD,20));
						             hbox5.setMargin(l41,new Insets(20,0,0,60));
						             Button b3=new Button("Remove");
						             b3.setOnAction(new EventHandler<ActionEvent>()
						            		 {
						            	            public void handle(ActionEvent ae)
						            	            {     Mysqlconn con1 =new Mysqlconn();
						            	            
						          
						              String str = "delete from employee where Empid = '"+t1.getText()+"'";
						            	                 try {
															con1.s.executeUpdate(str);
															Alert alert=new Alert(AlertType.INFORMATION);
															alert.setHeaderText("Data removed succesfully!!");
															alert.showAndWait();
															Details.stg3.show();
							            	            	 Remove_Employee.stg6.close();
														} catch (SQLException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
						            	            }
						            	 
						            		 });
						             
						             hbox6.setMargin(b3,new Insets(20,0,0,50));
						             Button b4=new Button("Cancel");
						             b4.setOnAction(new EventHandler<ActionEvent>()
				            		 {
			            	             public void handle(ActionEvent ae)
			            	             {
			            	            	 Details.stg3.show();
			            	            	 Remove_Employee.stg6.close();
			            	             }
			            		 }
			            		 );
						             hbox6.setMargin(b4,new Insets(20,0,0,100));
						             hbox3.getChildren().addAll(l2,l21);
						             hbox4.getChildren().addAll(l3,l31);
						             hbox5.getChildren().addAll(l4,l41);
						             hbox6.getChildren().addAll(b3,b4);
						             vbox1.getChildren().addAll(hbox3,hbox4,hbox5,hbox6);
						             rootnode.getChildren().add(vbox1);
						             stage6.show();
								}
								else
								{
									Alert alert=new Alert(AlertType.ERROR);
									alert.setHeaderText("There is no employee with"+t1.getText()+" employee id!!");
									alert.showAndWait();
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
            	        }
            		 }
            		 );
             Button b2=new Button("Back");
             hbox2.setMargin(b2,new Insets(30,0,0,70));
             b2.setOnAction(new EventHandler<ActionEvent>()
            		 {
            	             public void handle(ActionEvent ae)
            	             {
            	            	 Details.stg3.show();
            	            	 Remove_Employee.stg6.close();
            	             }
            		 }
            		 );
             
             hbox1.getChildren().addAll(l1,t1);
             hbox2.getChildren().addAll(b1,b2);
            vbox.getChildren().addAll(hbox1,hbox2);
             rootnode.getChildren().add(vbox);
           
            stage6.show();
	}

}
