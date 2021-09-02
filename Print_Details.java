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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Print_Details extends Application {
   static Stage stg7;
   String eid;
   String name,fname,addr,pno,email,qual,post,age,dob,aadhar;
	Print_Details(String id)
	{
		this.eid=id;
	}
	@Override
	public void start(Stage stage7) throws Exception {
	   	
            this.stg7= stage7;
            stage7.setTitle("View Employee");
            StackPane rootnode=new StackPane();
            Scene myscene4=new Scene(rootnode,595,642);
            HBox hbox1=new HBox();
            
            HBox hbox2=new HBox();
            HBox hbox3=new HBox();
            HBox hbox4=new HBox();
            HBox hbox5=new HBox();
            HBox hbox6=new HBox();
            HBox hbox7=new HBox();
            HBox hbox8=new HBox();
            HBox hbox9=new HBox();
            VBox vbox=new VBox();
            hbox9.setSpacing(100);
            vbox.setSpacing(20);
            hbox1.setSpacing(65);
            hbox2.setSpacing(85);
            hbox3.setSpacing(57);
            hbox4.setSpacing(80);
            hbox5.setSpacing(71);
            hbox6.setSpacing(90);
            hbox7.setSpacing(70);
            hbox8.setSpacing(85);
            try
            {
            	Mysqlconn con=new Mysqlconn();
            	String q="select * from employee where empid='"+this.eid+"'";
            	ResultSet rs= con.s.executeQuery(q);
            	
            	while(rs.next())
            	{
            		name=rs.getString("Name");
            	    fname=rs.getString("Father_Name");
            	    age=rs.getString("age");
            	    dob=rs.getString("DOB");
            	    addr=rs.getString("Address");
            	    pno=rs.getString("Phone");
            	    email=rs.getString("Email");
            	    qual=rs.getString("Qualification");
            	    post= rs.getString("Jobpost");
            	    aadhar=rs.getString("Aadhar");
            	    eid=rs.getString("Empid");
            	}
            	
            	
            }catch(Exception ae)
            {
            	System.out.println("Error!!");
            }
            Image img=new Image("https://data.whicdn.com/images/159604780/original.jpg");
            BackgroundImage bimg=new BackgroundImage(img,
                    BackgroundRepeat.NO_REPEAT, 
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
Background bground=new Background(bimg);
rootnode.setBackground(bground);
Label l1=new Label("Employee Details");
l1.setFont(Font.font("Garamond",FontWeight.BOLD,40));
vbox.setMargin(l1,new Insets(30,0,20,150));
Label l2=new Label("Employee ID:  ");
l2.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
hbox1.setMargin(l2,new Insets(0,0,0,50));
Label l21=new Label(eid);
l21.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l3=new Label("Name:         ");
l3.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
hbox2.setMargin(l3,new Insets(0,0,0,50));
Label l31=new Label(name);
l31.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l4=new Label("Father's Name:");
hbox3.setMargin(l4,new Insets(0,0,0,50));
l4.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l41=new Label(fname);
l41.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l5=new Label("Address:      ");
l5.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
hbox4.setMargin(l5,new Insets(0,0,0,50));
Label l51=new Label(addr);
l51.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l6=new Label("Mobile No:    ");
l6.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
hbox5.setMargin(l6,new Insets(0,0,0,50));
Label l61=new Label(pno);
l61.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l7=new Label("Email ID:     ");
l7.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
hbox6.setMargin(l7,new Insets(0,0,0,50));
Label l71=new Label(email);
l71.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l8=new Label("Qualification: ");
l8.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
hbox7.setMargin(l8,new Insets(0,0,0,50));
Label l81=new Label(qual);
l81.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Label l9=new Label("Job Post:     ");
l9.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
hbox8.setMargin(l9,new Insets(0,0,0,50));
Label l91=new Label(post);
l91.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
Button b1=new Button("Print");
b1.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:15");
b1.setOnAction(new EventHandler<ActionEvent>()
{
        public void handle(ActionEvent ae)
        {
        	Alert errorAlert = new Alert(AlertType.INFORMATION);
			errorAlert.setHeaderText("Thank you!!");
			errorAlert.showAndWait();
			Details.stg3.show();
			Print_Details.stg7.close();
        }
}
);
Button b2=new Button("Cancel");
b2.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:15");
b2.setOnAction(new EventHandler<ActionEvent>()
		{
	            public void handle(ActionEvent ae)
	            {
	            	View_Employee.stg5.show();
	            	Print_Details.stg7.close();
	            }
		}
		);
hbox9.setMargin(b1,new Insets(10,0,0,140) );
hbox9.setMargin(b2,new Insets(10,0,0,0) );
hbox1.getChildren().addAll(l2,l21);
hbox2.getChildren().addAll(l3,l31);
hbox3.getChildren().addAll(l4,l41);
hbox4.getChildren().addAll(l5,l51);
hbox5.getChildren().addAll(l6,l61);
hbox6.getChildren().addAll(l7,l71);
hbox7.getChildren().addAll(l8,l81);
hbox8.getChildren().addAll(l9,l91);
hbox9.getChildren().addAll(b1,b2);
    vbox.getChildren().addAll(l1,hbox1,hbox2,hbox3,hbox4,hbox5,hbox6,hbox7,hbox8,hbox9);
    
            stage7.setScene(myscene4);
            rootnode.getChildren().add(vbox);
            stage7.show();
	}

}
