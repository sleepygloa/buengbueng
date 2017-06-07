package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// 로그인 화면 띄우기
public class Main extends Application {
	private static Stage primaryStage = null;
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
		launch(args);
	}
}
