package Sudoku.controller;


import java.awt.Toolkit;

import Sudoku.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MainAppController {

	private MainApp mainApp;

	

	@FXML
	private Text raumbeschreibung;

	@FXML
	private Text infos;
	
	@FXML
	private Label hpanzeige;
	
	@FXML
	private ProgressBar hpAnzeige;
	
	@FXML
	private Label schildanzeige;
	
	@FXML
	private ProgressBar schildAnzeige;
	
	@FXML
	private ProgressBar gegnerHpAnzeige;
	
	@FXML
	private ComboBox<String> itemsimraum;
	
	@FXML
	private Text inventarLeer;
	
	@FXML
	private ImageView mapImage;
	
	@FXML
	private ImageView roomImage;
	
	@FXML
	private ImageView gegnerGif;
	
	@FXML
	private ImageView truheImage;
	
	@FXML
	private ImageView hebelImage;
	
	@FXML
	private HBox buttonbereich;
	
	@FXML
	private MenuBar menubar;
	
	@FXML
	private AnchorPane steuerungsbereich;
	
	@FXML
	private Tab inventar;
	
	@FXML
	private HBox topHBox;

	@FXML
	private HBox mainHBox;

	@FXML
	private HBox bottomHBox;

	@FXML
	private GridPane gridpane;

	@FXML
	private void initialize() {




	}
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		

	}	
	
	
    /**
     * setzt alle Informationen die Angezeigt werden sollen (Raumbeschreibung, Infotext, Spieler-Lebenspunkte und Lebensanzeige, Bild der Mapp für die Räume, Bild des Raums
     */
	public void startwerteSetzen() {
		
		AnchorPane.setTopAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.03);
		AnchorPane.setBottomAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8);

		AnchorPane.setTopAnchor(mainHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.176);
		AnchorPane.setBottomAnchor(mainHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.175);

		AnchorPane.setTopAnchor(bottomHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8);
		AnchorPane.setBottomAnchor(bottomHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0);

		this.gridpane.setMaxHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);
		this.gridpane.setMaxWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);

//		HBox h = new HBox();
//
//		h.setStyle("-fx-background-color: goldenrod;");
//		this.gridpane.add(h, 0, 0);
	}
	

	
	


}
