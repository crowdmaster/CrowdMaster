package pl.edu.agh.crowdmaster.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller implements Initializable {

	@FXML
	private ImageView image;
	@FXML
	private Pane pane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		image.fitWidthProperty().bind(pane.widthProperty()); 
		image.fitHeightProperty().bind(pane.heightProperty()); 
	}

	public void runSimulation(ActionEvent event) {
		System.out.println("run");
		SimulationTestEngine test = new SimulationTestEngine(image);
		new Thread(test).start();	//running simple simulation
	}
	
	public void stopSimulation(ActionEvent event) {
		System.out.println("stop");
	}
	
	public void click(MouseEvent event) {
		System.out.println("click in " + event.getY() + " " + event.getY());
		Circle circle = new Circle(event.getX(), event.getY(), 10); 
		pane.getChildren().add(circle);		//temporary
	}
	
	public void edit(ActionEvent event) {}
	public void open(ActionEvent event) {}
	public void save(ActionEvent event) {}
	public void generate(ActionEvent event) {}

}

class SimulationTestEngine implements Runnable 
{	//simple simulation engine which paint gradient

	WritableImage writableImage;
	PixelWriter pixelWriter;
	ImageView im;
	public SimulationTestEngine(ImageView im)
	{
		this.im = im;
	}
	@Override
	public void run() {
		for (int z = 0; z < 255; z += 1)
		{
			writableImage = new WritableImage(1024, 1024);
			pixelWriter = writableImage.getPixelWriter();
			for (int i = 0; i < 1024; i++)
				for (int j = 0; j < 1024; j++)
					pixelWriter.setColor(i, j, Color.rgb(i/4, j/4, z));
			im.setImage(writableImage);
		}
		System.out.println("done");
		
	}
	
}
