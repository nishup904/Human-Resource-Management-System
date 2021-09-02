package application;
import java.sql.ResultSet;

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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Update_Employee extends Application {
   static Stage stg8;
   String id,age,dat;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	Update_Employee(String eid)
	{
		this.id=eid;
	}
	
	public void start(Stage stage8) throws Exception {
	   	
		
            this.stg8= stage8;
            StackPane rootnode=new StackPane();
            HBox hbox1=new HBox();
            HBox hbox2=new HBox();
            HBox hbox3=new HBox();
            HBox hbox4=new HBox();
            HBox hbox5=new HBox();
            HBox hbox6=new HBox();
            HBox hbox7=new HBox();
            HBox hbox8=new HBox();
            HBox hbox9=new HBox();
            HBox hbox10=new HBox();
            VBox vbox=new VBox();
            vbox.setSpacing(30);
            Scene myscene4=new Scene(rootnode,950,500);
            stage8.setTitle("Update details");
            Image img=new Image("application/rkg.jpg");
            BackgroundImage bimg = new BackgroundImage(img, 
                    BackgroundRepeat.NO_REPEAT, 
                    BackgroundRepeat.NO_REPEAT, 
                    BackgroundPosition.DEFAULT, 
                       BackgroundSize.DEFAULT);
            Background bg = new Background(bimg);
            rootnode.setBackground(bg);
            
            
            Label l1=new Label("Update Employee Details");
            l1.setFont(Font.font("Time New Roman",FontWeight.BOLD,38));
            vbox.setMargin(l1,new Insets(10,0,0,250));
       
            Label l2=new Label("Name");
            hbox1.setMargin(l2, new Insets(0,0,0,50));
            l2.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
            
             t1=new TextField();
            t1.setPrefColumnCount(13);
            hbox1.setMargin(t1, new Insets(0,0,0,100));
            Label l3=new Label("Father's Name");
            hbox1.setMargin(l3, new Insets(0,0,0,230));
            l3.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
             t2=new TextField();
            t2.setPrefColumnCount(13);
            hbox1.setMargin(t2, new Insets(0,0,0,30));
            Label l4=new Label("Address");
            hbox2.setMargin(l4, new Insets(0,0,0,50));
            l4.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
             t3=new TextField();
            t3.setPrefColumnCount(13);
            hbox2.setMargin(t3, new Insets(0,0,0,80));
            Label l5=new Label("Mobile No");
            hbox2.setMargin(l5, new Insets(0,0,0,230));
            l5.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
             t4=new TextField();
            t4.setPrefColumnCount(13);
            hbox2.setMargin(t4, new Insets(0,0,0,70));
            Label l6=new Label("Email ID");
            hbox3.setMargin(l6, new Insets(0,0,0,50));
            l6.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
            t5=new TextField();
            t5.setPrefColumnCount(13);
            hbox3.setMargin(t5, new Insets(0,0,0,80));
            Label l7=new Label("Education");
            hbox3.setMargin(l7, new Insets(0,0,0,230));
            l7.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
             t6=new TextField();
            t6.setPrefColumnCount(13);
            hbox3.setMargin(t6, new Insets(0,0,0,70));
            Label l8=new Label("Job Post");
            hbox4.setMargin(l8, new Insets(0,0,0,50));
            l8.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
             t7=new TextField();
            t7.setPrefColumnCount(13);
            hbox4.setMargin(t7, new Insets(0,0,0,80));
            Label l9=new Label("Aadhar No");
            hbox4.setMargin(l9, new Insets(0,0,0,230));
            l9.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
             t8=new TextField();
            t8.setPrefColumnCount(13);
            hbox4.setMargin(t8, new Insets(0,0,0,60));
            Label l10=new Label("Employee ID");
            l10.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
            hbox5.setMargin(l10, new Insets(0,0,0,50));
             t9=new TextField();
            t9.setPrefColumnCount(13);
            hbox5.setMargin(t9, new Insets(0,0,0,40));
            Label l11 =new Label("Salary");
            l11.setFont(Font.font("Time New Roman",FontWeight.BOLD,20));
            hbox5.setMargin(l11, new Insets(0,0,0,230));
            t10=new TextField();
           t10.setPrefColumnCount(13);
           hbox5.setMargin(t10, new Insets(0,0,0,100));
            try {
            	
         
            Mysqlconn con=new Mysqlconn();
            String q="select * from Employee where Empid= '"+id+"'";
            
            
            ResultSet rs=con.s.executeQuery(q);
            if(rs.next())
            {
            t1.setText(rs.getString("Name"));
            t2.setText(rs.getString("Father_Name"));
            t3.setText(rs.getString("Address"));
            t4.setText(rs.getString("Phone"));
            t5.setText(rs.getString("Email"));
            t6.setText(rs.getString("Qualification"));
            t7.setText(rs.getString("JobPost"));
            t8.setText(rs.getString("Aadhar"));
            t9.setText(rs.getString("Empid"));
            t10.setText(rs.getString("Salary"));
            age=rs.getString("Age");
            dat=rs.getString("DOB");
            }
            }catch(Exception e)
            {
            	System.out.println();
            }
            Button b1=new Button("Update");
     
            		
              	b1.setOnAction(new EventHandler<ActionEvent>()
            		{
            	            public void handle(ActionEvent ae)
            	            {
            	            	 try {
            	                 	
            	                     
             Mysqlconn con=new Mysqlconn();
            String q= "update Employee set Name='"+t1.getText()+"',Father_Name='"+t2.getText()+"',Age='"+age+"',DOB='"+dat+"',Address='"+t3.getText()+"',Phone='"+t4.getText()+"',Email='"+t5.getText()+"',Qualification='"+t6.getText()+"',Jobpost='"+t7.getText()+"',Aadhar='"+t8.getText()+"',Empid='"+t9.getText()+"',Salary='"+t10.getText()+"' where Empid='"+id+"'";
            	                     con.s.executeUpdate(q);
            	                  Alert alert=new Alert(AlertType.INFORMATION);
            	                    alert.setContentText("Data Updated Successfully");
            	                    alert.showAndWait();
            	                    Update_Employee.stg8.close();
            	                    Details.stg3.show();
            	                 }catch(Exception e){
            	                     System.out.println("The error is:"+e);
            	                 }
            	            }
            		});
            	 
            	   
                                
            		
            		
            		
            hbox6.setMargin(b1, new Insets(0,0,0,260));
            b1.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:15");
            Button b2=new Button("Cancel");
            b2.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:15");
            b2.setOnAction(new EventHandler<ActionEvent>()
            		{
            	            public void handle(ActionEvent ae)
            	            {
            	            	Update_Employee.stg8.close();
            	            	Details.stg3.show();
            	            }
            		}
            		);
            hbox6.setMargin(b2, new Insets(0,0,0,160));
            
       hbox1.getChildren().addAll(l2,t1,l3,t2);
       hbox2.getChildren().addAll(l4,t3,l5,t4);
       hbox3.getChildren().addAll(l6,t5,l7,t6);
       hbox4.getChildren().addAll(l8,t7,l9,t8);
       hbox5.getChildren().addAll(l10,t9,l11,t10);
       hbox6.getChildren().addAll(b1,b2);
       vbox.getChildren().addAll(l1,hbox1,hbox2,hbox3,hbox4,hbox5,hbox6);
           rootnode.getChildren().addAll(vbox);
           
            stage8.setScene(myscene4);
            stage8.show();
	}

}
