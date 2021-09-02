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

public class Search_Employee extends Application {

		static Stage stg7;
		@Override
		public void start(Stage stage7) throws Exception {
	            this.stg7= stage7;
	            stage7.setTitle("Search employee");
	            StackPane rootnode=new StackPane();
	            Scene myscene7=new Scene(rootnode,500,270);
	            HBox hbox1=new HBox();
	            HBox hbox2=new HBox();
	            hbox2.setSpacing(50);
	            VBox vbox=new VBox();
	           vbox.setSpacing(40);
	            Image img=new Image("application/Utilising-Data.jpg");
	            BackgroundImage bimg = new BackgroundImage(img, 
                        BackgroundRepeat.NO_REPEAT, 
                        BackgroundRepeat.NO_REPEAT, 
                        BackgroundPosition.DEFAULT, 
                           BackgroundSize.DEFAULT);
	            Background bg = new Background(bimg);
	            rootnode.setBackground(bg);
	            Label l1=new Label("Employee ID");
	            hbox1.setMargin(l1,new Insets(60,10,0,40));
	            l1.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
	            TextField t1=new TextField();
	            t1.setPrefColumnCount(13);
	            hbox1.setMargin(t1,new Insets(60,0,0,0));
	            Button search=new Button("Search");
	            search.setOnAction(new EventHandler<ActionEvent>()
	    		{
	            	
	    	             public void handle(ActionEvent ae)
	    	             {
	    	            	 
	    	            	 
	    	            	 Mysqlconn con=new Mysqlconn();
	    	            	 String q="select * from employee where Empid='"+t1.getText()+"'";
	    	     
							try {
								 ResultSet	rs = con.s.executeQuery(q);
							
								if (rs.next())
								 {
									 Stage newstage=new Stage();
									 Update_Employee pg=new Update_Employee(t1.getText());
									 try {
										pg.start(newstage);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 Search_Employee.stg7.close();
								 }
								else
								{
									Alert alert=new Alert(AlertType.ERROR);
									alert.setHeaderText("Employee with this id doesn't exist");
									alert.showAndWait();
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	            	
	    	             }
	    	             
	    		}
	    		);
	            search.setStyle("-fx-Background-color:#000000;-fx-text-fill:#ffffff;");
	            hbox2.setMargin(search,new Insets(0,10,0,120));
	            Button cancel=new Button("Cancel");
	            cancel.setStyle("-fx-Background-color:#000000;-fx-text-fill:#ffffff;");
	            cancel.setOnAction(new EventHandler<ActionEvent>()
	            		{
	            	             public void handle(ActionEvent ae)
	            	             {
	            	            	 Details.stg3.show();
	            	            	 Search_Employee.stg7.close();
	            	             }
	            	             
	            		}
	            		);
	            hbox1.getChildren().addAll(l1,t1);
	            hbox2.getChildren().addAll(search,cancel);
	            vbox.getChildren().addAll(hbox1,hbox2);
	            rootnode.getChildren().add(vbox);
	            stage7.setScene(myscene7);
	            stage7.show();
		}
	}


