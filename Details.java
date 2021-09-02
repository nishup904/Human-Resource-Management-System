package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class Details extends Application {
   static Stage stg3;
	@Override
	public void start(Stage stage3) throws Exception {
		this.stg3=stage3;
		stage3.setTitle("Details");
       StackPane rootnode3=new StackPane();
       HBox hbox1=new HBox();
       hbox1.setSpacing(10);
       HBox hbox2=new HBox();
       hbox2.setSpacing(10);
       HBox hbox3=new HBox();
       VBox vbox=new VBox();
       vbox.setSpacing(20);
       FlowPane node=new FlowPane();
       Scene myscene3=new Scene(rootnode3,700,500);
       Image image = new Image("application/details.jpg");
       
       // create a background image
       BackgroundImage backgroundimage = new BackgroundImage(image, 
                                        BackgroundRepeat.NO_REPEAT, 
                                        BackgroundRepeat.NO_REPEAT, 
                                        BackgroundPosition.DEFAULT, 
                                           BackgroundSize.DEFAULT);

       // create Background
       Background background = new Background(backgroundimage);

       // set background
       rootnode3.setBackground(background);
       Label l1=new Label("Employee Details");
       l1.setFont(Font.font("serif",FontWeight.BOLD,28)); 
       vbox.setMargin(l1,new Insets(20,0,0,400));
       Button add=new Button("Add");
       add.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:20");
       add.setOnAction(new EventHandler<ActionEvent>()
    		   {
    		   public void handle(ActionEvent ae)
    		   {
    	           try
    	           {
    	        	   Stage stage4=new Stage();
    	        	   Add_Employee e=new Add_Employee();
    	        	   e.start(stage4);
    	        	   Details.stg3.close();
    	           }catch(Exception e)
    	           {
    	        	   e.printStackTrace();
    	           }
    		   }
    		   });
      hbox1.setMargin(add, new Insets (0, 0, 0,440));
       Button view=new Button("View");
       view.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:20");
       view.setOnAction(new EventHandler<ActionEvent>()
	   {
	   public void handle(ActionEvent ae)
	   {
           try
           {
        	   Stage stage5=new Stage();
        	  View_Employee e=new View_Employee();
        	   e.start(stage5);
        	   Details.stg3.close();
           }catch(Exception e)
           {
        	   e.printStackTrace();
           }
	   }
	   });
       Button remove=new Button("Remove"); 
      hbox2.setMargin(remove, new Insets (0, 0, 0,440));
      remove.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:20");
      remove.setOnAction(new EventHandler<ActionEvent>()
	   {
	   public void handle(ActionEvent ae)
	   {
          try
          {
       	   Stage stage6=new Stage();
       	  Remove_Employee e=new Remove_Employee();
       	   e.start(stage6);
       	   Details.stg3.close();
          }catch(Exception e)
          {
       	   e.printStackTrace();
          }
	   }
	   });
       Button update=new Button("Update");
       update.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:20");
       update.setOnAction(new EventHandler<ActionEvent>()
	   {
	   public void handle(ActionEvent ae)
	   {
           try
           {
        	   Stage stage7=new Stage();
        	  Search_Employee e=new Search_Employee();
        	   e.start(stage7);
        	   Details.stg3.close();
           }catch(Exception e)
           {
        	   e.printStackTrace();
           }
	   }
	   });
       Button vs=new Button("View Salary");
       hbox3.setMargin(vs, new Insets (0, 0, 0,440));
       vs.setStyle ("-fx-background-color: #000000;-fx-text-fill:#ffffff;-fx-font-size:20");
       vs.setOnAction(new EventHandler<ActionEvent>()
    		   {
    		   public void handle(ActionEvent ae)
    		   {
    	           try
    	           {
    	        	   Stage stage8=new Stage();
    	        	   SearchEmployeeForSalary e=new  SearchEmployeeForSalary();
    	        	   e.start(stage8);
    	        	   Details.stg3.close();
    	           }catch(Exception e)
    	           {
    	        	   e.printStackTrace();
    	           }
    		   }
    		   });
      
       hbox1.getChildren().addAll(add,view);
       hbox2.getChildren().addAll(remove,update);
       hbox3.getChildren().addAll(vs);
       vbox.getChildren().addAll(l1,hbox1,hbox2,hbox3);
       rootnode3.getChildren().add(vbox);
       stage3.setScene(myscene3);
       stage3.show();
	}
}
