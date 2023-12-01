package Sudoku.controller;

import java.awt.Toolkit;
import java.util.ArrayList;

import Sudoku.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainAppController {

	private MainApp mainApp;

	@FXML
	private HBox topHBox;

	@FXML
	private Label überschrift;
	
	  ArrayList<int[][]> boards = new ArrayList<>(); // Create an ArrayList object
	
		private int counter=0;
	  
	@FXML
	private void initialize() {

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	/**
	 * setzt alle Informationen die Angezeigt werden sollen (Raumbeschreibung,
	 * Infotext, Spieler-Lebenspunkte und Lebensanzeige, Bild der Mapp für die
	 * Räume, Bild des Raums
	 */
	public void startwerteSetzen() {

		AnchorPane.setTopAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.031);
		AnchorPane.setBottomAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85);

		überschrift.setFont(Font.font("System", FontWeight.BOLD,
		Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.04));
		


	}

}
