
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Visualization.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Crowd Master");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(getCurrentGraphicsPipeline());
		
	}
	@SuppressWarnings("restriction")	//checking hardware acceleration
	static String getCurrentGraphicsPipeline() {
	    return com.sun.prism.GraphicsPipeline.getPipeline().getClass().getName();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
