package application;

import java.sql.ResultSet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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

public class ViewSalaries extends Application {

	static Stage stage10; 
	String id,name,basicpay,tax,sal;
	ViewSalaries(String eid)
	{
		this.id=eid;
	}
	
	@Override
	public void start(Stage mystage) throws Exception {
	 this.stage10=mystage;	
	  StackPane rootnode=new StackPane();
	  VBox vbox=new VBox();
	  HBox h1=new HBox();
	  HBox h2=new HBox();
	  HBox h3=new HBox();
	  HBox h4=new HBox();
	  
      Scene myscene9=new Scene(rootnode,500,500);
     
      mystage.setTitle("View Salary");
      Image img=new Image("https://th.bing.com/th/id/OIP.Xe4oINkz9q72AEW6zE_j5QHaE8?w=250&h=180&c=7&o=5&dpr=1.25&pid=1.7");
      BackgroundImage bimg = new BackgroundImage(img, 
              BackgroundRepeat.REPEAT, 
              BackgroundRepeat.REPEAT, 
              BackgroundPosition.DEFAULT, 
                 BackgroundSize.DEFAULT);
      Background bg = new Background(bimg);
      rootnode.setBackground(bg);
      
      try
	  {
		  Mysqlconn con=new  Mysqlconn();
		
			 
		   String r=" select e.name, b.basic_pay,b.tax_in_percentage,b.netsalary from employee e,salaries b where b.empid=e.empid and e.empid='"+id+"'";
	            	ResultSet rp= con.s.executeQuery(r);
	            	while(rp.next())
	            	{
	            		name=rp.getString("name");
	            		basicpay=rp.getString("basic_pay");
	            		tax=rp.getString("tax_in_percentage");
	            		sal=rp.getString("netsalary");
	            	   
	            	}
	            	
	            	
	  }catch(Exception e)
	  {
		  System.out.println("Error!!");
	  }

 
      
      
      Label l1=new Label("Employee Salary");
      l1.setFont(Font.font("Time New Roman",FontWeight.BOLD,38));
      vbox.setMargin(l1,new Insets(10,0,0,80));
      Label l2=new Label("Employee name-");
      l2.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h1.setMargin(l2,new Insets(50,0,0,30));
      
      
     
      Label l21=new Label(name);
      l21.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h1.setMargin(l21,new Insets(50,0,0,30));
      
      
      
      Label l3=new Label("Basic Salary-");
      l3.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h2.setMargin(l3,new Insets(15,0,0,30));
      
      Label l31=new Label(basicpay);
      l31.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h2.setMargin(l31,new Insets(15,0,0,30));
      
      
      Label l4=new Label("Income Tax-");
      l4.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h3.setMargin(l4,new Insets(15,0,0,30));
      
      
      Label l41=new Label("15%");
      l41.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h3.setMargin(l41,new Insets(15,0,0,30));
      
      Label l5=new Label("Net Salary-");
      l5.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h4.setMargin(l5,new Insets(15,0,0,30));
      
      
      Label l51=new Label(sal);
      l51.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
      h4.setMargin(l51,new Insets(15,0,0,30));
      
      
      Button b2=new Button("Cancel");
      b2.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:15");
      b2.setOnAction(new EventHandler<ActionEvent>()
      		{
      	            public void handle(ActionEvent ae)
      	            {

      		        	 ViewSalaries.stage10.close();
      		        	 Details.stg3.show();
      	            }
      		}
      		);
      vbox.setMargin(b2,new Insets(30,0,0,180) );
      
      
      
      
      h1.getChildren().addAll(l2,l21);
      h2.getChildren().addAll(l3,l31);
      h3.getChildren().addAll(l4,l41);
      h4.getChildren().addAll(l5,l51);
      
      vbox.getChildren().addAll(l1,h1,h2,h3,h4,b2);
      rootnode.getChildren().add(vbox);
      mystage.setScene(myscene9);
      mystage.show();
	}

}
