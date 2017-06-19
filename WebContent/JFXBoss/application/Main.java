package application;
	
import application.controller.order.RentOrder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// 濡쒓렇�씤 �솕硫� �쓣�슦湲�
public class Main extends Application {
	private static Stage primaryStage = null;
	static Thread idx = new Thread(new RentOrder());
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		try {
			BorderPane root = new BorderPane();
			Parent login = FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
			root.setCenter(login);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage(){
		return primaryStage;
	}
	
	public static void main(String[] args) {
		idx.start();
		launch(args);
	}
}
