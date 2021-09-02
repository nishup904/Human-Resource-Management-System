package application;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.text.Font;
public class FrontPage extends Application {
	static Stage stg;
	public void start(Stage mystage) throws Exception {
		this.stg = mystage;
		mystage.setTitle("Human Resource Management System");
		FlowPane rootnode=new FlowPane();
        Scene myscene=new Scene(rootnode,500,500);
       rootnode.setStyle("-fx-background-color:#78C0F0");
       mystage.setScene(myscene);
        Label mylabel=new Label("Human Resource Management");
        mylabel.setFont(new Font("Arial", 30));
        Image image=new Image("https://thumbs.dreamstime.com/z/human-resources-hr-management-recruitment-employment-headhunting-concept-137699310.jpg");
        ImageView imageview=new ImageView(image);
        imageview.setFitHeight(500); 
        imageview.setFitWidth(500); 
        imageview.setPreserveRatio(true);  
        Button bt1=new Button("Click here to login");
     //   bt1.setStyle ("-fx-background-color: cyan; ");
        bt1.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				 try {
					 Stage stage2=new Stage();
					login n= new login();
					n.start(stage2);
			        FrontPage.stg.close();
			        
			        }catch(Exception e) 
				           {
			               e.printStackTrace();		              
              }
			}
		});
        rootnode.setAlignment(Pos.CENTER);
        Group root = new Group(imageview);  
        rootnode.getChildren().addAll(mylabel,imageview,bt1);

        mystage.show();
       
	}

	public static void main(String[] args) {
		launch(args);
	}

}
