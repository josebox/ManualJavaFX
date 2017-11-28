package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controlador implements Initializable {

	@FXML
	private AnchorPane manual, introduccion, manejo, iconos;
	@FXML
	private AnchorPane inPanel1,inPanel2S;
	@FXML
	private JFXButton btnIntroduccion, btnManejo, btnIconos, btnHome,atras2;

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		translateAnimation(0.5, introduccion, 600);
		translateAnimation(0.5, manejo, 600);
		translateAnimation(0.5, iconos, 600);

		btnIntroduccion.setOnMouseClicked(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), introduccion);
			translateTransition1.setByX(-600);
			translateTransition1.play();

		});

		btnManejo.setOnMouseClicked(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), manejo);
			translateTransition1.setByX(-600);
			translateTransition1.play();

		});

		btnIconos.setOnMouseClicked(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), iconos);
			translateTransition1.setByX(-600);
			translateTransition1.play();

		});

		btnHome.setOnMouseClicked(event -> {
			translateAnimation(0.5, iconos, +600);
			translateAnimation(0.5, manejo, +600);
			translateAnimation(0.5, introduccion, +600);
			

		});
		
		atras2.setOnMouseClicked(event -> {
			translateAnimation(0.5, manejo, +600);
			translateAnimation(0.5, manejo, +600);
			

		});
		
	
	}

	
	int showSlide = 0;

	@FXML
	void nextAction(ActionEvent event) {

		if (showSlide == 0) {
			translateAnimation(0.5, inPanel1, -600);
			showSlide++; // showSlide=1
			
		} else if (showSlide == 1) {

			translateAnimation(0.5, inPanel2S, -600);
			showSlide++; // showSlide=2
			

		} else {
			System.out.println("No more slides");
		}

	}
	

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");
		} else if (showSlide == 1) {
			translateAnimation(0.5, inPanel1, 600);
			showSlide--; // showSlide=0
			
		} else if (showSlide == 2) {
			translateAnimation(0.5, inPanel2S, 600);
			showSlide--; // showSlide=1
			
		}

	}

}
