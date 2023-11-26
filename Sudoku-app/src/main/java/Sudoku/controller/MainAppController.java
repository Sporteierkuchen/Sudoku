package Sudoku.controller;

import java.awt.Toolkit;
import java.util.ArrayList;

import Sudoku.MainApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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

		AnchorPane.setTopAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.025);
		AnchorPane.setBottomAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85);

		überschrift.setFont(Font.font("System", FontWeight.BOLD,
		Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.04));
		


	}

}
